package Hospital.model.entity;

public class Patient {
    private long id;
    private String name;
    private String family;

    private String typeOfIllness;

    private String receptionDate;

    private String Doctor;

    public long getId() {
        return id;
    }

    public Patient setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Patient setFamily(String family) {
        this.family = family;
        return this;
    }
    public String gettypeOfIllness(){
        return typeOfIllness;
    }

    public Patient settypeOfIllness(String typeOfIllness){
        this.typeOfIllness = typeOfIllness;
        return this;
    }

    public String getreceptionDate(){
        return receptionDate;
    }
    public Patient setreceptionDate(String receptionDate){
        this.receptionDate = receptionDate;
        return this;
    }
    public String getDoctor(){
        return Doctor;
    }
    public Patient setDoctor(String Doctor){
        this.Doctor = Doctor;
        return this;
    }
}
