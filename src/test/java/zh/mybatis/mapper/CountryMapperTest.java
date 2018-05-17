package zh.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import zh.mybatis.dao.BaseMapperTest;
import zh.mybatis.domain.Country;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest extends BaseMapperTest {
    /*private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    @Test
    public void testSelectAll(){
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = getSqlSession();
        try {
            List<Country> list = sqlSession.selectList("selectAll");
            printCountryList(list);
        }finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> list){
        for (Country country:list){
            //System.out.println(country.toString());
            System.out.printf("%-4d%4s%4s\n",country.getId(),country.getCountryname(),country.getCountrycode());
        }
    }
}
