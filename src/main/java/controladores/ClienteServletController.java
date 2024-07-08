package controladores;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.ClienteDAO;
import entidades.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/clientes")
public class ClienteServletController extends HttpServlet {

    static Logger logger = LoggerFactory.getLogger(ClienteServletController.class);
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        logger.info("Action received: " + action);

        if ("getAll".equals(action)) {
            res.setContentType("application/json; charset=UTF-8");
            List<Cliente> clienteList = ClienteDAO.obtener();
            logger.info("Clientes obtenidos: " + clienteList.size());
            mapper.writeValue(res.getWriter(), clienteList);
        } else {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            logger.error("Invalid action parameter");
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String route = req.getParameter("action");
        logger.info("Dentro del doPost()");
        logger.info("route :" + route);

        switch (route) {
            case "add" -> {
                String id_usuario = req.getParameter("id_usuario");
                String activo = req.getParameter("activo");
                String nombre = req.getParameter("nombre");
                String apellido = req.getParameter("apellido");
                String dni = req.getParameter("dni");
                String fecha_de_nacimiento = req.getParameter("fecha_de_nacimiento");
                String telefono = req.getParameter("telefono");
                String domicilio = req.getParameter("domicilio");
                String localidad = req.getParameter("localidad");
                String cp = req.getParameter("cp");
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                String password2 = req.getParameter("password2");
                String rol = req.getParameter("rol");

                logger.info("Datos recibidos: id_usuario={}, nombre={}, apellido={}, dni={}", id_usuario, nombre, apellido, dni);

                Cliente cliente = new Cliente(id_usuario, activo, nombre, apellido, dni, fecha_de_nacimiento, telefono, domicilio, localidad, cp, email, password, password2, rol);
                
                
                ClienteDAO.guardar(cliente);

                res.setStatus(HttpServletResponse.SC_CREATED);
            }
            default -> {
                logger.error("Parámetro no válido");
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }
}
