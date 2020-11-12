package br.login.app.response;

import java.util.List;
import br.login.app.model.Cliente;

public class ListClienteResponse extends BaseResponse{
	
	private List<Cliente> clientes;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
