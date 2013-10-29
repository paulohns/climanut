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
			$("#idCliente").val(ui.item.id);
			console.log("idSelecionado:"+$("#idCliente").val());
			
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idCliente").val(0); 
				$("#cliente").val("");
				$("#cliente").focus();
			}
			
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
						console.log("idClienteBloco:" + $("#idClienteBloco").val());
						
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
			$("#idClienteBloco").val(ui.item.id);
			console.log("idSelecionado:"+$("#idClienteBloco").val());
			//Habilitar Campos
			$("#bloco").attr('disabled',false);
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idClienteBloco").val(0); 
				$("#clienteBloco").val("");
				$("#clienteBloco").focus();
				$("#bloco").attr('disabled','disabled');
				$("#idBloco").val(0); 
				$("#bloco").val("");
			}
		}
	});
	
	//AUTOCOMPLETE PAVIMENTO (CLIENTE E BLOCO)
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
					termo:$("#clientePavimento").val(),
					acao:"PesquisarAutocompleteCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idClientePavimento").val(0);
						$("#idBlocoPavimento").val(0);
						$("#blocoPavimento").val("");
						$("#bloco").attr('disabled','disabled');
						$("#pavimento").attr('disabled','disabled');
						console.log("idClientePavimentoVazio:" + $("#idClientePavimento").val());
						console.log("idBlocoPavimentoVazio:" + $("#idBlocoPavimento").val());
						console.log("blocoVazio:" + $("#pavimento").val());
						console.log("idPavimentoVazio:" + $("#idPavimento").val());
						console.log("pavimentoVazio:" + $("#pavimento").val());
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
			$("#idClientePavimento").val(ui.item.id);
			console.log("idSelecionado:"+$("#idClientePavimento").val());
			//Habilitar Campos
			$("#blocoPavimento").attr('disabled',false);
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idClientePavimento").val(0); 
				$("#clientePavimento").val("");
				$("#clientePavimento").focus();
				$("#blocoPavimento").attr('disabled','disabled');
				$("#idBlocoPavimento").val(0); 
				$("#blocoPavimento").val("");
				$("#pavimento").attr('disabled','disabled');
				$("#idPavimento").val(0); 
				$("#pavimento").val("");
			}
		}
	});

	$("#blocoPavimento").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletBloco",
				dataType: "json",
				data: {
					termo:$("#blocoPavimento").val(),
					idCliente: $("#idClientePavimento").val(),
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
			$("#idBlocoPavimento").val(ui.item.id);
			console.log("idSelecionado:"+$("#idBlocoPavimento").val());
			console.log("idClientePavimento:"+$("#idClientePavimento").val());
			//Habilitar Campos
			$("#pavimento").attr('disabled',false);
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idBlocoPavimento").val(0); 
				$("#blocoPavimento").val("");
				$("#blocoPavimento").focus();
				$("#pavimento").attr('disabled','disabled');
				$("#idPavimento").val(0); 
				$("#pavimento").val("");
			}
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
	$("#areaClimatizada").focus(function(){
		LimparMensagens();
	});
	$("#pessoasFixas").focus(function(){
		LimparMensagens();
	});
	$("#pessoasFlutuantes").focus(function(){
		LimparMensagens();
	});
	$("#tipoAtividade").focus(function(){
		LimparMensagens();
	});
	$("#clienteLocal").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletCliente",
				dataType: "json",
				data: {
					termo:$("#clienteLocal").val(),
					acao:"PesquisarAutocompleteCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idClienteLocal").val(0);
						$("#idBlocoLocal").val(0);
						$("#blocoLocal").val("");
						$("#idPavimentoLocal").val(0);
						$("#pavimentoLocal").val("");
						$("#bloco").attr('disabled','disabled');
						$("#pavimento").attr('disabled','disabled');
						$("#areaClimatizada").attr('disabled','disabled');
						$("#pessoasFixas").attr('disabled','disabled');
						$("#pessoasFlutuantes").attr('disabled','disabled');
						$("#tipoAtividade").attr('disabled','disabled');
						console.log("idClienteLocalVazio:" + $("#idClienteLocal").val());
						console.log("idBlocoLocalVazio:" + $("#idBlocoLocal").val());
						console.log("blocoVazio:" + $("#blocoLocal").val());
						console.log("idPavimentoVazio:" + $("#idPavimentoLocal").val());
						console.log("pavimentoVazio:" + $("#pavimento").val());
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
			$("#idClienteLocal").val(ui.item.id);
			console.log("idSelecionado:"+$("#idClienteLocal").val());
			//Habilitar Campos
			$("#blocoLocal").attr('disabled',false);
			
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idClienteLocal").val(0); 
				$("#clienteLocal").val("");
				$("#clienteLocal").focus();
				$("#blocoLocal").attr('disabled','disabled');
				$("#idBlocoLocal").val(0); 
				$("#blocoLocal").val("");
				$("#pavimentoLocal").attr('disabled','disabled');
				$("#idPavimentoLocal").val(0); 
				$("#pavimentoLocal").val("");
				$("#local").attr('disabled','disabled');
				$("#local").val("");
				$("#areaClimatizada").attr('disabled','disabled');
				$("#pessoasFixas").attr('disabled','disabled');
				$("#pessoasFlutuantes").attr('disabled','disabled');
				$("#tipoAtividade").attr('disabled','disabled');
			}
			
		}
	});

	$("#blocoLocal").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletBloco",
				dataType: "json",
				data: {
					termo:$("#blocoLocal").val(),
					idCliente: $("#idClienteLocal").val(),
					acao:"PesquisarAutocompleteBlocoPorCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idBlocoLocal").val(0);
						$("#idPavimentoLocal").val(0);
						$("#pavimentoLocal").val("");
						console.log("idBlocoLocalVazio:"+$("#idBlocoLocal").val());
						console.log("idPavimentoLocalVazio:"+$("#idPavimentoLocal").val());
						console.log("pavimentoLocalVazio:"+$("#pavimentoLocal").val());
						
						$("#pavimentoLocal").attr("disabled",'disabled');
						$("#local").attr("disabled",'disabled');
						$("#areaClimatizada").attr('disabled','disabled');
						$("#pessoasFixas").attr('disabled','disabled');
						$("#pessoasFlutuantes").attr('disabled','disabled');
						$("#tipoAtividade").attr('disabled','disabled');
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
			$("#idBlocoLocal").val(ui.item.id);
			console.log("idBlocoLocalSelecionado:"+$("#idBlocoLocal").val());
			console.log("idClienteLocal:"+$("#idClienteLocal").val());
			//Limpar os campos abaixo
			$("#idPavimentoLocal").val(0);
			$("#pavimentoLocal").val("");
			//Habilitar Campos
			$("#pavimentoLocal").attr('disabled',false);
			
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idBlocoLocal").val(0); 
				$("#blocoLocal").val("");
				$("#blocoLocal").focus();
				$("#pavimentoLocal").attr('disabled','disabled');
				$("#idPavimentoLocal").val(0); 
				$("#pavimentoLocal").val("");
				$("#local").attr('disabled','disabled');
				$("#local").val("");
				$("#areaClimatizada").attr('disabled','disabled');
				$("#pessoasFixas").attr('disabled','disabled');
				$("#pessoasFlutuantes").attr('disabled','disabled');
				$("#tipoAtividade").attr('disabled','disabled');
			}
		}
	});
	
	$("#pavimentoLocal").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletPavimento",
				dataType: "json",
				data: {
					termo:$("#pavimentoLocal").val(),
					idBlocoPavimento: $("#idBlocoLocal").val(),
					acao:"PesquisarAutocompletePavimentoPorBloco"
				},
				success: function(data) {
					if(data.length === 0){
						//Limpar campos abaixo
						$("#idPavimentoLocal").val(0);
						console.log("idBlocoLocalVazio:"+$("#idBlocoLocal").val());
						console.log("idPavimentoLocalVazio:"+$("#idPavimentoLocal").val());
						console.log("pavimentoLocalVazio:"+$("#pavimentoLocal").val());
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
			$("#idPavimentoLocal").val(ui.item.id);
			console.log("idSelecionado:"+$("#idPavimentoLocal").val());
			console.log("idPavimentoLocal:"+$("#idPavimentoLocal").val());
			//Habilitar Campos
			$("#local").attr("disabled",false);
			
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idPavimentoLocal").val(0); 
				$("#pavimentoLocal").val("");
				$("#pavimentoLocal").focus();
				$("#local").attr('disabled','disabled');
				$("#local").val("");
				$("#areaClimatizada").attr('disabled','disabled');
				$("#pessoasFixas").attr('disabled','disabled');
				$("#pessoasFlutuantes").attr('disabled','disabled');
				$("#tipoAtividade").attr('disabled','disabled');
			}
		}
	});
	$("#local").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletLocal",
				dataType: "json",
				data: {
					termo:$("#local").val(),
					idPavimentoEquipamento: $("#idPavimentoLocal").val(),
					acao:"PesquisarAutocompleteLocalPorPavimento"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idLocal").val(0);
						console.log("idBlocoLocalVazio:"+$("#idBlocoLocal").val());
						console.log("idPavimentoLocalVazio:"+$("#idPavimentoLocal").val());
						console.log("pavimentoLocalVazio:"+$("#pavimentoLocal").val());
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
			$("#idLocal").val(ui.item.id);
			console.log("idSelecionado:"+$("#idLocal").val());
			console.log("idLocal:"+$("#idLocal").val());
			//Limpar os campos abaixo
			$("#idLocal").val(0);
			$("#local").val("");
			//Habilitar Campos
			$("#areaClimatizada").attr('disabled',false);
			$("#pessoasFixas").attr('disabled',false);
			$("#pessoasFlutuantes").attr('disabled',false);
			$("#tipoAtividade").attr('disabled',false);
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#areaClimatizada").attr('disabled','disabled');
				$("#areaClimatizada").val("");
				$("#pessoasFixas").attr('disabled','disabled');
				$("#pessoasFixas").val("");
				$("#pessoasFlutuantes").attr('disabled','disabled');
				$("#pessoasFlutuantes").val("");
				$("#tipoAtividade").attr('disabled','disabled');
				$("#tipoAtividade").val("");
			}
			
		}
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
	$("#clienteEquipamento").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletCliente",
				dataType: "json",
				data: {
					termo:$("#clienteEquipamento").val(),
					acao:"PesquisarAutocompleteCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idClienteEquipamento").val(0);
						$("#idBlocoEquipamento").val(0);
						$("#blocoEquipamento").val("");
						$("#idPavimentoEquipamento").val(0);
						$("#pavimentoEquipamento").val("");
						$("#idLocalEquipamento").val(0);
						$("#localEquipamento").val("");
						$("#bloco").attr('disabled','disabled');
						$("#pavimento").attr('disabled','disabled');
						$("#local").attr('disabled','disabled');
						console.log("idClienteEquipamentoVazio:" + $("#idClienteEquipamento").val());
						console.log("idBlocoEquipamentoVazio:" + $("#idBlocoEquipamento").val());
						console.log("blocoEquipamentoVazio:" + $("#blocoEquipamento").val());
						console.log("idPavimentoEquipamentoVazio:" + $("#idPavimentoEquipamento").val());
						console.log("pavimentoEquipamentoVazio:" + $("#pavimentoEquipamento").val());
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
			$("#idClienteEquipamento").val((ui.item.id ? ui.item.id : 0));
			console.log("idSelecionado:"+$("#idClienteEquipamento").val());
			//Limpar campos abaixo
			$("#idBlocoEquipamento").val(0);
			$("#blocoEquipamento").val("");
			$("#idPavimentoEquipamento").val(0);
			$("#pavimentoEquipamento").val("");
			$("#idLocalEquipamento").val(0);
			$("#localEquipamento").val("");
			$("#idEquipamento").val(0);
			$("#equipamento").val("");
			//Habilitar Campos
			$("#blocoEquipamento").attr('disabled',false);
			
		},
		change: function( event,ui) {
			if ( !ui.item ) {
				ui.item = "";
				$("#idClienteEquipamento").val(0);
				$("#clienteEquipamento").val("");
				$("#clienteEquipamento").focus();
				$("#blocoEquipamento").attr('disabled','disabled');
				$("#idBlocoEquipamento").val(0); 
				$("#blocoEquipamento").val("");
				$("#pavimentoEquipamento").attr('disabled','disabled');
				$("#idPavimentoEquipamento").val(0);
				$("#pavimentoEquipamento").val("");
				$("#localEquipamento").attr('disabled','disabled');
				$("#idLocalEquipamento").val(0); 
				$("#localEquipamento").val("");
				$("#equipamento").attr('disabled','disabled');
				$("#idEquipamento").val(0);
				$("#equipamento").val("");
				$("#numeroInterno").attr('disabled','disabled');
				$("#numeroInterno").val("");
           }
			
		}
	});

	$("#blocoEquipamento").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletBloco",
				dataType: "json",
				data: {
					termo:$("#blocoEquipamento").val(),
					idCliente: $("#idClienteEquipamento").val(),
					acao:"PesquisarAutocompleteBlocoPorCliente"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idBlocoEquipamento").val(0);
						$("#idPavimentoEquipamento").val(0);
						
						console.log("idBlocoEquipamentoVazio:"+$("#idBlocoEquipamento").val());
						console.log("idPavimentoEquipamentoVazio:"+$("#idPavimentoEquipamento").val());
					
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
			$("#idBlocoEquipamento").val(ui.item.id);
			console.log("idBlocoEquipamentoSelecionado:"+$("#idBlocoEquipamento").val());
			console.log("idBlocoEquipamento:"+$("#idBlocoEquipamento").val());
			//Limpar campos abaixo
			$("#idPavimentoEquipamento").val(0);
			$("#pavimentoEquipamento").val("");
			$("#idLocalEquipamento").val(0);
			$("#localEquipamento").val("");
			$("#idEquipamento").val(0);
			$("#equipamento").val("");
			//Habilitar Campos
			$("#pavimentoEquipamento").attr('disabled',false);
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idBlocoEquipamento").val(0); 
				$("#blocoEquipamento").val("");
				$("#blocoEquipamento").focus();
				$("#pavimentoEquipamento").attr('disabled','disabled');
				$("#idPavimentoEquipamento").val(0); 
				$("#pavimentoEquipamento").val("");
				$("#localEquipamento").attr('disabled','disabled');
				$("#idLocalEquipamento").val(0); 
				$("#localEquipamento").val("");
				$("#equipamento").attr('disabled','disabled');
				$("#idEquipamento").val(0); 
				$("#equipamento").val("");
				$("#numeroInterno").attr('disabled','disabled');
				$("#numeroInterno").val("");
			}
		}
	});
	$("#pavimentoEquipamento").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletPavimento",
				dataType: "json",
				data: {
					termo:$("#pavimentoEquipamento").val(),
					idBlocoPavimento: $("#idBlocoEquipamento").val(),
					acao:"PesquisarAutocompletePavimentoPorBloco"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idPavimentoEquipamento").val(0);
						$("#pavimentoEquipamento").val("");
						$("#idLocalEquipamento").val(0);
						$("#localEquipamento").val("");
						console.log("idBlocoEquipamentoVazio:"+$("#idBlocoEquipamento").val());
						console.log("idPavimentoEquipamentoVazio:"+$("#idPavimentoEquipamento").val());
						console.log("pavimentoEquipamentoVazio:"+$("#pavimentoEquipamento").val());
						console.log("idLocalEquipamento:"+$("#idLocalEquipamento").val());
						console.log("localEquipamento:"+$("#localEquipamento").val());
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
			$("#idPavimentoEquipamento").val(ui.item.id);
			console.log("idSelecionado:"+$("#idPavimentoEquipamento").val());
			console.log("idPavimentoEquipamento:"+$("#idBlocoEquipamento").val());
			//Limpar os campos abaixo
			$("#idLocalEquipamento").val(0);
			$("#localEquipamento").val("");
			$("#idEquipamento").val(0);
			$("#equipamento").val("");
			//Habilitar Campos
			$("#localEquipamento").attr('disabled',false);
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idPavimentoEquipamento").val(0); 
				$("#pavimentoEquipamento").val("");
				$("#pavimentoEquipamento").focus();
				$("#localEquipamento").attr('disabled','disabled');
				$("#idLocalEquipamento").val(0); 
				$("#localEquipamento").val("");
				$("#equipamento").attr('disabled','disabled');
				$("#idEquipamento").val(0); 
				$("#equipamento").val("");
				$("#numeroInterno").attr('disabled','disabled');
				$("#numeroInterno").val("");
			}
		}
	});
	$("#localEquipamento").autocomplete({
		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletLocal",
				dataType: "json",
				data: {
					termo:$("#localEquipamento").val(),
					idPavimentoEquipamento: $("#idPavimentoEquipamento").val(),
					acao:"PesquisarAutocompleteLocalPorPavimento"
				},
				success: function(data) {
					if(data.length === 0){
						$("#pavimentoLocal").val();
						console.log("idBlocoLocalVazio:"+$("#idBlocoLocal").val());
						console.log("idPavimentoLocalVazio:"+$("#idPavimentoLocal").val());
						console.log("pavimentoLocalVazio:"+$("#pavimentoLocal").val());
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
			$("#idLocalEquipamento").val(ui.item.id);
			console.log("idSelecionado:"+$("#idLocalEquipamento").val());
			console.log("idLocalEquipamento:"+$("#idLocalEquipamento").val());
			//Limpar os campos abaixo
			$("#idEquipamento").val(0);
			$("#equipamento").val("");
			//Habilitar Campos
			$("#equipamento").attr('disabled',false);
		},
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idLocalEquipamento").val(0); 
				$("#localEquipamento").val("");
				$("#localEquipamento").focus();
				$("#equipamento").attr('disabled','disabled');
				$("#idEquipamento").val(0);
				$("#equipamento").val("");
				$("#numeroInterno").attr('disabled','disabled');
				$("#numeroInterno").val("");
			}
			
		}
	});
	$("#equipamento").autocomplete({

		source: function(request, response) {
			$.ajax({
				type: "post",
				url: "/climanut/ServletEquipamento",
				dataType: "json",
				data: {
					termo:$("#equipamento").val(),
					acao:"PesquisarAutocompleteEquipamento"
				},
				success: function(data) {
					if(data.length === 0){
						$("#idEquipamento").val();
						console.log("idClienteEquipamentoVazio:"+$("#idClienteEquipamento").val());
						console.log("idBlocoEquipamentoVazio:"+$("#idBlocoEquipamento").val());
						console.log("idPavimentoEquipamentoVazio:"+$("#idPavimentoEquipamento").val());
						console.log("idLocalEquipamentoVazio:"+$("#idLocalEquipamento").val());
						console.log("idEquipamentoVazio:"+$("#idEquipamento").val());
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
			$("#idEquipamento").val(ui.item.id);
			console.log("idSelecionado:"+$("#idEquipamento").val());
			console.log("idEquipamento:"+$("#idEquipamento").val());
			//Limpar os campos abaixo
			$("#numeroInterno").val("");
			//Habilitar Campos
			$("#numeroInterno").attr('disabled',false);
		},
		
		change:function(event,ui){
			if ( !ui.item ) {
				ui.item = "";
				$("#idEquipamento").val(0);
				$("#equipamento").val("");
				$("#equipamento").focus();
				$("#numeroInterno").attr('disabled','disabled');
				$("#numeroInterno").val("");
			}
		}
	});
});			
