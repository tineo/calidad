<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="servicios.AsignacionService" %>
<%@ page import="entidades.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="servicios.ListingService" %><%--
  Created by IntelliJ IDEA.
  User: tineo
  Date: 29/05/19
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Usuario usuario = (Usuario) session.getAttribute("user"); %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Cesar Gutierrez Tineo">
    <title>Calidad de Software</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/offcanvas/">
    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/estilos.css">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.3/examples/offcanvas/offcanvas.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <a class="navbar-brand mr-auto mr-lg-0" href="#">FISI</a>
    <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Calidad SW<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Asignar cursos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Disponibilidad</a>
            </li>
        </ul>
    </div>
</nav>


<main role="main" class="container">
    <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded shadow-sm">
        <img class="mr-3" src="/docs/4.3/assets/brand/bootstrap-outline.svg" alt="" width="48" height="48">
        <div class="lh-90">
            <h6 class="mb-0 text-white lh-100">Disponibilidad de horario</h6>
            <small>Semestre 2019-2</small>
        </div>
        <div class="lh-10 ml-2 pl-2"><button class="btn btn-success btn-sm" id="guardar">Guardar</button></div>

    </div>

    <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">Seleccion de disponibilidad</h6>


        <table class="table table-sm" id="disponibilidad">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Lunes</th>
                <th scope="col">Martes</th>
                <th scope="col">Miercoles</th>
                <th scope="col">Jueves</th>
                <th scope="col">Viernes</th>
                <th scope="col">Sabado</th>
            </tr>
            </thead>
            <tbody>
            <% for(int h = 0; h < 14; h+=1) { %>
            <tr>
                <th scope="row" ><%=(h+8)%>:00 - <%=(h+9)%>:00</th>
                <% for(int d = 0; d < 6; d+=1) { %>
                <td class="day-<%=d%> hour-<%=h%> " data-day="<%=d%>" data-hour="<%=h%>"></td>
                <% } %>
            </tr>
            <% } %>
            </tbody>
        </table>

    </div>
    <div class="row">
        <div class="col-9">

            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Cursos Asigandos</h6>

                <% AsignacionService asignacionService =  new AsignacionService(); %>

                <% ArrayList lista = asignacionService.cursosAsignados(usuario.getId()); %>
                <% request.setAttribute("lista", lista); %>
                <c:forEach var="element" items="${lista}">
                    <div class="media text-muted pt-3">
                        <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
                        <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            <div class="d-flex justify-content-between align-items-center w-100">
                                <strong class="text-gray-dark">${element.nombre}</strong>
                                <!--<a href="#">Follow</a>-->
                            </div>
                            <!--<span class="d-block">@username</span>-->
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <div class="col-3">

            <form method="post" action="/asignar">
                <% ListingService listingService =  new ListingService(); %>
                <% ArrayList cursos = listingService.listarCursos();%>
                <% request.setAttribute("cursos", cursos); %>
                <div class="form-group">
                    <label for="curso">Curso</label>
                    <select name="curso" id="curso" class="form-control" >
                        <c:forEach var="element" items="${cursos}">
                            <option value="${element.id}">${element.nombre}</option>
                        </c:forEach>
                    </select>
                </div>

                <input type="hidden" name="usuario" value="<%=usuario.getId()%>">
                <div class="form-group">
                    <label for="anio">Año</label>
                    <input name="anio" id="anio" type="number" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="ciclo">Ciclo</label>
                    <input name="ciclo" id="ciclo" type="text" class="form-control" />
                </div>
                <input type="submit" class="btn btn-primary" value="Agregar curso"/>
            </form>
        </div>
    </div>

</main>



<div id="confirmacion" class="modal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="confirmacion-titulo"></h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12" style="">
                        <div id="confirmacion-texto"></div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button"  class="btn btn-primary" id="ok">Aceptar</button>
                <button type="button"  data-dismiss="modal" class="btn">Cancelar</button>
            </div>
        </div>
    </div>
</div>

<script src=" https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://getbootstrap.com/docs/4.3/examples/offcanvas/offcanvas.js"></script></body>
<script src="resources/js/main.js"></script>
</html>
