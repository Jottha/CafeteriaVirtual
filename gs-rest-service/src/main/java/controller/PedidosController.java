package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Pedido;
import repository.Pedidos;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	private Pedidos pedidos;

	@GetMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroPedidos", "pedidos", new Pedido());
		mv.addObject("pedidos", pedidos.findAll());
		return mv;
	}
	
	@PostMapping
	public String salvar(Pedido pedido) {
		pedidos.save(pedido);
		return "redirect:/pedidos";
	}
	
}
