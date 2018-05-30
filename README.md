# mybatisDemo
这是mybatis学习的事例

#所有例子均来自《MyBatis从入门到精通》 刘增辉(著)

很不错的书，挺基础，也很全面

很适合刚开始接触mybatis的初学人员

<resultMap id="userRoleListMap" extends="userMap"
           type="zh.mybatis.domain.SysUser">
    <!--<id property="id" column="id"/>
    <result property="userName" column="user_name"/>
    <result property="userPassword"  column="user_password"/>
    <result property="userEmail" column="user_email"/>
    <result property="userInfo" column="user_info"/>
    <result property="headImg" column="head_img" jdbcType="BLOB"/>
    <result property="createTime" column="create_time" jdbcType="TIMESTAMP"/>
    <collection property="roleList" columnPrefix="role_"
                javaType="zh.mybatis.domain.SysRole">
        <id property="id" column="id"/>
        <result property="roleName" column="role_name"/>
        <result property="enabled"  column="enabled"/>
        <result property="createBy" column="create_by"/>
        <result property="createTime" column="create_time" jdbcType="TIMESTAMP"/>
    </collection>-->
    <!-- 下面的写法更精简 -->
    <collection property="roleList" columnPrefix="role_"
    resultMap="zh.mybatis.dao.RoleMapper.roleMap"/>
</resultMap>

精简的写法就能查出数据，上面的写法就不行。o(╥﹏╥)o