<?php

    include "Conexao.php";

    $nome = $_POST['NOME'];
    $cpf = $_POST['CPF'];

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
