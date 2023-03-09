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
        try (Stream<Path> files = Files.list(Paths.get("src/main/resources/com/gektokot/javanotes/repo"))) {
            List<Path> notesPaths = files.toList();
            if (notesPaths.size() == 0) {
                new Note();
            }
            for (int i = 0; i < notesPaths.size(); i++) {
                String noteText = Files.readString(notesPaths.get(i));
                Note note = new Note(noteText, notesPaths.get(i).getFileName().toString());
                int x = 50;
                int y = 50;
                note.setX(x * i);
                note.setY(y * i);
            }
        }
    }
}
