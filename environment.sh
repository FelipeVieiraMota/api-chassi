clear 

mvn clean
echo "Deleted target/ folder"

mvn install -e
echo "Generating jar file"


scp -i "/home/felipe/workspace/Java/Cloud/AWS-Keys/BackOfficeKey.pem" /home/felipe/workspace/Java/Cloud/api-chassi/deploy.sh ubuntu@ec2-54-174-89-104.compute-1.amazonaws.com:/home/ubuntu
echo "Copied latest 'deploy.sh' file from local machine to ec2 instance"

scp -i "/home/felipe/workspace/Java/Cloud/AWS-Keys/BackOfficeKey.pem" /home/felipe/workspace/Java/Cloud/api-chassi/target/apichassi-0.0.1-SNAPSHOT.jar ubuntu@ec2-54-174-89-104.compute-1.amazonaws.com:/home/ubuntu
echo "Copied jar file from local machine to ec2 instance"

ssh -i "/home/felipe/workspace/Java/Cloud/AWS-Keys/BackOfficeKey.pem" ubuntu@ec2-54-174-89-104.compute-1.amazonaws.com ./deploy.sh
echo "Connecting to ec2 instance and starting server using java -jar command"