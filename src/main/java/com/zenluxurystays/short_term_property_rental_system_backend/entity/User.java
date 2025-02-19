package com.zenluxurystays.short_term_property_rental_system_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenluxurystays.short_term_property_rental_system_backend.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Authority> authorities;

    @PrePersist
    protected void onCreate() {
        this.createdAt =LocalDateTime.now();
    }
}
