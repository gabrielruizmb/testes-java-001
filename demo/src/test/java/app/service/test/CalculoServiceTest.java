package app.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculoService;

@SpringBootTest
public class CalculoServiceTest {
	
	@Autowired
	CalculoService calculoService;

	@Test
	@DisplayName("Cena 01 - Testando o método somar com valores válidos")
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(5);
		lista.add(2);
		
		int resultadoEsperado = 10;
		int resultadoObtido = this.calculoService.soma(lista);
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	

	@Test
	@DisplayName("Cena 02 - Testando o método somar com valores inválidos")
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(null);
		lista.add(2);
				
		assertThrows(Exception.class,() -> {
			this.calculoService.soma(lista);
		});
		
		
	}
	
	
	
	
	@Test
	@DisplayName("Cena 03 - Testar mediana com número par de elementos")
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 04 - Testar mediana com número ímpar de elementos")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	
	@Test
	@DisplayName("Cena 05 - Testar mediana com número ímpar de elementos")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(39);
		lista.add(339);
		lista.add(4);
		
		assertEquals(8, this.calculoService.mediana(lista));
	}
	
	

}
