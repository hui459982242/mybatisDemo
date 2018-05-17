package zh.mybatis.dao;

import zh.mybatis.domain.SysUser;

import java.util.List;

public interface UserMapper {
    /**
     * @Author: zhaohui
     * @Time: 2018/5/16 16:37
     * @Description:通过id查询用户
     * @param id
     */
    SysUser selectById(Long id);
    /**
     * @Author: zhaohui
     * @Time: 2018/5/16 17:09
     * @Description: 查询全部用户
     * @param
     */
    List<SysUser> selectAll();
}
