package br.login.app.controller;

import br.login.app.response.BaseResponse;

public class BaseController {
	
	public BaseResponse error = new BaseResponse();
	
	public BaseController() {
		error.message ="Erro inesperado.";
		error.statusCode = 500;
	}

}
