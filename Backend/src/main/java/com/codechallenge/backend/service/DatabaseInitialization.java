package com.codechallenge.backend.service;

import com.codechallenge.backend.modules.Phone;
import com.codechallenge.backend.repository.PhoneRepository;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class DatabaseInitialization {

    @Autowired
    private PhoneRepository phoneRepository;

    @PostConstruct
    public void init() throws IOException{
        Phone phone1 = new Phone("iPhone 7","Apple","Nice phone","Black",769,"4.7 inch IPS","A10 Fusion",2);
        setPhoneImage(phone1,"static/images/iPhone7.jpg");
        phoneRepository.save(phone1);
    }

    public void setPhoneImage(Phone phone, String classpathResource) throws IOException{
        Resource image = new ClassPathResource(classpathResource);
        phone.setImageFileName(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
    }
}
