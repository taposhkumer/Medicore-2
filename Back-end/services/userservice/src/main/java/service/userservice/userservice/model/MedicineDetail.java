package service.userservice.userservice.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class MedicineDetail {
    private String medicineName;
    private String dosage;
    private String duration;
}