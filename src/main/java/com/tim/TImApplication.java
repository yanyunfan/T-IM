package com.tim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TImApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TImApplication.class, args);
        // 启动websocket server
        ShowcaseWebsocketStarter.main(args);
    }

}
