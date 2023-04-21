package org.hs.lab.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 联系我们按钮事件
 *
 * @author hanson
 * @since 2023/4/19
 */
public class ConcatActionListener implements ActionListener {

    private Component parentComponent;

    public ConcatActionListener(Component parentComponent) {
        this.parentComponent = parentComponent;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(parentComponent,
                "作者：Hanson \n" + "邮箱：hanson.qian@outlook.com",
                "作者信息", JOptionPane.INFORMATION_MESSAGE);
    }
}
