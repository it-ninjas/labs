---
title: "Overview Lab"
linkTitle: "Overview Lab"
weight: 12
description: >
  Overview Lab: Theory of everything
sectionnumber: 5
---


## {{% param sectionnumber %}}.0: Meta


### {{% param sectionnumber %}}.0.1: Goals

* I know how applications work in a modern world
* I know what databases, backends, frontends are for
* I know what a monolithic application is
* I can divide the modules of an application


### {{% param sectionnumber %}}.0.2: Changelog

| Author | Version | Date | Change |
| --- | --- | --- | --- |  
| Raffael Hertle | 0.1 | 18.1.2022 | Initial version |


### {{% param sectionnumber %}}.0.3: Requirements

* None


## {{% param sectionnumber %}}.1: Applications in the modern world


### {{% param sectionnumber %}}.1.1: State of the world

In our state of the world now we know small applications existing and solving small problems (or even creating problems). For example we could simply create a Java application simulating a calculator on the command line. Some few lines of code would be enough to create a solution, compile the program and execute it on your local machine. Neat! But is this what modern software engineering is about? Not really.

In this chapter we dive a bit into the modern world of applications and take a look at how we solve problems at a bigger scale!

Solving problems: That's what software engineering is all about. We know a certain problem and we would like to tackle it by creating an application or automated solution. But how do we get there?


## {{% param sectionnumber %}}.2: Solving problems

Let's take a look at how we can tackle problems in the first place. There are two very well known approaches to describe and inspect problems we use every day in our jobs: Bottom-Up and Top-Down approaches.

To talk about how to solve problems, we need to create one in the first place.

We would like to sell our sneakers in an online shop. Our customers should have a neat web based UI to check out our shoes and order them online. Our application checks whether the shoes are still in stock and lets the customer pay and complete the order. Sounds simple, doesn't it? But here already we are talking about several smaller problems by describing a bigger problem. And this is what it is all about.


### {{% param sectionnumber %}}.2.1: Top-Down

In a Top-Down approach we describe the problem from the biggest scope possible and then work ourselves from top down to smaller problems and describing them. As you can easily see, we already followed a top-down approach by simply describing our problem in {{% param sectionnumber %}}.2. The Top-Down approach is the most useful if we already know the bigger scope of our problem and can start by digging down into smaller problems. It gets harder the complexer the problem will get. As soon as the problem's complexity is too big, a Bottom-Up approach is most likely more useful!


### {{% param sectionnumber %}}.2.2: Bottom-Up

The Bottom-Up approach inverts the idea. Sometimes it's easier to specify smaller parts of a solution first, then create the bigger solution from the puzzle of the small solutions.


### {{% param sectionnumber %}}.2.3: Assignment 1

Create a Bottom-Up specification for the problem described in {{% param sectionnumber %}}.2. Use your own words and document the specification as a file in your git repository.


## {{% param sectionnumber %}}.3: Building blocks of modern applications

Modern applications mostly do not just exist as a single system. They utilize a wide selection of other applications to perform the tasks needed. When systems are dependent on other systems we call them a `Dependency` of our system. These dependencies might be other applications of ours or other services. If we take a look at modern web applications the three default building blocks are mostly quite similar.

{{% alert title="Web Application"%}}
A web-application is an application program that is usually stored on a remote server, and users can access it through the use of Software known as web-browser.

> [Java Point](https://www.javatpoint.com/web-application)
{{% /alert %}}

{{% alert title="Building Block"%}}
General or abstract term for all kinds of artifacts from which software is constructed. Part of the
statical structure (Building Block View) of software architecture.

Building blocks can be hierarchically structured - they may contain other (smaller) building
blocks.

Some examples of alternative (concrete) names for building blocks: Component, module,
package, namespace, class, file, program, subsystem, function, configuration, data-definition.

> [iSAQB Definition of Building Blocks](https://www.isaqb.org/wp-content/uploads/2020/10/iSAQB_Glossary_of_Software_Architecture_EN.pdf)
{{% /alert %}}

These default building blocks of modern web application usually consists of:

* Frontend: Visualization of our application (Website)
* Backend: Backing service which handles application logic
* Database: Storing information for our application

{{% alert title="Frontend" %}}

The frontend of a software program or website is everything with which the user interacts. From a user standpoint, the frontend is synonymous with the user interface. From a developer standpoint, it is the interface design and the programming that makes the interface function. Conversely, the backend includes functions and data processing that takes place behind the scenes.

One of the primary goals of frontend development is to create a smooth or "frictionless" user experience. In other words, the front end of an application or website should be intuitive and easy to use. While this sounds like a simple goal, it can be surprisingly complex since not all users or devices are the same. For example, an app developed for a mobile device requires a significantly different frontend than a desktop application. Websites must work well on multiple devices and screen sizes, which is why modern web development typically involves responsive design.

> [TechTerms.com](https://techterms.com/definition/frontend)

{{% /alert %}}

{{% alert title="Backend" %}}

In the computer world, the "backend" refers to any part of a website or software program that users do not see. It contrasts with the frontend, which refers to a program's or website's user interface. In programming terminology, the backend is the "data access layer," while the frontend is the "presentation layer."

Most modern websites are dynamic, meaning webpage content is generated on-the-fly. A dynamic page contains one or more scripts that run on the web server each time the page is accessed. These scripts generate the content of the page, which is sent to the user's web browser. Everything that happens before the page is displayed in a web browser is part of the backend.

> [TechTerms.com](https://techterms.com/definition/backend)

{{% /alert %}}

{{% alert title="Database" %}}

A database is a data structure that stores organized information. Most databases contain multiple tables, which may each include several different fields. For example, a company database may include tables for products, employees, and financial records. Each of these tables would have different fields that are relevant to the information stored in the table.

> [TechTerms.com](https://techterms.com/definition/database)

{{% /alert %}}


## {{% param sectionnumber %}}.4: Our shop in different styles

We are now trying to describe our software solution for our online shop in a few different approaches. When designing our software solution we should always consider that there is most likely not only one correct solution available. In most cases there are several solutions possible fitting our needs and they all will have their own trade-offs.

There are a few architectural patterns which we can take a look at:


### {{% param sectionnumber %}}.4.1: Monolithic Architecture

{{% alert title="Monolithic Architecture" %}}

The monolithic architecture is considered to be a traditional way of building applications. A monolithic application is built as a single and indivisible unit. Usually, such a solution comprises a client-side user interface, a server side-application, and a database. It is unified and all the functions are managed and served in one place.

Normally, monolithic applications have one large code base and lack modularity. If developers want to update or change something, they access the same code base. So, they make changes in the whole stack at once.

{{% /alert %}}

Usually in monolithic applications modularity comes from separating responsibilities. We will have modules handling the system interaction from outside (API / Boundary classes), business logic (Services) and data access (Repositories).


#### {{% param sectionnumber %}}.4.1.1: API

{{% alert title="Monolithic Architecture" %}}

Stands for "Application Programming Interface." An API is a set of commands, functions, protocols, and objects that programmers can use to create software or interact with an external system.

> [TechTerms.com](https://techterms.com/definition/api)

{{% /alert %}}

So we think of APIs as an instruction set to use our application. It defines how the user can interact with our software on a technical level.


#### {{% param sectionnumber %}}.4.1.2: Services

All class handling business logic in our applications are contained in this section. By business logic we mean all logic which is affected by the applications business not the technical world. It defines how business objects interact with each other.

Take a look at our store example above. All the logic handling the prices, names, orders, addresses, etc. are part of the application's business logic. It has no technical relevancy but only from the business perspective.

Business logic parts are the core of our application to all users. Usually users don't care about how things are getting done, they mostly care that things are done. That is business logic!


#### {{% param sectionnumber %}}.4.1.3: Data Repositories

Data repositories are the access point to our databases and data storage. Think of them as the front desk in a library. They are classes which we use to access data stored in our library (database for example) and they give us an instruction set which tells us how to access the data - an API!


### {{% param sectionnumber %}}.4.2: Microservices

In the monolithic architecture world we think about all components living in the same application. The application would be divided by multiple domains (for example the order domain) which is then divided into modules for data access, business logic and the API. If we take a step further and separate a bit more we could think of all these domains as single applications. Then we would have multiple applications instead of multiple domains in one application. When one part of the software changes, not the entire landscape has to be rebuilt and redeployed onto our servers. This will lead to flexibility and adaptability in our software, but brings a lot more technical complexity to the scene.


### {{% param sectionnumber %}}.4.3: Assignment 2

It is now time for you as the architect in the web-shop project to decide how our application is built. Take your time and create two approaches for designing the application: a monolithic and microservice approach. Try to create an illustration on how your software is built, try to describe your software in a few sentences and show the different layers of your application.
