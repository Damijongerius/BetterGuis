-- SQLINES DEMO *** rated by MySQL Workbench
-- SQLINES DEMO *** 47 2023
-- SQLINES DEMO ***    Version: 1.0
-- SQLINES DEMO *** orward Engineering

/* SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0; */
/* SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0; */
/* SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'; */

-- SQLINES DEMO *** ------------------------------------
-- Schema trophies
-- SQLINES DEMO *** ------------------------------------

-- SQLINES DEMO *** ------------------------------------
-- Schema trophies
-- SQLINES DEMO *** ------------------------------------
CREATE SCHEMA IF NOT EXISTS `trophies` DEFAULT CHARACTER SET utf8 ;
USE `trophies` ;

-- SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** `tp_Badge`
-- SQLINES DEMO *** ------------------------------------
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE IF NOT EXISTS trophies.`tp_Badge` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** `tp_Player`
-- SQLINES DEMO *** ------------------------------------
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE IF NOT EXISTS trophies.`tp_Player` (
  `UUID` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UUID`))
ENGINE = InnoDB;


-- SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** `PlayerBadge`
-- SQLINES DEMO *** ------------------------------------
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE IF NOT EXISTS trophies.`PlayerBadge` (
  `tp_Player_UUID` VARCHAR(45) NOT NULL,
  `tp_Badge_ID` INT NOT NULL,
  `UnlockDate` DATE NOT NULL,
  `Placement` INT NULL,
  `PlayerBadgecol` VARCHAR(45) NULL,
  PRIMARY KEY (`tp_Player_UUID`, `tp_Badge_ID`),
  INDEX `fk_tp_Player_has_tp_Badge_tp_Badge1_idx` (`tp_Badge_ID` ASC) VISIBLE,
  INDEX `fk_tp_Player_has_tp_Badge_tp_Player_idx` (`tp_Player_UUID` ASC) VISIBLE,
  CONSTRAINT `fk_tp_Player_has_tp_Badge_tp_Player`
    FOREIGN KEY(`tp_Player_UUID`)
    REFERENCES trophies.`tp_Player`(`UUID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tp_Player_has_tp_Badge_tp_Badge1`
    FOREIGN KEY(`tp_Badge_ID`)
    REFERENCES trophies.`tp_Badge`(`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** `tp_Kingdom`
-- SQLINES DEMO *** ------------------------------------
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE IF NOT EXISTS trophies.`tp_Kingdom` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** `KingdomBadge`
-- SQLINES DEMO *** ------------------------------------
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE IF NOT EXISTS trophies.`KingdomBadge` (
  `Kingdom_id` INT NOT NULL,
  `tp_Badge_ID` INT NOT NULL,
  `UnlockDate` DATE NOT NULL,
  `Placement` INT NULL,
  PRIMARY KEY (`Kingdom_id`, `tp_Badge_ID`),
  INDEX `fk_Kingdom_has_tp_Badge_tp_Badge1_idx` (`tp_Badge_ID` ASC) VISIBLE,
  INDEX `fk_Kingdom_has_tp_Badge_Kingdom1_idx` (`Kingdom_id` ASC) VISIBLE,
  CONSTRAINT `fk_Kingdom_has_tp_Badge_Kingdom1`
    FOREIGN KEY(`Kingdom_id`)
    REFERENCES trophies.`tp_Kingdom`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Kingdom_has_tp_Badge_tp_Badge1`
    FOREIGN KEY(`tp_Badge_ID`)
    REFERENCES trophies.`tp_Badge`(`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


/* SET SQL_MODE=@OLD_SQL_MODE; */
/* SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS; */
/* SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS; */