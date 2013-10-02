<!DOCTYPE html>

		<article class="pesquisar" style="margin-top:-20px;"><br>
			<span id="corTitulo"> Pesquisar Manutenção </span>
			<jsp:include page="../botoes/abrirFecharP.jsp"></jsp:include>
			<div id="formPesquisaFiltro" style="display:none"><br><br>
				<label>Cliente:</label><br>
				<input id="clientePesq" name="clientePesq" class="campoTexto" type="text" size="50"  /><br><br>
				<label>Data inicial:</label><label style="margin-left:155px;">Data final:</label><br>
				<input id="dataInicialPesq" name="dadataInicialPesqtaInicial" class="campoTexto" type="text" size="18" />
				<input id="dataFinalPesq" name="dataFinalPesq" class="campoTexto" type="text" size="18" style="margin-left:85px;" /><br><br><br>
				
				<input id="botaoPesquisarManutencao" name="acao" class="botao" type="submit" value="Pesquisar">
				<jsp:include page="../botoes/botaoLimparPesq.jsp"></jsp:include>
				<jsp:include page="../mensagens/mensagensPesq.jsp"></jsp:include><br><br>
			</div>
			<div id="formPesquisa" ><br>
				
				<table  class="display" id="example">
				<thead>
					<tr>
						<th>Localização</th>
						<th>Agenda</th>
						<th>Data da manutenção</th>
						<th>Descrição</th>
						<th>Tecnico</th>
					</tr>
				</thead>
				<tbody>
			
					<tr class="gradeA">
						<td>Zezinho</td>
						<td>Internet
							 Explorer 4.0</td>
						<td>Win 95+</td>
						<td class="center"> 4</td>
						<td class="center">X</td>
			
					</tr>
					<tr class="gradeA">
						<td>Trident</td>
						<td>Internet
							 Explorer 5.0</td>
						<td>Win 95+</td>
						<td class="center">5</td>
						<td class="center">C</td>
			
					</tr>
					<tr class="gradeA">
						<td>Trident</td>
						<td>Internet
							 Explorer 5.5</td>
						<td>Win 95+</td>
						<td class="center">5.5</td>
						<td class="center">A</td>
			
					</tr>
					<tr class="gradeA">
						<td>Trident</td>
						<td>Internet
							 Explorer 6</td>
						<td>Win 98+</td>
						<td class="center">6</td>
						<td class="center">A</td>
			
					</tr>
					<tr class="gradeA">
						<td>Presto</td>
						<td>Opera 9.5</td>
						<td>Win 88+ / OSX.3+</td>
						<td class="center">-</td>
						<td class="center">A</td>
			
					</tr>
					<tr class="gradeA">
						<td>Presto</td>
						<td>Opera for Wii</td>
						<td>Wii</td>
						<td class="center">-</td>
						<td class="center">A</td>
			
					</tr>
					<tr class="gradeA">
						<td>Presto</td>
						<td>Nokia N800</td>
						<td>N800</td>
						<td class="center">-</td>
						<td class="center">A</td>
			
					</tr>
					<tr class="gradeA">
						<td>Presto</td>
						<td>Nintendo DS browser</td>
						<td>Nintendo DS</td>
						<td class="center">8.5</td>
						<td class="center">C/A<sup>1</sup></td>
			
					</tr>
					<tr class="gradeA">
						<td>KHTML</td>
						<td>Konqureror 3.1</td>
						<td>KDE 3.1</td>
						<td class="center">3.1</td>
						<td class="center">C</td>
			
					</tr>
					<tr class="gradeA">
						<td>KHTML</td>
						<td>Konqureror 3.3</td>
						<td>KDE 3.3</td>
						<td class="center">3.3</td>
						<td class="center">A</td>
			
					</tr>
					<tr class="gradeA">
						<td>KHTML</td>
						<td>Konqureror 3.5</td>
						<td>KDE 3.5</td>
						<td class="center">3.5</td>
						<td class="center">A</td>
			
					</tr>
					<tr class="gradeA">
						<td>Tasman</td>
						<td>Internet Explorer 4.5</td>
						<td>Mac OS 8-9</td>
						<td class="center">-</td>
						<td class="center">X</td>
			
					</tr>
					<tr class="gradeA">
						<td>Tasman</td>
						<td>Internet Explorer 5.1</td>
						<td>Mac OS 7.6-9</td>
						<td class="center">1</td>
						<td class="center">C</td>
			
					</tr>
					<tr class="gradeA">
						<td>Misc</td>
						<td>Links</td>
						<td>Text only</td>
						<td class="center">-</td>
						<td class="center">X</td>
			
					</tr>
					<tr class="gradeA">
						<td>Misc</td>
						<td>Lynx</td>
						<td>Text only</td>
						<td class="center">-</td>
						<td class="center">X</td>
			
					</tr>
					<tr class="gradeA">
						<td>Misc</td>
						<td>IE Mobile</td>
						<td>Windows Mobile 6</td>
						<td class="center">-</td>
						<td class="center">C</td>
			
					</tr>
					<tr class="gradeA">
						<td>Misc</td>
						<td>PSP browser</td>
						<td>PSP</td>
						<td class="center">-</td>
						<td class="center">C</td>
			
					</tr>
					<tr class="gradeA">
						<td>Other browsers</td>
						<td>All others</td>
						<td>-</td>
						<td class="center">-</td>
						<td class="center">U</td>
			
					</tr>
				</tbody>
			</table>
			</div>
		</article>
