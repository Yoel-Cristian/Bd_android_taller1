<?php
include "conexion.php";

$conexion = new mysqli($host, $user, $pass, $dbname);

// Recibe los datos del formulario
$idProducto = $_POST['idProducto'];


// Consulta SQL para insertar datos en la tabla

$consulta = "DELETE FROM productos WHERE ProductoID = '$idProducto'";
// Ejecuta la consulta
if ($conexion->query($consulta)) {
    echo "Datos eliminado con éxito";
} else {
    echo "Error al eliminar datos: " . $conexion->error;
}

// Cierra la conexión
$conexion->close();
?>
