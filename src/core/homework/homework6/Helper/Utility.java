package core.homework.homework6.Helper;

import core.homework.homework6.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Utility {
    public static HashMap<String, String> usernameSet = new HashMap<>();
    public static LinkedHashMap<String, Integer> usernameSetIndex = new LinkedHashMap<>();
    public static List<String> usersList;

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static void addUsernamesToHashSet(List<String> users) {
        for (int i = 0; i < users.size(); i++) {
            usernameSet.put(users.get(i).split(",")[3], users.get(i).split(",")[2]);
            usernameSetIndex.put(users.get(i).split(",")[3], i);
        }
    }

    public static User setUser(String key) {
        String[] userInfo = usersList.get(usernameSetIndex.get(key)).split(",");
        return new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
    }
}
