## Projet de Génie Logiciel
<h3>Présentation du projet</h3>
Dans le cadre de notre première année de master en Informatique à l'UFR Sciences et Techniques de Dijon, il nous est proposé un projet en groupe impliquant 6 personnes sur une durée d'un mois. Ce projet a pour objectif de concevoir et développer une application Java centrée autour de la gestion de paniers de fruits, initialement abordée lors des travaux pratiques ainsi que des travaux dirigés.
<h3>Membres du groupe</h3>
<ul>
  <li>ABOUHAMOU Amen</li>
  <li>ANNANE Mohamed</li>
  <li>ASNI Mehdi</li>
  <li>BAHOUS Mohamed-Aymene</li>
  <li>LAZRAK Nissrine</li>
  <li>SENER Betul</li>
</ul>

<h3>Méthodes utilisées</h3>
<h4>Pour l’interface </h4>on a créé 4 interfaces; la première pour afficher la liste des paniers et le contenue d'un panier, la seconde qui doit s'afficher lorsqu'on veut modifier le contenu d'un panier, la troisième et la quatrième interface pour créer un nouveau panier ou un nouveau fruit.
Pour construire ces interfaces on a utilisé comme logiciel netbeans qui offre une gamme complète d'outils et de fonctionnalités pour faciliter la création, la conception et la maintenance de l'interface de notre projet.
<h4>Pour la base de données </h4> Les données de cette application sont gérées au moyen d'une base de données SQLite.

<h4>Les modèles de conception</h4> sont des solutions éprouvées aux problèmes de conception courants, et leur utilisation facilite la création d'IHM efficaces et maintenables, voici quelques modèles design patterns qu’on a utilisé lors de la conception de notre application :
<ul>
  <li><b>Modèle MVC</b> pour séparer le modèle, la présentation (vue) et le contrôle (contrôleur). Cela permet de rendre l'IHM plus modulaire et facile à gérer. </li>
  <li><b>Modèle Singleton</b> utilisé pour garantir qu'une seule instance d'un composant ou d'une classe de gestion de l'IHM est créée.</li>
  <li><b>Modèle Fabrique (Factory)</b> utilisé pour créer dynamiquement des instances de composants d'IHM en fonction de certaines conditions ou paramètres.</li>
</ul>



