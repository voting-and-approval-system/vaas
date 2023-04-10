package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public List<TblOption> showOption() throws DataNotFoundException {
        List<TblOption> options = optionRepository.findAll();
        if (options.isEmpty()) {
            throw new DataNotFoundException("No Options Found");
        }
        return options;
    }


    public TblOption saveOption(TblOption option) throws Exception {
        try {
            return optionRepository.save(option);
        }catch (Exception e){
            throw new Exception(e);
        }
    }


    public void deleteOption(Integer id) throws DataNotFoundException {
        try {
            optionRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new DataNotFoundException("No Option Found With Id " + id);
        }
    }


    public List<TblOption> showOptionByIssueId(Integer id) throws DataNotFoundException {
        try {
            List<TblOption> options = optionRepository.findByIssueId(id);
            if(options.isEmpty()){
                throw new DataNotFoundException("No Option Found For Given Issue");
            }
            return options;
        }catch (EmptyResultDataAccessException e){
            throw new DataNotFoundException("No Issue Found For Id " + id);
        }
    }


    public TblOption showOption(Integer id) throws DataNotFoundException {
        Optional<TblOption> option = optionRepository.findById(id);
        if(!option.isPresent()){
            throw new DataNotFoundException("No Option Found For Id " + id);
        }
        return option.get();
    }
}
