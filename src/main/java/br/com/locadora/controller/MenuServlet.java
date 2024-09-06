package br.com.locadora.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


import br.com.locadora.dao.VeiculoDAO;
import br.com.locadora.model.Veiculo;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        List<Veiculo> listaVeiculo = veiculoDAO.findAll();

        request.setAttribute("carros", listaVeiculo);
        RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
        rd.forward(request, response);
        
    }


}
