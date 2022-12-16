package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "criteria")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Tester", "Harrow", "up to 5 miles", "30000", "500000", "Per annum", "Permanent", "Permanent Tester jobs in Harrow on the Hill"},
//                {"Teacher","Edinburgh","up to 10 miles","32000","400000","Per annum","Contract","Contract Teacher jobs in Edinburgh"},
//                {"Translator","London","up to 15 miles","340","300000","Per week","Part Time","Part Time Translator jobs in London"},
//                {"Mathematician","Birmingham","up to 5 miles","3100","400000","Per month","Permanent","Permanent Mathematician jobs in Birmingham"},
//                {"Accountant","Leeds","up to 15 miles","31000","300000","Per annum","Contract","Contract Accountant jobs in Leeds"},
//                {"Manager","Cambridge","up to 25 miles","35000","200000","Per annum","Permanent","Permanent Manager jobs in Cambridge"},
//                {"Trainer","Cardiff","up to 15 miles","29000","100000","Per annum","Part Time","Part Time Trainer jobs in Cardiff"},
        };
        return data;
    }

}
