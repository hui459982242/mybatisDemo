package zh.mybatis.dao;

import zh.mybatis.domain.SysRole;
import zh.mybatis.domain.SysUser;

import java.util.List;

public interface UserMapper {
    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    SysUser selectById(Long id);
    /**
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据用户id获取角色信息
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);
}
