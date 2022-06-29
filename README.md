# camel-flattenxml

This is a simple demonstration of how to use Camel's XLST support to
"flatten" an XML file, so that embedded tags become attributes of their
parents. That is, we turn this:

    <top>
      <item>
	<foo>1</foo>
	<bar>2</bar>
      </item>
      <item>
	<foo>3</foo>
	<bar>4</bar>
      </item>
    </top>

into this:

    <top>    
    <item foo="1" bar="2"/>    
    <item foo="3" bar="4"/>
    </top>

The XSLT transformation is generic in that it doesn't need any knowledge of the
tag names in the incoming XML -- names are preserved.  Any XML with the same
basic structure should capable of conversion. However, it assumes only one
level of "nesting" of tags. If it were _generally_ possible to flatten an XML
file so that nested elements become attributes, there would be no need for XML
to provide both. 

To build and run the sample:

    mvn compile exec:java

and to test:

    cp test.xml in/

The converted XML is written to the console.

Note that the Camel XSLT endpoint assumes that template files are 
relative to the class search path, not the local filesystem.

