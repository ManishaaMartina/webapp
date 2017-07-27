**Employee Details**
----------
*Process*
  * Login validation
   * Employee Details
   * Email to Employee
    * Update the details
----------
*Login validation* 
----------

    
          The login form validates the username and password 
    which is present in the database using the filter.If the 
    Error occurs means it intimate to the user.

          index->LoginFilter->Login.

----------
*1.Index.jsp*

```<html>
<head>
<link href="bootstrap.min.css" rel="stylesheet">
 <style>
 body, html{
     height: 100%;
 	background-repeat: no-repeat;
 	background:url(https://i.ytimg.com/vi/4kfXjatgeEU/maxresdefault.jpg);
 	font-family: 'Oxygen', sans-serif;
	 background-size: cover;
}
</style>
</head>
<body>
<div class="container">
<div class="well">
<h1>Login Page</h1>
<form method="post" action="Login">
<div class="row">
<div class="col-xm-6">
<div class="form-group">
<label for="Name" class="cols-sm-2 control-label">Name</label>
<div class="cols-sm-5">
<input type="text" class="form-horizontal" name="username" id="username"  placeholder="Enter your Name"/>
</div>
</div>  

<div class="form-group">
<label for="Password" class="cols-sm-2 control-label">Password</label>
<div class="cols-sm-5">
<input type="password" class="form-horizontal" name="pass" id="pass"  placeholder="Enter your Password"/>
</div>
</div>
<div class="form-group">
<div class="cols-sm-5">
<input type="submit" class=" form-horizontal btn-primary active glyphicon glyphicon-ok" value="Login"/>
</div>
</div>
</div>
</div>
<div class="well">
<h>APJ ABDUL KALAM :</h></br>
<quote class="center" color="#0000">" Never stop fighting until you arrive at your destined place - that is, the unique you. Have an aim in life, continuously acquire knowledge, work hard, and have perseverance to realise the great life. "</quote>
</div>
</form>
</div>
</body>
</html>

```
*2.LoginFilter* 


```import java.io.*;
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
            out.println("You have enter a wrong password");
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.include(request, response);
        }
    }
   public void destroy() { }
}

```
*3.Login*

```import java.io.*;
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

```
*Employee Details*
----------


          The details of the employee will added after the Login which state will be in successfull
    after the getting of details it will store into the database,At the same time the mail will sent 
    to the employee. 

    empreg->email,save into the database->view the details
----------


 *1.Empreg*

```
<html>
<link href="bootstrap.min.css" rel="stylesheet">
 <style>
 body, html{
     height: 100%;
 	background-repeat: no-repeat;
 	background:url(https://i.ytimg.com/vi/4kfXjatgeEU/maxresdefault.jpg);
 	font-family: 'Oxygen', sans-serif;
	 background-size: cover;
}
</style>
</head>  
<body>  
<div class="container">
<h1 class="title">Employee Details</h1>  
<form action="SaveServlet" method="post">  
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Your Name</label>
<div class="cols-sm-7">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Name"/>
</div>
</div>
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Your Password</label>
<div class="cols-sm-7">
<span class="input-group-addon"><i class="fa  fa-lock fa-lg" aria-hidden="true"></i></span>
<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your password"/>
</div>
</div>
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Your email</label>
<div class="cols-sm-7">
<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
<input type="email" class="form-control" name="email" id="email"  placeholder="Enter your password"/>
</div>
</div>
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">country</label>
<span class="input-group-addon"><i class="fa fa-user fa"></i></span>
<select name="country" style="width:150px">  
<option>India</option>  
<option>USA</option>  
<option>UK</option>  
<option>Other</option>  
</select>
</div>
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">click to save:</label>
<div class="cols-sm-7">
<input type="submit" class="btn-primary" value="Save Employee"/></td></tr>  
</div>
</div> 
</form>  
<div class="form-group">
<a href="ViewServlet">view employees</a>  
</div>
</div>
</body>  
</html>
```
*2.Emp->pojo class*

```public class Emp {  
private int id;  
private String name,password,email,country;  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public String getPassword() {  
    return password;  
}  
public void setPassword(String password) {  
    this.password = password;  
}  
public String getEmail() {  
    return email;  
}  
public void setEmail(String email) {  
    this.email = email;  
}  
public String getCountry() {  
    return country;  
}  
public void setCountry(String country) {  
    this.country = country;  
}  
  
}  

```


*3.Email*

```import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Email")
public class Email extends HttpServlet {

   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String to ="manisha.m@kggroup.com";
      final String from = "krishna.d@kggroup.com";
      final String pass="Krishna31";
      String host = "webmail.kggroup.com";
      Properties props = System.getProperties();
      props.put("mail.smtp.host",host);
      props.put("mail.smtp.auth", "true");    
Session session = Session.getDefaultInstance(props,  
 new javax.mail.Authenticator() {  
  protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication(from,pass);  
   }  
});
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         message.setSubject("Welcome to registration");
         message.setText("Hello");
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText("This is message body");
         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);
         messageBodyPart = new MimeBodyPart();
         String filename = "D:\\Emp.txt";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);
         message.setContent(multipart );
         Transport.send(message);
         String title = "Send Email";
         String res = "Sent message successfully....";
         String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         out.println(docType +
            "<html>\n" +
               "<head><title>" + title + "</title></head>\n" +
               "<body bgcolor = \"#f0f0f0\">\n" +
                  "<h1 align = \"center\">" + title + "</h1>\n"+
                  "<p align = \"center\">" + res + "</p>\n" +"</body></html>");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
} 

```
*4.EmpDao*

```import java.util.*;  
import java.sql.*;  
  
public class EmpDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into user905(name,password,email,country) values (?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user905 set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(String sid){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from user905 where email=?");  
            ps.setString(1,sid);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user905");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  


```
*5.SaveServlet*
   ```
   import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Emp e=new Emp();  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("empreg.html").include(request, response);  
             request.getRequestDispatcher("Email").include(request, response); 
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
} 

   ```
   *6.ViewServlet*
   ```
   import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='empreg.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?email="+e.getEmail()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  


   ```
    *Edit and update*
 ----------
        The Employee details can be edit and update using the servlet known as
        EditSevlet and EditServlet1.The updated record will be store into the 
        database.
    
        
 *1.EditServlet*
```import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>Country:</td><td>");  
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  


```

*2.EditServlet2*

```import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Emp e=new Emp();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  

```
*Delete the record*
----------




    
      The record details is to be deleted using the email-id of the employee.because,the email-id will be unique.
----------

```import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String sid=request.getParameter("email");  
        //int id=Integer.parseInt(sid);  
        EmpDao.delete(sid);  
        response.sendRedirect("ViewServlet");  
    }  
}  


```