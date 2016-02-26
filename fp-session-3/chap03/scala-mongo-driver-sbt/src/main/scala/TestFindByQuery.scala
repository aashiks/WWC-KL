import com.scalainaction.mongo._
import com.mongodb.BasicDBObject

object TestFindQuery extends App{

def client = new MongoClient
def db = client.db("mydb")
val col = db.readOnlyCollection("test")
val updatableCol = db.updatableCollection("test")
for(i <- 1 to 100) updatableCol += new BasicDBObject("X", i)

val rangeQuery = new BasicDBObject("X", new BasicDBObject("$gt", 20))
val richQuery = Query(rangeQuery).skip(20).limit(10)
val cursor = col.find(richQuery)
while(cursor.hasNext()) {
  println(cursor.next());
}

}
