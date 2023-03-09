package com.gektokot.javanotes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

public class Note extends Stage{

    public Note() throws IOException {
        String noteId = UUID.randomUUID().toString();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("note.fxml"));
        Scene scene = new Scene(loader.load(), 200, 100);
        NoteController controller = loader.getController();
        controller.setId(noteId);
        setStage(scene);
    }

    public Note(String note, String noteId) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("note.fxml"));
        Scene scene = new Scene(loader.load(), 200, 100);
        NoteController controller = loader.getController();
        controller.setId(noteId);
        controller.setTextArea(note);
        setStage(scene);
    }

    private void setStage(Scene scene) {
        this.setTitle("Note");
        this.setResizable(false);
        this.setOnCloseRequest(event -> event.consume());
        this.setScene(scene);
        this.show();
    }
}
