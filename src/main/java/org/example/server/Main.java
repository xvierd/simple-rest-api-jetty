package org.example.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.example.exceptions.ExampleException;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * @author Xavier Guti&#233;rrez
 *         27/12/16.
 */
public class Main {
    private static final int MAX_THREADS = 200;
    private static final int MIN_THREADS = 20;
    private static final int IDLE_TIME = 60000;
    private static int PORT;
    private static final Logger logger = Logger.getLogger("Main");

    public static void main(String[] args) {

        ResourceConfig config = new ResourceConfig();
        QueuedThreadPool threadPool = new QueuedThreadPool(MAX_THREADS, MIN_THREADS, IDLE_TIME);
        Server server = new Server(threadPool);
        try {
            initConfigServer();
            config.packages("org.example.server", "org.example.services", "org.example.dto");
            ServletHolder servlet = new ServletHolder(new ServletContainer(config));
            server = new Server(PORT);
            ServletContextHandler context = new ServletContextHandler(server, "/*");
            context.addServlet(servlet, "/*");
            server.start();
            server.join();
            // server.destroy();
        } catch (Exception e) {
            server.destroy();
            System.exit(0);
            e.printStackTrace();
        }
    }

    private static void initConfigServer() throws ExampleException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                "config");
    }
}
