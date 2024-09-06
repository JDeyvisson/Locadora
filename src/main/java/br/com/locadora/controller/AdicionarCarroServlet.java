package br.com.locadora.controller;

import br.com.locadora.model.Veiculo;
import br.com.locadora.dao.VeiculoDAO;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/adicionar")
public class AdicionarCarroServlet extends HttpServlet {

    private VeiculoDAO veiculoDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        veiculoDAO = new VeiculoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String placa = request.getParameter("placa");
        String anoStr = request.getParameter("ano");
        String cor = request.getParameter("cor");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        Integer ano = Integer.parseInt(anoStr);
        Veiculo veiculo = new Veiculo();

        veiculo.setPlaca(placa);
        veiculo.setAno(ano);
        veiculo.setCor(cor);
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        

        veiculoDAO.save(veiculo);
        
        response.sendRedirect("menu");
    }
}
