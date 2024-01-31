import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.must.Matchers

class GithubUserSpec extends AnyFeatureSpec with GivenWhenThen with Matchers :
  Feature("Github API User"):
    Scenario("GitHub user exists"):
      Given("GitHub user exists")
      val username = "kkomorowski"
      When("the /user/{username} endpoint is called")
      val response = requests.get(s"https://api.github.com/users/$username")
      Then("response has HTTP status code 200")
      response.statusCode mustBe 200
