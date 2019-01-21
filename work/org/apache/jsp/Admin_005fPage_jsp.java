package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_005fPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"Login.css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\timg{\r\n");
      out.write("\t\twidth: 40px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 115px;\r\n");
      out.write("\t\ttop: 85px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#home{\r\n");
      out.write("\t\tcolor: cadetblue;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 170px;\r\n");
      out.write("\t\ttop: 92px;\r\n");
      out.write("\t\tfont-size: 25px;\r\n");
      out.write("\t\tfont-family: 'Franklin Gothic Medium';\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header1{\r\n");
      out.write("\tcolor: darkslateblue;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tleft: 420px;\r\n");
      out.write("\ttop: 100px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header2{\r\n");
      out.write("\t\tcolor: darkslateblue;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 520px;\r\n");
      out.write("\t\ttop: 100px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header3{\r\n");
      out.write("\t\tcolor: darkslateblue;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 620px;\r\n");
      out.write("\t\ttop: 100px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header4{\r\n");
      out.write("\t\tcolor: darkslateblue;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 720px;\r\n");
      out.write("\t\ttop: 100px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header5{\r\n");
      out.write("\t\tcolor: darkslateblue;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 820px;\r\n");
      out.write("\t\ttop: 100px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header6{\r\n");
      out.write("\t\tcolor: darkslateblue;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 880px;\r\n");
      out.write("\t\ttop: 100px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header7{\r\n");
      out.write("\t\tcolor: darkslateblue;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 1200px;\r\n");
      out.write("\t\ttop: 100px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header1:hover{\r\n");
      out.write("\t\tcolor: cadetblue;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header2:hover{\r\n");
      out.write("\t\tcolor: cadetblue;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header3:hover{\r\n");
      out.write("\t\tcolor: cadetblue;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header4:hover{\r\n");
      out.write("\t\tcolor: cadetblue;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header5:hover{\r\n");
      out.write("\t\tcolor: cadetblue;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header6:hover{\r\n");
      out.write("\t\tcolor: cadetblue;\r\n");
      out.write("\t}\r\n");
      out.write("\t#header7:hover{\r\n");
      out.write("\t\tcolor: cadetblue;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a5:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a6:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a7:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a8:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a9:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a10:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a11:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a12:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a13:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a14:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a15:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a16:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a17:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a18:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#a19:hover{\r\n");
      out.write("\t\tcolor: green;\r\n");
      out.write("\t}\r\n");
      out.write("\t#name1{\r\n");
      out.write("\t\tleft: 388px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#input1{\r\n");
      out.write("\t\ttop: 375px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#input5{\r\n");
      out.write("\t\tleft: 380px;\r\n");
      out.write("\t\ttop: 480px;\r\n");
      out.write("\t\twidth: 200px;\r\n");
      out.write("\t\theight: 40px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#name3{\r\n");
      out.write("\t\tleft: 940px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#input3{\r\n");
      out.write("\t\ttop: 375px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#input6{\r\n");
      out.write("\t\tleft: 940px;\r\n");
      out.write("\t\ttop: 480px;\r\n");
      out.write("\t\twidth: 200px;\r\n");
      out.write("\t\theight: 40px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<title>Apollo Hospital-Admin</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
      out.write("\r\n");
      out.write("\t<a id = \"home\" href = \"index.jsp\">Apollo Hospital</a>\r\n");
      out.write("\t<a href = \"index.jsp\"><img src = \"https://image3.mouthshut.com/images/imagesp/925860290s.jpg\" alt = \"Apollo Hospital\" /></a>\r\n");
      out.write("\t<a id = \"header1\" href = \"\">Products</a>\r\n");
      out.write("\t<a id = \"header2\" href = \"\">Customers</a>\r\n");
      out.write("\t<a id = \"header3\" href = \"\">Resources</a>\r\n");
      out.write("\t<a id = \"header4\" href = \"\">Research</a>\r\n");
      out.write("\t<a id = \"header5\" href = \"\">Blog</a>\r\n");
      out.write("\t<a id = \"header6\" href = \"\">About Us</a>\r\n");
      out.write("\t<form action = \"index.jsp\" method = \"post\">\r\n");
      out.write("\t\t<input id = \"Reg\" type = \"submit\" value = \"Sign Out\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<h2 id = \"doc\">Doctor</h2>\r\n");
      out.write("\t<h2 id = \"nur\">Nurse</h2>\r\n");
      out.write("\t<form action = \"Doc-det\" method = \"post\" onsubmit = \"return Validation();\">\r\n");
      out.write("\t<br><br><span id = \"name1\">Doctor's Name</span><br><br><input id = \"input1\" type = \"text\" name = \"Name-D\" required/>\r\n");
      out.write("\t<br><br><input id = \"input5\" type = \"submit\" value = \"View Details\" name = \"LogInD\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action = \"Nur-det\" method = \"post\" onsubmit = \"return Validation();\">\r\n");
      out.write("\t<br><br><span id = \"name3\">Nurse's Name</span><br><br><input id = \"input3\" type = \"text\" name = \"Name-N\" required/>\r\n");
      out.write("\t<br><br><input id = \"input6\" type = \"submit\" value = \"View Details\" name = \"LogInN\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<p id = \"a1\">\r\n");
      out.write("\t\t<br><br><a id = \"a5\" href = \"\">Questions? Contact Us.</a>\r\n");
      out.write("\t\t<br><br><a id = \"a6\" href = \"\">FAQ</a>\r\n");
      out.write("\t\t<br><br><a id = \"a7\" href = \"\">Investor Relations</a>\r\n");
      out.write("\t\t<br><br><a id = \"a8\" href = \"\">Privacy</a>\r\n");
      out.write("\t\t<br><br><a id = \"a9\" href = \"\">Our Team<br><br><br><br></a>\r\n");
      out.write("\t</p>\r\n");
      out.write("\t<p id = \"a2\">\r\n");
      out.write("\t\t<br><br><a id = \"a10\" href = \"\">Help Center</a>\r\n");
      out.write("\t\t<br><br><a id = \"a11\" href = \"\">Jobs</a>\r\n");
      out.write("\t\t<br><br><a id = \"a12\" href = \"\">Cookie Preference</a>\r\n");
      out.write("\t\t<br><br><a id = \"a13\" href = \"\">Legal Notices</a>\r\n");
      out.write("\t</p>\r\n");
      out.write("\t<p id = \"a3\">\r\n");
      out.write("\t\t<br><br><a id = \"a14\" href = \"\">Account</a>\r\n");
      out.write("\t\t<br><br><a id = \"a15\" href = \"\">Cart</a>\r\n");
      out.write("\t\t<br><br><a id = \"a16\" href = \"\">Corporation</a>\r\n");
      out.write("\t</p>\r\n");
      out.write("\t<span id = \"a4\">\r\n");
      out.write("\t\t<br><br><a id = \"a17\" href = \"\">Media</a>\r\n");
      out.write("\t\t<br><br><a id = \"a18\" href = \"\">Terms of Appointments</a>\r\n");
      out.write("\t\t<br><br><a id = \"a19\" href = \"\">Contact Us</a>\r\n");
      out.write("\t</span>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
