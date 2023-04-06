package com.vaas.vaasbackend.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_assets")
public class TblAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assets_id", nullable = false)
    private Integer id;

    @NotBlank(message = "assetsTitle is require !")
    @Column(name = "assets_title", nullable = false, length = 30)
    private String assetsTitle;

    @Column(name = "assets_description", nullable = false, length = 500)
    private String assetsDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetsTitle() {
        return assetsTitle;
    }

    public void setAssetsTitle(String assetsTitle) {
        this.assetsTitle = assetsTitle;
    }

    public String getAssetsDescription() {
        return assetsDescription;
    }

    public void setAssetsDescription(String assetsDescription) {
        this.assetsDescription = assetsDescription;
    }

}