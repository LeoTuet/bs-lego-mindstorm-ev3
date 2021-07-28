IP=10.96.210.45
JAR=LegoRoboter-1.0-SNAPSHOT.jar
printf "Uploading...\n"
scp -oKexAlgorithms=+diffie-hellman-group1-sha1 -c 3des-cbc target/$JAR root@$IP:/home/lejos/programs
printf "Running...\n"
ssh -oKexAlgorithms=+diffie-hellman-group1-sha1 -c 3des-cbc root@$IP "jrun -jar /home/lejos/programs/$JAR"
