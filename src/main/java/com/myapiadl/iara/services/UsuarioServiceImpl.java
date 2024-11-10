package com.myapiadl.iara.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapiadl.iara.Model.Usuario;
import com.myapiadl.iara.Model.UsuarioService;
import com.myapiadl.iara.repository.UsuarioDao;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@Override
	@Transactional
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.save(usuario);
	}

	@Override	
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDao.delete(usuario);
	}

/*	@Override
	public Usuario findByEmailTel(String email, Long telefono) {
		// TODO Auto-generated method stub
		return usuarioDao.findByEmailTel(email ,telefono).orElse(null);
	}
	*/
	

}
