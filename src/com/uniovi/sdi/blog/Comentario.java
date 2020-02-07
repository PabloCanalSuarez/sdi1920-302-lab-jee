package com.uniovi.sdi.blog;

public class Comentario {

	private String nombreUsuario;
	private String comentario;
	
	public Comentario() {}
	
	public Comentario(String nombreUsuario, String comentario) {
		this.nombreUsuario = nombreUsuario;
		this.comentario = comentario;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
