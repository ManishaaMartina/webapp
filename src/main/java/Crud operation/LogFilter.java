import java.io.*;
import java.util.*;  
import java.sql.*;  
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter.*;
import javax.servlet.annotation.WebFilter;
@WebFilter(filterName="LogFilter", urlPatterns="/Login")
 public class LogFilter implements Filter {
   
    public void init(FilterConfig fc) throws ServletException {}
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
                response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("username");
        String pass = request.getParameter("pass");
        String dbname=null,dbpass=null;
        try
        {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
         PreparedStatement ps =con.prepareStatement("select * from login where username=? and password=?");
         ps.setString(1,user);
         ps.setString(2,pass);
         ResultSet rs =ps.executeQuery();
         if (rs.next()) {
              dbname=rs.getString(1);  
              dbpass=rs.getString(2);  
            }   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(dbname);
        System.out.println(dbpass);
        System.out.println(user);
        System.out.println(pass);
        if(user.equals(dbname) && pass.equals(dbpass))
        {
         chain.doFilter(request, response);   
        }
        else
        {
            //out.println("You have enter a wrong password");
            out.println("<div class="popup" onclick="myFunction()">Click me!
  <span class="popuptext" id="myPopup">You have entered wrong password or username</span>
</div>")
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.include(request, response);
        }
    }
   public void destroy() { }
}