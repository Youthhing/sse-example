package com.youth.sse.domain.entity;

import com.youth.sse.domain.enums.EducationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_status", nullable = false)
    private EducationStatus status;

    @Column(name = "education_number", nullable = false)
    private Long number;

    @Builder
    public Education(EducationStatus status, Long number) {
        this.status = status;
        this.number = number;
    }

    public void updateStatus(EducationStatus educationStatus) {
        this.status = educationStatus;
    }
}
