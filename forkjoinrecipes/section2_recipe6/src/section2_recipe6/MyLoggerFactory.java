package section2_recipe6;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLoggerFactory {
	
	private static Handler handler;
	
	public synchronized static Logger getLogger(String name) {
		
		Logger logger=Logger.getLogger(name);

		logger.setLevel(Level.ALL);
		
		try {
			if (handler==null) {
				handler=new FileHandler("message.log");
				Formatter format=new MyFormatter();
				handler.setFormatter(format);
			}
			
			if (logger.getHandlers().length==0) {
				logger.addHandler(handler);
			}
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		return logger;		
	}
}
