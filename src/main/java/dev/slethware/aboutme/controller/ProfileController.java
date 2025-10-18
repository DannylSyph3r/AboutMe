package dev.slethware.aboutme.controller;

import dev.slethware.aboutme.dto.ProfileResponse;
import dev.slethware.aboutme.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileResponse> getProfile() {
        log.info("GET /me endpoint called");
        ProfileResponse response = profileService.getProfile();
        return ResponseEntity.ok(response);
    }
}