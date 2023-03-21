package com.vaas.vaasbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class tbl_assetes {

    @Id
    private int assetes_id;
    private String assetes_title;
    private String assetes_description;

    public int getAssetes_id() {
        return assetes_id;
    }

    public void setAssetes_id(int assetes_id) {
        this.assetes_id = assetes_id;
    }

    public String getAssetes_title() {
        return assetes_title;
    }

    public void setAssetes_title(String assetes_title) {
        this.assetes_title = assetes_title;
    }

    public String getAssetes_description() {
        return assetes_description;
    }

    public void setAssetes_description(String assetes_description) {
        this.assetes_description = assetes_description;
    }

    public tbl_assetes() {
    }

    public tbl_assetes(int assetes_id, String assetes_title, String assetes_description) {
        this.assetes_id = assetes_id;
        this.assetes_title = assetes_title;
        this.assetes_description = assetes_description;
    }

    @Override
    public String toString() {
        return "tbl_assetes{" +
                "assetes_id=" + assetes_id +
                ", assetes_title='" + assetes_title + '\'' +
                ", assetes_description='" + assetes_description + '\'' +
                '}';
    }
}
