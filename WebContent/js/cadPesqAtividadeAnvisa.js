/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR - PESQUISAR ATIVIDADE ANVISA 
 * 
 */

// FUNÇÃO DE ALTERAR ATIVIDADE ANVISA
function alterarAtividadeAnvisa(atividadeAnvisa){
	
	//ESCONDE E MOSTRA TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	$("#abrirC").hide();
	$("#fecharC").show();
	// FECHA A TELA DE PESQUISA E MOSTRA A DE ALTERAR
	$("#formPesquisa").slideUp();
	$("#formCadastro").slideDown();
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirAtividadeAnvisa").hide();
	$("#botaoAlterarAtividadeAnvisa").show();
	//MOSTRAR BOTAO MAIS EM TELA DE PESQUISAR
	$("#fecharP").hide();
	$("#abrirP").show();
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idAtividadeAnvisa").val(atividadeAnvisa.idAtividadeAnvisa);
	$("#descricaoAtividade").val(atividadeAnvisa.descricaoAtividade);
	var periodicidade;
	if(atividadeAnvisa.periodicidadeManutencao == "Mensal"){
		periodicidade = 1;
	}else if(atividadeAnvisa.periodicidadeManutencao == "Bimestral"){
		periodicidade = 2;
	}else if(atividadeAnvisa.periodicidadeManutencao == "Trimestral"){
		periodicidade = 3;
	}else if(atividadeAnvisa.periodicidadeManutencao == "Semestral"){
		periodicidade = 6;
	}else if(atividadeAnvisa.periodicidadeManutencao == "Anual"){
		periodicidade = 12;
	}else if(atividadeAnvisa.periodicidadeManutencao == ""){
		periodicidade = "";
	}
	$("#periodicidade").val(periodicidade);
	
}
function excluirAtividadeAnvisa(id){
	
	console.log(id);
	$.ajax({  
        type: "post",    
        url: "/climanut/ServletAtividadeAnvisa", 
        data: {
        	idAtividadeAnvisa: id,
			acao:"Excluir"
        },  
	    success: function(result){ 
	    	chargeData();
			
		},
         error:function(){
   				
        }      
	});
}
//CARREGA OS DADOS PARA A LISTA 
function chargeData() {
    $.ajax({
    	data: {acao:"Pesquisar"},
    	dataType: 'json',
    	url: "/climanut/ServletAtividadeAnvisa",
	    type: 'POST',
		success: AjaxGetFieldDataSucceeded,
		error: AjaxGetFieldDataFailed
    });
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
		   url: "/climanut/ServletAtividadeAnvisa",
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
function AjaxGetFieldDataSucceeded(result) {
	if (result != "[]") {
       //dataTab = $.parseJSON(result);
       //instance of datatable
		    
       oTable = $('#example').dataTable({
    	   "bProcessing": true,
		   "aaData": result,
		    //important  -- headers of the json
		   "aoColumns": [{"mDataProp": "idAtividadeAnvisa", "bVisible": false},{ "mDataProp": "descricaoAtividade" }, { "mDataProp": "periodicidadeManutencao" },
		                 {"mDataProp": null,
		            	  "sClass": "control center",
		            	  "sDefaultContent": '<img id="alterar" title="Alterar" style="margin-left:5px;cursor:pointer" src=\'../../img/icoAlterar.png\' /><img id="excluir" title="Excluir" style="margin-left:10px;cursor:pointer" src=\'../../img/icoExcluir.png\' />'
	                     }],
		   "sPaginationType": "full_numbers",
		   "aaSorting": [[0, "asc"]],
		   "bDestroy":true,
		   "bJQueryUI": true
		});
       
       $('body').on("click", '#example td.control #excluir', function () {
		   
    	   var parent = this.parentNode;
		    var aData = oTable.fnGetData(parent.parentNode);
		    if (null != aData){
		    console.log(aData.idAtividadeAnvisa);
		       excluirAtividadeAnvisa(aData.idAtividadeAnvisa);
		       chargeData();
		    }
		}); 
       $('body').on("click", '#example td.control #alterar', function () {
		    var parent = this.parentNode;
		    var aData = oTable.fnGetData(parent.parentNode);
		    if (null != aData){
		    console.log(aData.idAtividadeAnvisa);
		       alterarAtividadeAnvisa(aData);
		       chargeData();
		    }
		});
	}
}


$(document).ready(function(){

		$("#botaoIncluirAtividadeAnvisa").click(function(){

			if($("#periodicidade option:selected").val() == "0" || $("#descricaoAtividade").val() == ""){
				$("#mensagemPreencherCampos").slideDown();
				return false;
			}else{
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletAtividadeAnvisa",    
			        data: {  
			        	periodicidade: $("#periodicidade").val(), 
			        	descricaoAtividade: $("#descricaoAtividade").val(),
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
		$("#botaoAlterarAtividadeAnvisa").click(function(){
			
			if($("#periodicidade option:selected").val() == "0" || $("#descricaoAtividade").val() == ""){
				$("#mensagemPreencherCampos").slideDown();
				return false;
			}else{
				$.ajax({  
			        type: "post",    
			        url: "/climanut/ServletAtividadeAnvisa",    
			        data: { 
			        	idAtividadeAnvisa: $("#idAtividadeAnvisa").val(),
			        	periodicidade: $("#periodicidade").val(),  
			        	descricaoAtividade: $("#descricaoAtividade").val(),
						acao:"Alterar"
			        	
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
		/* BOTÃO PESQUISAR CARREGA A LISTA DE EQUIPAMENTOS */
		$("#abrirP").click(function(){
				
			var otable;
			var dataTab;
			chargeData();

			
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
