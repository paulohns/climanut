<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo"> Incluir Chamado</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			<div id="formCadastro" style="display: none;margin-left:0px;height:250px;">
				<input name="idChamadoCliente" id="idChamadoCliente" type="hidden" /><br>
				<label>Descrição do chamado:</label><span id="asterisco">*</span><br>
				<textarea rows="4" cols="44"></textarea><br><br><br>
				
				<input id="botaoIncluirChamadoCliente" class="botaoIncluir" name="acao" type="submit" value="Incluir">
				<input id="botaoAlterarChamadoCliente" class="botaoAlterar" name="acao" type="submit" value="Alterar" style="display:;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
				
			</div>
		</article>	
