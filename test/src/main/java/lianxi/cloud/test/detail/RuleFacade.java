package lianxi.cloud.test.detail;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/20 11:30
 */
public class RuleFacade {
    private static Map<String, List<UseRuleConfigBean>> ruleMap = new HashMap<>();
    private static Map<String, PurseInfoBean> purseInfoMap = new HashMap<>();

    public static void buildMap() {
        //Step1,数据库查询积分类别使用规则规则配置表
        List<UseRuleConfigBean> ruleConfigBeanList = new ArrayList<>();
        //purseIdList = select * from tbl_vp_purse_use_rule_config where status = 1
        //Step1.1,构建map映射关系
        Map<String, List<UseRuleConfigBean>> ruleMap = ruleConfigBeanList.stream().collect(Collectors.groupingBy(UseRuleConfigBean::getPurseInfo));

        //Step2,数据库查询客户积分类别管理表
        List<PurseInfoBean> purseInfoBeanList = new ArrayList<>();
        //purseInfoBeanList = select * from tbl_vp_purse_info where status = 1
        //Step2.1,构建映射关系
        Map<String, PurseInfoBean> purseInfoMap = new HashMap<>(purseInfoBeanList.size());
        purseInfoBeanList.forEach(purseInfoBean -> purseInfoMap.put(purseInfoBean.getId(), purseInfoBean));
    }

    public static boolean isMatchRule(Object bean) {
//        //Step1,根据积分类别获取规则列表
//        List<Object> ruleList = ruleMap.get(bean.purseId);
//        //Step2,逐条判断是否匹配
//        boolean rt = ruleList.stream().allMatch(rule -> {
//            switch (rule.paramFiled) {
//                //比较字段“1”代表MCC规则
//                case "1": {
//                    //比较方式“1”代表“包含”
//                    if (rule.compare == "1") {
//                        //比较前截取rule.compareSubLen位
//                        String str = bean.MCC.substring(0, rule.compareSubLen);
//                        return str.contains(rule.compareKeys);
//                    }else if (rule.compare == "2"){
//                    } ...
//                    break;
//                };
//                //比较字段“2”代表商编规则
//                case "2": {
//                    break;
//                };
//            ...
//            }
//            return true;
//        });
//        return rt;
        return true;
    }

    public PointAccountBean filter(Object tradeBean) {
        //Step1,在数据库中根据openId查询个人客户积分账户
        List<PointAccountBean> accountList = null;
        List<PointAccountBean> rt = new ArrayList<>();
        //accountList = select * from tbl_vp_personal_point_acct_info where open_id = tradeBean.openId and time_now() between start_date and end_date

        //Step2,通过用分规则初步筛选符合条件的积分账户
        accountList.forEach(account -> {
            //Step2.1,组装bean
            Object bean = wrapBean(account.openId, tradeBean);
            //Step2.2,调用用分规则匹配方法判断是否匹配,若匹配加入初步筛选列表
            if (isMatchRule(bean)) {
                rt.add(account);
            }
        });
        //Step2.3,若列表为空，返回null，
        if (rt.size() == 0) {
            return null;
        }
        //Step2.4,若列表长度为1，返回该条账户信息
        if (rt.size() == 1) {
            return rt.get(0);
        }

        //Step3,若列表长度大于1，按照积分类别优先级进行筛选
        Map<String, List<PointAccountBean>> typeMap = new LinkedHashMap<>();
        //Step3.1,将排序关键字依次放入LinkedHashMap的key中
        List<String> sortKeys = new ArrayList<>();
        //purseOrderBeanList =select * from tbl_vp_personal_purse_order_conf where open_id = tradeBean.openId;
        for (int i = 0; i < sortKeys.size(); i++) {
            typeMap.put(sortKeys.get(0), null);
        }
        //Step3.2,将步骤2中初步筛选的积分账户列表按排序关键字分组
        accountList.forEach(pointAccountBean -> {
            String sortKey = purseInfoMap.get(pointAccountBean).purseKindsType;
            if (typeMap.get(sortKey) == null) {
                List<PointAccountBean> pointAccountBeanList = new ArrayList<>();
                pointAccountBeanList.add(pointAccountBean);
                typeMap.put(sortKey, pointAccountBeanList);
            } else {
                typeMap.get(sortKey).add(pointAccountBean);
            }
        });
        //Step3.3,取得typeMap中第一条value不为空的值
        Iterator<Map.Entry<String, List<PointAccountBean>>> iterator = typeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<PointAccountBean>> currentItem = iterator.next();
            if (currentItem.getValue() != null) {
                rt.clear();
                rt.addAll(currentItem.getValue());
            }
        }
        //Step3.4,若rt长度是否为1，返回
        if (rt.size() == 1) {
            return rt.get(0);
        }

        //Step4,按积分过期时间排序
        rt.sort(Comparator.comparing(PointAccountBean::getEndDate));

        //Step4.1,返回第一条
        return rt.get(0);
    }

    private Object wrapBean(String openId, Object tradeBean) {
        return null;
    }


}
