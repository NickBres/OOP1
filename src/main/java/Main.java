public class Main {

    public static void main(String[] args){
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.appendString("Hello");
        groupAdmin.appendString(" World");
        groupAdmin.appendString("!");

        groupAdmin.addMember("John");
        groupAdmin.addMember("Mary");

        groupAdmin.deleteString(0, 5);
        groupAdmin.insertString(0, "Goodbye");
        groupAdmin.undo();
        groupAdmin.undo();

        groupAdmin.removeMember("John");
        groupAdmin.removeMember("Mary");
        groupAdmin.addMember("Nick");

        groupAdmin.replaceString(0, 5, "Bye");
        groupAdmin.undo();

    }
}
