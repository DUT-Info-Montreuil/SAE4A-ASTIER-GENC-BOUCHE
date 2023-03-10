<?php

    class Connexion{
        public static $bdd;


        
        public function __construct(){

        }

        public static function initConnexion(){
            self::$bdd= new PDO(
                'mysql:dbname=dutinfopw201644;host=database-etudiants.iut.univ-paris8.fr',
                'dutinfopw201644',
                'rusedyny'
            );
        }
    }
    
?>