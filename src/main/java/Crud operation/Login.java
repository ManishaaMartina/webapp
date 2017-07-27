import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebServlet;
@WebServlet(name="Login", urlPatterns="/Login")

 public class Login extends HttpServlet {

 public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
     {
        response.setContentType("text/html");
       // PrintWriter out = response.getWriter();
        //String user = request.getParameter("user");
        //out.println("Wellcome "+user);
        RequestDispatcher rs = request.getRequestDispatcher("empreg.html");
        rs.forward(request, response);
     }
}