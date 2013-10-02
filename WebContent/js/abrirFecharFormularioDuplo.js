/**
 * JQUERY PARA ABRIR E FECHAR FORMULÁRIOS DE
 * CADASTRO E PESQUISA
 */

$(document).ready(function(){
	
		/*AO SELECIONAR ESTADO, POPULAR COMBO COM CIDADES
	 	$("#estados").change(function(){
     	alert($("#estados").val());
	   	 $.ajax({
	         type: "POST",
	         data:{
	        	 idEstado : $("#estados").val(),
	        	 acao:"Cidades"
	        	 	
	        	 },
	         url: "/climanut/PopulaEstadosCidades",
	         dataType: "json",
	         success: function(json){
	           var options = "";
	            $.each(json, function(key,value){
	            	console.log(key);
	            	console.log(value);
	            	
	            	options += '<option value="' + key + '">' + value.nomeCidade + '</option>';
	            });
	            $("#estados").html(options);
	         },
	         error:function(){  
	             alert("Erro ao encontrar Estados!"); 
	         }  
		 });*/
			
		$("#abrirC").click(function(){
			
			//POPULAR COMBO DE ESTADOS
			 $.ajax({
                 type: "POST",
                 data:{
                	 	acao:"Estados" 
                	  },
                 url: "/climanut/PopulaEstadosCidades",
                 dataType: "json",
                 success: function(json){
                   var options = '<option value="0">Selecione</option>';
                    $.each(json, function(key,value){
                    	//console.log(key);
                    	//console.log(value);
                    	options += '<option value="' + value.sigla + '">' + value.nomeEstado + '</option>';
                    });
                    $("#estados").html(options);
                 },
                 error:function(){  
                     alert("Erro ao encontrar Estados!"); 
                 }  
			 });
			
			
			
				
			/* SE ESTIVER ABERTO, FECHA O FORMPESQUISA, ESCONDE O - E MUDA PARA + */
			$("#formPesquisa").slideUp();
			$("#fecharP").hide();
			$("#abrirP").show();
				
			$("#formCadastro").slideDown();
			$("#formCadastro1").slideDown();
			$("#formContato").slideDown();
			$("#abrirC").hide();
			$("#fecharC").show();
			/* AUMENTAR BASE PARA CADASTRO E PESQUISA */
			$("#baseCadPesq").css("height", "1900px");
			
			//ALTERAÇÃO
			$(".botaoIncluir").show();
			$(".botaoAlterar").hide();
				
		});
		$("#fecharC").click(function(){
			
			$("#formCadastro").slideUp();
			$("#formCadastro1").slideUp();
			$("#formContato").slideUp();
			$("#abrirC").show();
			$("#fecharC").hide();
			LimparMensagens();
			/* RETIRAR TELA DE ALTERAR */
			LimparCampos("#formCadastro");
			$(".alterarTitulo").hide();
			$(".incluirTitulo").show();
			
			
				
		});
		$("#abrirP").click(function(){
				
			/* SE ESTIVER ABERTO, FECHA O FORMCADASTRO, ESCONDE O - E MUDA PARA MAIS */
			$("#formCadastro").slideUp();
			$("#formCadastro1").slideUp();
			$("#formContato").slideUp();
			$("#fecharC").hide();
			$("#abrirC").show();
			/* SE ESTIVER COM MENSAGENS A MOSTRA, ESCONDE-AS */
			LimparMensagens();
			$("#formPesquisa").slideDown();
			$("#abrirP").hide();
			$("#fecharP").show();
			/* AUMENTAR BASE PARA CADASTRO E PESQUISA */
			$("#baseCadPesq").css("height", "1000px");
			/* RETIRAR TELA DE ALTERAR */
			LimparCampos("#formCadastro");
			LimparMensagens();
			$(".botaoAlterar").hide();
			$(".botaoIncluir").show();
			$(".alterarTitulo").hide();
			$(".incluirTitulo").show();
				
		});
		$("#fecharP").click(function(){
				
			$("#formPesquisa").slideUp();
			$("#abrirP").show();
			$("#fecharP").hide();
			LimparMensagens();
	
		});
			
});

