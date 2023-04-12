package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAsset;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AssetsService {
    @Autowired
    AssetsRepository assetsRepository;

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

    public TblAsset updateAssets(Integer id, TblAsset asset) throws Exception {

        Optional<TblAsset> asset1 = assetsRepository.findById(id);
        if(!asset1.isPresent()){
            throw new DataNotFoundException("No Issue Found For Id " + id);
        }
        TblAsset tblAsset = asset1.get();

        if (Objects.nonNull(asset.getAssetsTitle()) &&
                !"".equalsIgnoreCase(asset.getAssetsTitle())) {
            tblAsset.setAssetsTitle(asset.getAssetsTitle());
        }

        if (Objects.nonNull(asset.getAssetsDescription()) &&
                !"".equalsIgnoreCase(asset.getAssetsDescription())) {
            tblAsset.setAssetsDescription(asset.getAssetsDescription());
        }
        try{
            return assetsRepository.save(tblAsset);
        }catch (Exception e){
            throw new Exception(e);
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
