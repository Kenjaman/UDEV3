# Rapport d'Audit - Projet "Animoz"

Ce document résume l'analyse du projet "Animoz" en termes de dépendances, de qualité de code et de bugs potentiels.

**Date de l'audit :** 2025-08-10

## 1. Analyse des Dépendances (`pom.xml`)

Le projet repose sur une stack technologique datant de 2019-2020, basée sur Java 8.

*   **Point Critique (Haute Priorité) :**
    *   `mysql-connector-java` est en version **5.1.47** (2018). Cette version est obsolète et n'est plus maintenue. Elle peut contenir des failles de sécurité connues.
    *   **Recommandation :** Mettre à jour vers la dernière version du connecteur 8.x (`8.0.33` ou plus récent) et ajuster la configuration de la source de données (le nom de la classe du driver change).

*   **Points Mineurs (Basse Priorité) :**
    *   Les versions de Spring (5.2.1), Hibernate (5.4.24), et JasperReports (6.12.2) sont anciennes mais fonctionnelles pour un projet de cette nature. Une mise à jour majeure nécessiterait une migration vers Java 17+ et Spring 6, ce qui est un effort conséquent.
    *   **Recommandation :** Pour une modernisation future, envisager une migration complète de la stack. Pour l'instant, le focus doit être sur le connecteur MySQL.

## 2. Qualité du Code et Architecture

L'application suit une structure MVC classique (Contrôleur, Service, DAO), ce qui est une bonne pratique. Cependant, plusieurs points peuvent être améliorés.

### Problèmes Identifiés

1.  **Violation de la Séparation des Couches :** Le `AnimalControleur` accède directement à la `DataSource` et gère la connexion SQL pour la génération de rapports.
    *   **Recommandation :** Déplacer la logique de génération de rapports (y compris l'accès aux données) dans une classe de service dédiée (ex: `RapportService`). Le contrôleur ne devrait qu'appeler ce service.

2.  **Gestion des Erreurs Insuffisante :**
    *   Les blocs `catch` dans la génération de rapports se contentent d'un `e.printStackTrace()`, ce qui ne produit aucune réponse claire pour l'utilisateur en cas d'échec.
    *   Les erreurs de validation sont signalées par `System.out.println()`.
    *   **Recommandation :** Mettre en place un framework de logging (ex: SLF4J/Logback). Gérer les exceptions dans les contrôleurs (via `@ExceptionHandler` ou un `ControllerAdvice`) pour retourner des messages d'erreur appropriés à l'utilisateur.

3.  **Utilisation Incohérente des DTOs :** La méthode d'ajout utilise un `AnimalDto` (bien), mais la méthode de modification utilise directement l'entité `Animal`.
    *   **Recommandation :** Utiliser systématiquement les DTOs pour toutes les données entrantes de la couche de présentation afin d'éviter les vulnérabilités de "mass assignment" et de découpler le modèle de la vue.

4.  **Logique Métier dans le Contrôleur :** Des détails comme le nom de l'auteur du rapport (`"Kénan Roux"`) sont codés en dur dans le contrôleur.
    *   **Recommandation :** Externaliser les valeurs de configuration dans un fichier de propriétés (`application.properties`).

## 3. Bugs Potentiels et Comportements Anormaux

1.  **Échec Silencieux à l'Ajout :** Si on tente d'ajouter un animal qui existe déjà (même nom), l'opération échoue silencieusement dans la couche service, et l'utilisateur est redirigé comme si tout avait fonctionné.
    *   **Recommandation :** Le `AnimalService` devrait lancer une exception métier (ex: `AnimalAlreadyExistsException`). Le contrôleur devrait intercepter cette exception et afficher un message d'erreur à l'utilisateur sur le formulaire.

2.  **Réponse Corrompue en cas d'Erreur de Rapport :** Si la génération du PDF échoue, le flux de sortie (`OutputStream`) sera probablement corrompu ou vide, résultant en une erreur de téléchargement ou un fichier PDF invalide pour l'utilisateur.
    *   **Recommandation :** Implémenter une gestion d'erreur robuste qui retourne une page d'erreur HTML ou un statut HTTP approprié.

## Conclusion de l'Audit

Le projet est une bonne démonstration d'une application Spring MVC de base. Les points critiques à corriger concernent la **mise à jour du connecteur MySQL** et l'**amélioration de la gestion des erreurs**. Les autres points sont des recommandations pour aligner le code avec les meilleures pratiques modernes et le rendre plus robuste et maintenable.
