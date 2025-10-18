package dev.slethware.aboutme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatFactResponse {
    private String fact;
    private Integer length;
}