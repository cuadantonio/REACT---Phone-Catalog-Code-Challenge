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
        Phone phone1 = new Phone("iPhone 7","Apple","Nice phone","Black",769,"4.7 inch IPS","A10 Fusion",2,"https://cf4.certideal.com/20792-thickbox_default/iphone-7-plus-32-gb-oro-rosa.jpg");
        phoneRepository.save(phone1);
        Phone phone2 = new Phone("iPhone 7","Apple","Nice phone","Black",769,"4.7 inch IPS","A10 Fusion",2,"https://cf4.certideal.com/20792-thickbox_default/iphone-7-plus-32-gb-oro-rosa.jpg");
        phoneRepository.save(phone2);
        Phone phone3 = new Phone("iPhone 7","Apple","Nice phone","Black",769,"4.7 inch IPS","A10 Fusion",2,"https://cf4.certideal.com/20792-thickbox_default/iphone-7-plus-32-gb-oro-rosa.jpg");
        phoneRepository.save(phone3);
        Phone phone4 = new Phone("iPhone 7","Apple","Nice phone","Black",769,"4.7 inch IPS","A10 Fusion",2,"https://cf4.certideal.com/20792-thickbox_default/iphone-7-plus-32-gb-oro-rosa.jpg");
        phoneRepository.save(phone4);
        Phone phone5 = new Phone("iPhone 7","Apple","Nice phone","Black",769,"4.7 inch IPS","A10 Fusion",2,"https://cf4.certideal.com/20792-thickbox_default/iphone-7-plus-32-gb-oro-rosa.jpg");
        phoneRepository.save(phone5);
    }

}
