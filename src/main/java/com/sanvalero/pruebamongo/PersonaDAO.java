package com.sanvalero.pruebamongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.sanvalero.pruebamongo.domain.Persona;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Creado por @ author: Pedro Orós
 * el 21/11/2020
 */
public class PersonaDAO {

    private MongoDatabase db;

    public void conectar() {
        MongoClient mongoClient = new MongoClient();
        db = mongoClient.getDatabase("personas");;
    }

    public void guardar(Persona persona) {
        Document document = new Document("nombre", persona.getNombre())
                .append("apellidos", persona.getApellidos())
                .append("edad", persona.getEdad());
        db.getCollection("persona").insertOne(document);
    }

    public List mostrarPersonas() {
        Document document = new Document();
        FindIterable findIterable = db.getCollection("persona").find(document);
        List<Persona> listaPersonas = new ArrayList<>();
        Persona persona;
        Iterator<Document> iterator= findIterable.iterator();
        while(iterator.hasNext()) {
            Document documento = iterator.next();
            persona = new Persona();
            persona.setNombre(documento.getString("nombre"));
            persona.setApellidos(documento.getString("apellidos"));
            persona.setEdad(documento.getInteger("edad"));
            listaPersonas.add(persona);
        }
        return listaPersonas;
    }

    public void modificar(Persona persona) {
        db.getCollection("persona").replaceOne(new Document("nombre", persona.getNombreAnterior()), new Document()
                .append("nombre", persona.getNombre())
                .append("apellidos", persona.getApellidos())
                .append("edad", persona.getEdad()));
    }

    public void eliminar(Persona persona) {
        db.getCollection("persona").deleteOne(new Document("nombre", persona.getNombre()));
    }
}
