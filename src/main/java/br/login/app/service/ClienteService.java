package br.login.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.login.app.model.Cliente;
import br.login.app.repository.ClienteRepository;
import br.login.app.request.ClienteRequest;
import br.login.app.response.BaseResponse;
import br.login.app.response.ListClienteResponse;

@Service
public class ClienteService {
	
	final ClienteRepository _repository;
	
	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}
	
	//CRIAR CLIENTE
	
	public BaseResponse criar(ClienteRequest request) {
		
		Cliente cliente = new Cliente();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		if(request.getNome() == null || request.getNome() == "") {
			response.message = "Nome Não inserido";
			return response;
		}
		if(request.getIdade() == null || request.getIdade() <0) {
			response.message = "Idade Não inserida";
			return response;
		}
		
		cliente.setIdade(request.getIdade());
		cliente.setNome(request.getNome());
		
		_repository.save(cliente);
		
		response.message = "Cliente cadastrado.";
		response.statusCode = 200;
		
		return response;
		
	}
	//LISTAR CLIENTES
	
	public ListClienteResponse listarClientes () {
		
		ListClienteResponse response = new ListClienteResponse();
		response.statusCode = 400;
		
		List<Cliente> lista = _repository.findAll();
		response.setClientes(lista);
		
		response.message = "Lista";
		response.statusCode = 200;
		
		return response;
	}
	//DELETE 
	
	public BaseResponse deletarCliente (Long id) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		if(id == null || id <= 0) {
			response.message = "ID invalido ou não Inserido.";
			return response;
		}
		
		 if(_repository.findById(id) == null) {
			 response.message = "Id não existente";
			 return response; 
		 }
		 
		_repository.deleteById(id);
		response.statusCode = 200;
		response.message = "Cliente Excluido";
		
		return response;
		
	}

}
