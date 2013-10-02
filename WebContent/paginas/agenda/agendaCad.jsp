<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Agenda</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Agenda</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			
			<div id="formCadastro" style="height:600px;">
				<input name="idAgenda" id="idAgenda" type="hidden" />
				<input name="idCliente" id="idTecnico" type="hidden" />
				<input name="idCliente" id="idTecnico" type="hidden" /><br>
				<label>Cliente:</label><span id="asterisco">*</span><br>
				<input  id="cliente" name="cliente" class="campoTexto" type="text" size="50"  /><br>
				<label>Técnico:</label><span id="asterisco">*</span><br>
				<input id="tecnico" name="tecnico" class="campoTexto" type="text" size="50" /><br>
				<label>Chamado:</label><br>
				<input id="chamado" name="chamado" class="campoTexto" type="text" size="50" /><br>
				<label>Descrição da atividade:</label><span id="asterisco">*</span><br>
				<textarea id="descricaoAtividade" name="descricaoAtividade" class="campoTexto"  rows="3" cols="48" maxlength="255" ></textarea><br>
				<label>Observação:</label><br>
				<textarea id="observacao" name="observacao" class="campoTexto" rows="3" cols="48" maxlength="255" ></textarea><br>
				<label>Data da agenda:</label><span id="asterisco">*</span><br>
				<input id="dataAgenda" name="dataAgenda" class="campoTexto" size="25" maxlength="10" /><br><br>
				<div id="mostraStatus" style="height:50px;display:none;">
				<label>Status:</label><br>
				<label>Agendado:</label>
				<input id="agendado" name="agendado" class="campoTexto" type="checkbox" size="18"  value="1" />
				<label>Cancelado:</label>
				<input id="cancelado" name="cancelado" class="campoTexto" type="checkbox" size="18"  value="2"/>
				<label>Fechado:</label>
				<input id="fechado" name="fechado" class="campoTexto" type="checkbox" size="18"  value="3" /><br><br><br>
				</div>
				<br><br>
				
				<input id="botaoIncluirAgenda" class="botaoIncluir" name="acao"  type="submit" value="Incluir">
				<input id="botaoAlterarAgenda" class="botaoAlterar" name="acao"  type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include><br>
			</div>
		</article>
		