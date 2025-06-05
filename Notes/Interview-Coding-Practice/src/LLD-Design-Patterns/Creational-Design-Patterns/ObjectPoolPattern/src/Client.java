/*
                              +---------------------------+
                              |      Client (Main)        |
                              +---------------------------+
                                            |
                                            v
                              +---------------------------+
                              |   DBConnectionPoolManager |
                              +---------------------------+
                              | - freeConnectionsInPool   |
                              | - connectionsInUse        |
                              +---------------------------+
                                            |
                     +----------------------+---------------------+
                     |                                            |
                     v                                            v
          +---------------------------+                +---------------------------+
          |       DBConnection        |                |  DBConnectionPoolManager  |
          |    (Reusable Object)      |                |      (Singleton)          |
          +---------------------------+                +---------------------------+


### Has-A and Is-A Relationships:
- **DBConnection Is-A**: `DBConnection` is a connection object used to interact with the database.
- **DBConnectionPoolManager Has-A**: `DBConnectionPoolManager`has lists of  `DBConnection` objects for managing the connection pool.

*/

public class Client {
    public static void main(String[] args) {

        DBConnectionPoolManager poolManager = DBConnectionPoolManager.getInstance();

        DBConnection dbConnection1 = poolManager.getConnection();
        DBConnection dbConnection2 = poolManager.getConnection();
        DBConnection dbConnection3 = poolManager.getConnection();
        DBConnection dbConnection4 = poolManager.getConnection();
        DBConnection dbConnection5 = poolManager.getConnection();
        DBConnection dbConnection6 = poolManager.getConnection();

        poolManager.getConnection();
        poolManager.releaseConnection(dbConnection1);
    }
}