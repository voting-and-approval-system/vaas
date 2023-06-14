package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OptionController {
    @Autowired
    private OptionService optionService;
    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/option")
    public List<TblOption> showOption() throws DataNotFoundException {
        return optionService.showOption();
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("option/{id}")
    public TblOption showOption(@PathVariable Integer id) throws DataNotFoundException {
        return optionService.showOption(id);
    }

    @GetMapping("/option/issue/{id}")
    public List<TblOption> ShowOptionByIssueId(@PathVariable("id")Integer id) throws DataNotFoundException {
        return optionService.showOptionByIssueId(id);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @PutMapping("/option/{id}")
    public TblOption updateOption(@PathVariable Integer id,@RequestBody TblOption option) throws Exception {
        return optionService.updateOption(id,option);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @PostMapping("/option")
    public TblOption saveOption(@RequestBody TblOption option) throws Exception {
        return optionService.saveOption(option);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("/option/{id}")
    public void deleteOption(@PathVariable Integer id) throws DataNotFoundException {
        optionService.deleteOption(id);
    }
}
