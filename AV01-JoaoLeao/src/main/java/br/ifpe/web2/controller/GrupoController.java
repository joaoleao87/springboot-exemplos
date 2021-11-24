package br.ifpe.web2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.service.GrupoService;

@Controller
public class GrupoController {

	@Autowired
	GrupoService grupoService;
	
	@GetMapping("/cadastrarGrupos")
	public String exibirForm(Grupo grupo) {
		return "grupos";
	}
		
	@PostMapping("salvarGrupo")
	public String salvarGrupo(Grupo grupo) {
		grupoService.criarGrupo(grupo);
		return "index";
	}
	
	@GetMapping("/listarGrupos")
	public String listarGrupos(Model model) {
		model.addAttribute("listaGrupos", grupoService.listarGrupos());
		return "index";
	}
}
