<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="StyleSheet" type="text/css" href="/climanut/css/estilo.css" >
<link rel="stylesheet" type="text/css" href="/climanut/css/confirmacao.css" >
<link rel="stylesheet" href="/climanut/css/css_table/table_jui.css" />
<link rel="stylesheet" href="/climanut/css/css_table/table.css" />
<script type="text/javascript" src="/climanut/resources/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/climanut/resources/inputfilter.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.maskedinput.js"></script>
<script type="text/javascript" src="/climanut/js/abrirFecharFormularioFiltro.js"></script>
<script type="text/javascript" src="/climanut/js/cadPesqAgendaAnvisa.js"></script>
<script type="text/javascript" src="/climanut/js/limparCampos.js"></script>
<title>Climanut - Agenda Anvisa</title>
</head>
<body>
	
	<div id="container">
		<header>
			<jsp:include page="../header/header.jsp"></jsp:include>
		</header>
		
		<section id="baseCadPesq" style="height:1000px;"><br>
			
			<div id="titulos"><br><br>
			<span id="corTitulo">&there4; Agenda Anvisa</span>&nbsp;&nbsp;
			<jsp:include page="../botoes/botaoVoltar.jsp"></jsp:include>
			</div>
			<!--<jsp:include page="agendaAnvisaCad.jsp"></jsp:include>-->
			<jsp:include page="agendaAnvisasPesq.jsp"></jsp:include>
			
			
		</section>		
	<footer>Teste</footer>
	</div>

</body>
</html>