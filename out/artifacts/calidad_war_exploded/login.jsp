<%--
  Created by IntelliJ IDEA.
  User: tineo
  Date: 29/05/19
  Time: 08:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Calidad de software">
    <title>Calidad de software</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


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
    <link href="https://getbootstrap.com/docs/4.3/examples/floating-labels/floating-labels.css" rel="stylesheet">
</head>
<body>
<form class="form-signin" action="/login" method="post">
    <div class="text-center mb-4">
        <img class="mb-4" src="https://getbootstrap.com/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesion</h1>
        <!--<p>Build form controls with floating labels via the <code>:placeholder-shown</code> pseudo-element. <a href="https://caniuse.com/#feat=css-placeholder-shown">Works in latest Chrome, Safari, and Firefox.</a></p>-->
    </div>

    <div class="form-label-group">
        <input name="codigo" type="text" id="inputEmail" class="form-control" placeholder="Codigo " required autofocus>
        <label for="inputEmail">Codigo</label>
    </div>

    <div class="form-label-group">
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
        <label for="inputPassword">Contraseña</label>
    </div>

    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2019</p>
</form>
<script src="resources/js/main.js"></script>
</body>
</html>

