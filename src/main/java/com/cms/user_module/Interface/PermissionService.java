package com.cms.user_module.Interface;

import com.cms.user_module.dto.PermissionRequest;
import com.cms.user_module.dto.PermissionResponse;

public interface PermissionService {

    public PermissionResponse addPermission (PermissionRequest permissionRequest);

    public PermissionResponse updatePermission(int id, PermissionRequest permissionRequest);

    public PermissionResponse deletePermission(int id);

    public PermissionResponse getPermission(int  id);
}
