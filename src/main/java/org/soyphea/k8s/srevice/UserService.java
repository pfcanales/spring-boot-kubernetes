package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

@Service
public class UserService {  
    
    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));
       
    public List<User> getUser(String containName) {

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
    
    public String applyCBC(String strKey, String plainText) {
        byte[] bytesIV = "7cVgr5cbdCZVw5WY".getBytes("UTF-8");

        /* KEY + IV setting */
        IvParameterSpec iv = new IvParameterSpec(bytesIV);
        SecretKeySpec skeySpec = new SecretKeySpec(strKey.getBytes("UTF-8"), "AES");

        /* Ciphering */
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);  // Noncompliant: the IV is hard coded and thus not generated with a secure random generator
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return DatatypeConverter.printBase64Binary(bytesIV)
              + ";" + DatatypeConverter.printBase64Binary(encryptedBytes);
    }

}
