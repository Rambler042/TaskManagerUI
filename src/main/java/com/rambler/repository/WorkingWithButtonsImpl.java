package com.rambler.repository;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Component;

@Component
public class WorkingWithButtonsImpl implements WorkingWithButtons{

    @Override
    public HBox createButtonBox(Button... buttons) {
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(buttons);
        return buttonBox;
    }

    @Override
    public void showAddTaskDialog(ObservableList<String> tasks) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Дабвить задачу");
        dialog.setHeaderText("Введите навзание задачи: ");
        dialog.setContentText("Задача: ");

        dialog.showAndWait().ifPresent(task -> tasks.add(task));
    }

    @Override
    public void showEditTaskDialog(ListView<String> taskListView, ObservableList<String> tasks) {
        int selectIndex = taskListView.getSelectionModel().getSelectedIndex();
        if (selectIndex >= 0) {
            String selectedTask = tasks.get(selectIndex);
            TextInputDialog dialog = new TextInputDialog(selectedTask);
            dialog.setTitle("Редактировать задачу");
            dialog.setHeaderText("Введите новое навзание задачи: ");
            dialog.setContentText("Задача: ");
            dialog.showAndWait().ifPresent(task -> tasks.set(selectIndex, task));
        }

    }

    @Override
    public void deleteSelectTask(ListView<String> taskListView, ObservableList<String> tasks) {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0){
            tasks.remove(selectedIndex);
        }
    }
}
