package dev.slethware.aboutme.service;

import dev.slethware.aboutme.dto.CatFactResponse;
import dev.slethware.aboutme.dto.ProfileResponse;
import dev.slethware.aboutme.dto.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.time.Instant;

@Service
@Slf4j
public class ProfileService {

    private final WebClient webClient;

    @Value("${user.profile.email}")
    private String userEmail;

    @Value("${user.profile.name}")
    private String userName;

    @Value("${user.profile.stack}")
    private String userStack;

    public ProfileService(@Value("${catfact.api.url}") String apiUrl) {
        this.webClient = WebClient.builder().baseUrl(apiUrl).build();
    }

    public ProfileResponse getProfile() {
        log.info("Fetching profile for: {}", userName);

        String catFact = fetchCatFact();

        UserProfile user = UserProfile.builder()
                .email(userEmail)
                .name(userName)
                .stack(userStack)
                .build();

        return ProfileResponse.builder()
                .status("success")
                .user(user)
                .timestamp(Instant.now().toString())
                .fact(catFact)
                .build();
    }

    private String fetchCatFact() {
        try {
            log.debug("Calling cat fact API");
            CatFactResponse response = webClient.get()
                    .retrieve()
                    .bodyToMono(CatFactResponse.class)
                    .timeout(Duration.ofSeconds(5))
                    .block();

            if (response == null || response.getFact() == null) {
                log.warn("Invalid response from cat fact API");
                return "Cat fact service temporarily unavailable";
            }

            return response.getFact();
        } catch (Exception e) {
            log.error("Failed to fetch cat fact: {}", e.getMessage());
            return "Cat fact service temporarily unavailable";
        }
    }
}