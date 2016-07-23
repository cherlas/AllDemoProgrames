package No1;

/**
 * Created by Yogurt on 16/7/23.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
