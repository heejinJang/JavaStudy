package regex;

public class regexEx {

	public static void main(String[] args) {
	
		String name = "æ∆¿Ã≈∞";
		String phone = "010-1234-2345";
		
		System.out.println(name.matches("[∞°-∆R]{3}"));
		System.out.println(phone.matches("^010-[0-9]+-[0-9]{4}"));
	
	}
	
}
