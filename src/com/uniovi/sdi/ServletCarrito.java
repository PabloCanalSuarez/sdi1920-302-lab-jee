package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/manejarCarrito")
public class ServletCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Opciones del Servlet.
	private final static String AÑADIR_CARRITO = "add";
	private final static String ELIMINAR_CARRITO = "delete";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCarrito() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		HashMap<String, Integer> carrito = (HashMap<String, Integer>) session.getAttribute("carrito");

		// No hay carrito, creamos uno y lo insertamos en sesión
		if (carrito == null) {
			carrito = new HashMap<String, Integer>();
			session.setAttribute("carrito", carrito);
		}

		String producto = request.getParameter("producto");

		if(producto != null) {
			String opcion = request.getParameter("opcion");
			switch (opcion) {
			case AÑADIR_CARRITO:
				synchronized (session) {
					insertarEnCarrito(carrito, producto);
				}
				break;
			case ELIMINAR_CARRITO:
				eliminarDeCarrito(carrito, producto);
				break;
			default:
				System.out.println("No existe la opción " + opcion);
			}
		}

		// Retornar la vista con parámetro "carrito"
		request.setAttribute("paresCarrito", carrito);
		getServletContext().getRequestDispatcher("/vista-carrito.jsp").forward(request, response);
	}

	private void eliminarDeCarrito(HashMap<String, Integer> carrito, String claveProducto) {
		if (carrito.get(claveProducto) != null) {
			carrito.remove(claveProducto);
		}
	}

	private void insertarEnCarrito(HashMap<String, Integer> carrito, String claveProducto) {
		if (carrito.get(claveProducto) == null) {
			carrito.put(claveProducto, new Integer(1));
		} else {
			int numeroArticulos = (Integer) carrito.get(claveProducto).intValue();
			carrito.put(claveProducto, new Integer(++numeroArticulos));
		}
	}

	private String carritoEnHTML(HashMap<String, Integer> carrito) {
		String carritoHtml = "";

		for (String key : carrito.keySet()) {
			carritoHtml += "<p>[" + key + "], " + carrito.get(key) + " unidades</p>";
		}

		return carritoHtml;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
