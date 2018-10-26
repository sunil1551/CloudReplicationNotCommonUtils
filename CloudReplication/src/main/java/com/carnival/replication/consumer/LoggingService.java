package com.carnival.replication.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

@Component
@PropertySource("file:${APP_PROP_PATH}/configprops.properties") 
public class LoggingService implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingService.class);
    @Value("${log.dir}")
    private String logDir;

    @Value("${log.name}")
    private String logFileName;
    
    @Value("${logback.file.path}")
    private String logConfigPath;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try {
            configureLogback();
        } catch (IOException io) {
        	LOGGER.error(io.getMessage(),io);
        }
    }

    private void configureLogback() throws IOException {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
        	LOGGER.info("============Inside LoggingService==============");
            JoranConfigurator jc = new JoranConfigurator();
            jc.setContext(context);
            context.reset(); 
            context.putProperty("LOG_DIR", logDir);
            context.putProperty("LOG_NAME", logFileName);
            jc.doConfigure(logConfigPath);
        } catch (JoranException je) {
        	LOGGER.error(je.getMessage(),je);
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);

    }

}