package zh.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zh.mybatis.domain.SysPrivilege;
import zh.mybatis.domain.SysRole;

import java.util.List;

public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAllRoleAndPrivileges(){
        SqlSession sqlSession = getSqlSession();
        try{
            RoleMapper roleMapper =  sqlSession.getMapper(RoleMapper.class);
            List<SysRole> list = roleMapper.selectAllRoleAndPrivileges();
            System.out.println("数量："+list.size());
            for (SysRole role:
            list) {
                System.out.println("角色名："+role.getRoleName());
                for (SysPrivilege privilege:
                     role.getPrivilegeList()) {
                    System.out.println("权限名："+privilege.getPrivilegeName());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
