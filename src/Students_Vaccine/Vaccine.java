package Students_Vaccine;

import java.io.Serializable;

public class Vaccine implements Serializable {

    private String VaccineID;
    private String Vaccinename;

    public Vaccine() {

    }

    public Vaccine(String VaccineID, String Vaccinename) {
        this.VaccineID = VaccineID;
        this.Vaccinename = Vaccinename;
    }

    public String getVaccineID() {
        return VaccineID;
    }

    public String getVaccinename() {
        return Vaccinename;
    }

    public void setVaccineid(String VaccineID) {
        this.VaccineID = VaccineID;
    }

    public void setVaccinename(String Vaccinename) {
        this.Vaccinename = Vaccinename;
    }

    @Override
    public String toString() {
        return VaccineID + ", " + Vaccinename;
    }
}
