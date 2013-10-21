
<!DOCTYPE html>
<html>

		<article class="agenda" style="display:none;margin-left:250px;">
			<br>
			<span id="corTitulo">Agendas</span>
			<br>
			<div id="visualizarAgenda">
				
				<img alt="Imagem de uma agenda" src="/climanut/img/calendarMenor.png" style="margin-left:300px;margin-top:8px;">
				<table style="font-size:14px;;margin-left:0px;margin-top:6px;width:400px;">
				<tr id="cabecalhoLink"><td width="2px;"></td><td >Cliente</td><td width="150px;">Data Final</td></tr>
					<tr><td width="2px;"></td><td></td>&nbsp;<td width="150px;"></td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX</td><td>06/05/2013</td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX YYYY</td><td>06/05/2013</td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX ZZZ</td><td>06/05/2013</td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX</td><td>06/05/2013</td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX YYY</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX ZZZ AAA</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX GGG DDD CCC</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX YYY</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX GGG TTT AAA</td><td>06/05/2013</td></tr>
				</table>
			</div>
			
		</article>
		<article class="chamado" style="display:none;margin-left:150px;">
			<br>
			<span id="corTitulo">Chamados</span>
			<br>
			<div id="visualizarChamados">
				
				<img alt="Imagem de um envelope" src="/climanut/img/email.png" style="margin-left:350px;">
				<table style="font-size:14px;;margin-left:0px;margin-top:px;">
					<tr><td width="2px;"></td><td width="270px;">Cliente</td><td width="150px;">Data de Abertura</td></tr>
					<tr><td width="2px;"></td><td width="270px;"></td>&nbsp;<td width="150px;"></td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX</td><td>06/05/2013</td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX YYYY</td><td>06/05/2013</td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX ZZZ</td><td>06/05/2013</td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX</td><td>06/05/2013</td></tr>
					<tr id="linkMais"><td><input type="hidden" value="1"></td><td>Empresa XXX YYY</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX ZZZ AAA</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX GGG DDD CCC</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX YYY</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX</td><td>06/05/2013</td></tr>
					<tr id="linkMenos"><td><input type="hidden" value="1"></td><td>Empresa XXX GGG TTT AAA</td><td>06/05/2013</td></tr>
					
				</table>
				
				<br><br>
				
			</div>
			
		</article>
		
		<script>
		$(document).ready(function(){
			$("article").slideDown('slow');
			
		});
		</script>
	
</html>