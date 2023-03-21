package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.service.AssetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.vaas.vaasbackend.entity.tbl_assetes;


@RestController
public class AssetesController {

    @Autowired
    private AssetesService assetesService;

    @GetMapping("/assetes")
    public List<tbl_assetes> FetchAssetes(){
        return assetesService.fetchAssetes();
    }
}
