import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";
        /*
         compute the size of a single objects,including padding,header,references
         and referenced objects' sizes.
         the total size,i.e., deep size of the object is denoted by (total)
         */
        logger.info(()->JvmUtilities.objectFootprint(s1));
        /*
         compute the size of multiple objects including their components
         and referenced objects' sizes.
         the total size,i.e., deep size of the object is denoted by (total)
         */
        logger.info(()->JvmUtilities.objectFootprint(s1,s2));
        // compute only the total size of s1
        logger.info(()->JvmUtilities.objectTotalSize(s1));
        logger.info(JvmUtilities::jvmInfo);
    }
}
