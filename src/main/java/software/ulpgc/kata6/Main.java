package software.ulpgc.kata6;

import software.ulpgc.kata6.control.webBuilder;
import software.ulpgc.kata6.view.WorkingDaysService;

public class Main {
    public static void main(String[] args) {
        webBuilder web = new webBuilder();
        new WorkingDaysService(8080, web).start();
    }
}