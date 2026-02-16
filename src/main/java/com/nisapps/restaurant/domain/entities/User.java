package com.nisapps.restaurant.domain.entities;

import com.nisapps.restaurant.domain.enums.Role;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "public_id", length = 16, updatable = false)
    private String publicId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "password_hash")
    private String passwordHash;

    @Column(nullable = false, unique = true, updatable = false, length = 10, name = "dni_number")
    private String dniNumber;

    @Column(unique = true, name = "phone_number", length = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Builder.Default
    private boolean active = true;

    @Column(name = "profile_photo_url", unique = true)
    private String profilePhotoUrl;

    @PrePersist
    public void onCreate(){
        this.publicId = UUID.randomUUID().toString().substring(0, 16);
    }
}
