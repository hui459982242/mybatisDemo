package zh.mybatis.domain;

public class SysUserRole {
    /**
     * 用户ID
     */
    private Long userid;
    /**
     * 角色ID
     */
    private Long roleid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
                "userid=" + userid +
                ", roleid=" + roleid +
                '}';
    }
}
