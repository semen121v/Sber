import hello.Greeter;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public  void  testMethod(){

        Greeter greeter = new Greeter();

        Assert.assertEquals(greeter.sayHello(), "Hello worlda!");
    }

}
