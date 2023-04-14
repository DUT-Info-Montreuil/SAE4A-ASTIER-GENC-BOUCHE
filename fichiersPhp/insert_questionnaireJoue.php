<?php
header('Content-Type: application/json');

try {
    $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root', '');
}catch(PDOException $e) {
    exit("Error: ".$e->getMessage());
}

$idUser = $_POST['idUtilisateur'];
$idQuest = $_POST['idQuestionnaire'];


// Insert le titre du questionnaire
$sql = $bdd->prepare('INSERT INTO questionnairejoue(idUtilisateur, idQuestionnaire) VALUES (?, ?)');
$sql->execute(array($idUser, $idQuest));

$resultat = $sql->fetchAll(PDO::FETCH_ASSOC);

echo json_encode($resultat);
?>