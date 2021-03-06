/**
 *
 */
package creadorbd;

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
    private String user = "";
    private String pass = "";
    private String url = "jdbc:mysql://localhost/";

    private boolean estadoConexion = true;

    public Conexion(String usuarioX, String passX) {
        user = usuarioX;
        pass = passX;
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
        } catch (SQLException ex) {
            estadoConexion = false;
            JOptionPane.showMessageDialog(null, "usuario o contraseña incorrectos", "error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return con;
    }

    public Connection getConexionBD(String nombreBDX) {
        try {
            con = (Connection) DriverManager.getConnection(url.concat(nombreBDX), user, pass);
        } catch (SQLException ex) {
            estadoConexion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void desconectar() {
        try {
            con.close();
            System.out.println("se cerro");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public boolean getEstado() {
        return estadoConexion;
    }

}
