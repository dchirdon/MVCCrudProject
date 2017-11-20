package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class WalletDaoCRUDimpl implements WalletDAO {
	private static String url = "jdbc:mysql://localhost:3306/virtualwalletdb";
	private String user = "walletuser";
	private String pass = "walletuser";

	public WalletDaoCRUDimpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}

	// @Override
	// public String getItemById1(int id) {
	// String type = null;
	// try {
	// Connection conn = DriverManager.getConnection(url, user, pass);
	// String sql = "SELECT type FROM virtualwalletdb WHERE id = ?";
	// PreparedStatement stmt = conn.prepareStatement(sql);
	// stmt.setInt(1, id);
	// ResultSet rs = stmt.executeQuery();
	// if (rs.next()) {
	// type = rs.getString(1);
	// }
	// rs.close();
	// stmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return type;
	// }

	// @Override
	public List<Item> getItemByKey(String word) {
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "select id, type, value, name from item where type like ? or name like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + word + "%");
			stmt.setString(2, "%" + word + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String type = rs.getString(2);
				double value = rs.getInt(3);
				String name = rs.getString(4);

				item = new Item(id, type, value, name);

				// call method to add actors to film
				// item.setActors(getActor(id));
				// films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	// @Override
	// public List<Actor> getActor(int filmId) {
	// List<Actor> actors = new ArrayList<>();
	// Actor actor = new Actor();
	// try {
	// Connection conn = DriverManager.getConnection(url, user, pass);
	// String sql = "select id, first_name, last_name from actor where id in (select
	// actor_id from film_actor where film_id = ?)";
	// PreparedStatement stmt = conn.prepareStatement(sql);
	// stmt.setInt(1, filmId);
	// ResultSet rs = stmt.executeQuery();
	// while (rs.next()) {
	// int id = rs.getInt(1);
	// String fName = rs.getString(2);
	// String lName = rs.getString(3);
	// actor = new Actor(id, fName, lName);
	// actors.add(actor);
	// }
	// rs.close();
	// stmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return actors;
	// }

	// @Override
	public Item getItemById(int id) {
		Item item = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, type, value, name FROM item WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
				double value = rs.getInt(2);
				String type = rs.getString(3);
				String name = rs.getString(4);
				item = new Item(id, type, value, name);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Item addItem(Item item) {
		Integer id = item.getId();
		String type = item.getType();
		Double value = item.getValue();
		String name = item.getName();
		String url = "jdbc:mysql://localhost:3306/virtualwalletdb";
		String user = "walletuser";
		String pword = "walletuser";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pword);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO item (id, type, value, name) VALUES (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id);
			stmt.setString(2, type);
			stmt.setDouble(3, value);
			stmt.setString(4, name);

			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println(id + " " + type + " " + value + " " + name + " added to your Virtual Wallet.");
			}
			// ResultSet keys = stmt.getGeneratedKeys();
			// if (keys.next()) {
			// int actorId = keys.getInt(1);
			// System.out.print("Enter a film ID: ");
			// int filmId = input.nextInt();
			// sql = "INSERT INTO film_actor (film_id,actor_id) VALUES (?,?)";
			// stmt = conn.prepareStatement(sql);
			// stmt.setInt(1, filmId);
			// stmt.setInt(2, actorId);
			// uc = stmt.executeUpdate();
			// if (uc == 1) {
			// conn.commit();
			// System.out.println(fName + " " + lName + " added to film " + filmId);
			// }
			// }
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Operation failed.  Not committing.");
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return item;
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteItem(Item id) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			String sql = "delete FROM item WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("Card " + id + " successfully deleted.");
			}
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Item editItem(Item item) {

		//public Film updateFilm(Film film, int id) {
			Integer id = item.getId();
			String type = item.getType();
			double value = item.getValue();
			String name = item.getName();
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, pass);
				conn.setAutoCommit(false);
				String sql = "UPDATE item (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) VALUES (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, id);
				stmt.setString(2, type);
				stmt.setDouble(3, value);
				stmt.setString(4, name);
				
				int uc = stmt.executeUpdate();
				if (uc == 1) {
					System.out.println(id + " " + type + " " + value + " " + name
							+ " added as a card.");
				}
				conn.commit();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Operation failed.  Not committing.");
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			return item;
		}
	}

