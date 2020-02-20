#SQL, MySql

## Datenbank erstellen

	CREATE SCHEMA `java_test_db` ;

## Tabelle erzeugen

	CREATE TABLE `java_test_db`.`personen` (
	  `id` INT NOT NULL AUTO_INCREMENT,
	  `vorname` VARCHAR(45) NULL,
	  `nachname` VARCHAR(45) NULL,
	  `geburtsjahr` INT NULL,
	  PRIMARY KEY (`id`),
	  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
## Select

	SELECT * FROM java_test_db.personen;
	
## Insert

	INSERT INTO `java_test_db`.`personen` (`vorname`, `nachname`, `geburtsjahr`) VALUES ('Max', 'Musterman', '1960');
	
## Drop Table

	DROP TABLE `java_test_db`.`tiere`;