package DesignPattern.CreationalPatterns.BuilderPattern.Problem;

public class WithoutBuilderPattern {
    public static void main(String[] args) {
        /**
         * So when ever i will need to create House class object that time i will be forced to pass
         * all param.
         *
         * */
        House house=new House("Anuj_House","Medium","Blue",true,false,true,true,"Large");
        System.out.println(house);
    }
}
