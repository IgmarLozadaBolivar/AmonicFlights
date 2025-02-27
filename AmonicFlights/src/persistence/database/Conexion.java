package persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfEx) {
            System.out.println("Error no se encuentra la clase, más detalles: " + cnfEx.getMessage());
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/session1",
                    "root", "0000");
        } catch (SQLException sqlEx) {
            System.out.println("Error al conectar la base de datos, más detalles: " + sqlEx.getMessage());
        }

        return conn;
    }
}
