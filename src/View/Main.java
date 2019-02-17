package View;

import Controller.Controller;

public class Main {


    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        Controller controller = new Controller();
        controller.makeSchedule();
        controller.getSchedule().printSchedule();
        for (int i = 0; i < controller.getAlternatives().size(); i++) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
                    "------------------------------------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            controller.getAlternatives().get(i).printSchedule();
        }

        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);

    }
}
