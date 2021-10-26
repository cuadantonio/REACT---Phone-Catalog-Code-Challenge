# React---Phone-Catalog-Code-Challenge
## Objective
The main objective of this challenge was to create a web app that showed us a list of phones, data that obtains from a backend made with Spring Boot, on a frontend made with React.
Even though the main functionality was only to show all of the phones you can also see every phone by itself with its details and delete (To add a phone and replace were 2 funcionalities that I tried to implement but due to some issues with CORS that wasn't able on the frontend but you can do that on the backend).
## Execution
- [Prerequisites](https://github.com/cuadantonio/REACT---Phone-Catalog-Code-Challenge/blob/main/README.md#prerequisites)
- [Run main code](https://github.com/cuadantonio/REACT---Phone-Catalog-Code-Challenge/blob/main/README.md#run-main-code)
- [Navigate through the app](https://github.com/cuadantonio/REACT---Phone-Catalog-Code-Challenge/blob/main/README.md#navigate-through-the-app)
### Prerequisites
There are three prequisites that you need in order to execute the code properly:
1. First you need to have **Java** installed on your computer, you can download it [here](https://www.java.com/es/download/). I recommend you to install JDK 11 but as long as you install a version newer that JDK 1.8 its okay. Once you install **Java** you need to install **[Maven]**(https://maven.apache.org/download.cgi) too. Its installation might be difficult so I leave you here some instructions on how to install it for [Windows](https://mkyong.com/maven/how-to-install-maven-in-windows/),[Linux](https://docs.wso2.com/display/IS323/Installing+Apache+Maven+on+Linux) and [Mac](https://mkyong.com/maven/install-maven-on-mac-osx/)
2. The second prerequisite is to have **Node.js** installed on your machine. You can find instructions on how to download and install it [here](https://nodejs.org/es/).
3. The las prerequsite is to have **MySQL** installed on your computer. You can download from [here](https://dev.mysql.com/downloads/). If you are using Windows I recommend you using the **MySQL Installer for Windows**
### Run main code
First you need to execute your backend, if you have Intellij IDEA or Spring Boot Suite installed in your computer I recommend you to open the project on the IDE you have install and press the run button.
If you don't have any of this installed on your computer what you have to do is open the backend folder inside the main folder you just downloaded on a terminal and write the next command ***mvn spring-boot:run***
Once the backend is already running we gotta execute the frontend, so we have to open the frontend folder from the main folder you just downloaded on a terminal and write the next command ***npm start***
### Navigate through the app
#### Backend ####
If you want to do operations with the backend here are the links for the basic operations with it
**GET ALL** If you want to get all of the phone from the backend you need to use this link **https://localhost:8080/phones/**
**GET ONE** If you want to get just one phone from the backend you need to use this link **https://localhost:8080/phones/{id}** and know the id of the phone you want to get 
**POST** If you want to create a phone on the backend you need to use this link **https://localhost:8080/phones/** and use a software like [Postman](https://www.postman.com/downloads/) where you can specify that you want to **POST** a phone 
**PUT** If you want to replace a phone on the backend you need to use this link **https://localhost:8080/phones/{id}** the id of the phone you want to replace and use a software like [Postman](https://www.postman.com/downloads/) where you can specify that you want to **PUT** a phone
**DELETE** If you want to delete a phone on the backend you need to use this link **https://localhost:8080/phones/{id}** the id of the phone you want to delete and use a software like [Postman](https://www.postman.com/downloads/) where you can specify that you want to **DELETE** a phone 
#### Frontend ####
If you want to navigate through the backend, first you need to open **http://localhost:8081/** in your browser. In that page will appear all of the phones that are on the database.
If you click in one of those phones you will be redirected to its main page where you can see all of its info, you can also access to this page by using this link **http://localhost:8081/phones/{id}** but you need to know the id of the phone you wante to search for. Also on this page you can delete that phone by pressing the Delete button that appears, if you press that button you will be redirected to the main page where all the phones appear.
