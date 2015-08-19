package ohnosequencesbundles.statika

import ohnosequences.statika._, bundles._, instructions._
import java.io.File


abstract class Express (val version: String) extends Bundle() {

  val usrbin = "/usr/bin/"

  def install: Results = {
    Seq("wget", s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/express/${version}/express-${version}-linux_x86_64.tgz") ->-
    Seq("tar", "-xvf", s"express-${version}-linux_x86_64.tgz") ->-
    Seq("cp", new File(s"express-${version}-linux_x86_64/express").getAbsolutePath, usrbin) ->-
    success(s"${bundleName} is installed")
  }

}
