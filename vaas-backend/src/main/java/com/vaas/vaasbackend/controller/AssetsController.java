package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblAsset;
import com.vaas.vaasbackend.errors.DataNotFoundException;

import com.vaas.vaasbackend.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AssetsController {
    @Autowired
    AssetsService assetsService;
    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/assets")
    public List<TblAsset> showAssets() throws DataNotFoundException {
        return assetsService.showAssets();
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/assets/{id}")
    public TblAsset showAssets(@PathVariable Integer id) throws DataNotFoundException {
        return assetsService.showAssets(id);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("assets/{id}")
    public void deleteAssets(@PathVariable Integer id) throws DataNotFoundException {
        assetsService.deleteAssets(id);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @PutMapping("assets/{id}")
    public TblAsset updateAssets(@PathVariable Integer id,@RequestBody TblAsset asset) throws Exception {
        System.out.println(asset.getAssetsTitle());
        return assetsService.updateAssets(id,asset);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @PostMapping("/assets")
    public TblAsset saveAssets(@Valid @RequestBody TblAsset asset) throws Exception {
        return assetsService.saveAssets(asset);
    }
}
