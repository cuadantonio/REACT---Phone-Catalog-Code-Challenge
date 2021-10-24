package com.codechallenge.backend.repository;

import com.codechallenge.backend.modules.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
