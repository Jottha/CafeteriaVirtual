package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Produto;
import repository.Produtos;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private Produtos produtos;

	@GetMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroProdutos", "produtos", new Produto());
		mv.addObject("produtos", produtos.findAll());
		return mv;
	}
	
	@PostMapping
	public String salvar(Produto produto) {
		produtos.save(produto);
		return "redirect:/produtos";
	}
	
}
