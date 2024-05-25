package com.cms.user_module.controller;

import com.cms.user_module.Interface.PermissionService;
import com.cms.user_module.dto.PermissionRequest;
import com.cms.user_module.dto.PermissionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/permission")
    public PermissionResponse addPermission(@RequestBody PermissionRequest permissionRequest) {
        return permissionService.addPermission(permissionRequest);
    }

    @PutMapping("/permission/{id}")
    public PermissionResponse updatePermission(@PathVariable int id, @RequestBody PermissionRequest permissionRequest) {
        return permissionService.updatePermission(id, permissionRequest);
    }

    @DeleteMapping("/permission/{id}")
    public PermissionResponse deletePermission(@PathVariable int id) {
        return permissionService.deletePermission(id);
    }

    @GetMapping("/permission/{id}")
    public PermissionResponse getPermission(@PathVariable int id) {
        return permissionService.getPermission(id);
    }
}
