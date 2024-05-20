package p01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DAO {

	//検索メソッド
//	public Member findById(String _id) throws DAOException {
//		Member m = null;
//
//		String sql = "SELECT * FROM members order by age asc";
//
//		try (
//			//正常にDBに接続された時に利用できるリモコンcon
//			//Connection con = DriverManager.getConnection(url, user, pass);
//			Connection con = getConnect();
//		) {
//			//SQL文を実行する準備をする
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			//プレースホルダの部分に値を設定する
//			//ps.setString(1, _id);
//
//			//SQLを実行して結果を取得する
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next() == true) { //レコードがあったら
//				//レコードの列のデータを取得する
//				int id = rs.getInt("id"); //idの列のデータを取得
//				String name = rs.getString("name"); //nameの列のデータを取得
//				
//
//				m = new Member(id, name, age, tel);
//			}
//
//		} catch (Exception e) {
//			throw new DAOException("データベース関連エラー");
//			//System.out.println("データベース関連エラー");
//			//e.printStackTrace();
//		}
//
//		return m;
//	}
	
	//全件検索メソッド
	public List<Member> findAll() throws DAOException {
		List<Member> members = new ArrayList<>();

		String sql = "SELECT * FROM members order by age asc";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

//			//プレースホルダの部分に値を設定する
//			ps.setString(1, _id);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code"); //idの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age");	
				String tel = rs.getString("tel");
				

//				User u = new User(id, name, age);
//				users.add(u);
				
				members.add(new Member(code, name, age, tel ));
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return members;
	}
	
//	//登録メソッド
//		public List<Member> insert(id,name) throws DAOException {
//			List<Member> users = new ArrayList<>();
//
//			String sql = "INSERT INTO users VALUE (?,?)";
//
//			try (
//				//正常にDBに接続された時に利用できるリモコンcon
//				//Connection con = DriverManager.getConnection(url, user, pass);
//				Connection con = getConnect();
//			) {
//				//SQL文を実行する準備をする
//				PreparedStatement ps = con.prepareStatement(sql);
//
//				//プレースホルダの部分に値を設定する
//				ps.setInt(1, id);
//				ps.setString(2,name);
//
//
//				//SQLを実行して結果を取得する
//				ResultSet rs = ps.executeQuery();
//
//				while (rs.next() == true) { //レコードがあったら
//					//レコードの列のデータを取得する
//					String id = rs.getString("id"); //idの列のデータを取得
//					String name = rs.getString("name"); //nameの列のデータを取得
//					int age = rs.getInt("age"); //ageの列のデータを取得
//
////					User u = new User(id, name, age);
////					users.add(u);
//					
//					users.add(new Member(id, name));
//				}
//
//			} catch (Exception e) {
//				throw new DAOException("データベース関連エラー");
//				//System.out.println("データベース関連エラー");
//				//e.printStackTrace();
//			}
//
//			return cheak;
//		}
	
}
