package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "Employees")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eid;

    String ename;
    String phoneNumber;
    String address;

    @ManyToOne
    @JoinColumn(name = "did")
    Department department;

    @ManyToOne
    @JoinColumn(name = "sid")
    Shift shift;

}