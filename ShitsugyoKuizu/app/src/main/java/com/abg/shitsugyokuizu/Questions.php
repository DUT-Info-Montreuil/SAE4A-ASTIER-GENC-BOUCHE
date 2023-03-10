<?php 
    class Questions extends Connexion{
        public function __construct(){

        }

        public function creerQuestionnaire($name){
            $query = self::$bdd->prepare("INSERT INTO Questionnaire (intitulé) VALUES (:name)");
            $query->execute(array(":name" => $name));
        }

        public function creerQuestion($name, $difficulty){
            $query = self::$bdd->prepare("INSERT INTO Question (intitulé, difficulté) VALUES (:name, :difficulty)");
            $query->execute(array(":name" => $name, ":difficulty" => $difficulty));
        }

        public function créerReponse($answer, $boolean, $idQuestion){
            $query = self::$bdd->prepare("SELECT * IN Question WHERE id = :idQuestion");
            $query->execute(array(":idQuestion" => $idQuestion));
            $row = $query->fetch();

            if($row){
                $query = self::$bdd->prepare("INSERT INTO Questionnaire (idQuestion, Réponse, BonneRéponse) VALUES (:idQuestion, :answer, :boolean)");
                $query->execute(array(":idQuestion" => $idQuestion, ":answer" => $answer, "BonneRéponse" => $boolean));
            }
        }

    }
?>