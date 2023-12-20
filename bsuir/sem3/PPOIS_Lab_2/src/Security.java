public class Security extends Personal{
    boolean pass;
    String messege;
    public Security(String age, String name,String job) {
        super(age, name, job);
    }
    public String patient_pass(boolean passport){
        if(passport) pass = true;
        if(pass) messege ="Пациент вошёл в поликлинику";
        return messege;
    }
}
