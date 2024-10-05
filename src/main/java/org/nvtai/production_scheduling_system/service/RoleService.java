package org.nvtai.production_scheduling_system.service;

import org.nvtai.production_scheduling_system.entity.Role;
import org.nvtai.production_scheduling_system.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null);  // Trả về role nếu tìm thấy, nếu không trả về null
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}