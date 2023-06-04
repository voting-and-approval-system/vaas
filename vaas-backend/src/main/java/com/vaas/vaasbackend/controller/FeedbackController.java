package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblFeedback;
import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public TblFeedback saveFeedback(@RequestBody TblFeedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/feedbacks")
    public List<TblFeedback> showFeedback(){
        return feedbackService.showFeedback();
    }

    @DeleteMapping("/feedback/{id}")
    public String deleteFeedbackById(@PathVariable("id") Integer id) {
        feedbackService.deleteFeedbackById(id);
        return "feedback deleted Successfully!!";
    }
}
