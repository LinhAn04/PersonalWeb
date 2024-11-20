package Cart;

import JavaMail.MailUtilLocal;
import jakarta.mail.MessagingException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Ch07CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String url = "/Web/Cart/Ch07CartView.jsp";

        ServletContext sc = getServletContext();

        String action = req.getParameter("action");
        if (action == null) {
            action = "addCart";
        }
        if (action.equals("shop")) {
            url = "/Web/Cart/Ch07CartView.jsp";
        }
        if(action.equals("addCart")) {
            String productCode = req.getParameter("productCode");
            String quantityString = req.getParameter("quantity");

            // Kiểm tra nếu productCode là null hoặc rỗng
            if (productCode == null || productCode.trim().isEmpty()) {
                // Xử lý khi productCode không hợp lệ (có thể thông báo lỗi)

                // Catch exception vứt ra giao diện đi nha
                System.out.println("Mã sản phẩm không hợp lệ!");
                // Quay lại trang giỏ hàng
                url = "/Web/Cart/Ch07CartView.jsp";
            } else {
                HttpSession session = req.getSession();
                Cart cart;
                final Object lock = req.getSession().getId().intern();
                synchronized (lock) {
                    cart = (Cart) session.getAttribute("cart");
                }
                if(cart == null) {
                    cart = new Cart();
                }

                int quantity;
                try{
                    quantity = Integer.parseInt(quantityString);
                    if(quantity < 0) {
                        quantity = 1;
                    }
                }
                catch (NumberFormatException nfe) {
                    quantity = 1;
                }

                // Lấy đường dẫn đến file products.txt
                String path = sc.getRealPath("/Web/Cart/products.txt");

                // Gọi phương thức getProduct để lấy thông tin sản phẩm
                Product product = ProductIO.getProduct(productCode, path);

                // Kiểm tra nếu sản phẩm không tồn tại
                if (product == null) {
                    System.out.println("Sản phẩm không tồn tại!");
                    // Xử lý khi sản phẩm không tìm thấy, ví dụ như thông báo lỗi
                    url = "/Web/Cart/Ch07CartView.jsp";
                } else {
                    // Thêm sản phẩm vào giỏ hàng
                    LineItem lineItem = new LineItem();
                    lineItem.setProduct(product);
                    lineItem.setQuantity(quantity);
                    if(quantity > 0){
                        cart.addItem(lineItem, false);
                    } else if (quantity == 0) {
                        cart.removeItem(lineItem);
                    }

                    synchronized (lock) {
                        session.setAttribute("cart", cart);
                    }
                    url = "/Web/Cart/Ch07CartInfor.jsp";
                }
            }
        }
        if (action.equals("updateCart")) {
            String productCode = req.getParameter("productCode");
            String quantityString = req.getParameter("quantity");

            HttpSession session = req.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1; // Đặt mặc định nếu số lượng không hợp lệ
                }
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }

            String path = sc.getRealPath("/Web/Cart/products.txt");
            Product product = ProductIO.getProduct(productCode, path);

            if (product != null) {
                LineItem lineItem = new LineItem();
                lineItem.setProduct(product);
                lineItem.setQuantity(quantity);

                // Gọi addItem với isUpdate = true để ghi đè số lượng
                cart.addItem(lineItem, true);
            }

            session.setAttribute("cart", cart);
            url = "/Web/Cart/Ch07CartInfor.jsp";
        }
        if (action.equals("checkout")) {
            // Lấy email từ request
            String to = req.getParameter("email");

            // Kiểm tra email hợp lệ
            if (to == null || to.trim().isEmpty()) {
                req.setAttribute("errorMessage", "Email address is required for checkout.");
                url = "/Web/Cart/Ch07CartView.jsp"; // Quay lại trang giỏ hàng
            } else {
                // Lấy giỏ hàng từ session
                HttpSession session = req.getSession();
                Cart cart = (Cart) session.getAttribute("cart");

                if (cart != null && cart.getItems().size() > 0) {
                    // Cấu hình thông tin email
                    String from = "lehoanglinhan@murach.com";
                    String subject = "Checkout Confirmation";

                    // Tạo nội dung email bằng HTML
                    StringBuilder body = new StringBuilder();
                    body.append("<!DOCTYPE html>")
                            .append("<html>")
                            .append("<head>")
                            .append("<style>")
                            .append("body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }")
                            .append(".email-container { width: 100%; max-width: 600px; margin: 0 auto; border: 1px solid #ddd; padding: 20px; background-color: #f9f9f9; }")
                            .append(".header { background-color: #4CAF50; color: white; text-align: center; padding: 10px 0; }")
                            .append(".footer { text-align: center; margin-top: 20px; font-size: 0.9em; color: #777; }")
                            .append(".table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                            .append(".table th, .table td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                            .append(".table th { background-color: #4CAF50; color: white; }")
                            .append("</style>")
                            .append("</head>")
                            .append("<body>")
                            .append("<div class='email-container'>")
                            .append("<div class='header'>")
                            .append("<h1>Thank You for Shopping with us!</h1>")
                            .append("</div>")
                            .append("<p>Dear Customer,</p>")
                            .append("<p>Thank you for your order. Here is the summary of your purchase:</p>")
                            .append("<table class='table'>")
                            .append("<tr>")
                            .append("<th>Product</th>")
                            .append("<th>Quantity</th>")
                            .append("<th>Price</th>")
                            .append("</tr>");

                    for (LineItem item : cart.getItems()) {
                        Product product = item.getProduct();
                        body.append("<tr>")
                                .append("<td>").append(product.getDescription()).append("</td>")
                                .append("<td>").append(item.getQuantity()).append("</td>")
                                .append("<td>").append(product.getPriceCurrencyFormat()).append("</td>")
                                .append("</tr>");
                    }

                    body.append("</table>")
                            .append("<p><strong>Total: ").append(cart.getItems().stream()
                                    .mapToDouble(LineItem::getTotal).sum()).append("</strong></p>")
                            .append("<p>We hope to serve you again soon!</p>")
                            .append("<p>Best regards,<br>Murach Shop Team</p>")
                            .append("<div class='footer'>")
                            .append("<p>&copy; 2024 Murach Shop. All rights reserved.</p>")
                            .append("</div>")
                            .append("</div>")
                            .append("</body>")
                            .append("</html>");

                    boolean isBodyHTML = true;

                    try {
                        MailUtilLocal.sendMail(to, from, subject, body.toString(), isBodyHTML);
                        req.setAttribute("message", "Checkout successful! A confirmation email has been sent.");
                    } catch (MessagingException e) {
                        e.printStackTrace();
                        req.setAttribute("errorMessage", "Unable to send confirmation email.");
                    }
                } else {
                    req.setAttribute("errorMessage", "Your cart is empty.");
                }

                url = "/Web/Cart/Ch07CartCheckout.jsp";
            }
        } else if (action.equals("shop")) {
            url = "/Web/Cart/Ch07CartView.jsp";
        }

        System.out.println(action);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
