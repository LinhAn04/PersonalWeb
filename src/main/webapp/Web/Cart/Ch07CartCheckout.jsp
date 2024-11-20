<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout Invoice</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/Cart/Ch07Cart.css" type="text/css">
</head>
<body>
<div class="invoice-container">
    <h1>Thank You for Your Purchase!</h1>
    <p class="invoice-header">Invoice</p>

    <table class="invoice-table">
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <%
            Cart.Cart cart = (Cart.Cart) session.getAttribute("cart");
            double grandTotal = 0;
            if (cart != null) {
                for (Cart.LineItem item : cart.getItems()) {
                    String description = item.getProduct().getDescription();
                    double price = item.getProduct().getPrice();
                    int quantity = item.getQuantity();
                    double total = item.getTotal();
                    grandTotal += total;
        %>
        <tr>
            <td><%= description %></td>
            <td><%= String.format("$%.2f", price) %></td>
            <td><%= quantity %></td>
            <td><%= String.format("$%.2f", total) %></td>
        </tr>
        <%
                }
            }
        %>
        <tr class="grand-total-row">
            <td colspan="3" style="text-align: right;"><strong>Grand Total:</strong></td>
            <td><strong><%= String.format("$%.2f", grandTotal) %></strong></td>
        </tr>
    </table>

    <div class="checkout-message">
        <p>Your items will be shipped to your provided address shortly. A confirmation email has been sent to your inbox.</p>
        <input class="btnHome" type="button" value="Return Home" id="home" onclick="returnHome()"><br>
    </div>
    <script>
        function returnHome() {
            // Chuyển hướng về trang chủ mà không kiểm tra form
            window.location.href = 'returnHome';
        }
    </script>
</div>
</body>
</html>
