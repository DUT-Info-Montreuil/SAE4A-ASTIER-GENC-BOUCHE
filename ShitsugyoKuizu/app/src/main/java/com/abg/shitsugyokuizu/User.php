<?php
    include_once('Connexion.php');
    class User extends Connexion{

        public function __construct(){}

        public function connect($username, $password){
            $query = self::$bdd->prepare("SELECT * FROM utilisateur WHERE pseudo = :username");
            $query->execute(array(":username" => $username));
            $row = $query->fetch();
            if($row){
                if(password_verify($password, $row['motdepasse'])){
                    $_SESSION['id'] = $row['id'];
                }else{
                    echo "Incorrect information";
                }
            }
        }

        public function signUp($username, $unHashedPassword, $email, ){
            $hash = password_hash($unHashedPassword, PASSWORD_DEFAULT);
            $query = self::$bdd->prepare("INSERT INTO utilisateur (pseudo, motdepasse, email) VALUES (:username, :password, :email)");
            $query->execute(array(":username" => $username, ":password" => $hash, ":email" => $email));
        }

    }
?>