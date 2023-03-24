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
    public List<TblOption> ShowOption() {
        return optionService.ShowOption();
    }

    @GetMapping("option/{id}")
    public TblOption ShowOption(@PathVariable Integer id){
        return optionService.ShowOption(id);
    }

    @GetMapping("/option/issue/{id}")
    public List<TblOption> ShowOptionByIssueId(@PathVariable("id")Integer id){
        return optionService.ShowOptionByIssueId(id);
    }

    @PostMapping("/option")
    public TblOption SaveOption(@RequestBody TblOption option) {
        return optionService.SaveOption(option);
    }

    @DeleteMapping("/option/{id}")
    public String DeleteOption(@PathVariable Integer id) {
        optionService.DeleteOption(id);
        return "Record Deleted";
    }
}
