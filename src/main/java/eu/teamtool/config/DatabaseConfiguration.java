package eu.teamtool.config;

import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.mongodb.Mongo;

@Configuration
public class DatabaseConfiguration {
	
	@Autowired
	private Mongo mongo;
	
	@Autowired
    private MongoProperties mongoProperties;

    @Bean
    public Mongeez mongeez() {
        Mongeez mongeez = new Mongeez();
        mongeez.setFile(new ClassPathResource("/config/mongeez/master.xml"));
        mongeez.setMongo(mongo);
        mongeez.setDbName(mongoProperties.getDatabase());
        mongeez.process();
        return mongeez;
    }
}
