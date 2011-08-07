package cz.excello;

import java.util.Calendar;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Bootstrap implements Daemon {

	private static Logger log = LoggerFactory.getLogger(Bootstrap.class.getName());
	
    private CamelServerContext context;

    public static void main(String[] args) throws Exception {

        long start = Calendar.getInstance().getTimeInMillis();

        Bootstrap boot = new Bootstrap();
        boot.init(null);

        long end = Calendar.getInstance().getTimeInMillis();

        log.info("Exo Server is successfully started in " + (end - start) + " milliseconds.");

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.commons.daemon.Daemon#destroy()
     */
    public void destroy() {
    	
    	//TODO:
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.commons.daemon.Daemon#init(org.apache.commons.daemon.DaemonContext
     * )
     */
    public void init(DaemonContext arg0) throws Exception {
        context = new CamelServerContext();
        //context.registerShutdownHook();
        context.start();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.commons.daemon.Daemon#start()
     */
    public void start() throws Exception {
        context.start();
        System.out.println("Start");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.commons.daemon.Daemon#stop()
     */
    public void stop() throws Exception {
        if (context != null) {
            context.stop();
            System.out.println("Stop");
        }
    }

}

/*public final class Bootstrap {

	
	private static Bootstrap daemon = null;
	private static int debug = 0;
	
	
	
	public void init(DaemonContext context) 
			throws  Exception {
		
		String arguments[] = null;
		
		if (context != null) {
			arguments = context.getArguments();
			
				if (arguments != null) {
					for (int i = 0; i < arguments.length; ++i) {
						if (arguments[i].endsWith("-debug"))
							debug = 1;
					}
				}
		}
		
	}	


	
	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (daemon == null) {
			daemon = new Bootstrap();
			
			try {
				
				daemon.start();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
*/
