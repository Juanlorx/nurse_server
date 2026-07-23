<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>NURSE Dashboard</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Ccs/Style_Panel.css">

</head>

<body>

<div class="dashboard">

    <!-- SIDEBAR -->

    <aside class="sidebar">

        <div class="logo-section">

            <img src="${pageContext.request.contextPath}/Img/Nurse Logo.png"
                 alt="Logo">

            <h2>NURSE</h2>

        </div>

        <ul class="menu">

            <li class="active">

                <a href="${pageContext.request.contextPath}/Dashboard">

                    Dashboard

                </a>

            </li>

            <li>

                <a href="${pageContext.request.contextPath}/Tabla_Usuarios">

                    Usuarios

                </a>

            </li>

            <li>

                <a href="${pageContext.request.contextPath}/Tabla_Pacientes">

                    Pacientes

                </a>

            </li>

            <li>

                <a href="${pageContext.request.contextPath}/Tabla_Enfermeras">

                    Enfermeras

                </a>

            </li>

            <li>

                <a href="${pageContext.request.contextPath}/Tabla_Medicamentos">

                    Medicamentos

                </a>

            </li>

            <li>

                <a href="${pageContext.request.contextPath}/Tabla_Tratamiento">

                    Tratamientos

                </a>

            </li>

            <li>

                <a href="${pageContext.request.contextPath}/Tabla_Horarios">

                    Horarios

                </a>

            </li>

            <li>

                <a href="${pageContext.request.contextPath}/Tabla_Atencion">

                    Atenciones

                </a>

            </li>

            <li>

                <a href="${pageContext.request.contextPath}/Tabla_Notificacion">

                    Notificaciones

                </a>

            </li>

        </ul>

    </aside>

    <!-- MAIN -->

    <main class="main-content">

        <div class="topbar">

            <div>

                <h1>Bienvenido a NURSE</h1>

                <p>
                    Sistema de gestión y administración médica
                </p>

            </div>

            <div class="date-box">

                📅 Dashboard General

            </div>

        </div>

        <!-- TARJETAS SUPERIORES -->

        <section class="stats">

            <div class="stat-card">

                <h4>Usuarios</h4>

                <h2>${totalUsuarios}</h2>

            </div>

            <div class="stat-card">

                <h4>Pacientes</h4>

                <h2>${totalPacientes}</h2>

            </div>

            <div class="stat-card">

                <h4>Enfermeras</h4>

                <h2>${totalEnfermeras}</h2>

            </div>

            <div class="stat-card">

                <h4>Medicamentos</h4>

                <h2>${totalMedicamentos}</h2>

            </div>

        </section>

        <!-- MODULOS -->

        <section class="cards">

            <div class="card">

                <h2>Usuarios</h2>

                <p>${totalUsuarios} registros</p>

                <a href="../Vista/Tabla_Usuarios.jsp">

                    Administrar

                </a>

            </div>

            <div class="card">

                <h2>Pacientes</h2>

                <p>${totalPacientes} registros</p>

                <a href="../Vista/Tabla_Pacientes.jsp">

                    Administrar

                </a>

            </div>

            <div class="card">

                <h2>Enfermeras</h2>

                <p>${totalEnfermeras} registros</p>

                <a href="../Vista/Tabla_Enfermeras.jsp">

                    Administrar

                </a>

            </div>

            <div class="card">

                <h2>Medicamentos</h2>

                <p>${totalMedicamentos} registros</p>

                <a href="../Vista/Tabla_Medicamentos.jsp">

                    Administrar

                </a>

            </div>

            <div class="card">

                <h2>Tratamientos</h2>

                <p>${totalTratamientos} registros</p>

                <a href="${pageContext.request.contextPath}/Tabla_Tratamiento">

                    Administrar

                </a>

            </div>

            <div class="card">

                <h2>Horarios</h2>

                <p>${totalHorarios} registros</p>

                <a href="${pageContext.request.contextPath}/Tabla_Horarios">

                    Administrar

                </a>

            </div>

            <div class="card">

                <h2>Atenciones</h2>

                <p>${totalAtenciones} registros</p>

                <a href="${pageContext.request.contextPath}/Tabla_Atencion">

                    Administrar

                </a>

            </div>

            <div class="card">

                <h2>Notificaciones</h2>

                <p>${totalNotificaciones} registros</p>

                <a href="${pageContext.request.contextPath}/Tabla_Notificacion">

                    Administrar

                </a>

            </div>

            <div class="card">

                <h2>Roles</h2>

                <p>${totalRoles} registros</p>

                <a href="${pageContext.request.contextPath}/Tabla_Roles">

                    Administrar

                </a>

            </div>

        </section>

    </main>

</div>

</body>

</html>
