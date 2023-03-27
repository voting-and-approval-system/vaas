package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAssete;
import com.vaas.vaasbackend.repository.AssetesRepository;
import com.vaas.vaasbackend.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetesServiceImpl implements AssetesService{
    @Autowired
    AssetesRepository assetesRepository;
    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<TblAssete> ShowAssetes() {
        return assetesRepository.findAll();
    }

    @Override
    public TblAssete ShowAssetes(Integer id) {
        return assetesRepository.findById(id).get();
    }

    @Override
    public TblAssete SaveAssetes(TblAssete assete) {
        return assetesRepository.save(assete);
    }

    @Override
    public void DeleteAssetes(Integer id) {
        assetesRepository.deleteById(id);
    }
}
