package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public List<TblOption> showOption() {
        return optionRepository.findAll();
    }


    public TblOption saveOption(TblOption option) {
        return optionRepository.save(option);
    }


    public void deleteOption(Integer id) {
        optionRepository.deleteById(id);
    }


    public List<TblOption> showOptionByIssueId(Integer id) {
        return optionRepository.findByIssueId(id);
    }


    public TblOption showOption(Integer id) {
        return optionRepository.findById(id).get();
    }
}
