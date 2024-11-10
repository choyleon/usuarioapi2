package com.myapiadl.iara.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapiadl.iara.Model.Usuario;

public interface UsuarioDao  extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findById(Long id);

	

}
