package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAsset;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.AssetsRepository;
import com.vaas.vaasbackend.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AssetsService {
    @Autowired
    AssetsRepository assetsRepository;
    @Autowired
    private IssueRepository issueRepository;

    public List<TblAsset> showAssets() throws DataNotFoundException {
        List<TblAsset> assets = assetsRepository.findAll();
        if (assets.isEmpty()) {
            throw new DataNotFoundException("No Data Found");
        }
        return assetsRepository.findAll();
    }

    public TblAsset showAssets(Integer id) throws DataNotFoundException {
        Optional<TblAsset> asset = assetsRepository.findById(id);
        if (!asset.isPresent()) {
            throw new DataNotFoundException("Assets Not Available For Id " + id);
        }
        return asset.get();
    }

    public TblAsset saveAssets(TblAsset asset) throws Exception {
        try {
            return assetsRepository.save(asset);
        }catch (Exception e){
            throw new Exception("Data Not Inserted");
        }
    }

    public void deleteAssets(Integer id) throws DataNotFoundException {
        try {
            assetsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DataNotFoundException("Data Not Found For Id " + id);
        }
    }
}
