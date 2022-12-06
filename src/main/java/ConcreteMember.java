import UndoableStringBuilder.*;
public class ConcreteMember implements Member {

    private UndoableStringBuilder undoableStringBuilder;
    private String name;

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

    @Override
    public void handleEvent() {
        System.out.println("Dear " + name + ". There is some changes in StringBuilder: \n" + this.undoableStringBuilder);
    }
}

