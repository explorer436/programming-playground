use crate::trees::tree::BinaryTree;

#[allow(dead_code)]
fn evaluate(optional_tree: Option<Box<BinaryTree<i32>>>) -> Vec<i32> {
    let mut vector_of_trees= Vec::new();
    vector_of_trees.push(optional_tree);
    breadth_level_sums(vector_of_trees)
}

fn breadth_level_sums(vector_of_trees: Vec<Option<Box<BinaryTree<i32>>>>) -> Vec<i32> {
    let mut root_elements_sum_vector: Vec<i32> = Vec::new();
    let mut root_sum = 0;

    for ele in vector_of_trees {

        let mut child_trees = Vec::new();

        let r = match ele {
            None => 0,
            Some(root) => {
                // optional_node<Option<&Node<T>>> = BinaryTree::root_element(v);

                /* let mut child_trees = Vec::new();
                let l_and_r = BinaryTree::left_and_right_trees(*root);
                child_trees.append(&mut l_and_r);
                breadth_level_sums(child_trees);*/


                let abc = match BinaryTree::root_element(&root) {
                    None => 0,
                    Some(node) => {
                        node.node_root.unwrap_or_else(|| 0)
                    }
                };

                let mut l_and_r = BinaryTree::left_and_right_trees(&root);
                child_trees.append(l_and_r);
                breadth_level_sums(child_trees);

                abc
            }
        };
        root_sum = root_sum + r;

    }

    /*for v in vector_of_trees.iter() {

        let r = match *v {
            None => 0,
            Some(root) => {
                // optional_node<Option<&Node<T>>> = BinaryTree::root_element(v);

                /* let mut child_trees = Vec::new();
                let l_and_r = BinaryTree::left_and_right_trees(*root);
                child_trees.append(&mut l_and_r);
                breadth_level_sums(child_trees);*/

                match BinaryTree::root_element(&root) {
                    None => 0,
                    Some(node) => {
                        node.node_root.unwrap_or_else(|| 0)
                    }
                }
            }
        };
        root_sum = root_sum + r;


        let mut child_trees = Vec::new();
        match *v {
            None => (),
            Some(root) => {
                let mut l_and_r = BinaryTree::left_and_right_trees(*root);
                child_trees.append(&mut l_and_r);
            },
        }
        breadth_level_sums(child_trees);
    }*/
    // push sum of root elements of all trees in the input vector
    root_elements_sum_vector.push(root_sum);

    // return
    root_elements_sum_vector
}

#[cfg(test)]
mod tests {
    use crate::trees::sums_by_each_level::evaluate;
    use crate::trees::tree::{BinaryTree, Node};

    #[test]
    fn testing_1() {
        let tree1: BinaryTree<i32> = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(1i32),
                left: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(2i32),
                        left: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(4i32),
                                left: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(8i32),
                                        left: None,
                                        right: None,
                                    }),
                                })),
                                right: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(9i32),
                                        left: None,
                                        right: None,
                                    }),
                                })),
                            }),
                        })),
                        right: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(5i32),
                                left: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(10i32),
                                        left: None,
                                        right: None,
                                    }),
                                })),
                                right: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(11i32),
                                        left: None,
                                        right: None,
                                    }),
                                })),
                            }),
                        })),
                    }),
                })),
                right: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(3i32),
                        left: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(6i32),
                                left: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(12i32),
                                        left: None,
                                        right: None,
                                    }),
                                })),
                                right: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(13i32),
                                        left: None,
                                        right: None,
                                    }),
                                })),
                            }),
                        })),
                        right: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(7i32),
                                left: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(14i32),
                                        left: None,
                                        right: None,
                                    }),
                                })),
                                right: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(15i32),
                                        left: None,
                                        right: None,
                                    }),
                                })),
                            }),
                        })),
                    }),
                })),
            }),
        };

        let actual: Vec<i32> = evaluate(Some(Box::new(tree1)));

        let mut expected: Vec<i32> = Vec::new();
        expected.push(1);
        expected.push(5);
        expected.push(22);
        expected.push(92);

        assert_eq!(actual, expected);
    }
}
