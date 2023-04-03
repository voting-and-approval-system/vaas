package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {
    @Autowired
    private OptionService optionService;

    @GetMapping("/option")
    public List<TblOption> ShowOption() {
        return optionService.showOption();
    }

    @GetMapping("option/{id}")
    public TblOption ShowOption(@PathVariable Integer id){
        return optionService.showOption(id);
    }

    @GetMapping("/option/issue/{id}")
    public List<TblOption> ShowOptionByIssueId(@PathVariable("id")Integer id){
        return optionService.showOptionByIssueId(id);
    }

    @PostMapping("/option")
    public TblOption SaveOption(@RequestBody TblOption option) {
        return optionService.saveOption(option);
    }

    @DeleteMapping("/option/{id}")
    public String DeleteOption(@PathVariable Integer id) {
        optionService.deleteOption(id);
        return "Record Deleted";
    }
}
