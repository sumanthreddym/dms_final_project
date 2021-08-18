-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema INSURANCE_COMPANY
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema INSURANCE_COMPANY
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `INSURANCE_COMPANY` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `INSURANCE_COMPANY` ;

-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ACCOUNT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ACCOUNT` (
  `account_id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `tax_id_number` VARCHAR(50) NULL DEFAULT NULL,
  `email_address` VARCHAR(50) NULL DEFAULT NULL,
  `phone_number` VARCHAR(50) NULL DEFAULT NULL,
  `account_established_date` DATETIME NULL DEFAULT NULL,
  `account_start_date` DATETIME NULL DEFAULT NULL,
  `account_end_date` DATETIME NULL DEFAULT NULL,
  `is_active` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ADDRESS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ADDRESS` (
  `address_id` VARCHAR(50) NOT NULL,
  `address_detail` VARCHAR(50) NULL DEFAULT NULL,
  `city` VARCHAR(50) NULL DEFAULT NULL,
  `state` VARCHAR(50) NULL DEFAULT NULL,
  `zipcode` VARCHAR(50) NULL DEFAULT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `is_current_address` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`COMPANY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`COMPANY` (
  `company_code` VARCHAR(50) NOT NULL,
  `company_name` VARCHAR(50) NULL DEFAULT NULL,
  `customer_service_phone` VARCHAR(50) NULL DEFAULT NULL,
  `address_id` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`company_code`),
  INDEX `address_id` (`address_id` ASC) VISIBLE,
  CONSTRAINT `company_ibfk_1`
    FOREIGN KEY (`address_id`)
    REFERENCES `INSURANCE_COMPANY`.`ADDRESS` (`address_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ASSOCIATE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ASSOCIATE` (
  `associate_ssn` VARCHAR(50) NOT NULL,
  `fname` VARCHAR(50) NULL DEFAULT NULL,
  `lname` VARCHAR(50) NULL DEFAULT NULL,
  `role` VARCHAR(50) NULL DEFAULT NULL,
  `date_of_birth` DATETIME NULL DEFAULT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `phone_number` VARCHAR(50) NULL DEFAULT NULL,
  `email_address` VARCHAR(50) NULL DEFAULT NULL,
  `address_id` VARCHAR(50) NULL DEFAULT NULL,
  `company_code` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`associate_ssn`),
  INDEX `address_id` (`address_id` ASC) VISIBLE,
  INDEX `company_code` (`company_code` ASC) VISIBLE,
  CONSTRAINT `associate_ibfk_1`
    FOREIGN KEY (`address_id`)
    REFERENCES `INSURANCE_COMPANY`.`ADDRESS` (`address_id`),
  CONSTRAINT `associate_ibfk_2`
    FOREIGN KEY (`company_code`)
    REFERENCES `INSURANCE_COMPANY`.`COMPANY` (`company_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ACCOUNT_ADMIN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ACCOUNT_ADMIN` (
  `account_admin_id` VARCHAR(50) NOT NULL,
  `account_id` VARCHAR(50) NULL DEFAULT NULL,
  `associate_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `is_active` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`account_admin_id`),
  INDEX `account_id` (`account_id` ASC) VISIBLE,
  INDEX `associate_ssn` (`associate_ssn` ASC) VISIBLE,
  CONSTRAINT `account_admin_ibfk_1`
    FOREIGN KEY (`account_id`)
    REFERENCES `INSURANCE_COMPANY`.`ACCOUNT` (`account_id`),
  CONSTRAINT `account_admin_ibfk_2`
    FOREIGN KEY (`associate_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`ASSOCIATE` (`associate_ssn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`BILLING_ACCOUNT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`BILLING_ACCOUNT` (
  `billing_account_id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `name2` VARCHAR(50) NULL DEFAULT NULL,
  `address_id` VARCHAR(50) NULL DEFAULT NULL,
  `tax_id_number` VARCHAR(50) NULL DEFAULT NULL,
  `online_billing_flag` TINYINT NULL DEFAULT NULL,
  `activity_status` VARCHAR(50) NULL DEFAULT NULL,
  `activity_status_date` DATETIME NULL DEFAULT NULL,
  `web_address` VARCHAR(200) NULL DEFAULT NULL,
  `is_payroll_processed` TINYINT NULL DEFAULT NULL,
  `billing_acct_type_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`billing_account_id`),
  INDEX `address_id` (`address_id` ASC) VISIBLE,
  CONSTRAINT `billing_account_ibfk_1`
    FOREIGN KEY (`address_id`)
    REFERENCES `INSURANCE_COMPANY`.`ADDRESS` (`address_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ACCOUNT_BILLING_ACCOUNT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ACCOUNT_BILLING_ACCOUNT` (
  `account_id` VARCHAR(50) NULL DEFAULT NULL,
  `billing_account_id` VARCHAR(50) NULL DEFAULT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `billing_frequency` INT NULL DEFAULT NULL,
  `non_billable_months` INT NULL DEFAULT NULL,
  `enrollment_period_length` INT NULL DEFAULT NULL,
  `fsa_claim_reimbursement_method` VARCHAR(50) NULL DEFAULT NULL,
  `is_payment_card` TINYINT NULL DEFAULT NULL,
  `is_ifca_exception` TINYINT NULL DEFAULT NULL,
  `account_billing_account_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`account_billing_account_id`),
  INDEX `account_billing_account_ibfk_1` (`account_id` ASC) VISIBLE,
  INDEX `account_billing_account_ibfk_2` (`billing_account_id` ASC) VISIBLE,
  CONSTRAINT `account_billing_account_ibfk_1`
    FOREIGN KEY (`account_id`)
    REFERENCES `INSURANCE_COMPANY`.`ACCOUNT` (`account_id`),
  CONSTRAINT `account_billing_account_ibfk_2`
    FOREIGN KEY (`billing_account_id`)
    REFERENCES `INSURANCE_COMPANY`.`BILLING_ACCOUNT` (`billing_account_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`CUSTOMER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`CUSTOMER` (
  `customer_ssn` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(50) NULL DEFAULT NULL,
  `middle_initial` VARCHAR(50) NULL DEFAULT NULL,
  `last_name` VARCHAR(50) NULL DEFAULT NULL,
  `suffix` VARCHAR(50) NULL DEFAULT NULL,
  `date_of_birth` DATETIME NULL DEFAULT NULL,
  `salutation` VARCHAR(50) NULL DEFAULT NULL,
  `email_address` VARCHAR(50) NULL DEFAULT NULL,
  `gender` VARCHAR(50) NULL DEFAULT NULL,
  `preferred_language` VARCHAR(50) NULL DEFAULT NULL,
  `address_id` VARCHAR(50) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_ssn`),
  INDEX `address_id` (`address_id` ASC) VISIBLE,
  CONSTRAINT `customer_ibfk_1`
    FOREIGN KEY (`address_id`)
    REFERENCES `INSURANCE_COMPANY`.`ADDRESS` (`address_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ACCOUNT_MEMBER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ACCOUNT_MEMBER` (
  `customer_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `account_id` VARCHAR(50) NULL DEFAULT NULL,
  `fsa_contribution_amount` DOUBLE NULL DEFAULT NULL,
  `cust_b_acct_department_name` VARCHAR(50) NULL DEFAULT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `account_member_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`account_member_id`),
  INDEX `account_member_ibfk_1` (`account_id` ASC) VISIBLE,
  INDEX `account_member_ibfk_2` (`customer_ssn` ASC) VISIBLE,
  CONSTRAINT `account_member_ibfk_1`
    FOREIGN KEY (`account_id`)
    REFERENCES `INSURANCE_COMPANY`.`ACCOUNT` (`account_id`),
  CONSTRAINT `account_member_ibfk_2`
    FOREIGN KEY (`customer_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`CUSTOMER` (`customer_ssn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`METAL_LEVEL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`METAL_LEVEL` (
  `metal_level_id` VARCHAR(50) NOT NULL,
  `metal_level_name` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`metal_level_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`PRODUCT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`PRODUCT` (
  `product_id` VARCHAR(50) NOT NULL,
  `plan_name` VARCHAR(50) NULL DEFAULT NULL,
  `line_of_business` VARCHAR(50) NULL DEFAULT NULL,
  `metal_level_id` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `company_code` VARCHAR(50) NULL DEFAULT NULL,
  `rating_area` VARCHAR(50) NULL DEFAULT NULL,
  `is_adult_child_only` TINYINT NULL DEFAULT NULL,
  `network_url` VARCHAR(100) NULL DEFAULT NULL,
  `plan_brochure_url` VARCHAR(100) NULL DEFAULT NULL,
  `benefits_sumary_url` VARCHAR(100) NULL DEFAULT NULL,
  `drug_formula_url` VARCHAR(100) NULL DEFAULT NULL,
  `is_dental_included` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `company_code` (`company_code` ASC) VISIBLE,
  INDEX `metal_level_id` (`metal_level_id` ASC) VISIBLE,
  CONSTRAINT `product_ibfk_1`
    FOREIGN KEY (`company_code`)
    REFERENCES `INSURANCE_COMPANY`.`COMPANY` (`company_code`),
  CONSTRAINT `product_ibfk_2`
    FOREIGN KEY (`metal_level_id`)
    REFERENCES `INSURANCE_COMPANY`.`METAL_LEVEL` (`metal_level_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ACCOUNT_PRODUCT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ACCOUNT_PRODUCT` (
  `account_id` VARCHAR(50) NULL DEFAULT NULL,
  `product_id` VARCHAR(50) NULL DEFAULT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `account_product_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`account_product_id`),
  INDEX `account_product_ibfk_1` (`account_id` ASC) VISIBLE,
  INDEX `account_product_ibfk_2` (`product_id` ASC) VISIBLE,
  CONSTRAINT `account_product_ibfk_1`
    FOREIGN KEY (`account_id`)
    REFERENCES `INSURANCE_COMPANY`.`ACCOUNT` (`account_id`),
  CONSTRAINT `account_product_ibfk_2`
    FOREIGN KEY (`product_id`)
    REFERENCES `INSURANCE_COMPANY`.`PRODUCT` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ACCOUNT_RELATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ACCOUNT_RELATION` (
  `master_account_id` VARCHAR(50) NULL DEFAULT NULL,
  `related_account_id` VARCHAR(50) NULL DEFAULT NULL,
  `relationship_type` VARCHAR(50) NULL DEFAULT NULL,
  `relation_type_date` DATETIME NULL DEFAULT NULL,
  `account_relation_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`account_relation_id`),
  INDEX `master_account_id` (`master_account_id` ASC) VISIBLE,
  INDEX `related_account_id` (`related_account_id` ASC) VISIBLE,
  CONSTRAINT `account_relation_ibfk_1`
    FOREIGN KEY (`master_account_id`)
    REFERENCES `INSURANCE_COMPANY`.`ACCOUNT` (`account_id`),
  CONSTRAINT `account_relation_ibfk_2`
    FOREIGN KEY (`related_account_id`)
    REFERENCES `INSURANCE_COMPANY`.`ACCOUNT` (`account_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ROLE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ROLE` (
  `role_id` VARCHAR(50) NOT NULL,
  `type` VARCHAR(50) NULL DEFAULT NULL,
  `phone_number` VARCHAR(50) NULL DEFAULT NULL,
  `district_name` VARCHAR(50) NULL DEFAULT NULL,
  `region_name` VARCHAR(50) NULL DEFAULT NULL,
  `state_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`ASSOCIATE_ROLE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`ASSOCIATE_ROLE` (
  `associate_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `role_id` VARCHAR(50) NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `associate_role_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`associate_role_id`),
  INDEX `associate_role_ibfk_1` (`role_id` ASC) VISIBLE,
  INDEX `associate_role_ibfk_2` (`associate_ssn` ASC) VISIBLE,
  CONSTRAINT `associate_role_ibfk_1`
    FOREIGN KEY (`role_id`)
    REFERENCES `INSURANCE_COMPANY`.`ROLE` (`role_id`),
  CONSTRAINT `associate_role_ibfk_2`
    FOREIGN KEY (`associate_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`ASSOCIATE` (`associate_ssn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`CHRONIC_DISEASES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`CHRONIC_DISEASES` (
  `chronic_disease_id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `typical_age` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `medication` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`chronic_disease_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`CHRONIC_DISEASE_CUSTOMER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`CHRONIC_DISEASE_CUSTOMER` (
  `customer_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `chronic_disease_id` VARCHAR(50) NULL DEFAULT NULL,
  `is_predicted` TINYINT NULL DEFAULT NULL,
  `chronic_disease_customer_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`chronic_disease_customer_id`),
  INDEX `chronic_disease_customer_ibfk_1` (`chronic_disease_id` ASC) VISIBLE,
  INDEX `chronic_disease_customer_ibfk_2` (`customer_ssn` ASC) VISIBLE,
  CONSTRAINT `chronic_disease_customer_ibfk_1`
    FOREIGN KEY (`chronic_disease_id`)
    REFERENCES `INSURANCE_COMPANY`.`CHRONIC_DISEASES` (`chronic_disease_id`),
  CONSTRAINT `chronic_disease_customer_ibfk_2`
    FOREIGN KEY (`customer_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`CUSTOMER` (`customer_ssn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`REGION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`REGION` (
  `region_id` VARCHAR(50) NOT NULL,
  `region_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`region_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`COUNTY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`COUNTY` (
  `county_id` VARCHAR(50) NOT NULL,
  `county_name` VARCHAR(50) NULL DEFAULT NULL,
  `state` VARCHAR(10) NULL DEFAULT NULL,
  `region_id` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`county_id`),
  INDEX `region_id` (`region_id` ASC) VISIBLE,
  CONSTRAINT `county_ibfk_1`
    FOREIGN KEY (`region_id`)
    REFERENCES `INSURANCE_COMPANY`.`REGION` (`region_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`CUSTOMER_IMAGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`CUSTOMER_IMAGE` (
  `document_id` VARCHAR(50) NOT NULL,
  `customer_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `image_type` VARCHAR(50) NULL DEFAULT NULL,
  `image_file_location` VARCHAR(200) NULL DEFAULT NULL,
  `date_received` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`document_id`),
  INDEX `customer_ssn` (`customer_ssn` ASC) VISIBLE,
  CONSTRAINT `customer_image_ibfk_1`
    FOREIGN KEY (`customer_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`CUSTOMER` (`customer_ssn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`CUSTOMER_RELATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`CUSTOMER_RELATION` (
  `customer1_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `customer2_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `relationship` VARCHAR(50) NULL DEFAULT NULL,
  `customer_relation_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`customer_relation_id`),
  INDEX `customer1_ssn` (`customer1_ssn` ASC) VISIBLE,
  INDEX `customer2_ssn` (`customer2_ssn` ASC) VISIBLE,
  CONSTRAINT `customer_relation_ibfk_1`
    FOREIGN KEY (`customer1_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`CUSTOMER` (`customer_ssn`),
  CONSTRAINT `customer_relation_ibfk_2`
    FOREIGN KEY (`customer2_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`CUSTOMER` (`customer_ssn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`INVOICE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`INVOICE` (
  `invoice_id` VARCHAR(50) NOT NULL,
  `billing_account_id` VARCHAR(50) NULL DEFAULT NULL,
  `customer_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `due_date` DATETIME NULL DEFAULT NULL,
  `paid_date` DATETIME NULL DEFAULT NULL,
  `run_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  INDEX `customer_ssn` (`customer_ssn` ASC) VISIBLE,
  INDEX `billing_account_id` (`billing_account_id` ASC) VISIBLE,
  CONSTRAINT `invoice_ibfk_1`
    FOREIGN KEY (`customer_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`CUSTOMER` (`customer_ssn`),
  CONSTRAINT `invoice_ibfk_2`
    FOREIGN KEY (`billing_account_id`)
    REFERENCES `INSURANCE_COMPANY`.`BILLING_ACCOUNT` (`billing_account_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`INVOICE_DETAILS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`INVOICE_DETAILS` (
  `invoice_id` VARCHAR(50) NULL DEFAULT NULL,
  `invoice_line_number` VARCHAR(50) NOT NULL,
  `is_conversion_pending` TINYINT NULL DEFAULT NULL,
  `is_paid` TINYINT NULL DEFAULT NULL,
  `premium_sub_total` DOUBLE NULL DEFAULT NULL,
  `due_date` DATETIME NULL DEFAULT NULL,
  `paid_date` DATETIME NULL DEFAULT NULL,
  `run_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`invoice_line_number`),
  INDEX `invoice_id` (`invoice_id` ASC) VISIBLE,
  CONSTRAINT `invoice_details_ibfk_1`
    FOREIGN KEY (`invoice_id`)
    REFERENCES `INSURANCE_COMPANY`.`INVOICE` (`invoice_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`PRODUCT_QUOTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`PRODUCT_QUOTE` (
  `product_quote_id` VARCHAR(50) NOT NULL,
  `region_id` VARCHAR(50) NULL DEFAULT NULL,
  `product_id` VARCHAR(50) NULL DEFAULT NULL,
  `age` DOUBLE NULL DEFAULT NULL,
  `num_of_people_on_plan` INT NULL DEFAULT NULL,
  `bmi` DOUBLE NULL DEFAULT NULL,
  `is_smoker` TINYINT NULL DEFAULT NULL,
  `charges` DOUBLE NULL DEFAULT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`product_quote_id`),
  INDEX `region_id` (`region_id` ASC) VISIBLE,
  INDEX `product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `product_quote_ibfk_1`
    FOREIGN KEY (`region_id`)
    REFERENCES `INSURANCE_COMPANY`.`REGION` (`region_id`),
  CONSTRAINT `product_quote_ibfk_2`
    FOREIGN KEY (`product_id`)
    REFERENCES `INSURANCE_COMPANY`.`PRODUCT` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`QUOTE_REQUEST`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`QUOTE_REQUEST` (
  `quote_request_id` VARCHAR(50) NOT NULL,
  `customer_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `associate_ssn` VARCHAR(50) NULL DEFAULT NULL,
  `region_id` VARCHAR(50) NULL DEFAULT NULL,
  `metal_level_id` VARCHAR(50) NULL DEFAULT NULL,
  `number_of_people_on_plan` INT NULL DEFAULT NULL,
  `bmi` DOUBLE NULL DEFAULT NULL,
  `is_smoker` TINYINT NULL DEFAULT NULL,
  `max_price` DOUBLE NULL DEFAULT NULL,
  `is_sale_complete` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`quote_request_id`),
  INDEX `associate_ssn` (`associate_ssn` ASC) VISIBLE,
  INDEX `customer_ssn` (`customer_ssn` ASC) VISIBLE,
  INDEX `region_id` (`region_id` ASC) VISIBLE,
  INDEX `metal_level_id` (`metal_level_id` ASC) VISIBLE,
  CONSTRAINT `quote_request_ibfk_1`
    FOREIGN KEY (`associate_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`ASSOCIATE` (`associate_ssn`),
  CONSTRAINT `quote_request_ibfk_2`
    FOREIGN KEY (`customer_ssn`)
    REFERENCES `INSURANCE_COMPANY`.`CUSTOMER` (`customer_ssn`),
  CONSTRAINT `quote_request_ibfk_3`
    FOREIGN KEY (`region_id`)
    REFERENCES `INSURANCE_COMPANY`.`REGION` (`region_id`),
  CONSTRAINT `quote_request_ibfk_4`
    FOREIGN KEY (`metal_level_id`)
    REFERENCES `INSURANCE_COMPANY`.`METAL_LEVEL` (`metal_level_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `INSURANCE_COMPANY`.`QUOTE_REQUEST_PRODUCT_QUOTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INSURANCE_COMPANY`.`QUOTE_REQUEST_PRODUCT_QUOTE` (
  `quote_request_product_quote_id` VARCHAR(50) NOT NULL,
  `quote_request_id` VARCHAR(50) NULL DEFAULT NULL,
  `product_quote_id` VARCHAR(50) NULL DEFAULT NULL,
  `is_accepted` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`quote_request_product_quote_id`),
  INDEX `quote_request_id` (`quote_request_id` ASC) VISIBLE,
  INDEX `product_quote_id` (`product_quote_id` ASC) VISIBLE,
  CONSTRAINT `quote_request_product_quote_ibfk_1`
    FOREIGN KEY (`quote_request_id`)
    REFERENCES `INSURANCE_COMPANY`.`QUOTE_REQUEST` (`quote_request_id`),
  CONSTRAINT `quote_request_product_quote_ibfk_2`
    FOREIGN KEY (`product_quote_id`)
    REFERENCES `INSURANCE_COMPANY`.`PRODUCT_QUOTE` (`product_quote_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
