package ua.stu.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App extends JFrame {
    private JPanel mainPanel;
    private JLabel label;
    private JButton buttonStart;

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menuAbout = new JMenu("About");
    private final JMenuItem menuItemDev = new JMenuItem("Developer");
    private final JMenuItem menuItemTheme = new JMenuItem("Theme of project");

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                App window = new App();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public JLabel getLabel() {
        return label;
    }

    public App() {
        initialize();
    }

    private void initialize() {
        setBounds(200, 200, 1081, 650);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Course project");

        menuBar.add(menuAbout);
        menuAbout.add(menuItemTheme);
        menuAbout.add(menuItemDev);
        setJMenuBar(menuBar);

        mainPanel = new JPanel() {
            public void paintComponent(Graphics graphics) {
                Graphics2D g2D = (Graphics2D) graphics;
                int width = mainPanel.getWidth();
                int height = mainPanel.getHeight();

                BufferedImage image = null;
                try {
                    image = ImageIO.read(new File("src/main/java/ua/stu/images/background.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g2D.drawImage(image, 0, 0, this);
                label.setLocation(5, 200);
                buttonStart.setLocation(30, height - 50);
            }
        };

        setContentPane(mainPanel);
        mainPanel.setLayout(null);

        label = new JLabel();
        label.setBounds(5, 200, 91, 91);
        mainPanel.add(label);

        buttonStart = new JButton();
        buttonStart.setText("Start");
        //  buttonStart.setToolTipText("Start");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    startWork();
                }).start();
            }
        });
        buttonStart.setBounds(5, getHeight() - 50, 80, 30);
        buttonStart.setBackground(Color.YELLOW);
        buttonStart.setBorder(null);
        buttonStart.setBorderPainted(false);
        /*buttonStart.setContentAreaFilled(false);
        buttonStart.setOpaque(false);*/
        mainPanel.add(buttonStart);


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

        setLocationRelativeTo(null);
    }

    public void startWork() {
        this.setResizable(false);
        buttonStart.setEnabled(false);
        JLabel newLabel = new JLabel();
        try {
            newLabel.setSize(91, 91);
            int x = getLabel().getX() + newLabel.getWidth();
            int y = getLabel().getY() + newLabel.getHeight() / 4;
            newLabel.setLocation(x, y);
            try {
                File file = new File("src/main/java/ua/stu/images/chelovekWithBucket.png");
                BufferedImage image = ImageIO.read(file);
                newLabel.setIcon(new ImageIcon(image));
                getMainPanel().add(newLabel);
                newLabel.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int count = 3;
            int averageTime = 5;

            goToBread(newLabel, averageTime);

            count -= 1;
            if (count == 0) {
                return;
            }

            goToVegetables(newLabel, averageTime);

            count -= 1;
            if (count == 0) {
                return;
            }

            goToDrinks(newLabel, averageTime);

            count -= 1;
            if (count == 0) {
                return;
            }
            goToMeat(newLabel, averageTime);

        } catch (InterruptedException e) {
            throw new RuntimeException("was interrupted.");
        } finally {
            getMainPanel().remove(newLabel);
            getMainPanel().repaint();
        }
    }

    private void goToBread(JLabel label, int averageTime) throws InterruptedException {
        int currentX = label.getX();
        while (currentX + label.getWidth() <= 370) {
            label.setLocation(currentX, label.getY());
            Thread.sleep(100);
            currentX += 10;
        }
        int currentY = label.getY();
        while (currentY + label.getHeight() >= 190) {
            label.setLocation(currentX, currentY);
            Thread.sleep(100);
            currentY -= 10;
        }

        try {
            Thread.sleep(averageTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToVegetables(JLabel label, int averageTime) throws InterruptedException {
        int currentX = label.getX();
        while (currentX + label.getWidth() <= 665) {
            label.setLocation(currentX, label.getY());
            Thread.sleep(100);
            currentX += 10;
        }

        try {
            Thread.sleep(averageTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToDrinks(JLabel label, int averageTime) throws InterruptedException {
        int currentX = label.getX();
        int currentY = label.getY();
        while (currentY + label.getHeight() <= 500) {
            label.setLocation(currentX, currentY);
            Thread.sleep(100);
            currentY += 10;
        }

        try {
            Thread.sleep(averageTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToMeat(JLabel label, int averageTime) throws InterruptedException {
        int currentX = label.getX();
        while (currentX + label.getWidth() >= 370) {
            label.setLocation(currentX, label.getY());
            Thread.sleep(100);
            currentX -= 10;
        }

        try {
            Thread.sleep(averageTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
