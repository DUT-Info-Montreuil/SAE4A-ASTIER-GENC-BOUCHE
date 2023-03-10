<?php 
    class Questions extends Connexion{
        public function __construct(){

        }

        public function creerQuestionnaire($name){
            $query = self::$bdd->prepare("INSERT INTO Questionnaire (intitulé) VALUES (:name)");
            $query->execute(array(":name" => $name));
        }

        public function creerQuestion($name, $difficulty, $idQuestionnaire){
            $query = self::$bdd->prepare("INSERT INTO Question (intitulé, difficulté) VALUES (:name, :difficulty)");
            $query->execute(array(":name" => $name, ":difficulty" => $difficulty));

            $query = self::$bdd->prepare("SELECT id IN Question WHERE $name = :name");
            $query->execute(array(":name" => $name));
            $id = $query->fetch();

            $query = self::$bdd->prepare("INSERT INTO QuestionDuQuestionnaire (idQuestion, idQuestionnaire) VALUES (:idQuestion, :idQuestionnaire)");
            $query->execute(array(":idQuestion" => $id, ":idQuestionnaire" => $idQuestionnaire)); 
        }

        public function créerReponse($answer, $boolean, $idQuestion){
            $query = self::$bdd->prepare("SELECT * IN Question WHERE id = :idQuestion");
            $query->execute(array(":idQuestion" => $idQuestion));
            $row = $query->fetch();

            if($row){
                $query = self::$bdd->prepare("INSERT INTO RéponseDeLaQuestion (idQuestion, Réponse, BonneRéponse) VALUES (:idQuestion, :answer, :boolean)");
                $query->execute(array(":idQuestion" => $idQuestion, ":answer" => $answer, "BonneRéponse" => $boolean));
            }
        }

        public function getAnswer($id){
            $query = self::$bdd->prepare("SELECT * IN RéponseDeLaQuestion WHERE id = :id");
            $query->execute(array(":id" => $id));
            $row = $query->fetch();
        }

        public function getQuestion($id){
            $query = self::$bdd->prepare("SELECT * IN Question WHERE id = :id");
            $query->execute(array(":id" => $id));
            $row = $query->fetch();
        }

        public function getQuestionnaire($id){
            $query = self::$bdd->prepare("SELECT * IN Questionnaire WHERE id = :id");
            $query->execute(array(":id" => $id));
            $row = $query->fetch();
        }

    }
?>