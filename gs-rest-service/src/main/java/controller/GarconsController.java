package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Garcom;
import repository.Garcons;

@Controller
@RequestMapping("/garcons")
public class GarconsController {
	
	@Autowired
	private Garcons garcons;

	@GetMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroGarcons", "garcons", new Garcom());
		mv.addObject("garcons", garcons.findAll());
		return mv;
	}
	
	@PostMapping
	public String salvar(Garcom garcom) {
		garcons.save(garcom);
		return "redirect:/garcons";
	}
	
}
