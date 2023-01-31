JPA/Hibernate :

Spring Data est un projet Spring qui a pour objectif de simplifier l’interaction avec différents
systèmes de stockage de données : qu’il s’agisse d’une base de données relationnelle,
d’une base de données NoSQL, d’un système Big Data ou encore d’une API Web.

Le principe de Spring Data est d’éviter aux développeurs de coder les accès à ces systèmes.
Pour cela, Spring Data utilise une convention de nommage des méthodes d’accès pour exprimer la requête à réaliser.

Spring Web :

Dépendance qui permet de gérer le fonctionnement d'une page Web

H2 :

H2 permet de réaliser une base de données

DevTools :
Des outils permettant de développer plus rapidement

Thymeleaf :

Thymeleaf est un moteur de template pour les applications web qui permet de générer des vues à partir de modèles et de données.


--------------------------------------------------------------------------------------------------------------
REPONSES AUX QUESTIONS :
--------------------------------------------------------------------------------------------------------------
q13 :

    1. @RequestParam(name="nameGET", required=false, defaultValue="World") String nameGET, Model model)

    2. @GetMapping("/greeting")

    3. En utilisant GET.

q17 :
Mtn table address. Pas avant.

q18:
@Entity permet à Spring que la classe Address soit une entité de notre base de données (ou une table).

q20:

Oui je vois le contenu

q22:

@Autowired sert à réaliser les injections de dépendances automatiques

q27:

Oui, c'est possible.

q30:

Dans le fichier pom.xml, on rajoute les dependencies liées à Bootstrap :

    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>bootstrap</artifactId>
        <version>3.3.6</version>
    </dependency>
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>bootstrap-datepicker</artifactId>
        <version>1.0.1</version>
    </dependency>


--------------------------------------------------------------------------------------------------------------
Partie 2 :
--------------------------------------------------------------------------------------------------------------

q6 :

1. Pour faire des appels API, un token est nécessaire. Pour l'obtenir, il faut créer un compte sur Meteo Concept.
2. Pour appeler l'API, utiliser l'URL suivante : https://api.meteo-concept.com/api/forecast/daily/0?token, avec les paramètres latitude, longitude.
3. Utilisez la méthode GET.
4. Les paramètres d'appel se trouvent dans l'URL, exemple : MeteoController.java.
5. Pour récupérer les données, il faut parser le fichier JSON ou XML.
6. La température se trouve dans le tableau "observations" du fichier JSON observations : https://api.meteo-concept.com/api/observations/24h/station.
7. Les prévisions se trouvent dans le tableau "forecast" avec les valeurs tmin et tmax.



lien github : https://github.com/guihaume/TP3_Poo.git
