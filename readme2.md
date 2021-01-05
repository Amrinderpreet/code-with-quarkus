1. After git clone, move to destination folder.
2. run 'gradle build'
3. once build is complete,
   
    1. run "java -jar build/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar read" 
       (text within " ")  to read list of fruits.
    2. run "java -jar build/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar write
       -n "nameOfFruit" -d "description" " to write fruit name and
       description of your choice.
       
       eg :java -jar build/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar write -n apple -d "keeps doctor away"
       
    3. You can read the data just entered run
    
    "java -jar build/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar read -f data.json"