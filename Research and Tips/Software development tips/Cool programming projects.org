What are some cool programming projects?

Ben Podgursky · May 19 Former Senior Data Engineer, Data Infrastructure lead at LiveRamp (2011–2019)

OpenWorm is an open-source initiative, attempting to simulate… a worm!

This picture doesn’t really do the OpenWorm justice though. The project isn’t attempting to simulate what a worm looks like, or how it moves — OpenWorm is building a worm from the ground up, cell by cell, neuron by neuron:

    OpenWorm is an open source project and open science community dedicated to creating the world's first whole organism in a computer, a C. elegans nematode, via bottom-up "systems biology" computational modeling.

The project chose C elegans as a target, because C Elegans is one of the simplest known organisms with a nervous system. The worm has precisely 302 neurons

, and their connections have been exhaustively mapped out (as opposed to humans, who have an average of 86 billion neurons).

This simplicity makes the worm “easy” to simulate, compared to other organisms with nervous systems (read: still beyond our current simulation capacity). The goal of the OpenWorm project is to program the primitives which make this nematode tick, and use those primitives to study the emergent behavior which arises.

I’m not a biologist, so I can’t speak to the feasibility of the project — I don’t know whether they’ve gotten 2% or 20% to a fully “alive” worm. But the idea is cool — whereas AI traditionally tries to build an artificial intelligence from the ground up*, OpenWorm tries to simulate life by recreating the basics from the ground up.

Plus, the fact that we’re still a ways away from simulating a worm, is reassuring — it means the rest of us are safe from being replaced by AI simulations… for now.

*admittedly, neural networks and deep learning have inverted this structure, and cutting-edge AI now primarily uses black-boxes of quasi-neurons to learn patterns
