package com.backend.server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
@SuppressWarnings("resource")
public class BackendServer {
    private static Logger logger = LoggerFactory.getLogger(BackendServer.class);

    public static void main(String[] args) {
        BackendServer server = new BackendServer();

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/application-context.xml");

        synchronized (BackendServer.class) {
            try {
                BackendServer.class.wait();
            } catch (InterruptedException exception) {
                logger.error("AuthServer has occured some problem! Please retry!", exception);
            }
        }
    }
}
