import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 *
 * Class Injector implements dependency injection into any object that contains fields marked with an annotation @AutoInjectable
 */
public class Injector <T>{
    /**
     * Reference to the configuration object
     */
    private final Properties properties;

    /**
     * Class constructor
     * @param pathToProperties path to file
     * @throws IOException exception that is thrown when an I/O error occurs
     */
    Injector(String pathToProperties) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(pathToProperties)));
    }

    /**
     * Inject accepts an object, examines it for fields with an AutoInjectable annotation
     * If there is such field, looks in the injection.properties file for implementation
     * @param object object of any class
     * @return object with initialized fields with an AutoInjectable annotation
     */
    T inject(T object) throws IOException, IllegalAccessException, InstantiationException {

        Class dependency;
        Class cl = object.getClass();

        Field[] fields = cl.getDeclaredFields();
        for (Field field: fields){

            Annotation a = field.getAnnotation(AutoInjectable.class);
            if (a != null){

                String[] fieldType = field.getType().toString().split(" ");
                String equalsClassName = properties.getProperty(fieldType[1], null);

                if (equalsClassName != null){

                    try {
                        dependency = Class.forName(equalsClassName);

                    } catch (ClassNotFoundException e){
                        System.out.println("Not found class for " + equalsClassName);
                        continue;
                    }

                    field.setAccessible(true);
                    field.set(object, dependency.newInstance());
                }
                else
                    System.out.println("Not found properties for field type " + fieldType[1]);
            }
        }
        return object;
    }

}
