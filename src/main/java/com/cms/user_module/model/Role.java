package com.cms.user_module.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "roles")

public class Role {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String role_name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

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
