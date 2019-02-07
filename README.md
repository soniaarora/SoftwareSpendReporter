# Software Spend Generator

## Dependencies

  - **Windows Platform** 
  - **Git** - Distributed version-control system
  - **Java SE Development Kit 8**
  - **Gradle 5.1.1** - Build Automation System

### Steps to install dependecnies-

* ### Git
1. Download [Git](https://git-scm.com/download/win)
2. Install the Git exe from download folder
3. Configure your system environment 
    1. In File Explorer right-click on the `This PC` (or `Computer`) icon, then click `Properties` -> `Advanced System Settings` -> `Environmental Variables`
    2. Under `System Variables` select `Path`, then click `Edit`
    3. Add a new entry for `C:\Program Files\Git\bin\` 
    4. Click OK to save.
4. To verify, restart cmd and type ```git --version``` in cmd

* ### Java SE Development Kit 8

1.	Open [link](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
2.	Under `Java SE Development Kit 8u201`, choose the executable appropriate for Windows platform.
3.	Download and install, leaving all of the default settings during installation.
4.	The JDK software is installed on your computer, for example, at `C:\Program Files\Java\jdk1.8.0_201`. You can move the JDK software to another location if desired.
5.	Set **JAVA_HOME**:
    1. In File Explorer right-click on the `This PC` (or `Computer`) icon, then click `Properties` -> `Advanced System Settings` -> `Environmental Variables`
    2. Under `System Variables` click `new`
    3. JAVA_HOME to point to where the JDK software is located, for example, “C:\Program Files\Java\jdk1.8.0_201”
![alt text](https://javatutorial.net/wp-content/uploads/2016/08/add-java_home-as-system-variable.jpg)
6. To verify, restart cmd and type ```java -version``` in cmd.

* ### Gradle

1. Download Gradle 5.1.1 using link [Binaries](https://gradle.org/next-steps/?version=5.1.1&format=bin)
2. Unpack the distribution
    1. Create a new directory `C:\Gradle` with File Explorer.
    2. Open a second File Explorer window and go to the directory where the Gradle distribution was downloaded. Double-click the ZIP archive to expose the content. Drag the content folder `gradle-5.1.1` to your newly created `C:\Gradle` folder.
    3. Alternatively you can unpack the Gradle distribution ZIP into `C:\Gradle` using an archiver tool of your choice.
3. Configure your system environment
    1. In File Explorer right-click on the `This PC` (or `Computer`) icon, then click `Properties` -> `Advanced System Settings` -> `Environmental Variables`
    2. Under `System Variables` select `Path`, then click `Edit`
    3. Add a new entry for `C:\Gradle\gradle-5.1.1\bin` 
    4. Click OK to save.
4. To verify, restart cmd and type `gradle –v` in cmd

## Step to Run Solution (Windows)
1. Open CMD
2. Download code from git repository using command 
    ```
    git clone https://github.com/soniaarora/SoftwareSpendReporter.git
    ```
3. Navigate to solution folder
    ```
    cd SoftwareSpendReporter
    ```
4. Build solution
    ```
    gradle clean build
    ```
5. Execute solution 
    ```
    java -jar ./build/libs/SoftwareSpendReporter-1.0.jar ./Sample/InputFile.csv
    ```
	![Output](Screenshots/Output.JPG)