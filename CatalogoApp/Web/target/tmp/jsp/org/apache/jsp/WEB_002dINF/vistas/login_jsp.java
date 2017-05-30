package org.apache.jsp.WEB_002dINF.vistas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/vistas/includes/cabeceraUsuarios.jsp");
    _jspx_dependants.add("/WEB-INF/vistas/includes/pie.jsp");
  }

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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPe html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>USUARIOS ÁLVARO</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/estilos.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t<h2>USUARIOS</h2>\r\n");
      out.write("\t<p>LISTA DE USUARIOS</p>\r\n");
      out.write("\t<h5>");
      out.print( new java.util.Date() );
      out.write("</h5> \r\n");
      out.write("\t</header>\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"UsuarioCRUD?op=alta\">ALTA</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"UsuarioCRUD\">LISTA DE USUARIOS</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"login?opcion=logout\">SALIR</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h2>LOGIN USUARIO</h2>\r\n");
      out.write("\r\n");
      out.write("\t");
      com.ipartek.formacion.Tipos.Usuario usuario = null;
      synchronized (request) {
        usuario = (com.ipartek.formacion.Tipos.Usuario) _jspx_page_context.getAttribute("usuario", PageContext.REQUEST_SCOPE);
        if (usuario == null){
          usuario = new com.ipartek.formacion.Tipos.Usuario();
          _jspx_page_context.setAttribute("usuario", usuario, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"login\" method=\"get\">\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t\t<label for=\"nombre\">USUARIO :</label> <input id=\"nombre\" name=\"nombre\" \r\n");
      out.write("\t\t\trequired = \"required\" minlength=\"6\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t\t<label for=\"pass\">CONTRASEÑA :</label> <input type=\"password\" id=\"pass\"\r\n");
      out.write("\t\t\t\tname=\"pass\" />\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"LOGIN\" />\r\n");
      out.write("\t\t\t<p class=\"errores\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.errores }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t<p>\r\n");
      out.write("\t<h5>");
      out.print( new java.util.Date() );
      out.write("</h5>\r\n");
      out.write("\t<h4>&COPY;2017 ÁLVARO MARTÍNEZ ALBALÁ</h4></p>\r\n");
      out.write("\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
