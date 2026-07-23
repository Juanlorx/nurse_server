<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Nurse - Inicio</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Ccs/Style_Menu.css">

</head>

<body>

<header class="header">

    <div class="logo">
        <img src="${pageContext.request.contextPath}/Img/Nurse Logo.png"
             alt="Logo">
    </div>

    <div class="header-menu">
        <nav>
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/Vista/Menu.jsp">Menu</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/Vista/Pacientes.jsp">Pacientes</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/Vista/Calendario.jsp">Calendario</a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="session-container">
        <a href="${pageContext.request.contextPath}/Index.jsp"
           class="Sesion">
            Sesión
        </a>
    </div>

</header>

<main class="contenido-principal">

    <!-- ? SECCIÓN CON CARRUSELES LATERALES -->
    <section class="seccion-visual">

        <!-- ? CARRUSEL PACIENTES -->
        <div class="carrusel-lateral">

            <h3>Gestión de Pacientes</h3>

            <div class="slider pacientes">

                <img src="${pageContext.request.contextPath}/Img/Guantes y tapa bocas.jpg" class="active">
                <img src="${pageContext.request.contextPath}/Img/Atencion.jpg">
                <img src="${pageContext.request.contextPath}/Img/Pulso.jpg">
                <img src="${pageContext.request.contextPath}/Img/Imagen de Inicio.jpg">

            </div>

        </div>

        <!-- ? VIDEO CENTRAL -->
        <div class="video-destacado">

            <video autoplay muted loop playsinline controls>

                <source src="${pageContext.request.contextPath}/Img/Logo Nurse con movimiento.mp4"
                        type="video/mp4">

            </video>

        </div>
</div>

        <!-- ? CARRUSEL MEDICAMENTOS -->
        <div class="carrusel-lateral">

            <h3>Medicamentos</h3>

            <div class="slider medicamentos">

                <img src="${pageContext.request.contextPath}/Img/Pastillas.jpg" class="active">
                <img src="${pageContext.request.contextPath}/Img/Medicamento.jpg">
                <img src="${pageContext.request.contextPath}/Img/Pastas.jpg">
                <img src="${pageContext.request.contextPath}/Img/Jeringa.jpg">

            </div>

        </div>

    </section>

    <!-- TEXTO -->
    <section class="texto-informativo">

  

    <h1>NURSE</h1>

    <p>
        Nurse es una plataforma digital desarrollada para optimizar la gestión de la atención médica domiciliaria.
        Su propósito es apoyar el trabajo del personal de enfermería mediante herramientas que facilitan el registro,
        seguimiento y control de los pacientes.
    </p>

    <p>
        La plataforma permite organizar citas, consultar información clínica y gestionar medicamentos de manera
        eficiente, contribuyendo a una atención más segura, ordenada y de calidad.
    </p>

    </section>
    <!-- PANEL DE INFORMACIÓN -->

<section class="panel-informativo">

    <!-- NOTICIAS -->

    <div class="noticias">

        <h2>? Noticias de Salud</h2>

        <div class="noticia">

            <h4>OMS recomienda nuevas medidas</h4>

            <p>
                Nuevas recomendaciones para prevenir enfermedades respiratorias.
            </p>

        </div>

        <div class="noticia">

            <h4>Campaña de Vacunación 2026</h4>

            <p>
                Se amplían las jornadas de vacunación para adultos mayores.
            </p>

        </div>

        <div class="noticia">

            <h4>Atención Domiciliaria</h4>

            <p>
                La atención en casa mejora la calidad de vida de pacientes crónicos.
            </p>

        </div>

    </div>

    <!-- COLUMNA DERECHA -->

    <div class="lateral-info">

        <div class="recomendacion">

            <h2>? Recomendación del Día</h2>

            <p>
                Verifique siempre los signos vitales antes de cada procedimiento.
            </p>

        </div>

        <div class="citas">

            <h2>? Próximas Citas</h2>

            <ul>

                <li>Juan Pérez - 08:00 AM</li>

                <li>María Gómez - 10:00 AM</li>

                <li>Carlos Ruiz - 02:00 PM</li>

            </ul>

        </div>

    </div>

</section>
</main>

<!-- ? JS DEL CARRUSEL -->
<script src="${pageContext.request.contextPath}/JavaScript/Script_Menu.js"></script>
<footer>

    <p>NURSE © 2026</p>

    <p>
        Sistema de gestión de pacientes y medicamentos
    </p>

</footer>
</body>

</html>