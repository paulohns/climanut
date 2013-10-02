/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR - PESQUISAR AGENDA 
 */

//FUNÇÃO PARA ALTERAR AGENDA ANVISA
function alterarAgenda(agenda){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	$("#abrirC").hide();
	$("#fecharC").show();
	$("#formPesquisaFiltro").slideUp();
	$("#formPesquisa").slideUp();
	$("#fecharP").hide();
	$("#abrirP").show();
	$("#formCadastro").slideDown();
	
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirAgenda").hide();
	$("#botaoAlterarAgenda").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	idCliente = agenda.idCliente;
	idTecnico = agenda.idTecnico;
	idChamado = agenda.chamado;
	idAgenda = agenda.idAgenda;
	if(agenda.status == "Agendado"){
		status = 1;
	}else if(agenda.status == "Cancelado"){
		status = 2;
	}else if(agenda.status == "Fechado"){
		status = 3;
	}
	$("#cliente").val(agenda.cliente).attr('disabled','disabled');  //Não
	$("#tecnico").val(agenda.tecnico);	//Sim
	$("#chamado").val(agenda.chamado);	//Sim
	$("#descricaoAtividade").val(agenda.descricaoAtividade);//Sim
	$("#observacao").val(agenda.observacao); //Sim
	$("#dataAgenda").val(agenda.dataAgenda); //Sim

}
var idCliente;
var idTecnico;
var idAgenda;
var idChamado;
var status;
var anOpen = [];
var lenght = 0;
//CARREGA OS DADOS PARA A LISTA 
function chargeData() {
	
    $.ajax({
    	data: {  
    			
	        	cliente: $("#clientePesq").val(),  
	        	dataInicio: $("#dataInicialPesq").val(),
	        	dataFim: $("#dataFinalPesq").val(),
	        	agendado: $("#agendadoPesq").is(":checked"),
				cancelado: $("#canceladoPesq").is(":checked"),
				fechado: $("#fechadoPesq").is(":checked"),
				acao: "Pesquisar"
	        	
        },
    	dataType: 'json',
    	url: "/climanut/ServletAgenda",
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
		   "aoColumns": [{"mDataProp": "idAgenda", "bVisible": false},{ "mDataProp": "cliente" },{ "mDataProp": "tecnico" },{ "mDataProp": "chamado" },{ "mDataProp": "dataAgenda" },{ "mDataProp": "status" },
		                 {"mDataProp": null,
		            	  "sClass": "control center",
		            	  "sDefaultContent": '<img id="detalhes" style="cursor:pointer" title="Detalhes" src=\'../../img/icoPesq.png\' /> <img id="alterar" title="Alterar" style="margin-left:5px;cursor:pointer" src=\'../../img/icoAlterar.png\' />'
	                     }],
		   "sPaginationType": "full_numbers",
		   "aaSorting": [[0, "asc"]],
		   "bDestroy":true,
		   "bJQueryUI": true
		});
      
       
       $('#example td.control #detalhes').on('click', function () {
			
			var linha = this.parentNode.parentNode;
		    var aData = oTable.fnGetData(linha);
		    var i = $.inArray(aData, anOpen);
		    
			
		    if (i === -1) {
		    	if(lenght == 0){
		    		lenght += 1200;
		    	}else{
		    		lenght += 200;
		    	}
		    	
		    	$("#baseCadPesqFiltro").css("height", lenght+"px");
		    	
				oTable.fnOpen(linha, '<table id=\'detalhes\' style=\'font-size:14px;color:#39a1b0;\'>'+
						 	'<tr><td colspan=\'4\' ><strong><center>Detalhes de Agenda</center></strong></td></tr>'+
							'<tr><td>Cliente:</strong></td><td>'+aData.cliente+'</td><td>Técnico:</td><td>'+aData.tecnico+'</td></tr>'+
							'<tr><td>Chamado:</strong></td><td>'+aData.chamado+'</td><td>Descrição da Atividade:</td><td>'+aData.descricaoAtividade+'</td></tr>'+
							'<tr><td>Observação:</td><td>'+aData.observacao+'</td><td>Data da Agenda:</td><td>'+aData.dataAgenda+'</td></tr>'+
							'</table>', "info_row" );
				
				anOpen.push(aData);
			} else {
				lenght -= 200;
				$("#baseCadPesqFiltro").css("height", lenght+"px");
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
				    if(aData.incluidoPor == 1){
				       alterarAgenda(aData);
				       chargeData();
				    }else{
						alert("Agenda não pode ser alterada, pois foi aberta pelo Sistema!");
					}
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
	
	/* FILTRO */
	$("#chamado").filter_input({regex : '[0-9]'});
	
	/* MÁSCARAS */
	//$("#dataAgenda").datepicker();
	$("#dataInicialPesq").mask("99/99/9999");
	$("#dataFinalPesq").mask("99/99/9999");
		
	$("#botaoIncluirAgenda").click(function(){
	
		/* COLOCAR QUAIS SÃO OS CAMPOS OBRIGATÓRIOS */
		if($("#cliente").val() == "" || $("#tecnico").val() == "" || $("#descAtividade").val() == "" || $("#dataAgenda").val() == ""){
			$("#mensagemPreencherCampos").slideDown();
			return false;
		}else{		
			$.ajax({  
			       type: "post",    
			       url: "/climanut/ServletAgenda",    
			       data: {  
			    	   cliente: $("#cliente").val(),  
			    	   tecnico: $("#tecnico").val(),
			    	   chamado: $("#chamado").val(),
			    	   descricaoAtividade: $("#descricaoAtividade").val(),
			    	   observacao: $("#observacao").val(),
			    	   dataAgenda: $("#dataAgenda").val(),
			    	   status: status,
			    	   acao: $("#botaoIncluirAgenda").val()
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
		$("#botaoAlterarAgenda").click(function(){
			/* COLOCAR QUAIS SÃO OS CAMPOS OBRIGATÓRIOS E QUAIS PODEM SER ALTERADOS */
			if($("#cliente").val() == "" || $("#tecnico").val() == "" || $("#descAtividade").val() == "" || $("#dataAgenda").val() == ""){
				$("#mensagemErroInclusao").slideDown();
				return false;
			}else{
				
			    $.ajax({  
			        type: "post",    
			        url: "/climanut/ServletAgenda",    
			        data: {  
			        	agenda: idAgenda,
			        	cliente: idCliente,  
			        	tecnico: idTecnico,
			        	chamado: idChamado,
			        	descricaoAtividade: $("#descricaoAtividade").val(),
						observacao: $("#observacao").val(),
						dataAgenda: $("#dataAgenda").val(),
						agendado:$("#agendado").val(),
						cancelado:$("#cancelado").val(),
						fechado:$("#fechado").val(),
						acao: "Alterar"
			        	
			        },  
			        success: function(result){     
			           LimparCampos("#formCadastro");
			           $("#mensagemSucessoAlteracao").slideDown();
			        },
	                 error:function(){
	                	$("#mensagemErroAlteracao").slideDown();  
	                 }     
			    });  
				
			}
		});
		$("#botaoPesquisarAgenda").click(function(){
			
			/* CAMPOS OBRIGATÓRIOS */
			if($("#clientePesq").val()== "" && $("#dataInicialPesq").val()== "" && $("#dataFinalPesq").val()=="" && !$("#agendadoPesq").is(":checked") && !$("#canceladoPesq").is(":checked") && !$("#fechadoPesq").is(":checked")){
				$("#mensagemInformeFiltro").slideDown();
				
			}else if($("#dataInicialPesq").val() != "" && $("#dataFinalPesq").val()== "" || $("#dataFinalPesq").val() != "" && $("#dataInicialPesq").val()== "" ){
				$("#mensagemInformeDatas").slideDown();
			
			}else if($("#clientePesq").val() != "" || $("#agendadoPesq").is(":checked") != "" || $("#canceladoPesq").is(":checked") != "" || $("#fechadoPesq").is(":checked") != "" || $("#dataInicialPesq").val() != "" && $("#dataFinalPesq").val() != ""){
				var otable;
				var dataTab;
				chargeData();
				//LimparCampos("#formPesquisaFiltro");
				$("#formPesquisa").slideDown();
				
			}				
		});
		$('#cliente').autocomplete({
			
	        //source: ["c++", "java", "php", "coldfusion", "javascript", "asp", "ruby"],
	        source: function(request, response) {
	        	$.ajax({
	        		type: "post",
	        		url: "/climanut/ServletCliente",
	        		dataType: "json",
	        		data: {
	        			termo: $("#cliente").val(),
	        			acao:"PesquisarAutocompleteCliente"
	        		},
	        		success: function(data,type) {
	        			console.log(data);
	        			items = data;
	        			response(items);
	        		},
	                error:function(){
	                	console.log("Erro");
	                }
			
	        	});
	        }
		});


		$(".campoTexto").keypress(function(){
			LimparMensagens();	
		});
		$("#agendadoPesq").change(function(){
			LimparMensagens();
		});
		$("#canceladoPesq").change(function(){
			LimparMensagens();
		});	
		$("#fechadoPesq").change(function(){
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