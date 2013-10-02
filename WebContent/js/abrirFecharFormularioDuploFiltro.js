/**
 * JQUERY PARA ABRIR E FECHAR FORMULÁRIOS DE
 * CADASTRO E PESQUISA
 */

$(document).ready(function(){
			
		$("#abrirC").click(function(){
				
			/* SE ESTIVER ABERTO, FECHA O FORMPESQUISA, ESCONDE O - E MUDA PARA + */
			$("#formPesquisaFiltro").slideUp();
			$("#formPesquisa").slideUp();
			$("#fecharP").hide();
			$("#abrirP").show();
				
			$("#formCadastro").slideDown();
			$("#formCadastro1").slideDown();
			$("#abrirC").hide();
			$("#fecharC").show();
			/* AUMENTAR BASE PARA CADASTRO E PESQUISA */
			$("#baseCadPesq").css("height", "1400px");
			//ALTERAÇÃO
			$(".botaoIncluir").show();
			$(".botaoAlterar").hide();
				
		});
		$("#fecharC").click(function(){
			
			$("#formCadastro").slideUp();
			$("#formCadastro1").slideUp();
			$("#abrirC").show();
			$("#fecharC").hide();
			LimparMensagens();
			/* RETIRAR TELA DE ALTERAR */
			LimparCampos("#formCadastro");
			LimparCampos("#formCadastro1");
			$(".alterarTitulo").hide();
			$(".incluirTitulo").show();
				
		});
		$("#abrirP").click(function(){
				
			/* SE ESTIVER ABERTO, FECHA O FORMCADASTRO, ESCONDE O - E MUDA PARA MAIS */
			$("#formCadastro").slideUp();
			$("#formCadastro1").slideUp();
			$("#fecharC").hide();
			$("#abrirC").show();
			/* SE ESTIVER COM MENSAGENS A MOSTRA, ESCONDE-AS */
			LimparMensagens();
				
			$("#formPesquisaFiltro").slideDown();
			$("#abrirP").hide();
			$("#fecharP").show();
			/* AUMENTAR BASE PARA CADASTRO E PESQUISA */
			$("#baseCadPesq").css("height", "1200px");
			/* RETIRAR TELA DE ALTERAR */
			LimparCampos("#formCadastro");
			LimparCampos("#formCadastro1");
			LimparMensagens();
			$(".botaoAlterar").hide();
			$(".botaoIncluir").show();
			$(".alterarTitulo").hide();
			$(".incluirTitulo").show();
				
		});
		$("#fecharP").click(function(){
				
			$("#formPesquisaFiltro").slideUp();
			$("#formPesquisa").slideUp();
			$("#abrirP").show();
			$("#fecharP").hide();
			LimparMensagens();
	
		});
			
});
/*ADAPTAR PARTE DE ABRIR 2 FORMS PARA CLIENTE*/
/*
 * $(document).ready(function(){
			
			
			
			$("#abrirC").click(function(){
				
				$("#formCadastro").slideDown();
				$("#formCadastro1").slideDown();
				$("#abrirC").hide();
				$("#fecharC").show();
				
			});
			$("#fecharC").click(function(){
				
				$("#formCadastro").slideUp();
				$("#formCadastro1").slideUp();
				$("#abrirC").show();
				$("#fecharC").hide();
				$("#mensagemErroCad").slideUp();
				$("#mensagemSucessoCad").slideUp();
				
				
			});
*/
