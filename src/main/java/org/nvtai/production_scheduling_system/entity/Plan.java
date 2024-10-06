package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.sql.Date;

@Entity
@Table(name = "Plans")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long plid;

    String planName;
    Date startDate;
    Date endDate;

    @ManyToOne
    @JoinColumn(name = "did")
    private Department department;

    // Getters and Setters
}