package br.com.locadora.controller;

import java.io.IOException;
import java.util.List;

import br.com.locadora.dao.ReservaDAO;
import br.com.locadora.model.Reserva;
import br.com.locadora.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/exibirReservas")
public class ReservasUsuarioServlet extends HttpServlet {

    private ReservaDAO reservaDAO;

    @Override
    public void init() throws ServletException {
        reservaDAO = new ReservaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Reserva> reservas = reservaDAO.buscarReservasPorUsuario(usuario.getId());

        request.setAttribute("reservas", reservas);

        request.getRequestDispatcher("reservas-usuario.jsp").forward(request, response);
    }
}
