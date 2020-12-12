package ua.stu.view;

import javax.swing.*;
import java.awt.event.*;

public class DlgThread extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldTime;
    private JTextField textFieldCount;

    float avTimeTimber;
    float avTimeCylinder;
    float avTimeWaste;
    float fullTime;
    int count;
    boolean isCorrectly;

    public DlgThread() {
        setUiProperties();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void setUiProperties() {
        setContentPane(contentPane);
        setModal(true);
        setBounds(200, 200, 500, 250);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Add products");
    }

    private void onOK() {
        isCorrectly = true;
        fullTime = 1000 * Float.parseFloat(textFieldTime.getText());
        count = Integer.parseInt(textFieldCount.getText());
        if (avTimeTimber <= 0 || avTimeCylinder <= 0 || avTimeWaste <= 0 || fullTime <= 0
                || fullTime < avTimeTimber || fullTime < avTimeCylinder) {
            JOptionPane.showMessageDialog(null, "Середній або загальний час введено неправильно", "InputError", JOptionPane.ERROR_MESSAGE);
            isCorrectly = false;
        }
        if (isCorrectly) {
            setVisible(false);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DlgThread dialog = new DlgThread();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public float getAvTimeTimber() {
        return avTimeTimber;
    }

    public float getAvTimeCylinder() {
        return avTimeCylinder;
    }

    public float getAvTimeWaste() {
        return avTimeWaste;
    }

    public float getFullTime() {
        return fullTime;
    }

    public int getCount() {
        return count;
    }

    public boolean isCorrectly() {
        return isCorrectly;
    }
}
