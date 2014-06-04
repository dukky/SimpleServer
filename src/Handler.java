import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Handler implements Runnable {

	Socket s;

	public Handler(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			Scanner in = new Scanner(s.getInputStream());
			PrintWriter out = new PrintWriter(s.getOutputStream());
			while(true) {
				out.println(new StringBuilder(in.nextLine()).reverse().toString());
				out.flush();
			}
		} catch (Exception e) {
			System.out.println(this.s.getRemoteSocketAddress() + " disconnected.");
		}
	}

}
