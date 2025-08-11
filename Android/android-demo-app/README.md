# Android Demo App

Cette application est un projet de démonstration pour Android, réalisé dans le cadre de la formation "Concepteur Développeur d'Applications". Elle a pour but d'illustrer plusieurs fonctionnalités clés du développement Android.

## Fonctionnalités

L'application est composée d'un menu principal qui donne accès à quatre démonstrations distinctes :

1.  **Mode Avion (Airplane Mode) :** Une activité qui vérifie et affiche l'état du mode avion du téléphone.
2.  **Lecteur de RFC (Standard) :** Une activité qui télécharge et affiche le contenu de la RFC 7230 (la spécification de HTTP/1.1) en utilisant les API réseau standard d'Android.
3.  **Lecteur de RFC (Volley) :** La même fonctionnalité que ci-dessus, mais implémentée avec la bibliothèque réseau [Volley](https://developer.android.com/training/volley), permettant de comparer les deux approches.
4.  **API Géo :** Une activité qui interroge une API géographique (probablement `geo.api.gouv.fr`) pour récupérer des informations sur les départements français.

## Technologies utilisées

*   **Langage :** Java
*   **SDK Android :**
    *   `minSdkVersion`: 15
    *   `targetSdkVersion`: 28
    *   `compileSdkVersion`: 28
*   **Bibliothèques :**
    *   AndroidX AppCompat
    *   Volley (pour les requêtes HTTP)
*   **Build :** Gradle

## Instructions de lancement

### Prérequis

*   Android Studio
*   Un émulateur Android ou un appareil physique

### Lancement

1.  Ouvrez le projet `Android/android-demo-app/` dans Android Studio.
2.  Laissez Gradle synchroniser et télécharger les dépendances nécessaires.
3.  Lancez l'application sur un émulateur ou un appareil connecté.
