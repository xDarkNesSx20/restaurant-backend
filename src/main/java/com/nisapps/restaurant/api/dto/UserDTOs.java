package com.nisapps.restaurant.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserDTOs {
    public record UserCreateRequest(@NotBlank String name, @NotBlank @Size(min = 2) String surname,
                                    @NotBlank @Email String email,
                                    @NotBlank @Size(min = 8, max = 24) String password,
                                    @NotBlank @Size(max = 10) String dniNumber,
                                    @Size(min = 10, max = 15) String phoneNumber, @NotBlank String role,
                                    String profilePhotoUrl) implements Serializable {
    }

    public record UserUpdateRequest(String name, String surname, @Size(min = 8, max = 24) String password,
                                    @Size(min = 10, max = 15) String phoneNumber,
                                    String profilePhotoUrl) implements Serializable {
    }

    public record UserResponse(String publicId, String name, String surname, String email, String dniNumber,
                               String phoneNumber, String role, String profilePhotoUrl,
                               @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAt,
                               boolean active) implements Serializable {
    }

    public record UserSummary(String publicId, String name, String surname, String dniNumber,
                              String role, String profilePhotoUrl) implements Serializable {
    }

    public record UserSimpleSummary(String publicId, String name, String surname,
                                    String profilePhotoUrl) implements Serializable {
    }
}
