# Mastermind

Jeu Mastermind développé en **Java** dans le cadre d’un projet académique. L’application fonctionne en mode console et met en œuvre une logique de jeu complète basée sur la comparaison de séries de couleurs.

## Aperçu du Projet

Ce projet implémente le jeu Mastermind classique où le joueur doit deviner une combinaison secrète de couleurs générée par le programme. À chaque tentative, le joueur reçoit un retour indiquant le nombre de couleurs correctement placées et celles présentes mais mal positionnées.

Le jeu se déroule entièrement dans le terminal et repose sur une architecture orientée objet claire.

## Fonctionnalités

### Logique de Jeu

* Génération aléatoire d’une combinaison secrète
* Comparaison des tentatives du joueur avec la solution
* Indication :

  * Couleurs bien placées
  * Couleurs correctes mais mal placées
* Nombre de tentatives contrôlé
* Fin de partie : victoire ou défaite

### Structure Orientée Objet

* Classe `Couleur` pour la gestion des couleurs
* Classe `Series` pour représenter une combinaison
* Classe `Mastermind` contenant la logique principale du jeu
* Classe `Main` pour le lancement de l’application

## Caractéristiques Techniques

* **Langage** : Java
* **Type d’application** : Console
* **Paradigme** : Programmation orientée objet
* **Gestion du projet** : IntelliJ IDEA

## Comment Utiliser

### Lancer le jeu

1. Ouvrir le projet dans un IDE Java (IntelliJ recommandé)
2. Compiler le projet
3. Exécuter la classe `Main`

### Processus de Jeu

1. Le programme génère une combinaison secrète
2. Le joueur entre une série de couleurs
3. Le jeu analyse la proposition
4. Un retour est affiché dans la console
5. Le jeu continue jusqu’à la victoire ou l’épuisement des tentatives

## Projet Académique

Ce projet a été réalisé dans le cadre d’un travail pratique visant à :

* Maîtriser la programmation orientée objet en Java
* Implémenter une logique algorithmique non triviale
* Structurer un projet logiciel simple

Le code est fourni à des fins éducatives.

## Démonstration

### Regarder la démo (cmd + click)

*Déroulement complet d’une partie de Mastermind en console*

<a href="https://rajbhanif.github.io/Matermind/Mastermind.mp4" target="_blank">▶ Cliquez ici pour ouvrir la vidéo de démo</a>

*La vidéo montre la génération de la combinaison, les tentatives du joueur et la fin de partie.*

## Auteur

**Raj Beghum Hanif**
Projet académique – Mastermind (Java, Console)
