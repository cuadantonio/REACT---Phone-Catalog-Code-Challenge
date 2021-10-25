package com.codechallenge.backend.api;

import com.codechallenge.backend.modules.Phone;
import com.codechallenge.backend.service.PhoneService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/phones")
public class PhoneRestController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/")
    public Collection<Phone> getPhones(){
        return phoneService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhone(@PathVariable long id){
        Optional<Phone> phone = phoneService.findById(id);
        if(phone.isPresent()){
            return ResponseEntity.ok(phone.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone){
        phoneService.save(phone);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(phone.getId()).toUri();
        return ResponseEntity.created(location).body(phone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable long id){
        Optional<Phone> phone = phoneService.findById(id);
        if(phone.isPresent()){
            phoneService.delete(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> replacePhone(@PathVariable long id,@RequestBody Phone newPhone){
        Optional<Phone> phone = phoneService.findById(id);
        if(phone.isPresent()){
            newPhone.setId(id);
            phoneService.save(newPhone);
            return ResponseEntity.ok(phone.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
