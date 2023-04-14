<?php 

    header('Content-Type: application/json');

    try {
        $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root','');
    }catch(PDOException $e) {
        exit("Error: ".$e->getMessage());
    }

    $idjoueur = $_GET['idUser'];

    $requete = $bdd->prepare('SELECT id, intitule,score FROM questionnaire 
                                LEFT JOIN utilisateur ON questionnaire.idUtilisateur = utilisateur.id
                                WHERE  utilisateur.id = ? 
    ');

    $requete->execute(array($idjoueur));
    $resultat = $requete->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($resultat, JSON_PRETTY_PRINT);
?>