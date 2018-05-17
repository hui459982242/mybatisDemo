package zh.mybatis.domain;

import java.util.Date;

public class SysRole {
    /**
     * 角色ID
     */
    private Long id;
    /**
     * 角色名称
     */
    private String role_name;
    /**
     * 有效标志
     */
    private int enabled;
    /**
     * 创建人ID
     */
    private int creat_by;
    /**
     * 创建时间
     */
    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getCreat_by() {
        return creat_by;
    }

    public void setCreat_by(int creat_by) {
        this.creat_by = creat_by;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", enabled=" + enabled +
                ", creat_by=" + creat_by +
                ", create_time=" + create_time +
                '}';
    }
}
