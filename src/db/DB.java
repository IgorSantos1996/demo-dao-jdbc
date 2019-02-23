package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) { // conexão não criada, vamos criar
            try {
                Properties props = loadProperties(); // carrega minha properties
                String url = props.getProperty("dburl"); // pega a url la de db.properties
                connection = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }

        return connection; // conexão ja criada
    }

    public static void closeConnection() {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }


    // criar métodos para carregar as informações da minha conexão em db.properties
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            // o load() faz a leitura do arquivo  db.properties apontando
            //pelo meu inputstream fs e vai guardar os dados dentro do objeto props
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) { // ou seja, se o resultset não está fechado
            try {
                rs.close(); // fecho
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
