package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "Products")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sid;

    String slevel;
    double salary;

}