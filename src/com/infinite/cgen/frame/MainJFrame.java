package com.infinite.cgen.frame;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.infinite.cgen.data.FileGen;

public class MainJFrame extends JFrame
{

    private JPanel contentPane;
    private JTextField textFieldPath;
    private JButton btnFbrowser;
    private JTextField textFieldFileName;
    private JButton btnGenerate;
    private JTextField textFieldCharnum;
    private JCheckBox chckbxNum;
    private JCheckBox chckbxSymbols;

    /**
     * Launch the application.
     */
    public static void startMainFrame()
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainJFrame frame = new MainJFrame();
                    frame.setVisible(true);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Creates the frame.
     */
    public MainJFrame()
    {
        setTitle("Character Generation");
        initComponents();
        createEvents();
    }
    
    //initializes components
    public void initComponents()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 309, 287);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblNumberOfCharacters = new JLabel("Number of characters :");
        
        textFieldCharnum = new JTextField();
        textFieldCharnum.setColumns(10);
        textFieldCharnum.setText("0");
        
        chckbxNum = new JCheckBox("uses numbers");
        
        chckbxSymbols = new JCheckBox("uses symbols");
        
        JLabel lblPath = new JLabel("Path :");
        
        textFieldPath = new JTextField();
        textFieldPath.setColumns(10);
        textFieldPath.setText(System.getProperty("user.dir"));
        
        btnFbrowser = new JButton("");
        
        Image imgFbrowser = new ImageIcon(this.getClass().getResource("/folder_icon.png")).getImage();
        btnFbrowser.setIcon(new ImageIcon(imgFbrowser));
        
        JLabel lblFileName = new JLabel("File name :");
        
        textFieldFileName = new JTextField();
        textFieldFileName.setText("generation");
        textFieldFileName.setColumns(10);
        
        btnGenerate = new JButton("Generate");
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnGenerate, Alignment.TRAILING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                            .addComponent(lblNumberOfCharacters)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(textFieldCharnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lblFileName)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(textFieldFileName))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lblPath)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(textFieldPath, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnFbrowser, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(chckbxNum)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(chckbxSymbols)))
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNumberOfCharacters)
                        .addComponent(textFieldCharnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(chckbxNum)
                        .addComponent(chckbxSymbols))
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(44)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblPath)
                                .addComponent(textFieldPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(34)
                            .addComponent(btnFbrowser)))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblFileName)
                        .addComponent(textFieldFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                    .addComponent(btnGenerate)
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
    
    //creates events
    public void createEvents()
    {
       textFieldCharnum.addKeyListener(new KeyAdapter() 
       {
            public void keyPressed(KeyEvent ke) 
            {
               String value = textFieldCharnum.getText();
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE ) {
                  textFieldCharnum.setEditable(true);
               } else {
                  textFieldCharnum.setEditable(false);
               }
            }
        });
            
        btnFbrowser.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                /*
                FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true);
                String file = dialog.getDirectory() + dialog.getFile();
                textFieldPath.setText(file);*/
                
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(fileChooser);
                if(option == JFileChooser.APPROVE_OPTION)
                {
                   File file = fileChooser.getSelectedFile();
                   textFieldPath.setText(file.getAbsolutePath());
                }
            }
        });
        
        btnGenerate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String path = textFieldPath.getText() + "\\" + textFieldFileName.getText() + ".txt";
                System.out.println("Path = " + path);
                FileGen.writetoFile(path, textFieldPath.getText(), Long.valueOf(textFieldCharnum.getText()), chckbxNum.isSelected(), chckbxSymbols.isSelected());
            }
        });
    }
}
