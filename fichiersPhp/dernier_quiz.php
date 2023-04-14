<?php 

    header('Content-Type: application/json');

    try {
        $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root','');
    }catch(PDOException $e) {
        exit("Error: ".$e->getMessage());
    }

    $idjoueur = $_GET['id'];

    $requete = $bdd->prepare('SELECT questionnaire.* FROM questionnairejoue
                                                JOIN questionnaire ON questionnairejoue.idQuestionnaire = questionnaire.id
                                                WHERE questionnairejoue.idUtilisateur = ?
                                                GROUP BY questionnaire.intitule
                                                ORDER BY questionnairejoue.dateDeJeu DESC
                                                LIMIT 4;
    ');

    $requete->execute(array($idjoueur));
    $resultat = $requete->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($resultat, JSON_PRETTY_PRINT);
?>