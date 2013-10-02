<!DOCTYPE html>

		<article class="cadastrar" ><br>
			<span id="corTitulo" class="incluirTitulo" > Incluir Cliente</span>
			<span id="corTitulo" class="alterarTitulo" style="display:none;"> Alterar Cliente</span>
			<jsp:include page="../botoes/abrirFecharC.jsp"></jsp:include>
			
			<div id="formCadastro" style="float:left;height:650px;"><br>
				<input name="idCliente" id="idCliente" type="hidden" /><br>
				<label>Nome/Razão Social:</label><span id="asterisco">*</span><br>
				<input id="nome" name="nome" class="campoTexto" type="text" size="60" maxlength="" /><br>
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
						<input id="cnpj" name="cnpj" class="campoTexto" type="text" size="18" maxlength=""  /><br>
					</div>
				</div>
				<label>CEP:</label><span id="asterisco">*</span><br>
				<input id="cep" name="cep" class="campoTexto" type="text" size="18" maxlength="" /><br>
				<label>Endereço:</label><span id="asterisco">*</span><br>
				<input id="endereco" name="endereco" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Número:</label><span id="asterisco">*</span><br>
				<input id="numero" name="numero" class="campoTexto" type="text" size="18" maxlength="" /><br>
				<label>Complemento:</label><br>
				<input id="complemento" name="complemento" class="campoTexto" class="campoTexto" type="text" size="60" maxlength=""  /><br>
				<label>Bairro:</label><br>
				<input id="bairro" name="bairro" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Estado:</label><span id="asterisco">*</span><br>
				<select id="estados" name="estados" class="campoTexto"></select><br>
				<label>Cidade:</label><span id="asterisco">*</span><br>
				<select id="cidades" name="cidades" class="campoTexto"></select><br>
				<label>Telefone Fixo:</label><br>
				<input id="telefoneFixo" name="telefoneFixo" class="campoTexto" type="text" size="18" maxlength=""  /><br>
				<label>Telefone Celular:</label><br>
				<input id="telefoneCelular" name="telefoneCelular" class="campoTexto" type="text" size="18" maxlength=""  /><br><br><br>
				
				<input id="botaoIncluirCliente" name="acao" class="botao" type="submit" value="Incluir">
				<input id="botaoAlterarCliente" name="acao" class="botao" type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimpar.jsp"></jsp:include>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
			</div>
			<div id="formCadastro1" class="formCadastroCliente" >
				<label id="tituloMedio" >&bull;Identificação do Ambiente ou Conjunto de Ambientes</label><br><br>
				<label>Identificação do Ambiente :</label><span id="asterisco">*</span><br>
				<input id="identificacaoAmbiente" name="identificacaoAmbiente" class="campoTexto" type="text" size="60" maxlength=""  /><br>
				<label>Endereço:</label><span id="asterisco">*</span><br>
				<input id="enderecoAmbiente" name="enderecoAmbiente" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Número:</label><span id="asterisco">*</span><br>
				<input id="numeroAmbiente" name="numeroAmbiente" class="campoTexto" type="text" size="18" maxlength="" /><br>
				<label>Complemento:</label><br>
				<input id="complementoAmbiente" name="complementoAmbiente" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Bairro:</label><span id="asterisco">*</span><br>
				<input id="bairroAmbiente" name="bairroAmbiente" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Telefone:</label><span id="asterisco">*</span><br>
				<input id="telefoneAmbiente" name="telefoneAmbiente" class="campoTexto"  type="text" size="18" maxlength="" /><br><br>
				<label id="tituloMedio">&bull; Dados de Login</label><br><br>
				<label>Email:</label><span id="asterisco">*</span><br>
				<input id="email" name="email" class="campoTexto" type="text" size="40"  /><br>
				<label>Senha:</label><span id="asterisco" >*</span><br>
				<input id="senha" name="senha" class="campoTexto" type="password" size="40" maxlength="8"  /><br>
			</div>
			<div id="formContato">
				<label id="corTitulo" >&there4; Incluir Contato</label><br>
				<div id="separaContato"></div><br>
				<label>Cliente:</label><br>
				<input id="clienteContato" name="clienteContato" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Nome:</label><br>
				<input id="nomeContato" name="nomeContato" class="campoTexto" type="text" size="60" maxlength="" /><br>
				<label>Telefone Fixo:</label><br>
				<input id="telefoneContato" name="telefoneContato" class="campoTexto" type="text" size="18" maxlength=""  /><br>
				<label>Ramal:</label><br>
				<input id="ramalContato" name="ramalContato" class="campoTexto" type="text" size="18" maxlength="" /><br>
				<label>Telefone Celular:</label><br>
				<input id="celularContato"  name="celularContato" class="campoTexto" type="text" size="18" maxlength="" /><br><br><br>
				
				<input id="botaoIncluirContato" name="acao" class="botaoIncluir" type="submit" value="Incluir">
				<input id="botaoAlterarContato" name="acao" class="botaoAlterar" type="submit" value="Alterar" style="display:none;">
				<jsp:include page="../botoes/botaoLimparContato.jsp"></jsp:include>
				<jsp:include page="../mensagens/mensagens.jsp"></jsp:include>
			</div>
			
		</article>
	
