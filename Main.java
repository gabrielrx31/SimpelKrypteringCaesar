public class Main {
    public static void main (String[] args) {
        CaesarCipher cipher = new CaesarCipher();

        System.out.println("=== CAESAR CIPHER ===");

        String message = "HALLO VERDEN";
        int key = 3;
        
        System.out.println("Original besked: " + message);
        System.out.println("Key: " + key);
        
        String encrypted = cipher.encrypt(message, key);
        System.out.println("\nKrypteret: " + encrypted);
        
        String decrypted = cipher.decrypt(encrypted, key);
        System.out.println("Dekrypteret: " + decrypted);
    }
}
