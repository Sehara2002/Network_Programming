
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("AES");

            SecretKey key = new SecretKeySpec("1234567891234567".getBytes(),"AES");

            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] encrypted = cipher.doFinal("My Data".getBytes());
            System.out.println(encrypted);


            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(encrypted);
            System.out.println("Data: "+new String(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
