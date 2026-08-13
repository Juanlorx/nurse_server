<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CRUD Atenciones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">
</head>

<body>

<div class="contenedor">

    <div class="acciones-superiores">
        <a href="${pageContext.request.contextPath}/Dashboard">
            Volver al Dashboard
        </a>
    </div>

    <h2>Gestión de Atenciones</h2>

    <p class="contador">
        Total atenciones: ${totalAtenciones}
    </p>

    <!-- FORMULARIO PARA INSERTAR / ACTUALIZAR -->
    <form action="${pageContext.request.contextPath}/Tabla_Atencion"
          method="post"
          class="formulario">

        <input type="hidden"
               name="accion"
               value="${registroEditar != null ? 'actualizar' : 'insertar'}">

        <input type="text"
               name="descripcion"
               placeholder="Descripción"
               value="${registroEditar != null ? registroEditar.descripcion : ''}"
               required>

        <button type="submit">
            ${registroEditar != null ? 'Actualizar' : 'Guardar'}
        </button>

        <c:if test="${registroEditar != null}">
            <a class="boton-secundario"
               href="${pageContext.request.contextPath}/Tabla_Atencion">
                Cancelar
            </a>
        </c:if>

    </form>


    <!-- TABLA DE ATENCIONES -->
    <table class="tabla">

        <thead>
            <tr>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
        </thead>

        <tbody>

            <c:forEach var="a" items="${listaAtenciones}">

                <tr>

                    <!-- NO SE MUESTRA EL ID -->
                    <td>
                        ${a.descripcion}
                    </td>

                    <td class="acciones-tabla">

                        <!-- ELIMINAR MEDIANTE POST -->
                        <form action="${pageContext.request.contextPath}/Tabla_Atencion"
                              method="post"
                              style="display:inline;"
                              onsubmit="return confirm('¿Desea eliminar esta atención?');">

                            <input type="hidden"
                                   name="accion"
                                   value="eliminar">

                            <input type="hidden"
                                   name="id"
                                   value="${a.id_atencion}">

                            <button type="submit">
                                Eliminar
                            </button>

                        </form>

                    </td>

                </tr>

            </c:forEach>

        </tbody>

    </table>

</div>

</body>
</html>
