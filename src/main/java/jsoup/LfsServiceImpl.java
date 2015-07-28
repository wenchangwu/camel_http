package jsoup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jsoup.dto.ResponseMsg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @description 湖北荆州水厂服务处理类
 * @author wenchang.wu
 * @version $Id: JingZhouWaterBillServiceImpl.java, v 0.1 2014-10-9 下午1:11:06 wenchang.wu Exp $
 */
public class LfsServiceImpl implements LfsService {

    private static Logger logger = LoggerFactory.getLogger(LfsServiceImpl.class);
    

    /**
     * 根据客户号查询出相应明细信息
     * 
     * @param customerNo
     * @return	
     */
    @Override
    public String doQuery(String customerNo) {

    	ResponseMsg response=new ResponseMsg();
        //第一步查询用户基本信息
        Map dMap = new HashMap<String, String>();
        dMap.put("customerNo", customerNo);
        dMap.put("filecontent", new byte[10]);

        Document doc;
        try {
            doc = Jsoup.connect("http://61.184.35.21/sys/getBaseClientInfo.do").timeout(300000).data(dMap)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:24.0) Gecko/20100101 Firefox/24.0").post();
            String abstractInfo = doc.select("body").text();

          
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return null;
    }
    
}
