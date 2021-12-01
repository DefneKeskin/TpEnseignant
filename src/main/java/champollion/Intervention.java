/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author defne
 */
public class Intervention {

    private Date debut;
    private int duree;
    private boolean annulee;
    private int heureDebut;
    private final TypeIntervention intervention;
    private UE ue;
    private final Salle salle;

    public Intervention(Date debut, int duree, int heureDebut, TypeIntervention intervention, UE ue, Salle salle) {
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.intervention=intervention;
        this.ue = ue;
        annulee = false;
        this.salle = salle;
        
    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getTypeIntervention() {
        return intervention;
    }

    public UE getUe() {
        return ue;
    }
    
    

}
