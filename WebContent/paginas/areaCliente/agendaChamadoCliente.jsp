
<!DOCTYPE html>
<html>

		<article class="agenda" style="display:none;margin-left:250px;">
			<br>
			<span id="corTitulo">Agenda</span>
			<br>
			<div id="visualizarAgenda">
				
				<img alt="Imagem de uma agenda" src="/climanut/img/calendarMenor.png" style="margin-left:300px;margin-top:8px;">
				<p style="font-size:14px;">Próximas agendas!</p>
				<br><br>
				
			</div>
			
		</article>
		<article class="chamado" style="display:none;margin-left:150px;">
			<br>
			<span id="corTitulo">Chamados</span>
			<br>
			<div id="visualizarChamados">
				
				<img alt="Imagem de um envelope" src="/climanut/img/email.png" style="margin-left:250px;">
				<p style="font-size:14px;">Chamados abertos!</p>
				<br><br>
				
			</div>
			
		</article>
		
		<script>
		$(document).ready(function(){
			$("article").slideDown('slow');
			
		});
		</script>
	
</html>