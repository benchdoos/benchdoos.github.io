package com.doos.service;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import static com.doos.service.Logging.getCurrentClassName;

/**
 * Created by Eugene Zrazhevsky on 30.10.2016.
 */
public class UrlsProceed {
    private static final Logger log = Logger.getLogger(getCurrentClassName());


    /**
     * Opens url on default browser.
     *
     * @param url Url to open.
     */
    public static void openUrl(String url) {
        if (!Desktop.isDesktopSupported()) {
            log.warn("Desktop is not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.browse(URI.create(url));
        } catch (IOException e) {
            log.warn("Can not open url: " + url, e);
            JOptionPane.showMessageDialog(new Frame(), "URL is corrupt: " + url);
        }

    }


    /**
     * Log before program shutdown.
     * */
    public static void shutdownLogout() {
        log.debug("Goodbye!");
    }


    /**
     * Creates <code>.webloc</code> file on given path.
     *
     * @param url URL to create.
     * @param path Path of creating file.
     * */
    public static void createWebloc(URL url, String path) {
        log.info("Creating .webloc at [" + path + "] URL: [" + url + "]");
        NSDictionary root = new NSDictionary();
        root.put("URL", url.toString());


        try {
            File file = new File(path);
            PropertyListParser.saveAsXML(root, file);
        } catch (IOException e) {
            log.warn("Can not create .webloc file", e);
        }
    }
}
