package com.kvsb.pp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDTO {

    private Long id;
    @NotEmpty(message = "Club title should not be empty.")
    private String title;
    @NotEmpty(message = "Photo url should not be empty.")
    private String photoUrl;
    @NotEmpty(message = "Content should not be empty.")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<EventDTO> events;

}
