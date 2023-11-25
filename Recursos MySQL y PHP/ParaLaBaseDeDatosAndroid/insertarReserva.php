<?php
// Recibir datos del POST request
$nombre = $_POST['nombre'];
$precio = $_POST['cantidad'];

// Realizar la conexión a la base de datos (ajusta las credenciales según tu configuración)
$conexion = new mysqli("localhost", "root", "", "db_android");

// Verificar la conexión
if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

// Preparar la consulta SQL para la inserción
$consulta = "INSERT INTO detallereserva (Nombre, Cantidad) VALUES ('$nombre', '$precio')";

// Ejecutar la consulta y verificar el resultado
if ($conexion->query($consulta) === TRUE) {
    echo "Datos insertados correctamente";
} else {
    echo "Error al insertar datos: " . $conexion->error;
}

// Cerrar la conexión
$conexion->close();
?>
