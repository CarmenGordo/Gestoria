package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author carmen_gordo
 */
public class ConexionBD {

    public static Connection getConexion() throws SQLException {
        Properties properties = new Properties();
        String IP, PORT, BBDD, USER, PWD;
        
        try {
            InputStream input_ip = new FileInputStream("ip.properties");
            properties.load(input_ip);
            IP = (String) properties.get("IP");
        } catch (IOException e) {
            IP = "localhost";
        }
        
        try {
            InputStream input = ConexionBD.class.getClassLoader().getResourceAsStream("bbdd.properties");
            if (input == null) {
                throw new IOException("No se pudo cargar el archivo de propiedades.");
            }
            properties.load(input);
            PORT = (String) properties.get("PORT");
            BBDD = (String) properties.get("BBDD");
            USER = (String) properties.get("USER");
            PWD = (String) properties.get("PWD");
            
            String conexionUrl = "jdbc:mariadb://" + IP + ":" + PORT + "/" + BBDD;
            return DriverManager.getConnection(conexionUrl, USER, PWD);
            
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error de conexión con la base de datos.", e);
        }
    }

}