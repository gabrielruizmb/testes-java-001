package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.Entrada;
import app.entity.Calculo;
import app.service.CalculoService;


@RestController
@RequestMapping("/api/calculos")
@CrossOrigin("*")
public class CalculoController {

	@Autowired
	private CalculoService calculoService;

	@PostMapping
	public ResponseEntity<?> calcular(@RequestBody Entrada entrada){
		try {
			Calculo calculo = this.calculoService.calcular(entrada);
			
			return ResponseEntity.status(HttpStatus.OK).body(calculo);
			
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .body(exception.getMessage());
		}
	}
}