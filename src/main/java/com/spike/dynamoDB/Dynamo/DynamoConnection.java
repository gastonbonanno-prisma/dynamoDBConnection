package com.spike.dynamoDB.Dynamo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class DynamoConnection {

    private AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    private DynamoDB dynamoDB = new DynamoDB(client);
    private final String TABLE_NAME = "notifications";



    public String retrieveItem() {

        System.out.println("retrieveItem: " +TABLE_NAME + " - " + client + " - " + dynamoDB);

        Table table = dynamoDB.getTable(TABLE_NAME);

        System.out.println("Tablee: "+table);
        String resp = "";

        try {

            PrimaryKey pk = new PrimaryKey();
            pk.addComponent("cuit",123456)
                    .addComponent("id",2);


            Item item = table.getItem(pk);
            resp = item.toJSONPretty();

            System.out.println("Printing item after retrieving it....");
            System.out.println(resp);
        }
        catch (Exception e) {
            System.err.println("GetItem failed.");
            System.err.println("error: "+e.getMessage());
        }


        return resp;
    }

    public void createItem() {

        Table table = dynamoDB.getTable(TABLE_NAME);

        System.out.println("tableee: "+table.getDescription());

        try {

            Item item = new Item().withPrimaryKey("id", 2)
                    .withNumber("cuit", 123456);
//                    .withString("Title", "Book 120 Title")
//                    .withString("ISBN", "120-1111111111")
//                    .withStringSet("Authors", new HashSet<>(Arrays.asList("Author12", "Author22")))
//                    .withNumber("Price", 20).withString("Dimensions", "8.5x11.0x.75").withNumber("PageCount", 500)
//                    .withBoolean("InPublication", false).withString("ProductCategory", "Book");
            table.putItem(item);

//            item = new Item().withPrimaryKey("Id", 121)
//                    .withString("Title", "Book 121 Title")
//                    .withString("ISBN", "121-1111111111")
//                    .withStringSet("Authors", new HashSet<String>(Arrays.asList("Author21", "Author 22")))
//                    .withNumber("Price", 20).withString("Dimensions", "8.5x11.0x.75").withNumber("PageCount", 500)
//                    .withBoolean("InPublication", true).withString("ProductCategory", "Book");
//            table.putItem(item);


        }
        catch (Exception e) {
            System.err.println("Create items failed.");
            System.err.println(e.getMessage());

        }
    }


//    public void updateAddNewAttribute() {
//        Table table = dynamoDB.getTable(TABLE_NAME);
//
//        try {
//
//            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("Id", 121)
//                    .withUpdateExpression("set #na = :val1").withNameMap(new NameMap().with("#na", "NewAttribute"))
//                    .withValueMap(new ValueMap().withString(":val1", "Some value")).withReturnValues(ReturnValue.ALL_NEW);
//
//            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
//
//            // Check the response.
//            System.out.println("Printing item after adding new attribute...");
//            System.out.println(outcome.getItem().toJSONPretty());
//
//        }
//        catch (Exception e) {
//            System.err.println("Failed to add new attribute in " + TABLE_NAME);
//            System.err.println(e.getMessage());
//        }
//    }
//
//    public void updateMultipleAttributes() {
//
//        Table table = dynamoDB.getTable(TABLE_NAME);
//
//        try {
//
//            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("Id", 120)
//                    .withUpdateExpression("add #a :val1 set #na=:val2")
//                    .withNameMap(new NameMap().with("#a", "Authors").with("#na", "NewAttribute"))
//                    .withValueMap(
//                            new ValueMap().withStringSet(":val1", "Author YY", "Author ZZ").withString(":val2", "someValue"))
//                    .withReturnValues(ReturnValue.ALL_NEW);
//
//            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
//
//            // Check the response.
//            System.out.println("Printing item after multiple attribute update...");
//            System.out.println(outcome.getItem().toJSONPretty());
//
//        }
//        catch (Exception e) {
//            System.err.println("Failed to update multiple attributes in " + TABLE_NAME);
//            System.err.println(e.getMessage());
//
//        }
//    }
//
//    public void updateExistingAttributeConditionally() {
//
//        Table table = dynamoDB.getTable(TABLE_NAME);
//
//        try {
//
//            // Specify the desired price (25.00) and also the condition (price =
//            // 20.00)
//
//            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("Id", 120)
//                    .withReturnValues(ReturnValue.ALL_NEW).withUpdateExpression("set #p = :val1")
//                    .withConditionExpression("#p = :val2").withNameMap(new NameMap().with("#p", "Price"))
//                    .withValueMap(new ValueMap().withNumber(":val1", 25).withNumber(":val2", 20));
//
//            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
//
//            // Check the response.
//            System.out.println("Printing item after conditional update to new attribute...");
//            System.out.println(outcome.getItem().toJSONPretty());
//
//        }
//        catch (Exception e) {
//            System.err.println("Error updating item in " + TABLE_NAME);
//            System.err.println(e.getMessage());
//        }
//    }
//
//    public void deleteItem() {
//
//        Table table = dynamoDB.getTable(TABLE_NAME);
//
//        try {
//
//            DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("Id", 120)
//                    .withConditionExpression("#ip = :val").withNameMap(new NameMap().with("#ip", "InPublication"))
//                    .withValueMap(new ValueMap().withBoolean(":val", false)).withReturnValues(ReturnValue.ALL_OLD);
//
//            DeleteItemOutcome outcome = table.deleteItem(deleteItemSpec);
//
//            // Check the response.
//            System.out.println("Printing item that was deleted...");
//            System.out.println(outcome.getItem().toJSONPretty());
//
//        }
//        catch (Exception e) {
//            System.err.println("Error deleting item in " + TABLE_NAME);
//            System.err.println(e.getMessage());
//        }
//    }
//




}
