package org.nvtai.production_scheduling_system.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Features")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fid")
    Long fid;

    @Column(name = "fname")
    String fname;

    @Column(name = "url")
    String url;

    @ManyToMany(mappedBy = "features")
    Set<Role> roles = new HashSet<>();
}