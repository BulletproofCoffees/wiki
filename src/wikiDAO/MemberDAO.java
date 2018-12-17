package wikiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import wiki.baes.DBManager;
import wikiVO.MemberVO;


public class MemberDAO { 
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {

		return instance;
	}

	public int loginMember(String userid) {//conformId
		int result = -1;
		String sql = "select * from wikimember where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return result;
	}
	//占싸깍옙占쏙옙
	public MemberVO getPromember(String id) {//Member
		MemberVO memberVO = null;
		String sql = "select * from wikimember where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setVandals(rs.getString("vandals"));
				memberVO.setUseyn(rs.getString("useyn"));
				memberVO.setIndate(rs.getTimestamp("indate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return memberVO;
	}
	
	//회占쏙옙占쏙옙占쏙옙
	public int insertMember(MemberVO memberVO) {
		int result = 0;
		String sql = "insert into wikimember (id, pwd, email) values(?,?,?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getEmail());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt);
		}
		return result;
	}
	//0718
	public ArrayList<MemberVO> listMember(String member_name) {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "select * from wikimember where id like '%'||?||'%' order by useyn, id desc"; // 占쏙옙占쏙옙 占십울옙占쏙옙
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			if(member_name =="") {
				pstmt.setString(1, "%");
			}else {
				pstmt.setString(1, member_name);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setUseyn(rs.getString("useyn"));
				memberVO.setIndate(rs.getTimestamp("indate"));
				memberList.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(con, pstmt, rs);
		}
		return memberList;
	}
	//占쏙옙占쏙옙占쏙옙占� 占싹몌옙占�

	public void deleteMember(String id) {
		String sql = "update wikimember set useyn='n' where id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			System.out.println("占쏙옙占쏙옙 占쏙옙占쏙옙트占쏙옙占�");
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.clase(con, pstmt);
		}
	}

	public void cancelMember(String id) {
		String sql = "update wikimember set useyn='y' where id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			System.out.println("占쏙옙占쏙옙 캔占쏙옙占쏙옙占�");
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.clase(con, pstmt);
		}
	}
	
	
	
     //占쏙옙占쏙옙占쏙옙 회占쏙옙 占쏙옙占쏙옙트
	public ArrayList<MemberVO> AdminMemberList() {
		ArrayList<MemberVO> list = new ArrayList<>();
		
		 String sql= "select * from  wikiMember order by indate desc";
		 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()){			
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setVandals(rs.getString("vandals"));
				memberVO.setUseyn(rs.getString("useyn"));
				memberVO.setIndate(rs.getTimestamp("indate"));
			    list.add(memberVO);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.clase(conn, pstmt, rs);
		}			
		return list;
	}
	
	//占쏙옙占쏙옙占쏙옙 회占쏙옙 占쏙옙占쏙옙
	public void delete(MemberVO vo) {
		String sql = "DELETE FROM wikiMember WHERE id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());	
			pstmt.executeUpdate();						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.clase(conn, pstmt);
		}		 
	}

	public int login(String id, String pwd) {
		int result = -1;
		String sql = "select * from wikimember where id=?";
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

	public void updateMember(String email, String id2, String id, String pwd) {
		String sql = "update wikimember set email='" + email + "', id='" + id2 + "', pwd='" + pwd + "' where id='" + id + "'";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			System.out.println("占쏙옙占쏙옙 占쏙옙占쏙옙트占쏙옙占�");
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.clase(con, pstmt);
		}
	}
		
	
}

