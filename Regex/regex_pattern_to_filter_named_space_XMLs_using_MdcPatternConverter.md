```
       /**
     * the pattern in this method accounts for namespace prefixes e.g. <ns2:Surname>JOE</ns2:Surname>
     */
    private String maskMessage(String message, List<String> attributeList)
    {
        String messageLocal = message;

        for (String attributeName : attributeList)
        {
            String s = "(?mix)" + attributeName + ">" +
                    ".*?" +
                    "<\\/" +
                    ".*?" +
                    attributeName;

            final Pattern pattern = Pattern.compile(s);
            final Matcher matcher = pattern.matcher(messageLocal);

            while (matcher.find())
            {
                try
                {
                    String repacingString = attributeName + ">XXXXXXXX</" + attributeName;
                    messageLocal = matcher.replaceAll(repacingString);
                }
                catch (Exception e)
                {
                    // e.printStackTrace();
                }
            }
        }
        return messageLocal;
    }
```
