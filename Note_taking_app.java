package CodeClause_Internship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

    public class Note_taking_app {
        private JFrame frame;
        private JTextArea textArea;
        private JFileChooser fileChooser;
        private ArrayList<String> notes;
        public Note_taking_app() {
            frame = new JFrame("Note Taking App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            textArea = new JTextArea();
            frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

            notes = new ArrayList<>();
            fileChooser = new JFileChooser();

            JMenuBar menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");

            JMenuItem newNoteItem = new JMenuItem("New Note");
            JMenuItem openItem = new JMenuItem("Open");
            JMenuItem saveItem = new JMenuItem("Save");
            JMenuItem exitItem = new JMenuItem("Exit");

            fileMenu.add(newNoteItem);
            fileMenu.add(openItem);
            fileMenu.add(saveItem);
            fileMenu.add(exitItem);

            menuBar.add(fileMenu);
            frame.setJMenuBar(menuBar);

            ActionListener menuListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (e.getActionCommand()) {
                        case "New Note":
                            textArea.setText("");
                            break;
                        case "Open":
                            openFile();
                            break;
                        case "Save":
                            saveFile();
                            break;
                        case "Exit":
                            System.exit(0);
                            break;
                    }
                }
            };
            newNoteItem.addActionListener(menuListener);
            openItem.addActionListener(menuListener);
            saveItem.addActionListener(menuListener);
            exitItem.addActionListener(menuListener);

            frame.setVisible(true);
        }
        private void openFile() {
            int returnVal = fileChooser.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    textArea.setText("");
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        private void saveFile() {
            int returnVal = fileChooser.showSaveDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                    writer.print(textArea.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new Note_taking_app());
        }
    }


