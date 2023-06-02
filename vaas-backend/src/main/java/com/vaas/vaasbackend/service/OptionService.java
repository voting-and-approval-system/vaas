package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    public void deleteOption(Integer id) throws DataNotFoundException {
        try {
            optionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DataNotFoundException("No Option Found With Id " + id);
        }
    }


    public List<TblOption> showOptionByIssueId(Integer id) throws DataNotFoundException {
        try {
            List<TblOption> options = optionRepository.findByIssueId(id);
            if (options.isEmpty()) {
                throw new DataNotFoundException("No Option Found For Given Issue");
            }
            return options;
        } catch (EmptyResultDataAccessException e) {
            throw new DataNotFoundException("No Issue Found For Id " + id);
        }
    }


    public TblOption showOption(Integer id) throws DataNotFoundException {
        Optional<TblOption> option = optionRepository.findById(id);
        if (!option.isPresent()) {
            throw new DataNotFoundException("No Option Found For Id " + id);
        }
        return option.get();
    }

    public TblOption updateOption(Integer id, TblOption option) throws Exception {
        Optional<TblOption> option1 = optionRepository.findById(id);
        if (!option1.isPresent()) {
            throw new DataNotFoundException("Option Not Found For Id " + id);
        }
        TblOption tblOption = option1.get();
        if (Objects.nonNull(option.getOptionTitle()) &&
                !"".equalsIgnoreCase(option.getOptionTitle())) {
            tblOption.setOptionTitle(option.getOptionTitle());
        }

        tblOption.setOptionDescription(option.getOptionDescription());

        if (Objects.nonNull(option.getOptionAttachmentPath()) &&
                !"".equalsIgnoreCase(option.getOptionAttachmentPath())) {
            tblOption.setOptionAttachmentPath(option.getOptionAttachmentPath());
        }


        if (Objects.nonNull(option.getIssue()) &&
                !"".equalsIgnoreCase(option.getIssue().toString())) {
            tblOption.setIssue(option.getIssue());
        }

        if (Objects.nonNull(option.getOptionIsActive()) &&
                !"".equalsIgnoreCase(option.getOptionIsActive().toString())) {
            tblOption.setOptionIsActive(option.getOptionIsActive());
        }

        try {
            return optionRepository.save(tblOption);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
