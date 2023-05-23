package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblFeedback;
import com.vaas.vaasbackend.repository.FeedbackRepository;
import com.vaas.vaasbackend.repository.VoteTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    public TblFeedback saveFeedback(TblFeedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<TblFeedback> showFeedback() {
        return feedbackRepository.findAll();
    }

    public void deleteFeedbackById(Integer id) {
        feedbackRepository.deleteById(id);
    }
}
