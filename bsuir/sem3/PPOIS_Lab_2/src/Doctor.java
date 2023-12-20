public class Doctor extends Human{

    private String profession;
    private boolean isfree;
    public String letter;
    private String sms;
    public Doctor(String age, String name, String profession, boolean isfree){
        super(age,name);
        this.profession = profession;
        this.isfree = isfree;
    }

    public String getProfession() {
        return profession;
    }

    public String Isfree() {
        if(isfree){
            sms = "Врач свободен";
        }else if(!isfree){
            sms =  "Врач занят";
        }
        return sms;
    }
    public String write_letter(){
        letter = ("Справка о болезни, от " + getName() + "подпись");
        return letter;
    }
    public String fu(){
        return "я " +profession+ " " + super.getName() + " " + super.getAge();
    }
}