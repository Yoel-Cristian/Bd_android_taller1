<?php
include "conexion.php";
$conexion = new mysqli($host, $user, $pass, $dbname);

$consulta = "SELECT * FROM `categoria`";
$resultado = $conexion->query($consulta);
$array = array();
$titulo="CategoriaID --	NombreCategoria	-- descripcion	";
array_push($array,$titulo );
while ($fila = $resultado->fetch_assoc()) {
    $e = $fila['CategoriaID'] . " -- " . $fila['NombreCategoria'] . " -- " . $fila['descripcion'];

    
    array_push($array, $e);
}
echo json_encode($array);
$conexion->close();
?>