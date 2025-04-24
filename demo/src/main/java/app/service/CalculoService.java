package app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.Entrada;
import app.entity.Calculo;
import app.repository.CalculoRepository;

@Service
public class CalculoService {

	@Autowired
	private CalculoRepository calculoRepository;

	public Calculo calcular(Entrada entrada) {

		if (entrada.lista() == null || entrada.lista().isEmpty()) 
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");

		Calculo calculo = new Calculo();
		calculo.setLista(entrada.lista());
		calculo.setSoma(this.soma(entrada.lista()));
		calculo.setMedia(this.media(entrada.lista()));
		calculo.setMediana(this.mediana(entrada.lista()));

		this.calculoRepository.save(calculo);
		return calculo;
	}

	public int soma(List<Integer> lista) {
		int soma = 0;

		for (int i = 0; i < lista.size(); i++) {
			soma += lista.get(i);
		}
		return soma;
	}


	public double media(List<Integer> lista) {
		return this.soma(lista) / lista.size();
	}


	public double mediana(List<Integer> lista) {
		
		Collections.sort(lista);

	    if (lista.size() % 2 == 1) { //ÍMPAR
	        return lista.get(lista.size() / 2);
	    } else {
	        int meio1 = lista.get(lista.size() / 2 - 1);
	        int meio2 = lista.get(lista.size() / 2);
	        return (meio1 + meio2) / 2;
	    }
	}

}
