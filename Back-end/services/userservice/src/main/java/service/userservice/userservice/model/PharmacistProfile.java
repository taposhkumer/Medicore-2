package service.userservice.userservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pharmacist_profiles")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PharmacistProfile {
    @Id @Column(name = "user_id") private String userId;
    private String pharmacyName;
    private LocalDateTime updatedAt;
    @PreUpdate @PrePersist protected void onUpdate() { this.updatedAt = LocalDateTime.now(); }
}