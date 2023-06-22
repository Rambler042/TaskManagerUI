package com.rambler.ui;

import com.rambler.repository.WorkingWithButtons;
import com.rambler.repository.WorkingWithButtonsImpl;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component()
public class TaskMenuUI {

    private final WorkingWithButtons workingWithButtons = new WorkingWithButtonsImpl();

    public void startMainMenu(ObservableList<String> tasks, ListView<String> taskListView){

        Stage stage = new Stage();

        stage.setTitle("Список задач");

        Button addButton = new Button("Добавить");
        addButton.setOnAction(event -> workingWithButtons.showAddTaskDialog(tasks));

        Button editButton = new Button("Редактировать");
        editButton.setOnAction(event -> workingWithButtons.showEditTaskDialog(taskListView, tasks));

        Button deleteButton = new Button("Удалить");
        deleteButton.setOnAction(e -> workingWithButtons.deleteSelectTask(taskListView, tasks));

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(taskListView, workingWithButtons.createButtonBox(addButton, editButton, deleteButton));

        Scene scene = new Scene(root, 300, 450);

        stage.setScene(scene);
        stage.show();
    }



}
