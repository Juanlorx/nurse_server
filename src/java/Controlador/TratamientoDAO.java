package Controlador;

import Conexion.Conexion;
import Modelo.Tratamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TratamientoDAO {
public List<Tratamiento> listarTratamientos() {

    List<Tratamiento> lista = new ArrayList<>();

    String sql = "SELECT * FROM tratamiento";

    try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
    ) {

        while (rs.next()) {

            Tratamiento t = new Tratamiento();

            t.setid_Tratamiento(
                    rs.getInt("id_tratamiento"));

            t.setDescripcion(
                    rs.getString("descripcion"));

            lista.add(t);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al listar tratamientos: "
                + e.getMessage());
    }

    return lista;
}
    // INSERTAR
    public boolean insertarTratamiento(Tratamiento tratamiento) {

        String sql = "INSERT INTO tratamiento (id_tratamiento, descripcion) VALUES (?, ?)";

        try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, tratamiento.getid_Tratamiento());
            ps.setString(2, tratamiento.getDescripcion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar tratamiento: " + e.getMessage());
            return false;
        }
    }

    // CONSULTAR
    public Tratamiento consultarTratamiento(int id_tratamiento) {

        String sql = "SELECT * FROM tratamiento WHERE id_tratamiento = ?";

        try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id_tratamiento);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Tratamiento tratamiento = new Tratamiento();

                tratamiento.setid_Tratamiento(rs.getInt("id_tratamiento"));
                tratamiento.setDescripcion(rs.getString("descripcion"));

                return tratamiento;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar tratamiento: " + e.getMessage());
        }

        return null;
    }

    // ACTUALIZAR
    public boolean actualizarTratamiento(Tratamiento tratamiento) {

        String sql = "UPDATE tratamiento SET descripcion = ? WHERE id_tratamiento = ?";

        try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, tratamiento.getDescripcion());
            ps.setInt(2, tratamiento.getid_Tratamiento());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar tratamiento: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminarTratamiento(int id_tratamiento) {

        String sql = "DELETE FROM tratamiento WHERE id_tratamiento = ?";

        try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id_tratamiento);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar tratamiento: " + e.getMessage());
            return false;
        }
    }
    public int contarTratamientos() {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM tratamiento";

    try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
    ) {

        if (rs.next()) {
            total = rs.getInt(1);
        }

    } catch (SQLException e) {
        System.out.println("Error al contar tratamientos: " + e.getMessage());
    }

    return total;
}
}
