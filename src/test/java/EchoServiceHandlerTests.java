import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.thrift.TException;
import org.junit.Test;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.sga.project.handlers.EchoServiceHandler;

@RunWith(PowerMockRunner.class)
public class EchoServiceHandlerTests {
	
	 @Mock
	 InetAddress inetAddress;
	
	private EchoServiceHandler sut;
	private String localIp = "127.0.0.1";

	public EchoServiceHandlerTests() throws UnknownHostException
	{
		sut = new EchoServiceHandler();
		PowerMockito.mockStatic(InetAddress.class);
		when(InetAddress.getLocalHost()).thenReturn(inetAddress);
        when(inetAddress.getHostAddress()).thenReturn(localIp);
		
	}
	
	@PrepareForTest({EchoServiceHandler.class})
	@Test
	public void EchoReturnsSameString()
	{
		String input = "Test String";
		String response = "";
		String expected = "from " + localIp + " : " + input;
		
		try {
			response = sut.echo(input);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(expected,response);
		
	}
	
	@Test
	@PrepareForTest({EchoServiceHandler.class})
	//@Test(expected = TException.class)
	public void EchoConstainsIpAddress()
	{
		String input = "Test String";
		String response = "";
		
		try {
			response = sut.echo(input);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThat(response).contains(localIp);
	}
}
