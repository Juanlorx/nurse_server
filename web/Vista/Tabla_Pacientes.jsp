<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>CRUD Pacientes</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Ccs/Style_Tablas.css">

</head>

<body>

<div class="contenedor">

    <div class="acciones-superiores">

        <a href="${pageContext.request.contextPath}/Dashboard">

            Volver al Dashboard

        </a>

    </div>

    <h2>

        Gestión de Pacientes

    </h2>

    <p class="contador">

        Total pacientes: ${totalPacientes}

    </p>

    <form action="${pageContext.request.contextPath}/Tabla_Pacientes"
          method="post"
          class="formulario">

        <input
            type="hidden"
            name="accion"
            value="${registroEditar != null ? 'actualizar' : 'insertar'}">

        <input
            type="hidden"
            name="id"
            value="${registroEditar.idPaciente}">

        <input
            type="date"
            name="fecha_nacimiento"
            value="${registroEditar.fecha_nacimiento}"
            required>

        <input
            type="text"
            name="diagnostico"
            placeholder="Diagnóstico"
            value="${registroEditar.diagnostico}"
            required>

        <input
            type="number"
            name="usuario"
            placeholder="ID Usuario"
            value="${registroEditar.usuariosIdUsuarios}"
            required>

        <button type="submit">

            ${registroEditar != null ? 'Actualizar' : 'Guardar'}

        </button>

        <c:if test="${registroEditar != null}">

            <a class="boton-secundario"
               href="${pageContext.request.contextPath}/Tabla_Pacientes">

                Cancelar

            </a>

        </c:if>

    </form>

    <table class="tabla">

        <thead>

        <tr>

            <th>ID</th>

            <th>Fecha Nacimiento</th>

            <th>Diagnóstico</th>

            <th>ID Usuario</th>

            <th>Acciones</th>

        </tr>

        </thead>

        <tbody>

        <c:forEach var="p"
                   items="${listaPacientes}">

            <tr>

                <td>

                    ${p.idPaciente}

                </td>

                <td>

                    ${p.fecha_nacimiento}

                </td>

                <td>

                    ${p.diagnostico}

                </td>

                <td>

                    ${p.usuariosIdUsuarios}

                </td>

                <td class="acciones-tabla">

                    <a href="${pageContext.request.contextPath}/Tabla_Pacientes?accion=editar&id=${p.idPaciente}">

                        Editar

                    </a>

                    |

                    <a href="${pageContext.request.contextPath}/Tabla_Pacientes?accion=eliminar&id=${p.idPaciente}"
                       onclick="return confirm('¿Desea eliminar este paciente?')">

                        Eliminar

                    </a>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>

</div>

</body>

</html>