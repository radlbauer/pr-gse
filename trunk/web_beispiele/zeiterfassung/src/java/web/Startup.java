
package web;

import fachlogik.Zeiterfassung;
import fachlogik.ZeiterfassungException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import persistenz.DBZeiterfassung;

/**
 * Web application lifecycle listener.
 * @author Rudolf Radlbauer
 */

public class Startup implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)
    {
        try
        {
            sce.getServletContext().setAttribute("zeiterfassung", new DBZeiterfassung());
        } catch (ZeiterfassungException ex)
        {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        try
        {
            Zeiterfassung z = (Zeiterfassung) sce.getServletContext().getAttribute("zeiterfassung");
            if (z != null)
            {
                z.close();
            }
        } catch (ZeiterfassungException ex)
        {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}