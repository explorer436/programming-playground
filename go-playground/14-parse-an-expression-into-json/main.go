package main

import (
	"encoding/json"
	"errors"
	"log"
	"regexp"
	"slices"
	"strings"
	"unicode"
)

func main() {
	tests := []struct {
		input    string
		expected string
	}{
		{"abcde", "\"ABCDE\""},
		{"abc--&def--", "{\"and\":[\"ABC--\",\"DEF--\"]}"},
	}

	for _, test := range tests {
		actual, _ := TransformExpression(test.input)

		actualBytes, _ := json.Marshal(actual)
		actualStr := string(actualBytes)

		if actualStr != test.expected {
			log.Fatalf("TransformExpression(%s) = %s; expected %s", test.input, actualStr, test.expected)
		}
	}

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

func CreateJSONTreeFromTokens(tokens []string) (interface{}, error) {

	jsonTree := make(map[string][]interface{})
	var lastCondition interface{}
	var lastOperator string
	var secondToLastOperator string
	operatorDict := map[string]string{"&": "and", "|": "or", "!": "not"}
	i := 0

	if len(tokens) == 1 {
		return tokens[0], nil
	}

	// Iterate through the tokens and generate a json tree
	for i < len(tokens) {
		token := tokens[i]

		if isValidCode(token) {
			lastCondition = token
			if lastOperator == "not" && secondToLastOperator != "" {
				notDict := map[string]interface{}{lastOperator: lastCondition}
				jsonTree[secondToLastOperator] = append(jsonTree[secondToLastOperator], notDict)
			}
		} else if _, ok := operatorDict[token]; ok {
			// Check if token is in operatorDict
			// Save the operators in case there are multiple operators in a row
			secondToLastOperator = lastOperator
			lastOperator = operatorDict[token]
			if lastCondition != nil && secondToLastOperator != "not" {
				// Append the current code to the corresponding operator list
				jsonTree[lastOperator] = append(jsonTree[lastOperator], lastCondition)
				// Reset lastCondition since its already been processed
				lastCondition = nil
			}
		} else if token == "(" {
			// Find the index of the last ending paranthesis
			endingParanthesisIndex := findLastParanthesisIndex(tokens, i)
			if endingParanthesisIndex == -1 {
				return nil, errors.New("error processing expression - missing or misplaced parantheses")
			}
			// Get the tokens between the paranthesis
			tokensBetweenParanthesis := tokens[i+1 : endingParanthesisIndex]
			// Recursively call CreateJSONTreeFromTokens to process the tokens between the paranthesis
			treeBetweenParanthesis, _ := CreateJSONTreeFromTokens(tokensBetweenParanthesis)
			if lastOperator == "not" {
				if secondToLastOperator != "" {
					// Handle the case where there are multiple operators in a row
					notDict := map[string]interface{}{lastOperator: treeBetweenParanthesis}
					jsonTree[secondToLastOperator] = append(jsonTree[secondToLastOperator], notDict)
				} else {
					jsonTree[lastOperator] = []interface{}{treeBetweenParanthesis}
				}
			} else if lastOperator != "" {
				// Check if lastOperator is not empty
				jsonTree[lastOperator] = append(jsonTree[lastOperator], treeBetweenParanthesis)
			} else {
				lastCondition = treeBetweenParanthesis
			}

			// Set the index to the ending paranthesis index to skip the tokens between the paranthesis
			i = endingParanthesisIndex
		}
		i++
	}

	// Handle the last condition if it hasn't been processed (i.e., no operator follows it)
	if lastCondition != nil && lastOperator != "" {
		jsonTree[lastOperator] = append(jsonTree[lastOperator], lastCondition)
	}

	return jsonTree, nil
}

func isValidCode(token string) bool {
	if len(token) != 5 {
		return false
	}
	for _, char := range token {
		if !unicode.IsLetter(char) && !unicode.IsDigit(char) && char != '-' && char != '#' {
			return false
		}
	}
	return true
}

func findLastParanthesisIndex(tokens []string, firstParanthesisIndex int) int {
	count := 0

	for i := firstParanthesisIndex; i < len(tokens); i++ {
		if tokens[i] == "(" {
			count++
		} else if tokens[i] == ")" {
			count--
			if count == 0 {
				return i
			}
		}
	}
	// If the closing parenthesis is not found
	return -1
}

func GetTokensFromExpression(exp string) ([]string, error) {
	expression := strings.ToUpper(exp)

	// Special cases
	exceptions := []string{"ALWAYS", "TRUE", "FALSE", "NO"}
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
		action  func(string) string
	}{
		{
			pattern: regexp.MustCompile(`(?m)^[(][\w\-\#\+]{5}[{1})]`),
			action: func(token string) string {
				return token[1 : len(token)-1]
			},
		},
		{
			// same as the previous - but without the square brackets
			pattern: regexp.MustCompile(`(?m)^[\w\-\#\+]{5}`),
			action: func(token string) string {
				return token
			},
		},
		{
			pattern: regexp.MustCompile(`(?m)^!+`),
			action: func(token string) string {
				return "!"
			},
		},
		{
			pattern: regexp.MustCompile(`(?m)^&+`),
			action: func(token string) string {
				return "&"
			},
		},
		{
			pattern: regexp.MustCompile(`(?m)^[|]+`),
			action: func(token string) string {
				return "|"
			},
		},
		{
			pattern: regexp.MustCompile(`(?m)^\(`),
			action: func(token string) string {
				return "("
			},
		},
		{
			pattern: regexp.MustCompile(`(?m)^\)`),
			action: func(token string) string {
				return ")"
			},
		},
		{
			pattern: regexp.MustCompile(`(?m)^\s+`),
			action: func(token string) string {
				return ""
			},
		}}

	var results []string
	var remainder = expression

	for len(remainder) > 0 {
		matched := false
		for _, rule := range rules {
			if rule.pattern.MatchString(remainder) {
				match := rule.pattern.FindString(remainder)
				remainder = strings.TrimPrefix(remainder, match)
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
