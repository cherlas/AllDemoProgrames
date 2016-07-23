package No1;

/**
 * Created by Yogurt on 16/7/23.
 */
public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("I'm a real Mallard Duck");
    }
    public MallardDuck(){
        flyBehavior=new FlyWithWings();
        quackBehavior=new Quack();
    }
}
