package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "WorkAssignments")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long waid;

    @ManyToOne
    @JoinColumn(name = "pdid")
    PlanDetail planDetail;

    @ManyToOne
    @JoinColumn(name = "eid")
    Employee employee;

    int quantity;

}