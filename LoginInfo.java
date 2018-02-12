package xlsx;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginInfo {

  public static final String DEALER = "Dealer";
  public static final String ADMIN = "Admin";
  public static final String BROKER = "Broker";
  public static final String CDTS = "CDTS";

  private Map<String, String> dealerMap;
  private Map<String, String> brokerMap;
  private Map<String, String> adminMap;
  private Map<String, String> cdtsMap;

  public LoginInfo(String xlsxFile) {
    this.dealerMap = getLoginMap(xlsxFile, DEALER);
    this.brokerMap = getLoginMap(xlsxFile, BROKER);
    this.adminMap = getLoginMap(xlsxFile, ADMIN);
    this.cdtsMap = getLoginMap(xlsxFile, CDTS);
  }


  public static Map<String, String> getLoginMap(String xlsxFile, String sheetName) {
    Map<String, String> map = new HashMap<>();
    try {
      FileInputStream excelFile = FileUtils.openInputStream(new File(xlsxFile));
      Workbook workbook = new XSSFWorkbook(excelFile);
      Sheet datatypeSheet = workbook.getSheet(sheetName);

      for (Row currentRow : datatypeSheet) {
        String userName = currentRow.getCell(0).getStringCellValue();
        String password = currentRow.getCell(1).getStringCellValue();
        if (StringUtils.equalsIgnoreCase(userName, "username") && StringUtils.equalsIgnoreCase(password, "password")){
          continue;
        }
        map.put(userName,password);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return map;
  }

  public Map<String, String> getDealerMap() {
    return dealerMap;
  }

  public Map<String, String> getBrokerMap() {
    return brokerMap;
  }

  public Map<String, String> getAdminMap() {
    return adminMap;
  }

  public Map<String, String> getCdtsMap() {
    return cdtsMap;
  }


  @Override
  public String toString() {
    return "{" +
        "\"dealerMap\":" + (dealerMap == null ? "null" : "\"" + dealerMap + "\"") + ", " +
        "\"brokerMap\":" + (brokerMap == null ? "null" : "\"" + brokerMap + "\"") + ", " +
        "\"adminMap\":" + (adminMap == null ? "null" : "\"" + adminMap + "\"") + ", " +
        "\"cdtsMap\":" + (cdtsMap == null ? "null" : "\"" + cdtsMap + "\"") +
        "}";
  }
}
