
package utc503DM2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class AppTest {
    Personnage test;
    Personnage test_;
    Personnage test2 ;
    PersonnageArme testarme;
    Arene arene;

    private static Personnage makePersonnage(final String nom){
        return (LanceDe.de6() > 3) ? new PersonnageArme(nom)
                                   : new Personnage(nom);
        }

    @BeforeEach
    public void initialisationPersos(){
        test        =   new Personnage("Test");
        test_       =   new PersonnageArme("Test arme");
        test2       =   new Personnage("Test2", 12, 8);
        testarme    =   new PersonnageArme("Test arme 2", 10, 10);
        arene       =   new Arene(makePersonnage("Beowulf")
                                    , makePersonnage("Grendel"));
    }

    @Test
    public void testConsVidePersonnage(){
        assertEquals(test.getNom(), "Test");
        assertTrue(test.getPointDeVie() > 0);
    }


    @Test 
    public void nouvelleInitialisationPersonnage(){
        test = new Personnage("Test", 14, 6);
        assertEquals(test.getNom(), "Test");
        assertEquals(test.getPointDeVie(),14);
        assertEquals(test.getClasseDArmure(),6);
    }

    @Test 
    public void testInitialisationPersonnage(){
        assertEquals(test2.getNom(), "Test2");
        assertEquals(test2.getPointDeVie(),12);
        assertEquals(test2.getClasseDArmure(),8);
    }

    @Test 
    public void testRecoitDommage(){
        test2.recoitDommage(1);
        assertEquals(test2.getPointDeVie(),11);
    }


    @Test
    public void testConsVidePersonnageArme(){
        assertEquals(test_.getNom(), "Test arme");
        assertTrue(test_.getPointDeVie() > 0);
        assertTrue( test_.getClasseDArmure() > 0 &&
                    test_.getClasseDArmure() <= 20);
    }
    @Test
    public void testConsSuperPersonnageArme(){
        assertEquals(testarme.getNom(), "Test arme 2");
        assertEquals(testarme.getPointDeVie() ,10);
        assertEquals(testarme.getClasseDArmure() ,10);
        assertTrue( testarme.getArme().getBonusAttaque() > 0 &&
                    testarme.getArme().getBonusAttaque() <= 6);
    }

    @Test
    public void testCombatArmeEtNonArme(){
        while(!testarme.attaque(test)){}
        assertTrue( testarme.getPointDeVie() > 7 &&
                    testarme.getPointDeVie() < 13);
    } 

    @Test 
    public void Arene(){
        assertNull(arene.getDernierVainqueur());
        assertNull(arene.getDernierPerdant());
        
        arene.combat();
        assertTrue( arene.getDernierVainqueur().getPointDeVie() > 0 &&
                    arene.getDernierPerdant().getPointDeVie() <= 0
        );
    }
}

