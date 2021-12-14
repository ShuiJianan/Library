import Login.Login;
import Book.BookSave;
public class Main {

    public static void main(String[] args) throws Exception{
        Boolean Loginsuccess=Login();
        if(Loginsuccess==true){
            Find();
        }

    }
    public static Boolean Login()throws Exception{
        Login login=new Login();
        login.Show();
        return true;
    }

    public static void Find()throws Exception{
        BookSave book=new BookSave();
        book.play();
    }
}

