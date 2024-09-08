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
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario usuario = usuarioDAO.findByEmail(email);

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            if (usuario != null && usuario.getSenha().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("usuarioId", usuario.getId()); 
                response.sendRedirect("menu");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Falhou</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('Email ou senha incorretos.');");
                out.println("window.location.href = 'login.jsp';");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
