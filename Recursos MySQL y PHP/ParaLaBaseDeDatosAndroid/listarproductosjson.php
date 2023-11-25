<?php
$conexion = new mysqli("localhost", "root", "", "db_android");
$consulta = "SELECT ProductoID,Nombre, Precio,Stock FROM productos";
$resultado = $conexion->query($consulta);
$array=array();
while ($fila = $resultado->fetch_assoc()) {
$e = array();
$e['id'] = $fila['ID'];
$e['nombre'] = $fila['Nombre'];
$e['precio'] = $fila['Precio'];
$e['stock'] = $fila['Stock'];
array_push($array, $e);
}
echo json_encode($array);
$conexion->close();
?>