package com.uniovi.sdi.blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletComentarios
 */
@WebServlet("/comentarios")
public class ServletComentarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ComentariosService cs = new ComentariosService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletComentarios() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comentario> comments = cs.getComentarios();
		
		// Retornar la vista con parámetro "carrito"
		request.setAttribute("comentariosBlog", comments);
		getServletContext().getRequestDispatcher("/blog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreUsuario = request.getParameter("usuario");
		String texto = request.getParameter("texto");
		
		Comentario cm = new Comentario(nombreUsuario.trim(), texto);
		cs.setNewComentario(cm);
		
		List<Comentario> comments = cs.getComentarios();
		
		request.setAttribute("comentariosBlog", comments);
		getServletContext().getRequestDispatcher("/blog.jsp").forward(request, response);
	}

}
