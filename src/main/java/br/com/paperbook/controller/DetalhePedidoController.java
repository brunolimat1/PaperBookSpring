package br.com.paperbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paperbook.domain.DetalhePedido;
import br.com.paperbook.repository.DetalhePedidoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/detalhepedido")
public class DetalhePedidoController {

	@Autowired
	private DetalhePedidoRepository detalhepedidoRepo;

	@GetMapping("/listar")
	public List<DetalhePedido> listar() {
		return detalhepedidoRepo.findAll();

	}

	@GetMapping("/buscar/{id}")
	public Optional<DetalhePedido> buscar(@PathVariable Integer id) {
		return detalhepedidoRepo.findById(id);
	}

	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody DetalhePedido cat) {
		detalhepedidoRepo.save(cat);
		return "{Detalhe do Pedido cadastrado}";

	}

	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id, @RequestBody DetalhePedido cat) {

		Optional<DetalhePedido> ct = detalhepedidoRepo.findById(id);
		String msg = "";

		if (ct.isPresent()) {
			DetalhePedido c = new DetalhePedido();
			c.setIddetalhepedido(id);
			c.setQuantidade(cat.getQuantidade());
			c.setPrecounitario(cat.getPrecounitario());
			c.setValortotal(cat.getValortotal());
			c.setPedido(cat.getPedido());
			c.setProduto(cat.getProduto());
			detalhepedidoRepo.save(c);
			msg = "Detalhe Pedido atualizado.";
		} else {
			msg = "Detalhe Pedido não localizado.";
		}
		return msg;

	}

	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		detalhepedidoRepo.deleteById(id);

		return "Detalhe Pedido Apagado";
	}

}
