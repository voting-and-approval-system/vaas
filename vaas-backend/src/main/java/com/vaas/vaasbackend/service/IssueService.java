package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class IssueService {
    @Autowired
    IssueRepository issueRepository;

    public List<TblIssue> showIssue() throws DataNotFoundException {
        List<TblIssue> issues = issueRepository.findAll();
        if(issues.isEmpty()){
            throw new DataNotFoundException("No Data Found");
        }
        return issues;
    }


    public TblIssue showIssue(Integer id) throws DataNotFoundException {
        Optional<TblIssue> issue = issueRepository.findById(id);
        if(!issue.isPresent()){
            throw new DataNotFoundException("No Issue Found For Id " + id);
        }
        return issueRepository.findById(id).get();
    }


    public TblIssue saveIssue(TblIssue issue) throws Exception {
        try{
            return issueRepository.save(issue);
        }catch (Exception e){
            throw new Exception(e);
        }
    }


    public void deleteIssue(Integer id) throws DataNotFoundException {
        try {
            issueRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new DataNotFoundException("No Issue Found For Id " + id);
        }
    }


    public TblIssue updateIssue(Integer id, TblIssue issue) throws Exception {

        Optional<TblIssue> issue1 = issueRepository.findById(id);
        if(!issue1.isPresent()){
            throw new DataNotFoundException("No Issue Found For Id " + id);
        }
        TblIssue tblIssue = issue1.get();

        if (Objects.nonNull(issue.getIssueTitle()) &&
                !"".equalsIgnoreCase(issue.getIssueTitle())) {
            tblIssue.setIssueTitle(issue.getIssueTitle());
        }

        if (Objects.nonNull(issue.getIssueDescription()) &&
                !"".equalsIgnoreCase(issue.getIssueDescription())) {
            tblIssue.setIssueDescription(issue.getIssueDescription());
        }

        if (Objects.nonNull(issue.getIssueAttachmentPath()) &&
                !"".equalsIgnoreCase(issue.getIssueAttachmentPath())) {
            tblIssue.setIssueAttachmentPath(issue.getIssueAttachmentPath());
        }

        if (Objects.nonNull(issue.getAllowMultipleOptions()) &&
                !"".equalsIgnoreCase(issue.getAllowMultipleOptions().toString())) {
            tblIssue.setAllowMultipleOptions(issue.getAllowMultipleOptions());
        }

        if (Objects.nonNull(issue.getAssets()) &&
                !"".equalsIgnoreCase(issue.getAssets().toString())) {
            tblIssue.setAssets(issue.getAssets());
        }

        if (Objects.nonNull(issue.getIssueIsActive()) &&
                !"".equalsIgnoreCase(issue.getIssueIsActive().toString())) {
            tblIssue.setIssueIsActive(issue.getIssueIsActive());
        }

        if (Objects.nonNull(issue.getVoteType()) &&
                !"".equalsIgnoreCase(issue.getVoteType().toString())) {
            tblIssue.setVoteType(issue.getVoteType());
        }

        try{
            return issueRepository.save(tblIssue);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public List<TblIssue> showActiveIssue(boolean isActive) throws DataNotFoundException {
        List<TblIssue> issues = issueRepository.findByIssueIsActive(isActive);
        if(issues.isEmpty()){
            throw new DataNotFoundException("No Active Issue Is Found");
        }
        return issues;
    }

    public List<TblIssue> getActiveIssueForAssets(Integer assetsId) throws DataNotFoundException {
        List<TblIssue> list = issueRepository.getActiveIssueForAssets(assetsId);
        if(list.isEmpty()){
            throw new DataNotFoundException("No Active Issue Found For Given Assets");
        }
        return list;
    }

    public Integer getIdOfLastAddedIssue() throws DataNotFoundException {
        Integer id = issueRepository.getIdOfLastAddedIssue();
        if(id == null){
            throw new DataNotFoundException("No Id Found");
        }
        return id;
    }
}
