/**
 * LIMPAR CAMPOS DOS FORMUL�RIOS E MENSAGENS
 */
	/* FUN��O PARA LIMPAR CAMPOS */	
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
		}
