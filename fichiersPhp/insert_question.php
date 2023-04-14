<?php
header('Content-Type: application/json');

try {
    $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root', '');
}catch(PDOException $e) {
    exit("Error: ".$e->getMessage());
}

$titreQuestionnaire = $_POST['titreQuestionnaire'];
$titreQuestion = $_POST['intituleQuestion'];
$idUser = $_POST['idUser'];
$reponse1 = $_POST['reponse1'];
$reponse2 = $_POST['reponse2'];
$reponse3 = $_POST['reponse3'];
$reponse4 = $_POST['reponse4'];
$bonneReponse = $_POST['bonneReponse'];

// Insert le titre du questionnaire
$sql = $bdd->prepare('INSERT INTO questionnaire(idUtilisateur, intitule) VALUES (?, ?)');
$sql->execute(array($idUser, $titreQuestionnaire));

//Récupère l'id du questionnaire
$sql = $bdd->prepare('SELECT MAX(id) FROM questionnaire WHERE intitule = ?');
$sql->execute(array($titreQuestionnaire));
$resultat = $sql->fetchAll();
$idQuestionnaire = $resultat[0];

// Insert le titre de la question
$sql = $bdd->prepare('INSERT INTO question(intitule, reponse1, reponse2, reponse3, reponse4, nReponse) VALUES (?, ?, ?, ?, ?, ?)');
$sql->execute(array($titreQuestion, $reponse1, $reponse2, $reponse3, $reponse4, $bonneReponse));
$resultat = $sql->fetchAll();

//Récupère l'id de la question
$sql = $bdd->prepare('SELECT MAX(id) FROM question WHERE intitule=?');
$sql->execute(array($titreQuestion));
$resultat = $sql->fetchAll();
$idQuestion = $resultat[0];

// Insert l'id de la question et l'id du questionnaire dans questionduquestionnaire
$sql = $bdd->prepare('INSERT INTO questionduquestionnaire(idQuestion, idQuestionnaire) VALUES (?, ?)');
$sql->execute(array($idQuestion[0], $idQuestionnaire[0]));
$resultat = $sql->fetchAll();

print("done");
?>