FROM doc1143/mvn3.6.3-jdk1.8-apifrwrk
Copy src home/apiframework/src
Copy index.html  home/apiframework/indexdocker.html
Copy pom.xml  home/apiframework/pom.xml
Copy testng.xml home/apiframework/testng.xml
Copy outputfolder  home/apiframework/outputfolder
WORKDIR home/apiframework
ENTRYPOINT mvn clean test