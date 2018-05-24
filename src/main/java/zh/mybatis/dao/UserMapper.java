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
     * @Description 1、useGeneratedKeys设置为true后，MyBatis会使用JDBC的getGeneratedKeys方法来取出由数据库内部生成的主键
     * 2、获得主键值后将其赋值给keyProperty配置的id属性。
     * 当需要设置多个属性时，使用逗号隔开，这种情况下通常还需要设置keyColumn属性，按顺序指定数据库的列，这里列的值会和keyProperty配置的属性一一对应。
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

    /**
     * 根据动态条件查询用户信息
     * @param user
     * @return
     * @Description
     */
    List<SysUser> selectByUser(SysUser user);

    /**
     * 根据主键更新
     * @param user
     * @return
     */
    int updateByldSelective(SysUser user);

    /**
     * 在INSERT动态插入列中使用if
     *
     * @param user
     * @return
     * @Description 1、在数据库表中插入数据的时候，如果某一列的参数值不为空，就使用传入的值，如果传入参数为空，就使用数据库中的默认值（通常是空），而不使用传入的空值。
     * 使用if就可以实现这种动态插入列的功能。
     * 2、在INSERT中使用时要注意，若在列的部分增加if条件，则values的部分也要增加相同的if条件，必须保证上下可以互相对应，完全匹配。
     *
     */
    int insert2Dynamic(SysUser user);
}
