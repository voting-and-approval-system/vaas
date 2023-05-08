package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.*;
import com.vaas.vaasbackend.repository.UsersRepository;
import com.vaas.vaasbackend.repository.UsersRoleRepository;
import com.vaas.vaasbackend.responseBody.JwtRequest;
import com.vaas.vaasbackend.responseBody.JwtResponse;
import com.vaas.vaasbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
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
    UsersRoleRepository usersRoleRepository;

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userEmail = jwtRequest.getUserEmail();
        UserDetails userDetails = loadUserByUsername(userEmail);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        TblUser tblUser = usersRepository.findByUserEmail(userEmail).get();
        List<String> roles = usersRoleRepository.findUserRoleByEmail(userEmail);
        return new JwtResponse(tblUser,roles,newGeneratedToken);

    }


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        TblUser tblUser = usersRepository.findByUserEmail(userEmail).get();

        if (tblUser != null) {
            return new org.springframework.security.core.userdetails.User(
                    tblUser.getUserEmail(),
                    "",
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
}
