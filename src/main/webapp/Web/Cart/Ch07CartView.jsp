<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="include/header.jsp"%>
<body>
  <h1>CD List</h1>
  <table>
    <tr>
      <th>Description</th>
      <th>Price</th>
      <th> </th>
    </tr>
    <tr>
      <td>86 (the band) - True Life Songs and Pictures</td>
      <td>$14.95</td>
      <form action="cart-exercise" method="post">
        <input type="hidden" name="action" value="addCart">
        <input type="hidden" name="productCode" value="8601">
        <td><input class="btnAdd" type="submit" value="Add to Cart"></td>
      </form>
    </tr>
    <tr>
      <td>Paddlefoot - The first CD</td>
      <td>$12.95</td>
      <form action="cart-exercise" method="post">
        <input type="hidden" name="action" value="addCart">
        <input type="hidden" name="productCode" value="pf01">
        <td><input class="btnAdd" type="submit" value="Add to Cart"></td>
      </form>
    </tr>
    <tr>
      <td>Paddlefoot - The second CD</td>
      <td>$14.95</td>
      <form action="cart-exercise" method="post">
        <input type="hidden" name="action" value="addCart">
        <input type="hidden" name="productCode" value="pf02">

        <td><input class="btnAdd" type="submit" value="Add to Cart"></td>
      </form>
    </tr>
    <tr>
      <td>Joe Rut - Genuine Wood Grained Finish</td>
      <td>$14.95</td>
      <form action="cart-exercise" method="post">
        <input type="hidden" name="action" value="addCart">
        <input type="hidden" name="productCode" value="jr01">
        <td><input class="btnAdd" type="submit" value="Add to Cart"></td>
      </form>
    </tr>
  </table>
</body>
<%@include file="include/footer.jsp"%>
</html>
