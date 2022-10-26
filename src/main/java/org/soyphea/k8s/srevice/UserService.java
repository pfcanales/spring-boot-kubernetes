package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {  
    
    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));
       
    public List<User> getUser(String containName) {
        
        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
    
    NodeList signatureElement = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");

    XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
    DOMValidateContext valContext = new DOMValidateContext(new KeyValueKeySelector(), signatureElement.item(0)); // Noncompliant
    XMLSignature signature = fac.unmarshalXMLSignature(valContext);

    boolean signatureValidity = signature.validate(valContext);

}
