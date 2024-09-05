package br.com.locadora.controller;

import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class CadastroServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        usuarioDAO = new UsuarioDAO(); // Inicialize o DAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo os parâmetros do formulário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");

        // Criando um novo usuário
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setEnderecoCep(cep);
        usuario.setEnderecoRua(rua);
        usuario.setEnderecoBairro(bairro);
        usuario.setEnderecoCidade(cidade);
        usuario.setEnderecoEstado(estado);

        // Salvando o usuário no banco de dados
        usuarioDAO.save(usuario);

        // Redirecionando para a página de login
        response.sendRedirect("login.jsp");
    }
}
