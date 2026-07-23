package Controlador;

import Conexion.Conexion;
import Modelo.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    // INSERTAR
    public boolean insertarPaciente(Paciente paciente) {

        String sql = "INSERT INTO paciente "
                + "(fecha_nacimiento, diagnostico, Usuarios_idUsuarios)"
                + " VALUES (?,?,?)";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setDate(1, paciente.getFecha_nacimiento());
            ps.setString(2, paciente.getDiagnostico());
            ps.setInt(3, paciente.getUsuariosIdUsuarios());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error insertar paciente: " + e.getMessage());

        }

        return false;

    }

    // CONSULTAR
    public Paciente consultarPaciente(int idPaciente) {

        String sql = "SELECT * FROM paciente WHERE idPaciente=?";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Paciente p = new Paciente();

                p.setIdPaciente(rs.getInt("idPaciente"));
                p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                p.setDiagnostico(rs.getString("diagnostico"));
                p.setUsuariosIdUsuarios(rs.getInt("Usuarios_idUsuarios"));

                return p;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return null;

    }

    // ACTUALIZAR
    public boolean actualizarPaciente(Paciente paciente) {

        String sql = "UPDATE paciente SET "
                + "fecha_nacimiento=?,"
                + "diagnostico=?,"
                + "Usuarios_idUsuarios=? "
                + "WHERE idPaciente=?";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setDate(1, paciente.getFecha_nacimiento());
            ps.setString(2, paciente.getDiagnostico());
            ps.setInt(3, paciente.getUsuariosIdUsuarios());
            ps.setInt(4, paciente.getIdPaciente());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    // ELIMINAR
    public boolean eliminarPaciente(int idPaciente) {

        String sql = "DELETE FROM paciente WHERE idPaciente=?";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, idPaciente);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    // CONTAR
    public int contarPacientes() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM paciente";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {

                total = rs.getInt(1);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return total;

    }

    // LISTAR
    public List<Paciente> listarPacientes() {

        List<Paciente> lista = new ArrayList<>();

        String sql = "SELECT * FROM paciente";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Paciente p = new Paciente();

                p.setIdPaciente(rs.getInt("idPaciente"));
                p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                p.setDiagnostico(rs.getString("diagnostico"));
                p.setUsuariosIdUsuarios(rs.getInt("Usuarios_idUsuarios"));

                lista.add(p);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return lista;

    }

}