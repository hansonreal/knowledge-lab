package com.knowledge.asyn.tx;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StringUtils;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableAsync
@EnableSwagger2WebMvc
@SpringBootApplication
@MapperScan({"com.knowledge.asyn.tx.mapper"})
public class AsynTxApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AsynTxApplication.class, args);
        Environment env = context.getEnvironment();
        try {
            String appName = env.getProperty("spring.application.name");
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = env.getProperty("server.port");
            String path = env.getProperty("server.servlet.context-path");
            if (StringUtils.hasText(path)){
                path = "/".equals(path) ? "" : path;
            }else{
                path="";
            }
            log.info("\n----------------------------------------------------------------------------------------------------\n\t" +
                    "Application " + appName + " is running! Access URLs:\n\t" +
                    "Local Swagger API Doc: \t\thttp://localhost:" + port + path + "/swagger-ui.html\n\t" +
                    "External Swagger API Doc:\thttp://" + ip + ":" + port + path + "/swagger-ui.html\n" +
                    "----------------------------------------------------------------------------------------------------");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
