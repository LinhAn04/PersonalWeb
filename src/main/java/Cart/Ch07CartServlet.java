package Cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
                System.out.println("Mã sản phẩm không hợp lệ!");
                // Quay lại trang giỏ hàng
                url = "/Web/Cart/Ch07CartView.jsp";
            } else {
                System.out.println(productCode);
                System.out.println(quantityString);

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
                        cart.addItem(lineItem);
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
        else if (action.equals("checkout")) {
            url = "/Web/Cart/Ch07CartCheckout.jsp";
        }
        else if (action.equals("shop")) {
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
