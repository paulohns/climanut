<!DOCTYPE html>

		<article class="pesquisar" style="margin-top:-20px;" ><br>
			<span id="corTitulo"> Pesquisar Sistema</span>
			<jsp:include page="../botoes/abrirFecharP.jsp"></jsp:include>
			<div id="formPesquisaFiltro" style="display:none"><br>
				<label>Cliente:</label><br>
				<input id="clientePesq" name="clientePesq" class="campoTexto" type="text" size="53"  /><br><br>
				<label>Status:</label><br>
				<label>Inativo:</label>
				<input id="inativoPesq" name="inativoPesq" class="campoTexto" type="checkbox" size="18"  value="2" /><br><br>
				
				<input id="botaoPesquisarSistema" name="acao" class="botao" type="submit" value="Pesquisar">
				<jsp:include page="../botoes/botaoLimparPesq.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagensPesq.jsp"></jsp:include>
				
			</div>
			<div id="formPesquisa" ><br>
				
				<table class="display" id="example" >
				<thead>
					<tr>
						<th>Id</th>
						<th>Bloco</th>
						<th>Data da instalação</th>
						<th>Status</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
				</table>
			</div>
		</article>
