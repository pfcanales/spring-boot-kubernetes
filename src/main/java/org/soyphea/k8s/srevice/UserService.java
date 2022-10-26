package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {  
    
    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));
    
    String key = "gb09ym9ydoolp3w886d0tciczj6ve9kszqd65u7d126040gwy86xqimjpuuc788g";
    SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("test.db", key, null);
    
    public List<User> getUser(String containName) {

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
    

}
