package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.*;
import com.vaas.vaasbackend.repository.UsersRepository;
import com.vaas.vaasbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userEmail = jwtRequest.getUserEmail();
        String password = jwtRequest.getPassword();

        authenticate(userEmail, password);

        UserDetails userDetails = loadUserByUsername(userEmail);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        TblUser tblUser = usersRepository.findByUserEmail(userEmail).get();
        return new JwtResponse(tblUser, newGeneratedToken);

    }


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        TblUser tblUser = usersRepository.findByUserEmail(userEmail).get();

        if (tblUser != null) {
            return new org.springframework.security.core.userdetails.User(
                    tblUser.getUserEmail(),
                    tblUser.getPassword(),
                    getAuthorities(tblUser)

            );
        } else {
            throw new UsernameNotFoundException("useremail is not valid" + userEmail);
        }
    }

    private Set getAuthorities(TblUser tblUser) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        List<String> Roles = usersRepository.getRole(tblUser.getId());
        for(String Role : Roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + Role));
        }
        return authorities;
    }


    private void authenticate(String userEmail, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEmail, password));
        } catch (DisabledException e) {
            throw new Exception("user is disabled", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credentials from user", e);
        }
    }

}
