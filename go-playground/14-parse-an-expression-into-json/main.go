package main

func main() {



}

func TransformExpression(exp string) (interface{}, error) {
  tokens, err := GetTokensFromExpression(exp)
  if err != nil {
    return nil, err
  }
  transformedExp, err := CreateJSONTreeFromTokens(tokens)
  if err != nil {
    return nil, err
  }
  return transformedExp, nil
}

func GetTokensFromExpression(exp string) ([]string, error) {
  expression = strings.ToUpper(exp)

  // Special cases
  exceptions := []string{"ALWAYS","TRUE", "FALSE", "NO"}
  if slices.Contains(exceptions, expression) {
    if expression == "TRUE" || expression == "ALWAYS" {
      return []string{"true"}, nil
    }
    // else, similarly handle other cases
  }

  tokensFromComplexExpressions, err := GetTokensFromComplexExpressions(expression)
  if err != nil {
    return nil, err
  }
  if tokensFromComplexExpressions == nil || len(tokensFromComplexExpressions) == 0 {
    return nil, errors.New("invalid expression")
  }
  return tokensFromComplexExpressions, nil
}

func GetTokensFromComplexExpressions(expression string) ([]string, error) {

  rules := []struct {
    pattern *regexp.Regexp
    action func(string) string
  }{
    {
      pattern: regexp.MustCompile(`(?m)^[(][\w\-\#\+]{5}[{1})]`),
      action: func(token string) string {
	return token[1 : len(token) - 1]
      }
    },
    {
      // same as the previous - but without the square brackets
      pattern: regexp.MustCompile(`(?m)^[\w\-\#\+]{5}`),
      action: func(token string) string {
	return token
      }
    },
    {
      pattern: regexp.MustCompile(`(?m)^!+`),
      action: func(token string) string {
	return "!"
      }
    },
    {
      pattern: regexp.MustCompile(`(?m)^&+`),
      action: func(token string) string {
	return "&"
      }
    },
    {
      pattern: regexp.MustCompile(`(?m)^[|]+`),
      action: func(token string) string {
	return "|"
      }
    },
    {
      pattern: regexp.MustCompile(`(?m)^\(`),
      action: func(token string) string {
	return "("
      }
    },
    {
      pattern: regexp.MustCompile(`(?m)^\)`),
      action: func(token string) string {
	return ")"
      }
    },
    {
      pattern: regexp.MustCompile(`(?m)^\s+`),
      action: func(token string) string {
	return ""
      }
    }

    var results []string
    var remainder = expression

    for len(remainder) > 0 {
       matched := false
       for _, rule := range rules {
	 if rule.pattern.MatchString(remainder) {
	   match := rule.pattern.FindString(remainder)
	   remainder := strings.TrimPrefix(remainder, match)
	   if actionResult := rule.action(match); len(actionResult) > 0 {
	     results = append(results, actionResult)
	   }
	   matched = true
	   break
	 }
       }
       if !matched {
	 return nil, errors.New("error processing expression - incomplete expression found")
	 break
       }
    }
    return results, nil
  }
}