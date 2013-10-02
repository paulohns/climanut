/**
 * JQUERY PARA INCLUIR - ALTERAR - EXCLUIR - PESQUISAR EQUIPAMENTO 
 *
 */

// FUNÇÃO PARA RECUPERAR VALORES DA LISTA E ADICIONAR NOS CAMPOS
function alterarEquipamento(equipamento){
	
	LimparMensagens();
	//ESCONDER E MOSTRAR TITULOS
	$(".incluirTitulo").hide();
	$(".alterarTitulo").show();
	
	$("#formPesquisa").slideUp();
	$("#fecharP").hide();
	$("#abrirP").show();
	$("#formCadastro").slideDown();
	$("#abrirC").hide();
	$("#fecharC").show();
	//ESCONDE BOTAO INCLUIR E MOSTRA BOTAO ALTERAR
	$("#botaoIncluirEquipamento").hide();
	$("#botaoAlterarEquipamento").show();
	
	//COLOCA CAMPOS NA TELA - DESABILITA CAMPOS QUE NÃO PODEM ALTERAR
	$("#idEquipamento").val(equipamento.idEquipamento);
	$("#numeroSerie").val(equipamento.numeroSerie);
	$("#marca").val(equipamento.marca);
	$("#modelo").val(equipamento.modelo);
	$("#btu").val(equipamento.btu);
	var periodicidade;
	if(equipamento.periodicidadeManutencao == "Mensal"){
		periodicidade = 1;
	}else if(equipamento.periodicidadeManutencao == "Bimestral"){
		periodicidade = 2;
	}else if(equipamento.periodicidadeManutencao == "Trimestral"){
		periodicidade = 3;
	}else if(equipamento.periodicidadeManutencao == "Semestral"){
		periodicidade = 6;
	}else if(equipamento.periodicidadeManutencao == "Anual"){
		periodicidade = 12;
	}
	$("#periodicidade").val(periodicidade);
	$("#status").val(equipamento.status);
	var checado = equipamento.status;
	if(checado == "Ativo"){
		$("#inativar").attr("checked",false);
	}else{
		$("#inativar").attr("checked",true);
	}
	$("#inativar").show();
	$("#labelInativar").show();
	
}

function excluirEquipamento(id){
	alert("Excluir id:"+id);
	console.log("Teste id:"+id);
		$.ajax({  
    		  type: "post",    
    		  url: "/climanut/ServletEquipamento", 
    		  data: {
    		       idEquipamento: id,
    		       acao:"Excluir"
    		        },  
    		        success: alert("Equipamento excluído com sucesso!"),
    			    error: alert("Erro ao excluir equipamento")
    			    
    		 });    
}
var anOpen = [];
//CARREGA OS DADOS PARA A LISTA 
function chargeData() {
    $.ajax({
    	data: {acao:"Pesquisar"},
    	dataType: 'json',
    	url: "/climanut/ServletEquipamento",
	    type: 'POST',
		success: AjaxGetFieldDataSucceeded,
		error: AjaxGetFieldDataFailed
    });
}
function AjaxGetFieldDataSucceeded(result) {
	if (result != "[]") {
       dataTab = $.parseJSON(result);
       //instance of datatable
       oTable = $('#example').dataTable({
    	   "bProcessing": true,
		   "aaData": result,
		    //important  -- headers of the json
		   "aoColumns": [{"mDataProp": "idEquipamento", "bVisible": false},{ "mDataProp": "numeroSerie" }, { "mDataProp": "marca" }, { "mDataProp": "modelo" },{ "mDataProp": "periodicidadeManutencao"}, { "mDataProp": "btu" }, { "mDataProp": "status" },
		                 {"mDataProp": null,
		            	  "sClass": "control center",
		            	  "sDefaultContent": '<img id="detalhes" style="cursor:pointer" title="Detalhes" src=\'../../img/icoPesq.png\' /> <img id="alterar" title="Alterar" style="margin-left:5px;cursor:pointer" src=\'../../img/icoAlterar.png\' /><img id="excluir" title="Excluir" style="margin-left:10px;cursor:pointer" src=\'../../img/icoExcluir.png\' />'
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
						 	'<tr><td colspan=\'4\' ><strong><center>Detalhes do Equipamento</center></strong></td></tr>'+
							'<tr><td>Número de Serie:</strong></td><td>'+aData.numeroSerie+'</td><td>Marca:</td><td>'+aData.marca+'</td></tr>'+
							'<tr><td>Modelo:</strong></td><td>'+aData.modelo+'</td><td>Btu:</td><td>'+aData.btu+'</td></tr>'+
							'<tr><td>Periodicidade de Manutenção:</td><td>'+aData.periodicidadeManutencao+'</td><td>Status:</td><td>'+aData.status+'</td></tr>'+
							'</table>', "info_row" );
				
				anOpen.push(aData);
			} else {
				lenght -= 100;
				$("#baseCadPesq").css("height", lenght);
				oTable.fnClose(linha);
				anOpen.splice(i, 1);
			}			
			
			/*var parent = this.parentNode;
		    var aData = oTable.fnGetData(parent.parentNode);
		    console.log("aData:"+ aData);
		    var i = $.inArray( aData, anOpen );
		    console.log("i:"+ i);
		     
		    if ( i === -1 ) {
		      var nDetailsRow = oTable.fnOpen( aData, fnFormatDetails(oTable, aData), 'details' );
		      //console.log("nDetailsRow:"+ nDetailsRow);
		      $('div.innerDetails', nDetailsRow).slideDown();
		      anOpen.push( aData );
		      //console.log("anOpen:"+ anOpen[0].modelo);
		    }
		    else {
		      $('div.innerDetails', $(aData).next()[0]).slideUp( function () {
		        oTable.fnClose( aData );
		        anOpen.splice( i, 1 );
		      } );
		    }*/
		});
		$('#example td.control #excluir').on('click', function () {
			var parent = this.parentNode;
		    var aData = oTable.fnGetData(parent.parentNode); // get datarow
		    if (null != aData){  // null if we clicked on title row
		    	console.log(aData.idEquipamento);
		        excluirEquipamento(aData.idEquipamento);//now aData[0] - 1st column(count_id), aData[1] -2nd, etc.
		        chargeData();
		    }
		});   
		$('#example td.control #alterar').on('click', function () {
		    var parent = this.parentNode;
		    var aData = oTable.fnGetData(parent.parentNode);
		    if (null != aData){
		    console.log(aData.idEquipamento);
		       alterarEquipamento(aData);
		       chargeData();
		    }
		});
       
       /*$('#example td.control #detalhes').click( function () {
       	console.log("linha haha");
         
       	oTable.fnOpen( this.parentNode.parentNode, "Temporary row opened", "info_row" );
        });*/
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
		   url: "/climanut/ServletEquipamento",
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
	
	var tXHR=0;  
	
	function XMLHTTPRequest() {  
    	if (window.XMLHttpRequest) {   
    		a=new XMLHttpRequest(); 
    		//Objeto nativo (FF/Safari/Opera7.6+)  
    	}else {  
        try {   
           a=new ActiveXObject("Msxml2.XMLHTTP");  //activeX (IE5.5+/MSXML2+)  
        }catch(e){  
          try {   
             a=new ActiveXObject("Microsoft.XMLHTTP"); //activeX (IE5+/MSXML1)  
          }catch(e) { /* O navegador nÃ£o tem suporte */   
             a=false;   
          }  
        }  
      }   
      return a;  
    }  

    $("#estados").change(function(){
    	
    	 $.ajax({
             type: "GET",
             data:{"estados":"PR"},
             url: "/Climanut/PopulaMunicipios",
             dataType: "json",
             success: function(json){
               var options = "";
                $.each(json, function(key,value){
                 options += '<option value="' + key + '">' + value + '</option>';
               });
                $("#cidades").html(options);
             },
             error:function(){  
                 alert("ERRO"); 
             }  
    	 });       
   });
		
	/* FILTRO NÚMEROS */
	$("#numeroSerie").filter_input({regex:'[0-9]'});
	$("#btu").filter_input({regex:'[0-9]'});
		
	$("#botaoIncluirEquipamento").click(function(){

		/* CAMPOS OBRIGATÓRIOS */
		if($("#periodicidade option:selected").val() == "0" || $("#marca").val() == "" || $("#btu").val() == ""){
			$("#mensagemPreencherCampos").slideDown();
			return false;
		}else{
			$.ajax({  
			      type: "post",    
			      url: "/climanut/ServletEquipamento", 
			      data: {
			        	numeroSerie: $("#numeroSerie").val(),  
			        	marca: $("#marca").val(),  
			        	modelo: $("#modelo").val(),
			        	btu: $("#btu").val(),
			        	periodicidade: $("#periodicidade").val(),
			        	acao: "Incluir"
			        	
			      },  
			      success: function(result){     
			    	  	LimparCampos("#formCadastro");
			    	  	$("#mensagemSucessoInclusao").slideDown();
			    	  	chargeData();
			      },
	              		error:function(){
	              		$("#mensagemErroInclusao").slideDown();   
	              }      
			    });  
			
			}
	});
	$("#botaoAlterarEquipamento").click(function(){
		/* CAMPOS OBRIGATÓRIOS */
		if($("#periodicidade option:selected").val() == "0" || $("#marca").val() == "" || $("#btu").val() == ""){
			$("#mensagemPreencherCampos").slideDown();
			return false;
		}else{
			var marcado;
			if ($("#inativar").is(":checked")){
				marcado = 0;
			}else{
				marcado = 1;
			}
			$.ajax({  
			      type: "post",    
			      url: "/climanut/ServletEquipamento", 
			      data: {
			    	  	idEquipamento: $("#idEquipamento").val(),
			        	numeroSerie: $("#numeroSerie").val(),  
			        	marca: $("#marca").val(),  
			        	modelo: $("#modelo").val(),
			        	btu: $("#btu").val(),
			        	periodicidade: $("#periodicidade").val(),
			        	status: marcado,
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
