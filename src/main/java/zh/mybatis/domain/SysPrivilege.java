package zh.mybatis.domain;

public class SysPrivilege {
    /**
     * 权限ID
     */
    private Long id;
    /**
     * 权限名称
     */
    private String privilege_name;
    /**
     * 权限URL
     */
    private String privilege_url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilege_name() {
        return privilege_name;
    }

    public void setPrivilege_name(String privilege_name) {
        this.privilege_name = privilege_name;
    }

    public String getPrivilege_url() {
        return privilege_url;
    }

    public void setPrivilege_url(String privilege_url) {
        this.privilege_url = privilege_url;
    }

    @Override
    public String toString() {
        return "SysPrivilege{" +
                "id=" + id +
                ", privilege_name='" + privilege_name + '\'' +
                ", privilege_url='" + privilege_url + '\'' +
                '}';
    }
}
