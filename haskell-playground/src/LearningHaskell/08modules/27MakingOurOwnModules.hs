-- We've looked at some cool modules so far, 
-- but how do we make our own module? 
-- Almost every programming language enables you to 
-- split your code up into several files and Haskell is no different.
-- When making programs, it's good practice to take functions and types 
-- that work towards a similar purpose and put them in a module.
-- That way, you can easily reuse those functions 
-- in other programs by just importing your module.

-- Let's see how we can make our own modules 
-- by making a little module that provides some functions 
-- for calculating the volume and area of a few geometrical objects.
-- We'll start by creating a file called Geometry.hs.

-- We say that a module exports functions.
-- What that means is that when I import a module,
-- I can use the functions that it exports.
-- It can define functions that its functions call internally,
-- but we can only see and use the ones that it exports.

-- At the beginning of a module, we specify the module name.
-- If we have a file called Geometry.hs, then we should name our module Geometry.
-- Then, we specify the functions that it exports and after that,
-- we can start writing the functions.

-- Pretty standard geometry right here.
-- There are a few things to take note of though.
-- Because a cube is only a special case of a cuboid,
-- we defined its area and volume by treating it as a cuboid 
-- whose sides are all of the same length.
-- We also defined a helper function called rectangleArea,
-- which calculates a rectangle's area based on the lenghts of its sides.
-- It's rather trivial because it's just multiplication.
-- Notice that we used it in our functions in the module 
-- (namely cuboidArea and cuboidVolume) but we didn't export it! 
-- Because we want our module to just present functions 
-- for dealing with three dimensional objects,
-- we used rectangleArea but we didn't export it.

-- When making a module, we usually export only those functions 
-- that act as a sort of interface to our module 
-- so that the implementation is hidden. 
-- If someone is using our Geometry module,
-- they don't have to concern themselves with functions that we don't export.
-- We can decide to change those functions completely 
-- or delete them in a newer version 
-- (we could delete rectangleArea and just use * instead) 
-- and no one will mind because we weren't exporting them in the first place.

-- To use our module, we just do:

import Geometry  

-- Geometry.hs has to be in the same folder 
-- that the program that's importing it is in, though.

-- Modules can also be given a hierarchical structures.
-- Each module can have a number of sub-modules 
-- and they can have sub-modules of their own.
-- Let's section these functions off so that Geometry is a module 
-- that has three sub-modules, one for each type of object.

-- First, we'll make a folder called Geometry.
-- Mind the capital G.
-- In it, we'll place three files: Sphere.hs, Cuboid.hs, and Cube.hs.

-- Alright! So first is Geometry.Sphere. 
-- Notice how we placed it in a folder called Geometry 
-- and then defined the module name as Geometry.Sphere.
-- We did the same for the cuboid.
-- Also notice how in all three sub-modules,
-- we defined functions with the same names.
-- We can do this because they're separate modules.
-- We want to use functions from Geometry.Cuboid in Geometry.Cube 
-- but we can't just straight up do import Geometry.Cuboid 
-- because it exports functions with the same names as Geometry.Cube.
-- That's why we do a qualified import and all is well.

-- So now if we're in a file that's on the same level as the Geometry folder, we can do, say:

import Geometry.Sphere  

-- And then we can call area and volume 
-- and they'll give us the area and volume for a sphere.
-- And if we want to juggle two or more of these modules,
-- we have to do qualified imports 
-- because they export functions with the same names.
-- So we just do something like:

import qualified Geometry.Sphere as Sphere  
import qualified Geometry.Cuboid as Cuboid  
import qualified Geometry.Cube as Cube 

-- And then we can call Sphere.area, Sphere.volume, Cuboid.area, etc.
-- and each will calculate the area or volume for their corresponding object.

-- The next time you find yourself writing a file 
-- that is really big and has a lot of functions,
-- try to see which functions serve some common purpose 
-- and then see if you can put them in their own module.
-- You'll be able to just import your module 
-- the next time you're writing a program 
-- that requires some of the same functionality.
