{- |
    Source: https://www.haskelltutorials.com/without-theory/lambdas.html

    Pagination

    Write the core logic for displaying page-numbers at the bottom of a typical list-view in any web-app. The entire list is divided into p pages of r items each.
    
    -- Note the use of type-synonyms to clearly indicate what each `Int`
    -- in the function signature actually _means_
    
    type ItemsPerPage = Int
    type TotalItems = Int
    type CurrentPage = Int
    displayPagination :: TotalItems -> ItemsPerPage -> CurrentPage -> String

    Usually, when the total page-count is less than 8 all the page-numbers are shown at the bottom of the list, as such (* next to a page number denotes that the user is currently on that page):
    
    displayPagination 55 10 4
    
    -- OUTPUT:
    -- < Prev | 1 | 2 | 3 | 4* | 5 | Next >

    However, when the total page-count is equal-to/higher-than 8, then all the page numbers are not shown (it would make the pagination too long). 
    The current page is kept towards the “center” and 3 numbers on either side are shown, as demonstrated below:
    
    displayPagination 545 10 16
    
    -- OUTPUT:
    -- <Prev | ... | 13 | 14 | 15 | 16* | 17 | 18 | 19 | ... | Next>

    However, there is an edge-case when we don’t have enough page numbers to display on either the left, or right, side of the “center” page. Examples:
    
    displayPagination 545 10 3
    
    -- OUTPUT:
    -- < Prev | 1 | 2 | 3* | 4 | 5 | 6 | 7 | ... | Next >
    
    displayPagination 545 10 53
    
    -- OUTPUT:
    -- < Prev | ... | 49 | 50 | 51 | 52 | 53* | 54 | 55 | Next >

    Follow-up: The total number of pages to be display was “hard-coded” (i.e. pre-decided) in the problem given above. 
    Modify your function to additionally take the total number of pages to display, as well. Example:
    
    type ItemsPerPage = Int
    type TotalItems = Int
    type CurrentPage = Int
    type NumOfPagesToDisplay = Int
    displayPagination :: NumOfPagesToDisplay -> TotalItems -> ItemsPerPage -> CurrentPage -> String
    
    displayPagination 13 321 10 3
    --
    -- OUTPUT:
    -- <Prev | 1 | 2 | 3* | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | ... | Next>
    
    
    displayPagination 13 321 10 15
    --
    -- OUTPUT:
    -- <Prev | ... | 9 | 10 | 11 | 12 | 13 | 14 | 15* | 16 | 17 | 18 | 19 | 20 | 21 | ... | Next>

    Another follow-up: Have you handled the case where NumOfPagesToDisplay is an even number?
-}
