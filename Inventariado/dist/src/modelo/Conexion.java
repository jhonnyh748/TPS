/**
 *
 */
package modelo;

import java.sql.*;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author ~Antares~
 *
 */
public class Conexion {

    private PreparedStatement statement;
    private ResultSet result;

    private Connection con = null;
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost/inventarioManuelDoncel";

    private boolean estadoConexion = true;

    public Conexion() {
        //user = usuarioX;
        // pass = passX;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Registro exitoso del driver");

        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Registro fallido del driver");
        }
    }

    public Connection getConexionInicial() {
        try {
            con = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("\nse conecto conexion");
        } catch (SQLException ex) {
            estadoConexion = false;
            JOptionPane.showMessageDialog(null, "usuario o contraseña incorrectos", "error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return con;
    }

    public void desconectar() {
        try {
            con.close();
            System.out.println("se desconecto conexion\n");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public boolean getEstado() {
        return estadoConexion;
    }

}
