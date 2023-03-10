<?php
    include_once('Connexion.php');
    class User extends Connexion{

        public function __construct(){}

        public function getUserData($username, $password){
            $query = self::$bdd->prepare("SELECT * FROM users WHERE username = :username");
            $query->execute(array(":username" => $username));
            $row = $query->fetch();
            return $row;
        }

    }
?>