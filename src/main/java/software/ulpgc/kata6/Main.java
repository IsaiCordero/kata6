package software.ulpgc.kata6;

import software.ulpgc.kata6.control.WebService;
import software.ulpgc.kata6.view.WorkingService;

public class Main {
    public static void main(String[] args) {
        WebService web = new WebService();
        new WorkingService(8080, web).start();
    }
}
