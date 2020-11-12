package br.login.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.login.app.request.ClienteRequest;
import br.login.app.response.BaseResponse;
import br.login.app.response.ListClienteResponse;
import br.login.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {
	
	
	private final ClienteService _service;
	
	public ClienteController(ClienteService service) {
		_service = service;
		
	}
	
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar(ClienteRequest request){
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
				
		}
	}
	@GetMapping
	public ResponseEntity<BaseResponse> listarClientes(){
		try {
			ListClienteResponse response = _service.listarClientes();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
			
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> deletar(@PathVariable Long id){
		try {
			BaseResponse response = _service.deletarCliente(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
		
	}
	
	
	
	
	
	
	
	
	

}
