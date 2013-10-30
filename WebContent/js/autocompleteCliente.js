$(document).ready(function(){

	// AUTOCOMPLETE CLIENTE (CLIENTE)
	$("#cliente").focus(function(){
		LimparMensagens();
	});
	$("#clientePesq").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletCliente",
				dataType: "json",
				data: {
					termo:$("#clientePesq").val(),
					acao:"PesquisarAutocompleteCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idClientePesq").val(0);
						console.log("idClienteErrado:" + $("#idClientePesq").val());
					}else{
						response($.map(data, function(item) {
							return {
								value: item.nome,
								id: item.id
							};
						})); 
					}
				},
				error:function(){
					console.log("Erro");
				}
			});
		},
		select: function(event, ui) {
			$("#idClientePesq").val(ui.item.id);
			console.log("idSelecionado:"+$("#idClientePesq").val());
			
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idClientePesq").val(0); 
				$("#clientePesq").val("");
				$("#clientePesq").focus();
			}
			
			console.log("idSelecionado:"+$("#idClientePesq").val());
		}
	});

});