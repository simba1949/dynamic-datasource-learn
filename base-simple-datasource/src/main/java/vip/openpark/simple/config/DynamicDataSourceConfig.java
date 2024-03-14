package vip.openpark.simple.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * spring 容器需要注入一个 datasource 的数据源，
 * 数据源中没有 datasource 名称则会报错，
 * 此时则需要通过注解 {@link Primary} 指定主数据源
 *
 * @author anthony
 * @since 2024/3/13 22:26
 */
@Primary
@Component
public class DynamicDataSourceConfig implements DataSource {
	// 用于切换数据源
	public static final ThreadLocal<DataSourceEnum> dataSourceType = new ThreadLocal<>();
	
	@Resource
	@Qualifier("dataSource1")
	private DataSource dataSource1;
	@Resource
	@Qualifier("dataSource2")
	private DataSource dataSource2;
	
	
	/**
	 * 获取数据库连接
	 *
	 * @return Connection
	 * @throws SQLException 获取连接异常
	 */
	@Override
	public Connection getConnection() throws SQLException {
		if (DataSourceEnum.WRITE.equals(dataSourceType.get())) {
			return dataSource1.getConnection();
		} else if (DataSourceEnum.READ.equals(dataSourceType.get())) {
			return dataSource2.getConnection();
		}
		
		// 设置默认数据源
		return dataSource1.getConnection();
	}
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}
	
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
	
	}
	
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
	
	}
	
	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}
	
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}
	
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}
}