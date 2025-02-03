**Apprentissage du langage Scala et de la programmation fonctionnelle **

\
**Installer spark sur windows**
- En indépendant : https://phoenixnap.com/kb/install-spark-on-windows-10
- Docker : https://hub.docker.com/_/spark

\
**Utilisation de spark dans un projet sbt scala** \
Spark 3.x ne supporte pas Scala 3.x \
Spark 3.x nécessite Java 8, 11, ou 17 (ne fonctionne pas correctement) \
Spark 3.x et Scala 2.13 ou 2.12 ne fonctionne pas bien avec sbt 1.10 \
Pour essayer, j'ai utilisé : 
- Java : 11
- sbt : 1.5.5
- scala 2.12.20
- spark : 3.x

\
**ToDo App.** \
Créer un fichier dans scr/main/resources/db/connection.txt avec comme contenu : username;password \
Il faut une base de données sur PostgreSQL
- Database : todo_app
- Schéma : todo_app
- Table : todo_list ("id", "name", "content", "created_date", "updated_date", "owner") avec id de type serial pour l'auto-incrément


