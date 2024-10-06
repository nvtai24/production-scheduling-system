package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.sql.Date;


@Entity
@Table(name = "PlanDetails")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlanDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pdid;

    @ManyToOne
    @JoinColumn(name = "phid")
    PlanHeader planHeader;

    @ManyToOne
    @JoinColumn(name = "sid")
    Shift shift;

    Date date;
    int quantity;

}