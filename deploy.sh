fuser -k 8080/tcp 
echo "Killed process running on port 8080"

java -jar apichassi-0.0.1-SNAPSHOT.jar
echo "Started server using java -jar command"
