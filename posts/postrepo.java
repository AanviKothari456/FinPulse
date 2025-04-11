package com.finpulse.repository;

import com.finpulse.model.SocialPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialPostRepository extends JpaRepository<SocialPost, Long> {
    List<SocialPost> findBySectorIgnoreCase(String sector);
}
