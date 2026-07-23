<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CRUD Tratamientos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">
</head>
<body>
<div class="contenedor">
    <div class="acciones-superiores">
        <a href="${pageContext.request.contextPath}/Dashboard">Volver al Dashboard</a>
    </div>

    <h2>Gestion de Tratamientos</h2>
    <p class="contador">Total tratamientos: ${totalTratamientos}</p>

    <form action="${pageContext.request.contextPath}/Tabla_Tratamiento" method="post" class="formulario">
        <input type="hidden" name="accion" value="${registroEditar != null ? 'actualizar' : 'insertar'}">
        <input type="number" name="id" placeholder="ID tratamiento" value="${registroEditar.id_Tratamiento}" ${registroEditar != null ? 'readonly' : ''} required>
        <input type="text" name="descripcion" placeholder="Descripcion" value="${registroEditar.descripcion}" required>
        <button type="submit">${registroEditar != null ? 'Actualizar' : 'Guardar'}</button>
        <c:if test="${registroEditar != null}">
            <a class="boton-secundario" href="${pageContext.request.contextPath}/Tabla_Tratamiento">Cancelar</a>
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
            <c:forEach var="t" items="${listaTratamientos}">
                <tr>
                    <td>${t.id_Tratamiento}</td>
                    <td>${t.descripcion}</td>
                    <td class="acciones-tabla">
                        <a href="${pageContext.request.contextPath}/Tabla_Tratamiento?accion=editar&id=${t.id_Tratamiento}">Editar</a>
                        <a href="${pageContext.request.contextPath}/Tabla_Tratamiento?accion=eliminar&id=${t.id_Tratamiento}" onclick="return confirm('Desea eliminar este tratamiento?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
