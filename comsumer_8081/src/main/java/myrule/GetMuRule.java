package myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetMuRule {

    @Bean
    public MyIEule getMyIEule(){
        return new MyIEule();
    }

}
