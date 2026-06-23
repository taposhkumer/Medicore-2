package main.java.services.communicationservice.communicationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.communicationservice.communicationservice.model.ChatMessage;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {
    // Fetches conversational context sorted chronological
    List<ChatMessage> findByDoctorIdAndPatientId(String doctorId, String patientId);
}