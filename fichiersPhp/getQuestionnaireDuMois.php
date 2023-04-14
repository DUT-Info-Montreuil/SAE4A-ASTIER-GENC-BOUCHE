<?php 

    header('Content-Type: application/json');

    try {
        $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root','');
    }catch(PDOException $e) {
        exit("Error: ".$e->getMessage());
    }


    $requete = $bdd->prepare('SELECT * FROM questionnairejoue INNER JOIN questionnaire ON questionnairejoue.idQuestionnaire = questionnaire.id WHERE dateDeCreation >= DATE_SUB(NOW(), INTERVAL 1 MONTH) GROUP BY intitule ORDER BY COUNT(*) desc LIMIT 4;');

    $requete->execute();
    $resultat = $requete->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($resultat, JSON_PRETTY_PRINT);
?>