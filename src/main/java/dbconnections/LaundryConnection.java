package dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LaundryConnection {
    Connection connection;
    public boolean dbconnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laundry", "root","");
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public Connection getConnections() {
        return connection;
    }
}
