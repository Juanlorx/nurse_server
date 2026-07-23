<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CRUD Horarios</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">
</head>
<body>
<div class="contenedor">
    <div class="acciones-superiores">
        <a href="${pageContext.request.contextPath}/Dashboard">Volver al Dashboard</a>
    </div>

    <h2>Gestion de Horarios</h2>
    <p class="contador">Total horarios: ${totalHorarios}</p>

    <form action="${pageContext.request.contextPath}/Tabla_Horarios" method="post" class="formulario">
        <input type="hidden" name="accion" value="${registroEditar != null ? 'actualizar' : 'insertar'}">
        <input type="number" name="id" placeholder="ID horario" value="${registroEditar.id_Horarios}" ${registroEditar != null ? 'readonly' : ''} required>
        <input type="date" name="fecha" placeholder="Fecha" value="${registroEditar.fecha}" required>
        <input type="time" name="hora_inicial" placeholder="Hora inicial" value="${registroEditar.hora_inicial}" required>
        <input type="time" name="hora_final" placeholder="Hora final" value="${registroEditar.hora_final}" required>
        <button type="submit">${registroEditar != null ? 'Actualizar' : 'Guardar'}</button>
        <c:if test="${registroEditar != null}">
            <a class="boton-secundario" href="${pageContext.request.contextPath}/Tabla_Horarios">Cancelar</a>
        </c:if>
    </form>

    <table class="tabla">
        <thead>
            <tr>
                <th>ID</th>
                <th>Fecha</th>
                <th>Hora inicial</th>
                <th>Hora final</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="h" items="${listaHorarios}">
                <tr>
                    <td>${h.id_Horarios}</td>
                    <td>${h.fecha}</td>
                    <td>${h.hora_inicial}</td>
                    <td>${h.hora_final}</td>
                    <td class="acciones-tabla">
                        <a href="${pageContext.request.contextPath}/Tabla_Horarios?accion=editar&id=${h.id_Horarios}">Editar</a>
                        <a href="${pageContext.request.contextPath}/Tabla_Horarios?accion=eliminar&id=${h.id_Horarios}" onclick="return confirm('Desea eliminar este horario?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
