package com.test.jenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @author ubuntu
 * @date $ $
 */
@RestController
public class Controllor {


    @GetMapping("test")
    public String test() throws IOException {
        return "这是一个测试页面";
    }


    public static void main(String[] args) throws IOException {

        String andStri = ";";
        String gitPath = "https://github.com/ic-xu/jenkins.git";
        String baseUrl = gitPath.split("\\s")[0];
        String projectName = baseUrl.substring(baseUrl.lastIndexOf("/") + 1, baseUrl.lastIndexOf("."));
        System.out.println(">>>--- pull " + projectName);
        getResult("rm -rf " + projectName);

        String password = "Aa@123";
        String user = "ubuntu";
        String baseIp = "10.92.36.12";
//        getResult("git clone " + gitPath);
//
//
//
//        StringBuffer commond = new StringBuffer();
//        System.out.println(">>>--- make jar " + projectName);
//        commond.append("cd " + projectName);
//        commond.append(andStri);
//        commond.append("mvn clean install -Dmaven.test.skip=true");
//        commond.append(andStri);
//        System.out.println(getResult(commond.toString()));
String s = "git clone https://github.com/ic-xu/jenkins.git;cd "+projectName+";mvn clean install -Dmaven.test.skip=true;" +
        "/usr/bin/expect <<-EOF\n" +
        "spawn bash -c \"scp target/*.jar "+user+"@"+baseIp+":~/work\"\n" +
        "     expect {\n" +
        "        \"password:\" {send "+password+"\r; exp_continue}\n" +
        "        }\n" +
        "spawn ssh "+user+"@"+baseIp +" java -jar /home/ubuntu/work/*.jar \n" +
        "    expect {\n" +
        "            \"yes/no\" {send \"yse\\r\"; exp_continue}\n" +
        "            \"password:\" {send "+password+"\r; exp_continue}\n" +
        "            }\n" +
        "EOF";


//        Runtime.getRuntime().exec("git clone https://github.com/ic-xu/jenkins.git");
//
//        process = Runtime.getRuntime().exec("mvn clean install");


        System.out.println( getResult(s));
    }

    public static String getResult(String bash) throws IOException {
        String[] cmd = new String[]{"/bin/sh", "-c", bash};
        Process process = Runtime.getRuntime().exec(cmd);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String line = reader.readLine();
        while (null != line) {
            stringBuffer.append(line + "\n");
            line = reader.readLine();
        }
        return stringBuffer.toString();
    }

}
