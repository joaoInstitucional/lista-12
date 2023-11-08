import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListarPratosServlet")
public class ListarPratosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Prato> pratos = new ArrayList<>();
        
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "");
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prato");
            
            while (rs.next()) {
                Prato prato = new Prato();
                prato.setId(rs.getInt("id"));
                prato.setNome(rs.getString("nome"));
                prato.setTipo(rs.getString("tipo"));
                prato.setIngredientes(rs.getString("ingredientes"));
                pratos.add(prato);
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("pratos", pratos);
        request.getRequestDispatcher("listarPratos.jsp").forward(request, response);
    }
}
