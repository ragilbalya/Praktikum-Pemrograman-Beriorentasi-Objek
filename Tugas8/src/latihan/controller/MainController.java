package latihan.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import model.Student;
import latihan.service.StudentService;

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
    private FilteredList<Student> filtered;

    private boolean isEditMode = false;
    private String editNpm = null;

    @FXML
    public void initialize() {

        colNpm.setCellValueFactory(cell -> cell.getValue().npmProperty());
        colName.setCellValueFactory(cell -> cell.getValue().nameProperty());
        colGpa.setCellValueFactory(cell -> cell.getValue().gpaProperty().asObject());

        setupActionButtons();

        filtered = new FilteredList<>(data, p -> true);

        searchField.textProperty().addListener((obs, oldVal, newVal) -> {
            filtered.setPredicate(item -> {
                if (newVal == null || newVal.isEmpty()) return true;
                return item.getName().toLowerCase().contains(newVal.toLowerCase());
            });
        });

        tableView.setItems(filtered);
    }

    @FXML
    private void onAddClicked(ActionEvent event) {
        try {
            String npm = npmField.getText().trim();
            String name = nameField.getText().trim();
            String gpaText = gpaField.getText().trim();

            if (npm.isEmpty()) throw new IllegalArgumentException("NPM wajib diisi.");
            if (!npm.matches("\\d+")) throw new IllegalArgumentException("NPM harus angka.");
            if (name.isEmpty()) throw new IllegalArgumentException("Nama wajib diisi.");

            double gpa = Double.parseDouble(gpaText);
            if (gpa < 0 || gpa > 4) throw new IllegalArgumentException("GPA harus 0–4.");

            if (!isEditMode) {
                Student s = service.createStudent(npm, name, gpa);
                data.add(s);
            } else {
                service.updateStudent(editNpm, name, gpa);

                for (Student s : data) {
                    if (s.getNpm().equals(editNpm)) {
                        s.setName(name);
                        s.setGpa(gpa);
                        break;
                    }
                }

                tableView.refresh();
                isEditMode = false;
                editNpm = null;
            }

            clearForm();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    /** ===========================
     *  ACTION COLUMN BUTTONS
     *  =========================== */
    private void setupActionButtons() {

        Callback<TableColumn<Student, Void>, TableCell<Student, Void>> cellFactory =
                new Callback<TableColumn<Student, Void>, TableCell<Student, Void>>() {

                    @Override
                    public TableCell<Student, Void> call(TableColumn<Student, Void> param) {

                        return new TableCell<Student, Void>() {

                            private final Button btnEdit = new Button("Edit");
                            private final Button btnDelete = new Button("Hapus");

                            {
                                btnEdit.setOnAction(e -> {
                                    int idx = getIndex();
                                    if (idx >= 0 && idx < tableView.getItems().size()) {
                                        Student s = tableView.getItems().get(idx);
                                        MainController.this.startEdit(s);
                                    }
                                });

                                btnDelete.setOnAction(e -> {
                                    int idx = getIndex();
                                    if (idx >= 0 && idx < tableView.getItems().size()) {
                                        Student s = tableView.getItems().get(idx);

                                        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                                        confirm.setTitle("Konfirmasi");
                                        confirm.setHeaderText(null);
                                        confirm.setContentText("Yakin menghapus: " + s.getName() + "?");
                                        confirm.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

                                        confirm.showAndWait().ifPresent(result -> {
                                            if (result == ButtonType.YES) {
                                                data.remove(s);
                                                service.deleteStudent(s.getNpm());
                                            }
                                        });
                                    }
                                });
                            }

                            @Override
                            protected void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);

                                if (empty) {
                                    setGraphic(null);
                                } else {
                                    HBox box = new HBox(10, btnEdit, btnDelete);
                                    setGraphic(box);
                                }
                            }
                        };
                    }
                };

        colAction.setCellFactory(cellFactory);
    }

    private void startEdit(Student s) {
        npmField.setText(s.getNpm());
        npmField.setDisable(true);
        nameField.setText(s.getName());
        gpaField.setText(String.valueOf(s.getGpa()));

        editNpm = s.getNpm();
        isEditMode = true;
    }

    private void clearForm() {
        npmField.setDisable(false);
        npmField.clear();
        nameField.clear();
        gpaField.clear();
    }
}