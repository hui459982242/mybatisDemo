package zh.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import zh.mybatis.domain.SysPrivilege;
import zh.mybatis.domain.SysRole;

import java.util.List;

public interface RoleMapper {

    /**
     * 根据id查询角色信息
     * @param role_id
     * @return
     */
    SysRole selectRoleById(@Param("id") long role_id);

    /**
     * 查询角色和对应权限
     * @return
     */
    List<SysRole> selectAllRoleAndPrivileges();
}
