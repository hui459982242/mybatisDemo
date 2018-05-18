package zh.mybatis.dao;

import org.apache.ibatis.annotations.Param;
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

    /**
     * 新增用户，并返回自增id
     * @param sysUser
     * @return
     */
    int insert3(SysUser sysUser);

    /**
     * 根据主键更新
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);

    /**
     * 通过主键删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据用户id和角色的enabled状态获取用户的角色
     * @param userId
     * @param enabled
     * @return
     * @Description 多个接口参数的用法，如果接口重要传多个值得话要用注释，让mybatis将参数转为map处理
     * 不然回报 org.apache.ibatis.binding.BindingException: Parameter 'userId' not found.
     * Available parameters are [0, 1, param1, param2]
     * 0和1,param1和param2都是MyBatis根据参数位置自定义的名字，这时如果将XML中的#{userid} 改为#{0}或#{param1}
     * 将#{enabled}改为#{1}或#{param2}，这个方法就可以被正常调用了。
     * 这样讲只是为了让大家理解它们之间的关系，但实际上并不建议这么做。
     */
    List<SysRole> selectRolesByUseridAndRoleEnabled(@Param("userId")Long userId,@Param("enabled")Integer enabled);
}
