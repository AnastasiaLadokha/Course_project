package ua.stu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class MainGui {
    private JPanel mainPanel;
    private JLabel label;
    public JFrame frame;

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menuAbout = new JMenu("About");
    private final JMenuItem menuItemDev = new JMenuItem("Developer");
    private final JMenuItem menuItemTheme = new JMenuItem("Theme of project");

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                MainGui window = new MainGui();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainGui() throws IOException {
        initialize();

    }

    private void initialize() throws IOException {
        frame = new JFrame();
        frame.setBounds(200, 200, 600, 400);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Course project");

        menuBar.add(menuAbout);
        menuAbout.add(menuItemTheme);
        menuAbout.add(menuItemDev);
        frame.setJMenuBar(menuBar);

        mainPanel = new JPanel(){
            public void paintComponent(Graphics graphics){
                Graphics2D g2D =(Graphics2D) graphics;

            }
        };

        frame.setContentPane(mainPanel);
        mainPanel.setLayout(null);

        menuItemDev.addActionListener(e -> {
            InfoFrame infoF = new InfoFrame();
            // Определение способа завершения работы диалогового окна
            infoF.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            // Определение типа оформления диалогового окна
            infoF.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
            infoF.setVisible(true);
        });

        menuItemTheme.addActionListener(e -> JOptionPane.showMessageDialog(
                null, "Покупці приходять у магазин через випадкові проміжки часу.\n" +
                        "У магазині покупець може зробити кілька покупок.\n" +
                        "Покупець розраховується  за покупки в касах на виході. " +
                        "\nЧас розрахунку на касі й час перебування покупця в " +
                        "\nмагазині залежить від кількості покупок", "Theme of project",
                JOptionPane.INFORMATION_MESSAGE));
    }
}
