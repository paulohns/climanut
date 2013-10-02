/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR - PESQUISAR TÉCNICO 
 * 
 */

// FUNÇÃO PARA ALTERAR TÉCNICO
function alterarTecnico(tecnico){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	// FECHA A TELA DE PESQUISA E MOSTRA A DE ALTERAR
	$("#formPesquisa").slideUp();
	$("#formCadastro").slideDown();
	$("#formCadastro1").slideDown();
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirTecnico").hide();
	$("#botaoAlterarTecnico").show();
	//MOSTRAR BOTAO MAIS EM TELA DE PESQUISAR
	$("#fecharP").hide();
	$("#abrirP").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idTecnico").val(tecnico.idTecnico);
	
}

function excluirTecnico(id){
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
    		        url: "/climanut/ServletTecnico", 
    		        data: {
    		        	idTecnico: $("#idTecnico").val(), 
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
	
		/* MÁSCARAS */
		$("#telefoneFixo").mask("(99)9999-9999");
		$("#telefoneCelular").mask("(99)9999-9999");
		$("#cpf").mask("999.999.999-99");
		$("#numero").filter_input({regex : '[0-9]'});
		$("#registro").filter_input({regex : '[0-9]'});
		$("#art").filter_input({regex : '[0-9]'});
		
		$("#botaoIncluirTecnico").click(function(){

			if($("#nome").val() == "" || $("#cpf").val() == "" || $("#registro").val() == "" || 
					$("#art").val() == "" || $("#email").val() == "" || $("#senha").val() == ""){
				$("#mensagemPreencherCampos").slideDown();
				return false;
			}else{
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletTecnico", 
			        data: {
			        	nome: $("#nome").val(),  
			        	cpf: $("#cpf").val(),  
			        	engenheiro: $("#engenheiro").val(),
			        	registro: $("#registro").val(),
			        	art: $("#art").val(),
			        	endereco: $("#endereco").val(),  
			        	numero: $("#numero").val(),  
			        	complemento: $("#complemento").val(),
			        	bairro: $("#bairro").val(),
			        	estado: $("#estado").val(),
			        	cidade: $("#cidade").val(),
			        	telefoneFixo: $("#telefoneFixo").val(),
			        	telefoneCelular: $("#telefoneCelular").val(),
						acao:"Incluir"
			        	
			        },  
			        success: function(result){     
			           LimparCampos("#formCadastro");
			           LimparCampos("#formCadastro1");
			           $("#mensagemSucessoInclusao").slideDown();
			        },
	                 error:function(){
	                	 $("#mensagemErroInclusao").slideDown();   
	                 }      
			    });  
			}
		});
		$("#botaoAlterarTecnico").click(function(){

			if($("#nome").val() == "" || $("#cpf").val() == "" || $("#registro").val() == "" || 
					$("#art").val() == "" || $("#email").val() == "" || $("#senha").val() == ""){
				$("#mensagemErroCad").slideDown();
				return false;
			}else{
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletTecnico", 
			        data: {
			        	nome: $("#nome").val(),  
			        	cpf: $("#cpf").val(),  
			        	engenheiro: $("#engenheiro").val(),
			        	registro: $("#registro").val(),
			        	art: $("#art").val(),
			        	endereco: $("#endereco").val(),  
			        	numero: $("#numero").val(),  
			        	complemento: $("#complemento").val(),
			        	bairro: $("#bairro").val(),
			        	estado: $("#estado").val(),
			        	cidade: $("#cidade").val(),
			        	telefoneFixo: $("#telefoneFixo").val(),
			        	telefoneCelular: $("#telefoneCelular").val(),
						acao:"Alterar"
			        	
			        },  
			        success: function(result){     
			           LimparCampos("#formCadastro");
			           LimparCampos("#formCadastro1");
			           $("#mensagemSucessoInclusao").slideDown();
			        },
	                 error:function(){
	                	 $("#mensagemErroInclusao").slideDown();   
	                 }      
			    });  
			}
		});
		$("#botaoExcluirTecnico").click(function(){
			
			/* CAMPOS OBRIGATÓRIOS 
			if($("#idTecnico").val() == ""){
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
	        				        url: "/climanut/ServletTecnico", 
	        				        data: {
	        				        	idTecnico: $("#idTecnico").val(), 
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
		$("#cidades").change(function(){
			LimparMensagens();	
		});
		$("#estados").change(function(){
			LimparMensagens();			
		});
			
		$("#botaoLimpar").click(function(){
			LimparCampos("#formCadastro");
			LimparCampos("#formCadastro1");
			LimparMensagens();
		});
		$("#botaoLimparPesq").click(function(){
			LimparCampos("#formPesquisaFiltro");
			LimparMensagens();
		});
		
	
});
