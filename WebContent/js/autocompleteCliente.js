$(document).ready(function(){

	// AUTOCOMPLETE CLIENTE (CLIENTE)
	$("#cliente").focus(function(){
		LimparMensagens();
	});
	$("#cliente").autocomplete({

		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletCliente",
				dataType: "json",
				data: {
					termo:$("#cliente").val(),
					acao:"PesquisarAutocompleteCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idCliente").val(0);
						console.log("idClienteErrado:" + $("#idCliente").val());
					}
					response($.map(data, function(item) {
						return {
							value: item.nome,
							id: item.id
						};

					})); 

				},
				error:function(){
					console.log("Erro");
				}
			});
		},
		select: function(event, ui) {

			$("#idCliente").val(ui.item.id);
			console.log("idSelecionado:"+$("#idCliente").val());
		}
	});

	//	AUTOCOMPLETE BLOCO (CLIENTE,BLOCO)
	$("#clienteBloco").focus(function(){
		LimparMensagens();
	});
	$("#bloco").focus(function(){
		LimparMensagens();
	});

	$("#clienteBloco").autocomplete({

		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletCliente",
				dataType: "json",
				data: {
					termo:$("#clienteBloco").val(),
					acao:"PesquisarAutocompleteCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idClienteBloco").val(0);
						$("#idBloco").val(0);
						$("#bloco").val("");
						$("#bloco").attr('disabled','disabled');
						console.log("idClienteBloco:" + $("#idClienteBloco").val());
						console.log("idBlocoVazio:" + $("#idBloco").val());
						console.log("blocoVazio:" + $("#bloco").val());
					}
					response($.map(data, function(item) {
						return {
							value: item.nome,
							id: item.id
						};

					})); 
					//Habilitar Campos
					$("#bloco").attr('disabled',false);


				},
				error:function(){
					console.log("Erro");
				}
			});
		},
		select: function(event, ui) {

			$("#idClienteBloco").val(ui.item.id);
			console.log("idSelecionado:"+$("#idClienteBloco").val());
		}
	});

	/*$("#bloco").autocomplete({

		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletBloco",
				dataType: "json",
				data: {
					termo:$("#bloco").val(),
					idCliente: $("#idClienteBloco").val(),
					acao:"PesquisarAutocompleteBlocoPorCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idBloco").val(0);
						console.log("idBloco:"+$("#idBloco").val());
					}
					response($.map(data, function(item) {
						return {
							value: item.nome,
							id: item.id
						};

					})); 
					//Habilitar Campos
					$("#bloco").attr('disabled',false);


				},
				error:function(){
					console.log("Erro");
				}
			});
		},
		select: function(event, ui) {

			$("#idBloco").val(ui.item.id);
			console.log("idSelecionado:"+$("#idBloco").val());
		}
	});
*/	
	//AUTOCOMPLETE PAVIMENTO (CLIENTE, BLOCO E PAVIMENTO)
	$("#clientePavimento").focus(function(){
		LimparMensagens();
	});
	$("#blocoPavimento").focus(function(){
		LimparMensagens();
	});
	$("#pavimento").focus(function(){
		LimparMensagens();
	});
	
	$("#clientePavimento").autocomplete({

		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletCliente",
				dataType: "json",
				data: {
					termo:$("#clientepavimento").val(),
					acao:"PesquisarAutocompleteCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idClientePavimento").val(0);
						$("#idBlocoPavimento").val(0);
						$("#blocoPavimento").val("");
						$("#idPavimento").val(0);
						$("#pavimento").val("");
						
						$("#bloco").attr('disabled','disabled');
						$("#pavimento").attr('disabled','disabled');
						
						console.log("idClientePavimentoVazio:" + $("#idClientePavimento").val());
						console.log("idBlocoPavimentoVazio:" + $("#idBlocoPavimento").val());
						console.log("blocoVazio:" + $("#pavimento").val());
						console.log("idPavimentoVazio:" + $("#idPavimento").val());
						console.log("pavimentoVazio:" + $("#pavimento").val());
					}
					response($.map(data, function(item) {
						return {
							value: item.nome,
							id: item.id
						};

					})); 
					//Habilitar Campos
					$("#blocoPavimento").attr('disabled',false);

				},
				error:function(){
					console.log("Erro");
				}
			});
		},
		select: function(event, ui) {

			$("#idClientePavimento").val(ui.item.id);
			console.log("idSelecionado:"+$("#idClientePavimento").val());
		}
	});

	$("#blocoPavimento").autocomplete({

		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletBloco",
				dataType: "json",
				data: {
					termo:$("#bloco").val(),
					idCliente: $("#idClienteBloco").val(),
					acao:"PesquisarAutocompleteBlocoPorCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idBlocoPavimento").val(0);
						$("#idPavimento").val(0);
						$("#pavimento").val();
						console.log("idBlocoPavimentoVazio:"+$("#idBlocoPavimento").val());
						console.log("idPavimentoVazio:"+$("#idPavimento").val());
						console.log("pavimentoVazio:"+$("#pavimento").val());
					}
					response($.map(data, function(item) {
						return {
							value: item.nome,
							id: item.id
						};

					})); 
					//Habilitar Campos
					$("#pavimento").attr('disabled',false);


				},
				error:function(){
					console.log("Erro");
				}
			});
		},
		select: function(event, ui) {

			$("#idBlocoPavimento").val(ui.item.id);
			console.log("idSelecionado:"+$("#idBloco").val());
		}
	});

	//AUTOCOMPLETE LOCAL (CLIENTE, BLOCO, PAVIMENTO E LOCAL)
	$("#clienteLocal").focus(function(){
		LimparMensagens();
	});
	$("#blocoLocal").focus(function(){
		LimparMensagens();
	});
	$("#pavimentoLocal").focus(function(){
		LimparMensagens();
	});
	$("#local").focus(function(){
		LimparMensagens();
	});
	
	//AUTOCOMPLETE EQUIPAMENTO (CLIENTE, BLOCO, PAVIMENTO, LOCAL E EQUIPAMENTO)
	$("#clienteEquipamento").focus(function(){
		LimparMensagens();
	});
	$("#blocoEquipamento").focus(function(){
		LimparMensagens();
	});
	$("#pavimentoEquipamento").focus(function(){
		LimparMensagens();
	});
	$("#localEquipamento").focus(function(){
		LimparMensagens();
	});
	$("#equipamento").focus(function(){
		LimparMensagens();
	});
	


});			
