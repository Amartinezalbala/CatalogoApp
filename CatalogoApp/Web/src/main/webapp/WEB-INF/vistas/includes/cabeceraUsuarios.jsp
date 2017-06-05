<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPe html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>USUARIOS ÁLVARO</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body>
	<header>
	<h2>USUARIOS</h2>
	<p>LISTA DE USUARIOS</p>
	<h5><%= new java.util.Date() %></h5> 
	</header>
	<nav>
	<ul>
			<li><a href="UsuarioCRUD?op=alta">ALTA</a></li>
			<li><a href="UsuarioCRUD">LISTA DE USUARIOS</a></li>
			<li><a href="productocrud">LISTA DE PRODUCTOS</a><li>
			<li><a href="login?opcion=logout">SALIR</a></li>
		</ul>
	</nav>