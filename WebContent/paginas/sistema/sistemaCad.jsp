<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Sistema</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Sistema</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			
			<div id="formCadastro" style="height:400px;"><br><br>
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Cliente</span>
				<jsp:include page="../botoes/abrirFecharCliente.jsp"></jsp:include>
				
				<div id="formCliente" style="height:220px;">
				<input name="idCliente" id="idCliente" type="hidden" /><br>
				<label>Cliente:</label><span id="asterisco">*</span><br>
				<input id="cliente" name="cliente" class="campoTexto" type="text" size="50" /><br><br><br>
				
				<input id="botaoIncluirCliente" class="botaoIncluir" type="submit" value="Incluir">
				<input id="botaoLimparCliente" class="botao" type="reset" value="Limpar"><br><br>
				<jsp:include page="../mensagens/mensagensCliente.jsp"></jsp:include><br><br>
				</div>
				
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Bloco</span>
				<jsp:include page="../botoes/abrirFecharBloco.jsp"></jsp:include>
				
				<div id="formBloco" style="height:220px;"><br>
					<input name="idClienteBloco" id="idClienteBloco" type="hidden" />
					<input name="idBloco" id="idBloco" type="hidden" />
					<label>Cliente:</label><span id="asterisco">*</span><br>
					<input id="clienteBloco" name="clienteBloco" class="campoTexto" type="text" size="50" /><br>
					<label>Bloco:</label><span id="asterisco">*</span><br>
					<input id="bloco" name="bloco"  class="campoTexto" type="text" size="50" /><br><br>
					
					<input id="botaoIncluirBloco" class="botaoIncluir" type="submit" value="Incluir">
					<!-- Apenas poderá alterar para inativo -->
					<input id="botaoAlterarBloco" name="acao" class="botaoAlterar" type="submit" value="Alterar" style="display:none;">
					<input id="botaoLimparBloco" class="botao" type="reset" value="Limpar"><br><br>
					<jsp:include page="../mensagens/mensagensBloco.jsp"></jsp:include>
				
				</div>
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Pavimento</span>
				
				<input type="submit" id="abrirPavimento" value="+" />
				<input type="submit" id="fecharPavimento" value="-" /><br><br>
				
				<div id="formPavimento" style="height:250px;"><br>
					<input name="idClientePavimento" id="idClientePavimento" type="hidden" />
					<input name="idBlocoPavimento" id="idBlocoPavimento" type="hidden" />
					<input name="idPavimento" id="idPavimento" type="hidden" />
					<label>Cliente:</label><span id="asterisco">*</span><br>
					<input id="clientePavimento" name="clientePavimento" class="campoTexto" type="text" size="50" /><br>
					<label>Bloco:</label><span id="asterisco">*</span><br>
					<input id="blocoPavimento" name="blocoPavimento" class="campoTexto" size="50" /><br>
					<label>Pavimento:</label><span id="asterisco">*</span><br>
					<input id="pavimento" name="pavimento" class="campoTexto" type="text" size="50" /><br><br>
					
					<input id="botaoIncluirPavimento" class="botaoIncluir" name="acao" type="submit" value="Incluir">
					<!-- Apenas poderá alterar para inativo -->
					<input id="botaoAlterarPavimento" class="botaoAlterar" name="acao"  type="submit" value="Alterar" style="display:none;">
					<input id="botaoLimparPavimento" class="botao" type="reset" value="Limpar"><br><br>
					<jsp:include page="../mensagens/mensagensPavimento.jsp"></jsp:include>
				
				</div>
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Local</span>
				<jsp:include page="../botoes/abrirFecharLocal.jsp"></jsp:include>
				<div id="formLocal" style="height:300px;"><br>
					<input name="idClienteLocal" id="idClienteLocal" type="hidden" />
					<input name="idBloco" id="idBloco" type="hidden" />
					<input name="idPavimento" id="idPavimento" type="hidden" />
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
				
				</div>
				<span id="corTitulo" style="margin-left:50px;">&there4; Incluir Equipamento</span>
				
				<jsp:include page="../botoes/abrirFecharEquipamento.jsp"></jsp:include>
				<div id="formEquipamento" style="height:400px;"><br>
					<input name="idClienteEquipamento" id="idClienteEquipamento" type="hidden" />
					<input name="idBloco" id="idBloco" type="hidden" />
					<input name="idPavimento" id="idPavimento" type="hidden" />
					<input name="idLocal" id="idLocal" type="hidden" />
					
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
					<label>Nº interno do Equipamento:</label><span id="asterisco">*</span><br>
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
		