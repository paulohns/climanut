/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR CONTATO - PESQUISAR CLIENTE
 * 
 */

// FUNÇÃO PARA ALTERAR CLIENTE
function alterarCliente(cliente){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	// FECHA A TELA DE PESQUISA E MOSTRA A DE ALTERAR
	$("#formPesquisa").slideUp();
	$("#formCadastro").slideDown();
	$("#formCadastro1").slideDown();
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirCliente").hide();
	$("#botaoAlterarCliente").show();
	//MOSTRAR BOTAO MAIS EM TELA DE PESQUISAR
	$("#fecharP").hide();
	$("#abrirP").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idCliente").val(cliente.idCliente);
	
}
// FUNÇÃO PARA EXCLUIR CONTATO
function excluirContato(id){
	console.log(id);
	alert(id);
	/* POPUP PARA CONFIRMAR EXCLUSÃO */
    $("<div>" + "Confirmar exclusão?" + "</div>").dialog({
    	title:"Excluir",
    	resizable: false,
    	height:100,
    	modal: true,
    	buttons: {
    		"Sim": function(){
   				$(this).dialog("close");
    			/* ENVIA POR AJAX O ID PARA EXCLUIR */ 
    			$.ajax({  
    		        type: "post",    
    		        url: "/climanut/ServletCliente", 
    		        data: {
    		        	idCliente: $("#idCliente").val(), 
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
    			     },
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
}

$(document).ready(function(){
		
		/* FILTRO NÚMEROS */
		$("#numero").filter_input({regex:'[0-9]'});
		$("#numeroAmbiente").filter_input({regex:'[0-9]'});
		/* MÁSCARAS */
		$("#cpf").mask("999.999.999-99");
		$("#cnpj").mask("99.999.999/9999-99");
		$("#telefoneFixo").mask("(99)9999-9999");
		$("#telefoneCelular").mask("(99)9999-9999");
		$("#telefoneAmbiente").mask("(99)9999-9999");
		$("#telefoneContato").mask("(99)9999-9999");
		$("#ramalContato").mask("999999");
		$("#celularContato").mask("(99)9999-9999");
		
		
		/* VALIDAR CAMPO CPF */
		$("#cpf").change(function(){
			alert("Validar CPF");
		});
		/* VALIDAR CAMPO CNPJ */
		$("#cnpj").change(function(){
			alert("Validar CNPJ");
		});
		
		$("input:radio[id=tipoFisica]").click(function(){
			LimparMensagens();
			$("#idFederal").css("display","block");
			$("#campoCnpj").slideUp();
			$("#campoCpf").slideDown();	
		});
		$("input:radio[id=tipoJuridica]").click(function(){
			LimparMensagens();
			$("#idFederal").css("display","block");
			$("#campoCpf").slideUp();	
			$("#campoCnpj").slideDown();
		});
		
	
		$("#botaoIncluirCliente").click(function(){
			
			
			if($("#estados option:selected").val() == "0" || $("#estados option:selected").val() == "0" || $("#nome").val() == "" || 
			    $("#endereco").val() == "" || $("#numero").val() == "" || 
			    $("#email").val() == "" || $("#senha").val() == "" || 
			    $("#identificacaoAmbiente").val() == "" || $("#enderecoAmbiente").val() == "" ||
			    $("#numeroAmbiente").val() == "" || $("#bairroAmbiente").val() == "" || $("#telefoneAmbiente").val() == "" ||
			    !$("#tipoFisica").is(":checked")&& !$("#tipoJuridica").is(":checked")||
			    $("#tipoFisica").is(":checked") && $("#cpf").val() == "" || 
			    $("#tipoJuridica").is(":checked")&& $("#cnpj").val() == "" ){
				
				$("#mensagemPreencherCampos").slideDown();
				return false;
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
		$("#botaoAlterarCliente").click(function(){
			
			
			if($("#estados option:selected").val() == "0" || $("#cidades option:selected").val() == "0" || $("#nome").val() == "" || 
				    $("#endereco").val() == "" || $("#numero").val() == "" || 
				    $("#email").val() == "" || $("#senha").val() == "" || 
				    $("#identificacaoAmbiente").val() == "" || $("#enderecoAmbiente").val() == "" ||
				    $("#numeroAmbiente").val() == "" || $("#bairroAmbiente").val() == "" || $("#telefoneAmbiente").val() == "" ||
				    !$("#tipoFisica").is(":checked")&& !$("#tipoJuridica").is(":checked")||
				    $("#tipoFisica").is(":checked") && $("#cpf").val() == "" || 
				    $("#tipoJuridica").is(":checked")&& $("#cnpj").val() == "" ){
					
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
		$("#botaoExcluirCliente").click(function(){
			
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
		
		$("#tipoFisica").change(function(){
			LimparMensagens();
		});
		$("#tipoJuridica").change(function(){
			LimparMensagens();
		});	
		$("#estados").change(function(){
			LimparMensagens();
		});
		$("#cidades").change(function(){
			LimparMensagens();	
		});
			
		$("#botaoLimpar").click(function(){
			$("#idFederal").slideUp();
			LimparMensagens();
			LimparCampos("#formCadastro");
			LimparCampos("#formCadastro1");
			
		});
		
});
