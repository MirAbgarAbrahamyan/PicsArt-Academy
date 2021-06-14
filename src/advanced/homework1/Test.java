package advanced.homework1;

public class Test {
    public static void main(String[] args) {
        User user = new User("username", "password", 2001);
        UserService.serializeXML(user);
        User user2 = UserService.deserializeXML();
        System.out.println(user2);
    }
}
