package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblAssete;
import com.vaas.vaasbackend.service.AssetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssetesController {
    @Autowired
    AssetesService assetesService;

    @GetMapping("/assetes")
    public List<TblAssete> ShowAssetes(){
        return assetesService.ShowAssetes();
    }

    @PostMapping("/assetes")
    public TblAssete SaveAssetes(@RequestBody TblAssete assete){
        return assetesService.SaveAssetes(assete);
    }
}
