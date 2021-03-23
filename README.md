# Pets Application
## Table of Contents
- [Description](#description)
- [Structure](#structure)
- [Usage](#usage)
- [Used technologies](#used technologies)

## Description
This is simple REST app, running at SAP cloud foundry, which provides user managing instances, such as: User, Pet (Cat, Dog). You can create/update/delete/get them.

## Structure
Users authentication is provided via Basic authentication.
AOP provides logging at service layer.
Database provides with the PostgreSQL service on SAP BTP.

## Usage
1. Create PostgreSQL service on SAP BTP using CLI or using Cockpit.
   You can create a service instance using the command 
   ```
   cf create-service SERVICE-NAME SERVICE-PLAN INSTANCE-NAME
   ```
   For example, 
   ```
   cf create-service postgresql v9.6-xsmall my_postgres_service
   ```
2. Write config file ([application.properties](src/main/resources/application.properties))
3. Write manifest ([manifest.yml](manifest.yml))
   
   3.1 Bind app to service
   - Add to manifest
   ```
     services:
     - SERVICE_INSTANCE
   ```
   - Or using CLI:
   ```
   cf bind-service APP-NAME SERVICE_INSTANCE
   ```
   
4. Push app to the cloud
   ```
   cf push
   ```
   
## Used technologies
- Spring Boot
- JPA
- Spring Security