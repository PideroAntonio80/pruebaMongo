package com.sanvalero.pruebamongo;

import com.sanvalero.pruebamongo.domain.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Creado por @ author: Pedro Orós
 * el 21/11/2020
 */
public class AppController implements Initializable {

    public TextField tfNombre;
    public TextField tfApellidos;
    public TextField tfEdad;

    public TableView<Persona> tvDatos;
    public TableColumn<Persona, String>tcNombre;
    public TableColumn<Persona, String>tcApellidos;
    public TableColumn<Persona, Integer> tcEdad;
    ObservableList<Persona> listaPersonas;

    public Label lAviso;

    public ImageView ivFoto;

    private final PersonaDAO personaDAO;

    public AppController() {
        personaDAO = new PersonaDAO();

            personaDAO.conectar();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarPersonasEnTabla();
    }

    @FXML
    public  void desconectar() {

    }

    @FXML
    public void guardar(ActionEvent event) {

        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        int edad = Integer.parseInt(tfEdad.getText());

        Persona persona = new Persona(nombre, apellidos, edad);
        personaDAO.guardar(persona);
        mostrarPersonasEnTabla();
        lAviso.setText("Documento guardado");

    }

    @FXML
    public void modificar(ActionEvent event) {
        Persona personaAnterior = new Persona(tvDatos.getSelectionModel().selectedItemProperty().getValue().getNombre(),
                tvDatos.getSelectionModel().selectedItemProperty().getValue().getApellidos(),
                tvDatos.getSelectionModel().getSelectedItem().getEdad());
        String nombreAnterior = tvDatos.getSelectionModel().selectedItemProperty().getValue().getNombre();
        String apellidoAnterior = tvDatos.getSelectionModel().selectedItemProperty().getValue().getApellidos();
        int edadAnterior = tvDatos.getSelectionModel().selectedItemProperty().getValue().getEdad();
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        int edad = Integer.parseInt(tfEdad.getText());

        Persona persona = new Persona(nombreAnterior, apellidoAnterior, edadAnterior, nombre, apellidos, edad);
        personaDAO.modificar(persona);
        mostrarPersonasEnTabla();
        lAviso.setText("Documento modificado");

    }

    @FXML
    public void eliminar(ActionEvent event) {
        String nombre = tvDatos.getSelectionModel().selectedItemProperty().getValue().getNombre();
        String apellidos = tvDatos.getSelectionModel().selectedItemProperty().getValue().getApellidos();
        int edad = tvDatos.getSelectionModel().getSelectedItem().getEdad();

        Persona persona = new Persona(nombre, apellidos, edad);
        personaDAO.eliminar(persona);
        mostrarPersonasEnTabla();
        lAviso.setText("Documento eliminado");
    }

    @FXML
    public void reset(ActionEvent event) {
        tfNombre.setText("");
        tfApellidos.setText("");
        tfEdad.setText("");
        lAviso.setText("");
    }

    @FXML
    public void mostrarDatos(Event event) {
        tfNombre.setText(tvDatos.getSelectionModel().selectedItemProperty().getValue().getNombre());
        tfApellidos.setText(tvDatos.getSelectionModel().selectedItemProperty().getValue().getApellidos());
        int edad = tvDatos.getSelectionModel().getSelectedItem().getEdad();
        tfEdad.setText(String.valueOf(edad));

    }

    @FXML
    public void importar(ActionEvent event) {

    }

    @FXML
    public void exportar(ActionEvent event) {

    }

    public void mostrarPersonasEnTabla() {
        listaPersonas = FXCollections.observableArrayList(personaDAO.mostrarPersonas());
        tvDatos.setItems(listaPersonas);

        tcNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellidos"));
        tcEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));


    }

}
