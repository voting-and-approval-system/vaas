package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService{
    @Autowired
    private OptionRepository optionRepository;
    @Override
    public List<TblOption> ShowOption() {
        return optionRepository.findAll();
    }

    @Override
    public TblOption SaveOption(TblOption option) {
        return optionRepository.save(option);
    }

    @Override
    public void DeleteOption(Integer id) {
        optionRepository.deleteById(id);
    }
}
