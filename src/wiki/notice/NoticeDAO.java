package wiki.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import wiki.baes.DBManager;
import wikiVO.NoticeVO;
import wikiVO.wiki_forumVO;

public class NoticeDAO {
   
   private static NoticeDAO instance = new NoticeDAO();   
   public static NoticeDAO getInstance() {   
      return instance;
      }
      //공지사항 리스트 보기
   public ArrayList<NoticeVO> noticeLest() {      
      ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
      String sql= "select * from  wikinotice order by indate desc";

      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);         
         rs = pstmt.executeQuery();
         while(rs.next()){         
            NoticeVO vo = new NoticeVO();
            vo.setNo(rs.getInt("no"));   
            vo.setId(rs.getString("id"));
            vo.setTitle(rs.getString("title"));
            vo.setText(rs.getString("text"));
            vo.setIndate(rs.getTimestamp("indate"));
            list.add(vo);            
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally{
         DBManager.clase(conn, pstmt, rs);
      }         
      return list;
   }
   
   //대문 리스트 보기
 public ArrayList<NoticeVO> ImdexLest() {      
    ArrayList<NoticeVO> list = new ArrayList<>();
    String sql= "SELECT no,title,indate FROM wikinotice WHERE ROWNUM <= 3 ORDER BY no DESC";
    Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;			 
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);			
		rs = pstmt.executeQuery();
		while(rs.next()){			
			NoticeVO vo = new NoticeVO();
			vo.setNo(rs.getInt("no"));	
			vo.setTitle(rs.getString("title"));	
			vo.setIndate(rs.getTimestamp("indate"));
		    list.add(vo);}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBManager.clase(conn, pstmt, rs);
	}			
	return list;	
 }
      //공지사항디테일보기
      public NoticeVO noticeDetail(String no) {         
         NoticeVO vo = null;
         String sql = "select * from wikinotice where no=?";
         
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;

         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, no);
            rs = pstmt.executeQuery();
            while (rs.next()) {
               vo = new NoticeVO();
               vo.setNo(rs.getInt("no"));   
               vo.setId(rs.getString("id"));
               vo.setTitle(rs.getString("title"));
               vo.setText(rs.getString("text"));
               vo.setIndate(rs.getTimestamp("indate"));
            }
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            DBManager.clase(conn, pstmt, rs);
         }
         return vo;
      }
      
      //관리자 공지사항 작성
      public int Update(NoticeVO vo) {   
         int d =0;
         String sql = "insert into wikinotice (no,id,title,text) values(wikinotice_no.nextval,?,?,?)";
         PreparedStatement pstmt = null;
         Connection con = null;
         try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,vo.getId());          
            pstmt.setString(2,vo.getTitle());         
            pstmt.setString(3,vo.getText());   
            d=pstmt.executeUpdate();
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            DBManager.clase(con, pstmt);
         }
         return d;         
      }
      
      //관리자 공지사항 수정
      public int Modified(NoticeVO vo) {
         int result = -1;
         String sql = "update wikinotice set title=?, text=? where no=?";
         Connection con = null;
         PreparedStatement pstmt = null;
         try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);               
            pstmt.setString(1,vo.getTitle());            
            pstmt.setString(2,vo.getText());
            pstmt.setInt(3,vo.getNo());
                        
            result = pstmt.executeUpdate();
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            DBManager.clase(con, pstmt);
         }
         return result;
         
      }
      
      //관리자 공지사항 삭제
      public int Delete(NoticeVO vo) {          
          int result = -1;
          String sql = "DELETE FROM wikinotice WHERE no =?";
            Connection con = null;
            PreparedStatement pstmt = null;
            try {
               con = DBManager.getConnection();
               pstmt = con.prepareStatement(sql);                              
               pstmt.setInt(1,vo.getNo());   
               System.out.println(vo.getNo());
               result = pstmt.executeUpdate();
            } catch (Exception e) {
               e.printStackTrace();
            } finally {
               DBManager.clase(con, pstmt);
            }
            return result;
            
         }
}