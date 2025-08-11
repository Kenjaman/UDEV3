# Projet de Démarrage Symfony 5

Ce projet est une application Symfony 5 minimale, créée dans le cadre de la formation "Concepteur Développeur d'Applications". Il sert de point de départ ou de "Hello World" pour démontrer la structure de base d'un projet Symfony.

## Fonctionnalités

L'application est très simple et contient deux routes :

*   `/`: Affiche le message "OLA".
*   `/default`: Affiche le message "Hello world".

Le projet n'inclut pas de base de données ou d'autres dépendances complexes.

## Technologies utilisées

*   **Framework**: Symfony 5.0
*   **Langage**: PHP 7.2.5+
*   **Gestionnaire de dépendances**: Composer
*   **Moteur de templates**: Twig (disponible mais peu utilisé dans les contrôleurs actuels)

## Instructions de lancement

### Prérequis

*   PHP 7.2.5 ou supérieur
*   Composer
*   Le client Symfony CLI (recommandé)

### 1. Installation des dépendances

1.  Ouvrez un terminal à la racine de ce projet (`Symfony/mon-projet/`).
2.  Installez les dépendances avec Composer :
    ```sh
    composer install
    ```

### 2. Lancement du serveur de développement

Vous pouvez lancer l'application en utilisant le serveur web interne de PHP ou le serveur de la CLI Symfony.

**Avec la CLI Symfony (méthode recommandée) :**

```sh
symfony server:start
```

**Avec le serveur web de PHP :**

```sh
php -S localhost:8000 -t public/
```

L'application sera alors accessible à l'adresse `http://localhost:8000`.
