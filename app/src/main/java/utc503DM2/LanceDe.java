package utc503DM2;


class LanceDe {

  private static int deNFaces(final int n){
    return (int) (Math.random()*n+1);
  }


/**
 * Simulation d'un lancer de dé à 20 faces
 * @return un entier entre 1 et 20
*/
  public static int de20(){
    return deNFaces(20);
  }

  /**
   * Simulation d'un lancer de dé à 6 faces
   * @return un entier entre 1 et 6
  */
  public  static int de6(){
    return deNFaces(6);
  }

  public int getDe20(){
    return de20();
  }

  public int getDe6(){
    return de6();
  }

}
