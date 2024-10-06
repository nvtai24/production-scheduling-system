package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Time;

@Entity
@Table(name = "Shifts")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sid;

    String sname;
    Time startTime;
    Time endTime;

    // Getters and Setters
}