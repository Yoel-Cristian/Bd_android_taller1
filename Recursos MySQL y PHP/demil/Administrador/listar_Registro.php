<?php
$conexion = new mysqli("localhost", "root", "", "db_android");
$consulta = "SELECT * FROM `registro_administrador`";
$resultado = $conexion->query($consulta);
$array = array();
$titulo="ID --	Nombre	-- Contraseña	";
array_push($array,$titulo );
while ($fila = $resultado->fetch_assoc()) {
    $e = $fila['ID'] . " -- " . $fila['Nombre'] ;

    
    array_push($array, $e);
}
echo json_encode($array);
$conexion->close();
?>