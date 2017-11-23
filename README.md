# SpringBoot

## What is Spring Framework?
Spring is a very popular Java-based framework for building web and enterprise applications.
Spring framework provides flexibility to configure beans in multiple ways such as XML, Annotations, and JavaConfig.

Overview of Spring Framework
If you are a Java developer then there is a high chance that you might have heard about Spring framework and 
probably have used it in your projects. Spring framework was created primarily as a Dependency Injection container 
but it is much more than that.

### Spring is very popular because of several reasons:
	1. Spring’s dependency injection approach encourages writing testable code
	2. Easy to use but powerful database transaction management capabilities
	3. Spring simplifies integration with other Java frameworks like JPA/Hibernate ORM, Struts/JSF/etc. web frameworks
	4. State of the art Web MVC framework for building web applications

## A Quick Taste of Spring Boot
Welcome to Spring Boot! Spring Boot does what exactly you are looking for. It will do things automatically for you but allows you to override the defaults if you want to.

#### Features
	1. Create stand-alone Spring applications
	2. Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)
	3. Provide opinionated 'starter' POMs to simplify your Maven configuration
	4. Automatically configure Spring whenever possible
	5. Provide production-ready features such as metrics, health checks and externalized configuration
	6. Absolutely no code generation and no requirement for XML configuration
	
## Create Spring Boot Application using Eclipse
#### Step 1.
###### Integrating Spring Tool with Eclipse
Lets get Started - Installing the Spring Tooling.
The easiest way to install the Spring tooling into your existing (or freshly downloaded) Eclipse IDE is to go the Eclipse Marketplace and search for the “Spring Tool Suite” - and install from there.
###### How to do it
> Help->Eclipse Marketplace->Search for STS(Spring Tool Suite)->Install/Update

#### Step2
###### Integrating Maven with Eclipse
If you would like to use Maven (which is used in many Spring projects) and you haven’t installed the Maven Integration for Eclipse yet, you should go ahead and do that. You can grab it from the Eclipse Marketplace or directly from the main Eclipse update repository, which is pre-configured in your Eclipse IDE.  Just look for the “Install New Software” wizard.
In this project we have installed maven from Eclipse Marketplace.
###### How to do it
> Help->Eclipse Marketplace->Search for (Maven Integration for Eclipse Luna 1.5.0)->Install/Update

Step3
###### Creating Spring Boot project
There are many approaches to creating spring boot project
Import Spring Getting Started Content
Spring Starter Project etc. But we will use "Import Spring Getting Started Content" approach

Using Spring Boot and the new Getting Started Guides: 
###### How to do it
> New->Other->Spring->Import Spring Getting Started Content->Select Spring Boot->Next->Finish

you will see 2 projects getting created 1. gs-spring-boot-initial 2. gs-spring-boot-complete
now you can start coding in any of the projects but the one named complete has all the maven dependencies and initial has few missing
I suggest you to go with complete if you're going to buid unit test cases for the project. Or while creating the project uncheck initial, so that you have only gs-spring-boot-complete project in your workspace.

Step4
###### Start Coding
Now that you have configured the project you can build spring application of your choice. :smiley: 



