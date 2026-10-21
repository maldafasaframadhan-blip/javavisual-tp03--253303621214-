
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel averageLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - TP8");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel titleLabel = new JLabel(
            "DAFTAR KARAKTER",
            SwingConstants.CENTER
        );
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        characterPanel = new JPanel();
        characterPanel.setLayout(
            new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);

        averageLabel = new JLabel();
        averageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        JButton addButton = new JButton("Tambah Karakter");

        addButton.addActionListener(e -> {
            Character newCharacter = new Character(
                "Maharani", CharacterType.MAGE
            );
            newCharacter.setLevel(4);

            boolean added = manager.addCharacter(newCharacter);

            if (added) {
                refreshCharacters();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Karakter Maharani sudah terdaftar."
                );
            }
        });

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 10));
        bottomPanel.add(averageLabel, BorderLayout.CENTER);
        bottomPanel.add(addButton, BorderLayout.SOUTH);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        refreshCharacters();
    }

    private void refreshCharacters() {
        characterPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {
            JLabel characterLabel = new JLabel(
                character.getName()
                + " | Tipe: " + character.getType()
                + " | Level: " + character.getLevel()
                + " | Attack: " + character.getAttack()
            );

            characterLabel.setBorder(
                BorderFactory.createEmptyBorder(8, 5, 8, 5)
            );

            characterPanel.add(characterLabel);
        }

        averageLabel.setText(
            String.format(
                "Rata-rata Level: %.2f",
                manager.getAverageLevel()
            )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}
