package homework3.processors

import homework3.Processor
import homework3.http.HttpResponse

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object BrokenLinkDetector extends Processor[Set[String]] {
  def apply(url: String, response: HttpResponse): Future[Set[String]] = Future {
    response.status match {
      case 404 => Set(url)
      case _ => Set.empty
    }
  }
}
