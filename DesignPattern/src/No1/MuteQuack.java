package No1;

/**
 * Created by Yogurt on 16/7/23.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Silence");
    }
}
