
package wikiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import wiki.baes.DBManager;
import wikiVO.WikiVO;

public class WikiDAO { 
	private static WikiDAO instance = new WikiDAO();
	public static WikiDAO getInstance() {
		return instance;
	}
	
 
	public void insertWiki(String option, WikiVO wikiVO) {
		String sql = "insert into wikidocument(wseq, kind, title, content, id) values(wikidocument_no.nextval,'" + option + "',?,?,?)";
		PreparedStatement pstmt = null;
		Connection con = null;		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wikiVO.getTitle());
			pstmt.setString(2, wikiVO.getContent());
			pstmt.setString(3, wikiVO.getId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt);
		}
	}
	
	
	//占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙
	public ArrayList<WikiVO> listWiki(String option, String key) {
		ArrayList<WikiVO> wikiList = new ArrayList<WikiVO>();
		String sql = "select * from wikidocument where " + option + " like '%'||?||'%' order by wseq desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

				pstmt.setString(1, key);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				WikiVO wikiVO= new WikiVO();
				wikiVO.setWseq(rs.getInt(1));
				wikiVO.setKind(rs.getString(2));
				wikiVO.setTitle(rs.getString(3));
				wikiVO.setId(rs.getString(5));
				wikiVO.setIndate(rs.getTimestamp("indate"));
				wikiList.add(wikiVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return wikiList;
	}
	
	//占쏙옙占쏙옙 占쏙옙占� 占싸뱄옙占쏙옙
	public ArrayList<WikiVO> listWiki_Humanities(String option, String key) {
		ArrayList<WikiVO> wikiList = new ArrayList<WikiVO>();
		String sql = "select * from wikidocument where " + option + " like '%'||?||'%' and kind='占싸뱄옙占쏙옙' order by wseq desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

				pstmt.setString(1, key);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				WikiVO wikiVO= new WikiVO();
				wikiVO.setWseq(rs.getInt(1));
				wikiVO.setKind(rs.getString(2));
				wikiVO.setTitle(rs.getString(3));
				wikiVO.setId(rs.getString(5));
				wikiVO.setIndate(rs.getTimestamp("indate"));
				wikiList.add(wikiVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return wikiList;
	}
	//占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙
	public ArrayList<WikiVO> listWiki_Science(String option, String key) {
		ArrayList<WikiVO> wikiList = new ArrayList<WikiVO>();
		String sql = "select * from wikidocument where kind='占쏙옙占쏙옙' and " + option + " like '%'||?||'%' order by wseq desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

				pstmt.setString(1, key);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				WikiVO wikiVO= new WikiVO();
				wikiVO.setWseq(rs.getInt(1));
				wikiVO.setKind(rs.getString(2));
				wikiVO.setTitle(rs.getString(3));
				wikiVO.setId(rs.getString(5));
				wikiVO.setIndate(rs.getTimestamp("indate"));
				wikiList.add(wikiVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return wikiList;
	}
	//占쏙옙占쏙옙 占쏙옙占� 占싱분뤄옙
	public ArrayList<WikiVO> listWiki_Unclassified(String option, String key) {
		ArrayList<WikiVO> wikiList = new ArrayList<WikiVO>();
		String sql = "select * from wikidocument where kind='占싱분뤄옙' and " + option + " like '%'||?||'%' order by wseq desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

				pstmt.setString(1, key);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				WikiVO wikiVO= new WikiVO();
				wikiVO.setWseq(rs.getInt(1));
				wikiVO.setKind(rs.getString(2));
				wikiVO.setTitle(rs.getString(3));
				wikiVO.setId(rs.getString(5));
				wikiVO.setIndate(rs.getTimestamp("indate"));
				wikiList.add(wikiVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return wikiList;
	}
	//占쏙옙占쏙옙 占쏙옙占시억옙 占싯삼옙 占쏙옙占�
	public ArrayList<WikiVO> listWiki_SearchFail(String search) {
		ArrayList<WikiVO> wikiList = new ArrayList<WikiVO>();
		String sql = "select * from wikidocument where Content like '%'||?||'%' order by wseq desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

				pstmt.setString(1, search);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				WikiVO wikiVO= new WikiVO();
				wikiVO.setWseq(rs.getInt(1));
				wikiVO.setKind(rs.getString(2));
				wikiVO.setTitle(rs.getString(3));
				wikiVO.setIndate(rs.getTimestamp("indate"));
				wikiList.add(wikiVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return wikiList;
	}
	
	
	
	//占쏙옙占쏙옙占쏙옙占쏙옙
	public void deleteWiki(int wseq) {
		String sql = "delete wikidocument where wseq=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, wseq);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt);
		}
	}
	
	
	
	public int updateWiki(WikiVO wikiVO) {
		int result = -1;
		String sql = "update wikidocument set content=? where wseq=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, wikiVO.getContent());			
			pstmt.setInt(2, wikiVO.getWseq());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt);
		}
		return result;
	}
	
	public WikiVO getWiki(String wseq) {
		WikiVO wiki = null;
		String sql = "select * from wikidocument where wseq=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				wiki = new WikiVO();
				wiki.setWseq(rs.getInt("wseq"));
				wiki.setKind(rs.getString("kind"));
				wiki.setTitle(rs.getString("title"));
				wiki.setContent(rs.getString("content"));
				wiki.setImage(rs.getString("image"));
				wiki.setId(rs.getString("id"));
				wiki.setIndate(rs.getTimestamp("indate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return wiki;
	}
	//
	//0726占쌘듸옙占싹쇽옙 占쏙옙치
	public WikiVO searchWiki(String search) {
		WikiVO search1 = null;
		String sql = "select * from wikidocument where title=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				search1 = new WikiVO();
				search1.setWseq(rs.getInt(1));
				search1.setKind(rs.getString(2));
				search1.setTitle(rs.getString(3));
				search1.setContent(rs.getString(4));
				search1.setId(rs.getString(5));
				search1.setImage(rs.getString(6));
				search1.setIndate(rs.getTimestamp("indate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return search1;
	}
 
    //占쌍근글뱄옙 
	public ArrayList<WikiVO> WikiListbar() {
		ArrayList<WikiVO> list = new ArrayList<>();
		String sql = "SELECT wseq,title,indate FROM wikidocument WHERE ROWNUM <= 7 ORDER BY wseq DESC";
		/*SELECT wseq,title FROM wikidocument WHERE ROWNUM <= 7 ORDER BY wseq DESC*/ //占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		/*SELECT wseq,title FROM wikidocument*/
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;			 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()){			
				WikiVO vo = new WikiVO();
				vo.setWseq(rs.getInt("wseq"));	
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

	public ArrayList<WikiVO> count() {
		ArrayList<WikiVO> list = new ArrayList<>();
		String sql = "SELECT COUNT(*) AS Wseq FROM Wikidocument";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;			 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()){			
				WikiVO vo = new WikiVO();
				vo.setWseq(rs.getInt("wseq"));					
			    list.add(vo);}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.clase(conn, pstmt, rs);
		}			
		return list;			
		
	}

	public ArrayList<WikiVO> random() {
		ArrayList<WikiVO> list = new ArrayList<>();
		String sql = "SELECT * FROM(SELECT wseq FROM Wikidocument ORDER BY DBMS_RANDOM.RANDOM()) WHERE ROWNUM <= 1";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;			 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()){			
				WikiVO vo = new WikiVO();
				vo.setWseq(rs.getInt("wseq"));					
			    list.add(vo);}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.clase(conn, pstmt, rs);
		}			
		return list;			
	}   
}