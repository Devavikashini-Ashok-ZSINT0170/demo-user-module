package com.cms.user_module.service;

import com.cms.user_module.Interface.RoleService;
import com.cms.user_module.dto.RoleRequest;
import com.cms.user_module.dto.RoleResponse;
import com.cms.user_module.model.Role;
import com.cms.user_module.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponse addRole(RoleRequest roleRequest) {
        Role role = new Role();
        role.setRole_name(roleRequest.getRole_name());

        Role savedRole = roleRepository.save(role);
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setStatus("success");
        return roleResponse;
    }

    @Override
    public RoleResponse updateRole(int id, RoleRequest roleRequest) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        existingRole.setRole_name(roleRequest.getRole_name());
        roleRepository.save(existingRole);
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setStatus("success");
        return roleResponse;
    }

    @Override
    public RoleResponse deleteRole(int id) {
        roleRepository.deleteById(id);
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setStatus("success");
        return roleResponse;
    }


}
