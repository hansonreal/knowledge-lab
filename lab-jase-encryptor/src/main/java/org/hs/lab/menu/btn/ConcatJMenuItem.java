package org.hs.lab.menu.btn;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 联系菜单
 *
 * @author hanson
 * @since 2023/4/19
 */
public class ConcatJMenuItem extends JMenuItem {


    public ConcatJMenuItem(String menuName,
                           ActionListener actionListener) {
        super(menuName);
        this.addActionListener(actionListener);
    }
}
