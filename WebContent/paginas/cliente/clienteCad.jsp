<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Cliente</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Cliente</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			
			<div id="formCadastro" style="float:left;height:700px;"><br>
				<input name="idCliente" id="idCliente" type="hidden" /><br>
				<label>Nome/Razão Social:</label><span id="asterisco">*</span><br>
				<input id="nome" name="nome" class="campoTexto" type="text" size="60" maxlength="50" /><br>
				<label>Tipo:</label><span id="asterisco">*</span><br>
				<label>Física </label>
				<input id="tipoFisica" name="tipo" type="radio" size="18" value="1"  />&nbsp;&nbsp;&nbsp;&nbsp;
				<label>Jurídica </label>
				<input id="tipoJuridica" name="tipo" type="radio" size="18" value="2"  /><br>
				<div id="idFederal" style="display:none;height:47px;">
					<div id="campoCpf" style="display:none">
						<label>CPF:</label><span id="asterisco" >*</span><br>
						<input id="cpf" name="cpf" class="campoTexto" type="text" size="18" maxlength="11"  /><br>
					</div>
					<div id="campoCnpj" style="display:none">
						<label>CNPJ:</label><span id="asterisco" >*</span><br>
						<input id="cnpj" name="cnpj" class="campoTexto" type="text" size="18" maxlength="14"  /><br>
					</div>
				</div>
				<label>CEP:</label><span id="asterisco">*</span><br>
				<input id="cep" name="cep" class="campoTexto" type="text" size="18" maxlength="9" /><br>
				<label>Endereço:</label><span id="asterisco">*</span><br>
				<input id="endereco" name="endereco" class="campoTexto" type="text" size="60" maxlength="50" /><br>
				<label>Número:</label><span id="asterisco">*</span><br>
				<input id="numero" name="numero" class="campoTexto" type="text" size="18" maxlength="5" /><br>
				<label>Complemento:</label><br>
				<input id="complemento" name="complemento" class="campoTexto" class="campoTexto" type="text" size="60" maxlength="100"  /><br>
				<label>Bairro:</label><br>
				<input id="bairro" name="bairro" class="campoTexto" type="text" size="60" maxlength="50" /><br>
				<label>Estado:</label><span id="asterisco">*</span><br>
				<select id="estados" name="estados" class="campoTexto"></select><br>
				<label>Cidade:</label><span id="asterisco">*</span><br>
				<select id="cidades" name="cidades" class="campoTexto"></select><br>
				<label>Telefone Fixo:</label><br>
				<input id="telefoneFixo" name="telefoneFixo" class="campoTexto" type="text" size="18" maxlength="15"  /><br>
				<label>Telefone Celular:</label><br>
				<input id="telefoneCelular" name="telefoneCelular" class="campoTexto" type="text" size="18" maxlength="15"  /><br><br><br>
				
				<input id="botaoIncluirCliente" name="acao" class="botao" type="submit" value="Incluir">
				<input id="botaoAlterarCliente" name="acao" class="botao" type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include><br><br>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
			</div>
			<div id="formCadastro1" class="formCadastroCliente" style="height:700px;" >
				<label id="tituloMedio" >&bull;Identificação do Ambiente ou Conjunto de Ambientes</label><br><br>
				<label>Identificação do Ambiente :</label><span id="asterisco">*</span><br>
				<input id="identificacaoAmbiente" name="identificacaoAmbiente" class="campoTexto" type="text" size="60" maxlength="50"  /><br>
				<label>Endereço:</label><span id="asterisco">*</span><br>
				<input id="enderecoAmbiente" name="enderecoAmbiente" class="campoTexto" type="text" size="60" maxlength="50" /><br>
				<label>Número:</label><span id="asterisco">*</span><br>
				<input id="numeroAmbiente" name="numeroAmbiente" class="campoTexto" type="text" size="18" maxlength="5" /><br>
				<label>Complemento:</label><br>
				<input id="complementoAmbiente" name="complementoAmbiente" class="campoTexto" type="text" size="60" maxlength="100" /><br>
				<label>Bairro:</label><span id="asterisco">*</span><br>
				<input id="bairroAmbiente" name="bairroAmbiente" class="campoTexto" type="text" size="60" maxlength="50" /><br>
				<label>Telefone:</label><span id="asterisco">*</span><br>
				<input id="telefoneAmbiente" name="telefoneAmbiente" class="campoTexto"  type="text" size="18" maxlength="14" /><br><br>
				<label id="tituloMedio">&bull; Dados de Login</label><br><br>
				<label>Email:</label><span id="asterisco">*</span><br>
				<input id="email" name="email" class="campoTexto" type="text" size="40" maxlength="50"  /><br>
				<label>Senha:</label><span id="asterisco" >*</span><br>
				<input id="senha" name="senha" class="campoTexto" type="text" size="40" maxlength="15"  /><br>
			</div>
			
			
		</article>
	
