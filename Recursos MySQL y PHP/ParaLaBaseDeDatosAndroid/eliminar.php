<?php
// Recibir el ID del producto a eliminar del POST request
$idProducto = $_POST['idProducto'];

// Realizar la conexión a la base de datos (ajusta las credenciales según tu configuración)
$conexion = new mysqli("localhost", "root", "", "basededatosandroid");

// Verificar la conexión
if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

// Preparar la consulta SQL para eliminar el producto
$consulta = "DELETE FROM productos WHERE ProductoID = '$idProducto'";

// Ejecutar la consulta y verificar el resultado
if ($conexion->query($consulta) === TRUE) {
    echo "Producto eliminado correctamente";
} else {
    echo "Error al eliminar el producto: " . $conexion->error;
}

// Cerrar la conexión
$conexion->close();
?>
