package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sanata
 */
public class EncriptPass {



    public EncriptPass() {
    }

    public String createSalts() {
        Date time = new Date();// sozdanie peremennoi
        String s = Long.toString(time.getTime());// perevod vremeni v stroku  - vmesto Time mozno vzjat ljuboe randomnoe 4islo -Random
        MessageDigest m;//klass dlja wifrovanija Stroki - importiruetsja iz lib
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncriptPass.class.getName()).log(Level.SEVERE, "Ne podderzivaet algoritm hewirovanija", ex);
            return null;
        }

    }
    public String setEncriptPass (String password, String salts){
        password=salts+password;
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("SHA-256");
            m.update(password.getBytes(),0,password.length());
           return new BigInteger(1,m.digest()).toString(16);
        
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncriptPass.class.getName()).log(Level.SEVERE,"Ne podderzivaet algoritm hewirovanija", ex);
        }
        return null;
    }
           
}
