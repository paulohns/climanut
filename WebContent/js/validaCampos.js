/**
 * JQUERY PARA VALIDAR CAMPOS
 *
 */
	function ValidarNumeros(campo) {
		
		campo.keyup(function(){
			
			var $this = $(this);
			var valor = $this.val().replace(/[^0-9]+/g,'');
			$this.val(valor);
		});
		
	}
	function ValidarLetras(campo) {
		
		campo.keyup(function(){
			
			var $this = $(this);
			var valor = $this.val().replace(/[^a-zA-Z]+/g,'');
			$this.val(valor);
		});
		
	}
	function ValidaCpf(campo){
		
	
	}
	