package codes.barker.snippr;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class Encryptor {
    private static final TextEncryptor encryptor;

    static {
        String password = "_Xp20GM#MYk~j]-%}H}w"; // !!! IN A REAL APPLICATION, THIS WOULD BE KEPT SECRET !!!
        String salt = KeyGenerators.string().generateKey(); // Generates a random 8-byte salt that is then hex-encoded
        encryptor = Encryptors.text(password, salt); // Derives an encryption key using PBKDF2 (a key derivation function)
    }

    public static String encrypt(String plaintext) {
        return encryptor.encrypt(plaintext);
    }

    public static String decrypt(String ciphertext) {
        return encryptor.decrypt(ciphertext);
    }
}
