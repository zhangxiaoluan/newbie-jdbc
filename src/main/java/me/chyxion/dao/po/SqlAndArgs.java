package me.chyxion.dao.po;

import java.util.Collection;

/**
 * @version 0.0.1
 * @since 0.0.1
 * @author Shaun Chyxion
 */
public class SqlAndArgs {
	private String sql;
	private Collection<?> args;

	/**
	 * @param sql sql
	 * @param args sql args
	 */
	public SqlAndArgs(String sql, Collection<?> args) {
		super();
		this.sql = sql;
		this.args = args;
	}

	/**
	 * @return the sql
	 */
	public String getSql() {
		return sql;
	}

	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}

	/**
	 * @return the args
	 */
	public Collection<?> getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(Collection<?> args) {
		this.args = args;
	}
}
