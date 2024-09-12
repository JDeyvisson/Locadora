package br.com.locadora.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import br.com.locadora.dao.ReservaDAO;
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
    private ReservaDAO reservaDAO;

    @Override
    public void init() throws ServletException {
        veiculoDAO = new VeiculoDAO();
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

        String placa = request.getParameter("placa");
        Veiculo veiculo = veiculoDAO.findByPlaca(placa);

        if (veiculo != null) {
            LocalDate dataInicio = LocalDate.now();
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("dataInicio", dataInicio);
            request.getRequestDispatcher("reservar.jsp").forward(request, response);
        } else {
            response.sendRedirect("menu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String placa = request.getParameter("placa");
        String dataInicioStr = request.getParameter("dataInicio");
        String dataTerminoStr = request.getParameter("dataTermino");

        Veiculo veiculo = veiculoDAO.findByPlaca(placa);

        if (veiculo != null && dataTerminoStr != null) {
            try {
                LocalDate dataInicio = LocalDate.parse(dataInicioStr);
                LocalDate dataTermino = LocalDate.parse(dataTerminoStr);
                LocalDate dataAtual = LocalDate.now();


                
                if (dataInicio.isBefore(dataAtual)) {
                   
                    response.sendRedirect("reservar-carro?placa=" + placa + "&erro=dataInicioInvalida");
                    return;
                }

                if (dataTermino.isBefore(dataInicio)) {
                 
                    response.sendRedirect("reservar-carro?placa=" + placa + "&erro=dataTerminoInvalida");
                    return;
                }

                
                if (!veiculo.isReservado()) {
                    Reserva reserva = new Reserva();
                    reserva.setVeiculo(veiculo);
                    reserva.setUsuario(usuario);
                    reserva.setDataInicio(dataInicio);
                    reserva.setDataTermino(dataTermino);

                    veiculo.setReservado(true);
                    veiculoDAO.update(veiculo); 
                    reservaDAO.salvar(reserva); 

                    response.sendRedirect("menu");
                } else {
                    response.sendRedirect("reservar-carro?placa=" + placa + "&erro=reservado");
                }
            } catch (DateTimeParseException e) {
                
                response.sendRedirect("reservar-carro?placa=" + placa + "&erro=invalidDate");
            }
        } else {
            response.sendRedirect("reservar-carro?placa=" + placa + "&erro=invalid");
        }
    }
}
