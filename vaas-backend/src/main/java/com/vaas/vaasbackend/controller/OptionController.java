package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {
    @Autowired
    private OptionService optionService;

    @GetMapping("/option")
    public List<TblOption> ShowOption(){
        return optionService.ShowOption();
    }

    @PostMapping("/option")
    public TblOption SaveOption(@RequestBody TblOption option){
        return optionService.SaveOption(option);
    }

    @DeleteMapping("/option/{id}")
    public String DeleteOption(@PathVariable Integer id){
        optionService.DeleteOption(id);
        return "Record Deleted";
    }
}
