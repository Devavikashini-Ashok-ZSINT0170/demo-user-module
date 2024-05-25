package com.cms.user_module.controller;

import com.cms.user_module.Interface.RoleService;
import com.cms.user_module.dto.RoleRequest;
import com.cms.user_module.dto.RoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public RoleResponse addRole(@RequestBody RoleRequest roleRequest) {
        return roleService.addRole(roleRequest);
    }

    @PutMapping("/role/{id}")
    public RoleResponse updateRole(@PathVariable int id, @RequestBody RoleRequest roleRequest) {
        return roleService.updateRole(id, roleRequest);
    }

    @DeleteMapping("/role/{id}")
    public RoleResponse deleteRole(@PathVariable int id) {
        return roleService.deleteRole(id);
    }

}
