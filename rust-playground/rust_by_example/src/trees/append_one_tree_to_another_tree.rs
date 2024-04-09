use crate::trees::tree::{BinaryTree, Node};

#[allow(dead_code)]
fn append_tree2_to_the_rightmost_leaf_of_tree1<T: std::cmp::PartialEq>(
    optional_tree_1: Option<Box<BinaryTree<T>>>,
    optional_tree_2: Option<Box<BinaryTree<T>>>) -> Option<Box<BinaryTree<T>>> {
    match optional_tree_2 {
        None => optional_tree_1,
        Some(tree_2) => {

            match optional_tree_1 {
                None => { Some(tree_2) }
                Some(tree_1) => {
                    match *tree_1 {

                        // root-element only tree
                        BinaryTree {
                            tree_root: Some(Node {
                                                node_root: Some(nr),
                                                left: None,
                                                right: None
                                            })
                        } => {
                            Some(Box::new(BinaryTree {
                                tree_root: Some(Node {
                                    node_root: Some(nr),
                                    left: None,
                                    right: Option::from(tree_2),
                                })
                            }))
                        }

                        // left-only tree
                        BinaryTree {
                            tree_root: Some(Node {
                                                node_root: Some(nr),
                                                left: Some(l),
                                                right: None
                                            })
                        } => {
                            Some(Box::new(BinaryTree {
                                tree_root: Some(Node {
                                    node_root: Some(nr),
                                    left: Some(l),
                                    right: Option::from(tree_2),
                                })
                            }))
                        }

                        // right-only tree
                        BinaryTree {
                            tree_root: Some(Node {
                                                node_root: Some(nr),
                                                left: None,
                                                right: Some(r)
                                            })
                        } => {
                            Some(Box::new(BinaryTree {
                                tree_root: Some(Node {
                                    node_root: Some(nr),
                                    left: None,
                                    right: append_tree2_to_the_rightmost_leaf_of_tree1(Option::from(r), Option::from(tree_2)),
                                })
                            }))
                        }

                        // left and right tree
                        BinaryTree {
                            tree_root: Some(Node {
                                                node_root: Some(nr),
                                                left: Some(l),
                                                right: Some(r)
                                            })
                        } => {
                            Some(Box::new(BinaryTree {
                                tree_root: Some(Node {
                                    node_root: Some(nr),
                                    left: Some(l),
                                    right: append_tree2_to_the_rightmost_leaf_of_tree1(Option::from(r), Option::from(tree_2)),
                                })
                            }))
                        }

                        // these patterns are not possible - adding them just to satisfy pattern matching
                        _ => {
                            None
                        }
                    }
                }
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use crate::trees::append_one_tree_to_another_tree::append_tree2_to_the_rightmost_leaf_of_tree1;
    use crate::trees::tree::{BinaryTree, Node};

    #[test]
    fn testing_append_tree2_to_the_rightmost_leaf_of_tree1_for_two_empty_trees() {
        let empty_tree1: BinaryTree<i32> = BinaryTree {
            tree_root: None
        };
        let empty_tree2: BinaryTree<i32> = BinaryTree {
            tree_root: None
        };

        let actual = append_tree2_to_the_rightmost_leaf_of_tree1(
            Some(Box::new(empty_tree1)),
            Some(Box::new(empty_tree2)));
        let expected = None;
        assert_eq!(actual, expected);
    }

    #[test]
    fn testing_append_tree2_to_the_rightmost_leaf_of_tree1_for_two_non_empty_trees_1() {
        let tree1: BinaryTree<i32> = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(6i32),
                left: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(7i32),
                        left: None,
                        right: None,
                    })
                })),
                right: None,
            })
        };
        let tree2: BinaryTree<i32> = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(8i32),
                left: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(9i32),
                        left: None,
                        right: None,
                    })
                })),
                right: None,
            })
        };

        let actual = append_tree2_to_the_rightmost_leaf_of_tree1(
            Some(Box::new(tree1)),
            Some(Box::new(tree2)));
        let expected = Some(Box::new(BinaryTree {
            tree_root: Some(Node {
                node_root: Some(6i32),
                left: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(7i32),
                        left: None,
                        right: None,
                    })
                })),
                right: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(8i32),
                        left: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(9i32),
                                left: None,
                                right: None,
                            })
                        })),
                        right: None,
                    })
                })),
            })
        }));
        assert_eq!(actual, expected);
    }

    #[test]
    fn testing_append_tree2_to_the_rightmost_leaf_of_tree1_for_two_non_empty_trees_2() {
        let tree1: BinaryTree<i32> = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(1i32),
                left: None,
                right: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(2i32),
                        left: None,
                        right: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(5i32),
                                left: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(7i32),
                                        left: None,
                                        right: None,
                                    })
                                })),
                                right: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(6i32),
                                        left: None,
                                        right: None,
                                    })
                                })),
                            })
                        }))
                    })
                })),
            })
        };
        let tree2: BinaryTree<i32> = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(3i32),
                left: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(4i32),
                        left: None,
                        right: None,
                    })
                })),
                right: None,
            })
        };

        let actual = append_tree2_to_the_rightmost_leaf_of_tree1(
            Some(Box::new(tree1)),
            Some(Box::new(tree2)));
        let expected = Some(Box::new(BinaryTree {
            tree_root: Some(Node {
                node_root: Some(1i32),
                left: None,
                right: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(2i32),
                        left: None,
                        right: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(5i32),
                                left: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(7i32),
                                        left: None,
                                        right: None,
                                    })
                                })),
                                right: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(6i32),
                                        left: None,
                                        right: Some(Box::new(BinaryTree {
                                            tree_root: Some(Node {
                                                node_root: Some(3i32),
                                                left: Some(Box::new(BinaryTree {
                                                    tree_root: Some(Node {
                                                        node_root: Some(4i32),
                                                        left: None,
                                                        right: None,
                                                    })
                                                })),
                                                right: None,
                                            })
                                        }))

                                    })
                                })),
                            })
                        }))
                    })
                })),
            })
        }));
        assert_eq!(actual, expected);
    }

    // TODO add tests to include empty tree on one side and non-empty tree on the other side
}