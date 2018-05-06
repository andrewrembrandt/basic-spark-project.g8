package $package$

import org.apache.spark.sql.SparkSession

object MainApp {
  def main(args: Array[String]): Unit = {
    val session = SparkSession
      .builder()
      .master("local")
      .appName("MainApp")
      .config("spark.sql.wharehouse.dir", "/user/hive/warehouse")
      .config("spark.sql.hive.metastore.version", "2.1")
      .config("spark.sql.hive.metastore.jars", sys.env.get("HIVE_HOME").map(hh => s"$hh/lib/*").getOrElse("maven"))
      .enableHiveSupport()
      .getOrCreate()

    Etl.process(session)

    session.stop()
  }
}

object Etl {
  def process(session: SparkSession) = {
    val sc = session.sparkContext

    import session.implicits._

  }
}