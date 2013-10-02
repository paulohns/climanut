/**
 * JQUERY PARA ABRIR E FECHAR FORMULÁRIOS DE
 * CADASTRO E PESQUISA
 */

$(document).ready(function(){
			
		$("#abrirC").click(function(){
				
			/* SE ESTIVER ABERTO, FECHA O FORMPESQUISA, ESCONDE O - E MUDA PARA + */
			$("#formPesquisa").slideUp();
			$("#fecharP").hide();
			$("#abrirP").show();
				
			$("#formCadastro").slideDown();
			$("#formCliente").slideDown();
			$("#formBloco").slideDown();
			$("#formPavimento").slideDown();
			$("#formLocal").slideDown();
			$("#formEquipamento").slideDown();
			$("#abrirC").hide();
			$("#fecharC").show();
			/* AUMENTAR BASE PARA CADASTRO E PESQUISA */
			$("#baseCadPesqSistema").css("height", "2200px"); 
				
		});
		$("#fecharC").click(function(){
			
			$("#formCadastro").slideUp();
			$("#abrirC").show();
			$("#fecharC").hide();
			LimparMensagens();
				
		});
		$("#abrirP").click(function(){
				
			/* SE ESTIVER ABERTO, FECHA O FORMCADASTRO, ESCONDE O - E MUDA PARA MAIS */
			$("#formCadastro").hide();
			$("#fecharC").hide();
			$("#abrirC").show();
				
			$("#formPesquisaFiltro").slideDown();
			$("#abrirP").hide();
			$("#fecharP").show();
			/* AUMENTAR BASE PARA CADASTRO E PESQUISA */
			$("#baseCadPesqSistema").css("height", "1200px");
				
		});
		$("#fecharP").click(function(){
				
			$("#formPesquisaFiltro").slideUp();
			$("#abrirP").show();
			$("#fecharP").hide();
			LimparMensagens();
	
		});
		
			
});
