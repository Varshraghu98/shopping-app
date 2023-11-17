package com.application.shopping.entity.admin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "image_model")
@Getter
@Setter
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;

    private String name;

    private String type;

    @Column(length = 5000000)
    private byte[] pictureBytes;

    public ImageModel() {

    }

    public ImageModel(String name, String type, byte[] pictureBytes) {
        this.name = name;
        this.type = type;
        this.pictureBytes = pictureBytes;
    }
}
