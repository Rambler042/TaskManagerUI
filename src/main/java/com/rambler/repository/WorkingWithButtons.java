package com.rambler.repository;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Component;

public interface WorkingWithButtons {

    public HBox createButtonBox(Button... buttons);

    public void showAddTaskDialog(ObservableList<String> tasks);

    public void showEditTaskDialog(ListView<String> taskListView, ObservableList<String> tasks);

    public void deleteSelectTask(ListView<String> taskListView, ObservableList<String> tasks);

}
