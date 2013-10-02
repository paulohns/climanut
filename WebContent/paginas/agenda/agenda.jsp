<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<link rel="StyleSheet" type="text/css" href="/climanut/css/estilo.css" >
<link rel="stylesheet" type="text/css" href="/climanut/css/confirmacao.css" >
<script type="text/javascript" src="/climanut/resources/jquery-1.9.0.min.js"></script>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/climanut/resources/inputfilter.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.maskedinput.js"></script>
<link rel="stylesheet" href="/climanut/css/css_table/table_jui.css" />
<link rel="stylesheet" href="/climanut/css/css_table/table.css" />
<script type="text/javascript" src="/climanut/js/abrirFecharFormularioFiltro.js"></script>
<script type="text/javascript" src="/climanut/js/cadPesqAgenda.js"></script>
<script type="text/javascript" src="/climanut/js/limparCampos.js"></script>
<title>Climanut - Agenda </title>
</head>
<body>
	<div id="container">
		<header>
			<jsp:include page="../header/header.jsp"></jsp:include>
		</header>
		
		<section id="baseCadPesqFiltro" style="height:1200px;"><br>
			<div id="titulos"><br><br>
			<span id="corTitulo">&there4; Agenda</span>&nbsp;&nbsp;
			<jsp:include page="../botoes/botaoVoltar.jsp"></jsp:include>
			</div>
			<jsp:include page="agendaCad.jsp"></jsp:include>
			<jsp:include page="agendaPesq.jsp"></jsp:include>
			<div id="titulos"></div><br>
			
		</section>	
	<footer>Teste</footer>
	</div>
</body>
</html>