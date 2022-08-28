### Definition of done
    
Putting a DoD on paper is simple. The difficulty often lies in having the development team actually respect the contract. So what can a team do to ensure that the DoD and acceptance criteria are respected? Start by embedding them in the team’s natural workflow. 

Definitions of done correspond to different parts of the development process: 
technical tasks, 
user stories, and 
bugs. 

##### Good development practises

1. Code changes need to be checked into the version control system
1. Tests (unit and integration) that run as part of the build are created or updated for all new code and code that may have been impacted by changes
1. Delete branches after merging code
1. Data that gets sent back to clients is documented
1. No known critical defects are left in the code
1. Meets Architectural Guidelines
1. Code builds without warnings (technical task)
1. Sonarcube does not introduce any new code smells and Sonarcube build passes
1. Integration test suites are passing

##### Maintaining paperwork

1. Documentation written/updated and details about it are mentioned in the Jira story.
1. Stories satisfy acceptance criteria before being closed.
1. Ticket is updated with any info relevant to the change and any decisions made
1. Feature is pushed to Production
1. Build pushed to demo server and the feature has been signed off by PO (demoed)
1. If Production code gets deployed but the code is not active, follow up story is created
1. Successfully tested in the highest deployed environment (no major or medium level bugs)
