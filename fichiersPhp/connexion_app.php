<?php
try {
    $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root','');
}catch(PDOException $e) {
    die("Error: ".$e->getMessage());
}

$pseudo = $_GET['pseudo'];
$mdp = $_GET['mdp'];


if(isset($pseudo) && isset($mdp)) {
    $mdpHash = password_hash($mdp, PASSWORD_DEFAULT);
    $sql = $bdd->prepare('SELECT * FROM utilisateur WHERE  pseudo = ?');
    $sql->execute(array($pseudo));
    $resultat = $sql->fetchall(PDO::FETCH_ASSOC);
}
if(isset($resultat[0]) && password_verify($mdp, $resultat[0]['motdepasse'])){
    echo json_encode($resultat);
}
    
?>