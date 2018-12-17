package wiki.Mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import wiki.baes.MybService;
import wikiVO.WikiVO;

public class WikiDAO2 {

	 private SqlSession sqlSession;
	
	 private static WikiDAO2 instance = new WikiDAO2();	
	public static WikiDAO2 getInstance() {
		
	        return instance;
	}
	
	
	public List<WikiVO> WikiListbar() {
		List<WikiVO> list=new ArrayList<>();
	        try{
	        	
	        	
	            sqlSession=MybService.getSqlSession().openSession();	            
	            list=sqlSession.selectList("document.documentlist");      
	            
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            MybService.sessionClose(sqlSession);
	        }
	        return list;
	    }


	
	     
}
