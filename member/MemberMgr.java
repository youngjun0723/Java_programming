package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB관련 메소드 선언하는 클래스
public class MemberMgr {
    
private DBConnectionMgr pool;

    public MemberMgr() {
        //DBConnectionMgr 객체를 가져와서 pool에 저장
        pool = DBConnectionMgr.getInstance();
    }

    //DB연동 테스트를 하기위해 MemberMgr 객체를 생성하고 listExCnt() 메소드를 호출
    public int selectCnt() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        int cnt = 0;

        try{
            con = pool.getConnection(); // Connection 객체를 pool에 렌탈
            sql = "select count(*) from tblMember"; // SQL문 작성
            pstmt = con.prepareStatement(sql); // SQL문을 DB서버가 요구하는 형식으로 pstmt로 만듬
            rs = pstmt.executeQuery(); // SQL문 실행 후 결과를 rs에 저장
            // rs.next()는 결과값이 있으면 true 없으면 false
            // rs.getInt(1) 현재 커서가 있는 레코드에 첫번째 data를 리턴.  타입이 int형
            if(rs.next()) // 결과가 있으면
                cnt = rs.getInt(1); // 첫번째 컬럼의 값을 cnt에 저장
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	pool.freeConnection(con, pstmt, rs);
        }
        return cnt;
    }
    
    // 저장
    public boolean insertMember(MemberBean bean) {
    	Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			// ?: 매개변수로 입력된 값을 동적으로 만들기 위한 문법기능
			sql = "insert tblMember values (null, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			// (null, '홍길동', '010-2222-9999', '서울시 강남구', '배우')
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getTeam());
			// 실행된 레코드의 개수를 리턴
			int cnt = pstmt.executeUpdate(); //DML 실행 메소드
			if(cnt == 1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
    }
    
    // 리스트
    public Vector<MemberBean> listMenber() {
    	Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<MemberBean> vlist = new Vector<MemberBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblMember";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setNum(rs.getInt("num")); // "num" 컬럼명
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setAddress(rs.getString("address"));
				bean.setTeam(rs.getString("team"));
				
				vlist.add(bean); // bean을 vector에 저장
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
    }
    
    // 레코드 한 개
    public MemberBean getMember(int num) {
    	Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblMember where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setNum(rs.getInt(1)); // 컬럼의 index 번호값 or 컬럼명
				bean.setName(rs.getString(2)); 
				bean.setPhone(rs.getString(3));
				bean.setAddress(rs.getString(4));
				bean.setTeam(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
    }
    
    // 수정
    public boolean updateMember(MemberBean bean) {
    	Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			// ?: 매개변수로 입력된 값을 동적으로 만들기 위한 문법기능
			sql = "update tblMember set name = ?, phone = ?, address = ?, team = ? " + "where num = ?";
			pstmt = con.prepareStatement(sql);
			// (null, '홍길동', '010-2222-9999', '서울시 강남구', '배우')
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getTeam());
			pstmt.setInt(5, bean.getNum());
			// 실행된 레코드의 개수를 리턴
			int cnt = pstmt.executeUpdate(); //DML 실행 메소드
			if(cnt == 1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
    }
    
    
    // 삭제
    public boolean deleteMember(int num) {
    	Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from tblMember where num =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int cnt = pstmt.executeUpdate(); //DML 실행 메소드
			if(cnt == 1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
    }
    
    public static void main(String[] args) {
        MemberMgr mgr = new MemberMgr(); // MemberMgr 객체 생성
        int cnt = mgr.selectCnt(); // selectCnt() 메소드 호출
        System.out.println("총 레코드 수: " + cnt); // 결과 출력
    }
}