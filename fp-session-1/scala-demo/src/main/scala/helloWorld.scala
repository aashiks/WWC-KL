import scala.collection.immutable
import scala.io.Source
import play.api.libs.json._

object ComputeAverage {
  def main(args: Array[String]) = {
    val data = fetchData();
    processData(data)
    println("!!!");
  }


  def processData(data:String)= {
   val rawData =  Json.parse(data)
   val carrotRecords =  (rawData \ "records").as[JsArray].value.filter( p =>
      p.\("commodity").toString().replace("\"","").equalsIgnoreCase("Cotton")
    )

    val min_average = carrotRecords.foldLeft(0)( (total:Int,p:JsValue) =>
      total + p.\("min_price").toString().replace("\"","").toInt
    )/carrotRecords.size

    val max_average = carrotRecords.foldLeft(0)( (total:Int,p:JsValue) =>
      total + p.\("max_price").toString().replace("\"","").toInt
    )/carrotRecords.size

    println("MIN AVG: " + min_average)
    println("MAX AVG: " + max_average)
  }
  def fetchData() = {

    val url = "https://data.gov.in/api/datastore/resource.json?resource_id=9ef84268-d588-465a-a308-a864a43d0070&api-key=283f9ef8c8a51d2d55b3a84766823aa2"
    Source.fromURL(url).mkString
  }
}
