<?php 

    header('Content-Type: application/json');

    try {
        $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root','');
    }catch(PDOException $e) {
        exit("Error: ".$e->getMessage());
    }

    $idQuestionnaire = $_GET['idQuestionnaire'];

    $requete = $bdd->prepare('SELECT question.* FROM questionduquestionnaire inner join question on questionduquestionnaire.idQuestion = question.id where idQuestionnaire=?');

    $requete->execute(array($idQuestionnaire));
    $resultat = $requete->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($resultat, JSON_PRETTY_PRINT);
?>