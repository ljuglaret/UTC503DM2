
  On va tout définir dans le même fichier, bien que cela soit peu recommandé,
  c'est tout à fait possible en particulier pour cet exercice puisque seule la
  classe possédant la méthode main() doit être connue à l'extérieur pour
  pouvoir lancer le jeu.
  Si vous utilisez la plateforme repl.it il suffira de copier cet embryon de
  code dans le fichier Main.java.
 
  https:replit.com
 
  On veut simuler un combat pour un jeu de rôle, dont les personnages ont les
  attributs principaux suivants :
   - un nom (une chaîne de caractères) ;
   - un nombre de points de vie (initialement un entier positif) ;
   - une classe d’armure (un entier entre 1 et 20) ;   

  Pour frapper un adversaire, on doit jeter un dé à 20 faces.   
  Si le dé est
  supérieur à la classe d’armure de l'adversaire, le coups est réussi, et on
  retire à l'adversaire 1 point de vie.   
  
  On étendra ensuite cela avec des personnages armés. Ces personnages auront
  la possibilité de porter une arme et donc disposeront d'un bonus d'attaque
  et d'une capacité de dommage accrue (>= 1 en fonction de l'arme) apportés
  par l'arme.
 
 
# Lance De
  La classe LanceDe permet de simuler un lancer de dé aléatoire équiprobable
  entre N faces (6 ou 20).
  La classe LanceDe est écrite uniquement pour proposer des méthodes de tirage
  de dés, basées sur la méthode Math.random(). Cela évitera de recopier le
  code de tirage de dé partout dans notre code.
 
  Cette première méthode permet de simuler un lancer de dé à n faces où n est
  le paramètre de la méthode.
  Cette méthode est privée car on ne souhaite pas qu'elle soit accessible
  à l'extérieur de cette classe. Ce n'est pas une obligation mais cela
  évite de pouvoir simuler des tirages de dés étranges avec par exemple 0
  faces, ou un nombre négatif de faces. Alors on pourrait se dire qu'on
  pourrait vérifier une précondition pour garantir un fonctionnement cohérent.
  C'est vrai mais cela engendrerait un test supplémentaire rendant la méthode
  inefficace. En gardant cette méthode privée, on s'évite ce travail en
  faisant en sorte que seules des méthodes contrôlées effectuent les tirage.
  Cette méthode permet surtout de factoriser le code entre plusieurs méthodes
  réalisant la même opération.
  Cela rend le code plus facile à maintenir en évitant par exemple de devoir
  répercuter à plusieurs endroits difrandomférents un éventuelle modification de
  l'utilisation de la méthode Math.random(). Par exemple, si on voulait
  modifier le profil du tirage aléatoire (Gauss, Poisson...).
 
 # Personnage 
  ## Les champs :
  À vous de choisir les variables d'instance qui caractérisent l'état d'un
  personnage.
  On rappelle ici que 3 propriétés de base vont aider à définir l'état :
   - le nom du personnage
   - le nombre de point de vie
   - la classe d'armure
 

   
  ## Les constructeurs : 
  Nous allons maintenant écrire des constructeurs pour la classe Personnage.
  Ces constructeurs vont permettre d'instancier des objets de la classe
  Personnage.
  On doit pouvoir lui donner un nom et on va supposer que les autres
  caractéristiques du personnage c'est à dire ses points de vie sont obtenus
  par le cumul du tirage aléatoire de deux dés à 6 faces. Tandis que la classe
  d'armure est obtenue par un tirage aléatoire de dé à 20 faces.
  mais on doit pouvoir également spécifier ces autres caractéristiques
  éventuellement à la construction de l'objet.
 

 
  ## Les méthodes :
 
  ### Les accesseurs :
  On souhaite pouvoir accéder à certaines propriétés du personnage :
   - son nom
   - sa classe d'armure
   - et son nombre de points de vie.
  Le principe de responsabilité des classes nous conduit à ne considérer que
  des getteurs. Expliquez pourquoi en commentaire.
 
 ### ToString()
  La méthode toString() est une méthode de la classe java.lang.Object qui est
  la classe mère directe ou indirecte de toute classe en Java. La méthode
  toString() est une méthode très importante en Java car elle associe à toute
  instance d'un objet une représentation sous la forme d'une chaîne de
  caractères. Cette méthode est d'autant plus importante qu'elle est appelée
  automatiquement (sans avoir besoin de le faire explicitement) chaque fois
  que l'on concatène un objet avec une chaîne ou chaque fois que l'on utilise
  un objet quelconque à la place d'une chaîne de caractères.
  Comme on souhaite redéfinir cette méthode dans la classe Personnage, il est
  recommandé d'ajouter l'annotation @Override juste avant la redéfinition de
  la méthode pour que le compilateur puisse vérifier que l'on est bien en
  train de faire une redéfinition d'une méthode existante dans la classe mère.
  Si par exemple, on se trompe dans le nom de la méthode ou dans ses
  paramètres, le compilateur pourra détecter cette erreur et nous la signaler.
  Sinon en l'absence de l'annotation @Override il ne produirait aucune erreur.   

  On utilisera le format de chaîne suivant :
  < nom_du_personnage : nb_de_pts_de_vie_restant >   
  
  Cette méthode permettra de construire les messages correspondant aux
  différentes phases de combat et de suivre l'évolution de ce dernier.
 

 # Arme

  La classe Arme contient les caractéristiques d'une arme.   
  
  Une arme peut-être
  vue comme une simple structure dotée d'accesseurs.   
  On peut ajouter cependant
  une méthode infligerDegat() qui permettra à une Arme d'appliquer des dégats
  à un personnage. On la dote ainsi d'un aspect comportemental.
 
  
  ## Les champs :
  On définira l'état d'un instance de type Arme à partir de la propriété de
  l'objet, bonus d'attaque obtenu par un jet de dé 6 faces. Une arme pourra
  également infliger un nombre de points de dégats tiré de façon aléatoire
  équiprobable au moyen d'un dé à 6 faces. Ce nombre sera ramené en dessous
  d'une autre propriété de l'arme : un nombre maximal de dégats (obtenu par un
  tirage de dé 6 face).
 Une arme pourra
  également infliger un nombre de points de dégats tiré de façon aléatoire
  équiprobable au moyen d'un dé à 6 faces. Ce nombre sera ramené en dessous
  d'une autre propriété de l'arme : un nombre maximal de dégats 
 
  ## Les constructeurs :
  A la création d'une arme les propriétés bonus d'attaque et dégats max
  doivent être fixées.
 
  ## Les méthodes :
  Pensez à définir ### Les accesseurs ou d'autres méthodes permettant de faciliter
  l'interaction de l'arme et du personnage armé en ayant en tête la notion des
  responsabilité des objets et d'encapsulation. Cependant, privilégiez
  toujours les solutions simples et fonctionnelles.
 
 
# Personnage Arme

  La classe PersonnageArme implémente un personnage avec une arme.  

  Elle redéfinira un certain nombre de méthodes pour les adapter, comme par
  exemple une nouvelle implémentation de la méthode attaque().   

  On ajoutera également le texte armé dans la chaîne de caractère qui lui
  est associé.

 # Arène
 
  ## Les champs :
  On définira l'état d'une instance de type Arene qui gère essentiellement les
  combatants.
 

 
  ## Les constructeurs :
  A la création d'une Arene on peut recevoir les combattants en paramètre.
 
  ## Les méthodes :
 
  ### Les accesseurs:
  Une arène doit pouvoir fournir le vainqueur et le perdant du dernier combat.   

 ### Le combat
  La méthode combat() gère le combat.
 