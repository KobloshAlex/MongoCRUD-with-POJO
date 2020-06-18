package com.cogent.info;

import com.cogent.info.dao.impl.StudentDao;
import com.cogent.info.entities.Course;
import com.cogent.info.entities.Student;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main {

    public static void main(String[] args) {

        ConnectionString connectionString = new ConnectionString
                ("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder()
                                                                         .automatic(true)
                                                                         .build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                                                                .applyConnectionString(connectionString)
                                                                .codecRegistry(codecRegistry)
                                                                .build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("cogent");

            MongoCollection<Student> studentsCollection = db.getCollection("students", Student.class);

//
            Student student = new Student().setStudentId(2)
                                           .setFirstName("Alexx")
                                           .setLastName("Koblosh")
                                           .setEmail("alex@gmial.com")
                                           .setBalance(1000)
                                           .setPassword("1123").setCourses(singletonList(new Course().setId(1)
                                                                                                     .setCode(101)
                                                                                                     .setName("Math")));
//
//            Student student1 = new Student().setFirstName("Alexx")
//                                           .setLastName("Koblosh")
//                                           .setEmail("alex@gmial.com")
//                                           .setBalance(1000)
//                                           .setPassword("1123").setCourses(singletonList(new Course().setId(1)
//                                                                                                     .setCode(101)
//                                                                                                     .setName("Math")));
//
//
//
//            //save



            StudentDao studentDao = new StudentDao(studentsCollection);
            studentDao.save(student);



            //update
            student.setBalance(3000);
            studentDao.update(student);
//
//            //delete by id
//            studentDao.deleteById(2);

            //studentsCollection.find().into(new ArrayList<>()).forEach(System.out::println);
        }
    }
}
