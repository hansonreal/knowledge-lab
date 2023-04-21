package org.hs.lab.frame;

import javax.swing.*;
import java.awt.*;

/**
 * 加密器框架
 *
 * @author hanson
 * @since 2023/4/19
 */
public class EncryptorFrame extends JFrame {

    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public EncryptorFrame(String frameTitle, int frameWidth, int frameHeight) throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setTitle(frameTitle);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}
