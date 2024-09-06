package br.com.locadora.controller;

import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera os parâmetros do formulário de login
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Verifica se o usuário existe e a senha está correta
        Usuario usuario = usuarioDAO.findByEmail(email);

        if (usuario != null && usuario.getSenha().equals(password)) {
            // Cria uma nova sessão para o usuário
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // Redireciona para a página inicial após login bem-sucedido
            response.sendRedirect("sucesso.jsp");
        } else {
            // Se o login falhar, redireciona de volta para a página de login com uma mensagem de erro
            request.setAttribute("errorMessage", "Email ou senha incorretos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

