package com.gektokot.javanotes;

import javafx.fxml.FXML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class MainController {

    @FXML
    void onNewNoteButtonAction() throws IOException {
        new Note();
    }

    @FXML
    void initialize() throws IOException {
        new Note();
        try (Stream<Path> files = Files.list(Paths.get("src/main/resources/com/gektokot/javanotes/repo"))) {
            List<Path> notesPaths = files.toList();
            for (int i = 0; i < notesPaths.size(); i++) {
                String noteText = Files.readString(notesPaths.get(i));
                Note note = new Note(noteText);
                int x = 50;
                int y = 50;
                note.setX(x * i);
                note.setY(y * i);
            }
        }
    }
}
