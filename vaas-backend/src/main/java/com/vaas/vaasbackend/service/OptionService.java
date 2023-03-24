package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblOption;

import java.util.List;

public interface OptionService {
    public List<TblOption> ShowOption();

    public TblOption SaveOption(TblOption option);

    public void DeleteOption(Integer id);

    public List<TblOption> ShowOptionByIssueId(Integer id);

    public TblOption ShowOption(Integer id);
}
