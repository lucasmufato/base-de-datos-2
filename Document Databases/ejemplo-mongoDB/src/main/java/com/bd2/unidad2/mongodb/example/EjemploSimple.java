package com.bd2.unidad2.mongodb.example;


import com.mongodb.client.*;
import org.bson.Document;

public class EjemploSimple {

    public static void main(String[] args){
        System.out.println("Starting");

        String connection = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(connection);
        System.out.println("Conectado!");

        System.out.println("Las BDs displonibles son: ");
        mongoClient.listDatabaseNames().forEach(System.out::println);
        MongoDatabase db;
        db = mongoClient.getDatabase("mongo_test");
        System.out.println("Conectado a mongo_test, las colecciones son:");
        db.listCollectionNames().forEach(System.out::println);

        MongoCollection<Document> collection = db.getCollection("example");
        long cantidadDocts = collection.countDocuments();
        System.out.println(String.format("Inspeccionando la coleccion example, tiene %s documentos", cantidadDocts));

        System.out.println("Insertando a cherencio y lucas");
        Document doc = generarDocumentoConCherencio(cantidadDocts++);
        collection.insertOne(doc);
        doc = generarDocumentoConLucas(cantidadDocts);
        collection.insertOne(doc);

        System.out.println("En la bd estan los documentos:");
        FindIterable<Document> documents = collection.find();
        documents.forEach(System.out::println);
    }

    private static Document generarDocumentoConLucas(long cantidadDocts) {
        Document doc = new Document();
        doc.append("id", cantidadDocts);
        doc.append("nombre", "Mufato Lucas");
        doc.append("profesion", "Ayudante");
        doc.append("edad", 60);
        return doc;
    }

    private static Document generarDocumentoConCherencio(long cantidadDocts) {
        Document doc = new Document();
        doc.append("id", cantidadDocts);
        doc.append("nombre", "Guillermo Cherencio");
        doc.append("profesion", "Docente");
        doc.append("edad", 60);
        return doc;
    }


}
