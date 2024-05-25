package com.cms.user_module.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "permissions")

public class Permission {

    @Id @GeneratedValue
    private int id;

    private String permission_type;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    protected void onCreate(){
        this.created_at=LocalDateTime.now();
    }

    protected void onUpdated(){
        this.updated_at=LocalDateTime.now();
    }

    private String created_by;

    private String updated_by;
}
