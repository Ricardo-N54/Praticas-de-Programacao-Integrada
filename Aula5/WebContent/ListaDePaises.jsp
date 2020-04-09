<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Aula5.Pais, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"content="width=device-width, initial-scale=1">
		<title>Lista de Paises</title>
		
		<link href="css/bootstrap.min.css"rel="stylesheet">
		<link href="css/style.css"rel="stylesheet">
	</head>
	<body>
	<%
		ArrayList<Pais> paises = (ArrayList<Pais>)request.getAttribute("paises");  for(Pais pais:paises){
	%>	
		<div id="main"class="container">
			<div class="row">
				<div class="col-md-12">
					<p><strong>ID:</strong> <%= pais.getId() %> </p>
				</div>
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
			</div>
		</div>
	<%} %>
		<div id="main"class="container">
			<div id="actions"class="row">
				<div class="col-md-12">
					<a href="index.html"class="btn btn-default">Voltar</a>
				</div>
			</div>
		</div>
	</body>
</html>
