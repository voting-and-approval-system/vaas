package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Repository
public interface FeedbackRepository extends JpaRepository<TblFeedback, Integer> {

}
