package lk.ijse.spring.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class DBConnection implements InitializingBean {

    @Value("${os.name}")  // ${} - Property Placeholder
    private  String myOSName;
    @Value("${USER}")
    private String myUserName;

    @Value("${db.user.name}")
    private String dbUsername;

    public DBConnection() {
        System.out.println("DBConnection: Instantiated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(myOSName);
        System.out.println(myUserName);
        System.out.println(dbUsername);
    }
}
