package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAsset;
import com.vaas.vaasbackend.errors.AssetesNotFoundException;
import com.vaas.vaasbackend.repository.AssetsRepository;
import com.vaas.vaasbackend.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetsService {
    @Autowired
    AssetsRepository assetsRepository;
    @Autowired
    private IssueRepository issueRepository;

    public List<TblAsset> showAssets() {
        return assetsRepository.findAll();
    }


    public TblAsset showAssets(Integer id) throws AssetesNotFoundException {
        Optional<TblAsset> asset = assetsRepository.findById(id);
        if(!asset.isPresent()){
            throw new AssetesNotFoundException("Assets Not Available");
        }
        return asset.get();
    }


    public TblAsset saveAssets(TblAsset asset) {
        return assetsRepository.save(asset);
    }


    public void deleteAssets(Integer id) {
        assetsRepository.deleteById(id);
    }
}
