package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblAssete;
import com.vaas.vaasbackend.errors.AssetesNotFoundException;

import com.vaas.vaasbackend.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AssetsController {
    @Autowired
    AssetsService assetsService;

    @GetMapping("/assets")
    public List<TblAssete> showAssets(){
        return assetsService.showAssets();
    }

    @GetMapping("/assets/{id}")
    public TblAssete showAssets(@PathVariable Integer id) throws AssetesNotFoundException {
        return assetsService.showAssets(id);
    }

    @DeleteMapping("assets/{id}")
    public String deleteAssets(@PathVariable Integer id){
        assetsService.deleteAssets(id);
        return "Record Deleted !!";
    }

    @PostMapping("/assets")
    public TblAssete saveAssets(@Valid @RequestBody TblAssete asset){
        return assetsService.saveAssets(asset);
    }
}
