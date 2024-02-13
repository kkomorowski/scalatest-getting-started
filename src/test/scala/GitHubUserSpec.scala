import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.must.Matchers
import sttp.client3.quick.*
import sttp.model.StatusCode

class GitHubUserSpec extends AnyFeatureSpec with GivenWhenThen with Matchers:

  Feature("GitHub User Profile"):

    info("As a programmer")
    info("I want to check the user profile presence")
    info("So I know if I can create an account with a given name")

    Scenario("GitHub User Exists"):
      Given("a GitHub account exists")
      val username = "kkomorowski"
      When("I send a request to the /user/{username} API endpoint")
      val request = quickRequest.get(uri"https://api.github.com/users/$username")
      val response = simpleHttpClient.send(request)
      Then("I get the response with HTTP status code 200")
      response.code mustBe StatusCode(200)

    Scenario("GitHub User Does Not Exist"):
      Given("a GitHub account does not exist")
      val username = "yx-oyn-qzg-dun2a7"
      When("I send a request to the /user/{username} API endpoint")
      val request = quickRequest.get(uri"https://api.github.com/users/$username")
      val response = simpleHttpClient.send(request)
      Then("I get the response with HTTP status code 404")
      response.code mustBe StatusCode(404)
