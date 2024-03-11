import org.scalatest.{EitherValues, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.must.Matchers
import sttp.client3.circe.asJson
import sttp.client3.quick.simpleHttpClient
import sttp.client3.{UriContext, quickRequest}
import sttp.model.StatusCode
import sttp.model.StatusCode.{NotFound, Ok}

class GitHubUserDetailsSpec extends AnyFeatureSpec with GivenWhenThen with Matchers with EitherValues:

  import io.circe.generic.auto._

  case class GitHubUserProfile(login: String, blog: String, email: Option[String])

  Feature("GitHub User Profile Details"):

    Scenario("GitHub User Details Check"):
      Given("GitHub user exists")
      val request = quickRequest
        .get(uri"https://api.github.com/users/kkomorowski")
        .response(asJson[GitHubUserProfile])
      When("I send the request for a GitHub User Profile")
      val response = simpleHttpClient.send(request)
      Then("I get the response with status 'OK'")
      response.code mustBe Ok
      And("the response body contains correct user, blog and email address")
      val user = response.body.value
      user.login mustBe "kkomorowski"
      user.blog mustBe "https://hiquality.dev"
      user.email mustBe empty

    Scenario("GitHub User Details Check - Failing"):
      Given("GitHub user does not exists")
      val request = quickRequest
        .get(uri"https://api.github.com/users/yx-oyn-qzg-dun2a7")
        .response(asJson[GitHubUserProfile])
      When("I send the request for a GitHub User Profile")
      val response = simpleHttpClient.send(request)
      info(response.body.toString)
      Then("I get the response with status 'Not Found'")
      response.code mustBe NotFound
      response.body.isRight mustBe true
