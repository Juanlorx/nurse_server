<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Calendario - Nurse</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Ccs/Style_Calendario.css">

</head>

<body>

    <!-- HEADER -->

    <header class="header">

        <div class="logo">

            <img src="${pageContext.request.contextPath}/Img/Nurse Logo.png"
                 alt="Logo">

        </div>

        <div class="header-menu">

            <nav>

                <ul>

                    <li>
                        <a href="${pageContext.request.contextPath}/Vista/Menu.jsp">
                            Menu
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/Vista/Pacientes.jsp">
                            Pacientes
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/Vista/Calendario.jsp"
                           class="activo">
                            Calendario
                        </a>
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

    <!-- CONTENIDO -->

    <main>

        <section class="calendario-nurse">

            <h2>Calendario de Citas</h2>

            <div class="calendario-container">

                <div class="calendario-header">

                    <button>&lt;</button>

                    <h3>Junio 2026</h3>

                    <button>&gt;</button>

                </div>

                <div class="dias-semana">

                    <div>Lun</div>
                    <div>Mar</div>
                    <div>Mié</div>
                    <div>Jue</div>
                    <div>Vie</div>
                    <div>Sáb</div>
                    <div>Dom</div>

                </div>

                <div class="dias-mes">

                    <div class="dia">1</div>
                    <div class="dia">2</div>
                    <div class="dia">3</div>
                    <div class="dia cita">4</div>
                    <div class="dia">5</div>
                    <div class="dia">6</div>
                    <div class="dia">7</div>

                    <div class="dia">8</div>
                    <div class="dia">9</div>
                    <div class="dia cita">10</div>
                    <div class="dia">11</div>
                    <div class="dia">12</div>
                    <div class="dia">13</div>
                    <div class="dia">14</div>

                    <div class="dia">15</div>
                    <div class="dia">16</div>
                    <div class="dia">17</div>
                    <div class="dia">18</div>
                    <div class="dia cita">19</div>
                    <div class="dia">20</div>
                    <div class="dia">21</div>

                </div>

            </div>

        </section>

    </main>

</body>

</html>