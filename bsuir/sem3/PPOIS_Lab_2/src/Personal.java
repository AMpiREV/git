public class Personal extends Human{
    private String job;
    String work = "выполняет работу";
    String endwork = "закончил работу";
    public Personal(String age, String name,String job){
        super(age,name);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    /**
     * сообщение о окончании работы
     * @return
     */
    public String EndWork(){
        return super.getAge()+super.getName() + endwork;
    }

    /**
     * сообщение об продолжении работы
     * @return
     */
    public String contWork(){
        return super.getAge()+super.getName() + work;
    }
}
