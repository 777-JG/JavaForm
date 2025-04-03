package br.com.vemprafam.controller;

import java.util.List;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vemprafam.dao.DaoFuncionario;
import br.com.vemprafam.pojo.Funcionario;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {
	private DaoFuncionario dao = new DaoFuncionario();

	@GetMapping
	public String homeEmpty() {
		return "index";
	}
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/new")
	public String showInsertForm(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "create-funcionario";
	}
	@PostMapping
	public String createFuncionario(@ModelAttribute Funcionario funcionario) {
		dao.insert(funcionario);
		return "redirect:/funcionarios";
	}
	@GetMapping("/lista")
	public String showLista(Model model) {
		List<Funcionario> lista = dao.getLista();
		model.addAttribute ("funcionarios", lista);
		return "lista-funcionarios";
	}

}
