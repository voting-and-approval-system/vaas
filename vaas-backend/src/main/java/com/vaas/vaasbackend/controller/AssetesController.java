package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblAssete;
import com.vaas.vaasbackend.service.AssetesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetesController {
    @Autowired
    AssetesService assetesService;

    @GetMapping("/assetes")
    public List<TblAssete> ShowAssetes(){
        return assetesService.ShowAssetes();
    }

    @GetMapping("/assetes/{id}")
    public TblAssete ShowAssetes(@PathVariable Integer id){
        return assetesService.ShowAssetes(id);
    }

    @DeleteMapping("assetes/{id}")
    public String DeleteAssetes(@PathVariable Integer id){
        assetesService.DeleteAssetes(id);
        return "Record Deleted !!";
    }

    @PostMapping("/assetes")
    public TblAssete SaveAssetes(@Valid @RequestBody TblAssete assete){
        return assetesService.SaveAssetes(assete);
    }
}
