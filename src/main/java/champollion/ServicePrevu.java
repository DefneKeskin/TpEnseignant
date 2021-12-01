package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    private Enseignant enseignant;
    private UE ue;


    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, Enseignant enseignant, UE ue) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.enseignant = enseignant;
        this.ue = ue;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public UE getUe() {
        return ue;
    }
    
    
    
    

}
