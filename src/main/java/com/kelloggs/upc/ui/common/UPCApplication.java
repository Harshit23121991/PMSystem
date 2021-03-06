package com.kelloggs.upc.ui.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.stereotype.Service;


/**
 * The Class UPCApplication.
 */

@Service
public class UPCApplication implements ServletContextListener
{
	/** The application config. */
	public static Properties applicationConfig = null;

	public ServletContext context;

	/** The Constant CONFIG_NAME. */
	private static final String CONFIG_NAME = "upcConfig.properties";

	/** The Constant JBOSS_HOME. */
	private static final String JBOSS_HOME = "jboss.server.config.dir";

	/** The Constant FILE_SEPARATOR. */
	private static final String FILE_SEPARATOR = "file.separator";

	/** The Constant LOG_FILE_NAME. */
	private static final String LOG_FILE_NAME = "log4j.xml";

	private static final String FS = System.getProperty(FILE_SEPARATOR);

	/** The Constant LOGGER. */
	static final Logger LOGGER = Logger.getLogger(UPCApplication.class);
	static String FOLDER_PATH = "";
	static
	{
		System.out.println(" Cocoon Mode " + System.getProperty("org.apache.cocoon.mode"));
		FOLDER_PATH = new StringBuilder(FOLDER_PATH).append("WEB-INF").append(FS).append("classes").append(FS).append("com")
				.append(FS).append("kelloggs").append(FS).append("upc").append(FS).append("ui").append(FS).append("resources")
				.append(FS).append(System.getProperty("org.apache.cocoon.mode")).toString();
	}

	/**
	 * Instantiates a new uPC application.
	 */
	public UPCApplication()
	{

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet .ServletContextEvent)
	 */
	public void contextInitialized(final ServletContextEvent iEvent)
	{
		context = iEvent.getServletContext();
		StringBuilder log4jFilePath = null;
		try
		{

			// Log4J Configuration starts
			log4jFilePath = new StringBuilder();
			log4jFilePath.append(FOLDER_PATH).append(FS).append(LOG_FILE_NAME);

			final File propertiesFile = new File(log4jFilePath.toString());
			DOMConfigurator.configure(context.getRealPath(propertiesFile.getPath()));
			// Log4J Configuration ends

			FileInputStream fis;
			final StringBuffer configPath = new StringBuffer();
			configPath.append(FOLDER_PATH);
			configPath.append(System.getProperty(FILE_SEPARATOR));
			configPath.append(CONFIG_NAME);

			try
			{

				applicationConfig = new Properties();
				fis = new FileInputStream(context.getRealPath(configPath.toString()));
				applicationConfig.load(fis);
				LOGGER.info("LOG INITILIZED");

			}
			catch (final FileNotFoundException e)
			{
				LOGGER.error(" FileNotFoundException ::: Error Ocurred in " + e.getMessage());

			}
			catch (final IOException e)
			{
				LOGGER.error(" IOException ::: Error Ocurred in ", e);

			}

		}
		catch (final Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		LOGGER.info("contextInitialized >>>>>>>>>>>>>>>>>>>");

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet. ServletContextEvent)
	 */
	public void contextDestroyed(final ServletContextEvent iEvent)
	{
		LOGGER.info("contextDestroyed >>>>>>>>>>>>>>>>>>>>>>>");
	}

}
