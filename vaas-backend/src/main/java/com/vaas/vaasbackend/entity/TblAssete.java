package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_assetes")
public class TblAssete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assetes_id", nullable = false)
    private Integer id;

    @NotBlank(message = "assetesTitle is require !")
    @Column(name = "assetes_title", nullable = false, length = 30)
    private String assetesTitle;

    @Column(name = "assetes_description", nullable = false, length = 500)
    private String assetesDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetesTitle() {
        return assetesTitle;
    }

    public void setAssetesTitle(String assetesTitle) {
        this.assetesTitle = assetesTitle;
    }

    public String getAssetesDescription() {
        return assetesDescription;
    }

    public void setAssetesDescription(String assetesDescription) {
        this.assetesDescription = assetesDescription;
    }

}