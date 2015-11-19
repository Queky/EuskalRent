<%-- 
    Document   : RegistroUsuario
    Created on : 19-nov-2015, 11:42:42
    Author     : BEEP
--%>

<!-- multistep form -->
<link href="../CSS/RegistroUsuario.css"
      rel="stylesheet" type="text/css"
 <h1 class="register-title">Welcome</h1>
  <form class="register">
    <div class="register-switch">
      <input type="radio" name="sex" value="F" id="sex_f" class="register-switch-input" checked>
      <label for="sex_f" class="register-switch-label">Female</label>
      <input type="radio" name="sex" value="M" id="sex_m" class="register-switch-input">
      <label for="sex_m" class="register-switch-label">Male</label>
    </div>
    <input type="email" class="register-input" placeholder="Email address">
    <input type="password" class="register-input" placeholder="Password">
    <input type="submit" value="Create Account" class="register-button">
  </form>