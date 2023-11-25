<?php
// Incluir el archivo de conexión
include "conexion.php";
$conexion = new mysqli($host, $user, $pass, $dbname);


// Recibir datos del formulario Android
$id=$_POST["id"];
$nombre = $_POST["nombre"];
$descripcion = $_POST["descripcion"];
$precio = $_POST["precio"];
$stock = $_POST["stock"];
$categoriaID = $_POST["categoriaID"];



$query = "SELECT CategoriaID FROM categoria WHERE NombreCategoria = '$categoriaID'";

// Ejecutar la consulta
$resultado = $conexion->query($query);

// Verificar si hay resultados
if ($resultado->num_rows > 0) {
    // Obtener el CategoriaID
    $fila = $resultado->fetch_assoc();
    $categoriaID = $fila['CategoriaID'];
}


// Insertar datos en la base de datos
$sql = "UPDATE productos SET Nombre = '$nombre', Descripcion = '$descripcion', Precio = '$precio', Stock = '$stock', CategoriaID='$categoriaID' WHERE ProductoID = '$id'";

$resultado = $conexion->query($sql);

// Verificar si la consulta fue exitosa
if ($resultado) {
    echo "Datos insertados con éxito";
} else {
    echo "Error al insertar datos: " . $conexion->error;
}

// Cerrar la conexión
$conexion->close();
?>
