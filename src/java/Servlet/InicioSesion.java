package Servlet;

import Controlador.UsuariosDAO;
import Modelo.Usuarios;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String correo =
                request.getParameter("correo");

        String clave =
                request.getParameter("clave");

        String rethus =
                request.getParameter("rethus");

        int rol =
                Integer.parseInt(
                        request.getParameter("rol"));

        UsuariosDAO dao =
                new UsuariosDAO();

        Usuarios usuario =
                dao.consultarUsuarioCorreo(correo);

        if (usuario == null) {

            request.setAttribute(
                    "mensaje",
                    "El usuario no existe");

            request.getRequestDispatcher(
                    "Index.jsp")
                    .forward(request, response);

        } else if (!usuario.getClave().equals(clave)) {

            request.setAttribute(
                    "mensaje",
                    "Contraseña incorrecta");

            request.getRequestDispatcher(
                    "Index.jsp")
                    .forward(request, response);

        } else if (!usuario.getRethus().equals(rethus)) {

            request.setAttribute(
                    "mensaje",
                    "Número RETHUS incorrecto");

            request.getRequestDispatcher(
                    "Index.jsp")
                    .forward(request, response);

        } else if (usuario.getRoles_idRoles() != rol) {

            request.setAttribute(
                    "mensaje",
                    "El rol seleccionado no corresponde al usuario");

            request.getRequestDispatcher(
                    "Index.jsp")
                    .forward(request, response);

        } else {

            request.getSession()
                    .setAttribute(
                            "usuario",
                            usuario);

            if (usuario.getRoles_idRoles() == 1) {

                response.sendRedirect(
                        "Vista/Panel.jsp");

            } else if (usuario.getRoles_idRoles() == 2) {

                response.sendRedirect(
                        "WEB-INF/Menu.jsp");
            }
        }
    }
}