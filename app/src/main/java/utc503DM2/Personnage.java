package utc503DM2;

class Personnage {

  private String nomPersonnage ;
  private  int nbPointsDeVie;
  private int classeArmure;

  public Personnage(String nomPersonnage){
    this.nomPersonnage = nomPersonnage;
    this.nbPointsDeVie = (new LanceDe()).getDe6() + (new LanceDe()).getDe6();
    this.classeArmure = (new LanceDe()).getDe20();
  }

  public Personnage(String nomPersonnage, int nbPointsDeVie, int classeArmure){
    this.nomPersonnage = nomPersonnage;
    this.nbPointsDeVie = nbPointsDeVie;
    this.classeArmure = classeArmure;
  }

  /**
  * accesseur Nom
  * @return nom du personnage 
  */
  public String getNom() {
    return nomPersonnage;
  }

    /**
  * accesseur classe d'armure
  * @return classe d'armure 
  */
  public int getClasseDArmure() {
    return classeArmure;
  }

/**
 * accesseur points de vie
 * @return points de vie
 */
  public int getPointDeVie() {
    return nbPointsDeVie;
  }


/**
 * La méthode estVivant() retourne une valeur booléenne permettant de savoir
 * si le personnage est toujours vivant ou non.
 * @return vrai si le personnage est vivant, faux sinon
 */
  public boolean estVivant(){
      return nbPointsDeVie > 0;
  }

  /**
  * La méthode recoitDommage modifie son nombre de points de vie
  * en fonction de points de dommages reçus.
  * @param dmg
  */
  public void recoitDommage(final int dmg){
    int degats = this.nbPointsDeVie - dmg;
    if (degats >= 0 ){
        this.nbPointsDeVie = degats;
    }
    else {
        this.nbPointsDeVie = 0; 
    }
  }


  /**
  * La méthode attaque() permet à un personnage d'attaquer un personnage.
  * @param adversaire
  * @return vrai si le dé est supérieur à la classe d’armure de l'adversaire, faux sinon
  */
  public boolean attaque(final Personnage adversaire){
    System.out.println(" depuis classe Personnage ");
    if( (new LanceDe()).getDe20() > adversaire.getClasseDArmure()){
      adversaire.recoitDommage(1);
      return true;  
    }
    return false;
  }

  @Override
  public String toString(){
    return "<" + this.nomPersonnage+ " : "+ this.nbPointsDeVie +">";
  }
}