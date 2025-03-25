package cn.nbmly;

import java.lang.Boolean;
import java.lang.String;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 项目启动类
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan("cn.nbmly.dao")
@ImportResource(locations = "classpath:datasource-config.xml")
public class LoveZjzApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(LoveZjzApplication.class);
        springApplication.setAllowCircularReferences(Boolean.TRUE);
        springApplication.run(args);
    }
}
