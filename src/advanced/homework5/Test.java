package advanced.homework5;

public class Test {
    public static void main(String[] args) {
        User user1 = User.getInstance();
        user1.setLogin("login");
        user1.setPassword("password");
        user1.setYear(2021);
        UserService.serialize(user1);
        User user2 = UserService.deserialize();
        // test
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
