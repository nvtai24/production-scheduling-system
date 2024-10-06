package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "PlanHeaders")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlanHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long phid;

    @ManyToOne
    @JoinColumn(name = "plid")
    Plan plan;

    @ManyToOne
    @JoinColumn(name = "pid")
    Product product;

    int quantity;

    // Getters and Setters
}