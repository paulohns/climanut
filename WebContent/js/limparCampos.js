/**
 * LIMPAR CAMPOS DOS FORMULÁRIOS E MENSAGENS
 */
	/* FUNÇÃO PARA LIMPAR CAMPOS */	
		function LimparCampos(container) {
			  $(container).find(":input, select").each(function () {
			       switch (this.type) {
			           case "file":
			           case "password":
			           case "text":
			           case "textarea":
			        	   $(this).val("");
			               break;
			           case "checkbox":
			           case "radio":
			               this.checked = false;
			       }

			       $(this).children("option:selected").removeAttr("selected").end()
			              .children("option:first").attr("selected", "selected");
			    });
		}
		function LimparMensagens() {
			$(".msg").slideUp();
			$("#mensagemPreencherCampos").slideUp();
			$("#mensagemSucessoInclusao").slideUp();
			$("#mensagemErroInclusao").slideUp();
			$("#mensagemSucessoAlteracao").slideUp();
			$("#mensagemErroAlteracao").slideUp();
			$("#mensagemInformeFiltro").slideUp();
			$("#mensagemInformeDatas").slideUp();
			$("#mensagemErroFiltro").slideUp();
			$("#mensagemPreencherCliente").slideUp();
			$("#mensagemPreencherBloco").slideUp();
			$("#mensagemPreencherPavimento").slideUp();
			$("#mensagemPreencherLocal").slideUp();
			$("#mensagemPreencherEquipamento").slideUp();
			$("#mensagemPreencherCamposCliente").slideUp();
			$("#mensagemPreencherCamposBloco").slideUp();
			$("#mensagemPreencherCamposPavimento").slideUp();
			$("#mensagemPreencherCamposLocal").slideUp();
			$("#mensagemPreencherCamposEquipamento").slideUp();
			$("#mensagemSucessoInclusaoCliente").slideUp();
			$("#mensagemSucessoInclusaoBloco").slideUp();
			$("#mensagemSucessoInclusaoPavimento").slideUp();
			$("#mensagemSucessoInclusaoLocal").slideUp();
			$("#mensagemSucessoInclusaoEquipamento").slideUp();
		}
