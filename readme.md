# Pour démarrer

## récupértion du projet
Pour récupérer le projet : 
- Ouvrez un terminal, 
- Placez vous dans le répertoire désiré puis lancez la ligne de commande suivante : 
 
		git clone https://github.com/stual37/oc-p11-backend.git

## Lancement
- Ouvrez un terminal, 
- placez vous dansle répertoire du projet,
- Lancez la ligne de commande suivante : 
	
		./mvnw install
		
### Execution :
- Lancez :
	
		java -jar target/backend-0.0.2-exec.jar

Une fois le projet compillé il doit se lancer sur le port 9001
  
## accès à la base de données
Il est possible d'accéder à la base de données  avec : 
	[http://127.0.0.1:9001/h2-console](http://127.0.0.1:9001/h2-console)

À la ligne JDBC URL, placez :

		jdbc:h2:mem:medhead

- User name : sa
- mot de passe : sa

## Accès à l'interface de l'API
Il est possible d'accéder à la documentation technique de l'API via : [http://127.0.0.1:9001/api.doc.html](http://127.0.0.1:9001/api/doc.html)

Il est possible de tester son focntionnement soit par :
- curl avec par exemple [http://127.0.0.1:9001/specialities](http://127.0.0.1:9001/specialities),
- soit avec postamn et en utilisant les url expliqués dans la documentation
  

## Stratégie du workflow

Le workflow comprend 5 branches :
- Master : La branche principale, elle ne doit pas être modifié directement et doit rester 'saine'.
- develop : Branche principale servant pour le développement, il faut ensuite réaliser depuis cette branche une pull request vers la branche Master afin de faire les mises à jours des parties développés.
- feature : Branche servant à développer des fonctionnalités supplémentaires, elle doit ensuite pousser vers la branche develop une fois validé
- htofix : Branche servant à corriger des bugs,
- release : Branche servant à réaliser les versions qui seront ensuites compilé pour la mise en production.
 

## Tests sous JMeter
- Téléchargez  JMeter de puis le lien suivant : [https://jmeter.apache.org/download_jmeter.cgi](https://jmeter.apache.org/download_jmeter.cgi)
- Depuis un terminal, lancez JMeter avec la ligne de commande suivante : 
	
		java -jar ApacheJMeter.jar

- Dans la fenêtre qui s'ouvre cliquez sur "Ouvrir", puis sélectionnez le fichier "backend-tests-plan.jmx" fourni avec le projet.
- Cliquer sur le bouton "Lancer".
 
 
## Intégration à la CI-CD

 Un fichier Jenkinsfile est diponible.
 Il comprend la configuration qui devra être utilisé ppur la mise en place de la CI-CD dans Jenkins.
 Pour utiliser Jenkins, il suffit de récupérer une image dans docker hub avec : 

        docker pull jenkins/jenkins

Execuer ensuite Jenkins depuis une ligne de commande avec 

        docker run jenkins/jenkins:latest

Un mot de passe pour l'utilisateur admin sera alors crée et fourni, il suffit de le copier et de le sauvegarder.
Ce mot de passe changera à chaque fois que la machine sera créée.

Dans un navigateur lancer : 

        [http://localhost:8080/](http://localhost:8080/)

Jenjkins ser à ce moment disponible,il suffit d'entrer admin comme utilisateur et le motde passe qui a été fournis au moment du lancement de l'image docker.

Pour utiliser ensuite la CI-CD, dans Jenkins, il faut  : 
- Depuis le tableau de bord cliquer à gauche sur "Nouveau item",
- donner un nom (ex.: backend),
- Choisir Pipeline,
- Cocher "GitHub project", et lui aissigner le lien du projet (ici : https://github.com/stual37/oc-p11-backend.git),
- Au niveau de Pipeline choisir "Pipeline script From SCM",
- Entrer sur SCM à nouveau l'URL entré précédement (soit : https://github.com/stual37/oc-p11-backend.git),
- Laisser le reste par défaut,
- Sauvegarder.
        
Ensuite, il suffit de cliquer sur " Lancer un Build".


### CI-CD groupé
À ce niveau la CI-CD des deux parties du projet sont indépendante l'une de l'autre.
Pour les regrouper, il faut dans un premeir temps installe NodeJS sur surJenkins.

Pour cela il faut cliquer sur 'Administrer Jenkins', puis 'Plugoins' dans 'Plugins disponible' rechercher 'NodeJs', sélectionner et lancer son installation.

Il y a plus d'information concernant cette partie sur :  [https://plugins.jenkins.io/nodejs/](https://plugins.jenkins.io/nodejs/)

 Ensuite: 
- Au niveau de la configuration de la pipeline, il faut cliquer sur "configurer".
- Puis en bas de page au niveau de "Pipeline", cliquer sur "Add repository",
- Ajouter l'URL de la repository du frontend (soit : https://github.com/stual37/oc-p11-frontend.git),
- Enfin Sauvegarder.
 
 
