package org.hs.lab.menu.btn;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 解密按钮
 *
 * @author hanson
 * @since 2023/4/19
 */
public class DecryptBtn extends JButton {
    /**
     * Creates a button with text.
     *
     * @param text the text of the button
     */
    public DecryptBtn(String text, ActionListener actionListener) {
        super(text);
        this.addActionListener(actionListener);
    }
}
