package com.Json.Mongo.handelers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.thrift.TException;
import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Json.Mongo.services.*;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

@Service
//@RequestMapping
public class InsertServiceHandler implements InsertService.Iface {

	@Override
	public String InsertJSON(String JSONStr) throws TException {
		// TODO Auto-generated method stub
		
		//JSONStr = "{'ElementName':'R4B','Spectra':'exc','Phase':'film 1','WaveLength':'em630','Coordinates':[{'WaveLength':300.0,'Y':6483.4209},{'WaveLength':301.0,'Y':6009.771},{'WaveLength':302.0,'Y':6041.47998},{'WaveLength':303.0,'Y':5538.16797},{'WaveLength':304.0,'Y':5532.56396},{'WaveLength':305.0,'Y':5056.44971},{'WaveLength':306.0,'Y':4746.52539},{'WaveLength':307.0,'Y':4771.62695},{'WaveLength':308.0,'Y':4543.26953},{'WaveLength':309.0,'Y':4463.26563},{'WaveLength':310.0,'Y':4042.29883},{'WaveLength':311.0,'Y':4010.57568},{'WaveLength':312.0,'Y':3935.69751},{'WaveLength':313.0,'Y':3638.6604},{'WaveLength':314.0,'Y':3525.7749},{'WaveLength':315.0,'Y':3649.67944},{'WaveLength':316.0,'Y':3230.55493},{'WaveLength':317.0,'Y':3456.98193},{'WaveLength':318.0,'Y':2939.53516},{'WaveLength':319.0,'Y':2847.25122},{'WaveLength':320.0,'Y':2843.16406},{'WaveLength':321.0,'Y':2574.10889},{'WaveLength':322.0,'Y':2488.60596},{'WaveLength':323.0,'Y':2390.21582},{'WaveLength':324.0,'Y':2302.59766},{'WaveLength':325.0,'Y':2203.61255},{'WaveLength':326.0,'Y':2237.2312},{'WaveLength':327.0,'Y':2128.31323},{'WaveLength':328.0,'Y':1959.7677},{'WaveLength':329.0,'Y':1845.4281},{'WaveLength':330.0,'Y':1867.61816},{'WaveLength':331.0,'Y':1825.86145},{'WaveLength':332.0,'Y':1705.59644},{'WaveLength':333.0,'Y':1701.77246},{'WaveLength':334.0,'Y':1602.85425},{'WaveLength':335.0,'Y':1536.66492},{'WaveLength':336.0,'Y':1406.4115},{'WaveLength':337.0,'Y':1427.04883},{'WaveLength':338.0,'Y':1409.76379},{'WaveLength':339.0,'Y':1406.97583},{'WaveLength':340.0,'Y':1300.91956},{'WaveLength':341.0,'Y':1361.71826},{'WaveLength':342.0,'Y':1293.9812},{'WaveLength':343.0,'Y':1294.32727},{'WaveLength':344.0,'Y':1248.24487},{'WaveLength':345.0,'Y':1245.94116},{'WaveLength':346.0,'Y':1290.42468},{'WaveLength':347.0,'Y':1245.47083},{'WaveLength':348.0,'Y':1248.79822},{'WaveLength':349.0,'Y':1324.21228},{'WaveLength':350.0,'Y':1316.89368},{'WaveLength':351.0,'Y':1242.15137},{'WaveLength':352.0,'Y':1294.1355},{'WaveLength':353.0,'Y':1420.55383},{'WaveLength':354.0,'Y':1575.36719},{'WaveLength':355.0,'Y':1518.86646},{'WaveLength':356.0,'Y':1602.72681},{'WaveLength':357.0,'Y':1798.66919},{'WaveLength':358.0,'Y':1989.40979},{'WaveLength':359.0,'Y':2249.09497},{'WaveLength':360.0,'Y':2376.53662},{'WaveLength':361.0,'Y':2264.5127},{'WaveLength':362.0,'Y':2246.40161},{'WaveLength':363.0,'Y':2566.20483},{'WaveLength':364.0,'Y':2701.86572},{'WaveLength':365.0,'Y':2844.68408},{'WaveLength':366.0,'Y':2914.50391},{'WaveLength':367.0,'Y':2847.86816},{'WaveLength':368.0,'Y':2979.48438},{'WaveLength':369.0,'Y':3749.98242},{'WaveLength':370.0,'Y':4310.21094},{'WaveLength':371.0,'Y':4570.48926},{'WaveLength':372.0,'Y':4468.75879},{'WaveLength':373.0,'Y':4031.99121},{'WaveLength':374.0,'Y':4018.98853},{'WaveLength':375.0,'Y':3659.95068},{'WaveLength':376.0,'Y':3530.27734},{'WaveLength':377.0,'Y':3345.54175},{'WaveLength':378.0,'Y':3484.69287},{'WaveLength':379.0,'Y':3372.53418},{'WaveLength':380.0,'Y':3237.70215},{'WaveLength':381.0,'Y':2956.66577},{'WaveLength':382.0,'Y':3243.01855},{'WaveLength':383.0,'Y':3006.16602},{'WaveLength':384.0,'Y':2954.52246},{'WaveLength':385.0,'Y':2839.85522},{'WaveLength':386.0,'Y':3250.12354},{'WaveLength':387.0,'Y':3292.59766},{'WaveLength':388.0,'Y':3554.12891},{'WaveLength':389.0,'Y':3360.43359},{'WaveLength':390.0,'Y':3260.77002},{'WaveLength':391.0,'Y':3232.88525},{'WaveLength':392.0,'Y':3205.11743},{'WaveLength':393.0,'Y':3409.66479},{'WaveLength':394.0,'Y':3316.91235},{'WaveLength':395.0,'Y':3171.37158},{'WaveLength':396.0,'Y':3119.41602},{'WaveLength':397.0,'Y':2859.53125},{'WaveLength':398.0,'Y':2867.79956},{'WaveLength':399.0,'Y':2958.74609},{'WaveLength':400.0,'Y':2877.64136},{'WaveLength':401.0,'Y':2888.98999},{'WaveLength':402.0,'Y':2687.60205},{'WaveLength':403.0,'Y':2865.66797},{'WaveLength':404.0,'Y':2807.65796},{'WaveLength':405.0,'Y':2805.27173},{'WaveLength':406.0,'Y':2856.65991},{'WaveLength':407.0,'Y':2843.06128},{'WaveLength':408.0,'Y':2680.24658},{'WaveLength':409.0,'Y':2661.7627},{'WaveLength':410.0,'Y':2238.91064},{'WaveLength':411.0,'Y':2059.24561},{'WaveLength':412.0,'Y':2096.323},{'WaveLength':413.0,'Y':2183.17041},{'WaveLength':414.0,'Y':2118.51758},{'WaveLength':415.0,'Y':2114.74512},{'WaveLength':416.0,'Y':2219.51611},{'WaveLength':417.0,'Y':2179.39087},{'WaveLength':418.0,'Y':2061.51685},{'WaveLength':419.0,'Y':2047.15088},{'WaveLength':420.0,'Y':1919.38647},{'WaveLength':421.0,'Y':1912.30127},{'WaveLength':422.0,'Y':1891.39136},{'WaveLength':423.0,'Y':1969.76404},{'WaveLength':424.0,'Y':1915.49927},{'WaveLength':425.0,'Y':1846.04614},{'WaveLength':426.0,'Y':1880.97058},{'WaveLength':427.0,'Y':1744.68823},{'WaveLength':428.0,'Y':1646.2146},{'WaveLength':429.0,'Y':1667.23584},{'WaveLength':430.0,'Y':1585.95923},{'WaveLength':431.0,'Y':1618.41455},{'WaveLength':432.0,'Y':1652.98315},{'WaveLength':433.0,'Y':1675.47144},{'WaveLength':434.0,'Y':1687.72827},{'WaveLength':435.0,'Y':1750.2821},{'WaveLength':436.0,'Y':1624.79028},{'WaveLength':437.0,'Y':1787.86157},{'WaveLength':438.0,'Y':1624.302},{'WaveLength':439.0,'Y':1528.69482},{'WaveLength':440.0,'Y':1502.21484},{'WaveLength':441.0,'Y':1498.30444},{'WaveLength':442.0,'Y':1361.91199},{'WaveLength':443.0,'Y':1557.64001},{'WaveLength':444.0,'Y':1369.63794},{'WaveLength':445.0,'Y':1316.71582},{'WaveLength':446.0,'Y':1381.60291},{'WaveLength':447.0,'Y':1322.10522},{'WaveLength':448.0,'Y':1404.8147},{'WaveLength':449.0,'Y':1320.29932},{'WaveLength':450.0,'Y':1321.07104},{'WaveLength':451.0,'Y':1274.9895},{'WaveLength':452.0,'Y':1181.9856},{'WaveLength':453.0,'Y':1153.93506},{'WaveLength':454.0,'Y':1062.23291},{'WaveLength':455.0,'Y':1070.55872},{'WaveLength':456.0,'Y':1099.62305},{'WaveLength':457.0,'Y':1064.36426},{'WaveLength':458.0,'Y':1106.94165},{'WaveLength':459.0,'Y':1110.97986},{'WaveLength':460.0,'Y':975.579468},{'WaveLength':461.0,'Y':1015.93872},{'WaveLength':462.0,'Y':972.124268},{'WaveLength':463.0,'Y':956.545288},{'WaveLength':464.0,'Y':952.976624},{'WaveLength':465.0,'Y':982.192932},{'WaveLength':466.0,'Y':1018.8623},{'WaveLength':467.0,'Y':985.994873},{'WaveLength':468.0,'Y':1074.52112},{'WaveLength':469.0,'Y':1025.91748},{'WaveLength':470.0,'Y':960.818542},{'WaveLength':471.0,'Y':974.993896},{'WaveLength':472.0,'Y':1087.23926},{'WaveLength':473.0,'Y':1128.39954},{'WaveLength':474.0,'Y':1037.88708},{'WaveLength':475.0,'Y':1083.26245},{'WaveLength':476.0,'Y':1072.94836},{'WaveLength':477.0,'Y':1142.0863},{'WaveLength':478.0,'Y':1194.71875},{'WaveLength':479.0,'Y':1248.37683},{'WaveLength':480.0,'Y':1243.69885},{'WaveLength':481.0,'Y':1218.50415},{'WaveLength':482.0,'Y':1384.31177},{'WaveLength':483.0,'Y':1456.68506},{'WaveLength':484.0,'Y':1473.72876},{'WaveLength':485.0,'Y':1481.12244},{'WaveLength':486.0,'Y':1469.08374},{'WaveLength':487.0,'Y':1411.5564},{'WaveLength':488.0,'Y':1503.08936},{'WaveLength':489.0,'Y':1479.82361},{'WaveLength':490.0,'Y':1574.95398},{'WaveLength':491.0,'Y':1597.72437},{'WaveLength':492.0,'Y':1704.30176},{'WaveLength':493.0,'Y':1809.94727},{'WaveLength':494.0,'Y':1801.72168},{'WaveLength':495.0,'Y':1916.71558},{'WaveLength':496.0,'Y':2086.30957},{'WaveLength':497.0,'Y':2020.97852},{'WaveLength':498.0,'Y':2206.42969},{'WaveLength':499.0,'Y':2136.35229},{'WaveLength':500.0,'Y':2222.98779},{'WaveLength':501.0,'Y':2230.43359},{'WaveLength':502.0,'Y':2408.3667},{'WaveLength':503.0,'Y':2512.7019},{'WaveLength':504.0,'Y':2622.0127},{'WaveLength':505.0,'Y':2659.39014},{'WaveLength':506.0,'Y':2629.96313},{'WaveLength':507.0,'Y':2638.24463},{'WaveLength':508.0,'Y':2703.50464},{'WaveLength':509.0,'Y':2639.05469},{'WaveLength':510.0,'Y':2627.81177},{'WaveLength':511.0,'Y':2803.09082},{'WaveLength':512.0,'Y':2779.18481},{'WaveLength':513.0,'Y':2788.62183},{'WaveLength':514.0,'Y':2920.53076},{'WaveLength':515.0,'Y':2886.60742},{'WaveLength':516.0,'Y':3106.43384},{'WaveLength':517.0,'Y':2842.35596},{'WaveLength':518.0,'Y':2967.74707},{'WaveLength':519.0,'Y':2924.49048},{'WaveLength':520.0,'Y':3108.19873},{'WaveLength':521.0,'Y':3179.69897},{'WaveLength':522.0,'Y':3126.61743},{'WaveLength':523.0,'Y':3256.2168},{'WaveLength':524.0,'Y':3132.07422},{'WaveLength':525.0,'Y':3357.75293},{'WaveLength':526.0,'Y':3540.89941},{'WaveLength':527.0,'Y':3407.65552},{'WaveLength':528.0,'Y':3422.88989},{'WaveLength':529.0,'Y':3428.48218},{'WaveLength':530.0,'Y':3289.09766},{'WaveLength':531.0,'Y':3456.43408},{'WaveLength':532.0,'Y':3410.60205},{'WaveLength':533.0,'Y':3522.91699},{'WaveLength':534.0,'Y':3493.32275},{'WaveLength':535.0,'Y':3411.81665},{'WaveLength':536.0,'Y':3655.69238},{'WaveLength':537.0,'Y':3700.36108},{'WaveLength':538.0,'Y':3607.34326},{'WaveLength':539.0,'Y':3735.92139},{'WaveLength':540.0,'Y':3695.50439},{'WaveLength':541.0,'Y':3544.91431},{'WaveLength':542.0,'Y':3368.19092},{'WaveLength':543.0,'Y':3602.95923},{'WaveLength':544.0,'Y':3462.41553},{'WaveLength':545.0,'Y':3498.99463},{'WaveLength':546.0,'Y':3661.37695},{'WaveLength':547.0,'Y':3425.40869},{'WaveLength':548.0,'Y':3472.80469},{'WaveLength':549.0,'Y':3620.58984},{'WaveLength':550.0,'Y':3580.72314},{'WaveLength':551.0,'Y':3417.41455},{'WaveLength':552.0,'Y':3534.20947},{'WaveLength':553.0,'Y':3640.61353},{'WaveLength':554.0,'Y':3696.61377},{'WaveLength':555.0,'Y':3901.60303},{'WaveLength':556.0,'Y':3775.18213},{'WaveLength':557.0,'Y':3803.57715},{'WaveLength':558.0,'Y':3821.54395},{'WaveLength':559.0,'Y':4067.39209},{'WaveLength':560.0,'Y':4198.2041},{'WaveLength':561.0,'Y':4309.33252},{'WaveLength':562.0,'Y':4133.12109},{'WaveLength':563.0,'Y':4036.50146},{'WaveLength':564.0,'Y':4190.94092},{'WaveLength':565.0,'Y':4100.8916},{'WaveLength':566.0,'Y':4028.4541},{'WaveLength':567.0,'Y':4251.90527},{'WaveLength':568.0,'Y':4347.06592},{'WaveLength':569.0,'Y':4467.39893},{'WaveLength':570.0,'Y':4230.66016},{'WaveLength':571.0,'Y':4257.96973},{'WaveLength':572.0,'Y':4356.80518},{'WaveLength':573.0,'Y':4618.80615},{'WaveLength':574.0,'Y':4268.75488},{'WaveLength':575.0,'Y':4465.66064},{'WaveLength':576.0,'Y':4263.6084},{'WaveLength':577.0,'Y':4467.30371},{'WaveLength':578.0,'Y':4538.25},{'WaveLength':579.0,'Y':4404.89404},{'WaveLength':580.0,'Y':4593.771},{'WaveLength':581.0,'Y':4197.10889},{'WaveLength':582.0,'Y':4507.38428},{'WaveLength':583.0,'Y':4376.27441},{'WaveLength':584.0,'Y':4076.28711},{'WaveLength':585.0,'Y':4261.03223},{'WaveLength':586.0,'Y':3963.44775},{'WaveLength':587.0,'Y':4190.48535},{'WaveLength':588.0,'Y':3889.56079},{'WaveLength':589.0,'Y':4061.93799},{'WaveLength':590.0,'Y':3848.70215},{'WaveLength':591.0,'Y':3620.0127},{'WaveLength':592.0,'Y':3707.39502},{'WaveLength':593.0,'Y':3585.86816},{'WaveLength':594.0,'Y':3072.37866},{'WaveLength':595.0,'Y':3218.3125},{'WaveLength':596.0,'Y':3063.98779},{'WaveLength':597.0,'Y':2746.10693},{'WaveLength':598.0,'Y':2587.59448},{'WaveLength':599.0,'Y':2618.03735},{'WaveLength':600.0,'Y':2404.41553},{'WaveLength':601.0,'Y':2409.14258},{'WaveLength':602.0,'Y':2162.93701},{'WaveLength':603.0,'Y':2036.77539},{'WaveLength':604.0,'Y':1814.48962},{'WaveLength':605.0,'Y':1758.25476},{'WaveLength':606.0,'Y':1692.20801},{'WaveLength':607.0,'Y':1583.50244},{'WaveLength':608.0,'Y':1531.99622},{'WaveLength':609.0,'Y':1438.32861},{'WaveLength':610.0,'Y':1262.57776},{'WaveLength':611.0,'Y':1265.93079},{'WaveLength':612.0,'Y':1200.97668},{'WaveLength':613.0,'Y':1282.42285},{'WaveLength':614.0,'Y':1194.46313},{'WaveLength':615.0,'Y':1165.71033},{'WaveLength':616.0,'Y':1157.14404},{'WaveLength':617.0,'Y':1075.02734},{'WaveLength':618.0,'Y':1177.06641},{'WaveLength':619.0,'Y':1196.75049},{'WaveLength':620.0,'Y':1304.70801}]}";
	       
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://sgauser:sgauser@sgamongodb-shard-00-00-ceccc.mongodb.net:27017,sgamongodb-shard-00-01-ceccc.mongodb.net:27017,sgamongodb-shard-00-02-ceccc.mongodb.net:27017/test?ssl=true&replicaSet=SGAMongoDb-shard-0&authSource=admin&retryWrites=true"));
        MongoDatabase database = mongoClient.getDatabase("testdb2");
        
        MongoCollection<Document> contCol = database.getCollection("wav5");
//        System.out.println("Printing");
        
        JSONParser parser1 = new JSONParser(); 
        try {
			JSONObject json = (JSONObject) parser1.parse(JSONStr);
			String fileName = json.get("ElementName")+"_"+json.get("Phase")+"_"+json.get("Spectra")+"_"+json.get("WaveLength");
			json.put("FileName", fileName);
//			System.out.println(fileName);
//			System.out.println(json.get("FileName"));
			contCol.insertOne(new Document(json));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        System.out.println("INSERTED");
		return "Inserted";

        
	}
}
