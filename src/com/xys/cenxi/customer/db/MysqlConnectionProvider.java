package com.xys.cenxi.customer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.exception.CusException;


/**
 * 用嵌入式数据库做测试
 */
public class MysqlConnectionProvider implements ConnectionProvider {
	
    private Properties settings;
    private String serverURL;
    private String driver = "org.gjt.mm.mysql.Driver";
    private String proxoolURL;
    
    private Logger logger = LoggerFactory.getLogger(MysqlConnectionProvider.class);

    public MysqlConnectionProvider() {
    	logger.warn("mysql database");
    }

    public boolean isPooled() {
        return true;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
            return DriverManager.getConnection(proxoolURL, settings);
        }
        catch (ClassNotFoundException e) {
            throw new CusException("找不到驱动: "+e);
        }
    }

    public void start() {
        serverURL = "jdbc:mysql://localhost:3306:nnhFarmer";
        proxoolURL = "proxool.gym:"+driver+":"+serverURL;
        settings = new Properties();
        settings.setProperty("proxool.maximum-connection-count", "25");
        settings.setProperty("proxool.minimum-connection-count", "3");
        settings.setProperty("proxool.maximum-connection-lifetime", Integer.toString((int)(86400000 * 0.5)));
        settings.setProperty("user", "root");
        settings.setProperty("password", "root");
    }

    public void restart() {
        // Kill off pool.
        destroy();
        // Start a new pool.
        start();
    }

    public void destroy() {
        // Shutdown the database.
/*        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement("SHUTDOWN");
            pstmt.execute();
        }
        catch (SQLException sqle) {
        	sqle.printStackTrace();
            logger.error(sqle.getMessage(), sqle);
        }
        finally {
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
*/        // Blank out the settings
        settings = null;
    }

    @Override
	public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }
}