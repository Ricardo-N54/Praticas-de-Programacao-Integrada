<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Aula5.Pais" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"content="width=device-width, initial-scale=1">
		<title>Pais</title>
		
		<link href="css/bootstrap.min.css"rel="stylesheet">
		<link href="css/style.css"rel="stylesheet">
	</head>
	<body>
		<% Pais pais = (Pais)request.getAttribute("pais");  %>
		<div id="main"class="container">
			<div class="row">
				<div class="col-md-12">
					<p><strong>Nome:</strong> <%= pais.getNome() %> </p>
				</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<p><strong>Populacao</strong> <%= pais.getPopulacao() %></p>
					</div>
					<div class="col-md-6">
						<p><strong>Area</strong> <%= pais.getArea() %> </p>
					</div>
				</div>
				<hr/>
				<div id="actions"class="row">
					<div class="col-md-12">
					<a href="index.html"class="btn btn-default">Voltar</a>
				</div>
			</div>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
