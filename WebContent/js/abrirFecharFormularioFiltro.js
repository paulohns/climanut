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
			$("#abrirC").hide();
			$("#fecharC").show();
			//ALTERAÇÃO
			$(".botaoIncluir").show();
			$(".botaoAlterar").hide();
			
				
		});
		$("#fecharC").click(function(){
			
			$("#formCadastro").slideUp();
			$("#abrirC").show();
			$("#fecharC").hide();
			LimparMensagens();
			/* RETIRAR TELA DE ALTERAR */
			LimparCampos("#formCadastro");
			$(".alterarTitulo").hide();
			$(".incluirTitulo").show();
				
		});
		$("#abrirP").click(function(){
				
			/* SE ESTIVER ABERTO, FECHA O FORMCADASTRO, ESCONDE O - E MUDA PARA MAIS */
			$("#formCadastro").slideUp();
			$("#fecharC").hide();
			$("#abrirC").show();
			/* SE ESTIVER COM MENSAGENS A MOSTRA, ESCONDE-AS */
			LimparMensagens();
				
			$("#formPesquisaFiltro").slideDown();
			$("#abrirP").hide();
			$("#fecharP").show();
			/* AUMENTAR BASE PARA CADASTRO E PESQUISA COM FILTROS */
			$("#baseCadPesqFiltro").css("height", "1400px");
			$("#baseCadPesq").css("height", "1400px");
			/* RETIRAR TELA DE ALTERAR */
			LimparCampos("#formCadastro");
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
