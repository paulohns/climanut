/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR - PESQUISAR CHAMADO : CLIENTE
 * 
 */

// FUNÇÃO PARA ALTERAR CHAMADO: CLIENTE
function alterarChamadoCliente(chamado){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	// FECHA A TELA DE PESQUISA E MOSTRA A DE ALTERAR
	$("#formPesquisa").slideUp();
	$("#formCadastro").slideDown();
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirChamado").hide();
	$("#botaoAlterarChamado").show();
	//MOSTRAR BOTAO MAIS EM TELA DE PESQUISAR
	$("#fecharP").hide();
	$("#abrirP").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idChamado").val(chamado.idChamado);
	
}

$(document).ready(function(){
		
	$("#botaoIncluirChamadoCliente").click(function(){

		/* CAMPOS OBRIGATÓRIOS */
		if($("#descricao").val() == "0" ){
			$("#mensagemPreencherCampos").slideDown();
			return false;
		}else{
			$.ajax({  
		        type: "post",    
		        url: "/climanut/ServletChamado", 
		        data: {
		        	cliente: $("#cliente").val(),  
		        	status: $("#status").val(),  
		        	descricao: $("#mdescricaoodelo").val(),
		        	dataAbertura: $("#dataAbertura").val(),
		        	observacao: $("#observacao").val(),
					acao:"Incluir"
		        	
		        },  
		        success: function(result){     
		           LimparCampos("#formCadastro");
		           $("#mensagemSucessoInclusao").slideDown();
		        },
                 error:function(){
                	 $("#mensagemErroInclusao").slideDown();   
                 }      
		    });  
		}
	});
		$("#botaoAlterarChamadoCliente").click(function(){

			/* CAMPOS OBRIGATÓRIOS */
			if($("#cliente").val() == "0" || $("#staus").val() == ""){
				$("#mensagemPreencherCampos").slideDown();
				return false;
			}else{
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletChamado", 
			        data: {
			        	cliente: $("#cliente").val(),  
			        	status: $("#status").val(),  
			        	descricao: $("#mdescricaoodelo").val(),
			        	dataAbertura: $("#dataAbertura").val(),
			        	observacao: $("#observacao").val(),
						acao:"Alterar"
			        	
			        },  
			        success: function(result){     
			           LimparCampos("#formCadastro");
			           $("#mensagemSucessoInclusao").slideDown();
			        },
	                 error:function(){
	                	 $("#mensagemErroInclusao").slideDown();   
	                 }      
			    });  
			}
		});
		
		/* ESCONDER A MENSAGEM */
		$(".campoTexto").keypress(function(){
			LimparMensagens();	
		});
		$("#periodicidade").change(function(){
			LimparMensagens();
		});
			
		$("#botaoLimpar").click(function(){
			LimparCampos("#formCadastro");
			LimparMensagens();
		});
	
});
