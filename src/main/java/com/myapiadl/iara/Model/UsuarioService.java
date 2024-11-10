package com.myapiadl.iara.Model;

import java.util.List;



public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Usuario usuario);
	
	//public Usuario findById(String  email, Long telefono);

	//public Usuario findByEmailTel(String email, Long telefono);
	

}
