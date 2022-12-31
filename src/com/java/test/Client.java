package com.java.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.test.factory.AddESSUserFactory;
import com.java.test.factory.OpenAdminViewFactory;
import com.java.test.factory.RemoveUserFactory;
import com.java.test.factory.SearchUserFactory;
import com.java.test.factory.SignInFactory;
import com.java.test.factory.UserManagementUsersFactory;
import com.java.test.interfaces.ClientInterface;
import com.java.test.interfaces.factory.AddESSUserFactoryInterface;
import com.java.test.interfaces.factory.OpenAdminViewFactoryInterface;
import com.java.test.interfaces.factory.RemoveUserFactoryInterface;
import com.java.test.interfaces.factory.SearchUserFactoryInterface;
import com.java.test.interfaces.factory.SignInFactoryInterface;
import com.java.test.interfaces.factory.UserManagementUsersFactoryInterface;
import com.java.test.interfaces.model.ESSUserModelInterface;
import com.java.test.interfaces.model.SignInModelInterface;
import com.java.test.model.ESSUserModel;
import com.java.test.model.SignInModel;

public class Client implements ClientInterface {
    private WebDriver driver;

    public Client(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn() {
        List<WebElement> credentials = driver.findElements(By.xpath("//p[@class='oxd-text oxd-text--p']"));

        SignInModelInterface signInRequest = new SignInModel(credentials.get(0), credentials.get(1));

        SignInFactoryInterface factory = new SignInFactory(driver);
        
        factory.signIn(signInRequest);
    }

    public void openAdminView() {
        OpenAdminViewFactoryInterface factory = new OpenAdminViewFactory(driver);

        factory.openAdminView();
    }

    public void admin_userManagement_users() {
        UserManagementUsersFactoryInterface factory = new UserManagementUsersFactory(driver);

        factory.open();
    }
    
    public void addESSUser(String name, String surname, String password, String employeeName)  throws InterruptedException {

        ESSUserModelInterface user = new ESSUserModel(name, surname, password, employeeName);

        AddESSUserFactoryInterface factory = new AddESSUserFactory(driver);
        
        factory.addESSUser(user);
    }

    public void searchUser(String username)  throws InterruptedException {

        SearchUserFactoryInterface factory = new SearchUserFactory(driver);
        
        factory.search(username);
    }

    public void removeUser(String username)  throws InterruptedException {
        this.searchUser(username);

        RemoveUserFactoryInterface factory = new RemoveUserFactory(driver);
        
        factory.remove(username);
    }
}
