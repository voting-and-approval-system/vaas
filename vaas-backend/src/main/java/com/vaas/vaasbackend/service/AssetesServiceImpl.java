package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAssete;
import com.vaas.vaasbackend.repository.AssetesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetesServiceImpl implements AssetesService{
    @Autowired
    AssetesRepository assetesRepository;

    @Override
    public List<TblAssete> ShowAssetes() {
        return assetesRepository.findAll();
    }

    @Override
    public TblAssete SaveAssetes(TblAssete assete) {
        return assetesRepository.save(assete);
    }
}
