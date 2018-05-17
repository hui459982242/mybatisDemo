package zh.mybatis.domain;

public class SysRolePrivilege {
    /**
     * 角色ID
     */
    private Long role_id;
    /**
     * 权限ID
     */
    private Long privilege_id;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(Long privilege_id) {
        this.privilege_id = privilege_id;
    }

    @Override
    public String toString() {
        return "SysRolePrivilege{" +
                "role_id=" + role_id +
                ", privilege_id=" + privilege_id +
                '}';
    }
}
