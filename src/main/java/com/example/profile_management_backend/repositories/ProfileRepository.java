package com.example.profile_management_backend.repositories;

import com.example.profile_management_backend.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
