package me.chyxion.dao;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSourceFactory;

import me.chyxion.dao.Ro;
import me.chyxion.dao.Co;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import me.chyxion.dao.BaseDAO;
import me.chyxion.dao.BaseDAOSupport;

public class TestDriver {
	DruidDataSource ds = null;
	private BaseDAO dao = null;
	{
		ds = new DruidDataSource();
		// dds.setDriver(driver);
		// ds.getConnection(username, password);
		ds.setUrl("jdbc:mysql://127.0.0.1/demo");
		ds.setUsername("root");
		ds.setPassword("0211");
		try {
			ds.init();
		}
		catch (SQLException e) {
			throw new IllegalStateException(
				"Init Data Source Error Caused", e);
		}
		dao = new BaseDAOSupport(ds);
	}

	protected void finalize() throws Throwable {
		ds.close();
	}

	private String id() {
		return UUID.randomUUID().toString();
	}

	@Test
	public void test() throws Exception {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("id", id());
		user.put("name", "Shaun Chyxion");
		user.put("gender", "M");
		user.put("date_created", new Date());
		dao.insert("demo_user", user);

		List<String> nn = dao.execute(new Co<List<String>>() {
			@Override
			protected List<String> run() {
				return null;
			}
		});

		List<String> names = dao.list(new Ro<String>() {
			public String exec(ResultSet rs) throws SQLException {
				return rs.getString("name");
			}
		}, "select name from demo_user");
		System.err.println(names);
		System.err.println(dao.findValue("select count(1) from demo_user"));
	}
}
