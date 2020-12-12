package ua.stu;

import javax.swing.*;

public abstract class Walking {

    protected JLabel label;

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

}
