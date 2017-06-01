package launch;
import javax.swing.SwingUtilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher
{
    static final Log LOG = LogFactory.getLog(Launcher.class);

    public static void main(String[] args)
    {
        Launcher launcher = new Launcher();
        launcher.launch();
    }
    
    public void launch() 
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String[] contextPaths = new String[] {"spring-xml/app-context.xml"};
                new ClassPathXmlApplicationContext(contextPaths);
            }
         });
    }
}