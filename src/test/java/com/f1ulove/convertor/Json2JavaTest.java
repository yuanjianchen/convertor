package com.f1ulove.convertor;

import com.f1ulove.convertor.json.JsonConverter;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.springframework.util.ClassUtils;

import java.io.IOException;

public class Json2JavaTest {

    @Test
    public void test1() throws IOException {
        String jsonStr = "{\n" +
                "  \"create_time\": \"下单时间\",\n" +
                "  \"booking_system_id\": \"预定方式\",\n" +
                "  \"operator_id\": \"客服人员\",\n" +
                "  \"operator_name\": \"客服人员\",\n" +
                "  \"company_id\": \"公司id\",\n" +
                "  \"booking_person\": {\n" +
                "    \"id\": \"预订人ID\",\n" +
                "    \"name\": \"预订人姓名\",\n" +
                "    \"phone\": \"预订人姓名\",\n" +
                "    \"unit_id\":\"部门id\",\n" +
                "    \"unit_name\": \"部门名称\"\n" +
                "  },\n" +
                "  \"ticket_no\": \"票号1,票号2,票号3\",\n" +
                "  \"passenger_id_list\": [\n" +
                "    \"乘机人ID\",\n" +
                "    \"乘机人ID\"\n" +
                "  ],\n" +
                "  \"supplier_id\": 1,\n" +
                "  \"remote_order_id\": \"\",\n" +
                "  \"pay_channel_id\": \"\",\n" +
                "  \"trip_type\": \"行程信息（1，单程；2，往返）\",\n" +
                "  \"segment_detail_list\": {\n" +
                "    \"go_segment_detail_list\": [\n" +
                "      {\n" +
                "        \"trip_type\": \"1（去程）\",\n" +
                "        \"carrier_name\": \"航司名称\",\n" +
                "        \"flight_no\": \"U12138\",\n" +
                "        \"code_share_flight\":true,\n" +
                "        \"main_carrier_name\": \"执飞（共享）航司名称\",\n" +
                "        \"main_flight_no\": \"执飞（共享）航班号\",\n" +
                "        \"dep_timestamp\": 1526515380000, \n" +
                "        \"dep_city_code\": \"出发城市三字码\",\n" +
                "        \"dep_city_name\": \"出发城市\",\n" +
                "        \"dep_airport\": \"出发机场\",\n" +
                "        \"dep_airport_code\": \"出发机场三字码\",\n" +
                "        \"dep_terminal\": \"起飞航站楼\",\n" +
                "        \"arr_timestamp\": 1526515380000,\n" +
                "        \"arr_city_code\": \"到达城市三字码\",\n" +
                "        \"arr_city_name\": \"到达城市\",\n" +
                "        \"arr_airport\": \"到达机场\",\n" +
                "        \"arr_airport_code\": \"到达机场三字码\",\n" +
                "        \"arr_terminal\": \"到达航站楼\",\n" +
                "        \"duration\": \"飞行时长\",\n" +
                "        \"cabin\": \"舱位code\",\n" +
                "        \"cabin_msg\": \"舱位信息\",\n" +
                "        \"pnr\": \"pnr信息\",\n" +
                "        \"middle_stop_count\": 0, \n" +
                "        \"stops\": [\n" +
                "          {\n" +
                "            \"country_name\": \"国家\",\n" +
                "            \"city_name\": \"城市\",\n" +
                "            \"stay_time\": \"经停时长\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"plane_type_name\": \"机型名称\",\n" +
                "        \"transits\": {\n" +
                "          \"country_name\": \"国家\",\n" +
                "          \"city_name\": \"城市\",\n" +
                "          \"stay_time\": \"停留时间\",\n" +
                "          \"same_port\": true\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"back_segment_detail_list\": [\n" +
                "      {\n" +
                "        \"trip_type\": \"2（返程）\",\n" +
                "        \"carrier_name\": \"航司名称\",\n" +
                "        \"flight_no\": \"U12138\",\n" +
                "        \"main_carrier_name\": \"执飞（共享）航司名称\",\n" +
                "        \"main_flight_no\": \"执飞（共享）航班号\",\n" +
                "        \"dep_timestamp\": 1526515380000,\n" +
                "        \"dep_city_code\": \"出发城市三字码\",\n" +
                "        \"dep_city_name\": \"出发城市\",\n" +
                "        \"dep_airport\": \"出发机场\",\n" +
                "        \"dep_airport_code\": \"出发机场三字码\",\n" +
                "        \"dep_terminal\": \"起飞航站楼\",\n" +
                "        \"arr_timestamp\": 1526515380000,\n" +
                "        \"arr_city_code\": \"到达城市三字码\",\n" +
                "        \"arr_city_name\": \"到达城市\",\n" +
                "        \"arr_airport\": \"到达机场\",\n" +
                "        \"arr_airport_code\": \"到达机场三字码\",\n" +
                "        \"arr_terminal\": \"到达航站楼\",\n" +
                "        \"duration\": \"飞行时长\",\n" +
                "        \"cabin\": \"舱位code\",\n" +
                "        \"cabin_msg\": \"舱位信息\",\n" +
                "        \"pnr\": \"pnr信息\",\n" +
                "        \"middle_stop_count\": 0,\n" +
                "        \"stops\": [\n" +
                "          {\n" +
                "            \"country_name\": \"国家\",\n" +
                "            \"city_name\": \"城市\",\n" +
                "            \"stay_time\": \"经停时长\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"plane_type_name\": \"机型名称\",\n" +
                "        \"transits\": {\n" +
                "          \"country_name\": \"国家\",\n" +
                "          \"city_name\": \"城市\",\n" +
                "          \"stay_time\": \"停留时间\",\n" +
                "          \"same_port\": true\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"tgq_info\": \"退改签规则\",\n" +
                "  \"baggage_info\": \"行李规定\",\n" +
                "  \"price_info\": {\n" +
                "    \"ticket_selling_price\": \"票销售价\",\n" +
                "    \"ticket_cost_price\": \"票采购价\",\n" +
                "    \"insurance_selling_price\": \"保险售价\",\n" +
                "    \"insurance_cost_price\": \"保险采购价\",\n" +
                "    \"taxes\": \"税费\",\n" +
                "    \"order_total_price\": \"订单总价\",\n" +
                "    \"ticket_par_price\": \"票面价\",\n" +
                "    \"ticket_par_discount\": \"票面折扣\"\n" +
                "  },\n" +
                "  \"internal_remark\": \"内部备注\",\n" +
                "  \"external_remark\": \"外部备注\",\n" +
                "  \"cost_attribution\": {\n" +
                "    \"id\": \"费用归属id\",\n" +
                "    \"name\": \"费用归属名称\",\n" +
                "    \"category\": \"费用归属类型（1：部门；2：项目）\"\n" +
                "  }\n" +
                "}";
        JsonConverter convertor = new JsonConverter();
        String testClass = convertor.convert2JavaBean(jsonStr, "TestClass");
        System.out.println(testClass);
    }


    @Test
    public void test2() throws IOException {
        String jsonStr = "{\n" +
                "\t\"msg\": \"success\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"results\": [{\n" +
                "\t\t\t\"booking_person\": { // 预订人信息，原字段名bookingPerson\n" +
                "\t\t\t\t\"id\": \"58ac12a55f281a629196b446\",\n" +
                "\t\t\t\t\"name\": \"刘维中\",\n" +
                "\t\t\t\t\"phone\": \"18601016943\",\n" +
                "\t\t\t\t\"unit_name\":\"预订人部门\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"air_info\": { // 航班信息 原字段名airInfo\n" +
                "\t\t\t\t\"passenger_info\": { // 乘机人信息 原字段名passengerInfo\n" +
                "\t\t\t\t\t\"phone\": \"18601016943\",\n" +
                "\t\t\t\t\t\"identity_no\": \"230422198707272413\", // 证件号\n" +
                "\t\t\t\t\t\"name\": \"刘维中\",\n" +
                "\t\t\t\t\t\"type\": 0,\n" +
                "\t\t\t\t\t\"identity_type\": {\n" +
                "\t\t\t\t\t\t\"key\": 1,\n" +
                "\t\t\t\t\t\t\"value\": \"身份证\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t    \"unit_name\":\"乘机人部门\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"flight_info\": { // 原字段名flightInfo\n" +
                "\t\t\t\t\t\"starting_city\": \"北京\",\n" +
                "\t\t\t\t\t\"starting_airport\": \"首都国际机场\",\n" +
                "\t\t\t\t\t\"starting_terminal\": \"T3\",\n" +
                "\t\t\t\t\t\"starting_code\": \"PEK\",\n" +
                "\t\t\t\t\t\"starting_time\": \"2018-05-16 16:40:00\",\n" +
                "\t\t\t\t\t\"arrived_city\": \"上海\",\n" +
                "\t\t\t\t\t\"arrived_airport\": \"虹桥国际机场\",\n" +
                "\t\t\t\t\t\"arrived_terminal\": \"T2\",\n" +
                "\t\t\t\t\t\"arrived_code\": \"SHA\",\n" +
                "\t\t\t\t\t\"arrived_time\": \"2018-05-16 16:40:00\",\n" +
                "\t\t\t\t\t\"cabin\": \"A\",\n" +
                "\t\t\t\t\t\"plane_type\": \"333\",\n" +
                "\t\t\t\t\t\"seat_msg\": \"头等舱\",\n" +
                "\t\t\t\t\t\"flight_no\": \"CA1531\",\n" +
                "\t\t\t\t\t\"airline_name\": \"中国国航\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"trip_type\": 1, // 行程类型 1：单程；2：往返\n" +
                "\t\t\t    \"is_intl\": false // 是否国际\n" +
                "\t\t\t},\n" +
                "\t\t\t\"remark_info\": { // 事由 原字段名remarkInfo\n" +
                "\t\t\t\t\"remark_detail\": \"事由补充内容\", // 原字段名 remarkDetail\n" +
                "\t\t\t\t\"remark\": \"事由\",\n" +
                "\t\t\t\t\"manual_remark\": \"外部备注\", // manual_remark\n" +
                "\t\t\t\t\"inner_remark\":\"内部备注\",\n" +
                "\t\t\t\t\"fail_reason\": \"最后一次失败理由\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"price_info\": { // 价格信息 原字段名priceInfo\n" +
                "\t\t\t\t\"coupon_amount\": 0, // 优惠券金额 原字段名couponAmount\n" +
                "\t\t\t\t\"sale_price\": 1240, // 销售价 原字段名salePrice\n" +
                "\t\t\t\t\"par_price\": 1240, // 票面价 原字段名parPrice\n" +
                "\t\t\t\t\"total_price\": 1290, // 订单总价 原字段名totalPrice\n" +
                "\t\t\t\t\"settle_price\": 1240, // 原字段名settlePrice\n" +
                "\t\t\t\t\"air_port_and_fuel_tax\": 50, // 机建燃油 原字段名airPortAndFuelTax\n" +
                "\t\t\t\t\"tax_fee\": 50, // 税费（国际机票）\n" +
                "\t\t\t\t\"insurance_price\": 50, // 保险销售价\n" +
                "\t\t\t\t\"insurance_cost_price\": 40, // 保险采购价\n" +
                "\t\t\t\t\"upgrade_fee\": 1000, // 升舱费\n" +
                "\t\t\t\t\"endorse_fee\": 100, // 改签费\n" +
                "\t\t\t\t\"service_fee\": 0, // 改签手续费\n" +
                "\t\t\t\t\"refund_fee\": 100, // 退票费\n" +
                "\t\t\t\t\"discount\": 0.6 // 折扣信息\n" +
                "\t\t\t},\n" +
                "\t\t\t\"air_status\": { // 机票状态 原字段名airStatus\n" +
                "\t\t\t\t\"key\": 1100,\n" +
                "\t\t\t\t\"value\": \"待支付\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"order_status\": { // 订单状态\n" +
                "\t\t\t\t\"key\": 1100,\n" +
                "\t\t\t\t\"value\": \"待支付\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"channel\": { // 订单来源\n" +
                "\t\t\t\t\"key\": 11,\n" +
                "\t\t\t\t\"value\": \"Android\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ticket_id\": \"58ae93865f281a43b066d00e\", // 票id 原字段名ticketId\n" +
                "\t\t\t\"contact\": { // 联系人信息\n" +
                "\t\t\t\t\"id\": \"\",\n" +
                "\t\t\t\t\"name\": \"韩美美\",\n" +
                "\t\t\t\t\"phone\": \"18601016943\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"company\": { // 公司信息\n" +
                "\t\t\t\t\"id\": \"5747fbc10f0e60e0709d8d7d\",\n" +
                "\t\t\t\t\"name\": \"北京分贝金服科技有限公司\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"create_time\": \"2017-02-23 15:47:18\", // 预定/退订时间 原字段名createTime\n" +
                "\t\t\t\"order_id\": \"58ae93835f281a43b066d00c\", // 订单id 原字段名orderId\n" +
                "\t\t\t\"ticket_no\": \"880-2137615761\", // 票号 原字段名ticketNo\n" +
                "\t\t\t\"remote_order_id\": \"112017022383692562\", // 供应商单号 原字段名remoteOrderId\n" +
                "\t\t\t\"cost_attribution\": { // 费用归属信息\n" +
                "\t\t\t\t\"category\": 1, \n" +
                "\t\t\t\t\"category_name\": \"项目\", // 费用归属类型\n" +
                "\t\t\t\t\"id\": \"57675fa82a3cb4c515a45f16\", // 费用归属id\n" +
                "\t\t\t\t\"name\": \"stereo项目\" // 费用归属名称\n" +
                "\t\t\t},\n" +
                "\t\t\t\"operator_info\": { // 客服人员信息\n" +
                "\t\t\t\t\"id\": 1, \n" +
                "\t\t\t\t\"name\": \"张三\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"supplier\": {\n" +
                "\t\t\t    \"key\": 118, \n" +
                "\t\t\t\t\"value\": \"去哪儿\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"insurance_info\": [{ // 保险信息 原字段名insuranceInfo\n" +
                "\t\t\t\t\"status\": { // 保险状态\n" +
                "\t\t\t\t\t\"key\": 5101,\n" +
                "\t\t\t\t\t\"value\": \"已投保\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"premium\": 30, // 保险金额\n" +
                "\t\t\t\t\"start_date\": \"2017-03-20\", // 开始时间\n" +
                "\t\t\t\t\"insurant_name\": \"李四\", // 投保人姓名\n" +
                "\t\t\t\t\"end_date\": \"2017-03-21\",\n" +
                "\t\t\t\t\"policy_number\": \"1000191573\",\n" +
                "\t\t\t\t\"category_name\": \"航意险\",\n" +
                "\t\t\t\t\"category_id\": 1,\n" +
                "\t\t\t\t\"unit_price\": 30\n" +
                "\t\t\t}]\n" +
                "\t\t}],\n" +
                "\t\t\"total_count\": 1 // 原字段名totalCount\n" +
                "\t},\n" +
                "\t\"code\": 0\n" +
                "}";
        JsonConverter convertor = new JsonConverter();
//        String testClass = convertor.convert2JavaBean(jsonStr, "TestClass");
        System.out.println(convertor.dealAnnotation(jsonStr, com.google.common.collect.Maps.newHashMap()));
    }

    @Test
    public void test3() {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
    }
}
