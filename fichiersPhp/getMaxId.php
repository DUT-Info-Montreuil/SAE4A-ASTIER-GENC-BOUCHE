<?php 

    header('Content-Type: application/json');

    try {
        $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root','');
    }catch(PDOException $e) {
        exit("Error: ".$e->getMessage());
    }

    $requete = $bdd->prepare('SELECT COUNT(id) FROM question');

    $requete->execute();
    $resultat = $requete->fetch(PDO::FETCH_ASSOC);

    echo json_encode($resultat, JSON_PRETTY_PRINT);
?>