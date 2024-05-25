package com.cms.user_module.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PermissionResponse {

    private String status;

    public void setPermission_type(String permissionType) {
    }
}
