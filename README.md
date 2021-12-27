# CPU Race Condition Simulator

This program is the final project of the OS class I took, but I thought it might be cool if other people can add more to it.

## First Time implementing (If you want to add more to the code, etc) **_[Eclipse IDE]_**

I only studied eclipse and used eclipse in this project. Meaning that the installation and preperation part is mainly focused on Eclipse.

`Note that other IDEs should be quite similar, hopefully!`

1) Install JavaFX
>- Start Eclipse
>- Go to Help -> Eclipse Marketplace -> Search for e(fx)clipse & install
>- Restart your IDE 
>- Download javafx SDK externally once more `What I used: https://gluonhq.com/products/javafx/`
>- Extract the the files somewhere on you computer

2) Fork the source code

3) Import the project into Eclipse

4) Right Click on the Project in Eclipse and Select Buildpath -> Configure Build Path -> Go to the Libraries Tab

5) Select Classpath and Click Add External JARs

>- Here you want to go to the extracted folder and go to the lib folder `Which should look similar to this .../javafx-sdk-"Your javafx Verson"\lib`
>- In there all Executable Jar Files have to be selected and then click on open

6) Select Classpath once more and click on Add Library
>- Select JavaFX SDK press Next -> Finish
>- You can close this window

7) Right Click on the Project in Eclipse once more and Select Run As -> Run Configurations
>- Go to Arguments and under VM arguments copy this into the text box: <br/>
`--module-path 'Your path to lib folder'  --add-modules=javafx.controls,javafx.fxml`

8) Press apply and you should be ready to go.

9) Run the program by Running the Main.java File. 👊

## Running the code

You can simply run/export the project after you completed the steps above.

Additionally you can install Scene Builder from Gluon if you want to add elements, but don't wanna code pure XML.
