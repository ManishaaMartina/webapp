/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-27 04:24:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<head>\r\n");
      out.write("<link href=\"bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write(" <style>\r\n");
      out.write(" body, html{\r\n");
      out.write("     height: 100%;\r\n");
      out.write(" \tbackground-repeat: no-repeat;\r\n");
      out.write(" \tbackground:url(https://wallpaperscraft.com/image/razer_adaro_headphones_stereo_headphones_glare_99445_1920x1080.jpg);\r\n");
      out.write(" \tfont-family: 'Oxygen', sans-serif;\r\n");
      out.write("\t background-size: cover;\r\n");
      out.write("}\r\n");
      out.write("h1{\r\n");
      out.write(" color: purple;\r\n");
      out.write(" }\r\n");
      out.write("h2{\r\n");
      out.write(" color: black;\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<div class=\"well\">\r\n");
      out.write("<h1>LOGIN PAGE</h1>\r\n");
      out.write("<form method=\"post\" action=\"Login\">\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("<div class=\"col-xm-5\">\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<label for=\"Name\" class=\"cols-sm-2 control-label\">Name</label>\r\n");
      out.write("<div class=\"cols-sm-5\">\r\n");
      out.write("<input type=\"text\" class=\"form-horizontal\" name=\"username\" id=\"username\"  placeholder=\"Enter your Name\"/>\r\n");
      out.write("</div>\r\n");
      out.write("</div>  \r\n");
      out.write("\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<label for=\"Password\" class=\"cols-sm-2 control-label\">Password</label>\r\n");
      out.write("<div class=\"cols-sm-5\">\r\n");
      out.write("<input type=\"password\" class=\"form-horizontal\" name=\"pass\" id=\"pass\"  placeholder=\"Enter your Password\"/>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<div class=\"cols-sm-5\">\r\n");
      out.write("<input type=\"submit\" class=\" form-horizontal btn-primary active glyphicon glyphicon-ok\" value=\"Login\"/>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"well\">\r\n");
      out.write("<h2>APJ Abdul Kalam :</h2></br>\r\n");
      out.write("<quote class=\"center\" >\" Never stop fighting until you arrive at your destined place - that is, the unique you. Have an aim in life, continuously acquire knowledge, work hard, and have perseverance to realise the great life. \"</quote>\r\n");
      out.write("</center>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
