package Servlet;

import Controlador.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // CONTADORES

        request.setAttribute(
                "totalUsuarios",
                new UsuariosDAO().contarUsuarios());

        request.setAttribute(
                "totalPacientes",
                new PacienteDAO().contarPacientes());

        request.setAttribute(
                "totalEnfermeras",
                new EnfermerasDAO().contarEnfermeras());

        request.setAttribute(
                "totalMedicamentos",
                new MedicamentoDAO().contarMedicamentos());

        request.setAttribute(
                "totalTratamientos",
                new TratamientoDAO().contarTratamientos());

        request.setAttribute(
                "totalHorarios",
                new HorariosDAO().contarHorarios());

        request.setAttribute(
                "totalAtenciones",
                new AtencionDAO().contarAtenciones());

        request.setAttribute(
                "totalNotificaciones",
                new NotificacionDAO().contarNotificaciones());

        request.setAttribute(
                "totalRoles",
                new RolesDAO().contarRoles());

        // LISTAS

        request.setAttribute(
                "listaUsuarios",
                new UsuariosDAO().listarUsuarios());

        request.setAttribute(
                "listaPacientes",
                new PacienteDAO().listarPacientes());

        request.setAttribute(
                "listaEnfermeras",
                new EnfermerasDAO().listarEnfermeras());

        request.setAttribute(
                "listaMedicamentos",
                new MedicamentoDAO().listarMedicamentos());

        request.setAttribute(
                "listaTratamientos",
                new TratamientoDAO().listarTratamientos());

        request.setAttribute(
                "listaHorarios",
                new HorariosDAO().listarHorarios());

        request.setAttribute(
                "listaAtenciones",
                new AtencionDAO().listarAtenciones());

        request.setAttribute(
                "listaNotificaciones",
                new NotificacionDAO().listarNotificaciones());

        request.setAttribute(
                "listaRoles",
                new RolesDAO().listarRoles());

        request.getRequestDispatcher(
                "/Vista/Panel.jsp")
                .forward(request, response);
    }
}
