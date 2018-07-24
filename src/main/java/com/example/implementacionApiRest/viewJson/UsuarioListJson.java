package com.example.implementacionApiRest.viewJson;

import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class UsuarioListJson extends  MappingJackson2JsonView {

	@Override
	protected Object filterModel(Map<String, Object> model) {
		
		
		return super.filterModel(model);
	}
	
	

}
