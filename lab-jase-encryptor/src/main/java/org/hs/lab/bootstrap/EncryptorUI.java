package org.hs.lab.bootstrap;

import org.hs.lab.frame.EncryptorFrame;
import org.hs.lab.listener.ConcatActionListener;
import org.hs.lab.listener.HelpActionListener;
import org.hs.lab.menu.btn.ConcatJMenuItem;
import org.hs.lab.menu.btn.OperateJMenuItem;
import org.hs.lab.panel.EncryptorJPanel;

import javax.swing.*;

/**
 * 程序入口
 *
 * @author hanson
 * @since 2023/4/19
 */
public class EncryptorUI {
    public static void main(String[] args) {
        EncryptorFrame encryptorFrame =
                new EncryptorFrame("微服务/应用敏感信息加密器", 550, 400);
        // 菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        // 菜单栏-帮助按钮
        JMenu jHelpMenu = new JMenu("使用帮助");
        // 菜单栏-帮助按钮-菜单1 使用说明
        OperateJMenuItem operateJMenuItem = new OperateJMenuItem("使用说明", new HelpActionListener(encryptorFrame));
        jHelpMenu.add(operateJMenuItem);
        // 菜单栏-帮助按钮-菜单2 联系作者
        ConcatJMenuItem concatJMenuItem = new ConcatJMenuItem("联系作者", new ConcatActionListener(encryptorFrame));
        jHelpMenu.add(concatJMenuItem);
        // 菜单栏绑定按钮
        jMenuBar.add(jHelpMenu);
        // 绑定菜单栏
        encryptorFrame.setJMenuBar(jMenuBar);
        // 设置操作面板
        encryptorFrame.add(new EncryptorJPanel(null));
        // 窗体可见
        encryptorFrame.setVisible(true);
    }
}
