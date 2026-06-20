package service.userservice.userservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicines")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Medicine {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private String medicineId;
    private String medicineName;
    private Double price;
    private Integer quantity;
}