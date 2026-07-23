<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CRUD Medicamentos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">
</head>
<body>
<div class="contenedor">
    <div class="acciones-superiores">
        <a href="${pageContext.request.contextPath}/Dashboard">Volver al Dashboard</a>
    </div>

    <h2>Gestion de Medicamentos</h2>
    <p class="contador">Total medicamentos: ${totalMedicamentos}</p>

    <form action="${pageContext.request.contextPath}/Tabla_Medicamentos" method="post" class="formulario">
        <input type="hidden" name="accion" value="${registroEditar != null ? 'actualizar' : 'insertar'}">
        <input type="number" name="id" placeholder="ID medicamento" value="${registroEditar.id_Medicamento}" ${registroEditar != null ? 'readonly' : ''} required>
        <input type="text" name="nombre" placeholder="Nombre" value="${registroEditar.nombre}" required>
        <button type="submit">${registroEditar != null ? 'Actualizar' : 'Guardar'}</button>
        <c:if test="${registroEditar != null}">
            <a class="boton-secundario" href="${pageContext.request.contextPath}/Tabla_Medicamentos">Cancelar</a>
        </c:if>
    </form>

    <table class="tabla">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="m" items="${listaMedicamentos}">
                <tr>
                    <td>${m.id_Medicamento}</td>
                    <td>${m.nombre}</td>
                    <td class="acciones-tabla">
                        <a href="${pageContext.request.contextPath}/Tabla_Medicamentos?accion=editar&id=${m.id_Medicamento}">Editar</a>
                        <a href="${pageContext.request.contextPath}/Tabla_Medicamentos?accion=eliminar&id=${m.id_Medicamento}" onclick="return confirm('Desea eliminar este medicamento?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
