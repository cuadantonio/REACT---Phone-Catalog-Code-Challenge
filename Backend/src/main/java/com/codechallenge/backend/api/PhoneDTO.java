package com.codechallenge.backend.api;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class PhoneDTO {

    private long id;

    private String name;
    private String manufacturer;
    private String description;
    private String color;
    private long price;
    private String screen;
    private String processor;
    private long ram;

    private MultipartFile imageFileName;


}
