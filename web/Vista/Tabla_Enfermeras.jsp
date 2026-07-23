<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CRUD Enfermeras</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">
</head>
<body>
<div class="contenedor">
    <div class="acciones-superiores">
        <a href="${pageContext.request.contextPath}/Dashboard">Volver al Dashboard</a>
    </div>

    <h2>Gestion de Enfermeras</h2>
    <p class="contador">Total enfermeras: ${totalEnfermeras}</p>

    <form action="${pageContext.request.contextPath}/Tabla_Enfermeras" method="post" class="formulario">
        <input type="hidden" name="accion" value="${registroEditar != null ? 'actualizar' : 'insertar'}">
        <input type="number" name="id" placeholder="ID enfermera" value="${registroEditar.id_Enfermeras}" ${registroEditar != null ? 'readonly' : ''} required>
        <input type="text" name="rethus_enfermeras" placeholder="Rethus" value="${registroEditar.rethus_Enfermeras}" required>
        <button type="submit">${registroEditar != null ? 'Actualizar' : 'Guardar'}</button>
        <c:if test="${registroEditar != null}">
            <a class="boton-secundario" href="${pageContext.request.contextPath}/Tabla_Enfermeras">Cancelar</a>
        </c:if>
    </form>

    <table class="tabla">
        <thead>
            <tr>
                <th>ID</th>
                <th>Rethus</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="e" items="${listaEnfermeras}">
                <tr>
                    <td>${e.id_Enfermeras}</td>
                    <td>${e.rethus_Enfermeras}</td>
                    <td class="acciones-tabla">
                        <a href="${pageContext.request.contextPath}/Tabla_Enfermeras?accion=editar&id=${e.id_Enfermeras}">Editar</a>
                        <a href="${pageContext.request.contextPath}/Tabla_Enfermeras?accion=eliminar&id=${e.id_Enfermeras}" onclick="return confirm('Desea eliminar esta enfermera?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
