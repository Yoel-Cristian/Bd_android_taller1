<?php
// Incluir el archivo de conexión
$host = 'localhost';
$dbname = 'db_android';
$user = 'root';
$pass = '';

// Intentar establecer una conexión
$conexion = new mysqli($host, $user, $pass, $dbname);

// Recibe los datos del formulario
$id = $_POST['id'];
$name = $_POST['nombre'];
$contraseña = md5($_POST['contraseña']);

// Consulta SQL para actualizar datos en la tabla
$query = "UPDATE urscliente SET Nombre = '$name', Contrasenia = '$contraseña' WHERE ID = '$id'";

// Ejecuta la consulta
if ($conexion->query($query)) {
    echo "Datos actualizados con éxito";
} else {
    echo "Error al actualizar datos: " . $conexion->error;
}

// Cierra la conexión
$conexion->close();
?>
