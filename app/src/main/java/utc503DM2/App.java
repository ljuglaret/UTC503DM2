
package utc503DM2;
public class App {
    public static void main(final String[] args){

        PersonnageArme testarme = new PersonnageArme("PersoArme1", 10, 10);
        Personnage test_ = new PersonnageArme("PersoArme2");
        final Arene arene = new Arene(testarme,test_);
        arene.combat();

    }
}
  