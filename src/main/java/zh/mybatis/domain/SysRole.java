package zh.mybatis.domain;

import java.util.Date;
import java.util.List;

public class SysRole {
    /**
     * 角色ID
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 有效标志
     */
    private int enabled;
    /**
     * 创建人ID
     */
    //private int createBy;
    /**
     * 创建时间
     */
    //private Date createTime;
    /**
     * 创建人和创建时间信息
     */
    private Createinfo createinfo;
    /**
     * 对应用户信息
     */
    private SysUser user;
    /**
     * 对应权限集
     */
    private List<SysPrivilege> privilegeList;

    public List<SysPrivilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<SysPrivilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    /*public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int creatBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }*/

    public Createinfo getCreateinfo() {
        return createinfo;
    }

    public void setCreateinfo(Createinfo createinfo) {
        this.createinfo = createinfo;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
