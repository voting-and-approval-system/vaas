package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblFeedback;
import com.vaas.vaasbackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public TblFeedback saveFeedback(@RequestBody TblFeedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/feedback")
    public List<TblFeedback> showFeedback(){
        return feedbackService.showFeedback();
    }

    @DeleteMapping("/feedback/{id}")
    public String deleteFeedbackById(@PathVariable("id") Integer id) {
        feedbackService.deleteFeedbackById(id);
        return "feedback deleted Successfully!!";
    }
}
