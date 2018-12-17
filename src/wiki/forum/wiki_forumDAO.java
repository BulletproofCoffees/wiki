package wiki.forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import wiki.baes.DBManager;
import wikiVO.CommentVO;
import wikiVO.WikiVO;
import wikiVO.wiki_forumVO;

public class wiki_forumDAO {
	private static wiki_forumDAO instance = new wiki_forumDAO();	
	public static wiki_forumDAO getInstance() {	
		return instance;
		}
	
	
	//포럼 데이터 가져오기
	public ArrayList<wiki_forumVO> forumList() {		
		ArrayList<wiki_forumVO> list = new ArrayList<>();
		
		 String sql= "select * from  wikiforum order by indate desc";
		 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()){			
				wiki_forumVO vo = new wiki_forumVO();
				vo.setNo(rs.getInt("no"));	
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setText(rs.getString("text"));
				vo.setCommen(rs.getString("commen"));
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

   //포럼디테일보기
	public wiki_forumVO forumDetail(int no) {
		wiki_forumVO vo = null;
		String sql = "select * from wikiforum where no=?"; // 안될가능성
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new wiki_forumVO();
				vo.setNo(rs.getInt("no"));	
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setText(rs.getString("text"));
				vo.setCommen(rs.getString("commen"));
				vo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(conn, pstmt, rs);
		}
		return vo;
	}

    //새포럼액션
	public int ForumInsert(wiki_forumVO VO) {		
		int vo = 0;
		String sql = "insert into wikiforum (no, id, title, text) values(wikiforum_no.nextval,?,?,?)";
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, VO.getId());
			pstmt.setString(2, VO.getTitle());
			pstmt.setString(3, VO.getText());
			vo = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(conn, pstmt);
		}
		return vo;		
	}
	
	//내일 수정!
	public String Comment(CommentVO commentVO ,String id, String no) {		
		String wiki_forumVO = "";
		String sql = "insert into wikicommen (no, nno, id, commen) values(wikicommen_no.nextval,"+ no + ",'" + id + "',?)";
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentVO.getCommen());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(conn, pstmt);
		}
		return wiki_forumVO;		
	}

	public ArrayList<CommentVO> commenList(int nno) {		
		ArrayList<CommentVO> commentlist = new ArrayList<CommentVO>();
		
		 String sql= "select * from  comment_view where nno = " + nno + " order by no asc";
		 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()){			
				CommentVO vo = new CommentVO();
				vo.setNo(rs.getInt("no"));	
				vo.setNno(rs.getInt("nno"));	
				vo.setFid(rs.getString("fid"));
				vo.setTitle(rs.getString("title"));
				vo.setText(rs.getString("text"));
				vo.setId(rs.getString("id"));
				vo.setCommen(rs.getString("commen"));
				vo.setIndate(rs.getTimestamp("indate"));
				commentlist.add(vo);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.clase(conn, pstmt, rs);
		}			
		return commentlist;
	}

	public void deleteComment(int no) {
		String sql = "delete wikicommen where no=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt);
		}
	}
	
	//0724수정
	public int updateforum(WikiVO wikiVO) {
		int result = -1;
		String sql = "update wikiforum set title=?, text=?, content=?, image=? where wseq=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wikiVO.getKind());
			pstmt.setString(2, wikiVO.getTitle());
			pstmt.setString(3, wikiVO.getContent());
			pstmt.setString(4, wikiVO.getImage());
			pstmt.setInt(5, wikiVO.getWseq());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt);
		}
		return result;
	}


	public ArrayList<wiki_forumVO> forumListbar() {
		ArrayList<wiki_forumVO> list = new ArrayList<>();
		String sql = "SELECT no,title,indate FROM wikiforum WHERE ROWNUM <= 5 ORDER BY no DESC"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;			 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()){			
				wiki_forumVO vo = new wiki_forumVO();
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
}
