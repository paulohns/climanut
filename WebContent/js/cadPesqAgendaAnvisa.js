/**
 * JQUERY PARA INCLUIR AGENDA ANVISA
 */

var anOpen = [];
var lenght = 0;
//CARREGA OS DADOS PARA A LISTA 
function chargeData() {
    $.ajax({
    	data: {  
    			/* PASSAR FILTROS */
				acao: "Pesquisar"	
        },
    	dataType: 'json',
    	url: "/climanut/ServletAgendaAnvisa",
	    type: 'POST',
		success: AjaxGetFieldDataSucceeded,
		error: AjaxGetFieldDataFailed
    });
}
function AjaxGetFieldDataSucceeded(result) {
	$("#formPesquisa").slideDown();
	
	if (result != "[]") {
       //dataTab = $.parseJSON(result);
       //instance of datatable
       oTable = $('#example').dataTable({
    	   "bProcessing": true,
		   "aaData": result,
		    //important  -- headers of the json
		   "aoColumns": [{"mDataProp": "idAgendaAnvisa", "bVisible": false},{ "mDataProp": "cliente"},{ "mDataProp": "statusAgenda" },
		                 {"mDataProp": null,
		            	  "sClass": "control center",
		            	  "sDefaultContent": '<img id="detalhes" style="cursor:pointer" title="Detalhes" src=\'../../img/icoPesq.png\' />'
	                     }],
		   "sPaginationType": "full_numbers",
		   "aaSorting": [[0, "asc"]],
		   "bDestroy":true,
		   "bJQueryUI": true
		});
       	$("#formPesquisa").slideDown();
       	
		$('#example td.control #detalhes').on('click', function () {
			
			var linha = this.parentNode.parentNode;
		    var aData = oTable.fnGetData(linha);
		    var i = $.inArray(aData, anOpen);
		    
		    var inicioTabela = '<table id=\'detalhes\' style=\'font-size:14px;color:#39a1b0;\'>'+
		 	'<tr><td colspan=\'4\' ><strong><center>Detalhes de Agenda Anvisa</center></strong></td></tr>'+
			'<tr><td>Data Final:</td><td>'+aData.dataFinal+'</td></tr>';
		   
		    var fimTabela ='</table>';
		    var meioTabela = '' ;
		    var status = "";
		    $.each(aData.atividadeAnvisa, function(index,value){
			   if(value.status == 1){
				   status = "Agendado";
			   }
			   meioTabela +='<tr><td>Atividade Anvisa:</td><td>'+value.atividade+'</td><td>Status:'+status+'</td></tr>';
		  	});
		   
		    var tabela = inicioTabela+meioTabela+fimTabela;
		    if (i === -1) {
		    	if(lenght == 0){
		    		lenght += 1500;
		    	}else{
		    		lenght += 500;
		    	}
		    	
		    	$("#baseCadPesq").css("height", lenght+"px");
				 oTable.fnOpen(linha,tabela,"info_row" );	
				 anOpen.push(aData);
			} else {
				lenght -= 500;
				$("#baseCadPesq").css("height", lenght);
				oTable.fnClose(linha);
				anOpen.splice(i, 1);
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
$(document).ready(function() {

	$("#dataInicialPesq").mask("99/99/9999");
	$("#dataFinalPesq").mask("99/99/9999");
	
	$("#botaoPesquisarAgendaAnvisa").click(function() {

		/* CAMPOS OBRIGATÓRIOS */
		if ($("#clientePesq").val() == ""
				&& $("#dataInicialPesq").val() == ""
				&& $("#dataFinalPesq").val() == ""
				&& !$("#abertoPesq").is(":checked")
				&& !$("#fechadoPesq").is(":checked")) {
			$("#mensagemInformeFiltro").slideDown();

		} else if ($("#dataInicialPesq").val() != ""
				&& $("#dataFinalPesq").val() == ""
				|| $("#dataFinalPesq").val() != ""
				&& $("#dataInicialPesq").val() == "") {
			$("#mensagemInformeDatas").slideDown();

		} else if ($("#clientePesq").val() != ""
			|| $("#abertoPesq").is(":checked") != "" 
			|| $("#fechadoPesq").is(":checked") != "" 
			|| $("#dataInicialPesq").val() != "" && $("#dataFinalPesq").val() != "") {
			
			var otable;
			var dataTab;
			chargeData();
			LimparCampos("#formPesquisaFiltro");
			
		}
			
	});
		
	$(".campoTexto").keypress(function() {
		LimparMensagens();
	});
	$("#abertoPesq").change(function(){
		LimparMensagens();
	});	
	$("#fechadoPesq").change(function(){
		LimparMensagens();
	});
	$("#botaoLimpar").click(function() {
		LimparCampos("#formCadastro");
		LimparMensagens();
	});
	$("#botaoLimparPesq").click(function() {
		LimparCampos("#formPesquisaFiltro");
		LimparMensagens();
	});		

});