package No1;

/**
 * Created by Yogurt on 16/7/23.
 */
public abstract class Duck {

    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;
    public void swim(){
        System.out.println("All ducks float,even decoys");
    }
    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }
}
