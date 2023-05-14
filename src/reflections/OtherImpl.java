package reflections;

/**
 * Class inherits class SomeInterface
 */
public class OtherImpl implements SomeOtherInterface {
    /**
     * Override method from SomeInterface
     */
    @Override
    public void doSome() {

        System.out.println("B");
    }
}
