<?php
include "conexion.php";
$conexion = new mysqli($host, $user, $pass, $dbname);


// Recibe los datos del formulario
$name = $_POST['nombre'];
$description = $_POST['descripcion'];

// Consulta SQL para insertar datos en la tabla
	
$query = "INSERT INTO categoria (NombreCategoria, descripcion) VALUES ('$name', '$description')";

// Ejecuta la consulta
if ($conexion->query($query)) {
    echo "Datos insertados con éxito";
} else {
    echo "Error al insertar datos: " . $conexion->error;
}

// Cierra la conexión
$conexion->close();
?>
