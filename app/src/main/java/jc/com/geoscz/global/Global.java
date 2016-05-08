package jc.com.geoscz.global;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class Global {

        public static String queryCategoria = "INSERT INTO Categoria VALUES(1,'Salud',' '),\n" +
                "(2,'Educación',' '),\n" +
                "(3,'Negocios',' '),\n" +
                "(4,'Industrial',' '),\n" +
                "(5,'Deporte',' ');";

        public static String queryActEco = "INSERT INTO ActEco VALUES(1,'','','','','851101','Hospitales (nivel 1)',1),\n" +
                "(2,'','','','','851102','Hospital (nivel 2)',1),\n"+
                "(3,'','','','','851103','Hospital (nivel 3)',1),\n"+
                "(4,'','','','','851104','Centros de Salud',1),\n"+
                "(5,'','','','','851105','Postas',1)";

        public static String queryDistrito = "INSERT INTO Distrito VALUES(1,'1','1','D-1','0.000000'),\n" +
                "(2,'2','2','D-2','0.000000'),\n" +
                "(3,'3','3','D-3','0.000000'),\n" +
                "(4,'4','6','D-6','0.000000'),\n" +
                "(5,'5','5','D-5','0.000000'),\n" +
                "(6,'6','7','D-7','0.000000'),\n" +
                "(7,'7','8','D-8','0.000000'),\n" +
                "(8,'8','12','D-12','0.000000'),\n" +
                "(9,'9','10','D-10','0.000000'),\n" +
                "(10,'10','9','D-9','0.000000'),\n" +
                "(11,'11','11','D-11','0.000000'),\n" +
                "(12,'12','4','D-4','0.000000'),\n" +
                "(13,'13','16','D-16','0.000000'),\n" +
                "(14,'14','13','D-13','0.000000'),\n" +
                "(15,'15','15','D-15','0.000000'),\n" +
                "(16,'16','14','D-14','0.000000'),\n" +
                "(17,'401','17','D-17','0.000000');";

        public static String queryUvs = "INSERT INTO Uvs VALUES(1,'135','0',8,'6','UV-79A', -63.135322, -17.732935),\n" +
                "(2,'156','0',8,'7','ET-38', -63.117278, -17.804564),\n" +
                "(3,'169','0',8,'7','UV-96', -63.112824, -17.804867),\n" +
                "(4,'180','0',7,'6','UV-141A', -63.125361, -17.769686),\n" +
                "(5,'299','0',0,'12','UV-260', -63.196341, -17.889913),\n" +
                "(6,'324','0',0,'8','UV-284', -63.051297, -17.808403),\n" +
                "(7,'326','0',0,'8','UV-283', -63.057454, -17.799266),\n" +
                "(8,'327','0',0,'8','UV-282', -63.050882, -17.799570),\n" +
                "(9,'328','0',0,'8','UV-280', -63.057182, -17.790294),\n" +
                "(10,'329','0',0,'8','UV-281', -63.050081, -17.788329),\n" +
                "(11,'343','0',0,'7','UV-268', -63.074330, -17.773220),\n" +
                "(12,'377','0',0,'0','S1-4', -63.148230, -17.678392),\n" +
                "(13,'378','0',0,'0','S1-3', -63.143835, -17.684761),\n" +
                "(14,'379','0',0,'0','S1-2', -63.138177, -17.691837),\n" +
                "(15,'383','0',0,'6','UV-208-B', -63.113521, -17.719197),\n" +
                "(16,'384','0',0,'6','UV-208', -63.121912, -17.714392),\n" +
                "(17,'385','0',0,'6','UV-222', -63.125065, -17.719595),\n" +
                "(18,'386','0',0,'6','UV-223', -63.118546, -17.725395),\n" +
                "(19,'387','0',0,'6','UV-225', -63.123626, -17.730831),\n" +
                "(20,'411','0',0,'0','PI', -63.139881, -17.740293),\n" +
                "(21,'412','0',0,'0','PI', -63.141525, -17.742807),\n" +
                "(22,'413','0',0,'0','PI-', -63.151385, -17.755228),\n" +
                "(23,'414','0',0,'0','PI', -63.148716, -17.756686),\n" +
                "(24,'415','0',0,'0','PI', -63.152727, -17.757693),\n" +
                "(25,'416','0',0,'0','PI', -63.150436, -17.759615),\n" +
                "(26,'417','0',0,'0','PI', -63.148101, -17.761384),\n" +
                "(27,'418','0',0,'0','PI', -63.148749, -17.763590),\n" +
                "(28,'419','0',0,'0','PI', -63.147048, -17.765656),\n" +
                "(29,'420','0',0,'0','PI', -63.146054, -17.758147),\n" +
                "(30,'421','0',0,'0','PI-29B', -63.144248, -17.756121),\n" +
                "(31,'422','0',0,'0','PI-29A', -63.143438, -17.754854),\n" +
                "(32,'423','0',0,'0','PI-30', -63.142209, -17.752899),\n" +
                "(33,'424','0',0,'0','PI', -63.145842, -17.762658),\n" +
                "(34,'425','0',0,'0','PI', -63.143674, -17.763899),\n" +
                "(35,'426','0',0,'0','PI', -63.143782, -17.759392),\n" +
                "(36,'427','0',0,'0','PI', -63.141596, -17.760596),\n" +
                "(37,'428','0',0,'0','PI-21B', -63.140558, -17.758156),\n" +
                "(38,'429','0',0,'0','PI-21A', -63.139765, -17.756900),\n" +
                "(39,'430','0',0,'0','PI', -63.138567, -17.754991),\n" +
                "(40,'431','0',0,'0','PI', -63.136880, -17.759355),\n" +
                "(41,'432','0',0,'0','PI', -63.138138, -17.761305),\n" +
                "(42,'433','0',0,'0','PI', -63.138830, -17.762455),\n" +
                "(43,'434','0',0,'0','PI', -63.139531, -17.763479),\n" +
                "(44,'435','0',0,'0','PI', -63.140322, -17.764857),\n" +
                "(45,'436','0',0,'0','PI', -63.141858, -17.766870),\n" +
                "(46,'437','0',0,'0','PI', -63.141309, -17.768097),\n" +
                "(47,'438','0',0,'0','PI', -63.139298, -17.769969),\n" +
                "(48,'439','0',0,'0','PI', -63.140757, -17.771025),\n" +
                "(49,'440','0',0,'0','PI', -63.140690, -17.772521),\n" +
                "(50,'441','0',0,'0','PI', -63.141428, -17.765696),\n" +
                "(51,'442','0',0,'0','PI', -63.144960, -17.766004),\n" +
                "(52,'443','0',0,'0','PI', -63.146199, -17.769332),\n" +
                "(53,'444','0',0,'0','PI', -63.144270, -17.768900),\n" +
                "(54,'445','0',0,'0','PI', -63.143410, -17.773014),\n" +
                "(55,'446','0',0,'0','PI', -63.145617, -17.773458),\n" +
                "(56,'447','0',0,'0','PI', -63.144587, -17.776266),\n" +
                "(57,'448','0',0,'0','PI', -63.144555, -17.777746),\n" +
                "(58,'449','0',0,'0','PI', -63.139769, -17.775675),\n" +
                "(59,'450','0',0,'0','PI', -63.135553, -17.774271),\n" +
                "(60,'451','0',0,'0','PI', -63.131786, -17.772856),\n" +
                "(61,'452','0',0,'0','PI', -63.132337, -17.770894),\n" +
                "(62,'453','0',0,'0','PI', -63.129096, -17.768656),\n" +
                "(63,'454','0',0,'0','PI', -63.140580, -17.750332),\n" +
                "(64,'455','0',0,'0','PI', -63.138997, -17.747828),\n" +
                "(65,'456','0',0,'0','PI', -63.137355, -17.745223),\n" +
                "(66,'457','0',0,'0','PI', -63.135753, -17.742683),\n" +
                "(67,'458','0',0,'0','PI', -63.130675, -17.745616),\n" +
                "(68,'459','0',0,'0','PI', -63.132228, -17.748193),\n" +
                "(69,'460','0',0,'0','PI', -63.133905, -17.750786),\n" +
                "(70,'461','0',0,'0','PI', -63.135459, -17.753339),\n" +
                "(71,'462','0',0,'0','PI', -63.135387, -17.756792),\n" +
                "(72,'463','0',0,'0','PI', -63.140997, -17.769603),\n" +
                "(73,'467','0',0,'6','UV-208', -63.116427, -17.714558),\n" +
                "(74,'474','0',0,'0','PI', -63.139283, -17.736312),\n" +
                "(75,'477','0',0,'0','PI', -63.131987, -17.761430),\n" +
                "(76,'484','0',0,'6','UV-208-A', -63.112180, -17.707509),\n" +
                "(77,'488','0',0,'7','UV-272', -63.054490, -17.781078),\n" +
                "(78,'489','0',0,'0','S1-1', -63.138102, -17.685723),\n" +
                "(79,'498','0',0,'0','PI', -63.129552, -17.738495),\n" +
                "(80,'506','0',0,'0','PI', -63.136049, -17.768497),\n" +
                "(81,'490','0',0,'0','P2', -63.122646, -17.701305),\n" +
                "(82,'452','0',0,'0','', 0.000000, 0.000000),\n" +
                "(83,'182','0',7,'6','', -63.127341, -17.765265),\n" +
                "(84,'187','0',7,'6','', -63.131331, -17.756791),\n" +
                "(85,'248','0',0,'12','', -63.132918, -17.848557),\n" +
                "(86,'297','0',0,'9','', -63.200531, -17.883527),\n" +
                "(87,'298','0',0,'9','', -63.201414, -17.886607),\n" +
                "(88,'509','0',0,'0','', 0.000000, 0.000000),\n" +
                "(89,'289','0',0,'10','UV-301', -63.240369, -17.848961),\n" +
                "(90,'290','0',0,'10','UV-301', -63.243489, -17.850775),\n" +
                "(91,'50','0',4,'1','UV-57', -63.206145, -17.769431),\n" +
                "(92,'51','0',4,'1','UV-58', -63.201169, -17.763049),\n" +
                "(93,'199','0',3,'1','ET-19', -63.202947, -17.770349),\n" +
                "(94,'23','0',3,'1','UV-32', -63.197954, -17.775635),\n" +
                "(95,'47','0',4,'1','UV-54', -63.211706, -17.788330),\n" +
                "(96,'48','0',4,'1','UV-55', -63.211105, -17.781533),\n" +
                "(97,'49','0',4,'1','UV-56', -63.209701, -17.774800),\n" +
                "(98,'71','0',5,'1','PU-2', -63.219234, -17.782704),\n" +
                "(99,'200','0',3,'1','ET-18', -63.204045, -17.774840),\n" +
                "(100,'202','0',3,'1','ET-16', -63.205747, -17.787757),\n" +
                "(101,'21','0',3,'1','UV-30', -63.200254, -17.788778),\n" +
                "(102,'24','0',3,'1','UV-33', -63.196650, -17.769927),\n" +
                "(103,'25','0',3,'1','UV-34', -63.192310, -17.767113),\n" +
                "(104,'22','0',3,'1','UV-31', -63.199633, -17.781660),\n" +
                "(105,'69','0',5,'1','UV-112', -63.221411, -17.796219),\n" +
                "(106,'70','0',5,'1','UV-113', -63.220688, -17.789292),\n" +
                "(107,'201','0',3,'1','ET-17', -63.204981, -17.781503),\n" +
                "(108,'46','0',4,'1','UV-53', -63.211374, -17.793636),\n" +
                "(109,'203','0',3,'1','ET-15', -63.205461, -17.792305),\n" +
                "(110,'26','0',3,'1','UV-35', -63.188549, -17.766501),\n" +
                "(111,'27','0',3,'1','UV-36', -63.183990, -17.764368),\n" +
                "(112,'194','0',3,'1','ET-24', -63.180416, -17.758751),\n" +
                "(113,'196','0',3,'1','ET-22', -63.189578, -17.760787),\n" +
                "(114,'197','0',3,'1','ET-21', -63.193879, -17.762528),\n" +
                "(115,'221','0',3,'1','', -63.182334, -17.759048),\n" +
                "(116,'52','0',4,'1','UV-59', -63.195289, -17.757483),\n" +
                "(117,'53','0',4,'1','UV-60', -63.189141, -17.755123),\n" +
                "(118,'54','0',4,'1','UV-61', -63.184636, -17.754570),\n" +
                "(119,'55','0',4,'1','UV-62', -63.179273, -17.753724),\n" +
                "(120,'195','0',3,'1','ET-23', -63.185306, -17.759644),\n" +
                "(121,'218','0',5,'1','UV-63', -63.181363, -17.746423),\n" +
                "(122,'160','0',6,'7','UV-81', -63.141411, -17.794886),\n" +
                "(123,'161','0',6,'7','UV-82', -63.137273, -17.789586),\n" +
                "(124,'162','0',6,'7','UV-83', -63.130465, -17.788776),\n" +
                "(125,'164','0',7,'7','UV-84B', -63.121904, -17.784039),\n" +
                "(126,'165','0',8,'7','UV-85B', -63.112003, -17.782370),\n" +
                "(127,'174','0',8,'7','ET-33', -63.117420, -17.783400),\n" +
                "(128,'272','0',9,'7','UV-227', -63.103317, -17.789659),\n" +
                "(129,'389','0',0,'7','UV-226', -63.102928, -17.782294),\n" +
                "(130,'390','0',0,'7','UV-226', -63.103319, -17.775756),\n" +
                "(131,'391','0',0,'7','UV-232', -63.095224, -17.796109),\n" +
                "(132,'392','0',0,'7','UV-231', -63.096465, -17.791660),\n" +
                "(133,'393','0',0,'7','UV-233', -63.094272, -17.800413),\n" +
                "(134,'73','0',5,'1','UV-59A', -63.196604, -17.750802),\n" +
                "(135,'198','0',3,'1','ET-20', -63.199631, -17.766321),\n" +
                "(136,'148','0',8,'7','UV-100', -63.114298, -17.810140),\n" +
                "(137,'149','0',7,'7','UV-99', -63.123753, -17.810461),\n" +
                "(138,'151','0',6,'7','UV-98', -63.132433, -17.809833),\n" +
                "(139,'157','0',7,'7','UV-89', -63.123070, -17.799658),\n" +
                "(140,'158','0',7,'7','UV-87', -63.122563, -17.794775),\n" +
                "(141,'167','0',8,'7','UV-88', -63.112706, -17.795209),\n" +
                "(142,'168','0',8,'7','UV-90', -63.112273, -17.800179),\n" +
                "(143,'170','0',8,'7','ET-36', -63.117874, -17.799864),\n" +
                "(144,'171','0',8,'7','ET-37', -63.116255, -17.799978),\n" +
                "(145,'172','0',8,'7','ET-35', -63.117545, -17.795002),\n" +
                "(146,'268','0',9,'7','UV-100A', -63.105810, -17.809571),\n" +
                "(147,'269','0',9,'7','UV-229A', -63.104173, -17.804363),\n" +
                "(148,'270','0',9,'7','UV-229', -63.103593, -17.799661),\n" +
                "(149,'271','0',9,'7','UV-228', -63.103851, -17.795548),\n" +
                "(150,'394','0',0,'7','UV-234', -63.095548, -17.804211),\n" +
                "(151,'58','0',4,'2','UV-39', -63.161241, -17.757469),\n" +
                "(152,'59','0',4,'2','UV-40', -63.154436, -17.763438),\n" +
                "(153,'152','0',6,'7','UV-97', -63.138930, -17.809595),\n" +
                "(154,'153','0',6,'7','UV-93', -63.138506, -17.804040),\n" +
                "(155,'159','0',6,'7','UV-86', -63.133465, -17.796693),\n" +
                "(156,'163','0',7,'7','UV-84', -63.122655, -17.789105),\n" +
                "(157,'166','0',8,'7','UV-85', -63.112391, -17.789637),\n" +
                "(158,'173','0',8,'7','ET-34', -63.117174, -17.789453),\n" +
                "(159,'28','0',3,'2','UV-15', -63.178841, -17.764846),\n" +
                "(160,'29','0',3,'2','UV-16', -63.173092, -17.765077),\n" +
                "(161,'30','0',3,'2','UV-17', -63.166379, -17.766114),\n" +
                "(162,'31','0',3,'2','UV-18', -63.162081, -17.770003),\n" +
                "(163,'32','0',3,'2','UV-19', -63.160242, -17.774899),\n" +
                "(164,'33','0',3,'2','UV-20', -63.159590, -17.779483),\n" +
                "(165,'34','0',3,'2','UV-21', -63.160600, -17.783858),\n" +
                "(166,'56','0',4,'2','UV-37', -63.174142, -17.754025),\n" +
                "(167,'57','0',4,'2','UV-38', -63.168612, -17.755141),\n" +
                "(168,'192','0',3,'2','ET-2', -63.170773, -17.759300),\n" +
                "(169,'193','0',3,'2','ET-1', -63.176510, -17.758692),\n" +
                "(170,'35','0',4,'2','UV-22', -63.155099, -17.784268),\n" +
                "(171,'60','0',4,'2','UV-41', -63.150761, -17.771309),\n" +
                "(172,'61','0',4,'2','UV-42', -63.150422, -17.778167),\n" +
                "(173,'62','0',4,'2','UV-43', -63.150786, -17.782983),\n" +
                "(174,'188','0',3,'2','ET-5', -63.155048, -17.773224),\n" +
                "(175,'189','0',3,'2','ET-6', -63.154006, -17.778777),\n" +
                "(176,'190','0',3,'2','ET-4', -63.157942, -17.767013),\n" +
                "(177,'191','0',3,'2','ET-3', -63.163624, -17.761844),\n" +
                "(178,'78','0',5,'3','UV-80', -63.146218, -17.795187),\n" +
                "(179,'79','0',5,'3','UV-91', -63.146034, -17.802493),\n" +
                "(180,'80','0',5,'3','UV-91A', -63.147618, -17.807406),\n" +
                "(181,'81','0',5,'3','UV-92', -63.152601, -17.812158),\n" +
                "(182,'499','0',4,'3','ED-1', -63.156428, -17.788892),\n" +
                "(183,'500','0',4,'3','UV-43B', -63.153034, -17.793963),\n" +
                "(184,'507','0',3,'3','UV-23', -63.164061, -17.791605),\n" +
                "(185,'38','0',4,'3','UV-45', -63.159528, -17.806516),\n" +
                "(186,'39','0',4,'3','UV-46', -63.166390, -17.810600),\n" +
                "(187,'209','0',3,'3','ET-7', -63.162104, -17.803384),\n" +
                "(188,'208','0',3,'3','ET-8', -63.168838, -17.806938),\n" +
                "(189,'36','0',3,'3','UV-24', -63.163397, -17.798628),\n" +
                "(190,'37','0',4,'3','UV-44', -63.155350, -17.800401),\n" +
                "(191,'20','0',3,'4','UV-29', -63.198373, -17.796714),\n" +
                "(192,'45','0',4,'4','UV-52', -63.208396, -17.802577),\n" +
                "(193,'204','0',3,'4','ET-14', -63.202806, -17.799687),\n" +
                "(194,'19','0',3,'4','UV-28', -63.193599, -17.804469),\n" +
                "(195,'40','0',4,'4','UV-47', -63.173817, -17.816156),\n" +
                "(196,'41','0',4,'4','UV-48', -63.180325, -17.818043),\n" +
                "(197,'42','0',4,'4','UV-49', -63.186865, -17.817698),\n" +
                "(198,'206','0',3,'4','ET-10', -63.180093, -17.812464),\n" +
                "(199,'43','0',4,'4','UV-50', -63.193969, -17.816533),\n" +
                "(200,'44','0',4,'4','UV-51', -63.201255, -17.811530),\n" +
                "(201,'215','0',3,'4','ET-13', -63.197874, -17.806743),\n" +
                "(202,'216','0',3,'4','ET-12', -63.193109, -17.810494),\n" +
                "(203,'76','0',5,'5','UV-67', -63.157580, -17.749886),\n" +
                "(204,'212','0',5,'5','UV-67', -63.153013, -17.752308),\n" +
                "(205,'119','0',6,'5','UV-70', -63.159967, -17.739540),\n" +
                "(206,'121','0',6,'5','UV-68', -63.173932, -17.734922),\n" +
                "(207,'130','0',6,'5','ET-30', -63.162972, -17.738256),\n" +
                "(208,'217','0',5,'1','UV-64', -63.180072, -17.741448),\n" +
                "(209,'252','0',0,'5','UV-194', -63.145549, -17.710378),\n" +
                "(210,'388','0',0,'6','UV-224', -63.129847, -17.726014),\n" +
                "(211,'402','0',9,'5','UV-195', -63.137552, -17.722371),\n" +
                "(212,'475','0',8,'5','UV-79', -63.139419, -17.732226),\n" +
                "(213,'476','0',0,'5','UV-195', -63.133838, -17.723969),\n" +
                "(214,'132','0',8,'5','UV-79', -63.143454, -17.729410),\n" +
                "(215,'133','0',8,'5','UV-78', -63.151260, -17.725330),\n" +
                "(216,'134','0',8,'5','ET-28', -63.155697, -17.723696),\n" +
                "(217,'123','0',7,'5','UV-73', -63.163514, -17.729719),\n" +
                "(218,'124','0',7,'5','UV-72', -63.170790, -17.727119),\n" +
                "(219,'128','0',7,'5','UV-75', -63.148201, -17.736523),\n" +
                "(220,'129','0',7,'5','UV-74', -63.155495, -17.732719),\n" +
                "(221,'131','0',7,'5','ET-29', -63.159463, -17.731366),\n" +
                "(222,'213','0',7,'5','UV-75', -63.144194, -17.739286),\n" +
                "(223,'219','0',6,'5','UV-71', -63.149370, -17.746924),\n" +
                "(224,'220','0',6,'5','UV-71', -63.147262, -17.743820),\n" +
                "(225,'74','0',5,'5','UV-65', -63.170572, -17.745849),\n" +
                "(226,'75','0',5,'5','UV-66', -63.165095, -17.747265),\n" +
                "(227,'118','0',6,'5','UV-71', -63.153248, -17.743006),\n" +
                "(228,'120','0',6,'5','UV-69', -63.166805, -17.737196),\n" +
                "(229,'122','0',6,'5','ET-25', -63.177192, -17.730350),\n" +
                "(230,'126','0',8,'5','UV-77', -63.160048, -17.722000),\n" +
                "(231,'77','0',5,'6','UV-140', -63.144616, -17.782654),\n" +
                "(232,'175','0',7,'6','UV-141', -63.124534, -17.775505),\n" +
                "(233,'464','0',0,'6','FFCC', -63.132486, -17.784818),\n" +
                "(234,'465','0',0,'6','FFCC', -63.137035, -17.781030),\n" +
                "(235,'466','0',0,'6','', -63.129353, -17.777138),\n" +
                "(236,'0','0',0,'6','ET 68', 0.000000, 0.000000),\n" +
                "(237,'176','0',7,'6','UV-153', -63.118815, -17.773460),\n" +
                "(238,'178','0',8,'6','ET-49', -63.111874, -17.774829),\n" +
                "(239,'179','0',8,'6','ET-50', -63.113411, -17.777786),\n" +
                "(240,'181','0',7,'6','UV-141B', -63.120232, -17.764333),\n" +
                "(241,'177','0',8,'6','UV-154', -63.112226, -17.770572),\n" +
                "(242,'273','0',9,'6','UV-155', -63.102469, -17.768497),\n" +
                "(243,'183','0',8,'6','UV-152', -63.111508, -17.759256),\n" +
                "(244,'275','0',9,'6','UV-199', -63.096210, -17.759274),\n" +
                "(245,'277','0',9,'6','UV-197', -63.104915, -17.751670),\n" +
                "(246,'214','0',7,'6','ET-32', -63.124104, -17.759745),\n" +
                "(247,'184','0',7,'6','UV-151', -63.125403, -17.754551),\n" +
                "(248,'185','0',8,'6','UV-144A', -63.116819, -17.750941),\n" +
                "(249,'186','0',8,'6','UV-144', -63.120627, -17.742633),\n" +
                "(250,'278','0',0,'6','UV-197', -63.108570, -17.744008)";

}
