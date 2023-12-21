public class Cleaner extends Personal{
    public Cleaner(String age, String name,String job) {
        super(age, name, job);
    }

    /**
     * смс о продолжении работы
     * @return
     */
    public String contWork(){
        return super.getAge()+super.getName()+ getJob() + work;
    }

    /**
     * смс о конце работы
     * @return
     */
    public String EndWork(){
        return super.getAge()+super.getName()+getJob()+ " уже " + endwork;
    }
}
