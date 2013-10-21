/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR CONTATO - PESQUISAR CLIENTE
 * 
 */

// FUNÇÃO PARA ALTERAR CLIENTE
function alterarContato(contato){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	// FECHA A TELA DE PESQUISA E MOSTRA A DE ALTERAR
	$("#formPesquisa").slideUp();
	$("#formContato").slideDown();
	
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirContato").hide();
	$("#botaoAlterarContato").show();
	//MOSTRAR BOTAO MAIS EM TELA DE PESQUISAR
	$("#fecharP").hide();
	$("#abrirP").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idCliente").val(cliente.idCliente);
	
}
// FUNÇÃO PARA EXCLUIR CONTATO
function excluirContato(id){
}

$(document).ready(function(){
		
		/* FILTRO NÚMEROS */
		$("#numero").filter_input({regex:'[0-9]'});
		$("#numeroAmbiente").filter_input({regex:'[0-9]'});
		/* MÁSCARAS */
		$("#telefoneContato").mask("(99)9999-9999");
		$("#ramalContato").mask("999999");
		$("#celularContato").mask("(99)9999-9999");
	
	
		$("#botaoIncluirContato").click(function(){
			
			if($("#clienteContato").val() == "" || $("#nomeContato").val() == "" || $("#telefoneContato").val() == ""){
				
				$("#mensagemPreencherCamposContato").slideDown();
				
			}else{
				$("#mensagemSucessoInclusao").slideDown();
				/*
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletCliente",    
			        data: {  
			        	nome: $("#cliente").val(),  
			        	cpf: $("#tecnico").val(),
			        	cnpj: $("#chamado").val(),
			        	descricaoAtividade: $("#descricaoAtividade").val(),
						endereco: $("#observacao").val(),
						numero: $("#dataAgenda").val(),
						complemento: $("#cliente").val(),  
			        	bairro: $("#tecnico").val(),
			        	estado: $("#chamado").val(),
			        	cidade: $("#descricaoAtividade").val(),
						telefoneFixo: $("#observacao").val(),
						telefoneCelular: $("#dataAgenda").val(),
						identificacaoAmbiente: $("#cliente").val(),  
			        	enderecoAmbiente: $("#tecnico").val(),
			        	numeroAmbiente: $("#chamado").val(),
			        	complementoAmbiente: $("#descricaoAtividade").val(),
						bairroAmbiente: $("#observacao").val(),
						nomeContato: $("#dataAgenda").val(),
						telefoneContato: $("#dataAgenda").val(),
						ramalContato: $("#cliente").val(),  
			        	celularContato: $("#tecnico").val(),
			        	email: $("#chamado").val(),
			        	senha: $("#descricaoAtividade").val(),
						acao:"Incluir"
			        	
			        },  
			        success: function(result){     
			           LimparCampos("#formCadastro");
			           $("#mensagemSucessoInclusao").slideDown();
			        },
	                 error:function(){
	                	 $("#mensagemErroInclusao").slideDown();   
	                 }      
			    });*/
					
			}	
			
		});
		$("#botaoAlterarContato").click(function(){
			
			
			if($("#").val() == "0"){
					
					$("#mensagemPreencherCampos").slideDown();
					return false;
			}else{
				/*
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletCliente",    
			        data: {  
			        	nome: $("#cliente").val(),  
			        	cpf: $("#tecnico").val(),
			        	cnpj: $("#chamado").val(),
			        	descricaoAtividade: $("#descricaoAtividade").val(),
						endereco: $("#observacao").val(),
						numero: $("#dataAgenda").val(),
						complemento: $("#cliente").val(),  
			        	bairro: $("#tecnico").val(),
			        	estado: $("#chamado").val(),
			        	cidade: $("#descricaoAtividade").val(),
						telefoneFixo: $("#observacao").val(),
						telefoneCelular: $("#dataAgenda").val(),
						identificacaoAmbiente: $("#cliente").val(),  
			        	enderecoAmbiente: $("#tecnico").val(),
			        	numeroAmbiente: $("#chamado").val(),
			        	complementoAmbiente: $("#descricaoAtividade").val(),
						bairroAmbiente: $("#observacao").val(),
						nomeContato: $("#dataAgenda").val(),
						telefoneContato: $("#dataAgenda").val(),
						ramalContato: $("#cliente").val(),  
			        	celularContato: $("#tecnico").val(),
			        	email: $("#chamado").val(),
			        	senha: $("#descricaoAtividade").val(),
						acao:"Alterar"
			        	
			        },  
			        success: function(result){     
			           LimparCampos("#formCadastro");
			           $("#mensagemSucessoAlteração").slideDown();
			        },
	                 error:function(){
	                	 $("#mensagemErroAlteração").slideDown();   
	                 }     
			    });*/
					
			}	
			
		});
		$("#botaoExcluirContato").click(function(){
			
			/* CAMPOS OBRIGATÓRIOS 
			if($("#idEquipamento").val() == ""){
				$("#mensagemErroExclusao").slideDown();
				return false;
			}else{*/
					/* POPUP PARA CONFIRMAR EXCLUSÃO 
	        		$("<div>" + "Confirmar exclusão?" + "</div>").dialog({
	        			title:"Excluir",
	        			resizable: false,
	        			height:100,
	        			modal: true,
	        			buttons: {
	        				"Sim": function(){*/
	        					/* ENVIA POR AJAX O ID PARA EXCLUIR 
	        					$.ajax({  
	        				        type: "post",    
	        				        url: "/climanut/ServletEquipamento", 
	        				        data: {
	        				        	idEquipamento: $("#idEquipamento").val(), 
	        							acao:"Excluir"
	        				        },  
	        				        success: function(result){     
	        				        	$(this).dialog("close");
	    	        					$("<div>" + "Exclusão realizada com sucesso!" + "</div>").dialog({
	    	        						title:"Excluir",
	    	        						resizable: false,
	    	        						height:100,
	    	        						modal: true,
	    	        						buttons: {
	    	        						"Sair": function() {
	    	        							$(this).dialog("close");
	    	        							}
	    	        						}
	    	        					});
	        				        /*},
	        		                 error:function(){
	        		                	 $(this).dialog("close");
		    	        					$("<div>" + "Exclusão não realizada!" + "</div>").dialog({
		    	        						title:"Excluir",
		    	        						resizable: false,
		    	        						height:100,
		    	        						modal: true,
		    	        						buttons: {
		    	        						"Sair": function() {
		    	        							$(this).dialog("close");
		    	        							}
		    	        						}
		    	        					});  
	        		                 }      
	        				    });
	        				},
	        				"Não": function() {
	        				$(this).dialog("close");
	        				}
	        			}
	        		});
			//}*/
		});
		
		/* ESCONDER A MENSAGEM */
		$(".campoTexto").keypress(function(){
			LimparMensagens();
		});
		$("#abrirContato").click(function(){
			
			/* SE ESTIVER ABERTO, FECHA O FORMCADASTRO, ESCONDE O - E MUDA PARA MAIS */
			$("#formCadastro").slideUp();
			$("#formCadastro1").slideUp();
			$("#formPesquisa").slideUp();
			$("#fecharC").hide();
			$("#abrirC").show();
			/* SE ESTIVER COM MENSAGENS A MOSTRA, ESCONDE-AS */
			LimparMensagens();
			$("#formContato").slideDown();
			$("#abrirP").show();
			$("#fecharP").hide();
			$("#abrirC").show();
			$("#fecharP").hide();
			$("#abrirContato").hide();
			$("#fecharContato").show();
			/* AUMENTAR BASE PARA CADASTRO E PESQUISA */
			$("#baseCadPesq").css("height", "1000px");
			/* RETIRAR TELA DE ALTERAR */
			LimparCampos("#formCadastro");
			LimparCampos("#formPesquisa");
			LimparMensagens();
			$(".botaoAlterar").hide();
			$(".botaoIncluir").show();
			$(".alterarTitulo").hide();
			$(".incluirTitulo").show();
				
		});
		$("#fecharContato").click(function(){
			
			$("#formCadastro").slideUp();
			$("#formCadastro1").slideUp();
			$("#formPesquisa").slideUp();
			$("#formContato").slideUp();
			$("#abrirContato").show();
			$("#fecharContato").hide();
			LimparMensagens();
			/* RETIRAR TELA DE ALTERAR */
			LimparCampos("#formContato");
			$(".botaoAlterar").hide();
			$(".botaoIncluir").show();
			$(".alterarTitulo").hide();
			$(".incluirTitulo").show();
			
		});
		
		$("#botaoLimpar").click(function(){
			LimparMensagens();
			LimparCampos("#formCadastro");
			LimparCampos("#formCadastro1");
			
		});
		$("#botaoLimparContato").click(function(){
			LimparMensagens();
			LimparCampos("#formContato");
		});
		
});
