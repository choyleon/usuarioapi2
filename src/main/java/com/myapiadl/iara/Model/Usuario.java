package com.myapiadl.iara.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long  id;
	@Column
    private String nomUsuario;
	@Column
    private String correo;
	@Column
    private Long telefono;
	@Column
    private String password;
    
    
    public Usuario () {    	
    	
    }
    public Usuario (Long Id ,String NomUsuario,String Correo, Long Telefono ,String Password)
    {
    	this.id=Id;
    	this.nomUsuario=NomUsuario;
    	this.correo=Correo;
    	this.telefono=Telefono;
    	this.password=Password;
    }
    
    
    public Usuario (String Correo, Long Telefono)
    {

    	this.correo=Correo;
    	this.telefono=Telefono;
    
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
    
    
}
