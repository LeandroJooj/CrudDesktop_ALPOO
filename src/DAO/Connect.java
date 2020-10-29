package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author george
 */
public class Connect {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    public static Connection GetConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            
            connection = DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("erro na conexão", ex);
        }
        
        return connection;
    }
    

    public static void fechar(Connection connection)  {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.print("Não foi possivel desconectar ao banco de dados");
        }
    }
    

    public static void fechar(Connection connection,
            Statement statement)  {
        try {
            connection.close();
        } catch (SQLException ex) {
                    System.err.print("Não foi possivel desconectar ao banco de dados");
        } 
        catch(NullPointerException e){
            e.printStackTrace();
            System.err.print("nao ");
        }
        finally {
            Connect.fechar(connection);
        }
    }

    public static void fechar(Connection connection,Statement statement,ResultSet resultSet) {
        try {
            connection.close();
        } catch (SQLException ex) {
              System.err.print("Não foi possivel desconectar ao banco de dados");
        } finally {
            Connect.fechar(connection, statement);
        }
    }
}
