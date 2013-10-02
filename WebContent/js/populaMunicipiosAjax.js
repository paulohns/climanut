/**
 * JQUERY PARA O BOTAO DE CADASTRAR AGENDA 
 * E LIMPAR CAMPOS 
 */

$(document).ready(function(){	   
        var tXHR=0;  
  
        function XMLHTTPRequest() {  
          if (window.XMLHttpRequest) {   
              a=new XMLHttpRequest(); } //Objeto nativo (FF/Safari/Opera7.6+)  
          else {  
            try {   
               a=new ActiveXObject("Msxml2.XMLHTTP");  //activeX (IE5.5+/MSXML2+)  
            }     
            catch(e) {  
              try {   
                 a=new ActiveXObject("Microsoft.XMLHTTP"); //activeX (IE5+/MSXML1)  
              }     
              catch(e) { /* O navegador não tem suporte */   
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
                /*  success:function(responseText){  
                	 $('#idCidades').html('option').text(responseText);
                	// $('#idCidades').text(responseText); 
                	 alert("OKAY"); 
                 }   */
        	 });       
       });
});