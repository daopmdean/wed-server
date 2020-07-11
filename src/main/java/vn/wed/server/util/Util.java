package vn.wed.server.util;

import java.util.Random;

public class Util {

	public static String hash(String password, String passwordSalt) {
		return password + passwordSalt;
	}
	
	public static String createPasswordSalt(int length) {
		Random random = new Random();
        char[] randomChar = {
            'a', 'b', 'c', 'd', 'e',
            'A', 'B', 'C', 'D', 'E',
            '1', '2', '3', '4', '5',
            '@', '#', '$', '%', '&'
        };
        String passwordSalt = "";
        int max = randomChar.length;
        
        for (int i = 0; i < length; i++) {
            passwordSalt += randomChar[random.nextInt(max)];
        }
        
        return passwordSalt;
	}

}
