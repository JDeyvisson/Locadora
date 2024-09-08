package br.com.locadora.controller;
import br.com.locadora.dao.VeiculoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/remover-carro")
public class RemoverCarroServlet extends HttpServlet {

    private VeiculoDAO veiculoDAO;

    @Override
    public void init() throws ServletException {
        veiculoDAO = new VeiculoDAO();  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String placa = request.getParameter("placa");

        if (placa != null && !placa.isEmpty()) {
            
            veiculoDAO.remover(placa);
        }

        
        response.sendRedirect("menu");
    }
}
