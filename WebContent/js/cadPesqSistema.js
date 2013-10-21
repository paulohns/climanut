/**
 * JQUERY PARA INCLUIR - ALTERAR - PESQUISAR SISTEMA 
 */

// FUNÇÃO PARA ALTERAR SISTEMA
function alterarSistema(sistema){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	// FECHA A TELA DE PESQUISA E MOSTRA A DE ALTERAR
	$("#formPesquisa").slideUp();
	$("#formCadastro").slideDown();
	$("#formCadastro1").slideDown();
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirSistema").hide();
	$("#botaoAlterarSistema").show();
	//MOSTRAR BOTAO MAIS EM TELA DE PESQUISAR
	$("#fecharP").hide();
	$("#abrirP").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idSistema").val(sistema.idSistema);
	
}

var anOpen = [];

//CARREGA OS DADOS PARA A LISTA 
function chargeData() {
	
    $.ajax({
    	data: {  
    			
	        	/*cliente: $("#clientePesq").val(),  
	        	dataInicio: $("#dataInicialPesq").val(),
	        	dataFim: $("#dataFinalPesq").val(),
	        	agendado: $("#agendadoPesq").is(":checked"),
				cancelado: $("#canceladoPesq").is(":checked"),
				fechado: $("#fechadoPesq").is(":checked"),*/
				acao: "Pesquisar"
	        	
        },
    	dataType: 'json',
    	url: "/climanut/ServletSistema",
	    type: 'POST',
		success: AjaxGetFieldDataSucceeded,
		error: AjaxGetFieldDataFailed
    });
}
function AjaxGetFieldDataSucceeded(result) {
	
	if (result != "[]") {
       //dataTab = $.parseJSON(result);
       //instance of datatable
       oTable = $('#example').dataTable({
    	   "bProcessing": true,
		   "aaData": result,
		    //important  -- headers of the json
		   "aoColumns": [{"mDataProp": "idLocalizacao", "bVisible": false},{ "mDataProp": "bloco" },{ "mDataProp": "dataInstalacao" },{ "mDataProp": "status" },
		                 {"mDataProp": null,
		            	  "sClass": "control center",
		            	  "sDefaultContent": '<img id="detalhes" style="cursor:pointer" title="Detalhes" src=\'../../img/icoPesq.png\' /> <img id="alterar" title="Alterar" style="margin-left:5px;cursor:pointer" src=\'../../img/icoAlterar.png\' />'
	                     }],
		   "sPaginationType": "full_numbers",
		   "aaSorting": [[0, "asc"]],
		   "bDestroy":true,
		   "bJQueryUI": true
		});
       var lenght = 0;
       $('#example td.control #detalhes').on('click', function () {
			
    	   var linha = this.parentNode.parentNode;
		    var aData = oTable.fnGetData(linha);
		    var i = $.inArray(aData, anOpen);
		    
			
		    if (i === -1) {
		    	if(lenght == 0){
		    		lenght += 1100;
		    	}else{
		    		lenght += 100;
		    	}
		    	
		    	$("#baseCadPesq").css("height", lenght+"px");
				 oTable.fnOpen(linha, '<table id=\'detalhes\' style=\'font-size:14px;color:#39a1b0;\'>'+
						 	'<tr><td colspan=\'4\' ><strong><center>Detalhes do Bloco</center></strong></td></tr>'+
							'<tr><td>Pavimento:</strong></td><td>'+aData.pavimento+'</td><td>Local:</td><td>'+aData.local+'</td></tr>'+
							'<tr><td>Equipamento:</strong></td><td>'+aData.equipamento+'</td><td>Status:</td><td>'+aData.status+'</td></tr>'+
							'</table>', "info_row" );
				
				anOpen.push(aData);
			} else {
				lenght -= 100;
				$("#baseCadPesq").css("height", lenght);
				oTable.fnClose(linha);
				anOpen.splice(i, 1);
			}			
			
		});
		
		$('#example td.control #alterar').on('click', function () {
			
			var parent = this.parentNode;
			var aData = oTable.fnGetData(parent.parentNode);
			    if (null != aData){
			    console.log(aData.idAgenda);
			    console.log(aData.incluidoPor);
				   /* if(aData.incluidoPor == 1){
				       alterarAgenda(aData);
				       chargeData();
				    }else{
						alert("Agenda não pode ser alterada, pois foi aberta pelo Sistema!");
					}*/
			    }
		});
	}
}

function AjaxGetFieldDataFailed(result) {
	alert(result.status + ' ' + result.statusText);
}
		/* 2. this function only insert the data in your database
		function insertData() {
		    var email = $("#season").val();
		    var evento = $("#type").val();
		    $.ajax({
		        type: "POST",
		        //in this method insert the data in your database
		        url: "/servlets/service/competitions/",
		        contentType: "application/json; charset=utf-8",
		        data: '{ season : "' + season + '", type : "' + type + '"}',
		        dataType: "json",
		        success: AjaxUpdateDataSucceeded,
		        error: AjaxUpdateDataFailed
		    });
		}*/

function AjaxUpdateDataSucceeded(result) {
	if (result != "[]") {
		alert("update ok");
		refreshDatatable();
	}
}
function AjaxUpdateDataFailed(result) {
	alert(result.status + ' ' + result.statusText);
}
// 3. This function refresh only the datatable not all page  in varius events you can call like INSERT,UPDATE,DELETE ;D
function refreshDatatable() {
	$.ajax({
		   type: "POST",
		   //same event used in chargeData function
		   url: "/climanut/ServletAgenda",
		   dataType: "json",
		   data: {acao:"Pesquisar"},
		   success: AjaxRefreshDataSucceeded,
		   error: AjaxRefreshDataFailed
	});
}
function AjaxRefreshDataSucceeded(result) {
	if (result.d != "[]") {
		var jposts = result;
		dataTab = $.parseJSON(jposts);
		//when the instance of datatable exists, only pass the data :D
		oTable.fnClearTable();
		oTable.fnAddData(dataTab);
	}
}
function AjaxRefreshDataFailed(result) {
	alert(result.status + ' ' + result.statusText);
}
$(document).ready(function(){
			
			/* VALIDAR CAMPOS PARA CADASTRO */
			$("#botaoIncluirCliente").click(function(){
				
				if($("#idCliente").val() == "" || $("#cliente").val() == ""){
					$("#mensagemPreencherCamposCliente").slideDown();
					return false;
				}else if($("#idCliente").val()!= 0){
					$("#mensagemErroInclusaoBloco").slideDown();
					return false;
				}else{
					
					$.ajax({  
				        type: "post",    
				        url: "/climanut/ServletSistema", 
				        data: {
				        	idCliente: $("#idCliente").val(),
				        	acao:"IncluirCliente"
				        	
				        },  
				        success: function(result){    
				           LimparCampos("#formCliente");
				           $("#mensagemSucessoInclusaoCliente").slideDown();
				        },
		                 error:function(){
		                   $("#mensagemErroInclusaoCliente").slideDown();   
		                }      
				    });

				}
	
			});
			$("#botaoIncluirBloco").click(function(){
				
				if($("#idClienteBloco").val()== "" || $("#clienteBloco").val()== "" ||$("#bloco").val() == "" ){
					$("#mensagemPreencherCamposBloco").slideDown();
					return false;
				}else if($("#idBloco").val()!= 0){
					$("#mensagemErroInclusaoBloco").slideDown();
					return false;
				}else{
					$.ajax({  
				        type: "post",    
				        url: "/climanut/ServletSistema", 
				        data: {
				        	idCliente: $("#idClienteBloco").val(), 
				        	bloco: $("#bloco").val(),  
				        	acao:"IncluirBloco"
				        	
				        },  
				        success: function(result){     
				           idClienteBloco = null;
				           LimparCampos("#formCadastro");
				           $("#mensagemSucessoInclusaoBloco").slideDown();
				           $("#bloco").attr('disabled','disabled');
				        },
		                 error:function(){
		                	$("#mensagemErroInclusaoBloco").slideDown();
		                 }      
				    });
				}
			});
			
			$("#botaoIncluirPavimento").click(function(){
				
				if($("#idClientePavimento").val() == "" || $("#clientePavimento").val() == "" || $("#idBlocoPavimento").val() == "" || $("#pavimento").val() == ""){
					$("#mensagemPreencherCamposPavimento").slideDown();
				return false;
				}else{
					
					$.ajax({  
				        type: "post",    
				        url: "/climanut/ServletSistema", 
				        data: {
				        	idCliente: $("#idClientePavimento").val(),
				        	idBlocoPavimento: $("#idBlocoPavimento").val(),
				        	pavimento: $("#pavimento").val(),
				        	acao:"IncluirPavimento"
				        	
				        },  
				        success: function(result){     
				           LimparCampos("#formCadastro");
				           $("#mensagemSucessoInclusaoPavimento").slideDown();
				        },
		                 error:function(){
		                	 $("#mensagemErroInclusaoPavimento").slideDown();   
		                }      
				    });

				}
	
			});
			$("#botaoIncluirLocal").click(function(){
				
				if($("#clienteLocal").val() == "" || $("#pavimento").val() == "" || $("#blocosLocal option:selected").val() == "0" || $("#pavimentosLocal option:selected").val() == "0"){
					$("#mensagemPreencherCampos").slideDown();
				return false;
				}else{
					$.ajax({  
				        type: "post",    
				        url: "/climanut/ServletSistema", 
				        data: {
				        	idCliente: $("#idClienteBloco").val(), 
				        	idBloco: $("#idBloco").val(),  
				        	idBloco: $("#pavimento").val(),  
				        	acao:"IncluirPAvimento"
				        	
				        },  
				        success: function(result){     
				           LimparCampos("#formCadastro");
				           $("#mensagemSucessoInclusaoLocal").slideDown();
				        },
		                 error:function(){
		                	 $("#mensagemErroInclusaoLocal").slideDown();   
		                 }      
				    });

				}
	
			});
			$("#botaoIncluirEquipamento").click(function(){
				
				if($("#clienteEquipamento").val() == "" || $("#equipamento").val() == "" || $("#blocosEquipamento option:selected").val() == "0" || 
				   $("#pavimentosEquipamento option:selected").val() == "0" || $("#locaisEquipamento option:selected").val() == "0"){
						$("#mensagemPreencherCampos").slideDown();
				return false;
				}else{
					$("#mensagemSucessoInclusaoEquipamento").slideDown();
					/*$.ajax({  
				        type: "post",    
				        url: "/climanut/ServletSistema", 
				        data: {
				        	equipamento: $("#equipamento").val(),  
				        	acao:"Incluir"
				        	
				        },  
				        success: function(result){     
				           LimparCampos("#formCadastro");
				           $("#mensagemSucessoInclusao").slideDown();
				        },
		                 error:function(){
		                	 $("#mensagemErroInclusao").slideDown();   
		                 }      
				    });  */

				}
	
			});
			$("#botaoAlterarSistema").click(function(){
				
			});
			$("#botaoPesquisarSistema").click(function(){
				alert("hello");
				/* CAMPOS OBRIGATÓRIOS */
				if($("#clientePesq").val()== "" && $("#dataInicialPesq").val()== "" && $("#dataFinalPesq").val()=="" && !$("#agendadoPesq").is(":checked") && !$("#canceladoPesq").is(":checked") && !$("#fechadoPesq").is(":checked")){
					$("#mensagemInformeFiltro").slideDown();
					
				}else if($("#dataInstalacaoInicialPesq").val() != "" && $("#dataInstalacaoFinalPesq").val()== "" || $("#dataFinalPesq").val() != "" && $("#dataInicialPesq").val()== "" ){
					$("#mensagemInformeDatas").slideDown();
				
				}else if($("#clientePesq").val() != "" || $("#agendadoPesq").is(":checked") != "" || $("#canceladoPesq").is(":checked") != "" || $("#fechadoPesq").is(":checked") != "" || $("#dataInicialPesq").val() != "" && $("#dataFinalPesq").val() != ""){
					var otable;
					var dataTab;
					chargeData();
					LimparCampos("#formPesquisaFiltro");
					$("#formPesquisa").slideDown();
					
				}				
			});

			$("#abrirC").click(function(){
				
				$("#formCadastro").slideDown();
				$("#abrirC").hide();
				$("#fecharC").show();
				
			});
			$("#fecharC").click(function(){
				
				$("#formCadastro").slideUp();
				$("#abrirC").show();
				$("#fecharC").hide();
				LimparMensagens();
				
			});
			//$("#clienteBloco").attr('disabled','disabled');
			$("#bloco").attr('disabled','disabled');
			//$("#clientePavimento").attr('disabled','disabled');
			$("#blocoPavimento").attr('disabled','disabled');
			$("#pavimento").attr('disabled','disabled');
			//$("#clienteLocal").attr('disabled','disabled');
			$("#blocoLocal").attr('disabled','disabled');
			$("#pavimentoLocal").attr('disabled','disabled');
			$("#local").attr('disabled','disabled');
			//$("#clienteEquipamento").attr('disabled','disabled');
			$("#blocoEquipamento").attr('disabled','disabled');
			$("#pavimentoEquipamento").attr('disabled','disabled');
			$("#localEquipamento").attr('disabled','disabled');
			$("#equipamento").attr('disabled','disabled');
		
			//AutocompleteCliente
			$("#cliente").focus(function(){
				autocompleteCliente("#cliente","#idCliente","PesquisarAutocompleteCliente");
			});
			//AutocompleteBloco
			$("#clienteBloco").focus(function(){
				autocompleteCliente("#clienteBloco","#idCliente","PesquisarAutocompleteCliente");
			});
			$("#bloco").focus(function(){
				LimparMensagens();
				autocompleteBlocoPorCliente("#bloco",$("idClienteBloco").val(),"PesquisarAutocompleteBlocoPorCliente");
			});
			//AutocompletePavimento
			$("#clientePavimento").focus(function(){
				autocompleteCliente("#clientePavimento","#idClientePavimento","PesquisarAutocompleteCliente");
			});
			
			//AutocompleteLocal
			$("#clienteLocal").focus(function(){
				autocompleteCliente("#clienteLocal","#idClienteLocal","PesquisarAutocompleteCliente");
			});
			
			//AutocompleteEquipamento
			$("#clienteEquipamento").focus(function(){
				autocompleteCliente("#clienteEquipamento","#idClienteEquipamento","PesquisarAutocompleteCliente");
			});
			
			/* RETIRA MENSAGEM DA TELA */
			$(".campoTexto").keypress(function(){
				LimparMensagens();
				
			});
			$("#botaoLimparCliente").click(function(){
				LimparCampos("#formCliente");
				LimparMensagens();
			});
			$("#botaoLimparBloco").click(function(){
				LimparCampos("#formBloco");
				LimparMensagens();
			});
			$("#botaoLimparPavimento").click(function(){
				LimparCampos("#formPavimento");
				LimparMensagens();
			});
			$("#botaoLimparLocal").click(function(){
				LimparCampos("#formLocal");
				LimparMensagens();
			});
			$("#botaoLimparEquipamento").click(function(){
				LimparCampos("#formEquipamento");
				LimparMensagens();
			});
			
			$("#pavimento").change(function(){
				LimparMensagens();
			});
			$("#local").change(function(){
				LimparMensagens();
			});
			$("#equipamento").change(function(){
				LimparMensagens();
			});
				
});