package main.java.tugas.controller;

import main.java.tugas.model.Student;
import main.java.tugas.service.StudentService;

import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class MainController {

    @FXML private TextField npmField;
    @FXML private TextField nameField;
    @FXML private TextField gpaField;
    @FXML private TextField searchField;

    @FXML private TableView<Student> tableView;
    @FXML private TableColumn<Student, String> colNpm;
    @FXML private TableColumn<Student, String> colName;
    @FXML private TableColumn<Student, Double> colGpa;
    @FXML private TableColumn<Student, Void> colAction;

    private final StudentService service = new StudentService();
    private final ObservableList<Student> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colNpm.setCellValueFactory(c -> c.getValue().npmProperty());
        colName.setCellValueFactory(c -> c.getValue().nameProperty());
        colGpa.setCellValueFactory(c -> c.getValue().gpaProperty().asObject());

        addActionButtons();

        FilteredList<Student> filtered = new FilteredList<>(data, s -> true);

        searchField.textProperty().addListener((obs, oldV, newV) -> {
            filtered.setPredicate(student -> {
                if (newV == null || newV.isEmpty()) return true;
                return student.getName().toLowerCase().contains(newV.toLowerCase());
            });
        });

        SortedList<Student> sorted = new SortedList<>(filtered);
        sorted.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sorted);
    }

    private void addActionButtons() {
        colAction.setCellFactory(col -> new TableCell<>() {

            private final Button editBtn = new Button("Edit");
            private final Button delBtn = new Button("Delete");

            {
                editBtn.setOnAction(e -> {
                    Student s = getTableView().getItems().get(getIndex());
                    npmField.setText(s.getNpm());
                    nameField.setText(s.getName());
                    gpaField.setText(String.valueOf(s.getGpa()));

                    data.remove(s);
                    service.delete(s.getNpm());
                });

                delBtn.setOnAction(e -> {
                    Student s = getTableView().getItems().get(getIndex());

                    Alert conf = new Alert(Alert.AlertType.CONFIRMATION);
                    conf.setHeaderText("Hapus Mahasiswa");
                    conf.setContentText("Hapus: " + s.getName());

                    if (conf.showAndWait().get() == ButtonType.OK) {
                        data.remove(s);
                        service.delete(s.getNpm());
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(new HBox(5, editBtn, delBtn));
                }
            }
        });
    }

    @FXML
    private void onAddClicked(ActionEvent e) {
        try {
            String npm = npmField.getText().trim();
            String name = nameField.getText().trim();
            String gpaText = gpaField.getText().trim();

            validate(npm, name, gpaText);

            double gpa = Double.parseDouble(gpaText);

            Student s = service.createStudent(npm, name, gpa);
            data.add(s);

            clearForm();

        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    private void validate(String npm, String name, String gpaText) {
        if (npm.isEmpty()) throw new IllegalArgumentException("NPM kosong.");
        if (!npm.matches("\\d+")) throw new IllegalArgumentException("NPM harus angka.");

        if (name.isEmpty()) throw new IllegalArgumentException("Nama kosong.");

        try {
            double gpa = Double.parseDouble(gpaText);
            if (gpa < 0 || gpa > 4)
                throw new IllegalArgumentException("GPA 0–4 saja.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("GPA harus angka.");
        }
    }

    private void clearForm() {
        npmField.clear();
        nameField.clear();
        gpaField.clear();
    }

    private void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText("Error");
        a.setContentText(msg);
        a.showAndWait();
    }
}