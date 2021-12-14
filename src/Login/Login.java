package Login;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//实现登陆和注册功能
public class Login {


    public static void main() throws Exception{

    }
    public void Show()throws Exception{
        System.out.println("请选择方式(输入其他退出)");
        System.out.println("1--登陆");
        System.out.println("2--注册");
        Scanner scanner=new Scanner(System.in);
        String n=scanner.next();
        switch (n){
            case "1":this.login();break;
            case "2":this.newlogin();break;
            default:System.exit(-1);
        }
    }

    public Boolean login() throws Exception{
        String name=null;
        String password=null;
        Map<String,String> userlist=new HashMap<>();
        File file=new File("./src/Login/user.txt");
        FileReader reader=new FileReader(file);
        BufferedReader reader1=new BufferedReader(reader);
        name=reader1.readLine();
       while (name!=null){
           password=reader1.readLine();
           userlist.put(name,password);
           name=reader1.readLine();
       }
       reader1.close();
       reader.close();

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名：");
        name=scanner.nextLine();
        System.out.println("请输入密码：");
        password=scanner.nextLine();
        if(name.equals(password)){
            System.out.println("ERROR!(用户名和密码不能相同)");
            this.Show();
        }

        if(userlist.get(name).equals(password)){

            System.out.println("登陆成功！");
            return true;
        }else{
            System.out.println("登陆失败！");
            this.Show();
        }
        return false;
    }
    public void newlogin()throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name=scanner.nextLine();
        System.out.println("请输入密码：");
        String password=scanner.nextLine();

        File file=new File("./src/Login/user.txt");
        FileWriter writer=new FileWriter(file,true);
        writer.write(name);
        writer.write("\n");
        writer.write(password);
        writer.write("\n");
        writer.close();
        System.out.println("注册成功！返回登陆页面");
        this.login();
    }


}
