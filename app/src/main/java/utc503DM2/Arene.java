package utc503DM2;

class Arene{

  Personnage p1;
  Personnage p2;
  Personnage vainqueur;

  Arene(Personnage p1,Personnage p2){
    this.p1 = p1;
    this.p2 = p2;
  }

  /**
   * Accesseur du dernier vainqueur
   * @return le dernier vainqueur
   */
  public Personnage getDernierVainqueur(){
    if (p1.estVivant() && p2.estVivant()){
      return null; 
    }
    else{
        if(p1.getPointDeVie() > 0) {
      return p1;
    }
    else{
      return p2;
    }
    }
    
  }

  /**
   * Accesseur du dernier perdant
   * @return le dernier perdant
   */
  public Personnage getDernierPerdant(){
    if (p1.estVivant() && p2.estVivant()){
      return null;
    }
    else{
      if(p1.getNom().equals(getDernierVainqueur().getNom())){
        return p2;
      }
      else{
        return p1;      
      }
    }
  }

  
/**
 * Combat entre deux personnages 
 */
  public void combat(){
/*
  * Vérifier que l'on a 2 combattants initialement vivants.
  */
    System.out.println("Combat à mort entre "+this.p1+" et "+this.p2);
/*
  * Tant que les 2 personnages sont vivants on fait combattre les
  * adversaires l'un après l'autre.
  */
    while( this.p1.estVivant() && this.p2.estVivant()){
/*
  * p1 frappe p2 si il le touche on indique un message sur la console.
  */
        System.out.print(this.p1.getNom()+" attaque "+this.p2.getNom());
      if( this.p1.attaque(this.p2) ){
        System.out.println("... le coups porte");
      }
      else{
        System.out.println("... le coups rate");
        }
    System.out.println("Fin du tour : "+this.p1+" "+this.p2 + "\n");

      Personnage ptemp;
      ptemp = p2;
      p2 = p1;
      p1 = ptemp;
    }
/*
  * On désigne le vainqueur.
  */
    if(p1.estVivant()){
      vainqueur = this.p1;    
    }
    else{
      vainqueur = this.p2;
    }
    System.out.println(this.vainqueur+" sort vainqueur");
    }
}
  
  
  
