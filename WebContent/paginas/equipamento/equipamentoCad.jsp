<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo"> Incluir Equipamento</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Equipamento</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			
			<div id="formCadastro" style="height:420px;">
				<input name="idEquipamento" id="idEquipamento" type="hidden" /><br>
				<label>Número de Série:</label><br>
				<input name="numeroSerie" id="numeroSerie" class="campoTexto" type="text" size="50"  /><br>
				<label>Marca:</label><span id="asterisco">*</span><br>
				<input id="marca" name="marca"  class="campoTexto" type="text" size="50" /><br>
				<label>Modelo:</label><br>
				<input id="modelo" name="modelo"  class="campoTexto" type="text" size="50" /><br>
				<label>BTUs:</label><span id="asterisco">*</span><br>
				<input id="btu" name="btu"  class="campoTexto" type="text" size="18" /><br>
				<label>Periodicidade de manutenção:</label><span id="asterisco">*</span><br>
				<select id="periodicidade" name="periodicidade" class="campoTexto">
					<option value="0">&nbsp;&nbsp;Selecione</option>
					<option value="1">&nbsp;&nbsp;Mensal&nbsp;&nbsp;</option>
					<option value="2">&nbsp;&nbsp;Bimestral&nbsp;&nbsp;</option>
					<option value="3">&nbsp;&nbsp;Trimestral&nbsp;&nbsp;</option>
					<option value="6">&nbsp;&nbsp;Semestral&nbsp;&nbsp;</option>
					<option value="12">&nbsp;&nbsp;Anual&nbsp;&nbsp;</option>
				</select><br>
				<label id="labelInativar" style="display:none;" >Inativar:</label><br>
				<input id="inativar" name="inativar" class="campoTexto" type="checkbox" size="18"  value="0" style="display:none;" /><br><br>
				
				<input id="botaoIncluirEquipamento" class="botaoIncluir" name="acao"  type="submit" value="Incluir">
				<input id="botaoAlterarEquipamento" class="botaoAlterar" name="acao"  type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
				
			</div>
		</article>

