
*******************************************************************
			      README
*******************************************************************

1. Prerequisite

   a. Java 8 installation and JAVA_HOME environment variable set to installation dir.
   b. Maven installation and available on system PATH environment variable.
   c. Eclipse to view the project source code.

2. Steps to run the program

   a. Extract the eclipse project archive stream-data-process.zip (APP_HOME).

   b. Open a terminal on APP_HOME folder, and execute "mvn clean install" command 
      to compile the source code and generate the binaries.

   c. From terminal, navigate to $APP_HOME/bin folder and execute "export PATH=.:$PATH" or
      add it in ~/.bashrc. Now execute any of the below commands syntax.

	i) dd if=/dev/urandom count=100 bs=1MB | base64 | stream-sampler.sh <POSITIVE_NUMBER>

        ii) stream-sampler.sh <POSTIVE_NUMBER>
        
	iii) cat input.txt | stream-sampler.sh <POSITIVE_NUMBER>

	iv) stream-sampler.sh help

3. Assumptions

   a. Assuming default value for input is 5. In case of invalid/zero,default value is taken.
      However, the default value can be changed by below VM argument.

	-Dcom.example.stream.process.defaultNumChars=<DEFAULT_VALUE>
   
   b. Assuming string length for Random string source generation in language is 1000.

 


