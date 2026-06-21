package service.userservice.userservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "prescriptions")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Prescription {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private String prescriptionId;
    private String patientId;
    private String doctorId;
    private String symptoms;
    private String description;
    private String transactionId;

    @JsonProperty("medicine_details")
    @ElementCollection
    @CollectionTable(name = "prescription_medicines", joinColumns = @JoinColumn(name = "prescription_id"))
    private List<MedicineDetail> medicineDetails;
}