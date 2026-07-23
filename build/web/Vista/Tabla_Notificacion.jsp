<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CRUD Notificaciones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">
</head>
<body>
<div class="contenedor">
    <div class="acciones-superiores">
        <a href="${pageContext.request.contextPath}/Dashboard">Volver al Dashboard</a>
    </div>

    <h2>Gestion de Notificaciones</h2>
    <p class="contador">Total notificaciones: ${totalNotificaciones}</p>

    <form action="${pageContext.request.contextPath}/Tabla_Notificacion" method="post" class="formulario">
        <input type="hidden" name="accion" value="${registroEditar != null ? 'actualizar' : 'insertar'}">
        <input type="number" name="id" placeholder="ID notificacion" value="${registroEditar.id_Notificacion}" ${registroEditar != null ? 'readonly' : ''} required>
        <input type="text" name="informacion" placeholder="Informacion" value="${registroEditar.informacion}" required>
        <button type="submit">${registroEditar != null ? 'Actualizar' : 'Guardar'}</button>
        <c:if test="${registroEditar != null}">
            <a class="boton-secundario" href="${pageContext.request.contextPath}/Tabla_Notificacion">Cancelar</a>
        </c:if>
    </form>

    <table class="tabla">
        <thead>
            <tr>
                <th>ID</th>
                <th>Informacion</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="n" items="${listaNotificaciones}">
                <tr>
                    <td>${n.id_Notificacion}</td>
                    <td>${n.informacion}</td>
                    <td class="acciones-tabla">
                        <a href="${pageContext.request.contextPath}/Tabla_Notificacion?accion=editar&id=${n.id_Notificacion}">Editar</a>
                        <a href="${pageContext.request.contextPath}/Tabla_Notificacion?accion=eliminar&id=${n.id_Notificacion}" onclick="return confirm('Desea eliminar esta notificacion?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
