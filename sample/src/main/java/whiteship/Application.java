package whiteship;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://172.25.122.22:5432/";
        String username = "postgres";
        String password = "1234";

        try(Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Connection created: " + connection);
            String sql = "INSERT INTO ACCOUNT VALUES(1, 'keesun', 'pass');";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
