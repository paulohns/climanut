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
<title>Climanut</title>
</head>
<body>
	
	<div id="container">
		<header>
			<jsp:include page="../header/header.jsp"></jsp:include>
		</header>
		
		<section class="telaInicial">
		
			<jsp:include page="menuLateralCliente.jsp"></jsp:include>
			<br><br>
			<jsp:include page="agendaChamadoCliente.jsp"></jsp:include>
			
		</section>
		<footer>Powered by Saly Vianna </footer>
	</div>
	
</body>
</html>