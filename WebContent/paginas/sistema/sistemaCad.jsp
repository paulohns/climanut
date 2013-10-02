<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Sistema</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Sistema</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			<div id="formCadastro" style="height:1700px">
				<input name="idSistema" id="idSistema" type="hidden" /><br>
				<div id="formCliente" style="height:200px;">
				<label>Cliente:</label><span id="asterisco">*</span><br>
				<input id="cliente" name="cliente" class="campoTexto" type="text" size="50" /><br><br><br>
				
				<input id="botaoIncluirCliente" class="botaoIncluir" type="submit" value="Incluir">
				<input id="botaoLimparCliente" class="botao" type="reset" value="Limpar"><br><br>
				<jsp:include page="../mensagens/mensagensCliente.jsp"></jsp:include><br><br>
				</div>
				<label id="corTitulo" >&bull; Localização do Sistema</label><br><br>
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Bloco</span>
				
				<div id="formBloco" style="height:220px;"><br>
					<label>Cliente:</label><span id="asterisco">*</span><br>
					<input id="clienteBloco" name="clienteBloco" class="campoTexto" type="text" size="50" /><br>
					<label>Bloco:</label><span id="asterisco">*</span><br>
					<input id="bloco" name="bloco"  class="campoTexto" type="text" size="50" /><br><br>
					
					<input id="botaoIncluirBloco" class="botaoIncluir" type="submit" value="Incluir">
					<!-- Apenas poderá alterar para inativo -->
					<input id="botaoAlterarBloco" name="acao" class="botaoAlterar" type="submit" value="Alterar" style="display:none;">
					<input id="botaoLimparBloco" class="botao" type="reset" value="Limpar"><br><br>
					<jsp:include page="../mensagens/mensagensBloco.jsp"></jsp:include>
				
				</div><br><br>
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Pavimento</span>
				
				<div id="formPavimento" style="height:250px;"><br>
				<label>Cliente:</label><span id="asterisco">*</span><br>
					<input id="clientePavimento" name="clientePavimento" class="campoTexto" type="text" size="50" /><br>
					<label>Bloco:</label><span id="asterisco">*</span><br>
					<select id="blocosPavimento" name="blocosPavimento" class="campoTexto"></select><br>
					<label>Pavimento:</label><span id="asterisco">*</span><br>
					<input id="pavimento" name="pavimento" class="campoTexto" type="text" size="50" /><br><br>
					
					<input id="botaoIncluirPavimento" class="botaoIncluir" name="acao" type="submit" value="Incluir">
					<!-- Apenas poderá alterar para inativo -->
					<input id="botaoAlterarPavimento" class="botaoAlterar" name="acao"  type="submit" value="Alterar" style="display:none;">
					<input id="botaoLimparPavimento" class="botao" type="reset" value="Limpar"><br><br>
					<jsp:include page="../mensagens/mensagensPavimento.jsp"></jsp:include>
				
				</div><br><br>
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Local</span>
				
				<div id="formLocal" style="height:300px;"><br>
					<label>Cliente:</label><span id="asterisco">*</span><br>
					<input id="clienteLocal" name="clienteLocal" class="campoTexto" type="text" size="50" /><br>
					<label>Bloco:</label><span id="asterisco">*</span><br>
					<select id="blocosLocal" name="blocosLocal" class="campoTexto"></select> <br>
					<label>Pavimento:</label><span id="asterisco">*</span><br>
					<select id="pavimentosLocal" name="pavimentosLocal" class="campoTexto"></select> <br>
					<label>Local:</label><span id="asterisco">*</span><br>
					<input id="local" name="local"  class="campoTexto" type="text" size="50" /><br><br>
					
					<input id="botaoIncluirLocal" class="botao" type="submit" value="Incluir">
					<!-- Apenas poderá alterar para inativo -->
					<input id="botaoAlterarLocal" class="botaoIncluir" name="acao"  type="submit" value="Alterar" style="display:none;">
					<input id="botaoLimparLocal" class="botaoAlterar" name="acao" type="reset" value="Limpar"><br><br>
					<jsp:include page="../mensagens/mensagensLocal.jsp"></jsp:include>
				
				</div><br><br>
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Equipamento</span>
				
				<div id="formEquipamento" style="height:400px;"><br>
					<label>Cliente:</label><span id="asterisco">*</span><br>
					<input id="clienteEquipamento" name="clientePavimento" class="campoTexto" type="text" size="50" /><br>
					<label>Bloco:</label><span id="asterisco">*</span><br>
					<select id="blocosEquipamento" name="blocosEquipamento" class="campoTexto">
					</select> <br>
					<label>Pavimento:</label><span id="asterisco">*</span><br>
					<select id="pavimentosEquipamento" name="pavimentosEquipamento" class="campoTexto">
					</select> <br>
					<label>Local:</label><span id="asterisco">*</span><br>
					<select id="locaisEquipamento" name="locaisEquipamento" class="campoTexto">
					</select><br>
					<label>Nº do Equipamento:</label><span id="asterisco">*</span><br>
					<input id="equipamento" name="equipamento"  class="campoTexto" type="text" size="20" /><br>
					<label>Equipamento:</label><span id="asterisco">*</span><br>
					<select id="equipamentos" name="equipamentos" class="campoTexto">
					</select><br><br>
					
					<input id="botaoIncluirEquipamento" class="botaoIncluir" type="submit" value="Incluir">
					<!-- Apenas poderá alterar para inativo -->
					<input id="botaoAlterarEquipamento" class="botaoAlterar" name="acao"  type="submit" value="Alterar" style="display:none;">
					<input id="botaoLimparEquipamento" class="botao" type="reset" value="Limpar"><br><br>
					<jsp:include page="../mensagens/mensagensEquipamento.jsp"></jsp:include>	
				
				</div>
				
			</div>
		</article>
		