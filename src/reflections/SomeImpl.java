package reflections;

/**
 * Class inherits class SomeInterface
 */
public class SomeImpl implements SomeInterface {
    /**
     * Overriden method from SomeOtherInterface
     */
    @Override
    public void doSome() {

        System.out.println("A");
    }
}
