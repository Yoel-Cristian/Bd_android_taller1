<?php
// Realizar la conexión a la base de datos (ajusta las credenciales según tu configuración)
$conexion = new mysqli("localhost", "root", "", "db_android");

// Verificar la conexión
if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

// Preparar la consulta SQL para obtener los nombres de los productos
$consulta = "SELECT ProductoID, Nombre FROM productos";

// Ejecutar la consulta
$resultado = $conexion->query($consulta);

// Verificar si hay resultados
if ($resultado->num_rows > 0) {
    // Crear un array para almacenar los nombres de los productos
    $nombresProductos = array();

    // Iterar a través de los resultados y almacenar los nombres en el array
    while ($fila = $resultado->fetch_assoc()) {
        $nombresProductos[] = $fila['Nombre'];
    }

    // Imprimir el array como un JSON
    echo json_encode($nombresProductos);
} else {
    echo "No se encontraron productos";
}

// Cerrar la conexión
$conexion->close();
?>
