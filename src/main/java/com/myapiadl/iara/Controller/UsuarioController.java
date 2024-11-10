package com.myapiadl.iara.Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.DatabaseStartupValidator;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapiadl.iara.Model.Usuario;
import com.myapiadl.iara.Model.UsuarioService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;



@RestController
@RequestMapping("/api/v2")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value="/usuarios")
	public ResponseEntity<Object> get(){
		Map<String , Object> map = new HashMap<String ,Object>();
		try {
			List<Usuario> list =usuarioService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	

	
	
	
	
	
	@GetMapping(value="/usuarios/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id){ 
		try {
			Usuario data = usuarioService.findById(id);
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		} 
		catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	
	/*
	@GetMapping(value="/usuarios/{correo}/telefono")
	public ResponseEntity<Object> getByEmailTel(@PathVariable String  correo, @PathVariable Long telefono ){ 
		try {
			Usuario data = usuarioService.findByEmailTel(correo,telefono);
			
			
			
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		} 
		catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	*/
	
	@PostMapping(value="/usuarios")
	public ResponseEntity<Object> create(@RequestBody Usuario usuario){		

		Map<String, Object> map = new HashMap<String, Object>();

	
		
		try {
			Usuario res = usuarioService.save(usuario);  
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
 	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> update(@RequestBody Usuario usuario, @PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			Usuario currentUsuario = usuarioService.findById(id);
			
			currentUsuario.setNomUsuario(usuario.getNomUsuario());
			currentUsuario.setCorreo(usuario.getCorreo());
			currentUsuario.setTelefono(usuario.getTelefono());
			currentUsuario.setPassword(usuario.getPassword());
			
			Usuario res = usuarioService.save(usuario);
			
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Usuario currentUsuario = usuarioService.findById(id); 
			usuarioService.delete(currentUsuario);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}


}
