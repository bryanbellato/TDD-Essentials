import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test.java.br.com.bellato.ClientDAOTest;
import test.java.br.com.bellato.ClientServiceTest;

public class Main {

    public static void main(String[] args) {
        System.out.println("Running ClientTest...");

        Result result = JUnitCore.runClasses(ClientServiceTest.class, ClientDAOTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Some tests failed.");
        }

    }

}
