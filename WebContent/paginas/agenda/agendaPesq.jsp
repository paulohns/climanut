<!DOCTYPE html>

		<article class="pesquisar" style="margin-top:-20px;" ><br>
			<span id="corTitulo"> Pesquisar Agenda </span>
			<jsp:include page="../botoes/abrirFecharP.jsp"></jsp:include>
			<div id="formPesquisaFiltro" style="display:none"><br>
				<label>Cliente:</label><br>
				<input id="clientePesq" name="clientePesq" class="campoTexto" type="text" size="50"  /><br><br>
				<label>Data inicial:</label><label style="margin-left:130px;">Data final:</label><br>
				<input id="dataInicialPesq" name="dataInicialPesq" class="campoTexto" type="text" size="18" />
				<input id="dataFinalPesq" name="dataFinalPesq" class="campoTexto" type="text" size="18" style="margin-left:75px;" /><br><br>
				<label>Status:</label><br>
				<label>Agendado:</label>
				<input id="agendadoPesq" name="agendadoPesq" class="campoTexto" type="checkbox" size="18"  value="1" />
				<label>Cancelado:</label>
				<input id="canceladoPesq" name="canceladoPesq" class="campoTexto" type="checkbox" size="18"  value="2" />
				<label>Fechado:</label>
				<input id="fechadoPesq" name="fechadoPesq" class="campoTexto" type="checkbox" size="18"  value="3" /><br><br><br>
				
				<input id="botaoPesquisarAgenda" name="acao" class="botao" type="submit" value="Pesquisar">
				<jsp:include page="../botoes/botaoLimparPesq.jsp"></jsp:include>
				<jsp:include page="../mensagens/mensagensPesq.jsp"></jsp:include>
				
			</div>
			<div id="formPesquisa" ><br><br>
			
				<table class="display" id="example" >
				<thead>
					<tr>
						<th>Id</th>
						<th>Cliente</th>
						<th>Técnico</th>
						<th>Chamado</th>
						<th>Data da Agenda</th>
						<th>Status</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
				</table>
			</div>
		</article>
		
