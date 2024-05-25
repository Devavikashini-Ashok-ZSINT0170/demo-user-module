package com.cms.user_module.Interface;

import com.cms.user_module.dto.RoleRequest;
import com.cms.user_module.dto.RoleResponse;


public interface RoleService {
    public RoleResponse addRole(RoleRequest roleRequest);

    public RoleResponse updateRole(int id, RoleRequest roleRequest);

    public RoleResponse deleteRole(int id);

}
