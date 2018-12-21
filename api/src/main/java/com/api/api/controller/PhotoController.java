package com.api.api.controller;

import com.api.api.model.PhotoModel;
import com.api.api.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PhotoController {

    @Autowired
    protected S3Service s3Service;

    @PostMapping("/photo/upload")
    public String uploadphoto(@RequestPart(value = "file") MultipartFile img){
        String url = s3Service.uploadFile(img);
        PhotoModel photo = new PhotoModel();
        photo.setUrl(url);
        return url;
    }
}
