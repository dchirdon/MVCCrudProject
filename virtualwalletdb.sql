-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema virtualwalletdb
-- -----------------------------------------------------
-- PUT STUFF IN IT FOOL
DROP SCHEMA IF EXISTS `virtualwalletdb` ;

-- -----------------------------------------------------
-- Schema virtualwalletdb
--
-- PUT STUFF IN IT FOOL
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `virtualwalletdb` DEFAULT CHARACTER SET utf8 ;
USE `virtualwalletdb` ;

-- -----------------------------------------------------
-- Table `Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Item` ;

CREATE TABLE IF NOT EXISTS `Item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `value` DECIMAL(6,2) NULL DEFAULT 0,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO walletuser@localhost;
 DROP USER walletuser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'walletuser'@'localhost' IDENTIFIED BY 'walletuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'walletuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Item`
-- -----------------------------------------------------
START TRANSACTION;
USE `virtualwalletdb`;
INSERT INTO `Item` (`id`, `type`, `value`, `name`) VALUES (1234, 'Credit Card', 30000, 'Wells Fargo');
INSERT INTO `Item` (`id`, `type`, `value`, `name`) VALUES (1235, 'Gift Card', 200, 'Amazon');
INSERT INTO `Item` (`id`, `type`, `value`, `name`) VALUES (1236, 'Debit Card', 3050, 'Navy Federal');

COMMIT;
