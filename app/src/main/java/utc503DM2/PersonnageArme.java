package utc503DM2;

class PersonnageArme extends Personnage {

  public PersonnageArme(String nom){
    super(nom);
  }

  public PersonnageArme(String nom,int pv, int classeArmure){
    super(nom,pv,classeArmure);         
  }
   
 
  public boolean attaque(final Personnage adversaire){
    System.out.println(" depuis classe PersonnageArme ");
    if((new LanceDe()).getDe20() >  adversaire.getClasseDArmure()){
    int degats = this.getArme().getPointsDeDegats();
    int bonusAttaque = this.getArme().getBonusAttaque();
    adversaire.recoitDommage(degats+ bonusAttaque);
    System.out.print( "l arme inflige " + degats +
                      " plus " + bonusAttaque + " de bonus d'attaque");
      return true;  
    }
    return false;
  }

  /**
  * accesseur de l'arme
  * @return l'arme utilisée 
  */
  public Arme getArme(){
    return new Arme((int) (Math.random()*11));
  }
   
 @Override
  public String toString(){
    return "<" + super.getNom()+ " armé : "+ super.getPointDeVie() +">";
  }
 
}