public class Registry extends Personal{
    String access;
    String patient_card;
    public Registry(String age, String name, String job){
        super(age,name,job);
    }
    public String card(String num, String fname){
        patient_card = "карта пациента "+num+fname;
        return patient_card;
    }
    public String giveAccess(String patient_card){
        access = getName()+getJob()+"пациент может идти к врачам";
        return access;
    }
    public String EndWork(){
        return super.getAge()+super.getName()+getJob() + endwork;
    }
}
