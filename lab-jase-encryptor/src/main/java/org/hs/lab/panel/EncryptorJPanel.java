package org.hs.lab.panel;

import org.hs.lab.menu.btn.EncryptBtn;
import org.hs.lab.util.EncryptUtil;
import org.jasypt.encryption.pbe.PBEStringEncryptor;

import javax.swing.*;
import java.awt.*;

/**
 * 加密器面板
 *
 * @author hanson
 * @since 2023/4/19
 */
public class EncryptorJPanel extends JPanel {


    public EncryptorJPanel(LayoutManager layout) {
        this.setLayout(layout);
        JLabel algorithmLabel = new JLabel("加密算法:");
        algorithmLabel.setBounds(90, 20, 80, 25);
        this.add(algorithmLabel);

        JComboBox<String> algorithmJComboBox = new JComboBox<>();
        algorithmJComboBox.setBounds(150, 20, 265, 25);
        algorithmJComboBox.addItem("PBEWithMD5AndDES");
        // algorithmJComboBox.addItem("PBEWITHHMACSHA512ANDAES_256");
        this.add(algorithmJComboBox);


        JLabel secretKeyJLabel = new JLabel("加密私钥:");
        secretKeyJLabel.setBounds(90, 80, 80, 25);
        this.add(secretKeyJLabel);

        JTextField secretKeyText = new JTextField(30);
        secretKeyText.setText("hanson");
        secretKeyText.setBounds(150, 80, 265, 25);
        this.add(secretKeyText);


        JLabel plaintTextJLabel = new JLabel("明文密码:");
        plaintTextJLabel.setBounds(90, 140, 80, 25);
        this.add(plaintTextJLabel);

        JTextField plaintText = new JTextField(30);
        plaintText.setText("123456");
        plaintText.setBounds(150, 140, 265, 25);
        this.add(plaintText);


        JLabel resultLabel = new JLabel("加密结果:");
        resultLabel.setBounds(90, 240, 80, 25);
        this.add(resultLabel);

        JTextField signatureText = new JTextField(30);
        signatureText.setBounds(150, 240, 265, 25);
        this.add(signatureText);


        EncryptBtn encryptBtn = new EncryptBtn("加密", e -> {
            String algorithm = String.valueOf(algorithmJComboBox.getSelectedItem());
            String secretKey = secretKeyText.getText();
            String plaint = plaintText.getText();
            PBEStringEncryptor encryptor = EncryptUtil.init(secretKey, algorithm);
            StringBuilder builder = new StringBuilder();
            builder.append("ENC(");
            String encrypt = encryptor.encrypt(plaint);
            builder.append(encrypt);
            builder.append(")");
            signatureText.setText(builder.toString());
        });
        encryptBtn.setBounds(370, 185, 100, 25);

        this.add(encryptBtn);


    }
}
