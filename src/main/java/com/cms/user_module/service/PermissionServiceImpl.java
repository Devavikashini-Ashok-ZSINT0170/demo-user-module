package com.cms.user_module.service;

import com.cms.user_module.Interface.PermissionService;
import com.cms.user_module.dto.PermissionRequest;
import com.cms.user_module.dto.PermissionResponse;
import com.cms.user_module.model.Permission;
import com.cms.user_module.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public PermissionResponse addPermission(PermissionRequest permissionRequest) {
        Permission permission = new Permission();
        permission.setPermission_type(permissionRequest.getPermission_type());
        Permission savedPermission = permissionRepository.save(permission);
        PermissionResponse permissionResponse = new PermissionResponse();
        permissionResponse.setStatus("success");
        return permissionResponse;
    }

    @Override
    public PermissionResponse updatePermission(int id, PermissionRequest permissionRequest) {
        Permission existingPermission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
        existingPermission.setPermission_type(permissionRequest.getPermission_type());
        permissionRepository.save(existingPermission);
        PermissionResponse permissionResponse = new PermissionResponse();
        permissionResponse.setStatus("success");
        return permissionResponse;
    }

    @Override
    public PermissionResponse deletePermission(int id) {
        permissionRepository.deleteById(id);
        PermissionResponse permissionResponse = new PermissionResponse();
        permissionResponse.setStatus("success");
        return permissionResponse;
    }

    @Override
    public PermissionResponse getPermission(int  id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
        PermissionResponse permissionResponse = new PermissionResponse();
        permissionResponse.setPermission_type(permission.getPermission_type());
        return permissionResponse;
    }
}
