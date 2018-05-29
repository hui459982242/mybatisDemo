package zh.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import zh.mybatis.domain.SysRole;

public interface RoleMapper {

    /**
     * 根据id查询角色信息
     * @param role_id
     * @return
     */
    SysRole selectRoleById(@Param("id") long role_id);
}
