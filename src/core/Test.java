package core;

import model.Human;
import service.HumanService;

public class Test {
    public static void main(String[] args) {
        HumanService humanService = new HumanService();
        Human[] humans = new Human[3];
        for (int i = 0; i < 3; i++) {
            humans[i] = humanService.create();
        }
        humanService.after2000(humans);
    }
}
