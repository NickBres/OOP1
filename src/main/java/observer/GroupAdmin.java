package observer;

import java.util.ArrayList;
import java.util.List;
import UndoableStringBuilder.*;

public class GroupAdmin implements Sender{

    private UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder();// expanded StringBuilder class with history of changes and last edited String
    private ArrayList <ConcreteMember> members = new ArrayList<>();// list of members to notify


    /**
     * Wrap of UndoableStringBuilder.append
     * @param str
     */
    public void appendString(String str){
        this.undoableStringBuilder.append(str);
        notifyMembers();
    }
    /**
     * Wrap of UndoableStringBuilder.delete
     * @param start
     * @param end
     */
    public void deleteString(int start, int end){
        this.undoableStringBuilder.delete(start,end);
        notifyMembers();
    }
    /**
     * Wrap of UndoableStringBuilder.insert
     * @param offset
     * @param str
     */
    public void insertString(int offset, String str){
        this.undoableStringBuilder.insert(offset,str);
        notifyMembers();
    }
    /**
     * Wrap of UndoableStringBuilder.undo
     */
    public void undo(){
        this.undoableStringBuilder.undo();
        notifyMembers();
    }
    /**
     * Wrap of UndoableStringBuilder.replace
     * @param start
     * @param end
     * @param str
     */
    public void replaceString(int start, int end, String str){
        this.undoableStringBuilder.replace(start,end,str);
        notifyMembers();
    }
    /**
     * Wrap of UndoableStringBuilder.reverse
     */
    public void reverseString(){
        this.undoableStringBuilder.reverse();
        notifyMembers();
    }
    /**
     * Add new member to list of members
     * @param name
     */
    @Override
    public void addMember(String name) {
        this.members.add(new ConcreteMember(this.undoableStringBuilder,name));
    }
/**
     * Remove member from list of members
     * @param name
     */
    @Override
    public void removeMember(String name) {
        for (ConcreteMember member : this.members) {
            if (member.getName().equals(name)) {
                this.members.remove(member); // remove member from list
                member.free(); // free resources
                break;
            }
        }
    }

    /**
     * Notify all members about changes
     */
    @Override
    public void notifyMembers() {
        for (ConcreteMember member : this.members) {
            member.handleEvent(); // notify member
        }
    }
}
