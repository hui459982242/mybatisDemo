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

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 新增用户，并返回自增id
     * @param sysUser
     * @return
     */
    int insert2(SysUser sysUser);
}
