package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {
    @Autowired
    private OptionService optionService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/option")
    public List<TblOption> showOption() throws DataNotFoundException {
        return optionService.showOption();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("option/{id}")
    public TblOption showOption(@PathVariable Integer id) throws DataNotFoundException {
        return optionService.showOption(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/option/issue/{id}")
    public List<TblOption> ShowOptionByIssueId(@PathVariable("id")Integer id) throws DataNotFoundException {
        return optionService.showOptionByIssueId(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/option/{id}")
    public TblOption updateOption(@PathVariable Integer id,@RequestBody TblOption option) throws Exception {
        return optionService.updateOption(id,option);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/option")
    public TblOption saveOption(@RequestBody TblOption option) throws Exception {
        return optionService.saveOption(option);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/option/{id}")
    public void deleteOption(@PathVariable Integer id) throws DataNotFoundException {
        optionService.deleteOption(id);
    }
}
