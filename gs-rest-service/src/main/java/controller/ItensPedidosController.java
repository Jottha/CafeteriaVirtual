package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.ItemPedido;
import repository.ItensPedidos;

@Controller
@RequestMapping("/itensPedidos")
public class ItensPedidosController {
	
	@Autowired
	private ItensPedidos itensPedidos;

	@GetMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroItensPedidos", "itensPedidos", new ItemPedido());
		mv.addObject("itensPedidos", itensPedidos.findAll());
		return mv;
	}
	
	@PostMapping
	public String salvar(ItemPedido itemPedido) {
		itensPedidos.save(itemPedido);
		return "redirect:/pedidos";
	}
	
}
