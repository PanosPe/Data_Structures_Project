cd com.ergasia03.maven.java 											    // Για να πάμε στο φάκελο που υπάρχει το αρχείο pom.xml
mvn compile																	// Για την μεταγλώττιση του κώδικα
mvn clean package														  	// Για να φτιαχτεί αρχείο JAR
java -cp target/com.ergasia03.maven.java-1.0-SNAPSHOT.jar HuffmanCoding	    // Για να εκτελεστεί το πρόγραμμα
