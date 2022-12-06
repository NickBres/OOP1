import java.util.ArrayList;
import java.util.List;
import UndoableStringBuilder.*;

public class GroupAdmin implements Sender{

    UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder();
    List<ConcreteMember> members = new ArrayList<>();

    public void appendString(String str){
        undoableStringBuilder.append(str);
        notifyMembers();
    }
    public void deleteString(int start, int end){
        undoableStringBuilder.delete(start,end);
        notifyMembers();
    }
    public void insertString(int offset, String str){
        undoableStringBuilder.insert(offset,str);
        notifyMembers();
    }
    public void undo(){
        undoableStringBuilder.undo();
        notifyMembers();
    }

    public void replaceString(int start, int end, String str){
        undoableStringBuilder.replace(start,end,str);
        notifyMembers();
    }

    public void reverseString(){
        undoableStringBuilder.reverse();
        notifyMembers();
    }
    @Override
    public void addMember(String name) {
        members.add(new ConcreteMember(this.undoableStringBuilder,name));
    }

    @Override
    public void removeMember(String name) {
        for (ConcreteMember member : members) {
            if (member.getName().equals(name)) {
                members.remove(member);
                break;
            }
        }
    }

    @Override
    public void notifyMembers() {
        for (ConcreteMember member : members) {
            member.setUndoableStringBuilder(this.undoableStringBuilder);
            member.handleEvent();
        }
    }
}
