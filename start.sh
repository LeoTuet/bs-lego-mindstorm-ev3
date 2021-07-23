IP=$(cat ip.txt)
JAR=LegoRoboter-1.0-SNAPSHOT.jar

printf "Uploading to %s...\n" "$IP"
scp -oKexAlgorithms=+diffie-hellman-group1-sha1 -c 3des-cbc target/$JAR root@$IP:/home/lejos/programs

if [ $? -gt 0 ]
then
  echo -e "\e[31mUpload failed\e[0m"
  exit 1
fi

printf "Running %s...\n" "$JAR"
ssh -oKexAlgorithms=+diffie-hellman-group1-sha1 -c 3des-cbc root@$IP "jrun -jar /home/lejos/programs/$JAR"

if [ $? -gt 0 ]
then
  echo -e "\e[31mRun failed\e[0m"
  exit 1
fi

printf "Done!\n"
exit 0
