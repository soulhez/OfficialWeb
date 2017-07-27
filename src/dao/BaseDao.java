package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ���ݿ�������
 * @author xujun
 *
 */
public class BaseDao {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost/officialwebdb";
	private static final String USER="root";
	private static final String PWD="ok";
	
	protected Connection con=null;
	protected PreparedStatement pstmt=null;
	protected ResultSet rs=null;
	/**
	 * ��������
	 */
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �������ݿ�
	 */
	public void getConnection(){
		
		try {
			con=DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ر�����
	 */
	public void closeAll(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ɾ��
	 */
	public int executeUpdate(String sql,Object...prams){
		getConnection();
		int num=0;
		try {
			pstmt=con.prepareStatement(sql);
			if(prams!=null){
				for (int i = 0; i < prams.length; i++) {
					pstmt.setObject(i+1,prams[i]);
				}
			}
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return num;
	}
	/**
	 * ��ѯ
	 */
	public ResultSet executeQuery(String sql,Object...prams){
		getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			if(prams!=null){
				for (int i = 0; i < prams.length; i++) {
					pstmt.setObject(i+1,prams[i]);
				}
			}
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
