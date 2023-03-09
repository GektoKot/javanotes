package com.gektokot.javanotes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class NoteController {

    @FXML
    private Button deleteButton;

    @FXML
    private TextArea textArea;

    @FXML
    private Label noteId;

    public static final String NOTES_REPO = "src/main/resources/com/gektokot/javanotes/repo/";

    @FXML
    void onDeleteButtonAction() throws IOException {
        Files.deleteIfExists(Paths.get(NOTES_REPO + noteId.getText()));
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onSaveButtonAction() {

        File file = new File(NOTES_REPO + noteId.getText());
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(textArea.getText());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTextArea(String note) {
        textArea.setText(note);
    }

    public void setId(String noteId) {
        this.noteId.setText(noteId);
    }

    @FXML
    void initialize() {
    }
}
