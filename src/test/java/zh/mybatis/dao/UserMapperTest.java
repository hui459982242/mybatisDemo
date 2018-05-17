package zh.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import zh.mybatis.domain.SysRole;
import zh.mybatis.domain.SysUser;

import java.util.List;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectAll方法查询所有用户
            List<SysUser> list = userMapper.selectAll();
            printSysUserList(list);
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size()>0);
        }finally {
            sqlSession.close();
        }
    }

    private void printSysUserList(List<SysUser> list){
        for (SysUser user:list){
            System.out.println(user.toString());
        }
    }

    @Test
    public void testUserById(){
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectByid方法，查询id = 1 的用户
            SysUser user = userMapper.selectById(1l);
            System.out.println(user.toString());
            Assert.assertNotNull(user);
            Assert.assertEquals("admin",user.getUserName());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testRoleByUserId(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> list = userMapper.selectRolesByUserId(1l);
            printSysRoleList(list);
        }finally {
            sqlSession.close();
        }
    }

    private void printSysRoleList(List<SysRole> list){
        for (SysRole role:list){
            System.out.println(role.toString());
        }
    }
}
