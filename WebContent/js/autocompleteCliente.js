/**
 * JQUERY PARA AUTOCOMPLETE DE CLIENTE
 * 
 */

var idClienteBloco;

function autocompleteCliente(campo,id,acao){
	console.log("campo:"+campo);
	$(campo).autocomplete({

		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletCliente",
				dataType: "json",
				data: {
					termo:$(campo).val(),
					acao:acao
				},
				success: function(data) {
					if(!data[1]){
						idClienteBloco = 0;
					}
					response($.map(data, function(item) {
						return {
							value: item.nome,
							id: item.id
						};

					})); 
				if(campo == "#clienteBloco"){
					$("#bloco").attr('disabled',false);
				}else if(campo == "#clientePavimento"){
					$("#blocoPavimento").attr('disabled',false);
				}	
				
				},
				error:function(){
					console.log("Erro");
				}
			});
		},
		select: function(event, ui) {
			
			$(id).val(ui.item.id);
			idClienteBloco = $(id).val();
			console.log("idSelecionado:"+$(id).val());
		}
	});
}
function autocompleteBlocoPorCliente(campo,idCliente,acao){
	console.log("campo:"+$(campo).val());
	console.log("idCliente:"+idClienteBloco);
	
	$(campo).autocomplete({
		
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletBloco",
				dataType: "json",
				data: {
					termo:$(campo).val(),
					idCliente:idClienteBloco,
					acao:acao
				},
				success: function(data) {
					if(!data[1]){
						$("#idBloco").val(0);
					}
					response($.map(data, function(item) {
						return {
							value: item.nome,
							id: item.id
						};

					})); 
				if(campo == "#clienteBloco"){
					$("#bloco").attr('disabled',false);
				}else if(campo == "#clientePavimento"){
					$("#blocoPavimento").attr('disabled',false);
				}	
				
				},
				error:function(){
					console.log("Erro");
					
				}
			});
		},
		select: function(event, ui) {
			
			$("#idBloco").val(ui.item.id);
			$("#idClienteBloco").val(idClienteBloco);
			
		}
	});
}