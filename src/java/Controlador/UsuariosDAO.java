package Controlador;

import Conexion.Conexion;
import Modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    // INSERTAR
    public boolean insertarUsuario(Usuarios usuario) {

        String sql = "INSERT INTO usuarios "
        + "(nombres,apellidos,identificacion,telefono,direccion,correo,clave,Rethus,Roles_idRoles) "
        + "VALUES (?,?,?,?,?,?,?,?,?)";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, usuario.getNombres());
ps.setString(2, usuario.getApellidos());
ps.setString(3, usuario.getIdentificacion());
ps.setString(4, usuario.getTelefono());
ps.setString(5, usuario.getDireccion());
ps.setString(6, usuario.getCorreo());
ps.setString(7, usuario.getClave());
ps.setString(8, usuario.getRethus());
ps.setInt(9, usuario.getRoles_idRoles());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    // CONSULTAR POR CORREO
    public Usuarios consultarUsuarioCorreo(String correo) {

        String sql = "SELECT * FROM usuarios WHERE correo = ?";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Usuarios usuario = new Usuarios();

                usuario.setid_Usuarios(rs.getInt("idUsuarios"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setIdentificacion(rs.getString("identificacion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setRethus(rs.getString("Rethus"));
                usuario.setRoles_idRoles(rs.getInt("Roles_idRoles"));

                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar usuario por correo: " + e.getMessage());
        }

        return null;
    }

    // CONSULTAR POR ID
    public Usuarios consultarUsuario(int idUsuarios) {

        String sql = "SELECT * FROM usuarios WHERE idUsuarios = ?";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, idUsuarios);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Usuarios usuario = new Usuarios();

                usuario.setid_Usuarios(rs.getInt("idUsuarios"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setIdentificacion(rs.getString("identificacion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setRethus(rs.getString("Rethus"));
                usuario.setRoles_idRoles(rs.getInt("Roles_idRoles"));

                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e.getMessage());
        }

        return null;
    }

    // VALIDAR LOGIN
    public boolean validarIndex(String correo, String clave) {

        String sql = "SELECT * FROM usuarios WHERE correo=? AND clave=?";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, correo);
            ps.setString(2, clave);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {

            System.out.println("Error login: " + e.getMessage());

            return false;
        }
    }

    // ACTUALIZAR
    public boolean actualizarUsuario(Usuarios usuario) {

        String sql = "UPDATE usuarios SET "
                + "nombres=?, "
                + "apellidos=?, "
                + "identificacion=?, "
                + "telefono=?, "
                + "direccion=?, "
                + "correo=?, "
                + "clave=?, "
                + "Rethus=?, "
                + "Roles_idRoles=? "
                + "WHERE idUsuarios=?";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getIdentificacion());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getClave());
            ps.setString(8, usuario.getRethus());
            ps.setInt(9, usuario.getRoles_idRoles());
            ps.setInt(10, usuario.getid_Usuarios());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminarUsuario(int idUsuarios) {

        String sql = "DELETE FROM usuarios WHERE idUsuarios = ?";

        try (
                Connection con = new Conexion().getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, idUsuarios);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
        
    }
    // VERIFICAR SI EL CORREO YA EXISTE
public boolean existeCorreo(String correo) {

    String sql = "SELECT correo FROM usuarios WHERE correo = ?";

    try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
    ) {

        ps.setString(1, correo);

        ResultSet rs = ps.executeQuery();

        return rs.next();

    } catch (SQLException e) {

        System.out.println("Error verificando correo: "
                + e.getMessage());

        return false;
    }
}
    // LISTAR TODOS LOS USUARIOS
public List<Usuarios> listarUsuarios() {

    List<Usuarios> lista = new ArrayList<>();

    String sql = "SELECT * FROM usuarios";

    try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
    ) {

        while (rs.next()) {

            Usuarios usuario = new Usuarios();

            usuario.setid_Usuarios(rs.getInt("idUsuarios"));
            usuario.setNombres(rs.getString("nombres"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setIdentificacion(rs.getString("identificacion"));
            usuario.setTelefono(rs.getString("telefono"));
            usuario.setDireccion(rs.getString("direccion"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setClave(rs.getString("clave"));
            usuario.setRethus(rs.getString("Rethus"));
            usuario.setRoles_idRoles(rs.getInt("Roles_idRoles"));

            lista.add(usuario);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al listar usuarios: "
                + e.getMessage());
    }

    return lista;

}// CONTAR USUARIOS
public int contarUsuarios() {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM usuarios";

    try (
            Connection con = new Conexion().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
    ) {

        if (rs.next()) {
            total = rs.getInt(1);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al contar usuarios: "
                + e.getMessage());
    }

    return total;
}

    public List<Usuarios> listar() {
        return listarUsuarios();
    }
    
}
