package com.example.springbootform.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String password;
    private String username;
    private String email;
    private List<StatusDto> statusDtoList;
}
