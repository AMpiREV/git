public class Surgeon extends Doctor{
    private boolean agreement;
    private String recomendation;
    public Surgeon(String age, String name, String prof, boolean isfree, boolean agreement){
        super(age, name, prof, isfree);
        this.agreement = agreement;
    }

    /**
     *
     * @return вывод смс о рекомендации о наложении гипса
     */
    public String rec(){
        recomendation = "надо наложить гипс";
        return recomendation;
    }

    /**
     * при вызове функции хирург спрашивает о том налаживать гипс или нет
     * @return
     */
    public boolean giveaccess(){
        agreement = true;
        return agreement;
    }

}
