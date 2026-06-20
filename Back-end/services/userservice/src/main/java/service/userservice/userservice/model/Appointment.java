package service.userservice.userservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "appointments")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long serialNo;
    private String patientId;
    private String patientName;
    private String patientPhone;
    private String doctorId;
    private String date;
    private String symptoms;
    private String transactionId;
    private Boolean isComplete;
}