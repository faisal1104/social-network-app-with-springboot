package com.example.springbootform.dto;

import com.example.springbootform.model.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class StatusDto {

    private long statusId;
    private String statusText;
    private Location location;
    private String statusPrivacy;
}
