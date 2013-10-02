/**
 * JQUERY PARA INLCUIR  - ALTERAR - PESQUISAR MANUTENÇÃO ANVISA
 * 
 */

// FUNÇÃO PARA ALTERA MANUTENÇÃO ANVISA 
function alterarManutencaoAnvisa(manutencaoAnvisa){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	// FECHA A TELA DE PESQUISA E MOSTRA A DE ALTERAR
	$("#formPesquisa").slideUp();
	$("#formCadastro").slideDown();
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirManutencaoAnvisa").hide();
	$("#botaoAlterarManutencaoAnvisa").show();
	//MOSTRAR BOTAO MAIS EM TELA DE PESQUISAR
	$("#fecharP").hide();
	$("#abrirP").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idManutencao").val(manutencaoAnvisa.idManutencaoAnvisa);
	
}

$(document).ready(function(){
	
		/* FILTROS */
		$("#agendaAnvisa").filter_input({regex:'[0-9]'});
		/* MÁSCARAS */
		$("#dataManutencaoAnvisa").mask("99/99/9999");
		$("#dataInicialPesq").mask("99/99/9999");
		$("#dataFinalPesq").mask("99/99/9999");
		

		$("#botaoIncluirManutencaoAnvisa").click(function(){

			if($("#agendaAnvisa").val() == "" || $("#dataManutencaoAnvisa").val() == "" || 
				$("#executadoPor").val() == "" || $("#aprovadoPor").val() == "" ){
				$("#mensagemPreencherCampos").slideDown();
				return false;
			}else{
				
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletManutencaoAnvisa",    
			        data: {  
			        	agendaAnvisa: $("#agendaAnvisa").val(),  
			        	dataManutencaoAnvisa: $("#dataManutencaoAnvisa").val(),
			        	executadoPor: $("#executadoPor").val(),
			        	aprovadoPor: $("#aprovadoPor").val(),
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
		$("#botaoAlterarManutencaoAnvisa").click(function(){

			if($("#agendaAnvisa").val() == "" || $("#dataManutencaoAnvisa").val() == "" || 
				$("#executadoPor").val() == "" || $("#aprovadoPor").val() == "" ){
				$("#mensagemPreencherCampos").slideDown();
				return false;
			}else{
				/*
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletManutencaoAnvisa",    
			        data: {  
			        	agendaAnvisa: $("#agendaAnvisa").val(),  
			        	dataManutencao: $("#dataManutencaoAnvisa").val(),
			        	executadoPor: $("#executadoPor").val(),
			        	AprovadoPor: $("#aprovadoPor").val(),
						acao:"Alterar"
			        	
			        },  
			        success: function(result){     
			           LimparCampos("#formCadastro");
			           $("#mensagemSucessoAlteracao").slideDown();
			        },
	                 error:function(){
	                	 $("#mensagemErroAlteracao").slideDown();   
	                 }      
			    });*/
			
			}
		});

		$("#botaoPesquisarManutencaoAnvisa").click(function(){
			
			/* CAMPOS OBRIGATÓRIOS */
			if($("#clientePesq").val()== "" && $("#dataInicialPesq").val()== "" && $("#dataFinalPesq").val()=="" && !$("#statusPesq").is(":checked")){
				$("#mensagemInformeFiltro").slideDown();
				
			}else if($("#dataInicialPesq").val() != "" && $("#dataFinalPesq").val()== "" || $("#dataFinalPesq").val() != "" && $("#dataInicialPesq").val()== "" ){
				$("#mensagemInformeDatas").slideDown();
			
			}else{
				LimparCampos("#formPesquisaFiltro");	
				$("#formPesquisa").slideDown();
				/*$.ajax({  
		        type: "post",    
		        url: "/climanut/ServletManutencao", 
		        data: {  
		        	cliente: $("#clientePesq").val(),  
		        	dataInicial: $("#dataInicialPesq").val(),
		        	dataFinal: $("#dataFinalPesq").val(),
					status: $("#statusPesq").val(),
					acao:"Pesquisar"
		        	
		        },  
		        success: function(result){     
		           LimparCampos("#formPesquisaFiltro");
		           /* MOSTRA LISTA COM DADOS 
		        },
                 error:function(){  
                	$("#mensagemErroFiltro").slideDown();  
                 }     
		    	}); */ 	

			}
				
				 	  
				
		});

		/* ESCONDER A MENSAGEM */
		$(".campoTexto").keypress(function(){
			LimparMensagens();
		});
			
		$("#botaoLimpar").click(function(){
			LimparCampos("#formCadastro");
			LimparMensagens();
		});
		$("#botaoLimparPesq").click(function(){
			LimparCampos("#formPesquisaFiltro");
			LimparMensagens();
		});
	
});
