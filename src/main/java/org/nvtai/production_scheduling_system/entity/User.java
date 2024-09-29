package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Users")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    Long userId;

    @Column(name = "EmployeeID")
    Long employeeId;

    @Column(name = "Username")
    String username;

    @Column(name = "Password")
    String password;

    @Column(name = "Active")
    boolean active;

    @Column(name = "Email")
    String email;
}