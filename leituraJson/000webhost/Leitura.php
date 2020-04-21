<?php

    include "Conexao.php";
    
    $PDO->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    
    $query = "Select * from pessoas";
    
    $statement = $PDO->prepare($query);
    $statement->execute();
    
    $resposta = array();
    while($r = $statement->fetch(PDO::FETCH_OBJ)) {

        $resposta[] = array('id'=>$r->id,'nome'=>$r->nome,'cpf'=>$r->cpf);
    }
    
    echo json_encode($resposta);
?>
