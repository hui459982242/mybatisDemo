package zh.mybatis.dao;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import zh.mybatis.domain.SysRole;
import zh.mybatis.domain.SysUser;

import java.util.ArrayList;
import java.util.Date;
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

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个user对象
            SysUser user = new SysUser();
            user.setUserName("test123");
            user.setUserEmail("test123@qq.com");
            user.setCreateTime(new Date());
            user.setUserInfo("这是一个mybatis添加的数据");
            user.setUserPassword("123456");
            //将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int result = userMapper.insert(user);
            //只插入l 条数据
            System.out.println(result);
        }finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession（）是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2User(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个user对象
            SysUser user = new SysUser();
            user.setUserName("test123");
            user.setUserEmail("test123@qq.com");
            user.setCreateTime(new Date());
            user.setUserInfo("这是一个mybatis添加的数据");
            user.setUserPassword("123456");
            //将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int result = userMapper.insert2(user);
            //只插入l 条数据
            System.out.println(result);
            //因为id回写，所以id不为null
            System.out.println(user.getId());
        }finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession（）是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3User(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个user对象
            SysUser user = new SysUser();
            user.setUserName("test123");
            user.setUserEmail("test123@qq.com");
            user.setCreateTime(new Date());
            user.setUserInfo("这是一个mybatis添加的数据");
            user.setUserPassword("123456");
            //将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int result = userMapper.insert3(user);
            //只插入l 条数据
            System.out.println(result);
            //因为id回写，所以id不为null
            System.out.println(user.getId());
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            //由于默认的sqlSessionFactory.openSession（）是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
        }finally {
            //为了不影响其他测试，这里选择回滚

            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1l);
            System.out.println("原用户名："+user.getUserName());
            user.setUserName("adminTest");
            user.setUserEmail("adminTest@icloud.com");
            user.setUserInfo("这是一个update信息");
            userMapper.updateById(user);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1011l);
            if(user!=null) {
                System.out.println("要删除的数据："+user.toString());
                int result = userMapper.deleteById(1011l);
                sqlSession.commit();
                System.out.println("受影响行数：" + result);
                List<SysUser> list = userMapper.selectAll();
                printSysUserList(list);
            }
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUseridAndRoleEnabled(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> list = userMapper.selectRolesByUseridAndRoleEnabled(1l,1);
            printSysRoleList(list);
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByUser(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test");
            List<SysUser> list = userMapper.selectByUser(user);
            printSysUserList(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testUpdateByldSelective(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("TaoTest");
            user.setId(1001l);
            user.setCreateTime(new Date());
            int result = userMapper.updateByldSelective(user);
            //直接回滚，因为Sqlsession 不会自动提交，需要手动sqlSession.commit();
            sqlSession.rollback();
            Assert.assertEquals(1,result);
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2Dynamic(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("testuser");
            user.setUserPassword("123456");
            user.setUserInfo("这是一个动态插入的用户");
            user.setCreateTime(new Date());
            int result = userMapper.insert2Dynamic(user);
            //直接回滚，因为Sqlsession 不会自动提交，需要手动sqlSession.commit();
            sqlSession.commit();
            SysUser userSelect = userMapper.selectById(user.getId());
            System.out.println(userSelect.getUserName());
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByidOrUserName(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("testuser");
            user.setUserPassword("123456");
            user.setId(1002l);
            user.setCreateTime(new Date());
            List<SysUser> list = userMapper.selectByidOrUserName(user);
            Assert.assertTrue(list.size()>0);
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByidList(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> idList =  new ArrayList<Long>();
            idList.add(1L);
            idList.add(1001l);
            List<SysUser> userList = userMapper.selectByidList1(idList);
            Assert.assertTrue(userList.size()>0);
            Assert.assertEquals(2,  userList.size());
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertList(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList =  new ArrayList<SysUser>();
            for(int i=2;i<4;i++) {
                SysUser user = new SysUser();
                user.setUserName("test"+i);
                user.setUserPassword("123456");
                user.setUserEmail("test@mybatis.tk");
                userList.add(user);
            }
            //将新建的对象批量插入数据库中
            //特别注意，这里的返回值result是执行SQL影响的行数
            int result = userMapper.insertList(userList);
            //sqlSession.commit();
            //和单表一样，此处增加了useGeneratedKeys和keyProperty两个属性， 增加这两个
            //属性后，简单修改测试类，输出id值。
            for (SysUser user:userList){
                System.out.println(user.getId());
            }

            Assert.assertEquals(2,  result);

        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
