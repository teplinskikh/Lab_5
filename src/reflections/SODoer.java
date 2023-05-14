package reflections;

/**
 * Class inherits class SomeOtherInterface
 */
public class SODoer implements SomeOtherInterface {
    /**
     * Overriden method from SomeOtherInterface
     */
    @Override
    public void doSome() {

        System.out.println("C");
    }
}
