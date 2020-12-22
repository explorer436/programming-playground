{-# OPTIONS_GHC -F -pgmF hspec-discover #-}

{- |

    https://hspec.github.io/hspec-discover.html
    
    Now if we want to run all specs in the test folder in one go we have to write the boilerplate. This is error prone, and neither challenging nor interesting. So it should be automated. Hspec provides a solution for that. We make creative use of GHC's support for custom preprocessors. The developer only has to create a test driver that contains a single line:
    
    -- file test/Spec.hs
    {-# OPTIONS_GHC -F -pgmF hspec-discover #-}
    
    This instructs GHC to invoke hspec-discover as a preprocessor on the source file. The rest of the source file is empty, so there is nothing to preprocess. Rather than preprocessing, hspec-discover scans the file system for all spec files belonging to a project and generates the required boilerplate. hspec-discover does not parse any source files, it instead relies on the following conventions:
    
        Spec files have to be placed into the same directory as the test driver, or into a subdirectory.
        The name of a spec file has to end in Spec.hs; the module name has to match the file name.
        Each spec file has to export a top-level binding spec of type Spec.
-}
