<!DOCTYPE html>
<html lang="pt-br">

<div id="menuslider">
	<form>
		 <nav id="navimenu" style="height:150px;">
		 
            <ul>
            	<li style="text-align:center;border-bottom:1px solid #a1eafa;">Menu</li>
	            <li><a href="paginas/cliente/chamadoCliente.jsp">Chamado</a></li>
	            <li><a href="paginas/cliente/relatorioCliente.jsp">Relatório</a></li>
            </ul>
   		 </nav>
   	 </form>
   		
</div>	
<script>

	$(document).ready(function(){
		$("#navimenu").animate({ width: 'show' }); 
		
	});

</script>
</html>