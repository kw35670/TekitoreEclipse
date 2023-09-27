package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.CampusException;
import model.Item;

public class itemDao extends BaseDao {

	// DBに接続
	public itemDao() throws CampusException {
		super();
	}

	// DBに登録
	public void exhibit(Item item) throws CampusException {
		int id = item.getItemId();
		ArrayList<String> iI = item.getItemImg();
		String iT = item.getItemTitle();
		String iE = item.getItemExplanation();
		String iS = item.getItemState();
		int iP = item.getItemPrice();
		boolean sS = item.isSaleState();
		Date date = item.getDateTime();
		String sn = item.getStudentNumber();

		int aik = 0;

		try {
			String sql = "INSERT INTO items(item_id, item_name," + "item_detail, item_state, item_price,"
					+ "sale_state, date_time, student_number) VALUE(?, ?, ?, ?, ?, ?, ?, ?)";

//			itemsテーブルに追加
			ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			ps.setString(2, iT);
			ps.setString(3, iE);
			ps.setString(4, iS);
			ps.setInt(5, iP);
			ps.setBoolean(6, sS);
			ps.setDate(7, (java.sql.Date) date);
			ps.setString(8, sn);
			ps.executeUpdate();
//			itemsテーブルのIDを取得
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				aik = rs.getInt(1);
			}

//			items_imgテーブルに追加
			sql = "insert into items_img(img_id, item_id, item_path)" + "value(?, ?, ?)";
			ps = con.prepareStatement(sql);
			for (int i = 0; i < iI.size(); i++) {
				ps.setInt(1, 0);
				ps.setInt(2, aik);
				ps.setString(3, iI.get(i));
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CampusException("商品の登録に失敗しました");
		}
	}

	// 一覧表示
	public ArrayList<Item> findAllItem() throws CampusException {
		ArrayList<Item> itemList = new ArrayList<>();

		try {
			String sql = "select * from items inner join items_img on items.item_id = items_img.item_id";

			// 検索の実行
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			// リストに格納
			while (rs.next()) {
				ArrayList<String> iI = new ArrayList<>();
				int id = rs.getInt("item_id");
				String iT = rs.getString("item_name");
				String iE = rs.getString("item_detail");
				String iS = rs.getString("item_state");
				int iP = rs.getInt("item_price");
				boolean sS = rs.getBoolean("sale_state");
				Date date = rs.getDate("date_time");
				String sn = rs.getString("student_number");

//				// 画像をArrayListに格納
				sql = "select count(*) from items_img where item_id = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				rsF = ps.executeQuery();
				rsF.next();
				int count = rsF.getInt(1);

				sql = "select item_path from items_img where item_id = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				rsF = ps.executeQuery();
				while (rsF.next()) {
					iI.add(rsF.getString("item_path"));
				}
				Item item = new Item(id, iI, iT, iE, iS, iP, sS, date, sn);
				itemList.add(item);

				for (int i = 0; i < count - 1; i++) {
					rs.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CampusException("商品の取得に失敗しました");
		}

		return itemList;
	}

	// 商品詳細取得
	public Item findItem(int itemId) throws CampusException {
		Item item = new Item();

		try {
			String sql = "select * from items inner join items_img on items.item_id = items_img.item_id where items.item_id = ?";

			// 検索の実行
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			rs = ps.executeQuery();

			while (rs.next()) {
				ArrayList<String> iI = new ArrayList<>();
				int id = rs.getInt("item_id");
				String iT = rs.getString("item_name");
				String iE = rs.getString("item_detail");
				String iS = rs.getString("item_state");
				int iP = rs.getInt("item_price");
				boolean sS = rs.getBoolean("sale_state");
				Date date = rs.getDate("date_time");
				String sn = rs.getString("student_number");

				// 画像をArrayListに格納
				sql = "select item_path from items_img where item_id = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				rsF = ps.executeQuery();
				while (rsF.next()) {
					iI.add(rsF.getString("item_path"));
				}

				item = new Item(id, iI, iT, iE, iS, iP, sS, date, sn);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CampusException("商品の取得に失敗しました");
		}

		return item;
	}

	// 出品した商品の取得
	public ArrayList<Item> findSelledItem(String studentNumber) throws CampusException {
		ArrayList<Item> itemList = new ArrayList<>();

		try {
			String sql = "select * from items inner join items_img on items.item_id = items_img.item_id where student_number = ?";

			// 検索の実行
			ps = con.prepareStatement(sql);
			ps.setString(1, studentNumber);
			rs = ps.executeQuery();

			// リストに格納
			while (rs.next()) {
				ArrayList<String> iI = new ArrayList<>();
				int id = rs.getInt("item_id");
				String iT = rs.getString("item_name");
				String iE = rs.getString("item_detail");
				String iS = rs.getString("item_state");
				int iP = rs.getInt("item_price");
				boolean sS = rs.getBoolean("sale_state");
				Date date = rs.getDate("date_time");
				String sn = rs.getString("student_number");

//				// 画像をArrayListに格納
				sql = "select count(*) from items_img where item_id = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				rsF = ps.executeQuery();
				rsF.next();
				int count = rsF.getInt(1);

				sql = "select item_path from items_img where item_id = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				rsF = ps.executeQuery();
				while (rsF.next()) {
					iI.add(rsF.getString("item_path"));
				}
				Item item = new Item(id, iI, iT, iE, iS, iP, sS, date, sn);
				itemList.add(item);

				for (int i = 0; i < count - 1; i++) {
					rs.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CampusException("商品の取得に失敗しました");
		}

		return itemList;
	}
}
