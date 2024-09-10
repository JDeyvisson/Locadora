package br.com.locadora.controller;

import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.model.Usuario;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        usuarioDAO = new UsuarioDAO(); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
    
        
        Usuario usuarioExistente = usuarioDAO.findByEmail(email);
    
        if (usuarioExistente != null) {
           
            request.setAttribute("mensagemErro", "Este e-mail já está cadastrado. Por favor, use outro.");
            RequestDispatcher rd = request.getRequestDispatcher("/cadastro-usuario.jsp");
            rd.forward(request, response);
        } else {
    
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setTelefone(telefone);
            usuario.setEnderecoCep(cep);
            usuario.setEnderecoRua(rua);
            usuario.setEnderecoBairro(bairro);
            usuario.setEnderecoCidade(cidade);
            usuario.setEnderecoEstado(estado);
    
            usuarioDAO.save(usuario);
    
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }
    
}
