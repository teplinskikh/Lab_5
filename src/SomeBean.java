import reflections.SomeInterface;
import reflections.SomeOtherInterface;

/**
 * Class contains two annotations
 */

public class SomeBean {
    @AutoInjectable
    private SomeInterface someField;
    @AutoInjectable
    private SomeOtherInterface otherField;

    /**
     * Default Class constructor
     */
    public SomeBean() {}

    /**
     * Method that calls interface methods from fields with annotations
     */
    public void go(){
        someField.doSome();
        otherField.doSome();
    }
}
