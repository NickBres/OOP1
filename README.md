<a name="OOP course first assignment"></a>

<a name="readme-top"></a>

<!-- ABOUT THE PROJECT -->
## About The Project

UndoableStringBuilder class extends the regular StringBuilder class(Java) implementing the UNDO function, also it may notify its subscribers about changes that were done.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Authors
* [Nikita Breslavsky](https://github.com/NickBres)
* [Chen Dahan](https://github.com/ChenDahan13)

### Built With

* Editor : IntelliJ IDEA
* Language: Java
* JDK: 19.0.1
* Maven 4.0.0
* JUnit 5.9.0
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- PROJECT CONTENT AND EXPLANATIONS -->
## Project content and explanations

### Undoable String Builder

UndoableStringBuilder extends the regular StringBuilder with undo function.

It can undo next functions:
* append
* delete
* insert
* replace
* reverse

UndoableStringBuilder saves data in regular StringBuilder and all commands that have been made in Stack. Every time a change is made on the string it saves its undoCommand in the stack. When the user wants to undo it just takes the last undoCommand from the stack and applies it. To perform an undo command it uses regular StringBuilder commands. For example to undo a reverse we just need to reverse it again. If we want to undo an append we just need to delete what’s been appended.

You can find the UndoableStringBuilder classes in [this](https://github.com/NickBres/OOP0) repository.

<img width="1153" alt="image" src="https://user-images.githubusercontent.com/70432147/208913411-b9779aa3-07be-46d7-932e-c5332514eafc.png">


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Observer

This project uses a simple Observer design pattern.
#### ConcreteMember
ConcreteMember class implements the Member interface.
Every member has its name (String) and UndoableStringBuilder shallow copy.
It uses the HandleEvent function to inform the member about changes that have been made in UndoableStringBuilder.
#### GroupAdmin
ConcreteMember class implements the Sender interface. 
It saves a list of Members and the original UndoableStringBuilder object.
GroupAdmin can manage members and make changes in UndoableStringBuilder.
If any changes are made to the UndoableStringBuilder, it will notify the members and sends them a new shallow copy.
If a member is deleted it will also free its data.

![image](https://user-images.githubusercontent.com/70432147/209438558-effe8cec-1def-48f1-9647-333f78c0c4d2.png)


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Tests
There is a simple main function that can show how the program works. 
All other tests are made using the JUnit tool.
* UndoableStringBuilderTest - Checks every function in UndoableStringBuilder
* Tests - Checks observer using JVMUtilities to show memory usage after every change has been made
<img width="706" alt="image" src="https://user-images.githubusercontent.com/70432147/208913571-622851f2-48ad-42c7-9ad1-1451b9713311.png">

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

Clone the repo
   ```sh
   git clone https://github.com/NickBres/OOP1.git
   ```


To run the project, open it in the IntelliJ IDEA editor, enter to pom.xml file and rebuild it. After the project was built you can run its tests using the Maven tool.

<img width="417" alt="image" src="https://user-images.githubusercontent.com/70432147/208905750-850f563c-2127-43f2-8d7f-b4f01c1373c1.png">



<p align="right">(<a href="#readme-top">back to top</a>)</p>


