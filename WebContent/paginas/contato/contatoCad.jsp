<!DOCTYPE html>

		<article class="cadastrarContato" style="margin-top:-20px;"><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Contato</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Contato</span>
			<jsp:include page="../botoes/abrirFecharContato.jsp"></jsp:include>
			
			<div id="formContato">
				
				<label>Cliente:</label><span id="asterisco">*</span><br>
				<input id="clienteContato" name="clienteContato" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Nome:</label><span id="asterisco">*</span><br>
				<input id="nomeContato" name="nomeContato" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Telefone Fixo:</label><span id="asterisco">*</span><br>
				<input id="telefoneContato" name="telefoneContato" class="campoTexto" type="text" size="18" maxlength=""  /><br>
				<label>Ramal:</label><br>
				<input id="ramalContato" name="ramalContato" class="campoTexto" type="text" size="18" maxlength="" /><br>
				<label>Telefone Celular:</label><br>
				<input id="celularContato"  name="celularContato" class="campoTexto" type="text" size="18" maxlength="" /><br><br><br>
				
				<input id="botaoIncluirContato" name="acao" class="botaoIncluir" type="submit" value="Incluir">
				<input id="botaoAlterarContato" name="acao" class="botaoAlterar" type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimparContato.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagensContato.jsp"></jsp:include>
			</div>
			
		</article>
	
