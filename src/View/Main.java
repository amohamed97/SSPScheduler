package View;

import Controller.Controller;

public class Main {


    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        controller.makeSchedule();
        controller.getSchedule().printSchedule();

    }
}
