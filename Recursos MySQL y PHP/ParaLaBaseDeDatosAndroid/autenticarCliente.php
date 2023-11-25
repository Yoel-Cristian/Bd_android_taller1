<?php
// Recibir datos del POST request
$nombreUsuario = $_POST['nombreUsuario'];
$contrasena = md5($_POST['contrasena']);


// Realizar la conexión a la base de datos (ajusta las credenciales según tu configuración)
$conexion = new mysqli("localhost", "root", "", "db_android");

// Verificar la conexión
if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

// Preparar la consulta SQL para verificar las credenciales del usuario
$consulta = "SELECT * FROM urscliente WHERE Nombre = '$nombreUsuario' AND Contrasenia = '$contrasena'";

// Ejecutar la consulta
$resultado = $conexion->query($consulta);

// Verificar si hay resultados
if ($resultado->num_rows > 0) {
    echo "Autenticación exitosa"; // Usuario y contraseña válidos
} else {
    echo "Error de autenticación"; // Usuario o contraseña incorrectos
}

// Cerrar la conexión
$conexion->close();
?>