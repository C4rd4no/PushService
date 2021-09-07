import PushService.Push;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Push push = new Push();
/**/
        push.subscribe("3","Probaa", new String[]{"asd", "asad", "das","ttttt"},"IGNORE","asadaaasdaassadasdasd");

        push.addGroup("3","Probaa", new String[]{"Admin","Könyvelés"});

        push.createSchedule("Probaa","karbantartas", "asd", new Integer[]{1, 2, 3});

        push.createNotification("Probaa","karbantartas", "a", "a", "a", "a" , "a");

    }
}
