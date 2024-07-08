package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entidades.Cliente;
import static data.Conexion.getConexion;
import static data.Conexion.close;

public class ClienteDAO {

    private static final String SQL_SELECT = "SELECT * FROM cliente";

    // Constructor vacío, generalmente no es necesario para un DAO
    public ClienteDAO() {
        // TODO Auto-generated constructor stub
    }

    // Método estático para obtener todos los clientes de la base de datos
    public static List<Cliente> obtener() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = getConexion(); // Obtener conexión a la base de datos
            ps = conn.prepareStatement(SQL_SELECT); // Preparar la consulta SQL
            rs = ps.executeQuery(); // Ejecutar la consulta y obtener resultados

            // Iterar sobre los resultados del ResultSet
            while (rs.next()) {
                // Obtener cada atributo del cliente desde la base de datos
                String id_usuario = rs.getString("id_usuario");
                String activo = rs.getString("activo");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String fecha_de_nacimiento = rs.getString("fecha_de_nacimiento");
                String telefono = rs.getString("telefono");
                String domicilio = rs.getString("domicilio");
                String localidad = rs.getString("localidad");
                String cp = rs.getString("cp");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String password2 = rs.getString("password2");
                String rol = rs.getString("rol");

                // Crear un objeto Cliente con los datos obtenidos y agregarlo a la lista
                Cliente cliente = new Cliente(id_usuario, activo, nombre, apellido, dni, fecha_de_nacimiento, telefono, domicilio, localidad, cp, email, password, password2, rol);

                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprimir cualquier excepción ocurrida
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement y Connection) en un bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return clientes; // Devolver la lista de clientes obtenidos de la base de datos
    }

    // Método estático para guardar un cliente en la base de datos (a implementar según sea necesario)
    public static void guardar(Cliente cliente) {
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

}
