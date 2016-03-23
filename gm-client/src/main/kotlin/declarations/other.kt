package declarations

import jquery.JQuery
import org.w3c.dom.Element

@native("$")
val j: dynamic = noImpl

@native
fun JQuery.append(element: Element): JQuery = noImpl

@native
fun alert(a: Any) {}


