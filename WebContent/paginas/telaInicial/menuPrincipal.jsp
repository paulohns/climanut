<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" type="text/css" href="/climanut/css/estilo.css" >
<script src="/climanut/resources/jquery-1.9.0.min.js" type="text/javascript"></script>
<title>Climanut</title>
</head>
<body>
	
	<div id="container">
		<header>
			<jsp:include page="../header/header.jsp"></jsp:include>
		</header>
		
		<section class="telaInicial">
		
			<jsp:include page="menuLateral.jsp"></jsp:include>
			<br><br>
			<jsp:include page="agendaChamados.jsp"></jsp:include>
			
		</section>
		<footer>Powered by Saly Vianna </footer>
	</div>
	
</body>
</html>