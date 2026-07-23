<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CRUD Roles</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">
</head>
<body>
<div class="contenedor">
    <div class="acciones-superiores">
        <a href="${pageContext.request.contextPath}/Dashboard">Volver al Dashboard</a>
    </div>

    <h2>Gestion de Roles</h2>
    <p class="contador">Total roles: ${totalRoles}</p>

    <form action="${pageContext.request.contextPath}/Tabla_Roles" method="post" class="formulario">
        <input type="hidden" name="accion" value="${registroEditar != null ? 'actualizar' : 'insertar'}">
        <input type="number" name="id" placeholder="ID rol" value="${registroEditar.idRoles}" ${registroEditar != null ? 'readonly' : ''} required>
        <input type="text" name="descripcionatencion" placeholder="Descripcion" value="${registroEditar.descripcionatencion}" required>
        <button type="submit">${registroEditar != null ? 'Actualizar' : 'Guardar'}</button>
        <c:if test="${registroEditar != null}">
            <a class="boton-secundario" href="${pageContext.request.contextPath}/Tabla_Roles">Cancelar</a>
        </c:if>
    </form>

    <table class="tabla">
        <thead>
            <tr>
                <th>ID</th>
                <th>Descripcion</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="r" items="${listaRoles}">
                <tr>
                    <td>${r.idRoles}</td>
                    <td>${r.descripcionatencion}</td>
                    <td class="acciones-tabla">
                        <a href="${pageContext.request.contextPath}/Tabla_Roles?accion=editar&id=${r.idRoles}">Editar</a>
                        <a href="${pageContext.request.contextPath}/Tabla_Roles?accion=eliminar&id=${r.idRoles}" onclick="return confirm('Desea eliminar este rol?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
