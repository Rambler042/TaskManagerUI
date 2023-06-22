package com.rambler;

import com.rambler.config.TaskManagerConfig;
import com.rambler.ui.TaskMenuUI;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;

public class HelloApplication extends Application {

    private TaskMenuUI taskMenuUI;
    private ObservableList<String> tasks;
    private ListView<String> taskListView;

    @Override
    public void start(Stage stage) throws IOException {

        taskMenuUI = new TaskMenuUI();
        tasks = FXCollections.observableArrayList();
        taskListView = new ListView<>(tasks);

        taskMenuUI.startMainMenu(tasks, taskListView);
    }


    public static void main(String[] args) {
        launch();
    }
}