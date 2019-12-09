#!/usr/bin/env bash

fileName=publish
target_ip=10.92.36.12
user=ubuntu
password=Aa@123


mkdir ${fileName}
cd ${fileName}
git clone https://github.com/ic-xu/jenkins.git
dir=$(ls -l ./ |awk '/^d/ {print $NF}')
for i in $dir
do
 cd $i
 mvn clean install -Dmaven.test.skip=true
/usr/bin/expect <<-EOF
spawn bash -c "scp *.jar ${user}@${target_ip}:~/work"
     expect {
        "password:" {send "${password}\r"; exp_continue}
        }
spawn ssh ${user}@${target_ip} "java -jar /home/ubuntu/work/*.jar"
    expect {
            "yes/no" {send "yse\r"; exp_continue}
            "password:" {send "${password}\r"; exp_continue}
            }
EOF
done

cd ../..
rm -rf ${fileName}





