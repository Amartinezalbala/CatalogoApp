<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPe html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Y CRUD ÁLVARO</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body>
	<header>
	<h2>MVC Y CRUD</h2>
	<p>USO DE MVC Y CRUD</p>
	<h5><%= new java.util.Date() %></h5> 
	</header>
	<nav>
	<ul>
			<li><a href="?op=alta">ALTA</a></li>
			<li><a href="login">LOGIN</a></li>
			<li><a href="UsuarioCRUD">MANTENIMIENTO USUARIOS</a></li>
			<li><a href="login?opcion=logout">SALIR</a></li>
		</ul>
	</nav>