package de.mmbbs.cwmeteor;

import de.mmbbs.cwmeteor.db.DBCleanupTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ConfigurationPropertiesScan
@Import({
		DBCleanupTask.class
})
public class CwMeteorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CwMeteorApplication.class, args);
	}

}
