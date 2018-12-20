package com.api.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class PhotoModel implements Serializable {

    @JsonProperty("url")
    private String url;

    public PhotoModel(){

    }
    public  PhotoModel(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

