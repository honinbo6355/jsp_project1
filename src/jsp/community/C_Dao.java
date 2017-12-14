package jsp.community;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class C_Dao {
	
	DataSource dataSource;
	
	public C_Dao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mywdbpool");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<C_Dto> readPage(int startNo, int pageSize/*읽을 시작 인덱스, 읽을 갯수*/){
		ArrayList<C_Dto> dtos = new ArrayList<C_Dto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		
		// 읽을 시작 인덱스 변수 선언 및 초기화
		// 읽을 갯수 변수 선언 및 초기화
		
		try{
			conn=dataSource.getConnection();
			sql="SELECT cNum, cId, cName, cTitle, cContent, cDate, cHit FROM community ORDER BY cNum desc limit ?, ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startNo-1/*읽을 시작 인덱스 변수*/);
			pstmt.setInt(2, pageSize/*읽을 갯수 변수*/);
			rs=pstmt.executeQuery();
			while(rs.next()){
				int cNum = rs.getInt("cNum");
				int cId = rs.getInt("cId");
				String cName = rs.getString("cName");
				String cTitle = rs.getString("cTitle");
				String cContent = rs.getString("cContent"); 
				Timestamp cDate = rs.getTimestamp("cDate");
				int cHit = rs.getInt("cHit");
				
				C_Dto dto = new C_Dto(cNum, cId, cName, cTitle, cContent, cDate, cHit);
				dtos.add(dto);
				//System.out.println("select page ok!!");	
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public Page_Dto pazing(int c_Page){
		Page_Dto dto = new Page_Dto();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		
		try{
			conn=dataSource.getConnection();
			sql="SELECT count(*) FROM community";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				dto.setTotal_record((rs.getInt(1) /*총 게시물 수*/));
		    dto.setPage_num(c_Page /*현재 페이지 번호*/);
			dto.setPage_per_record_cnt(5 /*각 페이지당 게시물 수*/);
			dto.setGroup_per_page_cnt(5 /*각 페이지당 보여줄 그룹 수*/);
			dto.Pazing();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public int write(String cName, String cTitle, String cContent){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		int result=0;
		try{
			conn=dataSource.getConnection();
			sql="SELECT ifnull(max(cNum),0)+1 FROM community";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			int cNum=0;
			if(rs.next()){
				cNum=rs.getInt(1);
			}
			sql="INSERT INTO community(cNum,cName,cTitle,cContent) VALUES(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cNum);
			pstmt.setString(2, cName);
			pstmt.setString(3, cTitle);
			pstmt.setString(4, cContent);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public C_Dto contentView(String strId){
		upHit(strId);
		
		C_Dto dto = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = null;
		
		try {
			conn=dataSource.getConnection();
			sql="SELECT * FROM community WHERE cId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				int cNum = rs.getInt("cNum");
				int cId = rs.getInt("cId");
				String cName = rs.getString("cName");
				String cTitle = rs.getString("cTitle");
				String cContent = rs.getString("cContent");
				Timestamp cDate = rs.getTimestamp("cDate");
				int cHit = rs.getInt("cHit");
				
				dto = new C_Dto(cNum, cId, cName, cTitle, cContent, cDate, cHit);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public C_Dto modifyView(String strId){
		C_Dto dto = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = null;
		
		try {
			conn=dataSource.getConnection();
			sql="SELECT * FROM community WHERE cId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				int cNum = rs.getInt("cNum");
				int cId = rs.getInt("cId");
				String cName = rs.getString("cName");
				String cTitle = rs.getString("cTitle");
				String cContent = rs.getString("cContent");
				Timestamp cDate = rs.getTimestamp("cDate");
				int cHit = rs.getInt("cHit");
				
				dto = new C_Dto(cNum, cId, cName, cTitle, cContent, cDate, cHit);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public int modify(String strId, String cTitle, String cContent) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = null;
		int result=0;
		
		try{
			conn=dataSource.getConnection();
			sql="UPDATE community SET cTitle=?, cContent=?, cDate=now() WHERE cId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cTitle);
			pstmt.setString(2, cContent);
			pstmt.setInt(3, Integer.parseInt(strId));
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int delete(String cId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = null;
		int result=0;
		
		try{
			conn=dataSource.getConnection();
			sql="DELETE FROM community WHERE cId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			result = pstmt.executeUpdate();
			cId_reOrder(cId);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public void cId_reOrder(String cId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = null;
		int result=0;
		
		try{
			conn=dataSource.getConnection();
			sql="UPDATE community SET cNum=cNum-1 WHERE cId>?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	private void upHit(String cId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = null;
		int result=0;
		try{
			conn=dataSource.getConnection();
			sql="UPDATE community SET cHit = cHit+1 WHERE cId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public int reply(String rGroup, String rName, String rContent){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		int result=0;
		try{
			conn=dataSource.getConnection();
			sql="SELECT ifnull(max(rNum),0)+1 FROM community_reply";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			int rParent=0;
			if(rs.next()){
				rParent=rs.getInt(1);
			}
			sql = "INSERT INTO community_reply(rParent, rGroup, rName, rContent, rStep, rIndent) VALUES(?,?,?,?,0,0)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rParent);
			pstmt.setInt(2, Integer.parseInt(rGroup));
			pstmt.setString(3, rName);
			pstmt.setString(4, rContent);
			result = pstmt.executeUpdate();
			System.out.println(result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<R_Dto> replyView(String strId){
		ArrayList<R_Dto> dtos = new ArrayList<R_Dto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = null;
		
		try {
			conn=dataSource.getConnection();
			sql="SELECT * FROM community_reply WHERE rGroup=? ORDER BY rParent desc, rStep asc";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				int rNum = rs.getInt("rNum");
				int rParent = rs.getInt("rParent");
				int rGroup = rs.getInt("rGroup");
				String rName = rs.getString("rName");
				String rContent = rs.getString("rContent");
				Timestamp rDate = rs.getTimestamp("rDate");
				int rStep = rs.getInt("rStep");
				int rIndent = rs.getInt("rIndent");
				
				R_Dto dto = new R_Dto(rNum, rParent, rGroup, rName, rContent, rDate, rStep, rIndent);
				dtos.add(dto);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public R_Dto answerView(String strrNum){
		R_Dto dto = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = null;
		
		try {
			conn=dataSource.getConnection();
			sql="SELECT * FROM community_reply WHERE rNum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strrNum));
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				int rNum = rs.getInt("rNum");
				int rParent = rs.getInt("rParent");
				int rGroup = rs.getInt("rGroup");
				String rName = rs.getString("rName");
				String rContent = rs.getString("rContent");
				Timestamp rDate = rs.getTimestamp("rDate");
				int rStep = rs.getInt("rStep");
				int rIndent = rs.getInt("rIndent");
				
				dto = new R_Dto(rNum, rParent, rGroup, rName, rContent, rDate, rStep, rIndent);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public int answer(String rParent, String rGroup, String rName, String rContent, String rStep, String rIndent){
		
		replyShape(rParent, rGroup, rStep);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		int result=0;
		
		try{
			conn=dataSource.getConnection();
			sql="INSERT INTO community_reply(rParent, rGroup, rName, rContent, rStep, rIndent) VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(rParent));
			pstmt.setInt(2, Integer.parseInt(rGroup));
			pstmt.setString(3, rName);
			pstmt.setString(4, rContent);
			pstmt.setInt(5, Integer.parseInt(rStep)+1);
			pstmt.setInt(6, Integer.parseInt(rIndent)+1);
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	private void replyShape(String rParent, String rGroup, String rStep){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql=null;
		int result=0;
		
		try{
			conn=dataSource.getConnection();
			sql="UPDATE community_reply SET rStep = rStep + 1 WHERE rParent = ? AND rGroup = ? AND rStep > ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(rParent));
			pstmt.setInt(2, Integer.parseInt(rGroup));
			pstmt.setInt(3, Integer.parseInt(rStep));
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
