package wikiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import wiki.baes.DBManager;



public class wiki_adminDAO { 
	
	private static wiki_adminDAO instance = new wiki_adminDAO();
	public static wiki_adminDAO getInstance() {
		return instance;
	}
	

	
	//관리자login 
		public int admin_login(String id, String pwd) {
			
			int result = -1;
			String sql = "select * from wikiworker where id=?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Connection conn = null;		
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					if (pwd.equals(rs.getString("pwd"))) {
						return result = 1;
					} else {
						result = 0;
					}
				} else {
					result = -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.clase(conn, pstmt, rs);
			}
			return result;
		}


		public void admin_document_delete(int wseq) {
			String sql = "delete wikidocument where wseq=?";
			PreparedStatement pstmt = null;
			Connection conn = null;		
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, wseq);
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.clase(conn, pstmt);
			}
		}
		
		public void admin_forum_delete(int no) {
			String sql = "delete wikiforum where no=?";
			PreparedStatement pstmt = null;
			Connection conn = null;		
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.clase(conn, pstmt);
			}
		}

  
		
		/*//문서리스트 합계
				public int total(String key) {
					PreparedStatement pstmt = null;
					Connection conn = null;
					ResultSet rs = null;
					String sql ="select count(*) from product where name like '%'||?||'%' ";
					int total=0;
					conn = DBManager.getConnection();
					try {
						pstmt = conn.prepareStatement(sql);
						if(key==null)
						{
							pstmt.setString(1, "%");
						}
						else
						{
							pstmt.setString(1, key);	
						}
						
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							total=rs.getInt(1);
						}
						
							
					} catch (Exception e) {				
						e.printStackTrace();
					} finally {
						DBManager.close(conn, pstmt, rs);
					}

					return total;
				}
				
				*/}

		
