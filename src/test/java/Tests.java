import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import observer.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    GroupAdmin groupAdmin = new GroupAdmin();
    String s1 = "Alice";
    String s2 = "Bob";
    // stub method to check external dependencies compatibility
    @BeforeEach
    void setUp() {
        groupAdmin.addMember(s1);
        groupAdmin.addMember(s2);
    }
    @AfterEach
    void testMemory(){
        logger.info(JvmUtilities::jvmInfo);
    }


    @Test
    public void testMemoryAddAndDeleteMembers(){
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.removeMember(s1);
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.removeMember(s2);
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
    }
    @Test
    public void testMemoryStringChanges(){
        groupAdmin.appendString("Hello");
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.appendString(" world!");
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.deleteString(0,5);
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.insertString(0,"Hello");
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.replaceString(0,5,"Goodbye");
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.reverseString();
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.undo();
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
        groupAdmin.undo();
        logger.info(() -> {
            return JvmUtilities.objectFootprint(new Object[]{groupAdmin});
        });
    }
}
