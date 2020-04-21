<?php
    
    $endereco = "mysql:host=localhost;dbname=id13202775_senaiteste2020;charset=utf8";
    $usuario = "id13202775_hugococus";
    $senha = "Admin#123456";
    
    try {
        
        $PDO = new PDO($endereco, $usuario, $senha);
        //echo "Conectamos!";
        
        
     } catch (PDOException $e) {
    
        echo $e;
        
    }

?>
