# SqlliteApp
First Responder project


Introduction
 
A major hurricane has just passed through the region and there is widespread flooding. Residents are stranded on rooftops and other structures. There are so many people that need to be rescued it could take days. Some of them may have lost access to medications, insulin needles, and wheelchairs. Perhaps an autistic child becomes separated from his caretaker. These people need assistance too.  First responders not only risk their lives, but often, as in this case, they have the foresight to think of what should or could be saved. They think beyond the fire to the belongings inside that are not replaceable. 
Purpose
The purpose of this document is for the First responders, A medical personnel (Nurses, Doctors and EMTs) who are the first to arrive at site of emergency. They help patients in critical conditions until more help arrives during emergency. When any emergency occurs whether its earth quake, fire or any other medical situations like chocking First responder can rely on the ability to access shared information to understand crises and make lifesaving decisions. When first responders are comfortable with the technology they are using, they can communicate and make decisions more quickly with First responder mobile application. 
Scope
To create a mobile app that will deliver the best first aid information available to the client. Gathering, organizing, and displaying the most accurate and situationally appropriate material in an intuitive way will help the user respond quickly - saving time and ultimately saving lives.  
Target user: First responder 
Development Platform: Android Studio
Search options:
Text
Voice
Display methods:
Text 
Image
Other features:
Connect to trained emergency personnel 
Plug in for a specific disaster: fire, flood, and earthquake. 
The content delivered by this app is not intended to replace the advice of a licensed physician.


Fully dressed Use case

Use Case: First Responder (Fully Dressed Format)
Primary Actor: First Responder, Application
Scope: First Responder App
Level: User-Goal
Stakeholders:
 First Responder- First responder wants to find information about medical emergency in
order to treat a patient.
Preconditions:
First responder has install application on their android device.
The menu of emergency options is presented to the first responder
Postconditions:
The first responder finds the appropriate medical information quickly and easily, and can treat the patient.
Main Success Scenario (basic flow)
1. The first responder arrives on the scene of an emergency.
2. The first responder needs medical information to help treat a patient
3. The first responder selects the type of emergency from a menu of options.
4. The first responder views the medical options and selects a more specialized option that corresponds with the patient’s symptoms
5. The first responder will search information with text search or with speech search.
6. The first responder reads the information and applies the knowledge and techniques to treat the patient.
Alternative Flow
Serious emergency
1.1: Patient is treated but needs further care.
If Patient need further treatment then first responder should call emergency number 911
Out of control situation
2.1: If First responder needs additional help he/she can call another person for help
2.2: Call 911 emergency 
      3.    If situation is not clear patient unable to figure out what exactly he asks for the help.
             3.1: Patient unclear about the condition unable to act on it
             3.2: Patient asks help from the first responder.
             3.3: Detailed out the condition so that to take an action 
             3.4: Action taken on the symptoms he has and the observations taken by first responder
             3.5: At last selects (search) the type of emergency either by text or speech functionality
             3.6: View the medical options 
             3.7: Treat the patient accordingly
             3.8: Seek for the effective help.
      4. If the situation is where patient has severe injury
4.1: Patient can only take help from speech functionality as he wants fast action to be    taken
       	 4.2: First responder takes the help and proceed with medical treatment.
5. If the situation is very common but patient gets panic and unable to do the appropriate   action    on the condition he faced, he can seek help directly to emergency services though first responder 
            5.1: Situation handled by the emergency services directly can act fast.
            5.2: As per the emergency services get the help and treat patient.

Design Overview
System architecture
This project is done in android studio which contains one or more modules with source code files and resource files. There are types of modules included 
Android app module 
Library module
By default, you can view project I the Android project view, all the build files are visible at the top level under Gradle Scripts and each app module contains the following folders:
Manifests: Contains the AndroidManifest.xml file.
 Java: Contains the Java source code files, including JUnit test code.
Res: Contains all non-code resources, such as XML layouts, UI strings, and bitmap images.
User Interface Rules Used in The Project
The toolbar lets you carry out a wide range of actions, including running your app and launching Android tools.
The navigation bar helps you navigate through your project and open files for editing. It provides a more compact view of the structure visible in the Project window.
The editor window is where you create and modify code. Depending on the current file type, the editor can change. For example, when viewing a layout file, the editor displays the Layout Editor.
The tool window bar runs around the outside of the IDE window and contains the buttons that allow you to expand or collapse individual tool windows.
The tool windows give you access to specific tasks like project management, search, version control, and more. You can expand them and collapse them.
The status bar displays the status of your project and the IDE itself, as well as any warnings or messages.
 
GRADLE BUILD SYSTEM:
This is the foundation of the system which provides the android specific capabilities which is provided by android plugin for gradle.
Configuring the build process.
By employing the flexibility of Gradle, you can achieve all of this without modifying your app's core source files


Figure 1: System Architecture
Technology Used
The target development environment is done in Android studio and backend as SQLite.
Android studio app is IDE for the Android app development.
It has a flexible gradle build system. 
Fast and feature rich emulator
You can make instant changes to running app without building new APK
Extensive testing tools
3.5  Workflow Basics:
Setting up the workspace 
Then writing, building and running the app is the next in the work flow.
Writing app consists of the writing code and adding assets
Building the app includes connecting to the device and emulator.
Iterate the process is the step where a user/developer can debug and test the app.

3.6  SQLite Workflow:
This project uses SQLite which is meant by providing the relational database management .The Lite in SQLite describes it is light in terms of setup, database administration, and other required resources. 
It has some important features:
It is self-contained 
Server less
It has zero configuration
It is transactional
SQLite database is integrated with the application that accesses database. The application directly interact with the SQLite database, it reads and writes from the database files which are stored.

![screen shot 2018-06-21 at 11 40 28 am](https://user-images.githubusercontent.com/28520902/41731449-7366be0c-754c-11e8-9257-abd391d57c0f.png)

![screen shot 2018-06-21 at 12 13 22 pm](https://user-images.githubusercontent.com/28520902/41731522-9dae2d9e-754c-11e8-8e11-a6b4108ccdbb.png)

![screen shot 2018-06-21 at 12 13 28 pm](https://user-images.githubusercontent.com/28520902/41731526-a0700b4c-754c-11e8-8000-7a2c2ad9d335.png)

![screen shot 2018-06-21 at 12 13 34 pm](https://user-images.githubusercontent.com/28520902/41731529-a2cc0f62-754c-11e8-8e15-39870449b41a.png)
![screen shot 2018-06-21 at 12 13 42 pm](https://user-images.githubusercontent.com/28520902/41731533-a442f496-754c-11e8-89db-f647b7bff7ba.png)
![screen shot 2018-06-21 at 12 13 47 pm](https://user-images.githubusercontent.com/28520902/41731535-a64c87a2-754c-11e8-9251-440b72b2b049.png)
![screen shot 2018-06-21 at 12 13 53 pm](https://user-images.githubusercontent.com/28520902/41731538-a84c44fc-754c-11e8-9cfe-af3db41a3986.png)


Future Scope

Future scope for First responder application will be add video functionality will be added. When First responder will search medical emergency, with text description there will be a short video clip appear on screen. The main advantage of video clip will be first responder have clear idea about situation and which will be easy for him/her to handle situation.
The next functionality we would like to enhance for future scope will be call 911. There will be a button to call emergency 911. This button will be appearing on each page when first responder will be search. When situation will be out of control first responder will have direct access to call 911 for emergency help and first responder will be redirected to call page.



Conclusion

First responders routinely depend on mobile technology during emergency situations. Using the First Responder app as a disaster response tool allows these personnel quick and easy access to common first aid procedures that they can use to treat victims. A wide array of disaster response instructions and pictures are available, and the easy to use menu allows responders to select, retrieve, and view content pertinent to their current crisis. Whether it is fire, flood, earthquake, or medical information, First Responder displays are organized and intuitive, and delivered via state of the art Android technology. Additionally, Android provides the portability that responders need to ensure the app is widely available to all their team members. First Responder app is an indispensable tool that gives the first responder the ability to tap into knowledge whether at their base station or in the field. By using First Responder, emergency workers save time and ultimately lives.

References
 
The Importance of First Responders. [online] Available at: https://www.huffingtonpost.com/entry/the-importance-of-first responders_us_588e6654e4b0de286b2574ca [Accessed 18 Dec. 2017].
The importance of technological innovation for first responders. [online] Available at: https://wtop.com/vmware/2017/11/importance-technological-innovation-first-responders/ [Accessed 18 Dec. 2017].
Studio, M. (2017). Meet Android Studio | Android Studio. [online] Developer.android.com. Available at: https://developer.android.com/studio/intro/index.html [Accessed 18 Dec. 2017].
Oodesign.com. (2017). Observer Pattern | Object Oriented Design. [online] Available at: http://www.oodesign.com/observer-pattern.html [Accessed 18 Dec. 2017].
Developer.android.com. (2017). android. database.sqlite | Android Developers. [online] Available at: https://developer.android.com/reference/android/database/sqlite/package-summary.html [Accessed 18 Dec. 2017].
Agilemodeling.com. (2017). UML 2 Class Diagrams: An Agile Introduction. [online] Available at: http://www.agilemodeling.com/artifacts/classDiagram.htm [Accessed 18 Dec. 2017].
Sis.nlm.nih.gov. (2017). Disaster Apps for Your Digital Go Bag. [online] Available at: https://sis.nlm.nih.gov/dimrc/disasterapps.html [Accessed 18 Dec. 2017].
Cold, F., Disease, H. and Management, P. (2017). WebMD Common Health Topics A-Z - Find reliable health and medical information on common topics from A to Z. [online] WebMD. Available at: https://www.webmd.com/a-to-z-guides/common-topics [Accessed 18 Dec. 2017].
 
