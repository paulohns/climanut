<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="StyleSheet" type="text/css" href="/climanut/css/estilo.css" >
<script src="/climanut/resources/jquery-1.9.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/climanut/js/limparCampos.js"></script>
<!--[if lte IE 7]>
<link href="css/estiloIE7.css" type="text/css" rel="stylesheet" />
<![endif]-->
<title>Climanut - Login</title>
</head>
<body>

	<div id="login">
		
			<input id="usuario" class="inputUser" name="usuario" type="text" maxlength="20" size="21" /><br/>
			<input id="senha" class="inputSenha" name="senha" type="password" maxlength="10" size="11" ><br/><br/>
			<a href="">Esqueci a senha!</a>
			<input id="botaoLogar" type="submit" name="acao" value="Entrar" class="botaoEntrar" >	
		
	</div>
	<label id="mensagemErroLogin" style="display:none;" ><img src="/climanut/img/dadosInvalidos.png" /></label>
	

<script>
$(document).ready(function(){
	
	$("#usuario").keypress(function(){
		$("#mensagemErroLogin").slideUp();
	});
	$("#senha").keypress(function(){
		$("#mensagemErroLogin").slideUp();
	});
	$("#botaoLogar").click(function(){
		
		if($("#usuario").val() == "" || $("#senha").val()== ""){
			$("label").slideDown();
			return false;
					
		}else{
			 $.ajax({  
			        type: "post",    
			        url: "/climanut/ServletLogin",  
			        dataType: "json",
			        data: {  
			        	usuario:$("#usuario").val(),
			        	senha:$("#senha").val(),
						acao:"Entrar"
			        	
			        },  
			        success: function(result){ 

			        	if(result.tipo == 1){
			        		 var url = "http://localhost:8080/climanut/paginas"+result.url;
				        	  $(window.document.location).attr('href',url);
				        	 
			        	}else if(result.tipo == 0){
			        		 var url = "http://localhost:8080/climanut/paginas/areaCliente/areaCliente.jsp";
				        	  $(window.document.location).attr('href',url);
			        	}
			        	
			         	LimparCampos();
			          	LimparMensagens();
			         
			        },
	              error:function(){
	            	  LimparCampos();
	            	  $("#mensagemErroLogin").slideDown();
	            	  console.log("erro");
	              }      
			    });  
		}
	});	
});

</script>

</body>
</html>