package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EnterOtp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <title>Document</title>\r\n");
      out.write("        <link\r\n");
      out.write("            rel=\"stylesheet\"\r\n");
      out.write("            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\"\r\n");
      out.write("            integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\"\r\n");
      out.write("            crossorigin=\"anonymous\"\r\n");
      out.write("            /> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/main.css\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write(" \r\n");
      out.write("\r\n");
      out.write("        <div  > \r\n");
      out.write("            <section class=\"vh-100 bg-image\">\r\n");
      out.write("                <div class=\"mask d-flex align-items-center h-100 gradient-custom-3\">\r\n");
      out.write("                    <div class=\"container h-100\">\r\n");
      out.write("                        <div class=\"row d-flex justify-content-center align-items-center h-100\">\r\n");
      out.write("                            <div class=\"col-12 col-md-9 col-lg-7 col-xl-6\">\r\n");
      out.write("                                <div class=\"card\" style=\"border-radius: 15px;\">\r\n");
      out.write("                                    <div class=\"card-body p-5\">\r\n");
      out.write("                                        <div class=\"text-center\">\r\n");
      out.write("                                            <h3>\r\n");
      out.write("                                                <i class=\"fa fa-lock fa-4x\"></i>\r\n");
      out.write("                                            </h3>\r\n");
      out.write("                                            <h2 class=\"text-center\">Enter OTP</h2>\r\n");
      out.write("                                            <p class=\"text-danger ml-1\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" add </p>\r\n");
      out.write("                                            <div class=\"panel-body\">\r\n");
      out.write("                                                <form id=\"register-form\" action=\"ValidateOtp\" role=\"form\" autocomplete=\"off\"\r\n");
      out.write("                                                      class=\"form\" method=\"post\">\r\n");
      out.write("                                                    <div class=\"form-group\">\r\n");
      out.write("                                                        <div class=\"input-group\">\r\n");
      out.write("                                                            <span class=\"input-group-addon\"><i\r\n");
      out.write("                                                                    class=\"glyphicon glyphicon-envelope color-blue\"></i></span> \r\n");
      out.write("                                                            <input \r\n");
      out.write("                                                                style=\"margin: 25px 0; border-radius: 5px\"\r\n");
      out.write("                                                                id=\"opt\" name=\"otp\" placeholder=\"Enter OTP\"\r\n");
      out.write("                                                                class=\"form-control\" type=\"text\" required=\"required\">\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <div class=\"form-group\">\r\n");
      out.write("                                                        <input name=\"recover-submit\"\r\n");
      out.write("                                                               class=\"btn btn-lg btn-primary  \"\r\n");
      out.write("                                                               value=\"Reset Password\" type=\"submit\">\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <input type=\"hidden\" class=\"hide\" name=\"token\" id=\"token\" value=\"\">\r\n");
      out.write("                                                </form>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section></div>\r\n");
      out.write("        <script\r\n");
      out.write("            src=\"https://kit.fontawesome.com/3a6c73e27c.js\"\r\n");
      out.write("            crossorigin=\"anonymous\"\r\n");
      out.write("        ></script>\r\n");
      out.write("        <script\r\n");
      out.write("            src=\"./js/main.js\"\r\n");
      out.write("        ></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
