# How to manually delete a cluster in case the pipelines do not work?

1. Find the target cluster to delete -> Go to Tasks tab -> Hit Stop All button
1. Go back to Services tab -> Click on the service -> Hit Delete button
1. Go to ALB page under EC2 service -> Find target ALB you want to delete -> Go to its Listeners tab -> Go into the listeners list and find target groups associated with that listener (default and current ones if applicable) -> Find those target groups in the Target Groups view
1. Go back to ALB Listeners tab -> Delete that listener
1. Go to the Target Groups view -> Delete those target group(s). Make sure you search for all the target groups for that stack. Look for prefix (search by the name of your application) to identify the target groups belonged to that stack
1. Go to the Auto Scaling Groups view -> Delete the auto scaling group(s)
1. Go to the Launch Configuration view -> Delete the launch configuration(s)
1. Go to the Load Balancer view -> Delete the target load balancer (you will need to edit the ALB attribute, and disable the Delete Protection option)
1. Go to the Target Groups view -> Look for any target group associated with that stack.
1. Go to the ECS view -> Delete the target cluster
1. Done


# How to find out what the current active environment is?

  We have to use Route53.
