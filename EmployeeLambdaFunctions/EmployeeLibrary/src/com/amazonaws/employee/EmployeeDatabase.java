package com.amazonaws.employee;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.bson.Document;

import com.amazonaws.services.lambda.runtime.Context;
import com.mongodb.MongoClient;

public class EmployeeDatabase {
	private Context context = null;

	public EmployeeDatabase(Context context) {
		this.context = context;
	}

	public String addEmployee(String employeeId, Employee employee) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

		Document doc = new Document("firstname", "FirstName" + timeStamp).append("lastname", "LastName" + timeStamp)
				.append("age", 36).append("gender", "male");

		// Creating a Mongo client
		MongoClient mongoClient = new MongoClient("18.216.225.196", 27017);

		try {
			System.out.println("mongoClient : " + mongoClient);
		} catch (Exception e) {
			context.getLogger().log("Exception while getting databae : " + e.toString());
		}

		System.out.println("Connected to the database successfully");

		// Accessing the database
		MongoDatabase database = mongoClient.getDatabase("employeedb");
		System.out.println("MongoDatabase created successfully");

		// Creating a collection
		// database.createCollection("employeeCollection");
		System.out.println("employeeCollection created successfully");

		/*
		 * for (String name : database.listCollectionNames()) {
		 * System.out.println(name); }
		 */

		// Retieving a collection
		MongoCollection<Document> collection = database.getCollection("employeecollection");

		collection.insertOne(doc);

		return "inserted";
	}

	public Employee getEmployeeById(String employeeId) {
		return null;

	}

	public List<Employee> getEmployees() {

		List<Employee> employeeList = new ArrayList<Employee>();

		// Creating a Mongo client
		MongoClient mongoClient = new MongoClient("18.216.225.196", 27017);

		try {
			System.out.println("mongoClient : " + mongoClient);
		} catch (Exception e) {
			context.getLogger().log("Exception while getting databae : " + e.toString());
		}

		// Creating Credentials
		// MongoCredential credential =
		// MongoCredential.createCredential("sampleUser", "myDb",
		// "password".toCharArray());

		System.out.println("Connected to the database successfully");

		// Accessing the database
		MongoDatabase database = mongoClient.getDatabase("employeedb");
		System.out.println("MongoDatabase created successfully");

		// Creating a collection
		// database.createCollection("employeeCollection");
		System.out.println("employeeCollection created successfully");

		/*
		 * for (String name : database.listCollectionNames()) {
		 * System.out.println(name); }
		 */

		// Retieving a collection
		MongoCollection<Document> collection = database.getCollection("employeecollection");

		if (null != collection) {

			MongoCursor<Document> curs = collection.find().iterator();
			Employee em = null;
			try {
				while (curs.hasNext()) {
					Document doc = curs.next();

					em = new Employee();
					em.setId((String) doc.getString("_id"));
					em.setFirstName((String) doc.getString("firstName"));
					em.setLastName((String) doc.getString("lastName"));
					em.setAge((Integer) doc.getInteger("age"));
					em.setGender((String) doc.getString("gender"));

					employeeList.add(em);
				}
			} finally {
				curs.close();
			}
		}
		return employeeList;
	}

	public void insertDocument(Employee employee) {
		Document document = new Document("title", "employee").append("id", employee.getId())
				.append("firstName", employee.getFirstName()).append("lastName", employee.getLastName())
				.append("age", employee.getAge()).append("gender", employee.getGender());

		// Creating a Mongo client
		MongoClient mongoClient = new MongoClient("18.216.225.196", 27017);

		try {
			System.out.println("mongoClient : " + mongoClient);
		} catch (Exception e) {
			context.getLogger().log("Exception while getting databae : " + e.toString());
		}

		// Creating Credentials
		// MongoCredential credential =
		// MongoCredential.createCredential("sampleUser", "myDb",
		// "password".toCharArray());

		System.out.println("Connected to the database successfully");

		// Accessing the database
		MongoDatabase database = mongoClient.getDatabase("employeedb");
		System.out.println("MongoDatabase created successfully");

		// Creating a collection
		// database.createCollection("employeeCollection");
		System.out.println("employeeCollection created successfully");

		/*
		 * for (String name : database.listCollectionNames()) {
		 * System.out.println(name); }
		 */

		// Retieving a collection
		MongoCollection<Document> collection = database.getCollection("employeecollection");

		collection.insertOne(document);
	}

}
