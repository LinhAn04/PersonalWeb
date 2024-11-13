<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Your Information</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/Survey/Survey.css">
</head>

<body>
<div class="body">
<h1>Thanks for filling out our survey</h1>

<h2>Here is the information that you entered:</h2>

<table>
    <tr>
        <td><b>Firstname:</b></td>
        <td><span>${user.firstName}</span></td>
    </tr>
    <tr>
        <td><b>Last Name:</b></td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td><b>Email:</b></td>
        <td><span>${user.email}</span></td>
    </tr>
    <tr>
        <td><b>Date of Birth:</b></td>
        <td><span>${user.dateOfBirth}</span></td>
    </tr>
</table>

<br>
<div class="contact">
    <label><b>You know us through:</b></label>
    <span>${user.hearInfor}</span><br>

    <label><b>You want to receive information through:</b></label>
    <span>${user.receiveInfor}</span><br>
    <label><b>We will contact you through:</b></label>
    <span>${user.contact}</span><br>
</div>

<br>
<form action="" method="post"> <!-- Specify the URL where the form should be submitted -->
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>
</div>
</body>
</html>