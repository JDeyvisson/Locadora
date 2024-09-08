package br.com.locadora.controller;

import java.io.IOException;
import java.time.LocalDate;

import br.com.locadora.dao.ReservaDAO;
import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.dao.VeiculoDAO;
import br.com.locadora.model.Reserva;
import br.com.locadora.model.Usuario;
import br.com.locadora.model.Veiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/reservar-carro")
public class ReservarCarroServlet extends HttpServlet {

    private VeiculoDAO veiculoDAO;
    private UsuarioDAO usuarioDAO;
    private ReservaDAO reservaDAO;

    @Override
    public void init() throws ServletException {
        veiculoDAO = new VeiculoDAO(); 
        usuarioDAO = new UsuarioDAO(); 
        reservaDAO = new ReservaDAO(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long usuarioId = (Long) session.getAttribute("usuarioId");

        if (usuarioId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String placa = request.getParameter("placa");

        Veiculo veiculo = veiculoDAO.findByPlaca(placa);
        Usuario usuario = usuarioDAO.find(usuarioId);

        if (veiculo != null && usuario != null) {
            Reserva reserva = new Reserva();
            reserva.setVeiculo(veiculo);
            reserva.setUsuario(usuario);
            reserva.setDataInicio(LocalDate.now());
            reserva.setDataTermino(LocalDate.now().plusDays(7));

            reservaDAO.salvar(reserva);
        }

        response.sendRedirect("menu");
    }
}
