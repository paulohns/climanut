
<!DOCTYPE html>
<html>
	
	<div id="logo"><img id="imgLogo" alt="" src="/climanut/img/logo.png" ></div>
	<p id="titClimanut">&nbsp;&nbsp;Climanut | Manutenção em Sistemas de Climatização</p>
	<p id="bemvindoUser"> </p>
	<form action="ServletLogin" method="post" >
	<input id="sair" type="submit" name="acao" value="Sair" class="botaoSair" >
	</form>
	
	<script>
	$(document).ready(function(){
		
		console.log("entrei");
		 $.ajax({  
		        type: "post",    
		        url: "/climanut/ServletLogin",  
		        dataType: "json",
		        data: {  
					acao:"Usuario"
		        	
		        },  
		        success: function(result){  
		        	console.log(result.usuario);
		          
		          if(result.usuario == "invalido"){
		        	  console.log(result.usuario);
		        	  var url = "http://localhost:8080/climanut/paginas/login/index.jsp";
		        	  $(window.document.location).attr('href',url);
		        	  
		          }else{
		        	  $("#bemvindoUser").text("Bem-Vindo "+ result.usuario );
		          }
		        },
              error:function(){
            	  var url = "http://localhost:8080/climanut/paginas/login/index.jsp";
	        	  $(window.document.location).attr('href',url);
              }      
		    });  
		
		$("#imgLogo").mouseover(function(){
			$("#imgLogo").animate({opacity:'0.5'});
		});
		$("#imgLogo").mouseout(function(){
			$("#imgLogo").animate({opacity:'1'});
		});
	});
	</script>
</html>