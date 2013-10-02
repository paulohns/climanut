<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="StyleSheet" type="text/css" href="css/estilo.css" >
<script src="/climanut/resources/jquery-1.9.0.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/climanut/css/confirmacao.css" >
<script type="text/javascript" src="/climanut/js/confirmaExclusao.js"></script>
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