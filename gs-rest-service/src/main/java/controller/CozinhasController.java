package controller;

import model.Cozinha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import repository.Cozinhas;

@Controller
@RequestMapping("/cozinhas")
public class CozinhasController {
	
	@Autowired
	private Cozinhas cozinhas;
	
	@GetMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroCozinhas", "cozinhas", new Cozinha());
		mv.addObject("cozinhas", cozinhas.findAll());
		return mv;
	}
	
	@PostMapping
	public String salvar(Cozinha cozinha) {
		cozinhas.save(cozinha);
		return "redirect:/cozinhas";
	}
	
}