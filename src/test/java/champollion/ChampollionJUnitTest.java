package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {

    Enseignant untel, untel2;
    UE uml, java;
    Intervention interCM, interTD, interTP;

    @BeforeEach
    public void setUp() {
        untel = new Enseignant("untel", "untel@gmail.com");
        uml = new UE("UML");
        java = new UE("Programmation en java");
    }

    @Test
    public void testNouvelEnseignantSansService() {
        assertEquals(0, untel.heuresPrevues(),
                "Un nouvel enseignant doit avoir 0 heures prévues");
    }

    @Test
    public void testAjouteHeures() {
        // 10h TD pour UML
        untel.ajouteEnseignement(uml, 0, 10, 0);

        assertEquals(10, untel.heuresPrevuesPourUE(uml),
                "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

        // 20h TD pour UML
        untel.ajouteEnseignement(uml, 0, 20, 0);

        assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

    }

    @Test
    public void testheuresPrevues() {
        untel.ajouteEnseignement(uml, 0, 4, 0);
        assertEquals(4, untel.heuresPrevues(), "L'enseignant doit avoir 4h d'heures prevues");
    }

    @Test
    public void testEnSousService() {
         untel.ajouteEnseignement(java, 0, 191, 0);
        assertTrue(untel.enSousService(), "L'enseignant est  en sous service");
        
        untel.ajouteEnseignement(uml, 0, 193, 0);
        assertFalse(untel.enSousService(), "L'enseignant n'est pas en sous service");

       
    }

    /*public void testAjouteEnseignement() {
        untel.ajouteEnseignement(uml, 0, 20, 0);
    }*/

    @Test
    public void testResteAPlanifier() {
        int sommePlannifie = 0;
        assertEquals(0, sommePlannifie, "Il doit être à 0");

    }

}
