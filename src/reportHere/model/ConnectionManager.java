package reportHere.model;

import java.sql.Connection;
import org.postgresql.ds.PGPoolingDataSource;

public class ConnectionManager {

    //INICIO SINGLETON
    private static ConnectionManager instance = null;

    private ConnectionManager() {
        source = new PGPoolingDataSource();
        source.setDataSourceName("ReportHereDataSource");
        source.setServerName("localhost");
        source.setPortNumber(5432);
        source.setDatabaseName("TESTEEEE");
        source.setUser("postgres");
        source.setPassword("fpssi");
        source.setMaxConnections(30);
        source.setInitialConnections(10);
     //   source.setTcpKeepAlive(true);
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }
    //FIM SINGLETON
    private PGPoolingDataSource source;

    public Connection getConnection() throws Exception {
        Connection conn = source.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }

}
