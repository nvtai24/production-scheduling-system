package org.nvtai.production_scheduling_system.mapper;

import org.mapstruct.Mapper;
import org.nvtai.production_scheduling_system.entity.User;
import org.nvtai.production_scheduling_system.model.UserModel;

@Mapper (componentModel = "spring")
public interface UserMapper {
    UserModel toModel(User entity);
}