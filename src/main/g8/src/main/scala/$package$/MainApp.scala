package $package$

import org.apache.spark.sql.SparkSession

object MainApp {
  def main(args: Array[String]): Unit = {
    val session = SparkSession
      .builder()
      .master("local")
      .appName("MainApp")
      .config("spark.sql.wharehouse.dir", "/user/hive/warehouse")
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