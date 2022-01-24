package com.farmanager.frame;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FarManagerFrame extends JFrame {
  private static final String TITLE = "Bamboo";
  private static final String DEFAULT_DIR = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();

  private static final int WIDTH = 700;
  private static final int HEIGHT = 700;
  private static final int X_COORDINATE = 50;
  private static final int Y_COORDINATE = 100;

  public FarManagerFrame() {
    super(TITLE);

    setBounds(X_COORDINATE, Y_COORDINATE, WIDTH, HEIGHT);
    setResizable(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    add(constructFilesComponent());
  }

  private JList<String> constructFilesComponent() {
    File file = new File(DEFAULT_DIR);
    List<String> directories = new ArrayList<>();
    directories.add(DEFAULT_DIR);

    String[] fileList = file.list();
    if (fileList != null) directories.addAll(Arrays.asList(fileList));

    DefaultListModel<String> listModel = new DefaultListModel<>();
    for (String dir : directories) listModel.addElement(dir);

    return new JList<>(listModel);
  }
}
