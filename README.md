<a name="OOP course first assignment"></a>

<a name="readme-top"></a>

<!-- ABOUT THE PROJECT -->
## About The Project

This project contains an Observer design pattern over String Builder wrap with undo function. Also It contains tests for UndoableStringBuilder and memory tests for Observer.

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

UndoableStringBuilder is a wrapper class for the original StringBuilder class in java with undo function.

It can undo next functions:
* append
* delete
* insert
* replace
* reverse

UndoableStringBuilder saves data in original StringBuilder and all commands that been made in Stack. Every time a change is made on string it saves its undoCommand in stack. When the user whants to undo it just takes last undoCommand from stak and applies it.
To perform an undo command it uses original StringBuilder commands. For example to undo a reverse we just need to reverse it again. If we wand to undo an append we just need to delete whats been appended.

You can find the UndoableStringBuilder classes in [this](https://github.com/NickBres/OOP0) repository.

<img width="1153" alt="image" src="https://user-images.githubusercontent.com/70432147/208913411-b9779aa3-07be-46d7-932e-c5332514eafc.png">


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Observer

This project uses simple Observer design pattern.
#### ConcreteMember
ConcreteMember class implemets the Member interface.
Every member have its name (String) and UndoableStringBuilder shallow copy.
It uses HandleEvent function to inform the member about changes that been made in UndoableStringBuilder.
#### GroupAdmin
ConcreteMember class implemets the Sender interface. 
It saves list of Members and original UndoableStringBuilder object.
GroupAdmin can manage members and make changes in UndoableStringBuilder.
If any changes are made to the UndoableStringBuilder, it will notify the members and sends them a new shallow copy.

<img width="676" alt="image" src="https://user-images.githubusercontent.com/70432147/208913193-66d03463-85c6-4c32-81f9-60d6664c91c9.png">


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Tests
There is a simple main function that can show how program works. 
All other test are made using JUnit tool.
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


To run the project, open it in the IntelliJ IDEA editor, enter to pom.xml file and rebuild it. After project was built you can run its tests using Maven tool.

<img width="417" alt="image" src="https://user-images.githubusercontent.com/70432147/208905750-850f563c-2127-43f2-8d7f-b4f01c1373c1.png">



<p align="right">(<a href="#readme-top">back to top</a>)</p>


