<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="StyleSheet" type="text/css" href="/climanut/css/estilo.css" >
<link rel="StyleSheet" type="text/css" href="/climanut/css/jquery-ui.css" >
<link rel="stylesheet" type="text/css" href="/climanut/css/jquery.ui.autocomplete.css" >
<script type="text/javascript" src="/climanut/resources/jquery-1.8.0.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery-ui.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/climanut/resources/inputfilter.js"></script>
<script type="text/javascript" src="/climanut/resources/jquery.maskedinput.js"></script>
<link rel="stylesheet" href="/climanut/css/css_table/table_jui.css" />
<link rel="stylesheet" href="/climanut/css/css_table/table.css" />
<script type="text/javascript" src="/climanut/js/abrirFecharFormulario.js"></script>
<script type="text/javascript" src="/climanut/js/cadPesqChamadoCliente.js"></script>
<script type="text/javascript" src="/climanut/js/limparCampos.js"></script>
</head>
<title>Climanut - Chamado</title>

<body>
	<div id="container">
		<header>
			<jsp:include page="../header/header.jsp"></jsp:include>
		</header>
		
		<section id="baseCadPesq" style="height:700px;"><br>
			<div id="titulos"><br><br>
			<span id="corTitulo">&there4;Chamado</span>&nbsp;&nbsp;
			<jsp:include page="../botoes/botaoVoltarCliente.jsp"></jsp:include>	
			</div>
			
			<jsp:include page="chamadoClienteCad.jsp"></jsp:include>
			<jsp:include page="chamadoClientePesq.jsp"></jsp:include>
				
		</section>		
		<footer>Teste</footer>
	</div>

</body>
</html>