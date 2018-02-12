package xlsx;

public class ApachePOIExcelRead {


  public static void main(String[] args) {
    final String XLSX_FILE_NAME = "C:\\Users\\mark-4304\\Downloads\\Testleaf_Testdata2.xlsx";
    LoginInfo loginInfo = new LoginInfo(XLSX_FILE_NAME);
    System.out.println("loginInfo = " + loginInfo);
    String password = loginInfo.getAdminMap().get("Admin2");
    System.out.println("password = " + password);
  }

}
