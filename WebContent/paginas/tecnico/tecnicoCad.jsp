<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Técnico</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Técnico</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			<div id="formCadastro" style="float:left;height:700px">
				<input name="idTecnico" id="idTecnico" type="hidden" /><br>
				<label>Nome:</label><span id="asterisco">*</span><br>
				<input id="nome" name="nome" class="campoTexto" type="text" size="60" /><br>
				<label>CPF:</label><span id="asterisco">*</span><br>
				<input id="cpf" type="text" name="cpf" class="campoTexto" size="18" maxlength="11"  /><br>
				<label>Engenheiro:</label><br>
				<input id="engenheiro" name="engenheiro" class="campoTexto" type="checkbox" size="18"  value="1"  /><br>
				<label>Registro:</label><span id="asterisco">*</span><br>
				<input id="registro" name="registro" class="campoTexto" type="text" size="18" maxlength="11" /><br>
				<label>ART:</label><span id="asterisco">*</span><br>
				<input id="art" name="art" class="campoTexto" type="text" size="18" maxlength="11" /><br>
				<label>CEP:</label><span id="asterisco">*</span><br>
				<input id="cep" name="cep" class="campoTexto" type="text" size="18" maxlength="" /><br>
				<label>Endereço:</label><br>
				<input id="endereco" name="endereco" class="campoTexto" type="text" size="60" /><br>
				<label>Número:</label><br>
				<input id="numero" name="numero" class="campoTexto" type="text" size="18"  /><br><br>
				<label id="tituloMedio">&bull; Dados de Login</label><br><br>
				<label>Email:</label><span id="asterisco">*</span><br>
				<input id="email" name="email" class="campoTexto" type="text" size="60" /><br>
				<label>Senha:</label><span id="asterisco">*</span><br>
				<input id="senha" name="senha" class="campoTexto" type="password" size="18" /><br><br><br>			
				
				<input id="botaoIncluirTecnico" class="botaoIncluir" name="acao" type="submit" value="Incluir">
				<input id="botaoAlterarTecnico" class="botaoAlterar" name="acao" type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
			
			</div>
			<div id="formCadastro1" style="float:left;height:700px"><br>
				<label>Complemento:</label><br>
				<input id="complemento" name="complemento" class="campoTexto" type="text" size="60" /><br>
				<label>Bairro:</label><br>
				<input id="bairro" name="bairro" class="campoTexto" type="text" size="60" /><br>
				<label>Estado:</label><br>
				<select id="estados"	name="estados" class="campoTexto" >
				<option value="0"> &nbsp;&nbsp;&nbsp;&nbsp;Selecione</option>
				<option value="1"> &nbsp;&nbsp;Acre&nbsp;&nbsp;</option>
				<option value="2"> &nbsp;&nbsp;Alagoas&nbsp;&nbsp;</option>
				<option value="3"> &nbsp;&nbsp;Amapá&nbsp;&nbsp;</option>
				<option value="4"> &nbsp;&nbsp;Amazonas&nbsp;&nbsp;</option>
				<option value="5"> &nbsp;&nbsp;Bahia&nbsp;&nbsp;</option>
				<option value="6"> &nbsp;&nbsp;Ceará&nbsp;&nbsp;</option>
				<option value="7"> &nbsp;&nbsp;Distrito Federal&nbsp;&nbsp;</option>
				<option value="8"> &nbsp;&nbsp;Goiás&nbsp;&nbsp;</option>
				<option value="9"> &nbsp;&nbsp;Maranhão&nbsp;&nbsp;</option>
				<option value="10">&nbsp;&nbsp;Mato Grosso&nbsp;&nbsp;</option>
				<option value="11">&nbsp;&nbsp;Mato Grosso do Sul&nbsp;&nbsp;</option>
				<option value="12">&nbsp;&nbsp;Pará&nbsp;&nbsp;</option>
				<option value="13">&nbsp;&nbsp;Paraíba&nbsp;&nbsp;</option>
				<option value="14">&nbsp;&nbsp;Paraná&nbsp;&nbsp;</option>
				<option value="15">&nbsp;&nbsp;Pernambuco&nbsp;&nbsp;</option>
				<option value="16">&nbsp;&nbsp;Piauí&nbsp;&nbsp;</option>
				<option value="17">&nbsp;&nbsp;Rio de Janeiro&nbsp;&nbsp;</option>
				<option value="18">&nbsp;&nbsp;Rio Grande do Norte&nbsp;&nbsp;</option>
				<option value="19">&nbsp;&nbsp;Rio Grande do Sul&nbsp;&nbsp;</option>
				<option value="20">&nbsp;&nbsp;Rondônia&nbsp;&nbsp;</option>
				<option value="21">&nbsp;&nbsp;São Paulo&nbsp;&nbsp;</option>
				<option value="22">&nbsp;&nbsp;Santa Catarina&nbsp;&nbsp;</option>
				<option value="23">&nbsp;&nbsp;Tocantins&nbsp;&nbsp;</option>
				</select><br>
				<label>Cidade:</label><br><select id="cidades" name="cidades" class="campoTexto"></select>  <br>
				<label>Telefone Fixo:</label><br>
				<input id="telefoneFixo" name="telefoneFixo" class="campoTexto" type="text" size="18" /><br>
				<label>Telefone Celular:</label><br>
				<input id="telefoneCelular" name="telefoneCelular" class="campoTexto" type="text" size="18" /><br>
				
			</div>
		</article>
		