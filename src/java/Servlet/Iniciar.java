package Servlet;

import Controlador.UsuariosDAO;
import Modelo.Usuarios;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Iniciar")
public class Iniciar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("txtUsuario");
String password = request.getParameter("txtPassword");
String rethus = request.getParameter("txtRethus");
        int rol = Integer.parseInt(request.getParameter("txtRol"));

        UsuariosDAO dao = new UsuariosDAO();

        Usuarios usuario = dao.consultarUsuarioCorreo(correo);

        // Usuario no existe
       if (usuario == null) {

    request.setAttribute("mensaje",
            "Usuario no registrado");

    request.getRequestDispatcher("/Index.jsp")
           .forward(request, response);

    return;
}
         if (!usuario.getClave().equals(rethus)) {

    request.setAttribute("mensaje",
            "Rethus incorrecto");

    request.getRequestDispatcher("/Index.jsp")
           .forward(request, response);

    return;
}

        // Contraseña incorrecta
       if (!usuario.getClave().equals(password)) {

    request.setAttribute("mensaje",
            "Contraseña incorrecta");

    request.getRequestDispatcher("/Index.jsp")
           .forward(request, response);

    return;
}

        // Rol incorrecto
       if (usuario.getRoles_idRoles() != rol) {

    request.setAttribute("mensaje",
            "El rol seleccionado no corresponde al usuario");

    request.getRequestDispatcher("/Index.jsp")
           .forward(request, response);

    return;
}
        // ADMINISTRADOR
        if (rol == 1) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/Vista/Panel.jsp");
        }

        // USUARIO
        else if (rol == 2) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/Vista/Menu.jsp");
        }
    }
}