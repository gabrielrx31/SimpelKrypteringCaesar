/**
 * Caesar Cipher Encryption
 * 
 * Caesar is a substitution cipher where each letter is shifted
 * a fixed number of positions in the alphabet.
 * 
 * Example with key=3:
 * A→D, B→E, C→F ... X→A, Y→B, Z→C
 */
public class CaesarCipher {
    
    public String encrypt(String plaintext, int key){
        // StringBuilder is more efficient than String concatenation in loops
        StringBuilder ciphertext = new StringBuilder();

        // Convert to uppercase for consistency
        plaintext = plaintext.toUpperCase();

        // Normalize key to 0-25 range
        // If key=27, it's the same as key=1 (27 % 26 = 1)
        key = key % 26;

        //Go through each character
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);

            // Check if it's a letter (A-Z)
            if (Character.isLetter(currentChar)) {
                // STEP 1: Convert letter to number (0-25)
                // 'A' has ASCII value 65, so 'A' - 'A' = 0
                // 'B' - 'A' = 1, 'C' - 'A' = 2, etc.
                int position = currentChar - 'A';

                // STEP 2: Shift the position with key
                // We use modulo (%) to "wrap around"
                // Example: position=24 (Y), key=3
                // (24 + 3) % 26 = 27 % 26 = 1 (B)
                int newPosition = (position + key) % 26;

                // STEP 3: Convert back to letter
                // Add 'A' (65) to get the ASCII value
                char newChar = (char) ('A' + newPosition);

                //Add to result
                ciphertext.append(newChar);
            } else {
                // If it's not a letter (space, number, punctuation)
                // keep it unchanged
                ciphertext.append(currentChar);
            }
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext, int key) {
        // Decryption is just encryption in the opposite direction!
        // If we encrypted with +3, we decrypt with -3
        // 
        // We use (26 - key) to avoid negative numbers:
        // -3 % 26 would give -3 in Java (not 23 as we want)
        // But (26 - 3) % 26 = 23 % 26 = 23 ✓
        //
        // Alternatively, we could also write:
        // return encrypt(ciphertext, -key);
        // but that would require extra handling of negative numbers
        return encrypt(ciphertext, 26 - key);
    }
}
