import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(6968);
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		while(true) {
			Socket s2 = s.accept();
			threadPool.execute(new Handler(s2));
			System.out.println("Accepted new connection from " + s2.getRemoteSocketAddress());
		}
	}
}


