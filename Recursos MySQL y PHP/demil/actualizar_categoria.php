<?php
include "conexion.php";
$conexion = new mysqli($host, $user, $pass, $dbname);



// Recibe los datos del formulario
$idCategoria = $_POST['id'];
$name = $_POST['nombre'];
$description = $_POST['descripcion'];

// Consulta SQL para actualizar datos en la tabla
$query = "UPDATE categoria SET NombreCategoria = '$name', descripcion = '$description' WHERE CategoriaID = '$idCategoria'";

// Ejecuta la consulta
if ($conexion->query($query)) {
    echo "Datos actualizados con éxito";
} else {
    echo "Error al actualizar datos: " . $conexion->error;
}

// Cierra la conexión
$conexion->close();
?>
