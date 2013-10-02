/**
 * JQUERY PARA INCLUIR - ALTERAR - PESQUISAR MANUTENÇÃO
 * 
 */

// FUNÇÃO PARA ALTERAR MANEUTENÇÃO
function alterarManutencao(manutencao){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	// FECHA A TELA DE PESQUISA E MOSTRA A DE ALTERAR
	$("#formPesquisa").slideUp();
	$("#formCadastro").slideDown();
	$("#formCadastro1").slideDown();
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirManutencao").hide();
	$("#botaoAlterarManutencao").show();
	//MOSTRAR BOTAO MAIS EM TELA DE PESQUISAR
	$("#fecharP").hide();
	$("#abrirP").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idManutencao").val(manutencao.idManutencao);
	
}


$(document).ready(function(){
	
		/* FILTROS */
		$("#agenda").filter_input({regex:'[0-9]'});
		/* MÁSCARAS */
		$("#dataManutencao").mask("99/99/9999");
		$("#dataInicialPesq").mask("99/99/9999");
		$("#dataFinalPesq").mask("99/99/9999"); 

		$("#naoOkCorrente").click(function(){
			$(".astCorrente").show();
		});
		$("#okCorrente").click(function(){
			$(".astCorrente").hide();
		});
		$("#naoOkPressaoHi").click(function(){
			$(".astPressaoHi").show();
		});
		$("#okPressaoHi").click(function(){
			$(".astPressaoHi").hide();
		});
		$("#naoOkPressaoLow").click(function(){
			$(".astPressaoLow").show();
		});
		$("#okPressaoLow").click(function(){
			$(".astPressaoLow").hide();
		});
		$("#naoOkTemperatura").click(function(){
			$(".astTemperatura").show();
		});
		$("#okTemperatura").click(function(){
			$(".astTemperatura").hide();
		});
		$("#naoOkFiltros").click(function(){
			$(".astFiltros").show();
		});
		$("#okFiltros").click(function(){
			$(".astFiltros").hide();
		});
		
	
		$("#botaoIncluirManutencao").click(function(){
			
			if($("#localizacao").val()=="" || $("#agenda").val()=="" || $("#dataManutencao").val()=="" ||
					!$("#okCorrente").is(":checked")&&!$("#naoOkCorrente").is(":checked")|| !$("#okTemperatura").is(":checked")&&!$("#naoOkTemperatura").is(":checked")||
					!$("#okPressaoHi").is(":checked")&&!$("#naoOkPressaoHi").is(":checked") || !$("#okPressaoLow").is(":checked")&&!$("#naoOkPressaoLow").is(":checked")||
					!$("#okFiltros").is(":checked")&&!$("#naoOkFiltros").is(":checked")){
				
					$("#mensagemPreencherCampos").slideDown();
				
			}else if($("#naoOkCorrente").is(":checked")&& $("#obsCorrente").val()=="" || 
					$("#naoOkPressaoHi").is(":checked")&& $("#obsPressaoHi").val()=="" ||
					$("#naoOkPressaoLow").is(":checked")&& $("#obsPressaoLow").val()=="" ||
					$("#naoOkTemperatura").is(":checked")&& $("#obsTemperatura").val()=="" ||
					$("#naoOkFiltros").is(":checked")&& $("#obsFiltros").val()==""){
					
					$("#mensagemPreencherCampos").slideDown();
					return false;
			}else{
				/*
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletManutencao",    
			        data: {  
			        	localizacao: $("#cliente").val(),  
			        	agenda: $("#tecnico").val(),
			        	dataManutencao: $("#chamado").val(),
			        	okCorrente: $("#descricaoAtividade").val(),
						naoOkCorrente: $("#observacao").val(),
						okPressaoHi: $("#descricaoAtividade").val(),
						naoOkPressaoHi: $("#observacao").val(),
						okPressaoLow: $("#descricaoAtividade").val(),
						naoOkPressaoLow: $("#observacao").val(),
						okTemperatura: $("#descricaoAtividade").val(),
						naoOkTemperatura: $("#observacao").val(),
						okFiltros: $("#descricaoAtividade").val(),
						naoOkFiltros: $("#observacao").val(),
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
		$("#botaoAlterarManutencao").click(function(){
			
			if($("#localizacao").val()=="" || $("#agenda").val()=="" || $("#dataManutencao").val()=="" ||
					!$("#okCorrente").is(":checked")&&!$("#naoOkCorrente").is(":checked")|| !$("#okTemperatura").is(":checked")&&!$("#naoOkTemperatura").is(":checked")||
					!$("#okPressaoHi").is(":checked")&&!$("#naoOkPressaoHi").is(":checked") || !$("#okPressaoLow").is(":checked")&&!$("#naoOkPressaoLow").is(":checked")||
					!$("#okFiltros").is(":checked")&&!$("#naoOkFiltros").is(":checked")){
				
					$("#mensagemPreencherCampos").slideDown();
				
			}else if($("#naoOkCorrente").is(":checked")&& $("#obsCorrente").val()=="" || 
					$("#naoOkPressaoHi").is(":checked")&& $("#obsPressaoHi").val()=="" ||
					$("#naoOkPressaoLow").is(":checked")&& $("#obsPressaoLow").val()=="" ||
					$("#naoOkTemperatura").is(":checked")&& $("#obsTemperatura").val()=="" ||
					$("#naoOkFiltros").is(":checked")&& $("#obsFiltros").val()==""){
					
					$("#mensagemPreencherCampos").slideDown();
					return false;
			}else{
				/*
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletManutencao",    
			        data: {  
			        	localizacao: $("#cliente").val(),  
			        	agenda: $("#tecnico").val(),
			        	dataManutencao: $("#chamado").val(),
			        	okCorrente: $("#descricaoAtividade").val(),
						naoOkCorrente: $("#observacao").val(),
						okPressaoHi: $("#descricaoAtividade").val(),
						naoOkPressaoHi: $("#observacao").val(),
						okPressaoLow: $("#descricaoAtividade").val(),
						naoOkPressaoLow: $("#observacao").val(),
						okTemperatura: $("#descricaoAtividade").val(),
						naoOkTemperatura: $("#observacao").val(),
						okFiltros: $("#descricaoAtividade").val(),
						naoOkFiltros: $("#observacao").val(),
						acao:"Alterar"
			        	
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
		$("#botaoPesquisarManutencao").click(function(){
			
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
		$("#okCorrente").change(function()  {
			LimparMensagens();		
		});
		$("#naoOkCorrente").change(function()  {
			LimparMensagens();		
		});
		$("#okPressaoHi").change(function()  {
			LimparMensagens();		
		});
		$("#naoOkPressaoHi").change(function()  {
			LimparMensagens();		
		});
		$("#okPressaoLow").change(function()  {
			LimparMensagens();		
		});
		$("#naoOkPressaoLow").change(function()  {
			LimparMensagens();		
		});
		$("#okTemperatura").change(function()  {
			LimparMensagens();		
		});
		$("#naoOkTemperatura").change(function()  {
			LimparMensagens();		
		});
		$("#okFiltros").change(function()  {
			LimparMensagens();		
		});
		$("#naoOkFiltros").change(function()  {
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
