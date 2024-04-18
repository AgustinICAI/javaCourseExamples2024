import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.logging.Logger;


public class Server {
    static Logger logger = Logger.getGlobal();

    public static void main(String argv[])
    {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
            server.createContext("/hello", new  MyHttpHandler());
            server.start();
            logger.info(" Server started on port 8001");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
