# FalabellaTestAutomation

#Lanzar Tests
ubicarse en la carpeta donde se tiene el proyecto con el comando 
~cd .../hybridtestng/
Ejecutar los test
~mvn -test


#Estructura del proyecto
El proyecto esta construido con el modelo POM(Page Objet Model), consta de:
1.Clase Base: 
  Base.java: La cuál permite aislar las clases page de los comandos de selenium.
2.Clases Page: Las clases page se utilizan para abstraer las acciones y localizadores a utilizar en las diferente páginas del sistema, 
             de esta forma si algún localizador o forma de ejecutar una acción cambia será fácilmente mantenible.
  LoginPage.java: LoginPage hereda de la clase base y centraliza los localizadores y acciones(métodos) de la página login.
  Register Page: (No desarrollada por completo, solo de ejemplo de otra clase page) RegisterPage hereda de la clase base y centraliza los localizadores y acciones(métodos) de la página register.
3.Clases Test: Estas clases sirven para ejecutar los diferentes casos de pruebas diseñados, en este ejemplo se utiliza solo la página login.
  CP_Login01_Test.java: ingresar a Falabella con correo y contraseña registrado en sistema.
  CP_Login02_Test.java: ingresar al sistema con correo y contraseña correcto, pero no registrado en el sistema
  CP_Login03_Test.java: ingresar al sistema dejando campos correo y contraseña vacios
  CP_Login04_Test.java: ingresar al sistema dejando solo campo correo vacio
  CP_Login05_Test.java: ingresar al sistema ingresando correo con formato incorrecto
