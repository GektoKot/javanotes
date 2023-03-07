package com.gektokot.javanotes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

public class Note extends Stage{

    private final String noteId;

    public Note() throws IOException {
        noteId = UUID.randomUUID().toString();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("note.fxml"));
        Scene scene = new Scene(loader.load(), 200, 100);
        NoteController controller = loader.getController();
        controller.setId(noteId);
        this.setTitle("Note");
        this.setResizable(false);
        this.setOnCloseRequest(event -> event.consume());
        this.setScene(scene);
        this.show();
    }

    public Note(String note) throws IOException {
        noteId = UUID.randomUUID().toString();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("note.fxml"));
        Scene scene = new Scene(loader.load(), 200, 100);
        NoteController controller = loader.getController();
        controller.setId(noteId);
        controller.setTextArea(note);
        this.setTitle("Note");
        this.setResizable(false);
        this.setOnCloseRequest(event -> event.consume());
        this.setScene(scene);
        this.show();
    }
}
