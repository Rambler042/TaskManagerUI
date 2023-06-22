module com.rambler.taskmanagernewversion {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.beans;
    requires spring.core;


    opens com.rambler to javafx.fxml;
    exports com.rambler;
}