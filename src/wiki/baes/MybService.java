package wiki.baes;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybService {


	 public static SqlSessionFactory sqlSession;  //세션 팩토리 메소드
	    
	    static {
	        String resource = "wiki/Mybatis/sqlConfig.xml";        
	        Reader reader;
	               
	        try {
	            reader = Resources.getResourceAsReader( resource ); //Configuration.xml의 리더 자원 가져옴
	            sqlSession = new SqlSessionFactoryBuilder().build( reader ); //Configuration.xml값을 담은 세션 팩토리 생성 
	          
	            //에러처리
	        } catch (IOException e) {
	            e.printStackTrace();
	        }        
	         
	    }
	    public static SqlSessionFactory getSqlSession() {return sqlSession; } // /Configuration.xml값을 담은 세션 팩토리 리턴  
		
     
	    
	    
	    
	    
	    
	    
	    //닫기
	    public static void sessionClose(SqlSession session){
	        if(session !=null) session.close();
	    }
	
	
	    
}
