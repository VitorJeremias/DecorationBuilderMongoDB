package database;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import modelo.Acoes;

public class DBManager {

	MongoClientURI uri = new MongoClientURI(
			"mongodb+srv://vitor:Vitorjeremias@foecluster-fpnpw.mongodb.net/admin?retryWrites=true&w=majority");
	public static MongoClient mongoClient = null;

	public DBManager() throws UnknownHostException {

		mongoClient = new MongoClient(uri);
	}

	public DB getDB() throws UnknownHostException {
		DB db = mongoClient.getDB("db");
		
		
		return db;

	}

	public DBCollection getDBCollection() throws UnknownHostException {
		DBCollection col = getDB().getCollection("users");
		return col;
	}

	public void updateData() throws UnknownHostException {
		DBCollection col = getDBCollection();
		List<Integer> quantidades = new ArrayList<Integer>();
		quantidades.add(0, Acoes.getPlantaReward());
		quantidades.add(1, Acoes.getPfReward());
		quantidades.add(2, Acoes.getAiDataReward());
		quantidades.add(3, Acoes.getBioplasticoReward());
		quantidades.add(4, Acoes.getNanofioReward());
		quantidades.add(5, Acoes.getBateriaReward());
		quantidades.add(6, Acoes.getGasolinaReward());
		quantidades.add(7, Acoes.getMedalReward());
		quantidades.add(8, Acoes.getCoinReward());
		quantidades.add(9, Acoes.getSupplyReward());

		for (int i = 1; i < col.getCount() + 1; i++) {
			DBObject filter = BasicDBObjectBuilder.start().add("_id", i).get();
			DBObject updatedValue = BasicDBObjectBuilder.start().add("Qtd", quantidades.get(i - 1)).get();
			DBObject updateOperationDocument = BasicDBObjectBuilder.start().add("$set", updatedValue).get();
			if (filter != null) {
				col.update(filter, updateOperationDocument);
			}
		}
		System.err.println("Rewards updated!");
	}

	public List<Integer> getQuantidades() throws UnknownHostException {
		DBCollection col = getDBCollection();
		List<Integer> quantidades = new ArrayList<Integer>();
		for (int i = 1; i < col.getCount() + 1; i++) {

			DBObject query = BasicDBObjectBuilder.start().add("_id", i).get();
			// System.out.println(col.findOne(query).get("Qtd"));
			quantidades.add(i - 1);
			quantidades.set(i - 1, (Integer) col.findOne(query).get("Qtd"));
		}
		// mongoClient.close();
		return quantidades;
	}

	public void insertData() throws UnknownHostException {
		DBCollection col = getDBCollection();

		List<DBObject> docs = new ArrayList<DBObject>();

		DBObject doc1 = new BasicDBObject();
		doc1.put("_id", 1);
		doc1.put("Reward", "Plantas");
		doc1.put("Qtd", 269);

		DBObject doc2 = new BasicDBObject();
		doc2.put("_id", 2);
		doc2.put("Reward", "PF");
		doc2.put("Qtd", 256);

		DBObject doc3 = new BasicDBObject();
		doc3.put("_id", 3);
		doc3.put("Reward", "Dados de IA");
		doc3.put("Qtd", 297);

		DBObject doc4 = new BasicDBObject();
		doc4.put("_id", 4);
		doc4.put("Reward", "Bioplásticos");
		doc4.put("Qtd", 267);

		DBObject doc5 = new BasicDBObject();
		doc5.put("_id", 5);
		doc5.put("Reward", "Nanofios");
		doc5.put("Qtd", 265);

		DBObject doc6 = new BasicDBObject();
		doc6.put("_id", 6);
		doc6.put("Reward", "Baterias de papel");
		doc6.put("Qtd", 278);

		DBObject doc7 = new BasicDBObject();
		doc7.put("_id", 7);
		doc7.put("Reward", "Gasolina Transester");
		doc7.put("Qtd", 282);

		DBObject doc8 = new BasicDBObject();
		doc8.put("_id", 8);
		doc8.put("Reward", "Medalhas");
		doc8.put("Qtd", 266);

		DBObject doc9 = new BasicDBObject();
		doc9.put("_id", 9);
		doc9.put("Reward", "Moedas");
		doc9.put("Qtd", 769);

		DBObject doc10 = new BasicDBObject();
		doc10.put("_id", 10);
		doc10.put("Reward", "Mantimentos");
		doc10.put("Qtd", 827);

		docs.add(doc1);
		docs.add(doc2);
		docs.add(doc3);
		docs.add(doc4);
		docs.add(doc5);
		docs.add(doc6);
		docs.add(doc7);
		docs.add(doc8);
		docs.add(doc9);
		docs.add(doc10);

		System.out.println(docs);
		col.insert(docs);

		// close resources
		DBManager.mongoClient.close();
	}

}
