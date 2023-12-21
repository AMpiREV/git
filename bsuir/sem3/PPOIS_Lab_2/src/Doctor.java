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

    /**
     *
     * @return возвращает профессию
     */
    public String getProfession() {
        return profession;
    }

    /**
     * проверяет свободен ли врач
     * @return смс о занятости
     */
    public String Isfree() {
        if(isfree){
            sms = "Врач свободен";
        }else if(!isfree){
            sms =  "Врач занят";
        }
        return sms;
    }

    /**
     *
     * @return справка с именем и подписью
     */
    public String write_letter(){
        letter = ("Справка о болезни, от " + getName() + "подпись");
        return letter;
    }

    /**
     * выводит инфу о докторе
     * @return
     */
    public String fu(){
        return "я " +profession+ " " + super.getName() + " " + super.getAge();
    }
}