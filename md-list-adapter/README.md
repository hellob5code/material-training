# Read Me

## Available Item Types



## How to Add a New Item Type

1. Define the item's layout. Reuse existing view IDs when applicable; such IDs are :
    `text1`, `text2`, `text3`,
    `icon`,
    `avatar`,
    `checkbox`
2. Create a new item class in file `ItemClasses.kt`. This class will be the object adapted by the `MaterialListAdapter` and must inherit from `MaterialListItem` or one of its subclass. You can compose
`TraitInterfaces` to add attributes to your class.
3. Create a new holder class in file `HolderClasses.kt`. This class will be used to bind and unbind the item object to its views, including actions to perform on user interaction. I must inherit from
`RecyclerView.ViewHolder` and implement `Bindable<MaterialListItem>. The binding of each of the item's trait is defined inside a stub class.
4. Edit the `MaterialListAdapter` to link the layout and the viewholder.