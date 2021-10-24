package com.codechallenge.backend.service;

import com.codechallenge.backend.modules.Phone;
import com.codechallenge.backend.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public boolean exists(long id){
        return phoneRepository.existsById(id);
    }

    public List<Phone> findAll(){
        return phoneRepository.findAll();
    }

    public void save(Phone phone){
        phoneRepository.save(phone);
    }

    public Optional<Phone> findById(long id){
        return phoneRepository.findById(id);
    }

    public void delete(long id){
        phoneRepository.deleteById(id);
    }

    public long count(){
        return phoneRepository.count();
    }
}
