<?php
require "conexion.php";
$conexion = new mysqli($host, $user, $pass, $dbname);

$consulta = "SELECT * FROM `productos`";
$resultado = $conexion->query($consulta);
$array = array();
$titulo="ProductoID-Nombre-Descripcion-Precio-Stock-CategoriaID	";
array_push($array,$titulo );
while ($fila = $resultado->fetch_assoc()) {
    $e = $fila['ProductoID'] . " -- " . $fila['Nombre'] . " -- " . $fila['Descripcion']. "  --  ".$fila['Precio'] . " 
    -- " . $fila['Stock']." --  ".$fila["CategoriaID"];
    array_push($array, $e);
}
echo json_encode($array);
$conexion->close();
?>