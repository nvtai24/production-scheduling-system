package org.nvtai.production_scheduling_system.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {
    Long uid;
    Long eid;
    String username;
    boolean active;
    String email;
}