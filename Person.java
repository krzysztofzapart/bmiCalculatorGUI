package sample;

public class Person {
    protected static final double A_1 = 457.0;
    protected static final double A_2 = 414.2;
    protected static final double B_1 = 495.0;
    protected static final double B_2 = 450.0;


    private static final double ONE = 1.1093800;
    private static final double TWO = 0.0008267;
    private static final double THREE = 0.0000016;
    private static final double FOUR = 0.0002574;

    protected int age;
    protected int chest;
    protected int waist;
    protected int thigh;
    protected int sumary;
    protected double bodyDensity;
    protected double bodyFat;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChest() {
        return chest;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getThigh() {
        return thigh;
    }

    public void setThigh(int thigh) {
        this.thigh = thigh;
    }

    public Person(int age, int chest, int waist, int thigh) {
        this.age = age;

        this.chest = chest;
        this.waist = waist;
        this.thigh = thigh;
        this.sumary=chest+waist+thigh;
        this.bodyDensity=setDensity();
        this.bodyFat=setBodyFat();
    }

    private double setDensity(){

        double two=TWO*sumary;
        double three=THREE*sumary*sumary;
        double four = FOUR*age;



        double density = ONE-two+three-four;


        return density;


    }


    private double setBodyFat(){


        double body1=(A_1/bodyDensity)-A_2;
        double body2=((B_1/bodyDensity)-B_2);
        double bodyFat=((body1+body2)/2);

        return bodyFat;


    }

    public String getBodyFat() {

        String fat = String.valueOf(bodyFat);
        return fat;
    }
}