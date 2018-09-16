import static org.assertj.core.api.Assertions.assertThat;
import org.apache.thrift.TException;
import org.junit.Test;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.sga.project.handlers.EchoServiceHandler;

@RunWith(PowerMockRunner.class)
public class EchoServiceHandlerTests {
	
	private EchoServiceHandler sut;

	public EchoServiceHandlerTests()
	{
		sut = new EchoServiceHandler();
		
	}
	
	@PrepareForTest({EchoServiceHandler.class})
	@Test
	public void EchoReturnsSameString()
	{
		String input = "Test String";
		String response = "";
		
		try {
			response = sut.echo(input);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThat(response).contains(input);
		
	}

}
