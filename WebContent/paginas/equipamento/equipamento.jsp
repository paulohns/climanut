<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="StyleSheet" type="text/css" href="/climanut/css/estilo.css" >
<script type="text/javascript" src="/climanut/resources/jquery-1.9.0.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/climanut/resources/inputfilter.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.maskedinput.js"></script>
<link rel="stylesheet" href="/climanut/css/css_table/table_jui.css" />
<link rel="stylesheet" href="/climanut/css/css_table/table.css" />
<script type="text/javascript" src="/climanut/js/abrirFecharFormulario.js"></script>
<script type="text/javascript" src="/climanut/js/cadPesqEquipamento.js"></script>
<script type="text/javascript" src="/climanut/js/limparCampos.js"></script>
</head>
<title>CliManut - Equipamento</title>

<body>
	<div id="container">
		<header>
			<jsp:include page="../header/header.jsp"></jsp:include>
		</header>
		
		<section id="baseCadPesq" style="height:1000px;"><br>
			
			<div id="titulos"><br><br>
			
			<span id="corTitulo">&there4; Equipamento</span>&nbsp;&nbsp;
			<jsp:include page="../botoes/botaoVoltar.jsp"></jsp:include>
			</div>
			<jsp:include page="equipamentoCad.jsp"></jsp:include>
			<jsp:include page="equipamentoPesq.jsp"></jsp:include>

		</section>
		<footer>Teste</footer>
	</div>

</body>
</html>