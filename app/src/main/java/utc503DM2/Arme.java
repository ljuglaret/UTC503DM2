package utc503DM2;

class Arme {

    private int bonusAttaque = (new LanceDe()).getDe6();
    private int degatsMax = (new LanceDe()).getDe6();
    private int pointsDeDegats;
  /*
   * Les constructeurs :
   * A la création d'une arme les propriétés bonus d'attaque et dégats max
   * doivent être fixées.
   */
    public Arme(int idArme){
  /*Une arme pourra
   * également infliger un nombre de points de dégats tiré de façon aléatoire
   * équiprobable au moyen d'un dé à 6 faces. Ce nombre sera ramené en dessous
   * d'une autre propriété de l'arme : un nombre maximal de dégats 
  */
      this.pointsDeDegats =(new LanceDe()).getDe6();
      if (this.pointsDeDegats > degatsMax){
        while(this.pointsDeDegats > degatsMax){
              this.pointsDeDegats = (new LanceDe()).getDe6();
        }
      }
    }
  
    public int getPointsDeDegats(){
        return pointsDeDegats;
    }
   
    public int getBonusAttaque(){
        return bonusAttaque;
    }
     public int getDegatsMax(){
        return degatsMax;
    }
    }