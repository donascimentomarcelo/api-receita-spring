package br.com.receita.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.receita.domain.Grupo;
import br.com.receita.dto.GrupoDTO;
import br.com.receita.service.GrupoService;

/**
 * @Author Marcelo Nascimento
 * @Date 10 de out de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc Controlador de curso.
 */
@RestController
@RequestMapping("/api/v1/grupos")
public class GrupoResource {

	@Autowired
	private GrupoService grupoService;
	
	@GetMapping
	ResponseEntity<List<GrupoDTO>> listar() {
		List<Grupo> lista = grupoService.listar();
		List<GrupoDTO> listaDto = lista.stream().map(grupo -> new GrupoDTO(grupo)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
}
