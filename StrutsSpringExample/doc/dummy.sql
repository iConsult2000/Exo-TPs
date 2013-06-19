/* Creation de votre utilisateur au préalable */

create database ITALIA;
grant all on ITALIA.* to cdsappl@'localhost';
SET PASSWORD FOR cdsappl@'localhost' = PASSWORD('iConsult2000');

/* Définition de la table PIZZA */

DROP TABLE IF EXISTS `ITALIA`.`PIZZA` ;
CREATE TABLE `ITALIA`.`PIZZA` (
    `PIZZA_ID` BIGINT(20) UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
    `NOM` VARCHAR(45) NOT NULL,
    `PRIX` FLOAT NOT NULL,
    PRIMARY KEY (`PIZZA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*
 * Définition de la table ingrédient
 */
DROP TABLE IF EXISTS `ITALIA`.`ingredient` ;
CREATE TABLE `ITALIA`.`ingredient` (
    `INGREDIENT_ID` BIGINT(20) UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
    `NOM` VARCHAR(45) NOT NULL,
    `PRIX` FLOAT NOT NULL,
    PRIMARY KEY (`INGREDIENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*
 * Définition de la table jointure ingredient_pizza
 */
DROP TABLE IF EXISTS `ITALIA`.`ingredient_pizza` ;
CREATE TABLE `ITALIA`.`ingredient_pizza` (
    `INGPIZZA_ID` BIGINT(20) UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
    `NOM_INGREDIENT` VARCHAR(45) DEFAULT NULL,
    `NOM_PIZZA` VARCHAR(45) DEFAULT NULL,
    `INGREDIENT_REF` BIGINT(20) UNSIGNED DEFAULT NULL,
    `PIZZA_REF` BIGINT(20) UNSIGNED DEFAULT NULL,
    PRIMARY KEY (`INGPIZZA_ID`),
    KEY `FKPIZZA` (`PIZZA_REF`),
    KEY `FKINGREDIENT` (`INGREDIENT_REF`),
    CONSTRAINT `FKPIZZA` FOREIGN KEY (`PIZZA_REF`) REFERENCES `PIZZA` (`PIZZA_ID`),
    CONSTRAINT `FKINGREDIENT` FOREIGN KEY (`INGREDIENT_REF`) REFERENCES `ingredient` (`INGREDIENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*
 * Définition de la table customer
 */
DROP TABLE IF EXISTS `ITALIA`.`customer`;
CREATE TABLE  `ITALIA`.`customer` (
  `CUSTOMER_ID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NOM` VARCHAR(45) NOT NULL,
  `PRENOM` VARCHAR(45) DEFAULT NULL,
  `ADRESSE` VARCHAR(255) NOT NULL,
  `TELEPHONE` VARCHAR(10) DEFAULT NULL,
  `CREATED_DATE` datetime NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Jeu de données
 * Steeve + Lory + Manuel
 *  */


insert into PIZZA values ('','Pizza Dolce Italia','');
insert into PIZZA values ('','Pizza carciofi','');
insert into PIZZA values ('','Pizza chèvre et courgette','');
insert into PIZZA values ('','Pizza aux légumes grillés','');
insert into PIZZA values ('','Pizza artichaut et coppa','');
insert into PIZZA values ('','Pizza melon et jambon cru Italia','');
insert into PIZZA values ('','Pizza Bresaola et Roquette','');


insert into customer values ('', 'DACALOR', 'Steeve', 'Rue basse, Auneau 28700, EURE-ET-LOIR', '0234678912',SYSDATE());
insert into customer values ('', 'BRAY', 'Yohann', 'Place de Vinci, Paris 75120, PARIS', '0934678912',SYSDATE());
insert into customer values ('', 'PHEJAR', 'Manuel', 'Espace de LIsle, Vendôme 34000, ARPAJON', '0345678912',SYSDATE());
insert into customer values ('', 'FERRAND', 'Lory', 'Résidence les Charmilles, Nîmes 35000, NÎMES', '0654127895',SYSDATE());



insert into ingredient values ('','Boeuf','1.5');
insert into ingredient values ('','Légumes','1.5');
insert into ingredient values ('', 'Emmental', '1.0');
insert into ingredient values ('','Jambon', '1.0');
insert into ingredient values ('','Merguez','1.5');
insert into ingredient values ('','PateEpaisse','1.0');
insert into ingredient values ('','PateFine','0.5');
insert into ingredient values ('','Poulet','1.5');

/* Pizza Dolce Italia (Boeuf, Jambon, Merguez, Poulet, PateFine) */
insert into ingredient_pizza values ('','Boeuf','Pizza Dolce Italia','10','10');
insert into ingredient_pizza values ('','Jambon','Pizza Dolce Italia','13','10');
insert into ingredient_pizza values ('','Merguez','Pizza Dolce Italia','14','10');
insert into ingredient_pizza values ('','Poulet','Pizza Dolce Italia','17','10');
insert into ingredient_pizza values ('','PateFine','Pizza Dolce Italia','16','10');

/* Pizza carciofi(Légumes,Merguez, PateEpaisse) */
insert into ingredient_pizza values ('','Boeuf','Pizza carciofi','10','11');
insert into ingredient_pizza values ('','Jambon','Pizza carciofi','13','11');
insert into ingredient_pizza values ('','Merguez','Pizza carciofi','14','11');

/* Pizza chèvre et courgette ( Emmental, légumes, PateFine) */
insert into ingredient_pizza values('','Emmental','Pizza chèvre et courgette','12','12');
insert into ingredient_pizza values('','Légumes','Pizza chèvre et courgette','11','12');
insert into ingredient_pizza values('','PateFine','Pizza chèvre et courgette','Légumes16','12');

/* Pizza aux légumes grillés (5 légumes, PateEpaisse) */
insert into ingredient_pizza values('','Légumes','Pizza aux légumes grillés','11','13');
insert into ingredient_pizza values('','Légumes','Pizza aux légumes grillés','11','13');
insert into ingredient_pizza values('','Légumes','Pizza aux légumes grillés','11','13');
insert into ingredient_pizza values('','Légumes','Pizza aux légumes grillés','11','13');
insert into ingredient_pizza values('','Légumes','Pizza aux légumes grillés','11','13');
insert into ingredient_pizza values('','PateEpaisse','Pizza aux légumes grillés','15','13');


/* Pizza artichaut et coppa (3 légumes, Poulet, PateFine) */

insert into ingredient_pizza values('','Légumes','Pizza artichaut et coppa','11','14');
insert into ingredient_pizza values('','Légumes','Pizza artichaut et coppa','11','14');
insert into ingredient_pizza values('','Légumes','Pizza artichaut et coppa','11','14');
insert into ingredient_pizza values('','Poulet','Pizza artichaut et coppa','17','14');
insert into ingredient_pizza values('','PateFine','Pizza artichaut et coppa','16','14');

/* Pizza melon et jambon cru Italia (légumes, Jambon, PateFine) */
insert into ingredient_pizza values('','Légumes','Pizza melon et jambon cru Italia','11','15');
insert into ingredient_pizza values('','Jambon','Pizza melon et jambon cru Italia','13','15');
insert into ingredient_pizza values('','PateFine','Pizza melon et jambon cru Italia','16','15');

/* Pizza Bresaola et Roquette (légumes, Jambon,Boeuf, PateFine) */
insert into ingredient_pizza values('','Légumes','Pizza Bresaola et Roquette','11','16');
insert into ingredient_pizza values('','Jambon','Pizza Bresaola et Roquette','13','16');
insert into ingredient_pizza values('','Boeuf','Pizza Bresaola et Roquette','10','16');
insert into ingredient_pizza values('','PateFine','Pizza Bresaola et Roquette','16','16');


/*
 * MISE A JOUR OBLIGATOIRE
 */


update PIZZA set NOM = '4frommages' where PIZZA_ID = 10;
update PIZZA set NOM = 'Oriental' where PIZZA_ID = 11;
update PIZZA set NOM = 'Végétarienne' where PIZZA_ID = 12;
update PIZZA set NOM = 'Margherita' where PIZZA_ID = 13;

update PIZZA set PRIX = '12' where PIZZA_ID = 10;
update PIZZA set PRIX = '14' where PIZZA_ID = 11;
update PIZZA set PRIX = '12' where PIZZA_ID = 12;
update PIZZA set PRIX = '11' where PIZZA_ID = 13;

update ingredient_pizza set NOM_PIZZA = '4frommages' where PIZZA_REF = 10;
update ingredient_pizza set NOM_PIZZA = 'Oriental' where PIZZA_REF = 11;
update ingredient_pizza set NOM_PIZZA = 'Végétarienne' where PIZZA_REF = 12;
update ingredient_pizza set NOM_PIZZA = 'Margherita' where PIZZA_REF = 13;

delete from PIZZA where PIZZA_ID in (16, 15,14);
delete from ingredient_pizza where PIZZA_REF in (16, 15,14);

/*  Table de conversion des types MySQL vers les classes Java
http://dev.mysql.com/doc/refman/5.0/en/connector-j-reference-type-conversions.html */

      




