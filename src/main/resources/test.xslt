<!-- "Flatten" an XML so that nested elements become attributes -->
<!-- Kevin Boone, June 2022 -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
  <xsl:strip-space elements="*"/>

  <xsl:template match="*">
    <xsl:element name="{local-name()}"> <!-- Original element name in output -->
	<xsl:for-each select="*"> <!-- Iterate all nodes at this level -->
	<!-- If there are no sub-child elements of this child element, 
             absorb the element text as an attribute -->
	  <xsl:if test="not(*)">           
	    <xsl:attribute name="{name()}">
	      <xsl:value-of select="text()"/>
	    </xsl:attribute>
	  </xsl:if>
	</xsl:for-each>
	<!-- But if there are sub-child elements (that's what matching *[*] 
             tests) descend into each one and process it -->
      <xsl:apply-templates select="*[*]"/>
    </xsl:element>
  </xsl:template>

</xsl:stylesheet>


