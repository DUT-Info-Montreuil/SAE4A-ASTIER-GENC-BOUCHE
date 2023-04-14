<?php 

    header('Content-Type: application/json');

    try {
        $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root','');
    }catch(PDOException $e) {
        exit("Error: ".$e->getMessage());
    }

    $idjoueur = $_GET['idUser'];

    $requete = $bdd->prepare('SELECT * FROM questionnaire 
    WHERE idUtilisateur = ? 
    GROUP BY intitule 
    ORDER BY dateDeCreation DESC 
    LIMIT 4;
    ');

    $requete->execute(array($idjoueur));
    $resultat = $requete->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($resultat, JSON_PRETTY_PRINT);
?>