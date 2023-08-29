package films;

import films.inter.Mediatory;
import films.inter.impl.ImageMediatory;
import org.junit.Test;

import java.net.Socket;

import static junit.framework.Assert.assertEquals;

public class ServerTest {


    @Test
    public void typeFileImageMediatory_ShouldReturnExtensionOfFile(){
        Socket client;
        Mediatory mediatoryI = new ImageMediatory("/img1.jpeg", client = new Socket());
        String type = mediatoryI.typeFile();
        assertEquals("jpeg", type);
    }

    @Test
    public void typeFileImageMediatory_ShouldReturnEmmptyIfnotExtension(){
        Socket client;
        Mediatory mediatoryI = new ImageMediatory("/img1", client = new Socket());
        String type = mediatoryI.typeFile();
        assertEquals("", type);
    }

}
