/*
 * SK's Minecraft Launcher
 * Copyright (C) 2010-2014 Albert Pham <http://www.sk89q.com> and contributors
 * Please see LICENSE.txt for license information.
 */

package com.skcraft.launcher.dialog;

import com.skcraft.launcher.swing.ActionListeners;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class AboutDialog extends JDialog {

    public AboutDialog(Window parent) {
        super(parent, "About", ModalityType.DOCUMENT_MODAL);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
        setResizable(false);
        pack();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        JPanel container = new JPanel();
        container.setLayout(new MigLayout("insets dialog"));

        container.add(new JLabel("<html>Licensed under GNU General Public License, version 3."), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>Based on SKCraft Launcher<br>" +
                "Modified by Billy"), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>Report any bugs to me on twitter<br>" +
                "@Billy_TheHero"), "wrap, gapbottom unrel");

        JButton okButton = new JButton("OK");
        JButton sourceCodeButton = new JButton("Website");

        container.add(sourceCodeButton, "span, split 3, sizegroup bttn");
        container.add(okButton, "tag ok, sizegroup bttn");

        add(container, BorderLayout.CENTER);

        getRootPane().setDefaultButton(okButton);
        getRootPane().registerKeyboardAction(ActionListeners.dispose(this), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        okButton.addActionListener(ActionListeners.dispose(this));
        sourceCodeButton.addActionListener(ActionListeners.openURL(this, "https://ducksquadnetwork.com"));
    }

    public static void showAboutDialog(Window parent) {
        AboutDialog dialog = new AboutDialog(parent);
        dialog.setVisible(true);
    }
}

