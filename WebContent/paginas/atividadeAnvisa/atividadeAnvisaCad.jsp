<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Atividade Anvisa</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Atividade Anvisa</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			<div id="formCadastro" style="height:320px;">
				<input name="idAtividadeAnvisa" id="idAtividadeAnvisa" type="hidden" /><br>
				<label>Descrição da atividade:</label><span id="asterisco">*</span><br>
				<textarea id="descricaoAtividade" name="descricaoAtividade" class="campoTexto" rows="3" cols="48"></textarea><br>
				<label>Periodicidade de manutenção:</label><span id="asterisco">*</span><br>
				<select id="periodicidade"	name="periodicidade" class="campoTexto" >
					<option value="0">&nbsp;&nbsp;Selecione</option>
					<option value="1">&nbsp;&nbsp;Mensal&nbsp;&nbsp;</option>
					<option value="2">&nbsp;&nbsp;Bimestral&nbsp;&nbsp;</option>
					<option value="3">&nbsp;&nbsp;Trimestral&nbsp;&nbsp;</option>
					<option value="6">&nbsp;&nbsp;Semestral&nbsp;&nbsp;</option>
					<option value="12">&nbsp;&nbsp;Anual&nbsp;&nbsp;</option>
				</select><br><br><br>
				
				<input id="botaoIncluirAtividadeAnvisa" class="botaoIncluir" name="acao"type="submit" value="Incluir">
				<input id="botaoAlterarAtividadeAnvisa" class="botaoAlterar" name="acao"  type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
				
			</div>
		</article>
		
