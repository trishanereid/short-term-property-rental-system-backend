package com.zenluxurystays.short_term_property_rental_system_backend.entity;

import com.zenluxurystays.short_term_property_rental_system_backend.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Property property;

    private Date arriveDate;
    private Date departDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private Double totalPrice;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }
}
