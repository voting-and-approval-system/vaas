package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public interface FeedbackRepository extends JpaRepository<TblFeedback, Integer> {

}
