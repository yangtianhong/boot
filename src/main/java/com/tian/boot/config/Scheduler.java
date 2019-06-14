package com.tian.boot.config;

import com.tian.boot.common.model.ZlpmThs;
import com.tian.boot.common.model.ZmoneyDfcf;
import com.tian.boot.one.mapper.ZlpmThsMapper;
import com.tian.boot.one.mapper.ZmoneyDfcfMapper;
import com.tian.boot.util.HttpProvide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Scheduler {

    private String today_String;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ZlpmThsMapper zlpmThsMapper;
    @Autowired
    private ZmoneyDfcfMapper zmoneyDfcfMapper;


   public String getTime(){
       Date day=new Date();
       SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
       return df.format(day);
   }
    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
    public void runZJ_DFCF(){
        String content="";
        today_String=getTime();
        ZmoneyDfcf temp=new ZmoneyDfcf();
        temp.setToday(today_String.substring(0,4)+"-"+today_String.substring(4,6)+"-"+today_String.substring(6,8));
        Integer num=zmoneyDfcfMapper.queryPmNum(temp);
        temp.setNum(num);
        List<ZmoneyDfcf>list=zmoneyDfcfMapper.queryByNumAndToday(temp);
        Map<String,ZmoneyDfcf>map=new HashMap<String,ZmoneyDfcf>();
        for(ZmoneyDfcf te:list){
            map.put(te.getCode(), te);
        }
        HttpProvide httpProvide=new HttpProvide();
        String url="http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?type=ct&st=(BalFlowMain)&sr=-1&p=1&ps=50000&js=var%20XDYfxWok={pages:(pc),date:%222014-10-22%22,data:[(x)]}&token=894050c76af8597a853f5b408b759f5d&cmd=C._A&sty=DCFFITA&rt=51990678";
        content=httpProvide.requestByGetMethod(url);
        content=content.split("\\[")[1].split("\\]")[0];
        System.out.println(content);
        String arg[]=content.split(",");
        ZmoneyDfcf zmoneyDfcf=null;
        for(int i=1;i<=arg.length;i++){
            String zhi=arg[i-1];
            if(i%17==1){
                zmoneyDfcf=new ZmoneyDfcf();
            }if(i%17==2)
                zmoneyDfcf.setCode(zhi);
            if(i%17==3)
                zmoneyDfcf.setName(zhi);
            if(i%17==4&&!"-".equals(zhi))
                zmoneyDfcf.setCurrentPrice(Double.valueOf(zhi));
            if(i%17==5&&!"-".equals(zhi))
                zmoneyDfcf.setChangeRate(Double.valueOf(zhi));
            if(i%17==6&&!"-".equals(zhi))
                zmoneyDfcf.setFlowMoney(Double.valueOf(zhi));
            if(i%17==7&&!"-".equals(zhi))
                zmoneyDfcf.setFlowRate(Double.valueOf(zhi));
            if(i%17==8&&!"-".equals(zhi))
                zmoneyDfcf.setLargeBigMoney(Double.valueOf(zhi));
            if(i%17==9&&!"-".equals(zhi))
                zmoneyDfcf.setLargeBigRate(Double.valueOf(zhi));
            if(i%17==10&&!"-".equals(zhi))
                zmoneyDfcf.setBigMoney(Double.valueOf(zhi));
            if(i%17==11&&!"-".equals(zhi))
                zmoneyDfcf.setBigRate(Double.valueOf(zhi));
            if(i%17==12&&!"-".equals(zhi))
                zmoneyDfcf.setMidMoney(Double.valueOf(zhi));
            if(i%17==13&&!"-".equals(zhi))
                zmoneyDfcf.setMidRate(Double.valueOf(zhi));
            if(i%17==14&&!"-".equals(zhi))
                zmoneyDfcf.setSmaMoney(Double.valueOf(zhi));
            if(i%17==15&&!"-".equals(zhi))
                zmoneyDfcf.setSmaRate(Double.valueOf(zhi));
            if(i%17==16&&!"-".equals(zhi)){
                zmoneyDfcf.setToday(zhi.substring(0, 10));
                zmoneyDfcf.setCdate(new Date());
                if(num==null||num==0){
                    zmoneyDfcf.setNum(1);
                    zmoneyDfcf.setFlowMoneyFirst(zmoneyDfcf.getFlowMoney());
                    zmoneyDfcf.setFlowRateFirst(zmoneyDfcf.getFlowRate());
                    zmoneyDfcf.setLargeBigMoneyFirst(zmoneyDfcf.getLargeBigMoney());
                    zmoneyDfcf.setLargeBigRateFirst(zmoneyDfcf.getLargeBigRate());
                    zmoneyDfcf.setBigMoneyFirst(zmoneyDfcf.getBigMoney());
                    zmoneyDfcf.setBigRateFirst(zmoneyDfcf.getBigRate());
                }else{
                    zmoneyDfcf.setNum(num+1);

                    ZmoneyDfcf z=map.get(zmoneyDfcf.getCode());
                    System.out.println("z.getCode():"+z.getCode());
                    zmoneyDfcf.setFlowMoneyFirst(z.getFlowMoneyFirst());
                    zmoneyDfcf.setFlowRateFirst(z.getFlowRateFirst());
                    zmoneyDfcf.setLargeBigMoneyFirst(z.getLargeBigMoneyFirst());
                    zmoneyDfcf.setLargeBigRateFirst(z.getLargeBigRateFirst());
                    zmoneyDfcf.setBigMoneyFirst(z.getBigMoneyFirst());
                    zmoneyDfcf.setBigRateFirst(z.getBigRateFirst());
                    //净流入
                    if(zmoneyDfcf.getFlowMoney()!=null){
                        Double  t1=zmoneyDfcf.getFlowMoney()-z.getFlowMoney();
                        zmoneyDfcf.setFlowMoneyChange(t1);
                    }
                    if(zmoneyDfcf.getFlowRate()!=null){
                        Double  t2=zmoneyDfcf.getFlowRate()-z.getFlowRate();
                        zmoneyDfcf.setFlowRateChange(t2);
                    }
                    //特大单
                    if(zmoneyDfcf.getLargeBigMoney()!=null){
                        Double  t3=zmoneyDfcf.getLargeBigMoney()-z.getLargeBigMoney();
                        zmoneyDfcf.setLargeBigMoneyChange(t3);
                    }
                    if(zmoneyDfcf.getLargeBigRate()!=null){
                        Double  t4=zmoneyDfcf.getLargeBigRate()-z.getLargeBigRate();
                        zmoneyDfcf.setLargeBigRateChange(t4);
                    }
                    //大单
                    if(zmoneyDfcf.getBigMoney()!=null){
                        Double  t5=zmoneyDfcf.getBigMoney()-z.getBigMoney();
                        zmoneyDfcf.setBigMoneyChange(t5);
                    }

                    if(zmoneyDfcf.getBigRate()!=null){
                        Double  t6=zmoneyDfcf.getBigRate()-z.getBigRate();
                        zmoneyDfcf.setBigRateChange(t6);
                    }

                }

                zmoneyDfcfMapper.insertSelective(zmoneyDfcf);
            }


        }
    }

    @Scheduled(cron="0 0/1 * * * ?") ///每分钟执行一次
    public void runZL_THS(){
        String content="";
        ZlpmThs temp=new ZlpmThs();
        today_String=getTime();
        temp.setToday(today_String.substring(0,4)+"-"+today_String.substring(4,6)+"-"+today_String.substring(6,8));
        Integer num=zlpmThsMapper.queryPmNum(temp);
        temp.setNum(num);
        List<ZlpmThs> list=zlpmThsMapper.queryByNumAndToday(temp);
        Map<String,ZlpmThs> map=new HashMap<String,ZlpmThs>();
        for(ZlpmThs te:list){
            map.put(te.getCode(), te);
        }
        HttpProvide httpProvide=new HttpProvide();
        String url="http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?type=ct&st=(FFARank)&sr=1&p=1&ps=50000&js=var%20gIqUwsSM={pages:(pc),data:[(x)]}&token=894050c76af8597a853f5b408b759f5d&cmd=C._A&sty=DCFFITAMA&rt=51976216";
        content=httpProvide.requestByGetMethod(url);
        content=content.split("\\[")[1].split("\\]")[0];
        System.out.println(content);
        String arg[]=content.split(",");
        ZlpmThs zlpmThs=null;
        for(int i=1;i<=arg.length;i++){
            if(i%16==1){
                zlpmThs=new ZlpmThs();
            }
            if(i%16==2)
                zlpmThs.setCode(arg[i-1]);
            if(i%16==3)
                zlpmThs.setName(arg[i-1]);
            if(i%16==4&&!"-".equals(arg[i-1]))
                zlpmThs.setCurrentPrice(Double.valueOf(arg[i-1]));
            if(i%16==5&&!"-".equals(arg[i-1]))
                zlpmThs.setZlLv(Double.valueOf(arg[i-1]));
            if(i%16==6&&!"-".equals(arg[i-1]))
                zlpmThs.setPm1(Integer.valueOf(arg[i-1]));
            if(i%16==7&&!"-".equals(arg[i-1]))
                zlpmThs.setChangeRate(Double.valueOf(arg[i-1]));
            if(i%16==8&&!"-".equals(arg[i-1]))
                zlpmThs.setZlLvFive(Double.valueOf(arg[i-1]));
            if(i%16==9&&!"-".equals(arg[i-1]))
                zlpmThs.setPm1Fiv(Double.valueOf(arg[i-1]));
            if(i%16==10&&!"-".equals(arg[i-1]))
                zlpmThs.setChangeRateFive(Double.valueOf(arg[i-1]));
            if(i%16==11&&!"-".equals(arg[i-1]))
                zlpmThs.setZlLvTen(Double.valueOf(arg[i-1]));
            if(i%16==12&&!"-".equals(arg[i-1]))
                zlpmThs.setPm1Ten(Double.valueOf(arg[i-1]));
            if(i%16==13&&!"-".equals(arg[i-1]))
                zlpmThs.setChangeRateTen(Double.valueOf(arg[i-1]));
            if(i%16==14&&!"-".equals(arg[i-1]))
                zlpmThs.setBankuai(arg[i-1]);

            if(i%16==0&&!"-".equals(arg[i-1])){
                zlpmThs.setToday(arg[i-1].substring(0, 10));
                zlpmThs.setCdate(new Date());
                if(num==null||num==0){
                    zlpmThs.setNum(1);
                    zlpmThs.setFirstPm(Integer.parseInt(zlpmThs.getPm1().toString()));
                    zlpmThs.setFirstZl(zlpmThs.getZlLv());
                }else{
                    zlpmThs.setNum(num+1);
                    if(!"-".equals(zlpmThs.getPm1())){
                        ZlpmThs z=map.get(zlpmThs.getCode());
                        zlpmThs.setFirstPm(z.getFirstPm());
                        zlpmThs.setFirstZl(z.getFirstZl());
                        //排名
                        Integer t1=z.getPm1()-zlpmThs.getPm1();
                        zlpmThs.setPmNum(Integer.parseInt(t1.toString()));
                        //主力
                        Double  t2=zlpmThs.getZlLv()-z.getZlLv();
                        zlpmThs.setZlLvChange(t2);
                        //与第一次相比
                        Integer t3=zlpmThs.getFirstPm()-Integer.parseInt(zlpmThs.getPm1().toString());
                        zlpmThs.setPmNumFirst(t3);
                        Double t4=zlpmThs.getZlLv()-zlpmThs.getFirstZl();
                        zlpmThs.setZlLvChangeFirst(t4);
                    }


                }
                zlpmThsMapper.insertSelective(zlpmThs);
            }
        }
    }


}
