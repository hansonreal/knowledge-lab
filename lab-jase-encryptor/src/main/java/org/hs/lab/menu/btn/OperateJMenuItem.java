package org.hs.lab.menu.btn;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 帮助菜单
 *
 * @author hanson
 * @since 2023/4/19
 */
public class OperateJMenuItem extends JMenuItem {
    public OperateJMenuItem(String menuName,
                            ActionListener helpActionListener) {
        super(menuName);
        this.addActionListener(helpActionListener);
    }


}
