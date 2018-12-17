package com.xxh.web;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @author 小小黑
 */
public class RobotFactory {
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        while (true) {
            RobotFactory.keyClick(KeyEvent.VK_Q);
            RobotFactory.deley(1000);
            
        }
    }


    public static Robot getRobot() {
        return robot;
    }

    public static void mouseClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void mouseMove(int x, int y) {
        robot.mouseMove(x, y);
    }

    public static void mouseMoveAndClick(int x, int y) {
        mouseMove(x, y);
        mouseClick();
    }

    public static void mouseMoveAndClick(int x, int y, int delay) {
        robot.delay(delay);
        mouseMove(x, y);
        mouseClick();
    }

    public static void keyClick(int keyCode) {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    public static void keyClick(int keyCode, int delay) {
        robot.delay(delay);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    public static void deley(int delay) {
        robot.delay(delay);
    }

    public static void backToDesktop() {
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
    }

}
