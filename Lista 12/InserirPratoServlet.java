package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Autenticador;
import model.Banco;
import model.Usuario;

@WebServlet("/InserirPratoServlet")
public class InserirPratoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 		
			throws ServletException, IOException {
				Usuario user = new Usuario();		
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");		
				user.setLogin(login);
				user.setSenha(senha);
				if(autenticar(user)){
					request.getSession().setAttribute("user", user);
					response.sendRedirect("home.jsp");
				}else{
					request.setAttribute("erro", "Usuário ou Senha Inválidos!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
			}
	

        response.sendRedirect("index.jsp"); // Redirecionar para a página inicial após a inserção.
    }

