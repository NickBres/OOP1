import UndoableStringBuilder.UndoableStringBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Junit test class for UndoableStringBuilder
 * Main purpose is to check undo function after each possible change
 * Not checking StringBuilder original functions
 * @author Nikita Breslavsky,Hen Dahan
 * 4.11.2022
 */
public class UndoableStringBuilderTest   {

    public static final Logger logger = LoggerFactory.getLogger(UndoableStringBuilderTest.class);


    UndoableStringBuilder usb = new UndoableStringBuilder();



    @BeforeEach
    void setUp() {
        usb.append("hello");
    }

    @Test
    public void test1(){ // used this test to understand how to use the JVM utilities
        logger.info(()->JvmUtilities.objectFootprint(usb));
        usb.append(" world!");
        logger.info(()->JvmUtilities.objectFootprint(usb));
        assertEquals("hello world!", usb.toString());
        usb.delete(0,5);
        logger.info(()->JvmUtilities.objectFootprint(usb));
        assertEquals(" world!", usb.toString());
        usb.insert(0,"Goodbye");
        logger.info(()->JvmUtilities.objectFootprint(usb));
        assertEquals("Goodbye world!", usb.toString());
        usb.undo();
        logger.info(()->JvmUtilities.objectFootprint(usb));
        assertEquals(" world!", usb.toString());
        usb.undo();
        logger.info(()->JvmUtilities.objectFootprint(usb));
        assertEquals("hello world!", usb.toString());
        usb.replace(0,5,"Hi");
        logger.info(()->JvmUtilities.objectFootprint(usb));
        assertEquals("Hi world!", usb.toString());
        usb.undo();
        logger.info(()->JvmUtilities.objectFootprint(usb));
        assertEquals("hello world!", usb.toString());

    }

    @Test
    public void testUndoWhenStackIsEmpty(){
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.undo();
        usb.undo();
        assertEquals("",usb.toString());
        usb.append("123");
        usb.undo();
        usb.undo();
        assertEquals("",usb.toString());

    }
    @Test
    public void testUndoCheck(){
        usb.append("world!");
        usb.undo();
        assertEquals("hello", usb.toString());
        usb.undo();
        assertEquals("", usb.toString());
    }
    @Test
    public void testAppendCheck(){
        //some comment
        assertEquals("hello",usb.toString());
        usb.append(" world");
        assertEquals("hello world",usb.toString());
        usb.append("!");
        assertNotEquals("hello world", usb.toString());
        usb.undo();
        assertEquals("hello world",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }
    @Test
    void deleteCheck(){
        usb.delete(0,3);
        assertNotEquals("hello",usb.toString());
        assertEquals("lo",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }
    @Test
    void insertCheck(){
        usb.insert(3," ");
        assertNotEquals("hello",usb.toString());
        assertEquals("hel lo",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }


    @Test
    void replaceCheck(){
        usb.replace(0,5,"bye");
        assertNotEquals("hello",usb.toString());
        assertEquals("bye",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }

    @Test
    void reverseCheck(){
        usb.reverse();
        assertNotEquals("hello",usb.toString());
        assertEquals("olleh",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }

}