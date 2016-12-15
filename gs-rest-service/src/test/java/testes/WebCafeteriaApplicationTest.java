package testes;

import static org.junit.Assert.assertEquals;
import model.Cozinha;
import model.Garcom;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebCafeteriaApplicationTest {

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void cozinhaTest(){
		Cozinha cozinha = new Cozinha();
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		Garcom garcom = new Garcom();
		ItemPedido itemPedido = new ItemPedido();
		
		cozinha.setId(1);
		cozinha.setNome("WebCozinha");
		
		produto.setId(1);
		produto.setDescricao("Coca-Cola");
		produto.setValor(4.00);
		
		
		pedido.setData(null);
		pedido.setGarcom(garcom);
		pedido.setId(1);
		pedido.setFinalizado(true);
		
		itemPedido.setId(1);
		itemPedido.setPedido(pedido);
		itemPedido.setProduto(produto);
		itemPedido.setQuantidade(2);
		
		garcom.setId(1);
		garcom.setNome("Jaciel");
		
		cozinha.addProduto(produto);
		cozinha.setDecisaoPedido(true);
		cozinha.setProdutoDisponivel(true);
		
		pedido.addItem(itemPedido);
		
		assertEquals("Jaciel", cozinha.getGarcom());
		
	}
}
