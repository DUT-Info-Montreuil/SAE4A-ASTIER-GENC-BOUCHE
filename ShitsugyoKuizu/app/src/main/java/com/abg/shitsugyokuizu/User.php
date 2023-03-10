<?php
    include_once('Connexion.php');
    class User extends Connexion{

        public function __construct(){}

        public function connect($username, $password){
            $query = self::$bdd->prepare("SELECT * FROM users WHERE username = :username");
            $query->execute(array(":username" => $username));
            $row = $query->fetch();
            if($row){
                if(password_verify($password, $row['password'])){
                    $_SESSION['id'] = $row['id'];
                    header('Location: index.php');
                }else{
                    echo "Incorrect information";
                }
            }
        }

    }
?>