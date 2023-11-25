<?php
include "conexion.php";
$conexion = new mysqli($host, $user, $pass, $dbname);

$consulta = "SELECT * FROM `categoria`";
$resultado = $conexion->query($consulta);
$array = array();
array_push($array, "CATEGORIA");

while ($fila = $resultado->fetch_assoc()) {
    $e = $fila['NombreCategoria'];

    

    array_push($array, $e);
}
echo json_encode($array);
$conexion->close();
?>