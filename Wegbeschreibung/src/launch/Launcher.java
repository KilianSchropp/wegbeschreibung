package launch;
import javax.swing.SwingUtilities;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher
{
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