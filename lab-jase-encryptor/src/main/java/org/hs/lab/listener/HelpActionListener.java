package org.hs.lab.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 帮助按钮动作
 *
 * @author hanson
 * @since 2023/4/19
 */
public class HelpActionListener implements ActionListener {
    private Component parentComponent;

    public HelpActionListener(Component parentComponent) {
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
                "*******************************************注意事项*******************************************\n" +
                        "1、首先确认微应用/服务引入了以下GAV坐标：\n" +
                        "<dependency>\n" +
                        "     <groupId>com.github.ulisesbocchio</groupId>\n" +
                        "     <artifactId>jasypt-spring-boot-starter</artifactId>\n" +
                        "     <version>3.0.5</version>//版本号理论上不会有影响\n" +
                        "</dependency>\n" +
                        "2、确定应用程序配置：（运维人员注意）\n" +
                        "jasypt:\n" +
                        "  encryptor:\n" +
                        "    algorithm: PBEWithMD5AndDES # 加密算法\n" +
                        "    password: hanson # 加密的秘钥，可以自定义\n" +
                        "3、确认应用程序编写了以下程序\n" +
                        "@Slf4j\n" +
                        "@EnableEncryptableProperties // 重要\n" +
                        "@SpringBootApplication\n" +
                        "public class ExampleApplication {\n" +
                        "    //关键配置，该配置只要保证启动时能够存入到Spring 容器即可\n" +
                        "    @Bean(\"jasyptStringEncryptor\")\n" +
                        "    public StringEncryptor jasyptStringEncryptor() {\n" +
                        "        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();\n" +
                        "        SimpleStringPBEConfig config = new SimpleStringPBEConfig();\n" +
                        "        config.setPassword(\"hanson\"); //加密的秘钥，可以自定义\n" +
                        "        config.setAlgorithm(\"PBEWithMD5AndDES\");\n" +
                        "        config.setPoolSize(1);\n" +
                        "        encryptor.setConfig(config);\n" +
                        "        return encryptor;\n" +
                        "    }\n" +
                        "}\n" +
                        "4、密文使用，将生成好的内容复制到对于的位置\n" +
                        "spring:\n" +
                        "  redis:\n" +
                        "    host: 127.0.0.1\n" +
                        "    port: 6379\n" +
                        "    password: ENC(6dngtsX85+3hdUPpb1dn/h/TMv6mqIjzDkFylNsUUvw=)",
                "关于", JOptionPane.WARNING_MESSAGE);
    }
}
