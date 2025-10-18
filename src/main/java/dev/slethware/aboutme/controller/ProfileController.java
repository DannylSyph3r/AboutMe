package dev.slethware.aboutme.controller;

import dev.slethware.aboutme.dto.ProfileResponse;
import dev.slethware.aboutme.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Profile", description = "User profile with cat facts")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get user profile with random cat fact")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "503", description = "External service unavailable")
    public ResponseEntity<ProfileResponse> getProfile() {
        log.info("GET /me endpoint called");
        ProfileResponse response = profileService.getProfile();
        return ResponseEntity.ok(response);
    }
}