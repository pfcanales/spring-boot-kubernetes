package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.io.File;

@Service
public class UserService {  
    
    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));

    
    protected final File createTempDir(String prefix) {
	try {
		File tempDir = File.createTempFile(prefix + ".", "." + getPort());
		tempDir.delete();
		tempDir.mkdir();
		tempDir.deleteOnExit();
		return tempDir;
	}
    
    public List<User> getUser(String containName) {
        
        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
    
}
