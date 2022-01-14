# How to set JAVA_HOME in Linux for all users

### How to find out where Java is installed?

If Java is installed using package managers or by using any other ways other than downloading the JDK from https://openjdk.java.net/install/ , it can get tricky to find out where it is installed.

1. The following command will tell you a lot of information about your java version, including the vendor. It works on Windows, Mac, and Linux.

  ``` 
  java -XshowSettings:properties -version
  ```

2. Here is another way to find it.

  ``` 
  find /usr/lib/jvm/java-1.x.x-openjdk
  ```

### Download Java from openjdk website

A more straight-forward way is to download it from openjdk install page and extracting it using the command:
``` 
$ tar xvf openjdk-13*_bin.tar.gz
```

### How to set JAVA_HOME after figuring out where the jdk is?

Look at LinuxTips.org for details about how the path can be set in .bashrc

You can also set it in /etc/profile. Try the .bashrc option before trying this.
``` 
vim /etc/profile
```

Prepend sudo if logged in as not-privileged user, ie. sudo vim

Press 'i' to get in insert mode and add this to the file:

``` 
export JAVA_HOME="path that you found"
export PATH=$JAVA_HOME/bin:$PATH
```

logout and login again, reboot, or use source /etc/profile to apply changes immediately in your current shell 

# Checking JAVA_HOME on Linux

Open a terminal and type:
``` 
> $JAVA_HOME/bin/javac -version
```

If JAVA_HOME points to a JDK, the output should look like:
``` 
> javac 1.X.0_XX
```

If JAVA_HOME doesn't point to a JDK, the OS will throw an error message:
``` 
> bash: /bin/javac: No such file or directory
```
