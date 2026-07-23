package Servlet;

import Controlador.AtencionDAO;
import Controlador.EnfermerasDAO;
import Controlador.HorariosDAO;
import Controlador.MedicamentoDAO;
import Controlador.NotificacionDAO;
import Controlador.PacienteDAO;
import Controlador.RolesDAO;
import Controlador.TratamientoDAO;
import Controlador.UsuariosDAO;
import Modelo.Atencion;
import Modelo.Enfermeras;
import Modelo.Horarios;
import Modelo.Medicamento;
import Modelo.Notificacion;
import Modelo.Paciente;
import Modelo.Roles;
import Modelo.Tratamiento;
import Modelo.Usuarios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet(urlPatterns = {
    "/Tabla_Usuarios",
    "/Tabla_Pacientes",
    "/Tabla_Enfermeras",
    "/Tabla_Medicamentos",
    "/Tabla_Tratamiento",
    "/Tabla_Horarios",
    "/Tabla_Atencion",
    "/Tabla_Notificacion",
    "/Tabla_Roles"
})
public class Tabla_Usuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String modulo = obtenerModulo(request);
        String accion = valor(request, "accion");

        if ("eliminar".equals(accion)) {
            eliminar(modulo, entero(request, "id"));
            response.sendRedirect(request.getContextPath() + "/" + obtenerRuta(modulo));
            return;
        }

        if ("editar".equals(accion) || "consultar".equals(accion)) {
            cargarRegistro(request, modulo, entero(request, "id"));
        }

        cargarListas(request);
        request.getRequestDispatcher("/Vista/" + obtenerVista(modulo)).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String modulo = obtenerModulo(request);
        String accion = valor(request, "accion");

        if ("actualizar".equals(accion)) {
            actualizar(request, modulo);
        } else {
            insertar(request, modulo);
        }

        response.sendRedirect(request.getContextPath() + "/" + obtenerRuta(modulo));
    }

    private void cargarListas(HttpServletRequest request) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();
        EnfermerasDAO enfermerasDAO = new EnfermerasDAO();
        MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
        TratamientoDAO tratamientoDAO = new TratamientoDAO();
        HorariosDAO horariosDAO = new HorariosDAO();
        AtencionDAO atencionDAO = new AtencionDAO();
        NotificacionDAO notificacionDAO = new NotificacionDAO();
        RolesDAO rolesDAO = new RolesDAO();

        request.setAttribute("listaUsuarios", usuariosDAO.listarUsuarios());
        request.setAttribute("listaPacientes", pacienteDAO.listarPacientes());
        request.setAttribute("listaEnfermeras", enfermerasDAO.listarEnfermeras());
        request.setAttribute("listaMedicamentos", medicamentoDAO.listarMedicamentos());
        request.setAttribute("listaTratamientos", tratamientoDAO.listarTratamientos());
        request.setAttribute("listaHorarios", horariosDAO.listarHorarios());
        request.setAttribute("listaAtenciones", atencionDAO.listarAtenciones());
        request.setAttribute("listaNotificaciones", notificacionDAO.listarNotificaciones());
        request.setAttribute("listaRoles", rolesDAO.listarRoles());

        request.setAttribute("totalUsuarios", usuariosDAO.contarUsuarios());
        request.setAttribute("totalPacientes", pacienteDAO.contarPacientes());
        request.setAttribute("totalEnfermeras", enfermerasDAO.contarEnfermeras());
        request.setAttribute("totalMedicamentos", medicamentoDAO.contarMedicamentos());
        request.setAttribute("totalTratamientos", tratamientoDAO.contarTratamientos());
        request.setAttribute("totalHorarios", horariosDAO.contarHorarios());
        request.setAttribute("totalAtenciones", atencionDAO.contarAtenciones());
        request.setAttribute("totalNotificaciones", notificacionDAO.contarNotificaciones());
        request.setAttribute("totalRoles", rolesDAO.contarRoles());
    }

    private void cargarRegistro(HttpServletRequest request, String modulo, int id) {
        switch (modulo) {
            case "usuarios":
                request.setAttribute("registroEditar", new UsuariosDAO().consultarUsuario(id));
                break;
            case "pacientes":
                request.setAttribute("registroEditar", new PacienteDAO().consultarPaciente(id));
                break;
            case "enfermeras":
                request.setAttribute("registroEditar", new EnfermerasDAO().consultarEnfermeras(id));
                break;
            case "medicamentos":
                request.setAttribute("registroEditar", new MedicamentoDAO().consultarMedicamento(id));
                break;
            case "tratamientos":
                request.setAttribute("registroEditar", new TratamientoDAO().consultarTratamiento(id));
                break;
            case "horarios":
                request.setAttribute("registroEditar", new HorariosDAO().consultarHorario(id));
                break;
            case "atenciones":
                request.setAttribute("registroEditar", new AtencionDAO().consultarAtencion(id));
                break;
            case "notificaciones":
                request.setAttribute("registroEditar", new NotificacionDAO().consultarNotificacion(id));
                break;
            case "roles":
                request.setAttribute("registroEditar", new RolesDAO().consultarRol(id));
                break;
            default:
                break;
        }
    }

    private void insertar(HttpServletRequest request, String modulo) {
        switch (modulo) {
            case "usuarios":
                new UsuariosDAO().insertarUsuario(usuarioDesdeRequest(request, false));
                break;
            case "pacientes":
                new PacienteDAO().insertarPaciente(pacienteDesdeRequest(request));
                break;
            case "enfermeras":
                new EnfermerasDAO().insertarEnfermeras(enfermeraDesdeRequest(request));
                break;
            case "medicamentos":
                new MedicamentoDAO().insertarMedicamento(medicamentoDesdeRequest(request));
                break;
            case "tratamientos":
                new TratamientoDAO().insertarTratamiento(tratamientoDesdeRequest(request));
                break;
            case "horarios":
                new HorariosDAO().insertarHorario(horarioDesdeRequest(request));
                break;
            case "atenciones":
                new AtencionDAO().insertarAtencion(atencionDesdeRequest(request));
                break;
            case "notificaciones":
                new NotificacionDAO().insertarNotificacion(notificacionDesdeRequest(request));
                break;
            case "roles":
                new RolesDAO().insertarRol(rolDesdeRequest(request));
                break;
            default:
                break;
        }
    }

    private void actualizar(HttpServletRequest request, String modulo) {
        switch (modulo) {
            case "usuarios":
                new UsuariosDAO().actualizarUsuario(usuarioDesdeRequest(request, true));
                break;
            case "pacientes":
                new PacienteDAO().actualizarPaciente(pacienteDesdeRequest(request));
                break;
            case "enfermeras":
                new EnfermerasDAO().actualizarEnfermeras(enfermeraDesdeRequest(request));
                break;
            case "medicamentos":
                new MedicamentoDAO().actualizarMedicamento(medicamentoDesdeRequest(request));
                break;
            case "tratamientos":
                new TratamientoDAO().actualizarTratamiento(tratamientoDesdeRequest(request));
                break;
            case "horarios":
                new HorariosDAO().actualizarHorario(horarioDesdeRequest(request));
                break;
            case "atenciones":
                new AtencionDAO().actualizarAtencion(atencionDesdeRequest(request));
                break;
            case "notificaciones":
                new NotificacionDAO().actualizarNotificacion(notificacionDesdeRequest(request));
                break;
            case "roles":
                new RolesDAO().actualizarRol(rolDesdeRequest(request));
                break;
            default:
                break;
        }
    }

    private void eliminar(String modulo, int id) {
        switch (modulo) {
            case "usuarios":
                new UsuariosDAO().eliminarUsuario(id);
                break;
            case "pacientes":
                new PacienteDAO().eliminarPaciente(id);
                break;
            case "enfermeras":
                new EnfermerasDAO().eliminarEnfermeras(id);
                break;
            case "medicamentos":
                new MedicamentoDAO().eliminarMedicamento(id);
                break;
            case "tratamientos":
                new TratamientoDAO().eliminarTratamiento(id);
                break;
            case "horarios":
                new HorariosDAO().eliminarHorario(id);
                break;
            case "atenciones":
                new AtencionDAO().eliminarAtencion(id);
                break;
            case "notificaciones":
                new NotificacionDAO().eliminarNotificacion(id);
                break;
            case "roles":
                new RolesDAO().eliminarRol(id);
                break;
            default:
                break;
        }
    }

    private Usuarios usuarioDesdeRequest(HttpServletRequest request, boolean incluirId) {
        Usuarios usuario = new Usuarios();
        if (incluirId) {
            usuario.setid_Usuarios(entero(request, "id"));
        }
        usuario.setNombres(valor(request, "nombres"));
        usuario.setApellidos(valor(request, "apellidos"));
        usuario.setIdentificacion(valor(request, "identificacion"));
        usuario.setTelefono(valor(request, "telefono"));
        usuario.setDireccion(valor(request, "direccion"));
        usuario.setCorreo(valor(request, "correo"));
        usuario.setClave(valor(request, "clave"));
        usuario.setRethus(valor(request, "rethus"));
        usuario.setRoles_idRoles(entero(request, "roles_idRoles"));
        return usuario;
    }

    private Paciente pacienteDesdeRequest(HttpServletRequest request) {
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(entero(request, "id"));
        paciente.setFecha_nacimiento(Date.valueOf(valor(request, "fecha_nacimiento")));
        paciente.setDiagnostico(valor(request, "diagnostico"));
        return paciente;
    }

    private Enfermeras enfermeraDesdeRequest(HttpServletRequest request) {
        Enfermeras enfermera = new Enfermeras();
        enfermera.setid_Enfermeras(entero(request, "id"));
        enfermera.setRethus_Enfermeras(valor(request, "rethus_enfermeras"));
        return enfermera;
    }

    private Medicamento medicamentoDesdeRequest(HttpServletRequest request) {
        Medicamento medicamento = new Medicamento();
        medicamento.setid_Medicamento(entero(request, "id"));
        medicamento.setNombre(valor(request, "nombre"));
        return medicamento;
    }

    private Tratamiento tratamientoDesdeRequest(HttpServletRequest request) {
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setid_Tratamiento(entero(request, "id"));
        tratamiento.setDescripcion(valor(request, "descripcion"));
        return tratamiento;
    }

    private Horarios horarioDesdeRequest(HttpServletRequest request) {
        Horarios horario = new Horarios();
        horario.setid_Horarios(entero(request, "id"));
        horario.setFecha(Date.valueOf(valor(request, "fecha")));
        horario.setHora_inicial(hora(request, "hora_inicial"));
        horario.setHora_final(hora(request, "hora_final"));
        return horario;
    }

    private Atencion atencionDesdeRequest(HttpServletRequest request) {
        Atencion atencion = new Atencion();
        atencion.setid_atencion(entero(request, "id"));
        atencion.setDescripcion(valor(request, "descripcion"));
        return atencion;
    }

    private Notificacion notificacionDesdeRequest(HttpServletRequest request) {
        Notificacion notificacion = new Notificacion();
        notificacion.setid_Notificacion(entero(request, "id"));
        notificacion.setInformacion(valor(request, "informacion"));
        return notificacion;
    }

    private Roles rolDesdeRequest(HttpServletRequest request) {
        Roles rol = new Roles();
        rol.setIdRoles(entero(request, "id"));
        rol.setDescripcionatencion(valor(request, "descripcionatencion"));
        return rol;
    }

    private String obtenerModulo(HttpServletRequest request) {
        String path = request.getServletPath();
        if (path.endsWith("Pacientes")) {
            return "pacientes";
        }
        if (path.endsWith("Enfermeras")) {
            return "enfermeras";
        }
        if (path.endsWith("Medicamentos")) {
            return "medicamentos";
        }
        if (path.endsWith("Tratamiento")) {
            return "tratamientos";
        }
        if (path.endsWith("Horarios")) {
            return "horarios";
        }
        if (path.endsWith("Atencion")) {
            return "atenciones";
        }
        if (path.endsWith("Notificacion")) {
            return "notificaciones";
        }
        if (path.endsWith("Roles")) {
            return "roles";
        }
        return "usuarios";
    }

    private String obtenerRuta(String modulo) {
        switch (modulo) {
            case "pacientes":
                return "Tabla_Pacientes";
            case "enfermeras":
                return "Tabla_Enfermeras";
            case "medicamentos":
                return "Tabla_Medicamentos";
            case "tratamientos":
                return "Tabla_Tratamiento";
            case "horarios":
                return "Tabla_Horarios";
            case "atenciones":
                return "Tabla_Atencion";
            case "notificaciones":
                return "Tabla_Notificacion";
            case "roles":
                return "Tabla_Roles";
            default:
                return "Tabla_Usuarios";
        }
    }

    private String obtenerVista(String modulo) {
        return obtenerRuta(modulo) + ".jsp";
    }

    private String valor(HttpServletRequest request, String nombre) {
        String valor = request.getParameter(nombre);
        return valor == null ? "" : valor.trim();
    }

    private int entero(HttpServletRequest request, String nombre) {
        String valor = valor(request, nombre);
        return valor.isEmpty() ? 0 : Integer.parseInt(valor);
    }

    private Time hora(HttpServletRequest request, String nombre) {
        String valor = valor(request, nombre);
        if (valor.length() == 5) {
            valor += ":00";
        }
        return Time.valueOf(valor);
    }
}
