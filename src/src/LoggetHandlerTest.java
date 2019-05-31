import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LoggetHandlerTest {

	private static void configureLogging() {
		Logger logger = Logger.getLogger("org.stepic.java");
		logger.setLevel(Level.ALL);
		XMLFormatter xmlFormatter = new XMLFormatter();
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL);
		consoleHandler.setFormatter(xmlFormatter);
		logger.addHandler(consoleHandler);
		logger.setUseParentHandlers(false);

		Logger loggerClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
		loggerClassA.setLevel(Level.ALL);

		Logger loggerClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
		loggerClassB.setLevel(Level.WARNING);
	}
}
