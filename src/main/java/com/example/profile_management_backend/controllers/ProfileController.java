package com.example.profile_management_backend.controllers;

import com.example.profile_management_backend.models.Profile;
import com.example.profile_management_backend.services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/web/api/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("v1/getAllProfile")
    public ResponseEntity<List<Profile>> getAllProfile() {
        return ResponseEntity.status(200).body(profileService.getAllProfiles());
    }

    @GetMapping("v1/getProfileById")
    public ResponseEntity<Optional<Profile>> getProfileById(@RequestParam("profileId") int id) {
        return ResponseEntity.status(200).body(profileService.getProfileById(id));
    }
}
