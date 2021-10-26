package com.codechallenge.backend.service;

import com.codechallenge.backend.modules.Phone;
import com.codechallenge.backend.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class DatabaseInitialization {

    @Autowired
    private PhoneRepository phoneRepository;

    @PostConstruct
    public void init() throws IOException{
        Phone phone1 = new Phone("iPhone 7","Apple","Nice phone","Black",769,"4.7 inch IPS","A10 Fusion",2,"https://m.media-amazon.com/images/I/61+fbdrjtCL._AC_SY355_.jpg");
        phoneRepository.save(phone1);
        Phone phone2 = new Phone("iPhone 8","Apple","Great phone","White",769,"4.7 inch IPS","A10 Fusion",2,"https://m.media-amazon.com/images/I/51l64VK7g1S._AC_SX679_.jpg");
        phoneRepository.save(phone2);
        Phone phone3 = new Phone("Xiaomi Redmi Note 7","Xiaomi","Nice phone","Blue",769,"4.7 inch IPS","A10 Fusion",2,"https://i01.appmifile.com/webfile/globalimg/zixuanz/redminote7blue.png");
        phoneRepository.save(phone3);
        Phone phone4 = new Phone("Huawei P40 Lite","Huawei","Nice phone","Green",769,"4.7 inch IPS","A10 Fusion",2,"https://img01.huaweifile.com/eu/es/huawei/pms/product/6901443375776/428_428_E0F61444A00057E73E9CE22690DEA43F5184B60E41B5030Bmp.png");
        phoneRepository.save(phone4);
        Phone phone5 = new Phone("Samsung Galaxy G20","Samsung","Nice phone","Pink",769,"4.7 inch IPS","A10 Fusion",2,"https://m.media-amazon.com/images/I/61Ovpc19HxL._AC_SX679_.jpg");
        phoneRepository.save(phone5);
    }

}
