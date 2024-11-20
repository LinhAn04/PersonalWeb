/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.26
 * Generated at: 2024-11-20 23:34:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Web.Cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class Ch07CartCheckout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Checkout Invoice</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Web/Cart/Ch07Cart.css\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"invoice-container\">\r\n");
      out.write("    <h1>Thank You for Your Purchase!</h1>\r\n");
      out.write("    <p class=\"invoice-header\">Invoice</p>\r\n");
      out.write("\r\n");
      out.write("    <table class=\"invoice-table\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>Description</th>\r\n");
      out.write("            <th>Price</th>\r\n");
      out.write("            <th>Quantity</th>\r\n");
      out.write("            <th>Total</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

            Cart.Cart cart = (Cart.Cart) session.getAttribute("cart");
            double grandTotal = 0;
            if (cart != null) {
                for (Cart.LineItem item : cart.getItems()) {
                    String description = item.getProduct().getDescription();
                    double price = item.getProduct().getPrice();
                    int quantity = item.getQuantity();
                    double total = item.getTotal();
                    grandTotal += total;
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.print( description );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( String.format("$%.2f", price) );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( quantity );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( String.format("$%.2f", total) );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

                }
            }
        
      out.write("\r\n");
      out.write("        <tr class=\"grand-total-row\">\r\n");
      out.write("            <td colspan=\"3\" style=\"text-align: right;\"><strong>Grand Total:</strong></td>\r\n");
      out.write("            <td><strong>");
      out.print( String.format("$%.2f", grandTotal) );
      out.write("</strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"checkout-message\">\r\n");
      out.write("        <p>Your items will be shipped to your provided address shortly. A confirmation email has been sent to your inbox.</p>\r\n");
      out.write("        <input class=\"btnHome\" type=\"button\" value=\"Return Home\" id=\"home\" onclick=\"returnHome()\"><br>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script>\r\n");
      out.write("        function returnHome() {\r\n");
      out.write("            // Chuyển hướng về trang chủ mà không kiểm tra form\r\n");
      out.write("            window.location.href = 'returnHome';\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
