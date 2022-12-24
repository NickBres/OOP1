package observer;

import UndoableStringBuilder.*;
public class ConcreteMember implements Member {

    private UndoableStringBuilder undoableStringBuilder;    // copy of extended StringBuilder
    private String name; // member name

    public ConcreteMember(UndoableStringBuilder undoableStringBuilder,String name) {
        this.undoableStringBuilder = new UndoableStringBuilder(undoableStringBuilder);
        this.name = name;
    }

    public void setUndoableStringBuilder(UndoableStringBuilder usb) {
        this.undoableStringBuilder = new UndoableStringBuilder(usb);
    }

    public String getName() {
        return this.name;
    }
    /**
     * Method to free resources
     */
    public void free(){
        this.undoableStringBuilder = null;
        this.name = null;
    }

    /**
     * Notify the member that the undoableStringBuilder has changed
     */
    @Override
    public void handleEvent() {
        System.out.println("_________________________________________________________________ \n" +
                "Dear " + name + ". There is some changes in String: \n" + this.undoableStringBuilder +
                "\n_________________________________________________________________");
    }
}

