<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CRUD Usuarios</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">
</head>
<body>
<div class="contenedor">
    <div class="acciones-superiores">
        <a href="${pageContext.request.contextPath}/Dashboard">Volver al Dashboard</a>
    </div>

    <h2>Gestion de Usuarios</h2>
    <p class="contador">Total usuarios: ${totalUsuarios}</p>

    <form action="${pageContext.request.contextPath}/Tabla_Usuarios" method="post" class="formulario">
        <c:choose>
            <c:when test="${registroEditar != null}">
                <input type="hidden" name="accion" value="actualizar">
                <input type="hidden" name="id" value="${registroEditar.id_Usuarios}">
            </c:when>
            <c:otherwise>
                <input type="hidden" name="accion" value="insertar">
            </c:otherwise>
        </c:choose>

        <input type="text" name="nombres" placeholder="Nombres" value="${registroEditar.nombres}" required>
        <input type="text" name="apellidos" placeholder="Apellidos" value="${registroEditar.apellidos}" required>
        <input type="text" name="identificacion" placeholder="Identificacion" value="${registroEditar.identificacion}" required>
        <input type="text" name="telefono" placeholder="Telefono" value="${registroEditar.telefono}" required>
        <input type="text" name="direccion" placeholder="Direccion" value="${registroEditar.direccion}" required>
        <input type="email" name="correo" placeholder="Correo" value="${registroEditar.correo}" required>
        <input type="password" name="clave" placeholder="Clave" value="${registroEditar.clave}" required>
        <input type="text" name="rethus" placeholder="Rethus" value="${registroEditar.rethus}" required>
        <input type="number" name="roles_idRoles" placeholder="ID rol" value="${registroEditar.roles_idRoles}" required>

        <button type="submit">${registroEditar != null ? 'Actualizar' : 'Guardar'}</button>
        <c:if test="${registroEditar != null}">
            <a class="boton-secundario" href="${pageContext.request.contextPath}/Tabla_Usuarios">Cancelar</a>
        </c:if>
    </form>

    <table class="tabla">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Identificacion</th>
                <th>Telefono</th>
                <th>Direccion</th>
                <th>Correo</th>
                <th>Rethus</th>
                <th>Rol</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${listaUsuarios}">
                <tr>
                    <td>${u.id_Usuarios}</td>
                    <td>${u.nombres}</td>
                    <td>${u.apellidos}</td>
                    <td>${u.identificacion}</td>
                    <td>${u.telefono}</td>
                    <td>${u.direccion}</td>
                    <td>${u.correo}</td>
                    <td>${u.rethus}</td>
                    <td>${u.roles_idRoles}</td>
                    <td class="acciones-tabla">
                        <a href="${pageContext.request.contextPath}/Tabla_Usuarios?accion=editar&id=${u.id_Usuarios}">Editar</a>
                        <a href="${pageContext.request.contextPath}/Tabla_Usuarios?accion=eliminar&id=${u.id_Usuarios}" onclick="return confirm('Desea eliminar este usuario?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
