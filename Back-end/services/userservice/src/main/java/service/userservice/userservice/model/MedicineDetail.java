package service.userservice.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class MedicineDetail {
    @JsonProperty("medicine_name")
    private String medicineName;
    private String dosage;
    private String duration;
}