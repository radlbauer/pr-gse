/*
 * Created on 07.04.2009
 *
 */
package fahrtenbuch.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import fahrtenbuch.fachlogik.Fahrer;
import fahrtenbuch.fachlogik.Fahrt;
import fahrtenbuch.fachlogik.Fahrtenbuch;

public class Hauptfenster extends JFrame
{
    private Fahrtenbuch fahrtenbuch;
    
    private JComboBox cbFahrer;
    private DefaultListModel lmFahrten;
    private DefaultListModel lmKosten;
    private JList jlFahrten;
    private JList jlKosten;
    
    public Hauptfenster()
    {
        fahrtenbuch = new Fahrtenbuch();
        initFrame();
        initMenu();
    }
    
    private void initFrame()
    {
        cbFahrer = new JComboBox(fahrtenbuch.alleFahrer());
        lmFahrten = new DefaultListModel();
        lmKosten = new DefaultListModel();
        jlFahrten = new JList(lmFahrten);
        jlFahrten.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlKosten = new JList(lmKosten);
        jlKosten.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        setLayout(new BorderLayout());
        
        JPanel north = new JPanel();
        add(north, BorderLayout.NORTH);
        north.setLayout(new FlowLayout());
        north.add(new JLabel("Fahrer/in"));
        north.add(cbFahrer);
        
        JPanel center = new JPanel();
        add(center, BorderLayout.CENTER);
        GridLayout centerLayout = new GridLayout(1,2);
        centerLayout.setHgap(20);
        center.setLayout(centerLayout);
        
        JPanel centerLeft = new JPanel();
        center.add(centerLeft);
        centerLeft.setLayout(new BorderLayout());
        centerLeft.add(new JLabel("Fahrten"), BorderLayout.NORTH);
        centerLeft.add(new JScrollPane(jlFahrten), BorderLayout.CENTER);
        
        JPanel centerRight = new JPanel();
        center.add(centerRight);
        centerRight.setLayout(new BorderLayout());
        centerRight.add(new JLabel("Kosten"), BorderLayout.NORTH);
        centerRight.add(new JScrollPane(jlKosten), BorderLayout.CENTER);
        
        JPanel buttonsLeft = new JPanel();
        buttonsLeft.setLayout(new GridLayout(10,1));
        centerLeft.add(buttonsLeft, BorderLayout.EAST);
        JButton neueFahrt = new JButton("NEU");
        JButton fahrtBearbeiten = new JButton("BEARBEITEN");
        JButton fahrtLoeschen = new JButton("L�SCHEN");
        for (int i = 0; i < 3; i++)
            buttonsLeft.add(new JLabel());
        buttonsLeft.add(neueFahrt);
        buttonsLeft.add(fahrtBearbeiten);
        buttonsLeft.add(fahrtLoeschen);
        
        JPanel buttonsRight = new JPanel();
        buttonsRight.setLayout(new GridLayout(10,1));
        centerRight.add(buttonsRight, BorderLayout.EAST);
        JButton tankstop = new JButton("Tankstop");
        JButton ausgabe = new JButton("Ausgabe");
        JButton kostenBearbeiten = new JButton("BEARBEITEN");
        JButton kostenLoeschen = new JButton("L�SCHEN");
        for (int i = 0; i < 3; i++)
            buttonsRight.add(new JLabel());
        buttonsRight.add(tankstop);
        buttonsRight.add(ausgabe);
        buttonsRight.add(kostenBearbeiten);
        buttonsRight.add(kostenLoeschen);
        
        neueFahrt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                neueFahrt();
            }});
        
        fahrtBearbeiten.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                fahrtBearbeiten();
            }});

        fahrtLoeschen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                fahrtLoeschen();
            }});
        
        tankstop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                tankstop();
            }});
        
        ausgabe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                ausgabe();
            }});
        
        kostenBearbeiten.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                kostenBearbeiten();
            }});
        
        kostenLoeschen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                kostenLoeschen();
            }});
        
    }
    

    private void initMenu()
    {
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu datei = new JMenu("Datei");
        menubar.add(datei);
        JMenuItem ende = new JMenuItem("beenden");
        datei.add(ende);
        
        ende.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                ende();
            }});        
    }


    // =================== event handler Methoden ==============================
    private void ende()
    {
        System.exit(0);
    }

    private void kostenLoeschen()
    {
        // TODO Auto-generated method stub
        
    }

    private void kostenBearbeiten()
    {
        // TODO Auto-generated method stub
        
    }

    private void ausgabe()
    {
        // TODO Auto-generated method stub
        
    }

    private void tankstop()
    {
        // TODO Auto-generated method stub
        
    }

    private void fahrtBearbeiten()
    {
        // TODO Auto-generated method stub
        
    }
    
    private void fahrtLoeschen()
    {
        Object fahrt = jlFahrten.getSelectedValue();
        if (fahrt != null)
        {
            lmFahrten.removeElement(fahrt);
            fahrtenbuch.remove((Fahrt) fahrt);
        }
        else
            JOptionPane.showMessageDialog(this, "Bitte eine Fahrt ausw�hlen", 
                    "Fahrt l�schen", JOptionPane.INFORMATION_MESSAGE);
    }


    private void neueFahrt()
    {
        Fahrt fahrt = new Fahrt();
        FahrtFenster dialog = new FahrtFenster(this, fahrt);
        dialog.setVisible(true);
        if (dialog.isOk())
        {
            lmFahrten.addElement(fahrt);
            fahrtenbuch.add(fahrt);
        }
    }


    
    
    
    
    //================== Delegates f�r Fahrtenbuch ============================
    

    public Fahrer[] alleFahrer()
    {
        return fahrtenbuch.alleFahrer();
    }

    /**
     * nur zum Testen
     * @param args
     */
    public static void main(String[] args)
    {
        Hauptfenster fenster = new Hauptfenster();
        fenster.pack();
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
    }
}