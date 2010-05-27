/*
 * Created on 16.12.2008
 *
 */
package sensor;

import java.util.Random;

public class Sensor
{
    private int[] werte;
    private int anzahl;
    private int minWert;
    private int maxWert;
    private Random rnd;
    
    public Sensor(int min, int max)
    {
        werte = new int[10];
        anzahl = 0;
        
        // falls (max < min) werden sie vertauscht
        if (min < max)
        {
            minWert = min;
            maxWert = max;
        }
        else
        {
            minWert = max;
            maxWert = min;
        }
        rnd = new Random(); 
    }
    
    public void ausgeben()
    {
        for (int i = 0; i < anzahl; i++)
            System.out.print(werte[i] + " ");
        System.out.println();
    }
    
    public void ausgebenGroesser(int w)
    {
        for (int i = 0; i < anzahl; i++)
        {
            if (werte[i] > w)  // es werden nur diejenigen ausgegeben, welche groesser als w sind
                System.out.print(werte[i] + " ");
        }
        System.out.println();
    }
    
    public void neuerWert(int wert)
    {
        if (wert >= minWert && wert <= maxWert)
        {
            if (anzahl < werte.length)
            {
                werte[anzahl] = wert;
                anzahl++;
            }
            else
                System.out.println("Maximale Anzahl von Messwerten bereits erreicht");
                
        }
        else
            System.out.println("ungültiger Wert");
    }
    
    public void einfuegen(int index, int wert)
    {
        if (index >= 0 && index < anzahl)
        {
            if (wert >= minWert && wert <= maxWert)
            {
                if (anzahl < werte.length)
                {
                    // ab index muessen alle Werte um 1 Platz nach hinten verschoben werden
                    for (int i = anzahl; i > index; i--)
                        werte[i] = werte[i-1];
                    // dann wird der neue Wert beim Index eingegeben
                    werte[index] = wert;
                    anzahl++;
                }
                
                else
                    System.out.println("Maximale Anzahl von Messwerten bereits erreicht");
            }
            else
                System.out.println("ungültiger Wert");
        }
        else
            System.out.println("ungültiger Index");
    }
    
    
    public void loeschen(int index)
    {
        if (index >= 0 && index < anzahl)
        {
            for (int i = index; i < anzahl-1; i++)
                werte[i] = werte[i+1];
            anzahl--;
        }        
        else
            System.out.println("ungültiger Index");
    }
    
    public void anzahlLoeschen(int anzahl)
    {
        if (anzahl <= this.anzahl)
        {
            // es reicht, anzahl mal den Wert bei Index 0 zu loeschen
            for (int i = 0; i < anzahl; i++)
                loeschen(0);
        }
        else
            System.out.println("Nicht so viele Werte vorhanden");
    }
    
    public void vertauschen(int index1, int index2)
    {
        if (index1 >= 0 && index1 < anzahl)
        {
            if (index2 >= 0 && index2 < anzahl)
            {
                int w = werte[index1];
                werte[index1] = werte[index2];
                werte[index2] = w;
            }
            else
                System.out.println("ungültiger index2");
        }
        else
            System.out.println("ungültiger index1");
        
    }
    
    public void zufallsWerte(int anzahl)
    {
        for (int i = 0; i < anzahl; i++)
        {
            // das ergibt Zufallszahlen von minWert bis maxWert (inklusive)
            int w = rnd.nextInt(maxWert-minWert+1) + minWert;
            neuerWert(w);
        }
    }
    
    public double berechneDurchschnitt()
    {
        double summe = 0;
        for (int i = 0; i < anzahl; i++)
            summe += werte[i];
        if (anzahl > 0)
            return summe / anzahl;
        else
        {
            System.out.println("keine Werte vorhanden");
            return 0;
        }
    }
    
    public int maximum()
    {
        if (anzahl > 0)
        {
            int max = werte[0];
            for (int i = 0; i < anzahl; i++)
            {
                if (werte[i] > max)
                    max = werte[i];
            }
            return max;
        }
        else
        {
            System.out.println("keine Werte vorhanden");
            return 0;
        }
    }
    
    public int maximumIndex()
    {
        int index = -1;
        if (anzahl > 0)
        {
            index = 0;
            for (int i = 0; i < anzahl; i++)
            {
                if (werte[i] > werte[index])
                    index = i;
            }
        }
        else
            System.out.println("keine Werte vorhanden");
        return index;
    }
    
    
    public void umdrehen()
    {
        for (int i = 0; i < anzahl/2; i++)
            vertauschen(i, anzahl-i-1);
    }
    

}
