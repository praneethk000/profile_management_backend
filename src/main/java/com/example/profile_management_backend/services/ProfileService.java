package com.example.profile_management_backend.services;

import com.example.profile_management_backend.models.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Optional<Profile> getProfileById(int id);
}
