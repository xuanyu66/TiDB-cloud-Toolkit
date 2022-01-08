package com.github.xuanyu66.tidbcloudtoolkit.plugin.ui;

import com.github.xuanyu66.tidbcloudtoolkit.plugin.service.DataService;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingUI implements Configurable {
    private JPanel mainPanel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField tokenTextField;

    private TiCloudUI tiCloudUI;

    private DataService dataService;

    /**
     * test connection
     * @param tiCloudUI
     */
    public SettingUI(TiCloudUI tiCloudUI){
        this.tiCloudUI = tiCloudUI;
    }


    public JComponent getPanel() {
        return mainPanel;
    }

    public JTextField getUsername() {
        return usernameTextField;
    }

    public JTextField getPassword() {
        return passwordTextField;
    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "TiCloud Setting";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return mainPanel;
    }

    @Override
    public boolean isModified() {
        return true;
    }

    /**
     * apply info
     * @throws ConfigurationException
     */
    @Override
    public void apply() throws ConfigurationException {
        String userName = getUsername().getText().trim();
        String password = getPassword().getText().trim();
        DataService.getDataService().login(userName,password);
    }
}
