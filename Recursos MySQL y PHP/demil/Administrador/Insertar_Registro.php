<?php
// Incluir el archivo de conexión
$host = 'localhost';
$dbname = 'db_android';
$user = 'root';
$pass = '';

// Intentar establecer una conexión
$conexion = new mysqli($host, $user, $pass, $dbname);

// Recibe los datos del formulario
$name = $_POST['nombre'];
$contraseña = $_POST['contraseña'];

// Consulta SQL para insertar datos en la tabla
	
$query = "INSERT INTO ursadministrador (Nombre, Contrasenia) VALUES ('$name', md5('$contraseña'))";

// Ejecuta la consulta
if ($conexion->query($query)) {
    echo "Datos insertados con éxito";
} else {
    echo "Error al insertar datos: " . $conexion->error;
}

// Cierra la conexión
$conexion->close();
?>
