package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAssete;
import com.vaas.vaasbackend.errors.AssetesNotFoundException;
import com.vaas.vaasbackend.repository.AssetesRepository;
import com.vaas.vaasbackend.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetesService {
    @Autowired
    AssetesRepository assetesRepository;
    @Autowired
    private IssueRepository issueRepository;

    public List<TblAssete> showAssetes() {
        return assetesRepository.findAll();
    }

    public TblAssete showAssetes(Integer id) throws AssetesNotFoundException {
        Optional<TblAssete> assete = assetesRepository.findById(id);
        if(!assete.isPresent()){
            throw new AssetesNotFoundException("Assetes Not Available");
        }
        return assete.get();
    }

    public TblAssete saveAssetes(TblAssete assete) {
        return assetesRepository.save(assete);
    }

    public void deleteAssetes(Integer id) {
        try {
            assetesRepository.deleteById(id);
        }catch (NullPointerException e){

        }
    }
}
