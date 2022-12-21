package observer;

public interface Sender {
    public void addMember(String name);

    public void removeMember(String name);

    public void notifyMembers();
}
