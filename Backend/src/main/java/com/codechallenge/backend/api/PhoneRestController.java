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

    @GetMapping("/{id}/image")
    public ResponseEntity<Object> getImage(@PathVariable long id) throws SQLException{
        Optional<Phone> phone = phoneService.findById(id);
        if(phone.isPresent()){
            int photoLength = (int) phone.get().getImageFileName().length();
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").body(new ByteArrayResource(phone.get().getImageFileName().getBytes(1,photoLength)));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Phone> postImage(@ModelAttribute PhoneDTO phoneDTO,@PathVariable long id) throws IOException, SQLException{
        Phone phone = phoneService.findById(id).get();
        MultipartFile image = phoneDTO.getImageFileName();
        phone.setImageFileName(BlobProxy.generateProxy(image.getInputStream(),image.getSize()));
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

    @PutMapping("/{id}/image")
    public ResponseEntity<Object> replaceImage(@ModelAttribute PhoneDTO phoneDTO,@PathVariable long id) throws IOException, SQLException{
        Optional<Phone> phone = phoneService.findById(id);
        if(phone.isPresent()){
            MultipartFile image = phoneDTO.getImageFileName();
            phone.get().setImageFileName(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
            phoneService.save(phone.get());
            URI location = fromCurrentRequest().path("/{id}").buildAndExpand(phone.get().getId()).toUri();
            return ResponseEntity.created(location).body(phone.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
