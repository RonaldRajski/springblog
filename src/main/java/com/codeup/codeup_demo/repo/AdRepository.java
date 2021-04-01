package com.codeup.codeup_demo.repo;

import com.codeup.codeup_demo.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
}
