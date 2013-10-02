<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Manutenção Anvisa</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Manutenção Anvisa</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			<div id="formCadastro" style="display: none;margin-left:0px;height:350px">
				<input name="idManutencaoAnvisa" id="idManutencaoAnvisa" type="hidden" />
				<input name="idTecnicoAprovadoPor" id="idTecnicoAprovadoPor" type="hidden"/><br>
				<label>Agenda Anvisa:</label><span id="asterisco">*</span><br>
				<input id="agendaAnvisa" name="agendaAnvisa" class="campoTexto" type="text" size="25" /><br>
				<label>Data Manutenção:</label><span id="asterisco">*</span><br>
				<input id="dataManutencaoAnvisa" name="dataManutencaoAnvisa"  class="campoTexto" type="text" size="25" /><br>
				<label>Executado por:</label><span id="asterisco">*</span><br>
				<input id="executadoPor" name="executadoPor"  class="campoTexto" type="text" size="50" /><br>
				<label>Aprovado por:</label><span id="asterisco">*</span><br>
				<input id="aprovadoPor" name="aprovadoPor"  class="campoTexto" type="text" size="50" /><br><br><br>
				
				<input id="botaoIncluirManutencaoAnvisa" class="botaoIncluir" type="submit" value="Incluir">
				<input id="botaoAlterarManutencaoAnvisa" class="botaoAlterar" name="acao"  type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
			</div>
		</article>
		