package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Attendances")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long atid;

    @ManyToOne
    @JoinColumn(name = "waid")
    WorkAssignment workAssignment;

    int actualQuantity;
    boolean alpha;

}