package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.tbl_assetes;
import com.vaas.vaasbackend.repository.AssetesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetesServiceImpl implements AssetesService {

    @Autowired
    private AssetesRepository assetesRepository;
    @Override
    public List<tbl_assetes> fetchAssetes() {
        return assetesRepository.findAll();
    }
}
