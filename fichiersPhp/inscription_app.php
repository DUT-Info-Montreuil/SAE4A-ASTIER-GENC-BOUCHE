<?php
    header('Content-Type: application/json');

try {
    $bdd = new PDO('mysql:host=localhost;dbname=quizz', 'root','');
}catch(PDOException $e) {
    exit("Error: ".$e->getMessage());
}

$pseudo = $_POST['pseudo'];
$email = $_POST['email'];
$mdp = $_POST['mdp'];



if($pseudo && $email && $mdp) {
    $mdpHash = password_hash($mdp, PASSWORD_DEFAULT);
    $sql = $bdd->prepare('INSERT INTO utilisateur(pseudo, email, motdepasse) VALUES (?, ?, ?)');
    $sql->execute(array($pseudo, $email, $mdpHash));
    $resultat = $sql;
}

if($resultat) {
    print("Inscription done !");
    echo json_encode($resultat);
}else {
    print("Pas inscrit !");
    echo json_encode($resultat);
}

?>