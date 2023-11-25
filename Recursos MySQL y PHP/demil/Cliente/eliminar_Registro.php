<?php
// Incluir el archivo de conexión
$host = 'localhost';
$dbname = 'db_android';
$user = 'root';
$pass = '';

// Intentar establecer una conexión
$conexion = new mysqli($host, $user, $pass, $dbname);

// Recibe los datos del formulario
$id = $_POST['idRegistro'];


// Consulta SQL para insertar datos en la tabla
	
$consulta = "DELETE FROM urscliente WHERE ID = '$id'";
// Ejecuta la consulta
if ($conexion->query($consulta)) {
    echo "Datos eliminado con éxito";
} else {
    echo "Error al eliminar datos: " . $conexion->error;
}

// Cierra la conexión
$conexion->close();
?>
