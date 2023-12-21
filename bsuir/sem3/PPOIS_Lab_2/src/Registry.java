public class Registry extends Personal{
    String access;
    String patient_card;
    public Registry(String age, String name, String job){
        super(age,name,job);
    }

    /**
     *
     * @param num возраст
     * @param fname имя
     * @return инфа о карте пациента
     */
    public String card(String num, String fname){
        patient_card = "карта пациента "+num+fname;
        return patient_card;
    }

    /**
     * даёт доступ пациенту идти после сдачи карты
     * @param patient_card
     * @return смс о том что пациент может идти
     */
    public String giveAccess(String patient_card){
        access = getName()+getJob()+"пациент может идти к врачам";
        return access;
    }

    /**
     *
     * @return смс об окончании работы регистратуры
     */
    public String EndWork(){
        return super.getAge()+super.getName()+getJob() + endwork;
    }
}
