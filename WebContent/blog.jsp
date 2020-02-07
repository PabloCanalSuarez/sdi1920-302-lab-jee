<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="com.uniovi.sdi.blog.* , java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Blog</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Barra de navegación superior -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar.nav">
				<li><a href="index.jsp">Página principal</a></li>
			</ul>
		</div>
	</nav>

	<!-- Contenido -->
	<div class="container" id="contenedor-principal">
		<h2>Blog</h2>
		<ul>
			<c:forEach var="comentario" items="${comentariosBlog}">
				<tr>
					<li>${comentario.nombreUsuario}: ${comentario.comentario}</li>
				</tr>
			</c:forEach>
		</ul>

		<!-- Para añadir un nuevo comentario -->
		<h4>Añadir comentario</h4>

		<form class="form-horizontal" method="post" action="comentarios">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nombre">Usuario:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="usuario"
						required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Texto:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="texto"
						required="true" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Añadir</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>