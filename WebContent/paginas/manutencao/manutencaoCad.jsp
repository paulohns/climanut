<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Manutenção</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Manutenção</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			<div id="formCadastro" style="float:left;height:700px"><br>
				<input name="idManutencao" id="idManutencao" type="hidden" />
				<label>Localização:</label><span id="asterisco">*</span><br>
				<input id="localizacao" name="localizacao" class="campoTexto" type="text" size="50"  /><br>
				<label>Agenda:</label><span id="asterisco">*</span><br>
				<input id="agenda" name="agenda"  class="campoTexto" type="text" size="25" /><br>
				<label>Data da Manuteção:</label><span id="asterisco">*</span><br>
				<input id="dataManutencao" name="dataManutencao"  class="campoTexto" type="text" size="25" /><br><br>
				<label>Corrente:</label><span id="asterisco">*</span><br>
				<label>OK&nbsp;&nbsp;</label>
				<input id="okCorrente" name="statusCorrente" type="radio" size="18" value="0"  />&nbsp;&nbsp;&nbsp;&nbsp;
				<label>NÃO OK &nbsp;&nbsp;</label>
				<input id="naoOkCorrente" name="statusCorrente" type="radio" size="18" value="1"  /><br>
				<label>Observacão Corrente:</label><span id="asterisco" style="display:none;" class="astCorrente">*</span><br>
				<textarea id="obsCorrente" name="obsCorrente" rows="3" cols="44" class="campoTexto"></textarea><br><br>
				<label>Pressão Hi:</label><span id="asterisco">*</span><br>
				<label>OK&nbsp;&nbsp;</label>
				<input id="okPressaoHi" name="statusPressaoHi" type="radio" size="18"  value="0"  />&nbsp;&nbsp;&nbsp;&nbsp;
				<label>NÃO OK &nbsp;&nbsp;</label>
				<input id="naoOkPressaoHi" name="statusPressaoHi" type="radio" size="18"   value="1"  /><br>
				<label>Observacão Pressão Hi:</label><span id="asterisco" style="display:none;" class="astPressaoHi">*</span><br>
				<textarea id="obsPressaoHi" name="obsPressaoHi" rows="3" cols="44" class="campoTexto" ></textarea><br><br><br><br>
				
				<input id="botaoIncluirManutencao" class="botaoIncluir" name="acao"  type="submit" value="Incluir">
				<input id="botaoAlterarManutencao" class="botaoAlterar" name="acao"  type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
			</div>
			<div id="formCadastro1" style="float:left;height:700px;margin-top:27px;">
				<label>Pressão Low:</label><span id="asterisco">*</span><br>
				<label>OK&nbsp;&nbsp;</label><input id="okPressaoLow" name="statusPressaoLow" type="radio" size="18" value="0"  />&nbsp;&nbsp;&nbsp;&nbsp;
				<label>NÃO OK &nbsp;&nbsp;</label><input id="naoOkPressaoLow" name="statusPressaoLow" type="radio" size="18" class="numero"  value="1"  /><br>
				<label>Observacão Pressão Low:</label><span id="asterisco" style="display:none;" class="astPressaoLow">*</span><br>
				<textarea id="obsPressaoLow" name="obsPressaoLow" rows="3" cols="44" class="campoTexto"></textarea><br><br>
				<label>Filtros:</label><span id="asterisco">*</span><br>
				<label>OK&nbsp;&nbsp;</label><input id="okFiltros" name="statusFiltros" type="radio" size="18"  value="0" />&nbsp;&nbsp;&nbsp;&nbsp;
				<label>NÃO OK&nbsp;&nbsp; </label><input id="naoOkFiltros" name="statusFiltros" type="radio" size="18" value="1"  /><br>
				<label>Observacão Filtros:</label><span id="asterisco" style="display:none;" class="astFiltros">*</span><br>
				<textarea id="obsFiltros" name="obsFiltros" rows="3" cols="44" class="campoTexto"></textarea><br><br>
				<label>Temperatura:</label><span id="asterisco">*</span><br>
				<label>OK&nbsp;&nbsp;</label><input id="okTemperatura" name="statusTemperatura" type="radio" size="18" value="0"  />&nbsp;&nbsp;&nbsp;&nbsp;
				<label>NÃO OK&nbsp;&nbsp; </label><input id="naoOkTemperatura" name="statusTemperatura" type="radio" size="18" value="1"  /><br>
				<label>Observacão Temperatura:</label><span id="asterisco" style="display:none;" class="astTemperatura">*</span><br>
				<textarea id="obsTemperatura" name="obsTemperatura" rows="3" cols="44" class="campoTexto"></textarea><br><br><br><br><br>
				
			</div>	
		</article>
