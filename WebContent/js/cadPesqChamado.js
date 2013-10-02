/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR - PESQUSIAR - CHAMADO : PARA TÉCNICO
 * 
 */

// FUNÇÃO PARA ALTERAR CHAMADO
function alterarChamado(chamado){
	
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
function excluirChamado(id){
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
    		        url: "/climanut/ServletChamado", 
    		        data: {
    		        	idChamado: $("#idChamado").val(), 
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

		$("#botaoAlterarChamado").click(function(){

			/* CAMPOS OBRIGATÓRIOS */
			if($("#cliente").val() == "0" || $("#staus").val() == "" || $("#descricao").val() == ""
				|| $("#dataAbertura").val() == "" || $("#observacao").val() == ""){
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
		$("#botaoExcluirChamado").click(function(){
			
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
	        				        url: "/climanut/ServletChamado", 
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
		$("#periodicidade").change(function(){
			LimparMensagens();
		});
			
		$("#botaoLimpar").click(function(){
			LimparCampos("#formCadastro");
			LimparMensagens();
		});
	
});
