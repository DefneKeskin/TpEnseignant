package champollion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Enseignant extends Personne {

    private final List<ServicePrevu> myServicePrevu = new LinkedList<>();
    private final Set<Intervention> intervention = new HashSet<>();
    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures
     * équivalent TD" Pour le calcul : 1 heure de cours magistral vaut 1,5 h
     * "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut
     * 0,75h "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int sommeHeure = 0;
        for (ServicePrevu s : myServicePrevu) {
            sommeHeure = (int) Math.round(sommeHeure + (s.getVolumeCM() * 1.5 + s.getVolumeTD() * 1 + s.getVolumeTP() * 0.75));
            //on ajoute la methode Math.round car sinon on se retrouve avec deux types incompatible : int et double
            
        }
        return sommeHeure;
    }

    public boolean enSousService() {
        boolean sousService = false;
        if (this.heuresPrevues() < 192) {
            sousService = true;
        }
        return sousService;
        /*service annuelle 192
        si en dessoous je suis en sous service */
        // TODO: Implémenter cette méthode
    }

    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        int sommeHeure = 0;
        for (ServicePrevu s : myServicePrevu) {
            //pour le ue donné en paramètre 
            if (s.getUe() == ue) {
                sommeHeure = (int) Math.round(sommeHeure + (s.getVolumeCM() * 1.5 + s.getVolumeTD() * 1 + s.getVolumeTP() * 0.75));
            }
        }
        return sommeHeure;
    }

    public void ajouteIntervention(Intervention inter) {
        // TODO: Implémenter cette méthode
        intervention.add(inter);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE
     * spécifiée en "heures équivalent TD" Pour le calcul : 1 heure de cours
     * magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent
     * TD" 1 heure de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu s = new ServicePrevu(volumeCM, volumeTD, volumeTP, this, ue);
        myServicePrevu.add(s);
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        int sommePlanifier = 0;

        for (Intervention inter : intervention) {
            if (inter.getTypeIntervention().equals(type) && inter.getUe().equals(ue)) {
                sommePlanifier += inter.getDuree();
            }
        }

        for (ServicePrevu s : myServicePrevu) {
            if (s.getUe().equals(ue)) {
                switch (type) {
                    case TP:
                        sommePlanifier -= s.getVolumeTP();
                    case TD:
                        sommePlanifier -= s.getVolumeTD();
                    case CM:
                        sommePlanifier -= s.getVolumeCM();
                        break;
                }
            }

        }
        return (int) sommePlanifier;

    }

}
