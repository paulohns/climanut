/**
 * JQUERY PARA ABRIR E FECHAR FORMULÁRIOS DE
 * CADASTRO E PESQUISA
 */

$(document).ready(function(){
			
		$("#abrirC").click(function(){
				
			/* SE ESTIVER ABERTO, FECHA O FORMPESQUISA, ESCONDE O - E MUDA PARA + */
			$("#formPesquisa").slideUp();
			$("#formPesquisaFiltro").slideUp();
			$("#fecharP").hide();
			$("#abrirP").show();
				
			$("#formCadastro").slideDown();
			//$("#formCliente").slideDown();
			//$("#formBloco").slideDown();
			//$("#formPavimento").slideDown();
			//$("#formLocal").slideDown();
			//$("#formEquipamento").slideDown();
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
			$("#formPesquisa").slideUp();
			$("#abrirP").show();
			$("#fecharP").hide();
			LimparMensagens();
	
		});
		/* CLIENTE */
		$("#abrirCliente").click(function(){
			
			/*FECHA TODOS QUE ESTIVEREM ABERTOS*/
			$("#formBloco").slideUp();$("#abrirBloco").show();$("#fecharBloco").hide();
			$("#formPavimento").slideUp();$("#abrirPavimento").show();$("#fecharPavimento").hide();
			$("#formLocal").slideUp();$("#abrirLocal").show();$("#fecharLocal").hide();
			$("#formEquipamento").slideUp();$("#abrirEquipamento").show();$("#fecharEquipamento").hide();
			/* FORM CADASTRO 700px*/
			$("#formCadastro").animate({height:600},500);	
			$("#formCliente").slideDown();
			$("#abrirCliente").hide();
			$("#fecharCliente").show();
				
		});
		$("#fecharCliente").click(function(){
				
			$("#formCliente").slideUp();
			$("#abrirCliente").show();
			$("#fecharCliente").hide();
			/* VOLTA PARA HEIGHT ANTERIOR */
			$("#formCadastro").animate({height:400},500);
			LimparMensagens();
				
		});
		/* LOCALIZAÇÃO */	
		$("#abrirBloco").click(function(){
			
			/*FECHA TODOS QUE ESTIVEREM ABERTOS*/
			$("#formCliente").slideUp();$("#abrirCliente").show();$("#fecharCliente").hide();
			$("#formPavimento").slideUp();$("#abrirPavimento").show();$("#fecharPavimento").hide();
			$("#formLocal").slideUp();$("#abrirLocal").show();$("#fecharLocal").hide();
			$("#formEquipamento").slideUp();$("#abrirEquipamento").show();$("#fecharEquipamento").hide();
			/* FORM CADASTRO 700px*/
			$("#formCadastro").animate({height:620},500);	
			$("#formBloco").slideDown();
			$("#abrirBloco").hide();
			$("#fecharBloco").show();
				
		});
		$("#fecharBloco").click(function(){
				
			$("#formBloco").slideUp();
			$("#abrirBloco").show();
			$("#fecharBloco").hide();
			/* VOLTA PARA HEIGHT ANTERIOR */
			$("#formCadastro").animate({height:400},500);
			LimparMensagens();
				
		});
		$("#abrirPavimento").click(function(){
				
			/*FECHA TODOS QUE ESTIVEREM ABERTOS*/
			$("#formCliente").slideUp();$("#abrirCliente").show();$("#fecharCliente").hide();
			$("#formBloco").slideUp();$("#abrirBloco").show();$("#fecharBloco").hide();
			$("#formLocal").slideUp();$("#abrirLocal").show();$("#fecharLocal").hide();
			$("#formEquipamento").slideUp();$("#abrirEquipamento").show();$("#fecharEquipamento").hide();
			/* FORM CADASTRO 700px*/
			$("#formCadastro").animate({height:650},500);
			$("#formPavimento").slideDown();
			$("#abrirPavimento").hide();
			$("#fecharPavimento").show();
				
				
		});
		$("#fecharPavimento").click(function(){
				
			$("#formPavimento").slideUp();
			$("#abrirPavimento").show();
			$("#fecharPavimento").hide();
			/* VOLTA PARA HEIGHT ANTERIOR */
			$("#formCadastro").animate({height:400},500);
			LimparMensagens();
						
		});
		$("#abrirLocal").click(function(){
				
			/*FECHA TODOS QUE ESTIVEREM ABERTOS*/
			$("#formCliente").slideUp();$("#abrirCliente").show();$("#fecharCliente").hide();
			$("#formPavimento").slideUp();$("#abrirPavimento").show();$("#fecharPavimento").hide();
			$("#formBloco").slideUp();$("#abrirBloco").show();$("#fecharBloco").hide();
			$("#formEquipamento").slideUp();$("#abrirEquipamento").show();$("#fecharEquipamento").hide();
			/* FORM CADASTRO 700px*/
			$("#formCadastro").animate({height:700},500);
			$("#formLocal").slideDown();
			$("#abrirLocal").hide();
			$("#fecharLocal").show();
	
		});
		$("#fecharLocal").click(function(){
				
			$("#formLocal").slideUp();
			$("#abrirLocal").show();
			$("#fecharLocal").hide();
			/* VOLTA PARA HEIGHT ANTERIOR */
			$("#formCadastro").animate({height:400},500);
			LimparMensagens();
				
		});
		$("#abrirEquipamento").click(function(){
				
			/*FECHA TODOS QUE ESTIVEREM ABERTOS*/
			$("#formCliente").slideUp();$("#abrirCliente").show();$("#fecharCliente").hide();
			$("#formBloco").slideUp();$("#abrirBloco").show();$("#fecharBloco").hide();
			$("#formPavimento").slideUp();$("#abrirPavimento").show();$("#fecharPavimento").hide();
			$("#formLocal").slideUp();$("#abrirLocal").show();$("#fecharLocal").hide();
			/* FORM CADASTRO 700px*/
			$("#formCadastro").animate({height:800},500);
			$("#formEquipamento").slideDown();
			$("#abrirEquipamento").hide();
			$("#fecharEquipamento").show();
						
		});
		$("#fecharEquipamento").click(function(){
				
			$("#formEquipamento").slideUp();
			$("#abrirEquipamento").show();
			$("#fecharEquipamento").hide();
			/* VOLTA PARA HEIGHT ANTERIOR */
			$("#formCadastro").animate({height:400},500);
			LimparMensagens();
				
		});
		
		/* RETIRA MENSAGEM DA TELA */
		$(".campoTexto").keypress(function(){
			LimparMensagens();
			
		});
		$("#botaoLimparCliente").click(function(){
			LimparCampos("#formCliente");
			LimparMensagens();
		});
		$("#botaoLimparBloco").click(function(){
			LimparCampos("#formBloco");
			LimparMensagens();
		});
		$("#botaoLimparPavimento").click(function(){
			LimparCampos("#formPavimento");
			LimparMensagens();
		});
		$("#botaoLimparLocal").click(function(){
			LimparCampos("#formLocal");
			LimparMensagens();
		});
		$("#botaoLimparEquipamento").click(function(){
			LimparCampos("#formEquipamento");
			LimparMensagens();
		});
		$("#blocos").change(function(){
			LimparMensagens();
		});
		$("#pavimentos").change(function(){
			LimparMensagens();
		});
		$("#locais").change(function(){
			LimparMensagens();
		});
		$("#equipamentos").change(function(){
			LimparMensagens();
		});
		
		
			
});
