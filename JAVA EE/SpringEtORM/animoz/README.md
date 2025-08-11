# Projet "Animoz" - Gestion de Zoo

"Animoz" est une application web de gestion de zoo développée dans le cadre de la formation "Concepteur Développeur d'Applications". Elle permet de gérer les animaux, les espèces et les enclos d'un zoo.

## Fonctionnalités

*   Lister les animaux et leurs caractéristiques.
*   Gérer les espèces et les régimes alimentaires.
*   Associer des animaux à des enclos.
*   Générer des rapports (fonctionnalité probable via JasperReports).

## Technologies utilisées

*   **Backend**: Java 1.8, Spring Framework (MVC, ORM, Data), Hibernate
*   **Frontend**: JSP (JavaServer Pages) avec JSTL
*   **Base de données**: MySQL
*   **Build**: Apache Maven
*   **Serveur d'application**: Apache Tomcat (ou tout autre conteneur de servlets compatible)

## Instructions d'installation et de lancement

### Prérequis

*   JDK 1.8 ou supérieur
*   Apache Maven
*   Un serveur MySQL
*   Apache Tomcat 9.0 (ou compatible)

### 1. Configuration de la base de données

1.  Connectez-vous à votre serveur MySQL.
2.  Créez une base de données, par exemple `animoz_db`.
3.  Exécutez le script SQL `src/main/sql/database.sql` pour créer les tables et insérer les données initiales.
4.  Mettez à jour les informations de connexion à la base de données dans le fichier `src/main/resources/database.properties` (ce fichier devra peut-être être créé ou ajusté à partir des exemples fournis dans le projet).

### 2. Build du projet

1.  Ouvrez un terminal à la racine de ce projet (`JAVA EE/SpringEtORM/animoz/`).
2.  Lancez la commande Maven pour compiler et packager l'application :
    ```sh
    mvn clean install
    ```
3.  Cela va générer un fichier `animoz.war` dans le dossier `target/`.

### 3. Déploiement

1.  Déployez le fichier `animoz.war` sur votre serveur Tomcat. Vous pouvez généralement le faire en copiant le fichier dans le répertoire `webapps` de Tomcat.
2.  Démarrez Tomcat.
3.  L'application devrait être accessible à l'adresse `http://localhost:8080/animoz/`.
