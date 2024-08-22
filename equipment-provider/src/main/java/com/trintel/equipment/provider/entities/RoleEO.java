package com.trintel.equipment.provider.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class RoleEO {
    @Id
    @Column(name="ROLE_ID", nullable = false, length = 20)
    private String roleId;
    @Column(name="ROLE_NAME", length = 50)
    private String roleName;

    public RoleEO() {
    }

    public RoleEO(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
