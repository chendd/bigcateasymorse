<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- saved from url=(0042)http://www.51booking.cn/reg/hotel_reg.asp# -->
<HTML><HEAD><META http-equiv="Content-Type" content="text/html; charset=GBK">
<SCRIPT language="JavaScript" type="text/javascript">
var onecount;
onecount=0;
subcat = new Array();

subcat[0] = new Array("安庆","35","725");

subcat[1] = new Array("蚌埠","35","726");

subcat[2] = new Array("合肥","35","727");

subcat[3] = new Array("黄山","35","728");

subcat[4] = new Array("芜湖","35","730");

subcat[5] = new Array("福州","37","732");

subcat[6] = new Array("龙岩","37","733");

subcat[7] = new Array("泉州","37","734");

subcat[8] = new Array("厦门","37","735");

subcat[9] = new Array("漳州","37","736");

subcat[10] = new Array("兰州","38","737");

subcat[11] = new Array("嘉峪关","38","738");

subcat[12] = new Array("酒泉","38","739");

subcat[13] = new Array("潮州","39","741");

subcat[14] = new Array("东莞","39","742");

subcat[15] = new Array("佛山","39","743");

subcat[16] = new Array("广州","39","744");

subcat[17] = new Array("河源","39","745");

subcat[18] = new Array("惠州","39","746");

subcat[19] = new Array("江门","39","747");

subcat[20] = new Array("揭阳","39","748");

subcat[21] = new Array("茂名","39","749");

subcat[22] = new Array("梅州","39","750");

subcat[23] = new Array("清远","39","751");

subcat[24] = new Array("汕头","39","752");

subcat[25] = new Array("汕尾","39","753");

subcat[26] = new Array("韶关","39","754");

subcat[27] = new Array("深圳","39","755");

subcat[28] = new Array("阳江","39","756");

subcat[29] = new Array("湛江","39","757");

subcat[30] = new Array("肇庆","39","759");

subcat[31] = new Array("中山","39","760");

subcat[32] = new Array("珠海","39","761");

subcat[33] = new Array("桂林","40","762");

subcat[34] = new Array("北海","40","763");

subcat[35] = new Array("柳州","40","764");

subcat[36] = new Array("南宁","40","765");

subcat[37] = new Array("玉林","40","766");

subcat[38] = new Array("贵阳","41","767");

subcat[39] = new Array("六盘水","41","768");

subcat[40] = new Array("毕节","41","769");

subcat[41] = new Array("遵义","41","770");

subcat[42] = new Array("海口","42","771");

subcat[43] = new Array("三亚","42","772");

subcat[44] = new Array("通什","42","773");

subcat[45] = new Array("石家庄","43","774");

subcat[46] = new Array("唐山","43","775");

subcat[47] = new Array("秦皇岛","43","776");

subcat[48] = new Array("承德","43","777");

subcat[49] = new Array("郑州","44","778");

subcat[50] = new Array("三门峡","44","779");

subcat[51] = new Array("洛阳","44","780");

subcat[52] = new Array("开封","44","781");

subcat[53] = new Array("哈尔滨","45","782");

subcat[54] = new Array("佳木斯","45","783");

subcat[55] = new Array("黑河","45","784");

subcat[56] = new Array("牡丹江","45","785");

subcat[57] = new Array("齐齐哈尔","45","786");

subcat[58] = new Array("大兴安岭","45","787");

subcat[59] = new Array("大庆","45","788");

subcat[60] = new Array("武汉","46","789");

subcat[61] = new Array("宜昌","46","790");

subcat[62] = new Array("赤壁","46","791");

subcat[63] = new Array("荆门","46","792");

subcat[64] = new Array("黄石","46","793");

subcat[65] = new Array("长沙","47","794");

subcat[66] = new Array("衡阳","47","795");

subcat[67] = new Array("湘潭","47","796");

subcat[68] = new Array("郴州","47","797");

subcat[69] = new Array("常德","47","798");

subcat[70] = new Array("怀化","47","799");

subcat[71] = new Array("永州","47","800");

subcat[72] = new Array("株洲","47","801");

subcat[73] = new Array("岳阳","47","802");

subcat[74] = new Array("张家界","47","803");

subcat[75] = new Array("长春","48","804");

subcat[76] = new Array("南京","49","807");

subcat[77] = new Array("常州","49","808");

subcat[78] = new Array("连云港","49","809");

subcat[79] = new Array("苏州","49","810");

subcat[80] = new Array("南通","49","811");

subcat[81] = new Array("无锡","49","812");

subcat[82] = new Array("徐州","49","813");

subcat[83] = new Array("扬州","49","814");

subcat[84] = new Array("镇江","49","815");

subcat[85] = new Array("九江","69","817");

subcat[86] = new Array("沈阳","51","820");

subcat[87] = new Array("大连","51","821");

subcat[88] = new Array("鞍山","51","822");

subcat[89] = new Array("丹东","51","823");

subcat[90] = new Array("呼和浩特","52","824");

subcat[91] = new Array("鄂尔多斯","52","825");

subcat[92] = new Array("赤峰","52","826");

subcat[93] = new Array("包头","52","827");

subcat[94] = new Array("银川","53","828");

subcat[95] = new Array("固原","53","829");

subcat[96] = new Array("石嘴山","53","830");

subcat[97] = new Array("吴忠","53","831");

subcat[98] = new Array("西宁","54","832");

subcat[99] = new Array("济南","55","838");

subcat[100] = new Array("青岛","55","839");

subcat[101] = new Array("烟台","55","840");

subcat[102] = new Array("淄博","55","841");

subcat[103] = new Array("太原","56","842");

subcat[104] = new Array("大同","56","843");

subcat[105] = new Array("西安","57","844");

subcat[106] = new Array("咸阳","57","845");

subcat[107] = new Array("延安","57","846");

subcat[108] = new Array("宝鸡","57","847");

subcat[109] = new Array("上海","58","848");

subcat[110] = new Array("成都","59","849");

subcat[111] = new Array("绵阳","59","850");

subcat[112] = new Array("西昌","59","851");

subcat[113] = new Array("广安","59","852");

subcat[114] = new Array("宜宾","59","853");

subcat[115] = new Array("天津","60","854");

subcat[116] = new Array("拉萨","61","855");

subcat[117] = new Array("阿里","61","856");

subcat[118] = new Array("乌鲁木齐","62","857");

subcat[119] = new Array("吐鲁番","62","858");

subcat[120] = new Array("克拉玛依","62","859");

subcat[121] = new Array("昆明","63","860");

subcat[122] = new Array("丽江","63","861");

subcat[123] = new Array("西双版纳","63","862");

subcat[124] = new Array("大理","63","863");

subcat[125] = new Array("杭州","64","864");

subcat[126] = new Array("嘉兴","64","865");

subcat[127] = new Array("宁波","64","866");

subcat[128] = new Array("温州","64","867");

subcat[129] = new Array("舟山","64","868");

subcat[130] = new Array("重庆","65","869");

subcat[131] = new Array("台北","66","870");

subcat[132] = new Array("香港","67","871");

subcat[133] = new Array("澳门","68","872");

subcat[134] = new Array("北京","36","878");

subcat[135] = new Array("义乌","64","879");

subcat[136] = new Array("毫州","35","881");

subcat[137] = new Array("巢湖","35","882");

subcat[138] = new Array("阜阳","35","883");

subcat[139] = new Array("淮南","35","884");

subcat[140] = new Array("九华山","35","885");

subcat[141] = new Array("马鞍山","35","886");

subcat[142] = new Array("宿州","35","887");

subcat[143] = new Array("天柱山","35","888");

subcat[144] = new Array("晋江","37","889");

subcat[145] = new Array("武夷山","37","890");

subcat[146] = new Array("连城","37","891");

subcat[147] = new Array("香格里拉","63","893");

subcat[148] = new Array("敦煌","38","894");

subcat[149] = new Array("张掖","38","895");

subcat[150] = new Array("陵水","42","896");

subcat[151] = new Array("琼海","42","897");

subcat[152] = new Array("开平","39","898");

subcat[153] = new Array("保定","43","899");

subcat[154] = new Array("北戴河","43","900");

subcat[155] = new Array("邯郸","43","901");

subcat[156] = new Array("衡水","43","902");

subcat[157] = new Array("廊坊","43","903");

subcat[158] = new Array("台山","39","904");

subcat[159] = new Array("邢台","43","905");

subcat[160] = new Array("鹤壁","44","908");

subcat[161] = new Array("南阳","44","909");

subcat[162] = new Array("濮阳","44","910");

subcat[163] = new Array("新乡","44","911");

subcat[164] = new Array("荆州","46","913");

subcat[165] = new Array("十堰","46","914");

subcat[166] = new Array("襄樊","46","915");

subcat[167] = new Array("仙桃","46","916");

subcat[168] = new Array("凤凰县","47","917");

subcat[169] = new Array("韶山","47","918");

subcat[170] = new Array("常熟","49","919");

subcat[171] = new Array("宜春","69","924");

subcat[172] = new Array("淮安","49","925");

subcat[173] = new Array("江都","49","926");

subcat[174] = new Array("江阴","49","927");

subcat[175] = new Array("金坛","49","928");

subcat[176] = new Array("昆山","49","929");

subcat[177] = new Array("溧阳","49","930");

subcat[178] = new Array("延吉","48","931");

subcat[179] = new Array("吉林","48","932");

subcat[180] = new Array("宿迁","49","933");

subcat[181] = new Array("太仓","49","934");

subcat[182] = new Array("锦州","51","935");

subcat[183] = new Array("泰州","49","936");

subcat[184] = new Array("同里","49","937");

subcat[185] = new Array("乌海","52","938");

subcat[186] = new Array("盐城","49","939");

subcat[187] = new Array("仪征","49","940");

subcat[188] = new Array("宜兴","49","941");

subcat[189] = new Array("滨州","55","942");

subcat[190] = new Array("德州","55","943");

subcat[191] = new Array("东营","55","944");

subcat[192] = new Array("肥城","55","945");

subcat[193] = new Array("菏泽","55","946");

subcat[194] = new Array("胶州","55","947");

subcat[195] = new Array("济宁","55","948");

subcat[196] = new Array("莱西","55","949");

subcat[197] = new Array("聊城","55","950");

subcat[198] = new Array("临沂","55","951");

subcat[199] = new Array("蓬莱","55","952");

subcat[200] = new Array("曲阜","55","953");

subcat[201] = new Array("泰安","55","954");

subcat[202] = new Array("威海","55","955");

subcat[203] = new Array("铜陵","35","956");

subcat[204] = new Array("周庄","49","957");

subcat[205] = new Array("张家港","49","958");

subcat[206] = new Array("库尔勒","62","959");

subcat[207] = new Array("阿坝州","59","960");

subcat[208] = new Array("德阳","59","961");

subcat[209] = new Array("都江堰","59","962");

subcat[210] = new Array("峨眉山","59","963");

subcat[211] = new Array("广元","59","965");

subcat[212] = new Array("九寨沟","59","966");

subcat[213] = new Array("乐山","59","967");

subcat[214] = new Array("泸州","59","968");

subcat[215] = new Array("南充","59","969");

subcat[216] = new Array("松潘","59","970");

subcat[217] = new Array("遂宁","59","971");

subcat[218] = new Array("自贡","59","973");

subcat[219] = new Array("晋中","56","974");

subcat[220] = new Array("平遥","56","975");

subcat[221] = new Array("忻州","56","976");

subcat[222] = new Array("运城","56","977");

subcat[223] = new Array("青海湖","54","979");

subcat[224] = new Array("格尔木","54","980");

subcat[225] = new Array("凯里","41","982");

subcat[226] = new Array("都匀","41","983");

subcat[227] = new Array("安顺","41","984");

subcat[228] = new Array("兴义","41","986");

subcat[229] = new Array("铜仁","41","987");

subcat[230] = new Array("长白山","48","989");

subcat[231] = new Array("湘西","47","990");

subcat[232] = new Array("衡山","47","992");

subcat[233] = new Array("长岛","55","993");

subcat[234] = new Array("嵩山","44","994");

subcat[235] = new Array("信阳","44","995");

subcat[236] = new Array("滁州","35","996");

subcat[237] = new Array("龙虎山","69","997");

subcat[238] = new Array("晋城","56","998");

subcat[239] = new Array("五台山","56","999");

subcat[240] = new Array("恩施","46","1000");

subcat[241] = new Array("高雄","66","1001");

subcat[242] = new Array("嘉义","66","1002");

subcat[243] = new Array("南投","66","1003");

subcat[244] = new Array("台东","66","1004");

subcat[245] = new Array("台南","66","1005");

subcat[246] = new Array("汉中","57","1006");

subcat[247] = new Array("榆林","57","1007");

subcat[248] = new Array("华山","57","1008");

subcat[249] = new Array("三清山","69","1009");

subcat[250] = new Array("台州","64","1011");

subcat[251] = new Array("万宁","42","1012");

subcat[252] = new Array("南昌","69","1013");

subcat[253] = new Array("赣州","69","1014");

subcat[254] = new Array("吉安","69","1015");

subcat[255] = new Array("萍乡","69","1016");

subcat[256] = new Array("景德镇","69","1017");

subcat[257] = new Array("井冈山","69","1018");

subcat[258] = new Array("上饶","69","1019");

subcat[259] = new Array("婺源","69","1021");

subcat[260] = new Array("绍兴","64","1022");

subcat[261] = new Array("湖州","64","1023");

subcat[262] = new Array("金华","64","1024");

subcat[263] = new Array("阳朔","40","1030");

subcat[264] = new Array("潍坊","55","1031");

subcat[265] = new Array("安吉","64","1032");

subcat[266] = new Array("慈溪","64","1033");

subcat[267] = new Array("德清","64","1034");

subcat[268] = new Array("奉化","64","1035");

subcat[269] = new Array("富阳","64","1036");

subcat[270] = new Array("海宁","64","1037");

subcat[271] = new Array("海盐","64","1038");

subcat[272] = new Array("横店","64","1039");

subcat[273] = new Array("建德","64","1040");

subcat[274] = new Array("嘉善","64","1041");

subcat[275] = new Array("缙云","64","1042");

subcat[276] = new Array("兰溪","64","1043");

subcat[277] = new Array("乐清","64","1044");

subcat[278] = new Array("临安","64","1045");

subcat[279] = new Array("临海","64","1046");

subcat[280] = new Array("丽水","64","1047");

subcat[281] = new Array("龙游","64","1048");

subcat[282] = new Array("宁海","64","1049");

subcat[283] = new Array("平湖","64","1050");

subcat[284] = new Array("千岛湖","64","1051");

subcat[285] = new Array("衢州","64","1052");

subcat[286] = new Array("瑞安","64","1053");

subcat[287] = new Array("上虞","64","1054");

subcat[288] = new Array("嵊州","64","1055");

subcat[289] = new Array("泰顺","64","1056");

subcat[290] = new Array("天台","64","1057");

subcat[291] = new Array("桐庐","64","1058");

subcat[292] = new Array("桐乡","64","1059");

subcat[293] = new Array("温岭","64","1060");

subcat[294] = new Array("武义","64","1062");

subcat[295] = new Array("象山","64","1063");

subcat[296] = new Array("新昌","64","1064");

subcat[297] = new Array("雁荡山","64","1065");

subcat[298] = new Array("永嘉","64","1066");

subcat[299] = new Array("永康","64","1067");

subcat[300] = new Array("余姚","64","1068");

subcat[301] = new Array("诸暨","64","1069");

subcat[302] = new Array("庐山","69","1070");

subcat[303] = new Array("钟祥","46","1071");

subcat[304] = new Array("喀什","62","1072");

subcat[305] = new Array("枣庄","55","1073");

subcat[306] = new Array("天水","38","1074");

subcat[307] = new Array("梧州","40","1075");

subcat[308] = new Array("钦州","40","1076");

subcat[309] = new Array("贵港","40","1077");

subcat[310] = new Array("伊宁","62","1079");

subcat[311] = new Array("福鼎","37","1080");

subcat[312] = new Array("宁德","37","1081");

subcat[313] = new Array("莆田","37","1082");

subcat[314] = new Array("三明","37","1083");

subcat[315] = new Array("石狮","37","1084");

subcat[316] = new Array("绥化","45","1085");

subcat[317] = new Array("保亭","42","1086");

subcat[318] = new Array("海螺沟","59","1089");

subcat[319] = new Array("江油","59","1090");

subcat[320] = new Array("内江","59","1091");

subcat[321] = new Array("攀枝花","59","1092");

subcat[322] = new Array("雅安","59","1093");

subcat[323] = new Array("沧州","43","1094");

subcat[324] = new Array("本溪","51","1095");

subcat[325] = new Array("盘锦","51","1096");

subcat[326] = new Array("铁岭","51","1097");

subcat[327] = new Array("营口","51","1098");

subcat[328] = new Array("莱芜","55","1099");

subcat[329] = new Array("日照","55","1100");

subcat[330] = new Array("寿光","55","1101");

subcat[331] = new Array("文登","55","1102");

subcat[332] = new Array("兖州","55","1103");

subcat[333] = new Array("临汾","56","1104");

subcat[334] = new Array("丹阳","49","1105");

subcat[335] = new Array("句容","49","1106");

subcat[336] = new Array("泗阳","49","1107");

subcat[337] = new Array("泰兴","49","1108");

subcat[338] = new Array("吴江","49","1109");

subcat[339] = new Array("新沂","49","1110");

subcat[340] = new Array("扬中","49","1113");

subcat[341] = new Array("海安","49","1115");

subcat[342] = new Array("胶南","55","1116");

subcat[343] = new Array("即墨","55","1117");

subcat[344] = new Array("巴彦淖尔","52","1118");

subcat[345] = new Array("满洲里","52","1119");

subcat[346] = new Array("防城港","40","1120");

subcat[347] = new Array("恩平","39","1122");

subcat[348] = new Array("阳泉","56","1123");

subcat[349] = new Array("迁安","43","1133");

subcat[350] = new Array("姜堰","49","1134");

subcat[351] = new Array("腾冲","63","1135");

subcat[352] = new Array("楚雄","63","1136");

subcat[353] = new Array("任丘","43","1137");

subcat[354] = new Array("南戴河","43","1138");

subcat[355] = new Array("张家口","43","1139");

subcat[356] = new Array("福清","37","1140");

subcat[357] = new Array("仙居","64","1142");

subcat[358] = new Array("龙口","55","1143");

subcat[359] = new Array("商丘","44","1144");

subcat[360] = new Array("浏阳","47","1145");

subcat[361] = new Array("通辽","52","1146");

subcat[362] = new Array("呼伦贝尔市","52","1147");

subcat[363] = new Array("安康","57","1148");

subcat[364] = new Array("安阳","44","1149");

subcat[365] = new Array("启东","49","1150");

subcat[366] = new Array("介休","56","1151");

subcat[367] = new Array("六安","35","1153");

subcat[368] = new Array("新余","69","1154");

subcat[369] = new Array("孝感","46","1155");

subcat[370] = new Array("邵阳","47","1156");

subcat[371] = new Array("益阳","47","1157");

subcat[372] = new Array("云浮","39","1158");

subcat[373] = new Array("高州","39","1159");

subcat[374] = new Array("亚布力","45","1160");

subcat[375] = new Array("抚顺","51","1161");

subcat[376] = new Array("漯河","44","1162");

subcat[377] = new Array("焦作","44","1163");

subcat[378] = new Array("许昌","44","1164");

subcat[379] = new Array("平顶山","44","1165");

subcat[380] = new Array("驻马店","44","1166");

subcat[381] = new Array("亳州","35","1237");

subcat[382] = new Array("池州","35","1238");

subcat[383] = new Array("宣城","35","1239");

subcat[384] = new Array("白银","38","1240");

subcat[385] = new Array("百色","40","1241");

subcat[386] = new Array("大新县","40","1242");

subcat[387] = new Array("龙胜","40","1243");

subcat[388] = new Array("五指山","42","1244");

subcat[389] = new Array("昌黎","43","1245");

subcat[390] = new Array("丰宁","43","1246");

subcat[391] = new Array("滦平","43","1247");

subcat[392] = new Array("三河市","43","1248");

subcat[393] = new Array("唐海","43","1249");

subcat[394] = new Array("香河县","43","1250");

subcat[395] = new Array("鹤岗","45","1251");

subcat[396] = new Array("鸡西","45","1252");

subcat[397] = new Array("漠河","45","1253");

subcat[398] = new Array("绥芬河","45","1254");

subcat[399] = new Array("登封","44","1255");

subcat[400] = new Array("济源","44","1256");

subcat[401] = new Array("新密","44","1257");

subcat[402] = new Array("大冶","46","1259");

subcat[403] = new Array("随州","46","1260");

subcat[404] = new Array("武穴","46","1261");

subcat[405] = new Array("咸宁","46","1262");

subcat[406] = new Array("吉首","47","1263");

subcat[407] = new Array("宝应","49","1264");

subcat[408] = new Array("高邮","49","1265");

subcat[409] = new Array("靖江","49","1266");

subcat[410] = new Array("如皋","49","1267");

subcat[411] = new Array("通州","49","1268");

subcat[412] = new Array("德兴","69","1269");

subcat[413] = new Array("鹰潭","69","1270");

subcat[414] = new Array("安图","48","1271");

subcat[415] = new Array("白山","48","1272");

subcat[416] = new Array("珲春","48","1273");

subcat[417] = new Array("通化","48","1274");

subcat[418] = new Array("海城","51","1275");

subcat[419] = new Array("辽阳","51","1276");

subcat[420] = new Array("兴城","51","1277");

subcat[421] = new Array("博兴","55","1279");

subcat[422] = new Array("海阳","55","1281");

subcat[423] = new Array("平度","55","1282");

subcat[424] = new Array("平邑","55","1283");

subcat[425] = new Array("青州","55","1284");

subcat[426] = new Array("荣成","55","1285");

subcat[427] = new Array("夏津","55","1286");

subcat[428] = new Array("阳城县","56","1287");

subcat[429] = new Array("神木县","57","1288");

subcat[430] = new Array("北川县","59","1289");

subcat[431] = new Array("稻城","59","1290");

subcat[432] = new Array("大英","59","1291");

subcat[433] = new Array("达州","59","1292");

subcat[434] = new Array("甘孜州","59","1293");

subcat[435] = new Array("康定","59","1295");

subcat[436] = new Array("阆中","59","1296");

subcat[437] = new Array("凉山州","59","1297");

subcat[438] = new Array("眉山","59","1298");

subcat[439] = new Array("新竹","66","1299");

subcat[440] = new Array("垦丁","66","1300");

subcat[441] = new Array("台中","66","1301");

subcat[442] = new Array("布尔津","62","1302");

subcat[443] = new Array("喀纳斯","62","1303");

subcat[444] = new Array("日喀则","61","1304");

subcat[445] = new Array("红河","63","1305");

subcat[446] = new Array("平阳","64","1306");

subcat[447] = new Array("浦江","64","1307");

subcat[448] = new Array("东台","49","1308");

subcat[449] = new Array("荔波","41","1309");

subcat[450] = new Array("海门","49","1310");

subcat[451] = new Array("磐安","64","1311");

subcat[452] = new Array("常山","64","1312");

subcat[453] = new Array("曲靖","63","1313");

subcat[454] = new Array("娄底","47","1315");

subcat[455] = new Array("铜川","57","1316");

subcat[456] = new Array("荥阳","44","1317");

subcat[457] = new Array("佛坪县","57","1319");

subcat[458] = new Array("锡林浩特","52","1320");

subcat[459] = new Array("保山","63","1321");

subcat[460] = new Array("邵通","63","1322");

subcat[461] = new Array("潞西","63","1323");

subcat[462] = new Array("榆林","57","1324");

subcat[463] = new Array("朝阳","51","1325");

subcat[464] = new Array("长治","56","1326");

subcat[465] = new Array("庆阳","38","1327");

subcat[466] = new Array("朔州","56","1328");

subcat[467] = new Array("淮北","35","1329");

subcat[468] = new Array("临沧","63","1331");

subcat[469] = new Array("普洱","63","1332");

subcat[470] = new Array("昭通","63","1333");

subcat[471] = new Array("应城","46","1334");

subcat[472] = new Array("资兴","47","1335");

subcat[473] = new Array("龙泉","64","1336");

		
onecount=474;

	function changeclass(locationid)
    {
	    
	var obj=document.form1;
    obj.city.length = 1; 
	obj.region.length = 1;
	obj.borough_id.length = 1;

    var locationid=locationid;
    var i;
    for (i=0;i < onecount; i++)
        {
            if (subcat[i][1] == locationid)
            { 
             obj.city.options[obj.city.length] = new Option(subcat[i][0], subcat[i][2]);
            }        
        }
        
    }   
</SCRIPT>
<!--select 改变类别结束-->
<!--select 改变小类别开始-->

<SCRIPT language="JavaScript">
var onecount1;
onecount1=0;
subcat1 = new Array();

subcat1[0] = new Array("环市东路、先烈路附近","744","7");

subcat1[1] = new Array("天河体育中心、火车东站","744","9");

subcat1[2] = new Array("沙面、上下九路步行街","744","10");

subcat1[3] = new Array("芳村、花地湾地区","744","11");

subcat1[4] = new Array("机场路、体育馆、白云山","744","12");

subcat1[5] = new Array("天安门、王府井地区","878","24");

subcat1[6] = new Array("东二环工人体育场地区","878","25");

subcat1[7] = new Array("北京国际展览中心地区","878","26");

subcat1[8] = new Array("亚运村、奥运村商圈","878","27");

subcat1[9] = new Array("国贸商圈","878","28");

subcat1[10] = new Array("北京西客站地区","878","29");

subcat1[11] = new Array("北京站、建国门地区","878","30");

subcat1[12] = new Array("燕莎商业区","878","32");

subcat1[13] = new Array("西直门北京展览馆地区","878","33");

subcat1[14] = new Array("西单、金融街地区","878","34");

subcat1[15] = new Array("首都国际机场附近","878","35");

subcat1[16] = new Array("天坛地区","878","36");

subcat1[17] = new Array("前门、崇文门商贸地区","878","37");

subcat1[18] = new Array("其他地区","878","38");

subcat1[19] = new Array("北京路步行街、海珠广场","744","39");

subcat1[20] = new Array("虹口、杨浦地区","848","40");

subcat1[21] = new Array("浦东新区","848","41");

subcat1[22] = new Array("虹桥地区","848","42");

subcat1[23] = new Array("人民广场附近","848","43");

subcat1[24] = new Array("徐家汇地区","848","44");

subcat1[25] = new Array("淮海路地区","848","45");

subcat1[26] = new Array("静安寺地区","848","46");

subcat1[27] = new Array("新客站地区","848","47");

subcat1[28] = new Array("外滩附近","848","48");

subcat1[29] = new Array("其它地区","848","49");

subcat1[30] = new Array("番禺区、洛溪新城、南沙","744","50");

subcat1[31] = new Array("罗湖地区","755","51");

subcat1[32] = new Array("华侨城地区","755","52");

subcat1[33] = new Array("华强北地区","755","53");

subcat1[34] = new Array("蛇口（南山）地区","755","54");

subcat1[35] = new Array("高交会.皇岗口岸地区","755","55");

subcat1[36] = new Array("其他地区","755","56");

subcat1[37] = new Array("五羊新城、珠江新城附近","744","57");

subcat1[38] = new Array("珠江南（河南）地区","744","58");

subcat1[39] = new Array("花都区、新白云国际机场","744","59");

subcat1[40] = new Array("火车站、广交会流花展馆","744","60");

subcat1[41] = new Array("城东地区","807","61");

subcat1[42] = new Array("山西路地区","807","62");

subcat1[43] = new Array("火车站地区","807","63");

subcat1[44] = new Array("新街口地区（市中心）","807","64");

subcat1[45] = new Array("夫子庙地区","807","65");

subcat1[46] = new Array("中山陵地区","807","66");

subcat1[47] = new Array("鼓楼地区","807","67");

subcat1[48] = new Array("其它地区","807","68");

subcat1[49] = new Array("江宁开发区","807","69");

subcat1[50] = new Array("滨江地区","864","72");

subcat1[51] = new Array("火车城站","864","73");

subcat1[52] = new Array("文教区","864","74");

subcat1[53] = new Array("西湖景区","864","75");

subcat1[54] = new Array("武林广场附近(市中心)","864","76");

subcat1[55] = new Array("火车东站","864","77");

subcat1[56] = new Array("萧山区","864","78");

subcat1[57] = new Array("黄龙体育中心","864","79");

subcat1[58] = new Array("其它地区","864","80");

subcat1[59] = new Array("春熙路商业区","849","81");

subcat1[60] = new Array("骡马市商业区","849","82");

subcat1[61] = new Array("市中心文化区","849","83");

subcat1[62] = new Array("火车北站地区","849","84");

subcat1[63] = new Array("其它地区","849","85");

subcat1[64] = new Array("市中心地区","844","86");

subcat1[65] = new Array("西部地区","844","87");

subcat1[66] = new Array("南部地区","844","88");

subcat1[67] = new Array("东部地区","844","89");

subcat1[68] = new Array("北部地区","844","90");

subcat1[69] = new Array("其它地区","844","91");

subcat1[70] = new Array("亚龙湾","772","92");

subcat1[71] = new Array("大东海","772","93");

subcat1[72] = new Array("三亚湾","772","94");

subcat1[73] = new Array("市区","772","95");

subcat1[74] = new Array("其它地区","772","96");

subcat1[75] = new Array("开福寺地区","794","97");

subcat1[76] = new Array("五一广场地区(市中心)","794","98");

subcat1[77] = new Array("贺龙体育中心地区","794","99");

subcat1[78] = new Array("文教区","794","100");

subcat1[79] = new Array("火车站地区","794","101");

subcat1[80] = new Array("其它地区","794","102");

subcat1[81] = new Array("汉口商业金融区","789","103");

subcat1[82] = new Array("汉口火车站地区","789","104");

subcat1[83] = new Array("武昌火车站地区","789","105");

subcat1[84] = new Array("洪山广场、东湖旅游区","789","106");

subcat1[85] = new Array("东湖高新技术开发区","789","107");

subcat1[86] = new Array("汉阳地区","789","108");

subcat1[87] = new Array("其它地区","789","109");

subcat1[88] = new Array("江东商业区","866","110");

subcat1[89] = new Array("海曙商业区(市中心)","866","111");

subcat1[90] = new Array("江北商业区","866","112");

subcat1[91] = new Array("北仑港区","866","113");

subcat1[92] = new Array("东钱湖风景区","866","114");

subcat1[93] = new Array("其他地区","866","115");

subcat1[94] = new Array("滨江道、小白楼商业区","854","116");

subcat1[95] = new Array("河西区","854","118");

subcat1[96] = new Array("长虹公园地区","854","119");

subcat1[97] = new Array("望海楼、古文化街地区","854","120");

subcat1[98] = new Array("红桥区","854","121");

subcat1[99] = new Array("河东区","854","122");

subcat1[100] = new Array("其它地区","854","123");

subcat1[101] = new Array("市中心地区","867","124");

subcat1[102] = new Array("温州经济开发区","867","125");

subcat1[103] = new Array("火车站地区","867","126");

subcat1[104] = new Array("其它地区","867","127");

subcat1[105] = new Array("城隍庙小商品区","727","128");

subcat1[106] = new Array("淮河路商业区(市中心)","727","129");

subcat1[107] = new Array("三孝口商业区","727","130");

subcat1[108] = new Array("合肥经济技术开发区","727","131");

subcat1[109] = new Array("包河公园商业区","727","132");

subcat1[110] = new Array("普陀山","868","134");

subcat1[111] = new Array("沈家门(市中心)","868","135");

subcat1[112] = new Array("朱家尖","868","136");

subcat1[113] = new Array("其它地区","868","137");

subcat1[114] = new Array("国际商贸城及东阳市区域","879","138");

subcat1[115] = new Array("市中心地区","879","139");

subcat1[116] = new Array("经济开发区","879","140");

subcat1[117] = new Array("解放碑地区(市中心)","869","141");

subcat1[118] = new Array("高新技术开发区","869","142");

subcat1[119] = new Array("人民广场地区","869","143");

subcat1[120] = new Array("沙坪坝地区","869","144");

subcat1[121] = new Array("长江南岸区","869","145");

subcat1[122] = new Array("其它地区","869","146");

subcat1[123] = new Array("西湖公园附近","732","147");

subcat1[124] = new Array("五一广场附近","732","148");

subcat1[125] = new Array("温泉公园附近(市中心)","732","149");

subcat1[126] = new Array("火车站地区","732","150");

subcat1[127] = new Array("城东地区","732","151");

subcat1[128] = new Array("其它地区","732","152");

subcat1[129] = new Array("温泉景区","728","153");

subcat1[130] = new Array("市区(屯溪区)","728","154");

subcat1[131] = new Array("北海风景区","728","155");

subcat1[132] = new Array("白云景区","728","156");

subcat1[133] = new Array("玉屏景区","728","157");

subcat1[134] = new Array("其它地区","728","158");

subcat1[135] = new Array("白鹭洲风景区","735","159");

subcat1[136] = new Array("鼓浪屿风景区","735","160");

subcat1[137] = new Array("中山路、轮渡区","735","161");

subcat1[138] = new Array("湖里工业园区","735","162");

subcat1[139] = new Array("松柏小区(新市中心)","735","163");

subcat1[140] = new Array("火车站附近","735","164");

subcat1[141] = new Array("其他地区","735","165");

subcat1[142] = new Array("东莞市区","742","166");

subcat1[143] = new Array("虎门镇","742","167");

subcat1[144] = new Array("塘厦镇","742","168");

subcat1[145] = new Array("洪梅镇","742","169");

subcat1[146] = new Array("长安镇","742","170");

subcat1[147] = new Array("厚街镇","742","171");

subcat1[148] = new Array("常平镇","742","172");

subcat1[149] = new Array("樟木头镇","742","173");

subcat1[150] = new Array("黄江镇","742","174");

subcat1[151] = new Array("桥头镇","742","175");

subcat1[152] = new Array("高埗镇","742","176");

subcat1[153] = new Array("凤岗镇","742","177");

subcat1[154] = new Array("茶山镇","742","178");

subcat1[155] = new Array("石龙镇","742","179");

subcat1[156] = new Array("大岭山镇","742","180");

subcat1[157] = new Array("火车站地区","765","181");

subcat1[158] = new Array("南湖开发区","765","182");

subcat1[159] = new Array("市中心商业区","765","183");

subcat1[160] = new Array("其它地区","765","184");

subcat1[161] = new Array("市中心湖景地区","762","185");

subcat1[162] = new Array("市中心江景地区","762","186");

subcat1[163] = new Array("国展中心地区","762","187");

subcat1[164] = new Array("火车站地区","762","188");

subcat1[165] = new Array("其他地区","762","189");

subcat1[166] = new Array("唐家地区","761","190");

subcat1[167] = new Array("拱北地区","761","191");

subcat1[168] = new Array("吉大地区","761","192");

subcat1[169] = new Array("香洲地区","761","193");

subcat1[170] = new Array("其他地区","761","196");

subcat1[171] = new Array("翠湖地区","860","199");

subcat1[172] = new Array("市中心商业地区","860","200");

subcat1[173] = new Array("政治文化地区","860","201");

subcat1[174] = new Array("火车站地区","860","202");

subcat1[175] = new Array("其它地区","860","203");

subcat1[176] = new Array("火车站","838","204");

subcat1[177] = new Array("植物园","838","205");

subcat1[178] = new Array("泉城广场商业区","838","206");

subcat1[179] = new Array("高新技术开发区","838","207");

subcat1[180] = new Array("工业园区","838","208");

subcat1[181] = new Array("其他地区","838","209");

subcat1[182] = new Array("西区","737","214");

subcat1[183] = new Array("市中心商业区","737","215");

subcat1[184] = new Array("七里河体育场地区","737","216");

subcat1[185] = new Array("其他地区","737","217");

subcat1[186] = new Array("商业金融中心(市中心)","782","218");

subcat1[187] = new Array("文化教育区","782","219");

subcat1[188] = new Array("老工业基地","782","220");

subcat1[189] = new Array("高新技术开发区","782","221");

subcat1[190] = new Array("其他地区","782","223");

subcat1[191] = new Array("黔灵公园地区","767","225");

subcat1[192] = new Array("市中心地区","767","226");

subcat1[193] = new Array("火车站地区","767","227");

subcat1[194] = new Array("其他地区","767","228");

subcat1[195] = new Array("国际机场附近","871","229");

subcat1[196] = new Array("新界","871","230");

subcat1[197] = new Array("旺角、油麻地","871","231");

subcat1[198] = new Array("尖沙咀、红磡","871","232");

subcat1[199] = new Array("中环、金钟","871","233");

subcat1[200] = new Array("湾仔、铜锣湾","871","234");

subcat1[201] = new Array("北角、鰂鱼涌","871","235");

subcat1[202] = new Array("其他地区","871","236");

subcat1[203] = new Array("火车站地区","752","237");

subcat1[204] = new Array("市中心区域","752","238");

subcat1[205] = new Array("高新科技开发区","752","239");

subcat1[206] = new Array("其他地区","741","240");

subcat1[207] = new Array("顺德区","743","242");

subcat1[208] = new Array("禅城区","743","243");

subcat1[209] = new Array("南海区","743","244");

subcat1[210] = new Array("高明区","743","245");

subcat1[211] = new Array("三水区","743","246");

subcat1[212] = new Array("商业金融中心","778","251");

subcat1[213] = new Array("老工业基地","778","252");

subcat1[214] = new Array("火车站地区","778","253");

subcat1[215] = new Array("郑东新区","778","254");

subcat1[216] = new Array("其他地区","778","255");

subcat1[217] = new Array("老城区","780","256");

subcat1[218] = new Array("西工区","780","257");

subcat1[219] = new Array("其他地区","780","258");

subcat1[220] = new Array("市中心区域","808","259");

subcat1[221] = new Array("常州新区","808","260");

subcat1[222] = new Array("火车站地区","808","261");

subcat1[223] = new Array("其他地区","808","262");

subcat1[224] = new Array("工业区","804","263");

subcat1[225] = new Array("商业金融中心","804","264");

subcat1[226] = new Array("文化教育区","804","265");

subcat1[227] = new Array("长春经济技术开发区","804","266");

subcat1[228] = new Array("其他地区","804","267");

subcat1[229] = new Array("商业金融中心","820","268");

subcat1[230] = new Array("文教区","820","269");

subcat1[231] = new Array("老工业区","820","270");

subcat1[232] = new Array("道义开发区","820","271");

subcat1[233] = new Array("其他地区","820","272");

subcat1[234] = new Array("中央公园地区","810","273");

subcat1[235] = new Array("火车站地区","810","274");

subcat1[236] = new Array("苏州工业园区","810","275");

subcat1[237] = new Array("苏州新区","810","276");

subcat1[238] = new Array("观前街地区(市中心)","810","277");

subcat1[239] = new Array("盘门地区","810","278");

subcat1[240] = new Array("其他地区","810","279");

subcat1[241] = new Array("商业金融中心区","821","280");

subcat1[242] = new Array("海滨风景旅游度假区","821","281");

subcat1[243] = new Array("大连开发区、金石滩国家旅游度假区","821","282");

subcat1[244] = new Array("沙河口、甘井子地区","821","283");

subcat1[245] = new Array("其他地区","821","284");

subcat1[246] = new Array("三阳广场(市中心)","812","287");

subcat1[247] = new Array("火车站附近","812","288");

subcat1[248] = new Array("五爱广场","812","289");

subcat1[249] = new Array("太湖风景区","812","290");

subcat1[250] = new Array("马山风景区","812","291");

subcat1[251] = new Array("其他地区","812","292");

subcat1[252] = new Array("黄岛经济技术开发区","839","293");

subcat1[253] = new Array("半岛商务中心（市政府）、奥帆中心区","839","294");

subcat1[254] = new Array("第一海滨浴场","839","295");

subcat1[255] = new Array("石老人风景区","839","296");

subcat1[256] = new Array("火车站、栈桥区","839","298");

subcat1[257] = new Array("四方长途汽车站区","839","299");

subcat1[258] = new Array("市中心区域","814","303");

subcat1[259] = new Array("扬州新区","814","304");

subcat1[260] = new Array("瘦西湖风景区","814","305");

subcat1[261] = new Array("其他地区","814","306");

subcat1[262] = new Array("第一海水浴场","840","307");

subcat1[263] = new Array("第二海水浴场","840","308");

subcat1[264] = new Array("市中心地区","840","309");

subcat1[265] = new Array("其他地区","840","310");

subcat1[266] = new Array("市中心地区","857","311");

subcat1[267] = new Array("开发区","857","312");

subcat1[268] = new Array("国际博览中心地区","857","313");

subcat1[269] = new Array("其他地区","857","314");

subcat1[270] = new Array("府西街地区","842","315");

subcat1[271] = new Array("高新技术产业开发区","842","316");

subcat1[272] = new Array("迎泽大街商业区","842","317");

subcat1[273] = new Array("万柏林地区","842","318");

subcat1[274] = new Array("其他地区","842","319");

subcat1[275] = new Array("其他地区","839","320");

subcat1[276] = new Array("琶洲国际会展中心附近","744","322");

subcat1[277] = new Array("东圃、经济开发区","744","323");

subcat1[278] = new Array("四川北路商业区","848","326");

subcat1[279] = new Array("上海火车南站地区","848","327");

subcat1[280] = new Array("浦东新国际博览中心","848","328");

subcat1[281] = new Array("浦东外高桥地区","848","329");

subcat1[282] = new Array("上海周边度假区","848","330");

subcat1[283] = new Array("豫园、大兴街商业区","848","331");

subcat1[284] = new Array("浦东张江地区","848","332");

subcat1[285] = new Array("浦东金桥地区","848","333");

subcat1[286] = new Array("五角场商业区","848","334");

subcat1[287] = new Array("北外滩地区","848","335");

subcat1[288] = new Array("市中心地区","1022","337");

subcat1[289] = new Array("火车站地区","1022","338");

subcat1[290] = new Array("城南新区","1022","339");

subcat1[291] = new Array("柯桥","1022","340");

subcat1[292] = new Array("绍兴经济开发区","1022","341");

subcat1[293] = new Array("其他地区","1022","342");

subcat1[294] = new Array("椒江城区","1011","343");

subcat1[295] = new Array("路桥城区","1011","344");

subcat1[296] = new Array("黄岩城区","1011","345");

subcat1[297] = new Array("其他地区","1011","346");

subcat1[298] = new Array("浦东陆家嘴金融贸易区","848","347");

subcat1[299] = new Array("浦东塘桥、昌里商业区","848","348");

subcat1[300] = new Array("江湾、大柏树地区","848","349");

subcat1[301] = new Array("浦东机场附近","848","350");

subcat1[302] = new Array("曹杨、真如地区","848","351");

subcat1[303] = new Array("漕河泾开发区","848","352");

subcat1[304] = new Array("沪太、彭浦地区","848","353");

subcat1[305] = new Array("小榄镇","760","354");

subcat1[306] = new Array("东区","760","355");

subcat1[307] = new Array("古镇","760","356");

subcat1[308] = new Array("三角镇","760","357");

subcat1[309] = new Array("西区","760","358");

subcat1[310] = new Array("三乡镇","760","360");

subcat1[311] = new Array("石岐镇","760","363");

subcat1[312] = new Array("其他地区","760","364");

subcat1[313] = new Array("江北地区","869","365");

subcat1[314] = new Array("盐田（大、小梅沙）","755","369");

subcat1[315] = new Array("深圳周边度假区","755","370");

subcat1[316] = new Array("海城区","763","371");

subcat1[317] = new Array("银海区","763","372");

subcat1[318] = new Array("西环","871","373");

subcat1[319] = new Array("广州周边度假区","744","374");

subcat1[320] = new Array("市北中央商务区","839","375");

subcat1[321] = new Array("山下","728","382");

subcat1[322] = new Array("黟县","728","383");

subcat1[323] = new Array("黄山区","728","384");

subcat1[324] = new Array("大朗镇","742","385");

subcat1[325] = new Array("其他地区","742","386");

subcat1[326] = new Array("博罗县","746","391");

subcat1[327] = new Array("大亚湾","746","392");

subcat1[328] = new Array("惠城区","746","393");

subcat1[329] = new Array("惠东县","746","394");

subcat1[330] = new Array("惠阳区","746","395");

subcat1[331] = new Array("龙门县","746","396");

subcat1[332] = new Array("蓬江区","747","398");

subcat1[333] = new Array("石碣镇","742","399");

subcat1[334] = new Array("大东区","820","400");

subcat1[335] = new Array("沟口","966","404");

subcat1[336] = new Array("甘海子","966","405");

subcat1[337] = new Array("其他地区","966","406");

subcat1[338] = new Array("西海岸 ","771","413");

subcat1[339] = new Array("端州区","759","414");

subcat1[340] = new Array("柳南区","764","424");

subcat1[341] = new Array("自治区政府区域","765","425");

subcat1[342] = new Array("国际会展中心","765","428");

subcat1[343] = new Array("龙胜地区","762","432");

subcat1[344] = new Array("北京周边度假区","878","433");

subcat1[345] = new Array("市区","771","434");

subcat1[346] = new Array("其他地区","771","435");

subcat1[347] = new Array("海甸岛","771","436");

subcat1[348] = new Array("火车站区域","730","444");

subcat1[349] = new Array("镜湖广场","730","445");

subcat1[350] = new Array("其他地区","730","446");

subcat1[351] = new Array("大研古镇内","861","447");

subcat1[352] = new Array("大研古镇外","861","448");

subcat1[353] = new Array("束河古镇","861","449");

subcat1[354] = new Array("其他地区","861","450");

subcat1[355] = new Array("八一广场地区(市中心)","1013","452");

subcat1[356] = new Array("火车站地区","1013","453");

subcat1[357] = new Array("其他地区","1013","454");

subcat1[358] = new Array("度假区","890","455");

subcat1[359] = new Array("市区","890","456");

subcat1[360] = new Array("莰坪镇","1018","457");

subcat1[361] = new Array("珠山区","1017","458");

subcat1[362] = new Array("昌江区","1017","459");

subcat1[363] = new Array("亦庄地区","878","460");

subcat1[364] = new Array("马甸地区","878","461");

subcat1[365] = new Array("后海地区","878","462");

subcat1[366] = new Array("望京地区","878","463");

subcat1[367] = new Array("劲松、潘家园地区","878","464");

subcat1[368] = new Array("上地、中关村地区","878","465");

subcat1[369] = new Array("公主坟、万寿路商贸区","878","466");

subcat1[370] = new Array("永定门、南站地区","878","467");

subcat1[371] = new Array("山上","963","468");

subcat1[372] = new Array("山脚","963","469");

subcat1[373] = new Array("市区","963","470");

subcat1[374] = new Array("新会区","747","471");

subcat1[375] = new Array("北新区","747","472");

subcat1[376] = new Array("其他地区","747","473");

subcat1[377] = new Array("市中心地区","929","475");

subcat1[378] = new Array("火车站地区","929","476");

subcat1[379] = new Array("玉山镇","929","477");

subcat1[380] = new Array("张浦镇","929","478");

subcat1[381] = new Array("正仪镇","929","479");

subcat1[382] = new Array("千灯镇","929","480");

subcat1[383] = new Array("巴城镇","929","481");

subcat1[384] = new Array("周市镇","929","482");

subcat1[385] = new Array("花桥镇","929","483");

subcat1[386] = new Array("昆山经济技术开发区","929","484");

subcat1[387] = new Array("市中心","955","485");

subcat1[388] = new Array("西海岸","955","486");

subcat1[389] = new Array("东海岸","955","488");

subcat1[390] = new Array("鼎湖区","759","489");

subcat1[391] = new Array("澳门半岛","872","490");

subcat1[392] = new Array("氹仔","872","491");

subcat1[393] = new Array("路氹","872","492");

subcat1[394] = new Array("路环","872","493");

subcat1[395] = new Array("阳朔地区","762","494");

subcat1[396] = new Array("汤山温泉度假区","807","495");

subcat1[397] = new Array("机场附近","735","496");

subcat1[398] = new Array("岱山","868","497");

subcat1[399] = new Array("桃花岛","868","498");

subcat1[400] = new Array("嵊泗列岛","868","499");

subcat1[401] = new Array("舟山市(定海)","868","500");

subcat1[402] = new Array("青山湖风景区","1013","501");

subcat1[403] = new Array("滕王阁风景区","1013","502");

subcat1[404] = new Array("抚河公园风景区","1013","503");

subcat1[405] = new Array("沙溪镇","760","504");

subcat1[406] = new Array("宝安国际机场附近","755","505");

subcat1[407] = new Array("滨海国际机场","854","506");

subcat1[408] = new Array("双流国际机场","849","507");

subcat1[409] = new Array("江北国际机场","869","508");

subcat1[410] = new Array("天河机场附近","789","509");

subcat1[411] = new Array("流亭国际机场附近","839","510");

subcat1[412] = new Array("市中心区域","811","511");

subcat1[413] = new Array("城东南","811","512");

subcat1[414] = new Array("市中心地区","919","513");

subcat1[415] = new Array("沙家浜风景区","919","514");

subcat1[416] = new Array("虞山尚湖风景区","919","515");

subcat1[417] = new Array("农林下路、王府井附近","744","516");

subcat1[418] = new Array("天河公园、棠下附近","744","517");

subcat1[419] = new Array("中堂镇","742","518");

subcat1[420] = new Array("企石镇","742","519");

subcat1[421] = new Array("横沥镇","742","520");

subcat1[422] = new Array("石排镇","742","521");

subcat1[423] = new Array("清溪镇","742","522");

subcat1[424] = new Array("谢岗镇","742","523");

subcat1[425] = new Array("沙田镇","742","524");

subcat1[426] = new Array("麻涌镇","742","527");

subcat1[427] = new Array("望牛墩镇","742","528");

subcat1[428] = new Array("东坑镇","742","529");

subcat1[429] = new Array("寮步镇","742","532");

subcat1[430] = new Array("道滘镇","742","533");

subcat1[431] = new Array("罗湖火车站附近","755","534");

subcat1[432] = new Array("火车站附近","844","535");

subcat1[433] = new Array("高新开发区","844","536");

subcat1[434] = new Array("曲江旅游度假区","844","537");

subcat1[435] = new Array("火车站附近","820","538");

subcat1[436] = new Array("周水子国际机场附近","821","539");

subcat1[437] = new Array("南城区","794","540");

subcat1[438] = new Array("台东商圈特色旅游区","839","541");

subcat1[439] = new Array("火车站附近","866","542");

subcat1[440] = new Array("机场附近","761","543");

subcat1[441] = new Array("海边地区","761","544");

subcat1[442] = new Array("前山地区","761","545");

subcat1[443] = new Array("南屏镇地区","761","546");

subcat1[444] = new Array("火车站地区","815","547");

subcat1[445] = new Array("市中心地区","815","548");

subcat1[446] = new Array("江北商业区域","1024","549");

subcat1[447] = new Array("江南商业区域","1024","550");

subcat1[448] = new Array("市中心","832","551");

subcat1[449] = new Array("西部地区","832","552");

subcat1[450] = new Array("东部地区","832","553");

subcat1[451] = new Array("市中心区","824","554");

subcat1[452] = new Array("东区","824","555");

subcat1[453] = new Array("南区","824","556");

subcat1[454] = new Array("西区","824","557");

subcat1[455] = new Array("北区","824","558");

subcat1[456] = new Array("山上","1070","559");

subcat1[457] = new Array("南山风景区","815","560");

subcat1[458] = new Array("天河电脑城、石牌岗顶","744","561");

subcat1[459] = new Array("江南大道、中山大学附近","744","562");

subcat1[460] = new Array("迪士尼景区","871","563");

subcat1[461] = new Array("市中心商业区","865","564");

subcat1[462] = new Array("江南摩尔区域","865","565");

subcat1[463] = new Array("南湖景区","865","566");

subcat1[464] = new Array("其他地区","865","567");

subcat1[465] = new Array("云龙湖景区","813","568");

subcat1[466] = new Array("商业金融（市中心）区","813","569");

subcat1[467] = new Array("市内","894","570");

subcat1[468] = new Array("市外","894","571");

subcat1[469] = new Array("长安公园、省博物馆地区","774","572");

subcat1[470] = new Array("城西区","774","573");

subcat1[471] = new Array("火车站地区","774","574");

subcat1[472] = new Array("其他地区","774","575");

subcat1[473] = new Array("经济开发区","780","580");

subcat1[474] = new Array("市中心区域","780","581");

subcat1[475] = new Array("市区","803","582");

subcat1[476] = new Array("索溪峪","803","583");

subcat1[477] = new Array("商业金融中心区","809","584");

subcat1[478] = new Array("海滨度假区","809","585");

subcat1[479] = new Array("山脚","954","587");

subcat1[480] = new Array("市内","954","588");

subcat1[481] = new Array("市中区","1073","589");

subcat1[482] = new Array("沈家门","868","590");

subcat1[483] = new Array("昌化镇","1045","591");

subcat1[484] = new Array("山下","1070","592");

subcat1[485] = new Array("太湖风景区","810","594");

subcat1[486] = new Array("外商国际俱","727","595");

subcat1[487] = new Array("一品天下商业圈","849","597");

subcat1[488] = new Array("太升路商业圈","849","598");

subcat1[489] = new Array("水碾河商业圈","849","599");

subcat1[490] = new Array("世纪城新会展商业圈","849","600");

subcat1[491] = new Array("李沧商圈","839","602");

subcat1[492] = new Array("人民商场商业区","838","603");

subcat1[493] = new Array("舜耕国际会展中心区","838","604");

subcat1[494] = new Array("长途汽车总站区","838","605");

subcat1[495] = new Array("洪楼广场区","838","606");

subcat1[496] = new Array("府东商业区","842","607");

subcat1[497] = new Array("曲江会展区","844","608");

subcat1[498] = new Array("河西奥体中心地区","807","609");

subcat1[499] = new Array("汽车西站区","812","610");

subcat1[500] = new Array("石路商业区","810","611");

subcat1[501] = new Array("十全街地区","810","612");

subcat1[502] = new Array("汤口","728","613");

subcat1[503] = new Array("经济技术开发区","730","614");

subcat1[504] = new Array("南门口地区","1014","615");

subcat1[505] = new Array("紫阳镇","1019","616");

subcat1[506] = new Array("上海火车站地区","848","617");

subcat1[507] = new Array("世博园区","848","618");

subcat1[508] = new Array("虹桥机场区域","848","619");

subcat1[509] = new Array("中南商业圈","789","620");

subcat1[510] = new Array("光谷科技中心","789","621");

subcat1[511] = new Array("青山工业区","789","622");

subcat1[512] = new Array("森林公园","803","623");

subcat1[513] = new Array("经济技术开发区","794","624");

subcat1[514] = new Array("古城内","917","625");

subcat1[515] = new Array("古城外","917","626");

subcat1[516] = new Array("黄龙","966","627");

subcat1[517] = new Array("川主寺","966","628");

subcat1[518] = new Array("宝安区","755","629");

subcat1[519] = new Array("龙岗区","755","630");

subcat1[520] = new Array("西南地区","762","631");

subcat1[521] = new Array("银海地区","762","632");

subcat1[522] = new Array("泸沽湖","861","633");

subcat1[523] = new Array("周边地区","860","634");

subcat1[524] = new Array("滨海新区","854","635");

subcat1[525] = new Array("华苑地区","854","636");

subcat1[526] = new Array("国际展览中心地区","854","637");

subcat1[527] = new Array("中部","855","638");

subcat1[528] = new Array("南田温泉","772","639");

subcat1[529] = new Array("高新开发区","812","640");

subcat1[530] = new Array("市区","984","641");

subcat1[531] = new Array("黄果树景区","984","642");

subcat1[532] = new Array("武进高新区","808","643");

subcat1[533] = new Array("新北开发区","808","644");

subcat1[534] = new Array("新城","861","645");

		
onecount1=535;

	function changeclass1(locationid1)
    {
	var obj1=document.form1;
    obj1.region.length = 1; 

    var locationid1=locationid1;
    var i;
    for (i=0;i < onecount1; i++)
        {
            if (subcat1[i][1] == locationid1)
            { 
             obj1.region.options[obj1.region.length] = new Option(subcat1[i][0], subcat1[i][2]);
            }        
        }
        
    }   
</SCRIPT>
<!--select 改变小类别结束-->
<!--select 改变类别开始-->

<SCRIPT language="JavaScript">
var onecount2;
onecount2=0;
subcat2 = new Array();

subcat2[0] = new Array("东城区","878","1");

subcat2[1] = new Array("西城区","878","2");

subcat2[2] = new Array("崇文区","878","3");

subcat2[3] = new Array("宣武区","878","4");

subcat2[4] = new Array("朝阳区","878","5");

subcat2[5] = new Array("丰台区","878","6");

subcat2[6] = new Array("石景山区","878","7");

subcat2[7] = new Array("海淀区","878","8");

subcat2[8] = new Array("门头沟区","878","9");

subcat2[9] = new Array("房山区","878","10");

subcat2[10] = new Array("通州区","878","11");

subcat2[11] = new Array("顺义区","878","12");

subcat2[12] = new Array("昌平区","878","13");

subcat2[13] = new Array("大兴区","878","14");

subcat2[14] = new Array("怀柔区","878","15");

subcat2[15] = new Array("平谷区","878","16");

subcat2[16] = new Array("密云县","878","17");

subcat2[17] = new Array("延庆县","878","18");

subcat2[18] = new Array("和平区","854","19");

subcat2[19] = new Array("河东区","854","20");

subcat2[20] = new Array("河西区","854","21");

subcat2[21] = new Array("南开区","854","22");

subcat2[22] = new Array("河北区","854","23");

subcat2[23] = new Array("红桥区","854","24");

subcat2[24] = new Array("滨海新区","854","25");

subcat2[25] = new Array("汉沽区","854","26");

subcat2[26] = new Array("大港区","854","27");

subcat2[27] = new Array("东丽区","854","28");

subcat2[28] = new Array("西青区","854","29");

subcat2[29] = new Array("津南区","854","30");

subcat2[30] = new Array("北辰区","854","31");

subcat2[31] = new Array("武清区","854","32");

subcat2[32] = new Array("宝坻区","854","33");

subcat2[33] = new Array("宁河县","854","34");

subcat2[34] = new Array("静海县","854","35");

subcat2[35] = new Array("蓟县","854","36");

subcat2[36] = new Array("长安区","774","37");

subcat2[37] = new Array("桥东区","774","38");

subcat2[38] = new Array("桥西区","774","39");

subcat2[39] = new Array("新华区","774","40");

subcat2[40] = new Array("井陉矿区","774","41");

subcat2[41] = new Array("裕华区","774","42");

subcat2[42] = new Array("鹿泉市","774","47");

subcat2[43] = new Array("井陉县","774","48");

subcat2[44] = new Array("正定县","774","49");

subcat2[45] = new Array("栾城县","774","50");

subcat2[46] = new Array("行唐县","774","51");

subcat2[47] = new Array("灵寿县","774","52");

subcat2[48] = new Array("高邑县","774","53");

subcat2[49] = new Array("深泽县","774","54");

subcat2[50] = new Array("赞皇县","774","55");

subcat2[51] = new Array("无极县","774","56");

subcat2[52] = new Array("平山县","774","57");

subcat2[53] = new Array("元氏县","774","58");

subcat2[54] = new Array("高新技术产业开发区","774","59");

subcat2[55] = new Array("路北区","775","60");

subcat2[56] = new Array("路南区","775","61");

subcat2[57] = new Array("古冶区","775","62");

subcat2[58] = new Array("开平区","775","63");

subcat2[59] = new Array("丰南区","775","64");

subcat2[60] = new Array("丰润区","775","65");

subcat2[61] = new Array("遵化市","775","66");

subcat2[62] = new Array("迁安市","775","67");

subcat2[63] = new Array("滦县","775","68");

subcat2[64] = new Array("滦南县","775","69");

subcat2[65] = new Array("乐亭县","775","70");

subcat2[66] = new Array("迁西县","775","71");

subcat2[67] = new Array("玉田县","775","72");

subcat2[68] = new Array("唐海县","775","73");

subcat2[69] = new Array("海港区","776","74");

subcat2[70] = new Array("山海关区","776","75");

subcat2[71] = new Array("北戴河区","776","76");

subcat2[72] = new Array("昌黎县","776","77");

subcat2[73] = new Array("抚宁县","776","78");

subcat2[74] = new Array("卢龙县","776","79");

subcat2[75] = new Array("秦皇岛","776","80");

subcat2[76] = new Array("丛台区","901","81");

subcat2[77] = new Array("邯山区","901","82");

subcat2[78] = new Array("复兴区","901","83");

subcat2[79] = new Array("峰峰矿区","901","84");

subcat2[80] = new Array("武安市","901","85");

subcat2[81] = new Array("邯郸县","901","86");

subcat2[82] = new Array("临漳县","901","87");

subcat2[83] = new Array("成安县","901","88");

subcat2[84] = new Array("大名县","901","89");

subcat2[85] = new Array("涉县","901","90");

subcat2[86] = new Array("磁县","901","91");

subcat2[87] = new Array("肥乡县","901","92");

subcat2[88] = new Array("永年县","901","93");

subcat2[89] = new Array("邱县","901","94");

subcat2[90] = new Array("鸡泽县","901","95");

subcat2[91] = new Array("广平县","901","96");

subcat2[92] = new Array("馆陶县","901","97");

subcat2[93] = new Array("魏县","901","98");

subcat2[94] = new Array("曲周县","901","99");

subcat2[95] = new Array("桥东区","905","100");

subcat2[96] = new Array("桥西区","905","101");

subcat2[97] = new Array("南宫市","905","102");

subcat2[98] = new Array("沙河市","905","103");

subcat2[99] = new Array("邢台县","905","104");

subcat2[100] = new Array("临城县","905","105");

subcat2[101] = new Array("内丘县","905","106");

subcat2[102] = new Array("柏乡县","905","107");

subcat2[103] = new Array("隆尧县","905","108");

subcat2[104] = new Array("任县","905","109");

subcat2[105] = new Array("南和县","905","110");

subcat2[106] = new Array("宁晋县","905","111");

subcat2[107] = new Array("巨鹿县","905","112");

subcat2[108] = new Array("新河县","905","113");

subcat2[109] = new Array("广宗县","905","114");

subcat2[110] = new Array("平乡县","905","115");

subcat2[111] = new Array("威县","905","116");

subcat2[112] = new Array("清河县","905","117");

subcat2[113] = new Array("临西县","905","118");

subcat2[114] = new Array("新市区","899","119");

subcat2[115] = new Array("北市区","899","120");

subcat2[116] = new Array("南市区","899","121");

subcat2[117] = new Array("涿州市","899","122");

subcat2[118] = new Array("定州市","899","123");

subcat2[119] = new Array("安国市","899","124");

subcat2[120] = new Array("高碑店市","899","125");

subcat2[121] = new Array("满城县","899","126");

subcat2[122] = new Array("清苑县","899","127");

subcat2[123] = new Array("涞水县","899","128");

subcat2[124] = new Array("阜平县","899","129");

subcat2[125] = new Array("徐水县","899","130");

subcat2[126] = new Array("定兴县","899","131");

subcat2[127] = new Array("唐县","899","132");

subcat2[128] = new Array("高阳县","899","133");

subcat2[129] = new Array("容城县","899","134");

subcat2[130] = new Array("涞源县","899","135");

subcat2[131] = new Array("望都县","899","136");

subcat2[132] = new Array("安新县","899","137");

subcat2[133] = new Array("易县","899","138");

subcat2[134] = new Array("曲阳县","899","139");

subcat2[135] = new Array("蠡县","899","140");

subcat2[136] = new Array("顺平县","899","141");

subcat2[137] = new Array("博野县","899","142");

subcat2[138] = new Array("雄县","899","143");

subcat2[139] = new Array("双桥区","777","144");

subcat2[140] = new Array("双滦区","777","145");

subcat2[141] = new Array("鹰手营子矿区","777","146");

subcat2[142] = new Array("承德县","777","147");

subcat2[143] = new Array("兴隆县","777","148");

subcat2[144] = new Array("平泉县","777","149");

subcat2[145] = new Array("滦平县","777","150");

subcat2[146] = new Array("隆化县","777","151");

subcat2[147] = new Array("丰宁满族自治县","777","152");

subcat2[148] = new Array("宽城满族自治县","777","153");

subcat2[149] = new Array("围场满族蒙古族自治县","777","154");

subcat2[150] = new Array("运河区","1094","155");

subcat2[151] = new Array("新华区","1094","156");

subcat2[152] = new Array("泊头市","1094","157");

subcat2[153] = new Array("任丘市","1094","158");

subcat2[154] = new Array("黄骅市","1094","159");

subcat2[155] = new Array("河间市","1094","160");

subcat2[156] = new Array("沧县","1094","161");

subcat2[157] = new Array("青县","1094","162");

subcat2[158] = new Array("东光县","1094","163");

subcat2[159] = new Array("海兴县","1094","164");

subcat2[160] = new Array("盐山县","1094","165");

subcat2[161] = new Array("肃宁县","1094","166");

subcat2[162] = new Array("南皮县","1094","167");

subcat2[163] = new Array("吴桥县","1094","168");

subcat2[164] = new Array("献县","1094","169");

subcat2[165] = new Array("孟村回族自治县","1094","170");

subcat2[166] = new Array("安次区","903","171");

subcat2[167] = new Array("广阳区","903","172");

subcat2[168] = new Array("霸州市","903","173");

subcat2[169] = new Array("三河市","903","174");

subcat2[170] = new Array("固安县","903","175");

subcat2[171] = new Array("永清县","903","176");

subcat2[172] = new Array("香河县","903","177");

subcat2[173] = new Array("大城县","903","178");

subcat2[174] = new Array("文安县","903","179");

subcat2[175] = new Array("大厂回族自治县","903","180");

subcat2[176] = new Array("桃城区","902","181");

subcat2[177] = new Array("枣强县","902","184");

subcat2[178] = new Array("武邑县","902","185");

subcat2[179] = new Array("武强县","902","186");

subcat2[180] = new Array("饶阳县","902","187");

subcat2[181] = new Array("安平县","902","188");

subcat2[182] = new Array("故城县","902","189");

subcat2[183] = new Array("景县","902","190");

subcat2[184] = new Array("小店区","842","192");

subcat2[185] = new Array("迎泽区","842","193");

subcat2[186] = new Array("杏花岭区","842","194");

subcat2[187] = new Array("尖草坪区","842","195");

subcat2[188] = new Array("万柏林区","842","196");

subcat2[189] = new Array("晋源区","842","197");

subcat2[190] = new Array("清徐县","842","198");

subcat2[191] = new Array("阳曲县","842","199");

subcat2[192] = new Array("娄烦县","842","200");

subcat2[193] = new Array("城区","843","202");

subcat2[194] = new Array("矿区","843","203");

subcat2[195] = new Array("南郊区","843","204");

subcat2[196] = new Array("新荣区","843","205");

subcat2[197] = new Array("阳高县","843","206");

subcat2[198] = new Array("天镇县","843","207");

subcat2[199] = new Array("广灵县","843","208");

subcat2[200] = new Array("灵丘县","843","209");

subcat2[201] = new Array("浑源县","843","210");

subcat2[202] = new Array("左云县","843","211");

subcat2[203] = new Array("大同县","843","212");

subcat2[204] = new Array("城区","998","213");

subcat2[205] = new Array("沁水县","998","214");

subcat2[206] = new Array("阳城县","998","215");

subcat2[207] = new Array("陵川县","998","216");

subcat2[208] = new Array("泽州县","998","217");

subcat2[209] = new Array("高平市","998","218");

subcat2[210] = new Array("榆次区","974","219");

subcat2[211] = new Array("介休市","974","220");

subcat2[212] = new Array("榆社县","974","221");

subcat2[213] = new Array("左权县","974","222");

subcat2[214] = new Array("和顺县","974","223");

subcat2[215] = new Array("昔阳县","974","224");

subcat2[216] = new Array("寿阳县","974","225");

subcat2[217] = new Array("太谷县","974","226");

subcat2[218] = new Array("祁县","974","227");

subcat2[219] = new Array("平遥县","974","228");

subcat2[220] = new Array("灵石县","974","229");

subcat2[221] = new Array("盐湖区","977","230");

subcat2[222] = new Array("永济市","977","231");

subcat2[223] = new Array("河津市","977","232");

subcat2[224] = new Array("临猗县","977","233");

subcat2[225] = new Array("万荣县","977","234");

subcat2[226] = new Array("闻喜县","977","235");

subcat2[227] = new Array("稷山县","977","236");

subcat2[228] = new Array("新绛县","977","237");

subcat2[229] = new Array("绛县","977","238");

subcat2[230] = new Array("垣曲县","977","239");

subcat2[231] = new Array("夏县","977","240");

subcat2[232] = new Array("平陆县","977","241");

subcat2[233] = new Array("芮城县","977","242");

subcat2[234] = new Array("尧都区","976","243");

subcat2[235] = new Array("侯马市","976","244");

subcat2[236] = new Array("霍州市","976","245");

subcat2[237] = new Array("曲沃县","976","246");

subcat2[238] = new Array("翼城县","976","247");

subcat2[239] = new Array("襄汾县","976","248");

subcat2[240] = new Array("洪洞县","976","249");

subcat2[241] = new Array("古县","976","250");

subcat2[242] = new Array("安泽县","976","251");

subcat2[243] = new Array("浮山县","976","252");

subcat2[244] = new Array("吉县","976","253");

subcat2[245] = new Array("乡宁县","976","254");

subcat2[246] = new Array("大宁县","976","255");

subcat2[247] = new Array("隰县","976","256");

subcat2[248] = new Array("永和县","976","257");

subcat2[249] = new Array("蒲县","976","258");

subcat2[250] = new Array("汾西县","976","259");

subcat2[251] = new Array("回民区","824","260");

subcat2[252] = new Array("新城区","824","261");

subcat2[253] = new Array("玉泉区","824","262");

subcat2[254] = new Array("赛罕区","824","263");

subcat2[255] = new Array("土默特左旗","824","264");

subcat2[256] = new Array("托克托县","824","265");

subcat2[257] = new Array("和林格尔县","824","266");

subcat2[258] = new Array("武川县","824","267");

subcat2[259] = new Array("昆区","827","268");

subcat2[260] = new Array("东河区","827","269");

subcat2[261] = new Array("青山区","827","270");

subcat2[262] = new Array("石拐区","827","271");

subcat2[263] = new Array("白云矿区","827","272");

subcat2[264] = new Array("九原区","827","273");

subcat2[265] = new Array("土默特右旗","827","274");

subcat2[266] = new Array("固阳县","827","275");

subcat2[267] = new Array("达尔罕茂明安联合旗","827","276");

subcat2[268] = new Array("海勃湾区","938","277");

subcat2[269] = new Array("海南区","938","278");

subcat2[270] = new Array("乌达区","938","279");

subcat2[271] = new Array("红山区","826","280");

subcat2[272] = new Array("元宝山区","826","281");

subcat2[273] = new Array("松山区","826","282");

subcat2[274] = new Array("新城区","826","283");

subcat2[275] = new Array("巴林左旗","826","284");

subcat2[276] = new Array("巴林右旗","826","285");

subcat2[277] = new Array("林西县","826","286");

subcat2[278] = new Array("克什克腾旗","826","287");

subcat2[279] = new Array("翁牛特旗","826","288");

subcat2[280] = new Array("喀喇沁旗","826","289");

subcat2[281] = new Array("宁城县","826","290");

subcat2[282] = new Array("敖汉旗","826","291");

subcat2[283] = new Array("东胜区","825","292");

subcat2[284] = new Array("达拉特旗","825","293");

subcat2[285] = new Array("准格尔旗","825","294");

subcat2[286] = new Array("鄂托克前旗","825","295");

subcat2[287] = new Array("鄂托克旗","825","296");

subcat2[288] = new Array("杭锦旗","825","297");

subcat2[289] = new Array("乌审旗","825","298");

subcat2[290] = new Array("伊金霍洛旗","825","299");

subcat2[291] = new Array("沈河区","820","300");

subcat2[292] = new Array("和平区","820","301");

subcat2[293] = new Array("大东区","820","302");

subcat2[294] = new Array("皇姑区","820","303");

subcat2[295] = new Array("铁西区","820","304");

subcat2[296] = new Array("苏家屯区","820","305");

subcat2[297] = new Array("东陵区","820","306");

subcat2[298] = new Array("沈北新区","820","307");

subcat2[299] = new Array("于洪区","820","308");

subcat2[300] = new Array("新民市","820","309");

subcat2[301] = new Array("辽中县","820","310");

subcat2[302] = new Array("康平县","820","311");

subcat2[303] = new Array("法库县","820","312");

subcat2[304] = new Array("西岗区","821","313");

subcat2[305] = new Array("中山区","821","314");

subcat2[306] = new Array("沙河口区","821","315");

subcat2[307] = new Array("甘井子区","821","316");

subcat2[308] = new Array("旅顺口区","821","317");

subcat2[309] = new Array("金州区","821","318");

subcat2[310] = new Array("经济技术开发区","821","319");

subcat2[311] = new Array("金石滩国家旅游度假区","821","320");

subcat2[312] = new Array("铁东区","822","323");

subcat2[313] = new Array("铁西区","822","324");

subcat2[314] = new Array("立山区","822","325");

subcat2[315] = new Array("千山区","822","326");

subcat2[316] = new Array("海城市","822","327");

subcat2[317] = new Array("台安县","822","328");

subcat2[318] = new Array("岫岩满族自治县","822","329");

subcat2[319] = new Array("平山区","1095","330");

subcat2[320] = new Array("溪湖区","1095","331");

subcat2[321] = new Array("明山区","1095","332");

subcat2[322] = new Array("南芬区","1095","333");

subcat2[323] = new Array("本溪满族自治县","1095","334");

subcat2[324] = new Array("桓仁满族自治县","1095","335");

subcat2[325] = new Array("振兴区","823","336");

subcat2[326] = new Array("元宝区","823","337");

subcat2[327] = new Array("振安区","823","338");

subcat2[328] = new Array("东港市","823","339");

subcat2[329] = new Array("凤城市","823","340");

subcat2[330] = new Array("沿江开发区","823","341");

subcat2[331] = new Array("太和区","935","342");

subcat2[332] = new Array("古塔区","935","343");

subcat2[333] = new Array("凌河区","935","344");

subcat2[334] = new Array("凌海市","935","345");

subcat2[335] = new Array("北镇市","935","346");

subcat2[336] = new Array("黑山县","935","347");

subcat2[337] = new Array("义县","935","348");

subcat2[338] = new Array("站前区","1098","349");

subcat2[339] = new Array("西市区","1098","350");

subcat2[340] = new Array("鲅鱼圈经济技术开发区","1098","351");

subcat2[341] = new Array("老边区","1098","352");

subcat2[342] = new Array("盖州市","1098","353");

subcat2[343] = new Array("大石桥市","1098","354");

subcat2[344] = new Array("兴隆台区","1096","355");

subcat2[345] = new Array("双台子区","1096","356");

subcat2[346] = new Array("大洼县","1096","357");

subcat2[347] = new Array("盘山县","1096","358");

subcat2[348] = new Array("银州区","1097","359");

subcat2[349] = new Array("清河区","1097","360");

subcat2[350] = new Array("调兵山市","1097","361");

subcat2[351] = new Array("开原市","1097","362");

subcat2[352] = new Array("铁岭县","1097","363");

subcat2[353] = new Array("西丰县","1097","364");

subcat2[354] = new Array("昌图县","1097","365");

subcat2[355] = new Array("朝阳区","804","366");

subcat2[356] = new Array("南关区","804","367");

subcat2[357] = new Array("宽城区","804","368");

subcat2[358] = new Array("二道区","804","369");

subcat2[359] = new Array("绿园区","804","370");

subcat2[360] = new Array("双阳区","804","371");

subcat2[361] = new Array("榆树区","804","374");

subcat2[362] = new Array("高新开发区","804","375");

subcat2[363] = new Array("船营区","932","376");

subcat2[364] = new Array("昌邑区","932","377");

subcat2[365] = new Array("龙潭区","932","378");

subcat2[366] = new Array("丰满区","932","379");

subcat2[367] = new Array("蛟河市","932","380");

subcat2[368] = new Array("桦甸市","932","381");

subcat2[369] = new Array("舒兰市","932","382");

subcat2[370] = new Array("磐石市","932","383");

subcat2[371] = new Array("永吉县","932","384");

subcat2[372] = new Array("松北区","782","385");

subcat2[373] = new Array("道里区","782","386");

subcat2[374] = new Array("南岗区","782","387");

subcat2[375] = new Array("道外区","782","388");

subcat2[376] = new Array("平房区","782","389");

subcat2[377] = new Array("香坊区","782","390");

subcat2[378] = new Array("呼兰区","782","391");

subcat2[379] = new Array("阿城区","782","392");

subcat2[380] = new Array("双城区","782","393");

subcat2[381] = new Array("尚志区","782","394");

subcat2[382] = new Array("五常区","782","395");

subcat2[383] = new Array("依兰区","782","396");

subcat2[384] = new Array("方正区","782","397");

subcat2[385] = new Array("宾县区","782","398");

subcat2[386] = new Array("巴彦区","782","399");

subcat2[387] = new Array("木兰区","782","400");

subcat2[388] = new Array("通河区","782","401");

subcat2[389] = new Array("延寿区","782","402");

subcat2[390] = new Array("龙沙区","786","403");

subcat2[391] = new Array("建华区","786","404");

subcat2[392] = new Array("铁锋区","786","405");

subcat2[393] = new Array("昂昂溪区","786","406");

subcat2[394] = new Array("富拉尔基区","786","407");

subcat2[395] = new Array("碾子山区","786","408");

subcat2[396] = new Array("梅里斯区","786","409");

subcat2[397] = new Array("讷河区","786","410");

subcat2[398] = new Array("龙江区","786","411");

subcat2[399] = new Array("依安区","786","412");

subcat2[400] = new Array("泰来区","786","413");

subcat2[401] = new Array("甘南区","786","414");

subcat2[402] = new Array("富裕区","786","415");

subcat2[403] = new Array("克山区","786","416");

subcat2[404] = new Array("克东区","786","417");

subcat2[405] = new Array("拜泉区","786","418");

subcat2[406] = new Array("萨尔图区","788","419");

subcat2[407] = new Array("龙凤区","788","420");

subcat2[408] = new Array("让胡路区","788","421");

subcat2[409] = new Array("红岗区","788","422");

subcat2[410] = new Array("大同区","788","423");

subcat2[411] = new Array("肇州县","788","424");

subcat2[412] = new Array("肇源县","788","425");

subcat2[413] = new Array("林甸县","788","426");

subcat2[414] = new Array("杜尔伯特蒙古族自治县","788","427");

subcat2[415] = new Array("前进区","783","428");

subcat2[416] = new Array("向阳区","783","429");

subcat2[417] = new Array("东风区","783","430");

subcat2[418] = new Array("郊区","783","431");

subcat2[419] = new Array("同江市","783","432");

subcat2[420] = new Array("富锦市","783","433");

subcat2[421] = new Array("桦南县","783","434");

subcat2[422] = new Array("桦川县","783","435");

subcat2[423] = new Array("汤原县","783","436");

subcat2[424] = new Array("抚远县","783","437");

subcat2[425] = new Array("爱民区","785","438");

subcat2[426] = new Array("东安区","785","439");

subcat2[427] = new Array("阳明区","785","440");

subcat2[428] = new Array("西安区","785","441");

subcat2[429] = new Array("绥芬河市","785","442");

subcat2[430] = new Array("海林市","785","443");

subcat2[431] = new Array("宁安市","785","444");

subcat2[432] = new Array("穆棱市","785","445");

subcat2[433] = new Array("东宁县","785","446");

subcat2[434] = new Array("林口县","785","447");

subcat2[435] = new Array("爱辉区","784","448");

subcat2[436] = new Array("北安市","784","449");

subcat2[437] = new Array("五大连池市","784","450");

subcat2[438] = new Array("嫩江县","784","451");

subcat2[439] = new Array("逊克县","784","452");

subcat2[440] = new Array("孙吴县","784","453");

subcat2[441] = new Array("北林区","1085","454");

subcat2[442] = new Array("安达市","1085","455");

subcat2[443] = new Array("肇东市","1085","456");

subcat2[444] = new Array("海伦市","1085","457");

subcat2[445] = new Array("望奎县","1085","458");

subcat2[446] = new Array("兰西县","1085","459");

subcat2[447] = new Array("青冈县","1085","460");

subcat2[448] = new Array("庆安县","1085","461");

subcat2[449] = new Array("明水县","1085","462");

subcat2[450] = new Array("绥棱县","1085","463");

subcat2[451] = new Array("呼玛县","787","464");

subcat2[452] = new Array("塔河县","787","465");

subcat2[453] = new Array("漠河县","787","466");

subcat2[454] = new Array("加格达奇区","787","467");

subcat2[455] = new Array("松岭区","787","468");

subcat2[456] = new Array("新林区","787","469");

subcat2[457] = new Array("呼中区","787","470");

subcat2[458] = new Array("黄浦区","848","471");

subcat2[459] = new Array("卢湾区","848","472");

subcat2[460] = new Array("徐汇区","848","473");

subcat2[461] = new Array("长宁区","848","474");

subcat2[462] = new Array("静安区","848","475");

subcat2[463] = new Array("普陀区","848","476");

subcat2[464] = new Array("闸北区","848","477");

subcat2[465] = new Array("虹口区","848","478");

subcat2[466] = new Array("杨浦区","848","479");

subcat2[467] = new Array("宝山区","848","480");

subcat2[468] = new Array("闵行区","848","481");

subcat2[469] = new Array("嘉定区","848","482");

subcat2[470] = new Array("浦东新区","848","483");

subcat2[471] = new Array("金山区","848","484");

subcat2[472] = new Array("松江区","848","485");

subcat2[473] = new Array("青浦区","848","486");

subcat2[474] = new Array("南汇区","848","487");

subcat2[475] = new Array("奉贤区","848","488");

subcat2[476] = new Array("崇明县","848","489");

subcat2[477] = new Array("玄武区","807","490");

subcat2[478] = new Array("白下区","807","491");

subcat2[479] = new Array("秦淮区","807","492");

subcat2[480] = new Array("建邺区","807","493");

subcat2[481] = new Array("鼓楼区","807","494");

subcat2[482] = new Array("下关区","807","495");

subcat2[483] = new Array("浦口区","807","496");

subcat2[484] = new Array("栖霞区","807","497");

subcat2[485] = new Array("雨花台区","807","498");

subcat2[486] = new Array("江宁区","807","499");

subcat2[487] = new Array("六合区","807","500");

subcat2[488] = new Array("溧水县","807","501");

subcat2[489] = new Array("高淳","807","502");

subcat2[490] = new Array("崇安区","812","503");

subcat2[491] = new Array("南长区","812","504");

subcat2[492] = new Array("北塘区","812","505");

subcat2[493] = new Array("滨湖区","812","506");

subcat2[494] = new Array("锡山区","812","507");

subcat2[495] = new Array("惠山区","812","508");

subcat2[496] = new Array("江阴市","812","509");

subcat2[497] = new Array("宜兴市","812","510");

subcat2[498] = new Array("云龙区","813","511");

subcat2[499] = new Array("鼓楼区","813","512");

subcat2[500] = new Array("九里区","813","513");

subcat2[501] = new Array("贾汪区","813","514");

subcat2[502] = new Array("泉山区","813","515");

subcat2[503] = new Array("新沂市","813","516");

subcat2[504] = new Array("邳州市","813","517");

subcat2[505] = new Array("丰县","813","518");

subcat2[506] = new Array("沛县","813","519");

subcat2[507] = new Array("铜山县","813","520");

subcat2[508] = new Array("睢宁县","813","521");

subcat2[509] = new Array("钟楼区","808","522");

subcat2[510] = new Array("天宁区","808","523");

subcat2[511] = new Array("戚墅堰","808","524");

subcat2[512] = new Array("新北区","808","525");

subcat2[513] = new Array("武进区","808","526");

subcat2[514] = new Array("溧阳市","808","527");

subcat2[515] = new Array("金坛市","808","528");

subcat2[516] = new Array("金阊区","810","529");

subcat2[517] = new Array("沧浪区","810","530");

subcat2[518] = new Array("平江区","810","531");

subcat2[519] = new Array("虎丘区","810","532");

subcat2[520] = new Array("吴中区","810","533");

subcat2[521] = new Array("相城区","810","534");

subcat2[522] = new Array("苏州新区","810","535");

subcat2[523] = new Array("苏州工业园区","810","537");

subcat2[524] = new Array("崇川区","811","540");

subcat2[525] = new Array("港闸区","811","541");

subcat2[526] = new Array("启东市","811","542");

subcat2[527] = new Array("如皋市","811","543");

subcat2[528] = new Array("通州市","811","544");

subcat2[529] = new Array("海门市","811","545");

subcat2[530] = new Array("海安县","811","546");

subcat2[531] = new Array("如东县","811","547");

subcat2[532] = new Array("新浦区","809","548");

subcat2[533] = new Array("连云区","809","549");

subcat2[534] = new Array("海州区","809","550");

subcat2[535] = new Array("赣榆县","809","551");

subcat2[536] = new Array("东海县","809","552");

subcat2[537] = new Array("灌云县","809","553");

subcat2[538] = new Array("灌南县","809","554");

subcat2[539] = new Array("清河区","925","555");

subcat2[540] = new Array("清浦区","925","556");

subcat2[541] = new Array("楚州区","925","557");

subcat2[542] = new Array("淮阴区","925","558");

subcat2[543] = new Array("涟水县","925","559");

subcat2[544] = new Array("洪泽县","925","560");

subcat2[545] = new Array("盱眙县","925","561");

subcat2[546] = new Array("金湖县","925","562");

subcat2[547] = new Array("亭湖区","939","563");

subcat2[548] = new Array("盐都区","939","564");

subcat2[549] = new Array("东台市","939","565");

subcat2[550] = new Array("大丰市","939","566");

subcat2[551] = new Array("响水县","939","567");

subcat2[552] = new Array("滨海县","939","568");

subcat2[553] = new Array("阜宁县","939","569");

subcat2[554] = new Array("射阳县","939","570");

subcat2[555] = new Array("建湖县","939","571");

subcat2[556] = new Array("广陵区","814","572");

subcat2[557] = new Array("邗江区","814","573");

subcat2[558] = new Array("维扬区","814","574");

subcat2[559] = new Array("仪征市","814","575");

subcat2[560] = new Array("高邮市","814","576");

subcat2[561] = new Array("江都市","814","577");

subcat2[562] = new Array("宝应县","814","578");

subcat2[563] = new Array("京口区","815","579");

subcat2[564] = new Array("润州区","815","580");

subcat2[565] = new Array("丹徒区","815","581");

subcat2[566] = new Array("海陵区","936","585");

subcat2[567] = new Array("高港区","936","586");

subcat2[568] = new Array("兴化市","936","587");

subcat2[569] = new Array("靖江市","936","588");

subcat2[570] = new Array("泰兴市","936","589");

subcat2[571] = new Array("姜堰市","936","590");

subcat2[572] = new Array("宿城区","933","591");

subcat2[573] = new Array("宿豫区","933","592");

subcat2[574] = new Array("沭阳县","933","593");

subcat2[575] = new Array("泗阳县","933","594");

subcat2[576] = new Array("泗洪县","933","595");

subcat2[577] = new Array("拱墅区","864","596");

subcat2[578] = new Array("上城区","864","597");

subcat2[579] = new Array("下城区","864","598");

subcat2[580] = new Array("江干区","864","599");

subcat2[581] = new Array("西湖区","864","600");

subcat2[582] = new Array("滨江区","864","601");

subcat2[583] = new Array("萧山区","864","602");

subcat2[584] = new Array("余杭区","864","603");

subcat2[585] = new Array("淳安县","864","608");

subcat2[586] = new Array("海曙区","866","609");

subcat2[587] = new Array("江东区","866","610");

subcat2[588] = new Array("江北区","866","611");

subcat2[589] = new Array("北仑区","866","612");

subcat2[590] = new Array("镇海区","866","613");

subcat2[591] = new Array("鄞州区","866","614");

subcat2[592] = new Array("鹿城区","867","620");

subcat2[593] = new Array("龙湾区","867","621");

subcat2[594] = new Array("瓯海区","867","622");

subcat2[595] = new Array("瑞安市","867","623");

subcat2[596] = new Array("乐清市","867","624");

subcat2[597] = new Array("洞头县","867","625");

subcat2[598] = new Array("永嘉县","867","626");

subcat2[599] = new Array("平阳县","867","627");

subcat2[600] = new Array("苍南县","867","628");

subcat2[601] = new Array("文成县","867","629");

subcat2[602] = new Array("泰顺县","867","630");

subcat2[603] = new Array("南湖区","865","631");

subcat2[604] = new Array("秀洲区","865","632");

subcat2[605] = new Array("吴兴区","1023","638");

subcat2[606] = new Array("南浔区","1023","639");

subcat2[607] = new Array("德清县","1023","640");

subcat2[608] = new Array("长兴县","1023","641");

subcat2[609] = new Array("安吉县","1023","642");

subcat2[610] = new Array("越城区","1022","643");

subcat2[611] = new Array("柯桥镇","1022","645");

subcat2[612] = new Array("嵊州","1022","646");

subcat2[613] = new Array("绍兴县","1022","647");

subcat2[614] = new Array("新昌","1022","648");

subcat2[615] = new Array("婺城区","1024","649");

subcat2[616] = new Array("金东区","1024","650");

subcat2[617] = new Array("兰溪市","1024","651");

subcat2[618] = new Array("义乌市","1024","652");

subcat2[619] = new Array("东阳市","1024","653");

subcat2[620] = new Array("永康市","1024","654");

subcat2[621] = new Array("武义县","1024","655");

subcat2[622] = new Array("浦江县","1024","656");

subcat2[623] = new Array("磐安县","1024","657");

subcat2[624] = new Array("柯城区","1052","658");

subcat2[625] = new Array("衢江区","1052","659");

subcat2[626] = new Array("江山市","1052","660");

subcat2[627] = new Array("常山县","1052","661");

subcat2[628] = new Array("开化县","1052","662");

subcat2[629] = new Array("龙游县","1052","663");

subcat2[630] = new Array("定海区","868","664");

subcat2[631] = new Array("普陀山","868","665");

subcat2[632] = new Array("普陀区","868","666");

subcat2[633] = new Array("嵊泗县","868","667");

subcat2[634] = new Array("椒江区","1011","668");

subcat2[635] = new Array("黄岩区","1011","669");

subcat2[636] = new Array("路桥区","1011","670");

subcat2[637] = new Array("温岭市","1011","671");

subcat2[638] = new Array("临海市","1011","672");

subcat2[639] = new Array("玉环县","1011","673");

subcat2[640] = new Array("三门县","1011","674");

subcat2[641] = new Array("天台县","1011","675");

subcat2[642] = new Array("仙居县","1011","676");

subcat2[643] = new Array("莲都区","1047","677");

subcat2[644] = new Array("青田县","1047","679");

subcat2[645] = new Array("缙云县","1047","680");

subcat2[646] = new Array("遂昌县","1047","681");

subcat2[647] = new Array("松阳县","1047","682");

subcat2[648] = new Array("云和县","1047","683");

subcat2[649] = new Array("庆元县","1047","684");

subcat2[650] = new Array("景宁畲族自治县","1047","685");

subcat2[651] = new Array("庐阳区","727","686");

subcat2[652] = new Array("瑶海区","727","687");

subcat2[653] = new Array("蜀山区","727","688");

subcat2[654] = new Array("包河区","727","689");

subcat2[655] = new Array("高新区","727","690");

subcat2[656] = new Array("肥东县","727","691");

subcat2[657] = new Array("肥西县","727","692");

subcat2[658] = new Array("镜湖区","730","693");

subcat2[659] = new Array("弋江区","730","694");

subcat2[660] = new Array("鸠江区","730","695");

subcat2[661] = new Array("三山区","730","696");

subcat2[662] = new Array("芜湖县","730","697");

subcat2[663] = new Array("繁昌县","730","698");

subcat2[664] = new Array("南陵县","730","699");

subcat2[665] = new Array("蚌山区","726","700");

subcat2[666] = new Array("龙子湖","726","701");

subcat2[667] = new Array("禹会区","726","702");

subcat2[668] = new Array("淮上区","726","703");

subcat2[669] = new Array("怀远县","726","704");

subcat2[670] = new Array("五河县","726","705");

subcat2[671] = new Array("固镇县","726","706");

subcat2[672] = new Array("田家庵区","884","707");

subcat2[673] = new Array("大通区","884","708");

subcat2[674] = new Array("谢家集","884","709");

subcat2[675] = new Array("八公山","884","710");

subcat2[676] = new Array("潘集区","884","711");

subcat2[677] = new Array("凤台县","884","712");

subcat2[678] = new Array("雨山区","886","713");

subcat2[679] = new Array("金家庄","886","714");

subcat2[680] = new Array("花山区","886","715");

subcat2[681] = new Array("当涂县","886","716");

subcat2[682] = new Array("铜官山","956","717");

subcat2[683] = new Array("狮子山","956","718");

subcat2[684] = new Array("郊区","956","719");

subcat2[685] = new Array("铜陵县","956","720");

subcat2[686] = new Array("迎江区","725","721");

subcat2[687] = new Array("大观区","725","722");

subcat2[688] = new Array("宜秀区","725","723");

subcat2[689] = new Array("桐城市","725","724");

subcat2[690] = new Array("怀宁县","725","725");

subcat2[691] = new Array("枞阳县","725","726");

subcat2[692] = new Array("潜山县","725","727");

subcat2[693] = new Array("太湖县","725","728");

subcat2[694] = new Array("宿松县","725","729");

subcat2[695] = new Array("望江县","725","730");

subcat2[696] = new Array("岳西县","725","731");

subcat2[697] = new Array("屯溪区","728","732");

subcat2[698] = new Array("黄山区","728","733");

subcat2[699] = new Array("徽州区","728","734");

subcat2[700] = new Array("歙县","728","735");

subcat2[701] = new Array("休宁县","728","736");

subcat2[702] = new Array("黟县","728","737");

subcat2[703] = new Array("祁门县","728","738");

subcat2[704] = new Array("琅琊区","996","739");

subcat2[705] = new Array("南谯区","996","740");

subcat2[706] = new Array("天长市","996","741");

subcat2[707] = new Array("明光市","996","742");

subcat2[708] = new Array("来安县","996","743");

subcat2[709] = new Array("全椒县","996","744");

subcat2[710] = new Array("定远县","996","745");

subcat2[711] = new Array("凤阳县","996","746");

subcat2[712] = new Array("颍州区","883","747");

subcat2[713] = new Array("颍东区","883","748");

subcat2[714] = new Array("颍泉区","883","749");

subcat2[715] = new Array("界首市","883","750");

subcat2[716] = new Array("临泉县","883","751");

subcat2[717] = new Array("太和县","883","752");

subcat2[718] = new Array("阜南县","883","753");

subcat2[719] = new Array("颍上县","883","754");

subcat2[720] = new Array("墉桥区","887","755");

subcat2[721] = new Array("砀山县","887","756");

subcat2[722] = new Array("萧县","887","757");

subcat2[723] = new Array("灵璧县","887","758");

subcat2[724] = new Array("泗县","887","759");

subcat2[725] = new Array("居巢区","882","760");

subcat2[726] = new Array("庐江县","882","761");

subcat2[727] = new Array("无为县","882","762");

subcat2[728] = new Array("含山县","882","763");

subcat2[729] = new Array("和县","882","764");

subcat2[730] = new Array("鼓楼区","732","765");

subcat2[731] = new Array("台江区","732","766");

subcat2[732] = new Array("仓山区","732","767");

subcat2[733] = new Array("马尾区","732","768");

subcat2[734] = new Array("晋安区","732","769");

subcat2[735] = new Array("福清市","732","770");

subcat2[736] = new Array("长乐市","732","771");

subcat2[737] = new Array("闽侯县","732","772");

subcat2[738] = new Array("连江县","732","773");

subcat2[739] = new Array("罗源县","732","774");

subcat2[740] = new Array("闽清县","732","775");

subcat2[741] = new Array("永泰县","732","776");

subcat2[742] = new Array("平潭县","732","777");

subcat2[743] = new Array("思明区","735","778");

subcat2[744] = new Array("海沧区","735","779");

subcat2[745] = new Array("湖里区","735","780");

subcat2[746] = new Array("集美区","735","781");

subcat2[747] = new Array("同安区","735","782");

subcat2[748] = new Array("翔安区","735","783");

subcat2[749] = new Array("城厢区","1082","784");

subcat2[750] = new Array("涵江区","1082","785");

subcat2[751] = new Array("荔城区","1082","786");

subcat2[752] = new Array("秀屿区","1082","787");

subcat2[753] = new Array("仙游县","1082","788");

subcat2[754] = new Array("梅列区","1083","789");

subcat2[755] = new Array("三元区","1083","790");

subcat2[756] = new Array("永安县","1083","791");

subcat2[757] = new Array("明溪县","1083","792");

subcat2[758] = new Array("清流县","1083","793");

subcat2[759] = new Array("宁化县","1083","794");

subcat2[760] = new Array("大田县","1083","795");

subcat2[761] = new Array("尤溪县","1083","796");

subcat2[762] = new Array("沙县","1083","797");

subcat2[763] = new Array("将乐县","1083","798");

subcat2[764] = new Array("泰宁县","1083","799");

subcat2[765] = new Array("建宁县","1083","800");

subcat2[766] = new Array("鲤城区","734","801");

subcat2[767] = new Array("丰泽区","734","802");

subcat2[768] = new Array("洛江区","734","803");

subcat2[769] = new Array("泉港区","734","804");

subcat2[770] = new Array("石狮市","734","805");

subcat2[771] = new Array("晋江市","734","806");

subcat2[772] = new Array("南安市","734","807");

subcat2[773] = new Array("惠安县","734","808");

subcat2[774] = new Array("安溪县","734","809");

subcat2[775] = new Array("永春县","734","810");

subcat2[776] = new Array("德化县","734","811");

subcat2[777] = new Array("金门县","734","812");

subcat2[778] = new Array("芗城区","736","813");

subcat2[779] = new Array("龙文区","736","814");

subcat2[780] = new Array("龙海市","736","815");

subcat2[781] = new Array("云霄县","736","816");

subcat2[782] = new Array("漳浦县","736","817");

subcat2[783] = new Array("诏安县","736","818");

subcat2[784] = new Array("长泰县","736","819");

subcat2[785] = new Array("东山县","736","820");

subcat2[786] = new Array("南靖县","736","821");

subcat2[787] = new Array("平和县","736","822");

subcat2[788] = new Array("平和县","736","823");

subcat2[789] = new Array("华安县","736","824");

subcat2[790] = new Array("新罗区","733","825");

subcat2[791] = new Array("漳平市","733","826");

subcat2[792] = new Array("长汀县","733","827");

subcat2[793] = new Array("永定县","733","828");

subcat2[794] = new Array("上杭县","733","829");

subcat2[795] = new Array("武平县","733","830");

subcat2[796] = new Array("连城县","733","831");

subcat2[797] = new Array("蕉城区","1081","832");

subcat2[798] = new Array("福安市","1081","833");

subcat2[799] = new Array("福鼎市","1081","834");

subcat2[800] = new Array("霞浦县","1081","835");

subcat2[801] = new Array("古田县","1081","836");

subcat2[802] = new Array("屏南县","1081","837");

subcat2[803] = new Array("寿宁县","1081","838");

subcat2[804] = new Array("周宁县","1081","839");

subcat2[805] = new Array("柘荣县","1081","840");

subcat2[806] = new Array("东湖区","1013","841");

subcat2[807] = new Array("西湖区","1013","842");

subcat2[808] = new Array("湾里区","1013","843");

subcat2[809] = new Array("青云谱区","1013","844");

subcat2[810] = new Array("青山湖区","1013","845");

subcat2[811] = new Array("红谷新区","1013","846");

subcat2[812] = new Array("新建县","1013","847");

subcat2[813] = new Array("安义县","1013","848");

subcat2[814] = new Array("进贤县","1013","849");

subcat2[815] = new Array("珠山区","1017","850");

subcat2[816] = new Array("昌江区","1017","851");

subcat2[817] = new Array("乐平市","1017","852");

subcat2[818] = new Array("浮梁县","1017","853");

subcat2[819] = new Array("安源区","1016","854");

subcat2[820] = new Array("湘东区","1016","855");

subcat2[821] = new Array("莲花县","1016","856");

subcat2[822] = new Array("芦溪县","1016","857");

subcat2[823] = new Array("上栗县","1016","858");

subcat2[824] = new Array("浔阳区","817","859");

subcat2[825] = new Array("庐山区","817","860");

subcat2[826] = new Array("瑞昌市","817","861");

subcat2[827] = new Array("九江县","817","862");

subcat2[828] = new Array("武宁县","817","863");

subcat2[829] = new Array("修水县","817","864");

subcat2[830] = new Array("永修县","817","865");

subcat2[831] = new Array("德安县","817","866");

subcat2[832] = new Array("星子县","817","867");

subcat2[833] = new Array("都昌县","817","868");

subcat2[834] = new Array("湖口县","817","869");

subcat2[835] = new Array("彭泽县","817","870");

subcat2[836] = new Array("章贡区","1014","871");

subcat2[837] = new Array("瑞金市","1014","872");

subcat2[838] = new Array("南康市","1014","873");

subcat2[839] = new Array("赣县","1014","874");

subcat2[840] = new Array("信丰县","1014","875");

subcat2[841] = new Array("大余县","1014","876");

subcat2[842] = new Array("上犹县","1014","877");

subcat2[843] = new Array("崇义县","1014","878");

subcat2[844] = new Array("安远县","1014","879");

subcat2[845] = new Array("龙南县","1014","880");

subcat2[846] = new Array("定南县","1014","881");

subcat2[847] = new Array("全南县","1014","882");

subcat2[848] = new Array("宁都县","1014","883");

subcat2[849] = new Array("于都县","1014","884");

subcat2[850] = new Array("兴国县","1014","885");

subcat2[851] = new Array("会昌县","1014","886");

subcat2[852] = new Array("寻乌县","1014","887");

subcat2[853] = new Array("石城县","1014","888");

subcat2[854] = new Array("吉州区","1015","889");

subcat2[855] = new Array("青原区","1015","890");

subcat2[856] = new Array("井冈山","1015","891");

subcat2[857] = new Array("吉安县","1015","892");

subcat2[858] = new Array("吉水县","1015","893");

subcat2[859] = new Array("峡江县","1015","894");

subcat2[860] = new Array("新干县","1015","895");

subcat2[861] = new Array("永丰县","1015","896");

subcat2[862] = new Array("泰和县","1015","897");

subcat2[863] = new Array("遂川县","1015","898");

subcat2[864] = new Array("万安县","1015","899");

subcat2[865] = new Array("安福县","1015","900");

subcat2[866] = new Array("永新县","1015","901");

subcat2[867] = new Array("袁州区","924","902");

subcat2[868] = new Array("丰城市","924","903");

subcat2[869] = new Array("樟树市","924","904");

subcat2[870] = new Array("高安市","924","905");

subcat2[871] = new Array("奉新县","924","906");

subcat2[872] = new Array("万载县","924","907");

subcat2[873] = new Array("上高县","924","908");

subcat2[874] = new Array("宜丰县","924","909");

subcat2[875] = new Array("靖安县","924","910");

subcat2[876] = new Array("铜鼓县","924","911");

subcat2[877] = new Array("信州区","1019","912");

subcat2[878] = new Array("德兴市","1019","913");

subcat2[879] = new Array("上饶县","1019","914");

subcat2[880] = new Array("广丰县","1019","915");

subcat2[881] = new Array("玉山县","1019","916");

subcat2[882] = new Array("铅山县","1019","917");

subcat2[883] = new Array("横峰县","1019","918");

subcat2[884] = new Array("弋阳县","1019","919");

subcat2[885] = new Array("余干县","1019","920");

subcat2[886] = new Array("鄱阳县","1019","921");

subcat2[887] = new Array("万年县","1019","922");

subcat2[888] = new Array("婺源县","1019","923");

subcat2[889] = new Array("历下区","838","924");

subcat2[890] = new Array("市中区","838","925");

subcat2[891] = new Array("槐荫区","838","926");

subcat2[892] = new Array("天桥区","838","927");

subcat2[893] = new Array("历城区","838","928");

subcat2[894] = new Array("长清区","838","929");

subcat2[895] = new Array("章丘市","838","930");

subcat2[896] = new Array("平阴县","838","931");

subcat2[897] = new Array("济阳县","838","932");

subcat2[898] = new Array("商河县","838","933");

subcat2[899] = new Array("市南区","839","934");

subcat2[900] = new Array("市北区","839","935");

subcat2[901] = new Array("四方区","839","936");

subcat2[902] = new Array("黄岛经济技术开发区","839","937");

subcat2[903] = new Array("崂山区","839","938");

subcat2[904] = new Array("李沧区","839","939");

subcat2[905] = new Array("城阳区","839","940");

subcat2[906] = new Array("张店区","841","946");

subcat2[907] = new Array("淄川区","841","947");

subcat2[908] = new Array("博山区","841","948");

subcat2[909] = new Array("临淄区","841","949");

subcat2[910] = new Array("周村区","841","950");

subcat2[911] = new Array("桓台县","841","951");

subcat2[912] = new Array("高青县","841","952");

subcat2[913] = new Array("沂源县","841","953");

subcat2[914] = new Array("市中区","1073","954");

subcat2[915] = new Array("薛城区","1073","955");

subcat2[916] = new Array("峄城区","1073","956");

subcat2[917] = new Array("台儿庄区","1073","957");

subcat2[918] = new Array("山亭区","1073","958");

subcat2[919] = new Array("东城区","944","960");

subcat2[920] = new Array("河口区","944","961");

subcat2[921] = new Array("西城区","944","962");

subcat2[922] = new Array("利津县","944","963");

subcat2[923] = new Array("广饶县","944","964");

subcat2[924] = new Array("芝罘区","840","965");

subcat2[925] = new Array("福山区","840","966");

subcat2[926] = new Array("牟平区","840","967");

subcat2[927] = new Array("开发区","840","973");

subcat2[928] = new Array("莱山区","840","974");

subcat2[929] = new Array("海阳市风城县","840","975");

subcat2[930] = new Array("潍城区","1031","977");

subcat2[931] = new Array("寒亭区","1031","978");

subcat2[932] = new Array("坊子区","1031","979");

subcat2[933] = new Array("奎文区","1031","980");

subcat2[934] = new Array("临朐县","1031","987");

subcat2[935] = new Array("昌乐县","1031","988");

subcat2[936] = new Array("环翠区","955","989");

subcat2[937] = new Array("经济技术开发区","955","990");

subcat2[938] = new Array("高技术产业开发区","955","991");

subcat2[939] = new Array("市中区","948","993");

subcat2[940] = new Array("任城区","948","994");

subcat2[941] = new Array("曲阜市","948","995");

subcat2[942] = new Array("兖州市","948","996");

subcat2[943] = new Array("邹城市","948","997");

subcat2[944] = new Array("微山县","948","998");

subcat2[945] = new Array("鱼台县","948","999");

subcat2[946] = new Array("金乡县","948","1000");

subcat2[947] = new Array("嘉祥县","948","1001");

subcat2[948] = new Array("汶上县","948","1002");

subcat2[949] = new Array("泗水县","948","1003");

subcat2[950] = new Array("梁山县","948","1004");

subcat2[951] = new Array("泰山区","954","1005");

subcat2[952] = new Array("岱岳区","954","1006");

subcat2[953] = new Array("山脚","954","1007");

subcat2[954] = new Array("市内","954","1008");

subcat2[955] = new Array("宁阳县","954","1009");

subcat2[956] = new Array("东平县","954","1010");

subcat2[957] = new Array("东港区","1100","1011");

subcat2[958] = new Array("新市区","1100","1012");

subcat2[959] = new Array("开发区","1100","1013");

subcat2[960] = new Array("东岗区","1100","1014");

subcat2[961] = new Array("莱城区","1099","1015");

subcat2[962] = new Array("钢城区","1099","1016");

subcat2[963] = new Array("兰山区","951","1017");

subcat2[964] = new Array("罗庄区","951","1018");

subcat2[965] = new Array("河东区","951","1019");

subcat2[966] = new Array("沂南县","951","1020");

subcat2[967] = new Array("郯城县","951","1021");

subcat2[968] = new Array("沂水县","951","1022");

subcat2[969] = new Array("苍山县","951","1023");

subcat2[970] = new Array("费县","951","1024");

subcat2[971] = new Array("平邑县","951","1025");

subcat2[972] = new Array("莒南县","951","1026");

subcat2[973] = new Array("蒙阴县","951","1027");

subcat2[974] = new Array("临沭县","951","1028");

subcat2[975] = new Array("东昌府区","950","1029");

subcat2[976] = new Array("阳谷镇","950","1031");

subcat2[977] = new Array("莘县","950","1032");

subcat2[978] = new Array("茌平县","950","1033");

subcat2[979] = new Array("东阿县","950","1034");

subcat2[980] = new Array("冠县","950","1035");

subcat2[981] = new Array("高唐县","950","1036");

subcat2[982] = new Array("牡丹区","946","1037");

subcat2[983] = new Array("开发区","946","1038");

subcat2[984] = new Array("单县","946","1039");

subcat2[985] = new Array("成武县","946","1040");

subcat2[986] = new Array("巨野县","946","1041");

subcat2[987] = new Array("郓城县","946","1042");

subcat2[988] = new Array("鄄城县","946","1043");

subcat2[989] = new Array("定陶县","946","1044");

subcat2[990] = new Array("东明县","946","1045");

subcat2[991] = new Array("中原区","778","1046");

subcat2[992] = new Array("二七区","778","1047");

subcat2[993] = new Array("金水区","778","1049");

subcat2[994] = new Array("上街区","778","1050");

subcat2[995] = new Array("惠济区","778","1051");

subcat2[996] = new Array("巩义市","778","1052");

subcat2[997] = new Array("荥阳","778","1053");

subcat2[998] = new Array("新密市","778","1054");

subcat2[999] = new Array("新郑市","778","1055");

subcat2[1000] = new Array("管城回族区","778","1056");

subcat2[1001] = new Array("高新技术产业开发区","778","1057");

subcat2[1002] = new Array("鼓楼区","781","1058");

subcat2[1003] = new Array("龙亭区","781","1059");

subcat2[1004] = new Array("顺河区","781","1060");

subcat2[1005] = new Array("禹王台","781","1061");

subcat2[1006] = new Array("金明区","781","1062");

subcat2[1007] = new Array("杞县","781","1063");

subcat2[1008] = new Array("通许县","781","1064");

subcat2[1009] = new Array("尉氏县","781","1065");

subcat2[1010] = new Array("开封县","781","1066");

subcat2[1011] = new Array("兰考县","781","1067");

subcat2[1012] = new Array("西工区","780","1068");

subcat2[1013] = new Array("老城区","780","1069");

subcat2[1014] = new Array("瀍河区","780","1070");

subcat2[1015] = new Array("涧西区","780","1071");

subcat2[1016] = new Array("吉利区","780","1072");

subcat2[1017] = new Array("洛龙区","780","1073");

subcat2[1018] = new Array("洛南新区","780","1074");

subcat2[1019] = new Array("孟津县","780","1075");

subcat2[1020] = new Array("新安县","780","1076");

subcat2[1021] = new Array("栾川县","780","1077");

subcat2[1022] = new Array("嵩县","780","1078");

subcat2[1023] = new Array("汝阳县","780","1079");

subcat2[1024] = new Array("宜阳县","780","1080");

subcat2[1025] = new Array("洛宁县","780","1081");

subcat2[1026] = new Array("伊川县","780","1082");

subcat2[1027] = new Array("淇滨区","908","1083");

subcat2[1028] = new Array("山城区","908","1084");

subcat2[1029] = new Array("鹤山区","908","1085");

subcat2[1030] = new Array("浚县","908","1086");

subcat2[1031] = new Array("淇县","908","1087");

subcat2[1032] = new Array("卫滨区","911","1088");

subcat2[1033] = new Array("红旗区","911","1089");

subcat2[1034] = new Array("凤泉区","911","1090");

subcat2[1035] = new Array("牧野区","911","1091");

subcat2[1036] = new Array("卫辉市","911","1092");

subcat2[1037] = new Array("辉县市","911","1093");

subcat2[1038] = new Array("新乡县","911","1094");

subcat2[1039] = new Array("获嘉县","911","1095");

subcat2[1040] = new Array("原阳县","911","1096");

subcat2[1041] = new Array("延津县","911","1097");

subcat2[1042] = new Array("封丘县","911","1098");

subcat2[1043] = new Array("长垣县","911","1099");

subcat2[1044] = new Array("华龙区","910","1100");

subcat2[1045] = new Array("清丰县","910","1101");

subcat2[1046] = new Array("南乐县","910","1102");

subcat2[1047] = new Array("范县","910","1103");

subcat2[1048] = new Array("台前县","910","1104");

subcat2[1049] = new Array("高新区","910","1105");

subcat2[1050] = new Array("湖滨区","779","1106");

subcat2[1051] = new Array("开发区","779","1107");

subcat2[1052] = new Array("灵宝市","779","1108");

subcat2[1053] = new Array("渑池县","779","1109");

subcat2[1054] = new Array("陕县","779","1110");

subcat2[1055] = new Array("卢氏县","779","1111");

subcat2[1056] = new Array("卧龙区","909","1112");

subcat2[1057] = new Array("宛城区","909","1113");

subcat2[1058] = new Array("高新区","909","1114");

subcat2[1059] = new Array("南召县","909","1115");

subcat2[1060] = new Array("方城县","909","1116");

subcat2[1061] = new Array("西峡县","909","1117");

subcat2[1062] = new Array("镇平县","909","1118");

subcat2[1063] = new Array("内乡县","909","1119");

subcat2[1064] = new Array("淅川县","909","1120");

subcat2[1065] = new Array("社旗县","909","1121");

subcat2[1066] = new Array("唐河县","909","1122");

subcat2[1067] = new Array("新野县","909","1123");

subcat2[1068] = new Array("桐柏县","909","1124");

subcat2[1069] = new Array("浉河区","995","1125");

subcat2[1070] = new Array("平桥区","995","1126");

subcat2[1071] = new Array("罗山县","995","1127");

subcat2[1072] = new Array("光山县","995","1128");

subcat2[1073] = new Array("新县","995","1129");

subcat2[1074] = new Array("商城县","995","1130");

subcat2[1075] = new Array("固始县","995","1131");

subcat2[1076] = new Array("潢川县","995","1132");

subcat2[1077] = new Array("淮滨县","995","1133");

subcat2[1078] = new Array("息县","995","1134");

subcat2[1079] = new Array("江岸区","789","1135");

subcat2[1080] = new Array("江汉区","789","1136");

subcat2[1081] = new Array("硚口区","789","1137");

subcat2[1082] = new Array("汉阳区","789","1138");

subcat2[1083] = new Array("武昌区","789","1139");

subcat2[1084] = new Array("青山区","789","1140");

subcat2[1085] = new Array("洪山区","789","1141");

subcat2[1086] = new Array("东西湖区","789","1142");

subcat2[1087] = new Array("汉南区","789","1143");

subcat2[1088] = new Array("蔡甸区","789","1144");

subcat2[1089] = new Array("江夏区","789","1145");

subcat2[1090] = new Array("黄陂区","789","1146");

subcat2[1091] = new Array("新洲区","789","1147");

subcat2[1092] = new Array("黄石港","793","1148");

subcat2[1093] = new Array("西塞山","793","1149");

subcat2[1094] = new Array("下陆区","793","1150");

subcat2[1095] = new Array("铁山区","793","1151");

subcat2[1096] = new Array("大冶","793","1152");

subcat2[1097] = new Array("阳新县","793","1153");

subcat2[1098] = new Array("襄城区","915","1154");

subcat2[1099] = new Array("樊城区","915","1155");

subcat2[1100] = new Array("襄阳区","915","1156");

subcat2[1101] = new Array("老河口","915","1157");

subcat2[1102] = new Array("枣阳市","915","1158");

subcat2[1103] = new Array("宜城市","915","1159");

subcat2[1104] = new Array("南漳县","915","1160");

subcat2[1105] = new Array("谷城县","915","1161");

subcat2[1106] = new Array("保康县","915","1162");

subcat2[1107] = new Array("茅箭区","914","1163");

subcat2[1108] = new Array("张湾区","914","1164");

subcat2[1109] = new Array("丹江口","914","1165");

subcat2[1110] = new Array("郧县","914","1166");

subcat2[1111] = new Array("郧西县","914","1167");

subcat2[1112] = new Array("竹山县","914","1168");

subcat2[1113] = new Array("竹溪县","914","1169");

subcat2[1114] = new Array("房县","914","1170");

subcat2[1115] = new Array("沙市区","913","1171");

subcat2[1116] = new Array("荆州区","913","1172");

subcat2[1117] = new Array("石首市","913","1173");

subcat2[1118] = new Array("洪湖市","913","1174");

subcat2[1119] = new Array("松滋市","913","1175");

subcat2[1120] = new Array("公安县","913","1176");

subcat2[1121] = new Array("监利县","913","1177");

subcat2[1122] = new Array("江陵县","913","1178");

subcat2[1123] = new Array("西陵区","790","1179");

subcat2[1124] = new Array("伍家岗","790","1180");

subcat2[1125] = new Array("点军区","790","1181");

subcat2[1126] = new Array("猇亭区","790","1182");

subcat2[1127] = new Array("夷陵区","790","1183");

subcat2[1128] = new Array("宜都市","790","1184");

subcat2[1129] = new Array("当阳市","790","1185");

subcat2[1130] = new Array("枝江市","790","1186");

subcat2[1131] = new Array("远安县","790","1187");

subcat2[1132] = new Array("兴山县","790","1188");

subcat2[1133] = new Array("秭归县","790","1189");

subcat2[1134] = new Array("长阳自治县","790","1190");

subcat2[1135] = new Array("五峰自治县","790","1191");

subcat2[1136] = new Array("东宝区","792","1192");

subcat2[1137] = new Array("掇刀区","792","1193");

subcat2[1138] = new Array("钟祥市","792","1194");

subcat2[1139] = new Array("京山县","792","1195");

subcat2[1140] = new Array("沙洋县","792","1196");

subcat2[1141] = new Array("芙蓉区","794","1197");

subcat2[1142] = new Array("天心区","794","1198");

subcat2[1143] = new Array("岳麓区","794","1199");

subcat2[1144] = new Array("开福区","794","1200");

subcat2[1145] = new Array("雨花区","794","1201");

subcat2[1146] = new Array("长沙县","794","1203");

subcat2[1147] = new Array("望城县","794","1204");

subcat2[1148] = new Array("宁乡县","794","1205");

subcat2[1149] = new Array("荷塘区","801","1206");

subcat2[1150] = new Array("芦淞区","801","1207");

subcat2[1151] = new Array("石峰区","801","1208");

subcat2[1152] = new Array("天元区","801","1209");

subcat2[1153] = new Array("醴陵市","801","1210");

subcat2[1154] = new Array("株洲县","801","1211");

subcat2[1155] = new Array("攸县","801","1212");

subcat2[1156] = new Array("茶陵县","801","1213");

subcat2[1157] = new Array("炎陵县","801","1214");

subcat2[1158] = new Array("雨湖区","796","1215");

subcat2[1159] = new Array("岳塘区","796","1216");

subcat2[1160] = new Array("湘乡市","796","1217");

subcat2[1161] = new Array("韶山市","796","1218");

subcat2[1162] = new Array("湘潭县","796","1219");

subcat2[1163] = new Array("珠晖区","795","1220");

subcat2[1164] = new Array("雁峰区","795","1221");

subcat2[1165] = new Array("石鼓区","795","1222");

subcat2[1166] = new Array("蒸湘区","795","1223");

subcat2[1167] = new Array("南岳区","795","1224");

subcat2[1168] = new Array("耒阳市","795","1225");

subcat2[1169] = new Array("常宁市","795","1226");

subcat2[1170] = new Array("衡阳县","795","1227");

subcat2[1171] = new Array("衡南县","795","1228");

subcat2[1172] = new Array("衡山县","795","1229");

subcat2[1173] = new Array("衡东县","795","1230");

subcat2[1174] = new Array("祁东县","795","1231");

subcat2[1175] = new Array("岳阳楼区","802","1232");

subcat2[1176] = new Array("云溪区","802","1233");

subcat2[1177] = new Array("君山区","802","1234");

subcat2[1178] = new Array("汨罗市","802","1235");

subcat2[1179] = new Array("临湘市","802","1236");

subcat2[1180] = new Array("岳阳县","802","1237");

subcat2[1181] = new Array("华容县","802","1238");

subcat2[1182] = new Array("湘阴县","802","1239");

subcat2[1183] = new Array("平江县","802","1240");

subcat2[1184] = new Array("武陵区","798","1241");

subcat2[1185] = new Array("鼎城区","798","1242");

subcat2[1186] = new Array("津市市","798","1243");

subcat2[1187] = new Array("安乡县","798","1244");

subcat2[1188] = new Array("汉寿县","798","1245");

subcat2[1189] = new Array("澧县","798","1246");

subcat2[1190] = new Array("临澧县","798","1247");

subcat2[1191] = new Array("桃源县","798","1248");

subcat2[1192] = new Array("石门县","798","1249");

subcat2[1193] = new Array("永定区","803","1250");

subcat2[1194] = new Array("武陵源区","803","1251");

subcat2[1195] = new Array("慈利县","803","1252");

subcat2[1196] = new Array("桑植县","803","1253");

subcat2[1197] = new Array("北湖区","797","1254");

subcat2[1198] = new Array("苏仙区","797","1255");

subcat2[1199] = new Array("资兴市","797","1256");

subcat2[1200] = new Array("桂阳县","797","1257");

subcat2[1201] = new Array("宜章县","797","1258");

subcat2[1202] = new Array("永兴县","797","1259");

subcat2[1203] = new Array("嘉禾县","797","1260");

subcat2[1204] = new Array("临武县","797","1261");

subcat2[1205] = new Array("汝城县","797","1262");

subcat2[1206] = new Array("桂东县","797","1263");

subcat2[1207] = new Array("安仁县","797","1264");

subcat2[1208] = new Array("零陵区","800","1265");

subcat2[1209] = new Array("冷水滩","800","1266");

subcat2[1210] = new Array("祁阳县","800","1267");

subcat2[1211] = new Array("东安县","800","1268");

subcat2[1212] = new Array("双牌县","800","1269");

subcat2[1213] = new Array("道县","800","1270");

subcat2[1214] = new Array("江永县","800","1271");

subcat2[1215] = new Array("宁远县","800","1272");

subcat2[1216] = new Array("蓝山县","800","1273");

subcat2[1217] = new Array("新田县","800","1274");

subcat2[1218] = new Array("江华自治县","800","1275");

subcat2[1219] = new Array("鹤城区","799","1276");

subcat2[1220] = new Array("河西新区","799","1277");

subcat2[1221] = new Array("沅陵县","799","1278");

subcat2[1222] = new Array("辰溪县","799","1279");

subcat2[1223] = new Array("溆浦县","799","1280");

subcat2[1224] = new Array("中方县","799","1281");

subcat2[1225] = new Array("会同县","799","1282");

subcat2[1226] = new Array("麻阳自治县","799","1283");

subcat2[1227] = new Array("新晃自治县","799","1284");

subcat2[1228] = new Array("芷江自治县","799","1285");

subcat2[1229] = new Array("靖州自治县","799","1286");

subcat2[1230] = new Array("通道自治县","799","1287");

subcat2[1231] = new Array("越秀区","744","1288");

subcat2[1232] = new Array("荔湾区","744","1289");

subcat2[1233] = new Array("海珠区","744","1290");

subcat2[1234] = new Array("天河区","744","1291");

subcat2[1235] = new Array("白云区","744","1292");

subcat2[1236] = new Array("黄埔区","744","1293");

subcat2[1237] = new Array("番禺区","744","1294");

subcat2[1238] = new Array("花都区","744","1295");

subcat2[1239] = new Array("南沙区","744","1296");

subcat2[1240] = new Array("萝岗区","744","1297");

subcat2[1241] = new Array("增城市","744","1298");

subcat2[1242] = new Array("从化市","744","1299");

subcat2[1243] = new Array("福田区","755","1300");

subcat2[1244] = new Array("罗湖区","755","1301");

subcat2[1245] = new Array("南山区","755","1302");

subcat2[1246] = new Array("宝安区","755","1303");

subcat2[1247] = new Array("龙岗区","755","1304");

subcat2[1248] = new Array("盐田区","755","1305");

subcat2[1249] = new Array("香洲区","761","1306");

subcat2[1250] = new Array("斗门区","761","1307");

subcat2[1251] = new Array("金湾区","761","1308");

subcat2[1252] = new Array("金平区","752","1309");

subcat2[1253] = new Array("龙湖区","752","1310");

subcat2[1254] = new Array("濠江区","752","1311");

subcat2[1255] = new Array("潮阳区","752","1312");

subcat2[1256] = new Array("潮南区","752","1313");

subcat2[1257] = new Array("澄海区","752","1314");

subcat2[1258] = new Array("南澳县","752","1315");

subcat2[1259] = new Array("浈江区","754","1316");

subcat2[1260] = new Array("武江区","754","1317");

subcat2[1261] = new Array("曲江区","754","1318");

subcat2[1262] = new Array("始兴县","754","1321");

subcat2[1263] = new Array("仁化县","754","1322");

subcat2[1264] = new Array("翁源县","754","1323");

subcat2[1265] = new Array("新丰县","754","1324");

subcat2[1266] = new Array("乳源县","754","1325");

subcat2[1267] = new Array("禅城区","743","1326");

subcat2[1268] = new Array("南海区","743","1327");

subcat2[1269] = new Array("顺德区","743","1328");

subcat2[1270] = new Array("三水区","743","1329");

subcat2[1271] = new Array("高明区","743","1330");

subcat2[1272] = new Array("江海区","747","1331");

subcat2[1273] = new Array("蓬江区","747","1332");

subcat2[1274] = new Array("新会区","747","1333");

subcat2[1275] = new Array("鹤山市","747","1336");

subcat2[1276] = new Array("赤坎区","757","1338");

subcat2[1277] = new Array("霞山区","757","1339");

subcat2[1278] = new Array("坡头区","757","1340");

subcat2[1279] = new Array("麻章区","757","1341");

subcat2[1280] = new Array("开发区","757","1342");

subcat2[1281] = new Array("雷州市","757","1343");

subcat2[1282] = new Array("吴川市","757","1344");

subcat2[1283] = new Array("遂溪县","757","1345");

subcat2[1284] = new Array("徐闻县","757","1346");

subcat2[1285] = new Array("茂南区","749","1347");

subcat2[1286] = new Array("茂港区","749","1348");

subcat2[1287] = new Array("高州市区","749","1350");

subcat2[1288] = new Array("信宜市区","749","1351");

subcat2[1289] = new Array("电白县","749","1352");

subcat2[1290] = new Array("端州区","759","1353");

subcat2[1291] = new Array("鼎湖区","759","1354");

subcat2[1292] = new Array("高要市","759","1355");

subcat2[1293] = new Array("四会市","759","1356");

subcat2[1294] = new Array("广宁县","759","1357");

subcat2[1295] = new Array("怀集县","759","1358");

subcat2[1296] = new Array("封开县","759","1359");

subcat2[1297] = new Array("德庆县","759","1360");

subcat2[1298] = new Array("惠城区","746","1361");

subcat2[1299] = new Array("惠阳区","746","1362");

subcat2[1300] = new Array("博罗县","746","1363");

subcat2[1301] = new Array("惠东县","746","1364");

subcat2[1302] = new Array("龙门县","746","1365");

subcat2[1303] = new Array("梅江区","750","1366");

subcat2[1304] = new Array("兴宁市","750","1367");

subcat2[1305] = new Array("梅县","750","1368");

subcat2[1306] = new Array("大埔县","750","1369");

subcat2[1307] = new Array("丰顺县","750","1370");

subcat2[1308] = new Array("五华县","750","1371");

subcat2[1309] = new Array("平远县","750","1372");

subcat2[1310] = new Array("蕉岭县","750","1373");

subcat2[1311] = new Array("市城区","753","1374");

subcat2[1312] = new Array("陆丰市","753","1375");

subcat2[1313] = new Array("海丰县","753","1376");

subcat2[1314] = new Array("陆河县","753","1377");

subcat2[1315] = new Array("源城区","745","1378");

subcat2[1316] = new Array("紫金县","745","1379");

subcat2[1317] = new Array("龙川县","745","1380");

subcat2[1318] = new Array("连平县","745","1381");

subcat2[1319] = new Array("和平县","745","1382");

subcat2[1320] = new Array("东源县","745","1383");

subcat2[1321] = new Array("江城区","756","1384");

subcat2[1322] = new Array("阳春市","756","1385");

subcat2[1323] = new Array("阳东县","756","1386");

subcat2[1324] = new Array("海陵岛试验区","756","1387");

subcat2[1325] = new Array("清城区","751","1388");

subcat2[1326] = new Array("英德","751","1389");

subcat2[1327] = new Array("连州市","751","1390");

subcat2[1328] = new Array("佛冈县","751","1391");

subcat2[1329] = new Array("阳山县","751","1392");

subcat2[1330] = new Array("清新县","751","1393");

subcat2[1331] = new Array("连山壮族瑶族自治县","751","1394");

subcat2[1332] = new Array("连南瑶族自治县","751","1395");

subcat2[1333] = new Array("湘桥区","741","1396");

subcat2[1334] = new Array("潮安县","741","1397");

subcat2[1335] = new Array("饶平县","741","1398");

subcat2[1336] = new Array("榕城区","748","1399");

subcat2[1337] = new Array("东山区","748","1400");

subcat2[1338] = new Array("揭东县","748","1401");

subcat2[1339] = new Array("揭西县","748","1402");

subcat2[1340] = new Array("惠来县","748","1403");

subcat2[1341] = new Array("兴宁区","765","1404");

subcat2[1342] = new Array("青秀区","765","1405");

subcat2[1343] = new Array("江南区","765","1406");

subcat2[1344] = new Array("西乡塘区","765","1407");

subcat2[1345] = new Array("良庆区","765","1408");

subcat2[1346] = new Array("邕宁区","765","1409");

subcat2[1347] = new Array("武鸣县","765","1410");

subcat2[1348] = new Array("隆安县","765","1411");

subcat2[1349] = new Array("马山县","765","1412");

subcat2[1350] = new Array("上林县","765","1413");

subcat2[1351] = new Array("宾阳县","765","1414");

subcat2[1352] = new Array("横县","765","1415");

subcat2[1353] = new Array("城中区","764","1416");

subcat2[1354] = new Array("鱼峰区","764","1417");

subcat2[1355] = new Array("柳南区","764","1418");

subcat2[1356] = new Array("柳北区","764","1419");

subcat2[1357] = new Array("柳江县","764","1420");

subcat2[1358] = new Array("柳城县","764","1421");

subcat2[1359] = new Array("鹿寨县","764","1422");

subcat2[1360] = new Array("融安县","764","1423");

subcat2[1361] = new Array("融水苗族自治县","764","1424");

subcat2[1362] = new Array("三江侗族自治县","764","1425");

subcat2[1363] = new Array("秀峰区","762","1426");

subcat2[1364] = new Array("叠彩区","762","1427");

subcat2[1365] = new Array("象山区","762","1428");

subcat2[1366] = new Array("七星区","762","1429");

subcat2[1367] = new Array("雁山区","762","1430");

subcat2[1368] = new Array("阳朔县","762","1431");

subcat2[1369] = new Array("临桂县","762","1432");

subcat2[1370] = new Array("灵川县","762","1433");

subcat2[1371] = new Array("全州县","762","1434");

subcat2[1372] = new Array("兴安县","762","1435");

subcat2[1373] = new Array("永福县","762","1436");

subcat2[1374] = new Array("灌阳县","762","1437");

subcat2[1375] = new Array("资源县","762","1438");

subcat2[1376] = new Array("平乐县","762","1439");

subcat2[1377] = new Array("荔浦县","762","1440");

subcat2[1378] = new Array("龙胜县","762","1441");

subcat2[1379] = new Array("恭城瑶族自治县","762","1442");

subcat2[1380] = new Array("万秀区","1075","1443");

subcat2[1381] = new Array("蝶山区","1075","1444");

subcat2[1382] = new Array("长洲区","1075","1445");

subcat2[1383] = new Array("岑溪市","1075","1446");

subcat2[1384] = new Array("苍梧县","1075","1447");

subcat2[1385] = new Array("藤县","1075","1448");

subcat2[1386] = new Array("蒙山县","1075","1449");

subcat2[1387] = new Array("海城区","763","1450");

subcat2[1388] = new Array("银海区","763","1451");

subcat2[1389] = new Array("铁山港区","763","1452");

subcat2[1390] = new Array("合浦县","763","1453");

subcat2[1391] = new Array("防城港","763","1454");

subcat2[1392] = new Array("钦南区","1076","1455");

subcat2[1393] = new Array("钦北区","1076","1456");

subcat2[1394] = new Array("灵山县","1076","1457");

subcat2[1395] = new Array("浦北县","1076","1458");

subcat2[1396] = new Array("港北区","1077","1459");

subcat2[1397] = new Array("港南区","1077","1460");

subcat2[1398] = new Array("覃塘区","1077","1461");

subcat2[1399] = new Array("桂平市","1077","1462");

subcat2[1400] = new Array("平南县","1077","1463");

subcat2[1401] = new Array("玉州区","766","1464");

subcat2[1402] = new Array("北流市","766","1465");

subcat2[1403] = new Array("容县","766","1466");

subcat2[1404] = new Array("陆川县","766","1467");

subcat2[1405] = new Array("博白县","766","1468");

subcat2[1406] = new Array("兴业县","766","1469");

subcat2[1407] = new Array("龙华区","771","1470");

subcat2[1408] = new Array("秀英区","771","1471");

subcat2[1409] = new Array("琼山区","771","1472");

subcat2[1410] = new Array("美兰区","771","1473");

subcat2[1411] = new Array("儋州市","772","1476");

subcat2[1412] = new Array("文昌市","772","1477");

subcat2[1413] = new Array("东方市","772","1479");

subcat2[1414] = new Array("定安县","772","1480");

subcat2[1415] = new Array("屯昌县","772","1481");

subcat2[1416] = new Array("临高县","772","1483");

subcat2[1417] = new Array("白沙黎族自治县","772","1485");

subcat2[1418] = new Array("昌江黎族自治县","772","1486");

subcat2[1419] = new Array("乐东黎族自治县","772","1487");

subcat2[1420] = new Array("渝中区","869","1491");

subcat2[1421] = new Array("大渡口区","869","1492");

subcat2[1422] = new Array("江北区","869","1493");

subcat2[1423] = new Array("沙坪坝区","869","1494");

subcat2[1424] = new Array("九龙坡区","869","1495");

subcat2[1425] = new Array("南岸区","869","1496");

subcat2[1426] = new Array("北碚区","869","1497");

subcat2[1427] = new Array("万盛区","869","1498");

subcat2[1428] = new Array("双桥区","869","1499");

subcat2[1429] = new Array("渝北区","869","1500");

subcat2[1430] = new Array("巴南区","869","1501");

subcat2[1431] = new Array("万州区","869","1502");

subcat2[1432] = new Array("涪陵区","869","1503");

subcat2[1433] = new Array("黔江区","869","1504");

subcat2[1434] = new Array("长寿区","869","1505");

subcat2[1435] = new Array("江津区","869","1506");

subcat2[1436] = new Array("合川区","869","1507");

subcat2[1437] = new Array("永川区","869","1508");

subcat2[1438] = new Array("南川区","869","1509");

subcat2[1439] = new Array("丰都区","869","1510");

subcat2[1440] = new Array("垫江区","869","1511");

subcat2[1441] = new Array("铜梁县","869","1512");

subcat2[1442] = new Array("大足县","869","1513");

subcat2[1443] = new Array("荣昌县","869","1514");

subcat2[1444] = new Array("璧山县","869","1515");

subcat2[1445] = new Array("武隆县","869","1517");

subcat2[1446] = new Array("城口县","869","1519");

subcat2[1447] = new Array("梁平县","869","1520");

subcat2[1448] = new Array("开巫溪县","869","1521");

subcat2[1449] = new Array("巫山县","869","1522");

subcat2[1450] = new Array("奉节县","869","1523");

subcat2[1451] = new Array("云阳县","869","1524");

subcat2[1452] = new Array("忠县","869","1525");

subcat2[1453] = new Array("锦江区","849","1530");

subcat2[1454] = new Array("青羊区","849","1531");

subcat2[1455] = new Array("金牛区","849","1532");

subcat2[1456] = new Array("武侯区","849","1533");

subcat2[1457] = new Array("成华区","849","1534");

subcat2[1458] = new Array("龙泉驿区","849","1535");

subcat2[1459] = new Array("青白江区","849","1536");

subcat2[1460] = new Array("新都区","849","1537");

subcat2[1461] = new Array("温江区","849","1538");

subcat2[1462] = new Array("彭州市","849","1540");

subcat2[1463] = new Array("邛崃市","849","1541");

subcat2[1464] = new Array("崇州市","849","1542");

subcat2[1465] = new Array("金堂县","849","1543");

subcat2[1466] = new Array("双流县","849","1544");

subcat2[1467] = new Array("郫县","849","1545");

subcat2[1468] = new Array("大邑县","849","1546");

subcat2[1469] = new Array("蒲江区","849","1547");

subcat2[1470] = new Array("新津县","849","1548");

subcat2[1471] = new Array("自流井区","973","1549");

subcat2[1472] = new Array("贡井区","973","1550");

subcat2[1473] = new Array("大安区","973","1551");

subcat2[1474] = new Array("沿滩区","973","1552");

subcat2[1475] = new Array("荣县","973","1553");

subcat2[1476] = new Array("高新区","973","1554");

subcat2[1477] = new Array("东区","1092","1555");

subcat2[1478] = new Array("西区","1092","1556");

subcat2[1479] = new Array("仁和区","1092","1557");

subcat2[1480] = new Array("米易县","1092","1558");

subcat2[1481] = new Array("盐边县","1092","1559");

subcat2[1482] = new Array("旌阳区","961","1560");

subcat2[1483] = new Array("广汉市","961","1561");

subcat2[1484] = new Array("什邡市","961","1562");

subcat2[1485] = new Array("绵竹市","961","1563");

subcat2[1486] = new Array("罗江县","961","1564");

subcat2[1487] = new Array("中江县","961","1565");

subcat2[1488] = new Array("涪城区","850","1566");

subcat2[1489] = new Array("游仙区","850","1567");

subcat2[1490] = new Array("三台县","850","1569");

subcat2[1491] = new Array("盐亭县","850","1570");

subcat2[1492] = new Array("安县","850","1571");

subcat2[1493] = new Array("梓潼县","850","1572");

subcat2[1494] = new Array("平武县","850","1573");

subcat2[1495] = new Array("利州区","965","1575");

subcat2[1496] = new Array("元坝区","965","1576");

subcat2[1497] = new Array("朝天区","965","1577");

subcat2[1498] = new Array("旺苍县","965","1578");

subcat2[1499] = new Array("青川县","965","1579");

subcat2[1500] = new Array("剑阁县","965","1580");

subcat2[1501] = new Array("苍溪县","965","1581");

subcat2[1502] = new Array("船山区","971","1582");

subcat2[1503] = new Array("安居区","971","1583");

subcat2[1504] = new Array("蓬溪县","971","1584");

subcat2[1505] = new Array("射洪县","971","1585");

subcat2[1506] = new Array("大英县","971","1586");

subcat2[1507] = new Array("市中区","1091","1587");

subcat2[1508] = new Array("东兴区","1091","1588");

subcat2[1509] = new Array("威远县","1091","1589");

subcat2[1510] = new Array("资中县","1091","1590");

subcat2[1511] = new Array("隆昌县","1091","1591");

subcat2[1512] = new Array("市中区","967","1592");

subcat2[1513] = new Array("山湾地区","967","1593");

subcat2[1514] = new Array("五通桥","967","1594");

subcat2[1515] = new Array("金口河","967","1595");

subcat2[1516] = new Array("峨眉山","967","1596");

subcat2[1517] = new Array("犍为县","967","1597");

subcat2[1518] = new Array("井研县","967","1598");

subcat2[1519] = new Array("夹江县","967","1599");

subcat2[1520] = new Array("沐川县","967","1600");

subcat2[1521] = new Array("峨边彝族自治县","967","1601");

subcat2[1522] = new Array("马边彝族自治县","967","1602");

subcat2[1523] = new Array("顺庆区","969","1603");

subcat2[1524] = new Array("高坪区","969","1604");

subcat2[1525] = new Array("嘉陵区","969","1605");

subcat2[1526] = new Array("阆中市","969","1606");

subcat2[1527] = new Array("南部县","969","1607");

subcat2[1528] = new Array("营山县","969","1608");

subcat2[1529] = new Array("蓬安县","969","1609");

subcat2[1530] = new Array("仪陇县","969","1610");

subcat2[1531] = new Array("西充县","969","1611");

subcat2[1532] = new Array("翠屏区","853","1612");

subcat2[1533] = new Array("宜宾县","853","1613");

subcat2[1534] = new Array("南溪县","853","1614");

subcat2[1535] = new Array("江安县","853","1615");

subcat2[1536] = new Array("长宁县","853","1616");

subcat2[1537] = new Array("高县","853","1617");

subcat2[1538] = new Array("珙县","853","1618");

subcat2[1539] = new Array("筠连县","853","1619");

subcat2[1540] = new Array("兴文县","853","1620");

subcat2[1541] = new Array("屏山县","853","1621");

subcat2[1542] = new Array("广安区","852","1622");

subcat2[1543] = new Array("华蓥市","852","1623");

subcat2[1544] = new Array("岳池县","852","1624");

subcat2[1545] = new Array("武胜县","852","1625");

subcat2[1546] = new Array("邻水县","852","1626");

subcat2[1547] = new Array("雨城区","1093","1627");

subcat2[1548] = new Array("名山县","1093","1628");

subcat2[1549] = new Array("荥经县","1093","1629");

subcat2[1550] = new Array("汉源县","1093","1630");

subcat2[1551] = new Array("石棉县","1093","1631");

subcat2[1552] = new Array("天全县","1093","1632");

subcat2[1553] = new Array("芦山县","1093","1633");

subcat2[1554] = new Array("宝兴县","1093","1634");

subcat2[1555] = new Array("马尔康","960","1635");

subcat2[1556] = new Array("汶川县","960","1636");

subcat2[1557] = new Array("理县","960","1637");

subcat2[1558] = new Array("茂县","960","1638");

subcat2[1559] = new Array("松潘县","960","1639");

subcat2[1560] = new Array("九寨沟县","960","1640");

subcat2[1561] = new Array("金川县","960","1641");

subcat2[1562] = new Array("小金县","960","1642");

subcat2[1563] = new Array("黑水县","960","1643");

subcat2[1564] = new Array("壤塘县","960","1644");

subcat2[1565] = new Array("阿坝县","960","1645");

subcat2[1566] = new Array("若尔盖县","960","1646");

subcat2[1567] = new Array("红原县","960","1647");

subcat2[1568] = new Array("乌当区","767","1648");

subcat2[1569] = new Array("南明区","767","1649");

subcat2[1570] = new Array("云岩区","767","1650");

subcat2[1571] = new Array("花溪区","767","1651");

subcat2[1572] = new Array("白云区","767","1652");

subcat2[1573] = new Array("小河区","767","1653");

subcat2[1574] = new Array("清镇市","767","1654");

subcat2[1575] = new Array("开阳县","767","1655");

subcat2[1576] = new Array("息烽县","767","1656");

subcat2[1577] = new Array("修文县","767","1657");

subcat2[1578] = new Array("钟山区","768","1658");

subcat2[1579] = new Array("六枝特区","768","1659");

subcat2[1580] = new Array("水城县","768","1660");

subcat2[1581] = new Array("盘县","768","1661");

subcat2[1582] = new Array("红花岗区","770","1662");

subcat2[1583] = new Array("汇川区","770","1663");

subcat2[1584] = new Array("赤水市","770","1664");

subcat2[1585] = new Array("仁怀市","770","1665");

subcat2[1586] = new Array("遵义县","770","1666");

subcat2[1587] = new Array("桐梓县","770","1667");

subcat2[1588] = new Array("绥阳县","770","1668");

subcat2[1589] = new Array("正安县","770","1669");

subcat2[1590] = new Array("凤冈县","770","1670");

subcat2[1591] = new Array("湄潭县","770","1671");

subcat2[1592] = new Array("余庆县","770","1672");

subcat2[1593] = new Array("习水县","770","1673");

subcat2[1594] = new Array("道真仡佬族苗族自治县","770","1674");

subcat2[1595] = new Array("务川仡佬族苗族自治县","770","1675");

subcat2[1596] = new Array("西秀区","984","1676");

subcat2[1597] = new Array("平坝县","984","1677");

subcat2[1598] = new Array("普定县","984","1678");

subcat2[1599] = new Array("黄果树镇","984","1679");

subcat2[1600] = new Array("关岭布依族苗族自治县","984","1680");

subcat2[1601] = new Array("紫云苗族布依族自治县","984","1681");

subcat2[1602] = new Array("铜仁市","987","1682");

subcat2[1603] = new Array("江口县","987","1683");

subcat2[1604] = new Array("石阡县","987","1684");

subcat2[1605] = new Array("思南县","987","1685");

subcat2[1606] = new Array("德江县","987","1686");

subcat2[1607] = new Array("玉屏侗族自治县","987","1687");

subcat2[1608] = new Array("印江土家族苗族自治县","987","1688");

subcat2[1609] = new Array("沿河土家族自治县","987","1689");

subcat2[1610] = new Array("松桃苗族自治县","987","1690");

subcat2[1611] = new Array("万山特区","987","1691");

subcat2[1612] = new Array("毕节市","769","1692");

subcat2[1613] = new Array("大方县","769","1693");

subcat2[1614] = new Array("黔西县","769","1694");

subcat2[1615] = new Array("金沙县","769","1695");

subcat2[1616] = new Array("织金县","769","1696");

subcat2[1617] = new Array("纳雍县","769","1697");

subcat2[1618] = new Array("赫章县","769","1698");

subcat2[1619] = new Array("威宁彝族回族苗族自治县","769","1699");

subcat2[1620] = new Array("五华区","860","1700");

subcat2[1621] = new Array("盘龙区","860","1701");

subcat2[1622] = new Array("官渡区","860","1702");

subcat2[1623] = new Array("西山区","860","1703");

subcat2[1624] = new Array("东川区","860","1704");

subcat2[1625] = new Array("安宁市","860","1705");

subcat2[1626] = new Array("呈贡县","860","1706");

subcat2[1627] = new Array("晋宁县","860","1707");

subcat2[1628] = new Array("富民县","860","1708");

subcat2[1629] = new Array("宜良县","860","1709");

subcat2[1630] = new Array("嵩明县","860","1710");

subcat2[1631] = new Array("石林县","860","1711");

subcat2[1632] = new Array("禄劝县","860","1712");

subcat2[1633] = new Array("寻甸县","860","1713");

subcat2[1634] = new Array("古城","861","1714");

subcat2[1635] = new Array("永胜县","861","1715");

subcat2[1636] = new Array("华坪县","861","1716");

subcat2[1637] = new Array("玉龙县","861","1717");

subcat2[1638] = new Array("宁蒗县","861","1718");

subcat2[1639] = new Array("城关区","855","1719");

subcat2[1640] = new Array("林周县","855","1720");

subcat2[1641] = new Array("当雄县","855","1721");

subcat2[1642] = new Array("尼木县","855","1722");

subcat2[1643] = new Array("曲水县","855","1723");

subcat2[1644] = new Array("堆龙德庆县","855","1724");

subcat2[1645] = new Array("达孜县","855","1725");

subcat2[1646] = new Array("墨竹工卡县","855","1726");

subcat2[1647] = new Array("噶尔县","856","1727");

subcat2[1648] = new Array("普兰县","856","1728");

subcat2[1649] = new Array("札达县","856","1729");

subcat2[1650] = new Array("日土县","856","1730");

subcat2[1651] = new Array("革吉县","856","1731");

subcat2[1652] = new Array("改则县","856","1732");

subcat2[1653] = new Array("措勤县","856","1733");

subcat2[1654] = new Array("未央区","844","1734");

subcat2[1655] = new Array("新城区","844","1735");

subcat2[1656] = new Array("碑林区","844","1736");

subcat2[1657] = new Array("莲湖区","844","1737");

subcat2[1658] = new Array("灞桥生态区","844","1738");

subcat2[1659] = new Array("雁塔区","844","1739");

subcat2[1660] = new Array("阎良区","844","1740");

subcat2[1661] = new Array("临潼区","844","1741");

subcat2[1662] = new Array("长安区","844","1742");

subcat2[1663] = new Array("西高新开发区","844","1743");

subcat2[1664] = new Array("渭滨区","847","1747");

subcat2[1665] = new Array("金台区","847","1748");

subcat2[1666] = new Array("陈仓区","847","1749");

subcat2[1667] = new Array("凤翔县","847","1750");

subcat2[1668] = new Array("岐山县","847","1751");

subcat2[1669] = new Array("扶风县","847","1752");

subcat2[1670] = new Array("眉县","847","1753");

subcat2[1671] = new Array("陇县","847","1754");

subcat2[1672] = new Array("千阳县","847","1755");

subcat2[1673] = new Array("麟游县","847","1756");

subcat2[1674] = new Array("凤县","847","1757");

subcat2[1675] = new Array("太白县","847","1758");

subcat2[1676] = new Array("秦都区","845","1759");

subcat2[1677] = new Array("杨陵区","845","1760");

subcat2[1678] = new Array("渭城区","845","1761");

subcat2[1679] = new Array("兴平市","845","1762");

subcat2[1680] = new Array("三原县","845","1763");

subcat2[1681] = new Array("泾阳县","845","1764");

subcat2[1682] = new Array("乾县","845","1765");

subcat2[1683] = new Array("礼泉县","845","1766");

subcat2[1684] = new Array("永寿县","845","1767");

subcat2[1685] = new Array("彬县","845","1768");

subcat2[1686] = new Array("长武县","845","1769");

subcat2[1687] = new Array("旬邑县","845","1770");

subcat2[1688] = new Array("淳化县","845","1771");

subcat2[1689] = new Array("武功县","845","1772");

subcat2[1690] = new Array("白塔区","846","1773");

subcat2[1691] = new Array("延长县","846","1774");

subcat2[1692] = new Array("延川县","846","1775");

subcat2[1693] = new Array("子长县","846","1776");

subcat2[1694] = new Array("安塞县","846","1777");

subcat2[1695] = new Array("志丹县","846","1778");

subcat2[1696] = new Array("吴起县","846","1779");

subcat2[1697] = new Array("甘泉县","846","1780");

subcat2[1698] = new Array("富县","846","1781");

subcat2[1699] = new Array("洛川县","846","1782");

subcat2[1700] = new Array("宜川县","846","1783");

subcat2[1701] = new Array("黄龙县","846","1784");

subcat2[1702] = new Array("黄陵县","846","1785");

subcat2[1703] = new Array("汉台区","1006","1786");

subcat2[1704] = new Array("南郑县","1006","1787");

subcat2[1705] = new Array("城固县","1006","1788");

subcat2[1706] = new Array("洋县","1006","1789");

subcat2[1707] = new Array("西乡县","1006","1790");

subcat2[1708] = new Array("勉县","1006","1791");

subcat2[1709] = new Array("宁强县","1006","1792");

subcat2[1710] = new Array("略阳县","1006","1793");

subcat2[1711] = new Array("镇巴县","1006","1794");

subcat2[1712] = new Array("留坝县","1006","1795");

subcat2[1713] = new Array("佛坪县","1006","1796");

subcat2[1714] = new Array("榆阳区","1007","1797");

subcat2[1715] = new Array("神木县","1007","1798");

subcat2[1716] = new Array("府谷县","1007","1799");

subcat2[1717] = new Array("横山县","1007","1800");

subcat2[1718] = new Array("靖边县","1007","1801");

subcat2[1719] = new Array("定边县","1007","1802");

subcat2[1720] = new Array("绥德县","1007","1803");

subcat2[1721] = new Array("米脂县","1007","1804");

subcat2[1722] = new Array("佳县","1007","1805");

subcat2[1723] = new Array("吴堡县","1007","1806");

subcat2[1724] = new Array("清涧县","1007","1807");

subcat2[1725] = new Array("子洲县","1007","1808");

subcat2[1726] = new Array("城关区","737","1809");

subcat2[1727] = new Array("七里河区","737","1810");

subcat2[1728] = new Array("西固区","737","1811");

subcat2[1729] = new Array("安宁区","737","1812");

subcat2[1730] = new Array("红古区","737","1813");

subcat2[1731] = new Array("永登县","737","1814");

subcat2[1732] = new Array("皋兰县","737","1815");

subcat2[1733] = new Array("榆中县","737","1816");

subcat2[1734] = new Array("秦州区","1074","1817");

subcat2[1735] = new Array("麦积区","1074","1818");

subcat2[1736] = new Array("清水县","1074","1819");

subcat2[1737] = new Array("秦安县","1074","1820");

subcat2[1738] = new Array("甘谷县","1074","1821");

subcat2[1739] = new Array("武山县","1074","1822");

subcat2[1740] = new Array("张家川回族自治县","1074","1823");

subcat2[1741] = new Array("甘州区","895","1824");

subcat2[1742] = new Array("民乐县","895","1825");

subcat2[1743] = new Array("临泽县","895","1826");

subcat2[1744] = new Array("高台县","895","1827");

subcat2[1745] = new Array("山丹县","895","1828");

subcat2[1746] = new Array("肃南裕固族自治县","895","1829");

subcat2[1747] = new Array("肃州区","739","1830");

subcat2[1748] = new Array("玉门市","739","1831");

subcat2[1749] = new Array("敦煌市","739","1832");

subcat2[1750] = new Array("金塔县","739","1833");

subcat2[1751] = new Array("瓜州县","739","1834");

subcat2[1752] = new Array("肃北蒙古族自治县","739","1835");

subcat2[1753] = new Array("阿克塞哈萨克族自治县","739","1836");

subcat2[1754] = new Array("海东地区","832","1837");

subcat2[1755] = new Array("城东区","832","1844");

subcat2[1756] = new Array("城中区","832","1845");

subcat2[1757] = new Array("城西区","832","1846");

subcat2[1758] = new Array("城北区","832","1847");

subcat2[1759] = new Array("湟中县","832","1848");

subcat2[1760] = new Array("湟源县","832","1849");

subcat2[1761] = new Array("兴庆区","828","1851");

subcat2[1762] = new Array("金凤区","828","1852");

subcat2[1763] = new Array("西夏区","828","1853");

subcat2[1764] = new Array("灵武市","828","1854");

subcat2[1765] = new Array("永宁县","828","1855");

subcat2[1766] = new Array("贺兰县","828","1856");

subcat2[1767] = new Array("大武口区","830","1857");

subcat2[1768] = new Array("惠农区","830","1858");

subcat2[1769] = new Array("平罗县","830","1859");

subcat2[1770] = new Array("利通区","831","1860");

subcat2[1771] = new Array("青铜峡市","831","1861");

subcat2[1772] = new Array("盐池县","831","1862");

subcat2[1773] = new Array("同心县","831","1863");

subcat2[1774] = new Array("红寺堡开发区","831","1864");

subcat2[1775] = new Array("原州区","829","1865");

subcat2[1776] = new Array("西吉县","829","1866");

subcat2[1777] = new Array("隆德县","829","1867");

subcat2[1778] = new Array("泾源县","829","1868");

subcat2[1779] = new Array("彭阳县","829","1869");

subcat2[1780] = new Array("天山区","857","1870");

subcat2[1781] = new Array("沙依巴克区","857","1871");

subcat2[1782] = new Array("新市区","857","1872");

subcat2[1783] = new Array("水磨沟区","857","1873");

subcat2[1784] = new Array("头屯河区","857","1874");

subcat2[1785] = new Array("达坂城区","857","1875");

subcat2[1786] = new Array("米东区","857","1876");

subcat2[1787] = new Array("市内","857","1877");

subcat2[1788] = new Array("克拉玛依区","859","1878");

subcat2[1789] = new Array("独山子区","859","1879");

subcat2[1790] = new Array("白碱滩区","859","1880");

subcat2[1791] = new Array("乌尔禾区","859","1881");

subcat2[1792] = new Array("市内","858","1882");

subcat2[1793] = new Array("鄯善县","858","1883");

subcat2[1794] = new Array("托克逊县","858","1884");

subcat2[1795] = new Array("喀什市","1072","1885");

subcat2[1796] = new Array("疏附县","1072","1886");

subcat2[1797] = new Array("疏勒县","1072","1887");

subcat2[1798] = new Array("英吉沙县","1072","1888");

subcat2[1799] = new Array("泽普","1072","1889");

subcat2[1800] = new Array("莎车","1072","1890");

subcat2[1801] = new Array("叶城","1072","1891");

subcat2[1802] = new Array("麦盖提","1072","1892");

subcat2[1803] = new Array("岳普湖","1072","1893");

subcat2[1804] = new Array("伽师","1072","1894");

subcat2[1805] = new Array("巴楚","1072","1895");

subcat2[1806] = new Array("塔什库尔干塔吉克自治县","1072","1896");

subcat2[1807] = new Array("观塘","871","1897");

subcat2[1808] = new Array("离岛","871","1898");

subcat2[1809] = new Array("油尖旺","871","1899");

subcat2[1810] = new Array("中环","871","1900");

subcat2[1811] = new Array("东区","871","1901");

subcat2[1812] = new Array("湾仔","871","1902");

subcat2[1813] = new Array("铜锣湾","871","1903");

subcat2[1814] = new Array("南区","871","1904");

subcat2[1815] = new Array("元朗","871","1905");

subcat2[1816] = new Array("屯门","871","1906");

subcat2[1817] = new Array("葵青","871","1907");

subcat2[1818] = new Array("中西区","871","1908");

subcat2[1819] = new Array("九龙城","871","1909");

subcat2[1820] = new Array("新界","871","1910");

subcat2[1821] = new Array("沙田","871","1911");

subcat2[1822] = new Array("荃湾","871","1912");

subcat2[1823] = new Array("旺角","871","1913");

subcat2[1824] = new Array("赤腊角","871","1914");

subcat2[1825] = new Array("氹仔岛","872","1915");

subcat2[1826] = new Array("路环岛","872","1916");

subcat2[1827] = new Array("东部","872","1917");

subcat2[1828] = new Array("西部","872","1918");

subcat2[1829] = new Array("南部","872","1919");

subcat2[1830] = new Array("北部","872","1920");

subcat2[1831] = new Array("东南部","872","1921");

subcat2[1832] = new Array("东北部","872","1922");

subcat2[1833] = new Array("西南部","872","1923");

subcat2[1834] = new Array("西北部","872","1924");

subcat2[1835] = new Array("松山区","870","1925");

subcat2[1836] = new Array("信义区","870","1926");

subcat2[1837] = new Array("大安区","870","1927");

subcat2[1838] = new Array("中山区","870","1928");

subcat2[1839] = new Array("中正区","870","1929");

subcat2[1840] = new Array("大同区","870","1930");

subcat2[1841] = new Array("万华区","870","1931");

subcat2[1842] = new Array("文山区","870","1932");

subcat2[1843] = new Array("南港区","870","1933");

subcat2[1844] = new Array("内湖区","870","1934");

subcat2[1845] = new Array("士林区","870","1935");

subcat2[1846] = new Array("北投区","870","1936");

subcat2[1847] = new Array("盐埕区","1001","1937");

subcat2[1848] = new Array("鼓山区","1001","1938");

subcat2[1849] = new Array("左营区","1001","1939");

subcat2[1850] = new Array("楠梓区","1001","1940");

subcat2[1851] = new Array("三民区","1001","1941");

subcat2[1852] = new Array("新兴区","1001","1942");

subcat2[1853] = new Array("前金区","1001","1943");

subcat2[1854] = new Array("苓雅区","1001","1944");

subcat2[1855] = new Array("前镇区","1001","1945");

subcat2[1856] = new Array("旗津区","1001","1946");

subcat2[1857] = new Array("小港区","1001","1947");

subcat2[1858] = new Array("西区","1005","1948");

subcat2[1859] = new Array("东区","1005","1949");

subcat2[1860] = new Array("西区","1005","1950");

subcat2[1861] = new Array("南区","1005","1951");

subcat2[1862] = new Array("北区","1005","1952");

subcat2[1863] = new Array("安南区","1005","1953");

subcat2[1864] = new Array("安平区","1005","1954");

subcat2[1865] = new Array("中西区","1005","1955");

subcat2[1866] = new Array("东区","1002","1956");

subcat2[1867] = new Array("西区","1002","1957");

subcat2[1868] = new Array("中部","872","1958");

subcat2[1869] = new Array("韶山冲","918","1959");

subcat2[1870] = new Array("清溪镇","918","1960");

subcat2[1871] = new Array("竹鸡村","918","1961");

subcat2[1872] = new Array("澄迈县","771","1962");

subcat2[1873] = new Array("上虞","1022","1964");

subcat2[1874] = new Array("动力区","782","1965");

subcat2[1875] = new Array("石碣镇","742","1966");

subcat2[1876] = new Array("茶山镇","742","1967");

subcat2[1877] = new Array("洪梅镇","742","1968");

subcat2[1878] = new Array("黄江镇","742","1969");

subcat2[1879] = new Array("万江区","742","1970");

subcat2[1880] = new Array("东城区","742","1971");

subcat2[1881] = new Array("南城区","742","1972");

subcat2[1882] = new Array("大岭山镇","742","1973");

subcat2[1883] = new Array("大朗镇","742","1974");

subcat2[1884] = new Array("道滘镇","742","1975");

subcat2[1885] = new Array("石龙镇","742","1976");

subcat2[1886] = new Array("常平镇","742","1977");

subcat2[1887] = new Array("凤岗镇","742","1978");

subcat2[1888] = new Array("虎门镇","742","1979");

subcat2[1889] = new Array("莞城","742","1980");

subcat2[1890] = new Array("厚街镇","742","1981");

subcat2[1891] = new Array("长安镇","742","1982");

subcat2[1892] = new Array("桥头镇","742","1983");

subcat2[1893] = new Array("塘厦镇","742","1984");

subcat2[1894] = new Array("高埗镇","742","1985");

subcat2[1895] = new Array("樟木头镇","742","1986");

subcat2[1896] = new Array("松山湖科技产业园区","742","1987");

subcat2[1897] = new Array("杏林区","735","1988");

subcat2[1898] = new Array("鼓浪屿区","735","1989");

subcat2[1899] = new Array("开元区","735","1990");

subcat2[1900] = new Array("高新开发区","1013","1994");

subcat2[1901] = new Array("乍浦镇","1050","1995");

subcat2[1902] = new Array("当湖镇","1050","1996");

subcat2[1903] = new Array("三乡镇","760","1997");

subcat2[1904] = new Array("西区","760","1998");

subcat2[1905] = new Array("石岐区","760","1999");

subcat2[1906] = new Array("东区","760","2000");

subcat2[1907] = new Array("三角镇","760","2001");

subcat2[1908] = new Array("小榄镇","760","2002");

subcat2[1909] = new Array("古镇","760","2003");

subcat2[1910] = new Array("沙溪镇","760","2004");

subcat2[1911] = new Array("南头镇","760","2005");

subcat2[1912] = new Array("高新区","849","2006");

subcat2[1913] = new Array("开发区","782","2007");

subcat2[1914] = new Array("尚湖","919","2008");

subcat2[1915] = new Array("虞山镇","919","2009");

subcat2[1916] = new Array("东南开发区","919","2010");

subcat2[1917] = new Array("沙家浜镇","919","2011");

subcat2[1918] = new Array("市北区","1119","2012");

subcat2[1919] = new Array("巴城镇","929","2013");

subcat2[1920] = new Array("花桥镇","929","2014");

subcat2[1921] = new Array("千灯镇","929","2015");

subcat2[1922] = new Array("玉山镇","929","2016");

subcat2[1923] = new Array("张浦镇","929","2017");

subcat2[1924] = new Array("正仪镇","929","2018");

subcat2[1925] = new Array("周市镇","929","2019");

subcat2[1926] = new Array("稠江区","879","2020");

subcat2[1927] = new Array("牯岭镇","1070","2021");

subcat2[1928] = new Array("新区","815","2022");

subcat2[1929] = new Array("燕郊","878","2023");

subcat2[1930] = new Array("五桂山镇","760","2024");

subcat2[1931] = new Array("稠城","879","2025");

subcat2[1932] = new Array("市区","930","2026");

subcat2[1933] = new Array("溧城镇","930","2027");

subcat2[1934] = new Array("天目湖镇 ","930","2028");

subcat2[1935] = new Array("德城区","943","2029");

subcat2[1936] = new Array("经济开发区","943","2030");

subcat2[1937] = new Array("经济技术开发区","1031","2031");

subcat2[1938] = new Array("石浦","1063","2032");

subcat2[1939] = new Array("丹城镇","1063","2033");

subcat2[1940] = new Array("谯城区","881","2034");

subcat2[1941] = new Array("香泉镇","882","2035");

subcat2[1942] = new Array("新昌区","898","2036");

subcat2[1943] = new Array("祥龙区","898","2037");

subcat2[1944] = new Array("长沙区","898","2038");

subcat2[1945] = new Array("川岛镇","904","2039");

subcat2[1946] = new Array("博鳌镇","897","2040");

subcat2[1947] = new Array("官塘","897","2041");

subcat2[1948] = new Array("城关镇","1053","2042");

subcat2[1949] = new Array("安阳镇","1053","2043");

subcat2[1950] = new Array("高新技术产业区","899","2044");

subcat2[1951] = new Array("开发区","903","2046");

subcat2[1952] = new Array("南关区","781","2047");

subcat2[1953] = new Array("天元区","794","2049");

subcat2[1954] = new Array("吉首市","990","2050");

subcat2[1955] = new Array("金坛","808","2052");

subcat2[1956] = new Array("口岸镇","936","2053");

subcat2[1957] = new Array("宜城镇","941","2054");

subcat2[1958] = new Array("金港镇","958","2055");

subcat2[1959] = new Array("句容市","1106","2056");

subcat2[1960] = new Array("茅山镇","1106","2057");

subcat2[1961] = new Array("经济技术开发区","935","2058");

subcat2[1962] = new Array("商贸旅游区","823","2059");

subcat2[1963] = new Array("开发区","838","2060");

subcat2[1964] = new Array("德城区","942","2061");

subcat2[1965] = new Array("滨城区","942","2062");

subcat2[1966] = new Array("高新技术开发区","948","2063");

subcat2[1967] = new Array("曲阜","953","2064");

subcat2[1968] = new Array("市中区","1102","2065");

subcat2[1969] = new Array("经济开发区","1116","2066");

subcat2[1970] = new Array("平遥县","975","2067");

subcat2[1971] = new Array("高新区","850","2068");

subcat2[1972] = new Array("山脚","963","2069");

subcat2[1973] = new Array("峨眉山市","963","2070");

subcat2[1974] = new Array("山顶","963","2071");

subcat2[1975] = new Array("漳扎镇","966","2072");

subcat2[1976] = new Array("甘海子","966","2073");

subcat2[1977] = new Array("沟口","966","2074");

subcat2[1978] = new Array("江阳区","968","2075");

subcat2[1979] = new Array("磨西镇","1089","2077");

subcat2[1980] = new Array("中部","855","2079");

subcat2[1981] = new Array("西部","855","2080");

subcat2[1982] = new Array("拉萨","855","2081");

subcat2[1983] = new Array("新城","861","2082");

subcat2[1984] = new Array("景洪","862","2083");

subcat2[1985] = new Array("云南省昆明","862","2084");

subcat2[1986] = new Array("大理","863","2085");

subcat2[1987] = new Array("下关","863","2086");

subcat2[1988] = new Array("古城","863","2087");

subcat2[1989] = new Array("朱家尖","868","2088");

subcat2[1990] = new Array("沈家门","868","2089");

subcat2[1991] = new Array("武康镇 ","1023","2090");

subcat2[1992] = new Array("武康镇","1034","2091");

subcat2[1993] = new Array("乾元镇","1034","2092");

subcat2[1994] = new Array("溪口","1035","2093");

subcat2[1995] = new Array("锦城镇","1045","2094");

subcat2[1996] = new Array("昌化镇","1045","2095");

subcat2[1997] = new Array("淳安县","1051","2096");

subcat2[1998] = new Array("千岛湖镇","1051","2097");

subcat2[1999] = new Array("乌镇","1059","2098");

subcat2[2000] = new Array("新昌 ","1064","2099");

subcat2[2001] = new Array("城关镇","1064","2100");

subcat2[2002] = new Array("莲塘镇","1013","2101");

subcat2[2003] = new Array("莰坪镇","1018","2102");

subcat2[2004] = new Array("星子县","1070","2103");

subcat2[2005] = new Array("北戴河","900","2104");

subcat2[2006] = new Array("南戴河","1138","2105");

subcat2[2007] = new Array("桥东区","1139","2106");

subcat2[2008] = new Array("崇礼县","1139","2107");

subcat2[2009] = new Array("龙田镇","1140","2108");

subcat2[2010] = new Array("经济开发试验区","741","2109");

subcat2[2011] = new Array("溱湖风景区","1134","2110");

subcat2[2012] = new Array("拱北区","761","2111");

subcat2[2013] = new Array("吉大区","761","2112");

subcat2[2014] = new Array("经济开发区","1136","2113");

subcat2[2015] = new Array("火炬高技术产业开发区","760","2114");

subcat2[2016] = new Array("南戴河","776","2115");

subcat2[2017] = new Array("开发区","776","2116");

subcat2[2018] = new Array("黄山风景区","728","2117");

subcat2[2019] = new Array("经济技术开发区","730","2118");

subcat2[2020] = new Array("三亚市","772","2119");

subcat2[2021] = new Array("岳阳开发区","802","2120");

subcat2[2022] = new Array("星沙经济技术开发区","794","2121");

subcat2[2023] = new Array("大亚湾区","746","2122");

subcat2[2024] = new Array("新站开发区","727","2123");

subcat2[2025] = new Array("开发区","1101","2124");

subcat2[2026] = new Array("东江镇","1143","2125");

subcat2[2027] = new Array("紫阳镇","1021","2126");

subcat2[2028] = new Array("兴隆旅游度假区","1012","2127");

subcat2[2029] = new Array("礼纪镇","1012","2128");

subcat2[2030] = new Array("昆山经济技术开发区","929","2129");

subcat2[2031] = new Array("睢阳区","1144","2130");

subcat2[2032] = new Array("新区","812","2131");

subcat2[2033] = new Array("临河区","1118","2132");

subcat2[2034] = new Array("华山风景区","1008","2133");

subcat2[2035] = new Array("白沙镇","904","2134");

subcat2[2036] = new Array("红海湾经济开发区","753","2135");

subcat2[2037] = new Array("科尔沁区","1146","2136");

subcat2[2038] = new Array("商业区","1146","2137");

subcat2[2039] = new Array("海拉尔区","1147","2138");

subcat2[2040] = new Array("西城区","762","2139");

subcat2[2041] = new Array("北关区","1149","2140");

subcat2[2042] = new Array("铁西区","1149","2141");

subcat2[2043] = new Array("文峰区","1149","2142");

subcat2[2044] = new Array("殷都区","1149","2143");

subcat2[2045] = new Array("龙安区","1149","2144");

subcat2[2046] = new Array("三河","878","2145");

subcat2[2047] = new Array("滕州市","1073","2146");

subcat2[2048] = new Array("晋中","1151","2147");

subcat2[2049] = new Array("市外","894","2148");

subcat2[2050] = new Array("木渎镇","810","2149");

subcat2[2051] = new Array("汶河区","814","2150");

subcat2[2052] = new Array("松陵镇","1109","2151");

subcat2[2053] = new Array("震泽镇","1109","2152");

subcat2[2054] = new Array("芦墟镇","1109","2153");

subcat2[2055] = new Array("杨舍镇","958","2154");

subcat2[2056] = new Array("大新镇","958","2155");

subcat2[2057] = new Array("城厢镇","934","2156");

subcat2[2058] = new Array("浏家港镇","934","2157");

subcat2[2059] = new Array("下沙经济开发区","864","2158");

subcat2[2060] = new Array("临城新区","868","2159");

subcat2[2061] = new Array("浒山镇","1033","2160");

subcat2[2062] = new Array("观海卫镇","1033","2161");

subcat2[2063] = new Array("白果镇","1045","2162");

subcat2[2064] = new Array("颊口镇","1045","2163");

subcat2[2065] = new Array("天柱山","888","2164");

subcat2[2066] = new Array("裕安区","1153","2165");

subcat2[2067] = new Array("大通镇","956","2166");

subcat2[2068] = new Array("晋州区","1019","2167");

subcat2[2069] = new Array("渝水区","1154","2168");

subcat2[2070] = new Array("东山岛","736","2169");

subcat2[2071] = new Array("孝南区","1155","2170");

subcat2[2072] = new Array("东山开发区","790","2171");

subcat2[2073] = new Array("大祥区","1156","2172");

subcat2[2074] = new Array("双清区","1156","2173");

subcat2[2075] = new Array("赫山区","1157","2174");

subcat2[2076] = new Array("云城区","1158","2175");

subcat2[2077] = new Array("台城镇","747","2176");

subcat2[2078] = new Array("北新区","747","2177");

subcat2[2079] = new Array("坦洲镇","760","2178");

subcat2[2080] = new Array("高州市区","1159","2179");

subcat2[2081] = new Array("港口区","1120","2180");

subcat2[2082] = new Array("康巴什新区","825","2181");

subcat2[2083] = new Array("阿里","856","2182");

subcat2[2084] = new Array("三亚湾海坡开发区","772","2183");

subcat2[2085] = new Array("澳门半岛","872","2184");

subcat2[2086] = new Array("路氹","872","2185");

subcat2[2087] = new Array("尚志","1160","2186");

subcat2[2088] = new Array("新抚区","1161","2187");

subcat2[2089] = new Array("三坡县","899","2188");

subcat2[2090] = new Array("京唐港开发区","775","2189");

subcat2[2091] = new Array("宣化区","1139","2190");

subcat2[2092] = new Array("源汇区","1162","2191");

subcat2[2093] = new Array("解放区","1163","2192");

subcat2[2094] = new Array("山阳区","1163","2193");

subcat2[2095] = new Array("魏都区","1164","2194");

subcat2[2096] = new Array("卫东区","1165","2195");

subcat2[2097] = new Array("驿城区","1166","2196");

subcat2[2098] = new Array("三埠区","898","2197");

subcat2[2099] = new Array("娄星区","1315","2198");

subcat2[2100] = new Array("冷水江市","1315","2199");

subcat2[2101] = new Array("平房经济开发区","782","2200");

subcat2[2102] = new Array("高新区","1099","2201");

subcat2[2103] = new Array("经济开发区","925","2202");

subcat2[2104] = new Array("曾都区","1260","2203");

subcat2[2105] = new Array("梧桐镇 ","1059","2204");

subcat2[2106] = new Array("洲泉镇","1059","2205");

		
onecount2=2107;

	function changeclass2(locationid2)
    {
	var obj2=document.form1;
    obj2.borough_id.length = 1; 

    var locationid2=locationid2;
    var i;
    for (i=0;i < onecount2; i++)
        {
            if (subcat2[i][1] == locationid2)
            { 
             obj2.borough_id.options[obj2.borough_id.length] = new Option(subcat2[i][0], subcat2[i][2]);
            }        
        }
        
    }   
</SCRIPT>
<!--select 改变类别结束-->



<TITLE>酒店加盟</TITLE>

<META name="Description" content="酒店加盟,宾馆加盟,加盟合作协议,网络营销加盟酒店">
<LINK href="<%=request.getContextPath() %>/jiamengfiles/css.css" rel="stylesheet" type="text/css">

<SCRIPT language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/jiamengfiles/calendar.js"></SCRIPT>
<SCRIPT language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/jiamengfiles/hotel_reg.js"></SCRIPT>
<STYLE type="text/css">
<!--
.STYLE1 {color: #FF0000}
.STYLE4 {color: #FFFFFF}
-->
</STYLE>

</HEAD><BODY>
<div>
<jsp:include page="/header.jsp"></jsp:include>
</div>
<DIV align="center">
  <P>
  <TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0">
    <TBODY><TR>
      <TD height="30" valign="middle"><SPAN class="name14">&nbsp;酒店加盟</SPAN> </TD>
    </TR>
    <TR>
      <TD valign="top" bgcolor="#DFDFDF"><BLOCKQUOTE>
        <P><BR>
          致各酒店、宾馆销售部负责人： </P>
        <P class="duanluo150">&nbsp;&nbsp;&nbsp;&nbsp;中国商务订房网开展网上订房业务，有着丰富的订房经验，熟知订房程序，诚愿与贵酒店、宾馆建立长期的合作关系！ <BR>
  &nbsp;&nbsp;&nbsp;&nbsp;如果贵酒店/宾馆愿意加盟，请致电：13700000000 或传真：13700000000 索取加盟协议，或者直接下载<A href="<%=request.getContextPath() %>/jiameng.doc"><SPAN class="blue">酒店加盟协议</SPAN></A>，你也可以在这里在线加盟。我们也十分愿意使用你们的协议！<BR>
  &nbsp;&nbsp;&nbsp;&nbsp;非常感谢你们的大力支持，祝贵酒店、宾馆生意兴隆，财源广进！合作愉快！&nbsp;&nbsp; </P>
        <P class="duanluo150">　　<SPAN class="red14">请您认真填写如下酒店加盟信息表，确认无误后点击“确认提交”按钮，我们会尽快跟您联系。</SPAN></P>
      </BLOCKQUOTE></TD>
    </TR>
  </TBODY></TABLE>
  <TABLE width="780" border="0" cellspacing="0" cellpadding="0">
    <TBODY><TR>
      <TD height="32" align="left">
      <SPAN class="blue14">&nbsp;<B>酒店加盟信息表</B></SPAN></TD>
      <TD align="right"><SPAN class="blue">·</SPAN><A href="<%=request.getContextPath() %>/jiameng.doc"><SPAN class="blue">酒店加盟协议下载</SPAN></A>&nbsp;</TD>
    </TR>
    <FORM name="form1" method="post" action="hoteljoin_submit.do" onsubmit="return check(this);"><TR>
        <TD colspan="2"><DIV align="center">
          <TABLE width="780" border="1" cellpadding="0" cellspacing="0" bordercolorlight="#cccccc" bordercolordark="#ffffff" bgcolor="#eff3f7">
            <TBODY><TR>
              <TD width="88" height="20" align="right" class="opt">酒店名称：</TD>
              <TD colspan="6"><INPUT name="hotelName" type="text" id="hotel_name" size="35"><INPUT type="button" name="bb1" onclick="javascript:gethotelname()" value=" 检 测 "><SPAN class="hui">( 中文 )城市名+酒店名 如：广州中国大酒店 </SPAN>
                <DIV id="str2"></DIV></TD>
              </TR>
            <TR>
              <TD height="20" align="right" class="opt">酒店英文名：</TD>
              <TD colspan="6"><INPUT name="hotel_e_name" type="text" id="hotel_e_name" size="35"></TD>
            </TR>
            <TR>
              <TD height="20" align="right" class="opt">公司全称：</TD>
              <TD colspan="6"><INPUT name="companyName" type="text" id="hotel_name" size="35">
                <SPAN class="red14">*</SPAN><SPAN class="hui">酒店名称与管理公司全称不同的请填写，方便核实倒帐</SPAN></TD>
            </TR>
			 <TR>
              <TD height="20" align="right" class="opt">联系人：</TD>
              <TD colspan="6"><INPUT name="link_name" type="text" id="hotel_name" size="35"></TD>
            </TR>
			 <TR>
			   <TD height="20" align="right" class="opt">联系人电话：</TD>
			   <TD colspan="6"><INPUT name="link_tel" type="text" id="hotel_name" size="35"></TD>
		      </TR>
			 <TR>
              <TD height="20" align="right" class="opt">联系人手机：</TD>
              <TD colspan="6"><INPUT name="link_mobile" type="text" id="hotel_name" size="35"></TD>
            </TR>
			 
            
            <TR>
              <TD height="20" align="right" class="opt">酒店星级：</TD>
              <TD width="210"><SELECT name="hotelType" id="hotel_star">
                <OPTION value="0" selected="">-选择星级-</OPTION>
                <OPTION value="10">五星级</OPTION>
                <OPTION value="9">准五星级</OPTION>
                <OPTION value="8">四星级</OPTION>
                <OPTION value="7">准四星级</OPTION>
                <OPTION value="6">三星级</OPTION>
                <OPTION value="5">准三星级</OPTION>
                <OPTION value="4">二星级</OPTION>
                <OPTION value="3">准二星级</OPTION>
                <OPTION value="1">未评星级</OPTION>
                </SELECT></TD>
              <TD colspan="3" align="right">&nbsp;</TD>
              <TD width="116" align="right">连锁酒店</TD>
              <TD width="141"><SELECT name="chain_id" id="chain_id">
          <OPTION value="">请选择</OPTION>
          
          <OPTION value="10003">如家快捷</OPTION>
          
          <OPTION value="10001">香格里拉</OPTION>
          
          <OPTION value="10002">锦江之星</OPTION>
          
          <OPTION value="10004">7天连锁</OPTION>
          
          <OPTION value="10005">速8连锁</OPTION>
          
          <OPTION value="10006">汉庭连锁</OPTION>
          
          <OPTION value="10007">莫泰连锁</OPTION>
          
          <OPTION value="10010">岭南佳园</OPTION>
          
          <OPTION value="10012">粤海之星</OPTION>
          
          <OPTION value="10013">新宇之星</OPTION>
          
          <OPTION value="10014">扬子江连锁</OPTION>
          
          <OPTION value="10015">万好万家</OPTION>
          
          <OPTION value="10017">美宝连锁</OPTION>
          
          <OPTION value="10019">云马连锁</OPTION>
          
          <OPTION value="10020">斯玛特酒店</OPTION>
          
          <OPTION value="10021">申花酒店</OPTION>
          
          <OPTION value="10024">蓝色快舟</OPTION>
          
          <OPTION value="10065">雷迪森酒店</OPTION>
          
          <OPTION value="10025">山水时尚</OPTION>
          
          <OPTION value="10027">书香门第</OPTION>
          
          <OPTION value="10028">吉泰连锁</OPTION>
          
          <OPTION value="10029">迷你连锁</OPTION>
          
          <OPTION value="10060">华天之星</OPTION>
          
          <OPTION value="10061">百客蛮好</OPTION>
          
          <OPTION value="10030">好如家连锁</OPTION>
          
          <OPTION value="10032">星月时尚</OPTION>
          
          <OPTION value="10036">瑞心连锁</OPTION>
          
          <OPTION value="10037">金泰之家</OPTION>
          
          <OPTION value="10038">方圆快捷</OPTION>
          
          <OPTION value="10039">马瑞卡连锁</OPTION>
          
          <OPTION value="10040">希尔顿酒店</OPTION>
          
          <OPTION value="10041">华美达酒店</OPTION>
          
          <OPTION value="10042">戴斯酒店</OPTION>
          
          <OPTION value="10043">假日酒店</OPTION>
          
          <OPTION value="10045">诺富特酒店</OPTION>
          
          <OPTION value="10047">海逸酒店</OPTION>
          
          <OPTION value="10048">洲际酒店</OPTION>
          
          <OPTION value="10008">格林豪泰</OPTION>
          
          <OPTION value="10070">豪生酒店</OPTION>
          
          <OPTION value="10009">雅悦酒店</OPTION>
          
          <OPTION value="10011">南苑E家</OPTION>
          
          <OPTION value="10016">久悦商务</OPTION>
          
          <OPTION value="10018">欣燕都连锁</OPTION>
          
          <OPTION value="10022">传家连锁</OPTION>
          
          <OPTION value="10023">麦禾连锁</OPTION>
          
          <OPTION value="10026">逸羽连锁</OPTION>
          
          <OPTION value="10031">神舟商旅</OPTION>
          
          <OPTION value="10033">西翠之旅</OPTION>
          
          <OPTION value="10034">悦嘉连锁</OPTION>
          
          <OPTION value="10035">城市客栈</OPTION>
          
          <OPTION value="10044">马哥孛罗</OPTION>
          
          <OPTION value="10046">凯悦酒店</OPTION>
          
          <OPTION value="10049">皇冠假日</OPTION>
          
          <OPTION value="10050">喜来登酒店</OPTION>
          
          <OPTION value="10051">珀丽酒店</OPTION>
          
          <OPTION value="10052">凯莱酒店</OPTION>
          
          <OPTION value="10053">万豪酒店</OPTION>
          
          <OPTION value="10054">凯宾斯基</OPTION>
          
          <OPTION value="10055">索菲特酒店</OPTION>
          
          <OPTION value="10057">威斯汀酒店</OPTION>
          
          <OPTION value="10058">艳阳天旅店</OPTION>
          
          <OPTION value="10059">维也纳连锁</OPTION>
          
          <OPTION value="10078">24K国际连锁</OPTION>
          
          <OPTION value="10056">最佳西方</OPTION>
          
          <OPTION value="10062">新世界酒店</OPTION>
          
          <OPTION value="10063">都市客栈</OPTION>
          
          <OPTION value="10064">富豪酒店</OPTION>
          
          <OPTION value="10066">a8连锁酒店</OPTION>
          
          <OPTION value="10067">中州快捷</OPTION>
          
          <OPTION value="10068">星程酒店</OPTION>
          
          <OPTION value="10069">桔子酒店</OPTION>
          
          <OPTION value="10071">半岛酒店</OPTION>
          
          <OPTION value="10072">丽晶酒店</OPTION>
          
          <OPTION value="10076">阳光酒店</OPTION>
          
          <OPTION value="10079">宝隆居家</OPTION>
          
          <OPTION value="10081">云之舍连锁</OPTION>
          
          <OPTION value="10082">八方快捷</OPTION>
          
          <OPTION value="10084">宜必思酒店</OPTION>
          
          <OPTION value="10088">文星酒店</OPTION>
          
          <OPTION value="10073">瑞士酒店</OPTION>
          
          <OPTION value="10083">名典商旅</OPTION>
          
          <OPTION value="10085">建国酒店</OPTION>
          
          <OPTION value="10086">维景国际</OPTION>
          
          <OPTION value="10087">快捷假日</OPTION>
          
          <OPTION value="10089">飘HOME</OPTION>
          
          <OPTION value="10090">凯旋龙连锁</OPTION>
          
          <OPTION value="10091">微八酒店</OPTION>
          
          <OPTION value="10092">布丁酒店</OPTION>
          
          <OPTION value="10095">威伦酒店</OPTION>
          
          <OPTION value="10096">万丽酒店</OPTION>
          
          <OPTION value="10097">新东方酒店</OPTION>
          
          <OPTION value="10098">锐思特连锁</OPTION>
          
          <OPTION value="10099">金一村连锁</OPTION>
          
          <OPTION value="10100">城市之家</OPTION>
          
          <OPTION value="10101">碧桂园酒店</OPTION>
          
          <OPTION value="10105">金广快捷</OPTION>
          
          <OPTION value="10106">禧龙宾馆</OPTION>
          
          <OPTION value="10074">粤海酒店</OPTION>
          
          <OPTION value="10075">怡莱酒店</OPTION>
          
          <OPTION value="10080">万事达酒店</OPTION>
          
          <OPTION value="10093">假日之星</OPTION>
          
          <OPTION value="10102">开元酒店</OPTION>
          
          <OPTION value="10103">金陵酒店</OPTION>
          
          <OPTION value="10104">云上四季</OPTION>
          
          <OPTION value="10107">银座佳驿</OPTION>
          
          <OPTION value="10109">日月光连锁</OPTION>
          
          <OPTION value="10110">清沐连锁</OPTION>
          
          <OPTION value="10111">富润连锁</OPTION>
          
          <OPTION value="10112">未来宜居</OPTION>
          
          <OPTION value="10113">美爵酒店</OPTION>
          
          <OPTION value="10114">都市万锦</OPTION>
          
          <OPTION value="10094">铂尔曼酒店</OPTION>
          
          <OPTION value="10108">城市便捷</OPTION>
          
        </SELECT></TD>
            </TR>
            
            <TR>
              <TD height="20" align="right" class="opt">所属区域：</TD>
              <TD colspan="6"><SELECT name="hotel_country" id="hotel_country">
                <OPTION value="0" selected="">中国</OPTION>
                </SELECT>
                <SPAN class="opt">省份：</SPAN>
                <SELECT name="sheng" id="sheng" onchange="changeclass(document.form1.sheng.options[document.form1.sheng.selectedIndex].value);">
                  <OPTION value="0" selected="">-选择-</OPTION>
                  
                  <OPTION value="35">安徽</OPTION>
                  
                  <OPTION value="36">北京</OPTION>
                  
                  <OPTION value="37">福建</OPTION>
                  
                  <OPTION value="38">甘肃</OPTION>
                  
                  <OPTION value="39">广东</OPTION>
                  
                  <OPTION value="40">广西</OPTION>
                  
                  <OPTION value="41">贵州</OPTION>
                  
                  <OPTION value="42">海南</OPTION>
                  
                  <OPTION value="43">河北</OPTION>
                  
                  <OPTION value="44">河南</OPTION>
                  
                  <OPTION value="45">黑龙江</OPTION>
                  
                  <OPTION value="46">湖北</OPTION>
                  
                  <OPTION value="47">湖南</OPTION>
                  
                  <OPTION value="48">吉林</OPTION>
                  
                  <OPTION value="49">江苏</OPTION>
                  
                  <OPTION value="51">辽宁</OPTION>
                  
                  <OPTION value="52">内蒙古</OPTION>
                  
                  <OPTION value="53">宁夏</OPTION>
                  
                  <OPTION value="54">青海</OPTION>
                  
                  <OPTION value="55">山东</OPTION>
                  
                  <OPTION value="56">山西</OPTION>
                  
                  <OPTION value="57">陕西</OPTION>
                  
                  <OPTION value="58">上海</OPTION>
                  
                  <OPTION value="59">四川</OPTION>
                  
                  <OPTION value="60">天津</OPTION>
                  
                  <OPTION value="61">西藏</OPTION>
                  
                  <OPTION value="62">新疆</OPTION>
                  
                  <OPTION value="63">云南</OPTION>
                  
                  <OPTION value="64">浙江</OPTION>
                  
                  <OPTION value="65">重庆</OPTION>
                  
                  <OPTION value="66">台湾</OPTION>
                  
                  <OPTION value="67">香港</OPTION>
                  
                  <OPTION value="68">澳门</OPTION>
                  
                  <OPTION value="69">江西</OPTION>
                  
                  </SELECT>
                <SPAN class="STYLE1">*</SPAN> <SPAN class="opt">城市：</SPAN>
                <SELECT name="city" id="city" onchange="changeclass1(document.form1.city.options[document.form1.city.selectedIndex].value);changeclass2(document.form1.city.options[document.form1.city.selectedIndex].value);">
                  <OPTION value="0">-选择-</OPTION>
                  </SELECT>
                <SPAN class="opt">商业区：</SPAN>
                <SELECT name="region" id="region">
                  <OPTION value="0">-选择-</OPTION>
                  </SELECT>
                <SPAN class="red9">行政区：</SPAN>
                <SELECT name="borough_id" id="borough_id">
                  <OPTION value="0">-选择-</OPTION>
                </SELECT></TD>
              </TR>
            <TR>
              <TD height="20" align="right" class="opt">酒店地址：</TD>
              <TD><INPUT name="hotelAddress" type="text" class="inputs" id="hotel_address" size="30"></TD>
              <TD colspan="2" align="right" class="opt">房间数量：</TD>
              <TD colspan="3"><INPUT name="ctrip_room_num" type="text" id="ctrip_room_num" size="10">
              间</TD>
            </TR>
            
            <TR>
              <TD height="20" align="right" class="opt">酒店电话：</TD>
              <TD><INPUT name="hotelPhone" type="text" id="hotel_tel" class="inputs"></TD>
              <TD colspan="2" align="right" class="opt">酒店传真：</TD>
              <TD colspan="3"><INPUT name="hotel_fax" type="text" id="hotel_fax" size="30"></TD>
            </TR>
            <TR>
              <TD height="20" align="right" class="opt">开业时间：</TD>
              <TD><SELECT name="hotel_KaiDate">
                <OPTION value="" selected="">-选择开业时间-</OPTION>
				
                <OPTION value="2010">2010年</OPTION>
            
                <OPTION value="2009">2009年</OPTION>
            
                <OPTION value="2008">2008年</OPTION>
            
                <OPTION value="2007">2007年</OPTION>
            
                <OPTION value="2006">2006年</OPTION>
            
                <OPTION value="2005">2005年</OPTION>
            
                <OPTION value="2004">2004年</OPTION>
            
                <OPTION value="2003">2003年</OPTION>
            
                <OPTION value="2002">2002年</OPTION>
            
                <OPTION value="2001">2001年</OPTION>
            
                <OPTION value="2000">2000年</OPTION>
            
                <OPTION value="1999">1999年</OPTION>
            
                <OPTION value="1998">1998年</OPTION>
            
                <OPTION value="1997">1997年</OPTION>
            
                <OPTION value="1996">1996年</OPTION>
            
                <OPTION value="1995">1995年</OPTION>
            
                <OPTION value="1994">1994年</OPTION>
            
                <OPTION value="1993">1993年</OPTION>
            
                <OPTION value="1992">1992年</OPTION>
            
                <OPTION value="1991">1991年</OPTION>
            
                <OPTION value="1990">1990年</OPTION>
            
                <OPTION value="1989">1989年</OPTION>
            
                <OPTION value="1988">1988年</OPTION>
            
                <OPTION value="1987">1987年</OPTION>
            
                <OPTION value="1986">1986年</OPTION>
            
                <OPTION value="1985">1985年</OPTION>
            
                <OPTION value="1984">1984年</OPTION>
            
                <OPTION value="1983">1983年</OPTION>
            
                <OPTION value="1982">1982年</OPTION>
            
                <OPTION value="1981">1981年</OPTION>
            
                <OPTION value="1980">1980年</OPTION>
            
                <OPTION value="1979">1979年</OPTION>
            
                <OPTION value="1978">1978年</OPTION>
            
                <OPTION value="1977">1977年</OPTION>
            
                <OPTION value="1976">1976年</OPTION>
            
                <OPTION value="1975">1975年</OPTION>
            
                <OPTION value="1974">1974年</OPTION>
            
                <OPTION value="1973">1973年</OPTION>
            
                <OPTION value="1972">1972年</OPTION>
            
                <OPTION value="1971">1971年</OPTION>
            
                <OPTION value="1970">1970年</OPTION>
            
                <OPTION value="1969">1969年</OPTION>
            
                <OPTION value="1968">1968年</OPTION>
            
                <OPTION value="1967">1967年</OPTION>
            
                <OPTION value="1966">1966年</OPTION>
            
                <OPTION value="1965">1965年</OPTION>
            
                <OPTION value="1964">1964年</OPTION>
            
                <OPTION value="1963">1963年</OPTION>
            
                <OPTION value="1962">1962年</OPTION>
            
                <OPTION value="1961">1961年</OPTION>
            
                <OPTION value="1960">1960年</OPTION>
            
                <OPTION value="1959">1959年</OPTION>
            
                <OPTION value="1958">1958年</OPTION>
            
                <OPTION value="1957">1957年</OPTION>
            
                <OPTION value="1956">1956年</OPTION>
            
                <OPTION value="1955">1955年</OPTION>
            
                <OPTION value="1954">1954年</OPTION>
            
                <OPTION value="1953">1953年</OPTION>
            
                <OPTION value="1952">1952年</OPTION>
            
                <OPTION value="1951">1951年</OPTION>
            
                </SELECT></TD>
              <TD colspan="2" align="right" class="opt">装修时间：</TD>
              <TD colspan="3"><SELECT name="hotel_ZhuangDate">
                <OPTION value="" selected="">-选择装修时间-</OPTION>
				
                <OPTION value="2010">2010年</OPTION>
            
                <OPTION value="2009">2009年</OPTION>
            
                <OPTION value="2008">2008年</OPTION>
            
                <OPTION value="2007">2007年</OPTION>
            
                <OPTION value="2006">2006年</OPTION>
            
                <OPTION value="2005">2005年</OPTION>
            
                <OPTION value="2004">2004年</OPTION>
            
                <OPTION value="2003">2003年</OPTION>
            
                <OPTION value="2002">2002年</OPTION>
            
                <OPTION value="2001">2001年</OPTION>
            
                <OPTION value="2000">2000年</OPTION>
            
                <OPTION value="1999">1999年</OPTION>
            
                <OPTION value="1998">1998年</OPTION>
            
                <OPTION value="1997">1997年</OPTION>
            
                <OPTION value="1996">1996年</OPTION>
            
                <OPTION value="1995">1995年</OPTION>
            
                <OPTION value="1994">1994年</OPTION>
            
                <OPTION value="1993">1993年</OPTION>
            
                <OPTION value="1992">1992年</OPTION>
            
                <OPTION value="1991">1991年</OPTION>
            
                <OPTION value="1990">1990年</OPTION>
            
                <OPTION value="1989">1989年</OPTION>
            
                <OPTION value="1988">1988年</OPTION>
            
                <OPTION value="1987">1987年</OPTION>
            
                <OPTION value="1986">1986年</OPTION>
            
                <OPTION value="1985">1985年</OPTION>
            
                <OPTION value="1984">1984年</OPTION>
            
                <OPTION value="1983">1983年</OPTION>
            
                <OPTION value="1982">1982年</OPTION>
            
                <OPTION value="1981">1981年</OPTION>
            
                <OPTION value="1980">1980年</OPTION>
            
                <OPTION value="1979">1979年</OPTION>
            
                <OPTION value="1978">1978年</OPTION>
            
                <OPTION value="1977">1977年</OPTION>
            
                <OPTION value="1976">1976年</OPTION>
            
                <OPTION value="1975">1975年</OPTION>
            
                <OPTION value="1974">1974年</OPTION>
            
                <OPTION value="1973">1973年</OPTION>
            
                <OPTION value="1972">1972年</OPTION>
            
                <OPTION value="1971">1971年</OPTION>
            
                <OPTION value="1970">1970年</OPTION>
            
                <OPTION value="1969">1969年</OPTION>
            
                <OPTION value="1968">1968年</OPTION>
            
                <OPTION value="1967">1967年</OPTION>
            
                <OPTION value="1966">1966年</OPTION>
            
                <OPTION value="1965">1965年</OPTION>
            
                <OPTION value="1964">1964年</OPTION>
            
                <OPTION value="1963">1963年</OPTION>
            
                <OPTION value="1962">1962年</OPTION>
            
                <OPTION value="1961">1961年</OPTION>
            
                <OPTION value="1960">1960年</OPTION>
            
                <OPTION value="1959">1959年</OPTION>
            
                <OPTION value="1958">1958年</OPTION>
            
                <OPTION value="1957">1957年</OPTION>
            
                <OPTION value="1956">1956年</OPTION>
            
                <OPTION value="1955">1955年</OPTION>
            
                <OPTION value="1954">1954年</OPTION>
            
                <OPTION value="1953">1953年</OPTION>
            
                <OPTION value="1952">1952年</OPTION>
            
                <OPTION value="1951">1951年</OPTION>
            
                </SELECT></TD>
            </TR>
            <TR>
              <TD height="20" align="right" class="opt">距离机场：</TD>
              <TD><INPUT name="hotel_distance_1" type="text" id="hotel_distance_1" size="5">
                公里</TD>
              <TD colspan="2" align="right" class="opt">距离&nbsp;</TD>
              <TD colspan="3"><INPUT name="hotel_distance_name4" type="text" id="hotel_distance_name4" size="15">
                ：<INPUT name="hotel_distance_4" type="text" id="hotel_distance_4" size="5">
                公里</TD>
            </TR>
            <TR>
              <TD height="20" align="right" class="opt">距离市中心：</TD>
              <TD><INPUT name="hotel_distance_3" type="text" id="hotel_distance_3" size="5">
                公里</TD>
              <TD colspan="2" align="right" class="opt">距离&nbsp;</TD>
              <TD colspan="3"><INPUT name="hotel_distance_name5" type="text" id="hotel_distance_name5" size="15">
                ：<INPUT name="hotel_distance_5" type="text" id="hotel_distance_5" size="5">
                公里</TD>
            </TR>
            <TR>
              <TD height="20" align="right" class="opt">距离火车站：</TD>
              <TD><INPUT name="hotel_distance_2" type="text" id="hotel_distance_2" size="5">
                公里</TD>
              <TD colspan="2" align="right" class="opt">距离&nbsp;</TD>
              <TD colspan="3"><INPUT name="hotel_distance_name6" type="text" id="hotel_distance_name6" size="15">
                ：<INPUT name="hotel_distance_6" type="text" id="hotel_distance_6" value="" size="5">
                公里</TD>
            </TR>
            <TR>
              <TD height="20" align="right" class="opt"><SPAN class="red14">*</SPAN>周边景观：</TD>
              <TD colspan="6"><INPUT name="hotelRound" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value=""><BR><INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value="">&nbsp;<INPUT name="hotel_around" type="text" size="10" class="inputs" id="hotel_around" value=""><BR>
                <SPAN class="opt"><SPAN class="red14">*</SPAN></SPAN><SPAN class="hui">每格填写一个景观，建议多提供标志性的景观，以便更多客户从网上找到贵酒店；周边景观包括：景区景点、商业大厦、休闲购物、综合广场、高等院校、医院、政府机构、交通枢纽、道路街道等。</SPAN></TD>
            </TR>
            
            <TR>
              <TD height="20" align="right" class="opt">服务项目：</TD>
              <TD colspan="6">
			    <TABLE width="686" border="0" cellpadding="0" cellspacing="0">
                  <TBODY><TR>
				  
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="100">商务中心</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="101">会议厅</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="102">停车场</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="103">收费停车场</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="104">外币兑换服务</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="105">票务服务</TD>
					
					
<TD width="60"></TR><TR>
                    
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="106">洗衣服务</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="107">残疾人客房</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="108">商场</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="109">鲜花店</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="110">医务室</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="111">理发美容室</TD>
					
					
<TD width="60"></TR><TR>
                    
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="112">邮政服务</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="113">前台保险柜</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="114">专职行李员</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="115">行李存放服务</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="116">穿梭机场班车</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="117">出租车</TD>
					
						
					<TD width="60"><INPUT type="checkbox" name="checkbox" value="checkbox" onclick="javascript:selectall(this.form.hotel_Services,this.checked);"><SPAN class="hui">全选</SPAN></TD></TR><TR>
					

                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="118">国内长途电话</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="119">国际长途电话</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="120">无线上网公共区</TD>
					
					
                    <TD width="110"><INPUT name="hotel_Services" type="checkbox" value="121">免费旅游交通图</TD>
					
					
                   
                
               
                  </TR>
                </TBODY></TABLE>		        </TD>
              </TR>
            <TR>
              <TD height="20" align="right" class="opt">娱乐设施：</TD>
              <TD colspan="6"><TABLE width="686" border="0" cellpadding="0" cellspacing="0">
                  <TBODY><TR>
				  
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="122">卡拉OK厅</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="123">交谊舞厅</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="124">迪斯科舞厅</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="125">桌球室</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="126">壁球室</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="127">乒乓球室</TD>
					
					
<TD width="60"></TR><TR>
                    
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="128">健身室</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="129">按摩室</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="130">桑拿浴室</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="131">日光浴场</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="132">棋牌室</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="133">录象室</TD>
					
						
					<TD width="60"><INPUT type="checkbox" name="checkbox" value="checkbox" onclick="javascript:selectall(this.form.hotel_yule,this.checked);"><SPAN class="hui">全选</SPAN></TD></TR><TR>
					

                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="134">室内游泳池</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="135">室外游泳池</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="136">网球场</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="137">保龄球场</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="138">SPA</TD>
					
					
                    <TD width="110"><INPUT name="hotel_yule" type="checkbox" value="139">小型高尔夫球场</TD>
					
					
<TD width="60"></TR><TR>
                    
                   
                
               
                  </TR>
                </TBODY></TABLE></TD>
              </TR>
            <TR>
              <TD height="25" align="right" class="opt">餐饮情况：</TD>
              <TD colspan="7"><TABLE width="686" border="0" cellspacing="0" cellpadding="0">
                  <TBODY><TR>
				  
                    <TD width="110"><INPUT name="hotel_cangying" type="checkbox" value="140">中餐厅</TD>
					
					
                    <TD width="110"><INPUT name="hotel_cangying" type="checkbox" value="141">西餐厅</TD>
					
					
                    <TD width="110"><INPUT name="hotel_cangying" type="checkbox" value="142">咖啡厅</TD>
					
					
                    <TD width="110"><INPUT name="hotel_cangying" type="checkbox" value="143">烧烤</TD>
					
					
                    <TD width="110"><INPUT name="hotel_cangying" type="checkbox" value="144">酒吧</TD>
					
					
                    <TD width="110"><INPUT name="hotel_cangying" type="checkbox" value="145">日餐厅</TD>
					
						
					<TD width="60"><INPUT type="checkbox" name="checkbox" value="checkbox" onclick="javascript:selectall(this.form.hotel_cangying,this.checked);"><SPAN class="hui">全选</SPAN></TD></TR><TR>
					

                    <TD width="110"><INPUT name="hotel_cangying" type="checkbox" value="146">客房送餐服务</TD>
					
					
                   
                
               
                  </TR>
                </TBODY></TABLE> </TD>
              </TR>
            <TR>
              <TD height="20" align="right" class="opt">早餐类型：</TD>
              <TD><SELECT name="hotel_Zhaocangjia_input" id="select">
                <OPTION value="" selected="">
                <OPTION value="自助早餐">自助早餐</OPTION>
                <OPTION value="中式早餐">中式早餐</OPTION>
                <OPTION value="中式自助早餐">中式自助早餐</OPTION>
                <OPTION value="西式早餐">西式早餐</OPTION>
                <OPTION value="西式自助早餐">西式自助早餐</OPTION>
              </SELECT>
                <SPAN class="opt">&nbsp;&nbsp;早餐价</SPAN>：
                <INPUT name="hotel_zhaocangjia" type="text" id="hotel_zhaocangjia" size="5">
元</TD>
              <TD width="200" align="left" class="opt">&nbsp;</TD>
              <TD colspan="4" align="left" class="opt">加床价：
                <INPUT name="hotel_jiachuangjia" type="text" id="hotel_jiachuangjia" size="5">
                元</TD>
              </TR>
            
            
            <TR>
              <TD height="20" align="right" class="opt">信用卡类型：</TD>
              <TD colspan="5"><LABEL>
                <INPUT name="hotel_pay" type="checkbox" id="hotel_pay" value="1">
                </LABEL>
                <IMG src="<%=request.getContextPath() %>/jiamengfiles/add_clip_image001.gif" alt="境外发行信用卡 -- 万事达(Master)" width="44" height="26">
                <INPUT name="hotel_pay" type="checkbox" id="hotel_pay" value="2">          &nbsp;<IMG src="<%=request.getContextPath() %>/jiamengfiles/add_clip_image002.gif" alt="境外发行信用卡 -- 威士(VISA)" width="45" height="25">
                <INPUT name="hotel_pay" type="checkbox" id="hotel_pay" value="3">          <IMG src="<%=request.getContextPath() %>/jiamengfiles/add_clip_image003.gif" alt="境外发行信用卡 -- 运通(AMEX) " width="26" height="26">
                <INPUT name="hotel_pay" type="checkbox" id="hotel_pay" value="4">          <IMG src="<%=request.getContextPath() %>/jiamengfiles/add_clip_image004.gif" alt="境外发行信用卡 -- 大来(Diners Club) " width="40" height="26">
                <INPUT name="hotel_pay" type="checkbox" id="hotel_pay" value="5">          &nbsp;<IMG src="<%=request.getContextPath() %>/jiamengfiles/add_clip_image005.gif" alt="境外发行信用卡 -- JCB " width="21" height="26"> <INPUT name="hotel_pay" type="checkbox" id="hotel_pay" value="6">
                <IMG src="<%=request.getContextPath() %>/jiamengfiles/add_clip_image006.gif" alt="国内发行银联卡" width="41" height="27">
                </TD>
              <TD align="right"><TABLE width="75" border="0">
                <TBODY><TR>
                  <TD><INPUT type="checkbox" name="checkbox" value="checkbox" onclick="javascript:selectall(this.form.hotel_pay,this.checked);"><SPAN class="hui">全选</SPAN></TD>
                </TR>
              </TBODY></TABLE></TD>
            </TR>
            
	 	  
            
            
            <TR>
              <TD height="20" align="right" class="opt">详细介绍：</TD>
              <TD colspan="6"><TEXTAREA name="hotelDetail" cols="80" rows="4" class="inputs" id="hotel_resume"></TEXTAREA></TD>
              </TR>
            <TR>
              <TD height="20" align="right" class="opt"><P>简单简介：<BR>
                  <SPAN class="hui">（限80字内）</SPAN></P>                </TD>
			  
              <TD colspan="6"><TEXTAREA cols="80" name="hotelIntroduce" rows="2" class="inputs" id="hotel_beizhu"></TEXTAREA><INPUT name="regid" type="hidden" class="inputs" value="2010310114356"></TD>
              </TR>
            <TR>
              <TD height="25" align="right" class="opt">酒店图片：</TD>
              <TD colspan="6"><SPAN class="blue">·</SPAN><A href="<%=request.getContextPath() %>/jiamengfiles/酒店加盟 宾馆加盟申请_中国商务订房网.htm" onclick="javascript:window.open (&#39;photo_add.asp?hotel_id=2010310114356&#39;, &#39;newwindow&#39;, &#39;height=600, width=800, top=0, left=0, toolbar=no, menubar=no, scrollbars=1, resizable=no,location=n o, status=no&#39;)"><SPAN class="blue">上传酒店相关图片</SPAN></A><SPAN class="hui">（欢迎提供更多更精美的酒店图片，至少提供酒店外观、大堂和客房3张图片。）</SPAN></TD>
            </TR>
             <TR>
              <TD height="20" align="right" class="opt">备注：</TD>
              <TD colspan="6"><TEXTAREA cols="80" name="hotel_memo" rows="2" class="inputs" id="hotel_beizhu"></TEXTAREA></TD>
              </TR>
            <TR align="center">
              <TD height="28" colspan="7" class="opt"><INPUT type="submit" name="Submit" value=" 确认提交 "></TD>
              </TR>
            </TBODY></TABLE>
      </DIV>
      <TABLE width="100%" border="1" cellspacing="0" cellpadding="0" bordercolordark="#ffffff" bordercolorlight="#cccccc"><TBODY><TR align="center">
        </TBODY></TABLE></TD>
    </TR>
  </TBODY></TABLE>
  </P><DIV align="center">
    <TABLE width="778" border="0" cellspacing="0" cellpadding="0">
    <TBODY><TR>
      <TD>&nbsp;</TD>
    </TR>
    <TR>
      <TD style="background:url(/image/dashed.gif) repeat-x; height:8px;">
    </TR>
    </FORM>
  </TBODY></TABLE>

</DIV>


</DIV>
<SCRIPT type="text/javascript" src="<%=request.getContextPath() %>/jiamengfiles/prototype.js"></SCRIPT>
<SCRIPT type="text/javascript" src="<%=request.getContextPath() %>/jiamengfiles/x.js"></SCRIPT>


</BODY></HTML>