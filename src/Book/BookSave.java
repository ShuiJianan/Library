package Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookSave {
    public static void main(String[] args) throws Exception{
       BookSave bs=new BookSave();
       bs.Show();


    }

    public void play()throws Exception{
        System.out.println("欢迎来到java书店！");
        System.out.println("请选择服务项目：(输入其他退出)");
        System.out.println("1：存书");
        System.out.println("2：查找书");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        switch (s){
            case "1":Save();break;
            case "2":Show();break;
            default:System.exit(-1);
        }
    }
    //存储书籍
    public void Save()throws Exception{
        File file=new File("./src/Book/Book.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        String name=null;
        String price=null;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入书名：");
        name=scanner.nextLine();
        System.out.println("请输入价格：");
        price=scanner.nextLine();
        Book book=new Book(name,price);
        fileWriter.write("《");
        fileWriter.write(name);
        fileWriter.write("》");
        fileWriter.write("\n");
        fileWriter.write(price);
        fileWriter.write("\n");
        fileWriter.close();
        play();
    }

    //读取书籍列表
    public void Show()throws Exception{
        //展示列表时 先把文件中的内容读到内存
        Map<Integer,Book> booklist=new HashMap<Integer,Book>();
        File file=new File("./src/Book/Book.txt");
        FileReader fileReader=new FileReader(file);
        BufferedReader reader=new BufferedReader(fileReader);
        String name=reader.readLine();
        Integer i=1;
        String price=null;
        while (name!=null)
        {
            price=reader.readLine();
            Book book=new Book(name,price);
            booklist.put(i++,book);
            name=reader.readLine();
        }
        reader.close();
        fileReader.close();
        System.out.println("数据装载完成！");
        System.out.println("Booklist:");
        for (Integer integer = 1; integer < i; integer++) {
            System.out.println("Id:"+integer+", "+"书名:"+booklist.get(integer).getName()+","+"价格:"+booklist.get(integer).getPrice());
        }
        play();
    }
}
