<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Survey</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/Survey/Survey.css">
</head>
<body>
<div class="body">
  <!-- image -->
  <div class="png">
    <img src="${pageContext.request.contextPath}/Web/Survey/surveyImage/murach.png" height="100px" class="imageMurach">
  </div>
  <!-- header 1: Survey -->
  <form action="surveyEx" method="post">
  <!-- header 1: Survey -->
    <div>
      <h1>Survey</h1>
      <p>If you have a moment, we'd appreciate it if you would fill out this survey.</p>
    </div>
    <!-- header 2: Fill information -->
    <div>
      <h1>Your information:</h1>
    </div>
    <input type="hidden" name="action" value="add">
    <div>
      <!-- textbox -->
      <label class="a" for="FirstName"><b>First name:</b></label>
      <input type="text" id="FirstName" name="FirstName"><br>
      <label class="a" for="LastName"><b>Last name:</b></label>
      <input type="text" id="LastName" name="LastName"><br>
      <label class="a" for="Email"><b>Email:</b></label>
      <input type="text" id="Email" name="Email"><br>
      <!-- date -->
      <label class="a" for="DateOfBirth"><b>Date of birth:</b></label>
      <input type="date" id="DateOfBirth" name="DateOfBirth" required><br>
    </div>

    <!-- radio button -->
    <h3>How did you hear about us?</h3>
    <input type="radio" id="SearchEngine" name="Tools" value="Search engine">
    <label for="SearchEngine">Search engine</label>

    <input type="radio" id="WorldOfMouth" name="Tools" value="World of mouth">
    <label for="WorldOfMouth">World of mouth</label>

    <input type="radio" id="SocialMedia" name="Tools" value="Social media">
    <label for="SocialMedia">Social media</label>

    <input type="radio" id="Other" name="Tools" value="Other">
    <label for="Other">Other</label>

    <!-- check box -->
    <h4>Would you like to receive announcements
      about new CDs and special offers?</h4>
    <input type="checkbox" id="Yes" name="option" value="You'd like that!">
    <label for="Yes">YES, I'd like that.</label><br><br>

    <input type="checkbox" id="YesInfo" name="option" value="We will send you email announcements.">
    <label for="YesInfo">YES, please send me email announcements.</label><br><br>

    <label for="Contacts">Please contact me by:</label>
    <select name="contacts" id="Contacts">
      <option value="Email or postal mail">Email or postal mail</option>
      <option value="Email only">Email only</option>
      <option value="Postal mail only">Postal mail only</option>
    </select>
    <br><br>
    <input type="submit" value="Submit">

    <input class="btnHome" type="button" value="Return Home" id="home" onclick="returnHome()">

  </form>

  <script>
    function returnHome() {
      // Chuyển hướng về trang chủ mà không kiểm tra form
      window.location.href = 'returnHome';
    }
  </script>

</div>
</body>
</html>