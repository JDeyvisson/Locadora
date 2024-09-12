package br.com.locadora.controller;

import java.io.IOException;

import br.com.locadora.dao.ReservaDAO;
import br.com.locadora.dao.VeiculoDAO;
import br.com.locadora.model.Reserva;
import br.com.locadora.model.Veiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancelar-reserva")
public class CancelarReservaServlet extends HttpServlet {

    private ReservaDAO reservaDAO;
    private VeiculoDAO veiculoDAO;

    @Override
    public void init() throws ServletException {
        reservaDAO = new ReservaDAO();
        veiculoDAO = new VeiculoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String reservaIdParam = request.getParameter("reservaId");

        if (reservaIdParam != null && !reservaIdParam.isEmpty()) {
            try {
               
                long reservaId = Integer.parseInt(reservaIdParam);

               
                Reserva reserva = reservaDAO.buscarPorId(reservaId);

                if (reserva != null) {
                    
                    Veiculo veiculo = reserva.getVeiculo();
                    if (veiculo != null) {
                        veiculo.setReservado(false);
                        veiculoDAO.update(veiculo);
                    }

                    reservaDAO.remover(reservaId);

                    response.sendRedirect("exibirReservas");
                } else {
                  
                    response.sendRedirect("erro.jsp");
                }
            } catch (NumberFormatException e) {
     
                response.sendRedirect("erro.jsp");
            }
        } else {
          
            response.sendRedirect("erro.jsp");
        }
    }
}
