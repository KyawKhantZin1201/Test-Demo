package com.demo.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyFirstDb {

	public static String sql = "select count(*) from post";

	private ConnectionManager manager;

	public MyFirstDb(ConnectionManager manager) {
		super();
		this.manager = manager;
	}

	public long getPostCount() {

		try (var con = manager.getConnection(); 
				var statement = con.createStatement()) {

			var rs = statement.executeQuery(sql);

			while (rs.next()) {
				return rs.getLong(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}
}
