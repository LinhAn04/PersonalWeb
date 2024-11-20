<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial scale=1.0">
    <title>Cart Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/Cart/Ch07Cart.css" type="text/css">
</head>
<body>
<h1>Your cart</h1>
<table>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
        <th></th>
    </tr>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>
                <form action="cart-exercise" method="post">
                    <input type="hidden" name="productCode"
                           value="<c:out value='${item.product.code}'/>">
                    <input type="text" name="quantity"
                           value="<c:out value='${item.quantity}'/>" id="quantity">
                    <input type="hidden" name="action" value="updateCart">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <c:out value='${item.product.description}'/>
            </td>
            <td>
                    ${item.product.price} $
            </td>
            <td>
                    ${item.total} $
            </td>
            <td>
                <form action="" method="post">
                    <input type="hidden" name="productCode"
                           value="<c:out value='${item.product.code}'/>">
                    <input type="hidden" name="quantity" value="0">
                    <input type="submit" value="Remove Item">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
<form action="" method="post">
    <input type="hidden" name="action" value="shop">
    <input type="submit" value="Continue Shopping">
</form>

<form action="" method="post">
    <input type="hidden" name="action" value="checkout">
    <input type="submit" value="Check out">
</form>
</body>
</html>
