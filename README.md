# Fredi MOBILE
## Réalisé par : 
* Alexis Lapeze
* Julien Pinet
* Clement Roussel

## Installation : 
* Récupérer le projet : 
```cmd
git clone https://github.com/m2l-limayrac/FrediMobile.git
````
* Installer easyPHP 17
* Créé un dossier nommé 'Fredy' dans le dossier eds-www de easyPHP et déplacer le fichier cloner à l'intérieur
* Récuperer le script SQL **fredi_plot3_structure** dans le dossier nommé **'sql'** et l'importer dans MySQL en **désactivant la verification des clés étrangère** du projet FREDI
* Récuperer le script SQL **fredi_plot3_data** dans le dossier sql et l'importer dans MySQL en **désactivant la verification des clés étrangère** du projet FREDI
* Si vous utilisez EasyPhp, merci de vérifier que mysql est à jour. Sinon :
```cmd
mysql-upgrade.exe -u root --force
```

* Installer Android studio
* Ouvrir le projet FREDI MOBILE.
* Mettre le poste sur le meme réseau que la tablette.
* Changer l'adresse IP dans le fichier MyAsyncTask.java et mettre celle du poste sur lequel le serveur web est installer.
* Executer le projet sur le support (tablette / smartphone). 

## Utilisation : 
* Login : 'simon.berbier@gmail.com' ou 'corentin.diolo@gmail.com'
* Tous les mots de passes sont : '1234'
