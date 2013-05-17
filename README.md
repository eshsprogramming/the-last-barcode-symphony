The Last Barcode Symphony
=========================

Barcodes be barcoding.


Getting Started
---------------

### Prerequisites

#### IDE
Install either [IntelliJ](http://www.jetbrains.com/idea/) or [Eclipse](http://www.eclipse.org/), along with the
[Android SDK](http://developer.android.com/sdk/index.html) (select "Use an existing IDE").

#### Maven

##### Mac OS X
Maven has been included in Mac OS X since 10.7.1. It should be located at `/usr/share/maven`.

Type `mvn -version` into your terminal to verify your installation.

##### Ubuntu/Debian

    sudo apt-get install maven

##### Arch Linux
Install Maven.

    sudo pacman -S maven

Add environment variables to `~/.bashrc`

    export M2_HOME=/opt/maven/
    export M2=$M2_HOME/bin
    export PATH=$M2:$PATH

Run `mvn -version` to verify installation.

##### Other Linux (no package manager)

Download and untar into `/usr/local/apache-maven/apache-maven-3.0.4`

    wget http://mirror.olnevhost.net/pub/apache/maven/binaries/apache-maven-3.0.4-bin.tar.gz
    tar xvf apache-maven-3.0.4-bin.tar.gz /usr/local/apache-maven/apache-maven-3.0.4

Add environment variables to `~/.bashrc`

    export M2_HOME=/usr/local/apache-maven/apache-maven-3.0.4
    export M2=$M2_HOME/bin
    export PATH=$M2:$PATH

Verify installation with `mvn -version`.

##### Windows
Follow [this](http://www.mkyong.com/maven/how-to-install-maven-in-windows/) tutorial.

### Setting up your IDE

#### IntelliJ

##### Configuring Maven

Go to **File → Settings** and in the tree dialog choose Maven. Specify the directory where Maven lives.

##### Importing the project

Go to **File → Import Project** and then navigate to the `the_last_barcode_symphony` folder you cloned from GitHub.

Once the project is loaded, you need to enable the Maven profiles. On the right of your screen, open the Maven project
view and check the three profiles: desktop, android, and html.

##### Configurations

###### Desktop

Go to **Run → Edit Configuration** and create a new configuration by clicking the plus button in the top left and
selecting `Application`. Set the main class to the `com.eshsrobotics.the_last_barcode_symphony.java.TheLastBarcodeSymphonyDesktop` and select
the desktop module.

Launch the configuration to run the app on your desktop.

###### Android

Create a new Android application configuration. Select the Android module and then check `Run Maven Goal` and click the
`...` button to the right. In the dialog, select the Android project, then `Lifecycle`, and from the list of goals,
`package`. You can also set `Target Device` to your preferred method of deploying the Android application.

#### Eclipse

Before you can import the project, you need to install the following Eclipse plugins:

* [m2e](http://eclipse.org/m2e/) - This should already be included in a clean Eclipse Java installation. It provides
  basic Maven support within Eclipse.
* [m2e-android](http://rgladwell.github.com/m2e-android/) - Provides Maven integration for Android projects in Eclipse.
  Until [this](https://github.com/rgladwell/m2e-android/pull/124) pull request is merged, you're going to have to clone
  their repository, compile the plugin, and manually install it in Eclipse.
* [Google Web Toolkit](https://developers.google.com/web-toolkit/) - Allows you to develop GWT projects.

Once all of these are installed, you can import the project by going to **File → Import... → Maven → Existing Maven
Projects**. Thiss will import the parent `pom` as a projet along with the `core`, `desktop`, `android`, and `html`
project.

The `html` project might not be recognized by Eclipse as a GWT project. To fix this, right click the project, go to
**Properties → Google → Web Toolkit**. Check `Use Google Web toolkit`. Next, go to **Properties → Google → Web
Application**, check `This project has a WAR directory`, specify `src/main/webapp`, and finally check `Launch and deploy
from this directory`.

### Maven Goals

#### Desktop

To create a runnable jar to share with others, run:

    mvn -Pdesktop package

This will create a file called `the_last_barcode_symphony-desktop-1.0-SNAPSHOT-jar-with-dependencies.jar` in the `desktop/target`
folder.

You should not be creating a new runnable jar for testing each new feature. Instead, just run the game from your IDE.

#### Android

Create an unsigned APK for Android:

    mvn -Pandroid package

This will create a file called `the_last_barcode_symphony-android-1.0-SNAPSHOT.apk` in the `android/target` folder.

To install the game on a connected device or emulator, run:

    mvn -Pandroid install

#### HTML/GWT

To compile the HTML5 project to Javascript, run:

    mvn -Phtml package

The result is located in the `html/target` folder. You can either deploy the `.war` file that was generated to a Jetty
or Tomcat server, or copy the contents of the `html/target/the_last_barcode_symphony-1.0-SNAPSHOT/` folder to the server you want to
deploy on. Both the `.war` file and the folder contain all of the compiled Javscript, HTML, and assets.
