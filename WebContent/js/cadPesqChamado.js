/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR - PESQUSIAR - CHAMADO : PARA T�CNICO
 * 
 */

// FUN��O PARA ALTERAR CHAMADO
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
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE N�O PODEM ALTERAR
	$("#idChamado").val(chamado.idChamado);
	
	
}
function excluirChamado(id){
	console.log(id);
	alert(id);
	/* POPUP PARA CONFIRMAR EXCLUS�O */
    $("<div>" + "Confirmar exclus�o?" + "</div>").dialog({
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
	        			$("<div>" + "Exclus�o realizada com sucesso!" + "</div>").dialog({
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
    	       				$("<div>" + "Exclus�o n�o realizada!" + "</div>").dialog({
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
   			"N�o": function() {
   				$(this).dialog("close");
   			}
  		}
   	});
}

$(document).ready(function(){

		$("#botaoAlterarChamado").click(function(){

			/* CAMPOS OBRIGAT�RIOS */
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
			
			/* CAMPOS OBRIGAT�RIOS 
			if($("#idEquipamento").val() == ""){
				$("#mensagemErroExclusao").slideDown();
				return false;
			}else{*/
					/* POPUP PARA CONFIRMAR EXCLUS�O 
	        		$("<div>" + "Confirmar exclus�o?" + "</div>").dialog({
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
	    	        					$("<div>" + "Exclus�o realizada com sucesso!" + "</div>").dialog({
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
		    	        					$("<div>" + "Exclus�o n�o realizada!" + "</div>").dialog({
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
	        				"N�o": function() {
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
