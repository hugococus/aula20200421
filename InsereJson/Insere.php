<?php

    include "Conexao.php";

    $dados = json_decode($_POST['JSON']);
    
    $nome =  $dados->nome;
    $cpf = $dados->cpf;
     

    $PDO->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    try {
        $query = "INSERT INTO pessoas(id, nome, cpf) VALUES (NULL, :NOME, :CPF)";
        $statement = $PDO->prepare($query);
 
        $statement->bindParam(':NOME', $nome, PDO::PARAM_STR);
        $statement->bindParam(':CPF', $cpf, PDO::PARAM_STR);
        $erro = $statement->execute();
    } catch (PDOException  $e) {
        echo $e->getMessage();
    }

?>
