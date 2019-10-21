# Project: Cookbook

## Developer: Tanwi Sharma
## Reviewer: Alex Malotky

| Item | Considerations | Comments/Suggestions | 
|------|------------|----------|
| Problem Statement| 1. Accurately describes project purpose2. Is professional and free of typos, slang, etc.3. Fully explains the problem and the solution4. Is understandable by the average person | I like your plan it was easy to understand and follow.
| Design Documentation | 1. Navigation/flow through the application is logical and easy to use.2. The order in which values are displayed are logical and easy to understand/use3. The order in which the form fields entered are logical and easy to understand/use4. All data discussed/documented (problem statement, flow, db design, etc.) is represented on the screens | Your design documents looked like you have a good idea of what you want everything to look like and are easy to make out.
| Data model/Database | 1. Everything on the screens and problem statement/flow is represented in the model2. There is at least one 1-to-many relationship.3. The model represents good database design | Your proposed database sounds like it has two many to many relationships which go above and beyond what is called for.
| Code | 1. Proper Maven project structure is used2. a .gitignore file for IntelliJ Java projects has been implemented3. There is not any redundant or copy/paste code in the JSPs or classes4. Classes are appropriately-sized (no monster classes)Property files are used appropriately: no hard-coded values5. Logging statements are used rather than System.out.println and printStackTrace.6. There are appropriate unit tests/code coverages. | It doesn't look like you have much code yet. I know you have a many to many in your database and I have included the precursor to the many to many below.

```java
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="favorites",
                joinColumns =        {@JoinColumn(name="user_id", nullable = false, updatable = false)},
                inverseJoinColumns = {@JoinColumn(name="recipe_id", nullable = false, updatable = false)})
    private Set<Recipe> favorites = new HashSet<>();
``` 

joinColumn should point to the column that reference the object and the inverseJoinColumns should point to the reference
to what goes in the list.  I accidentally had them flipped and it caused some problems.

Additional note: my join table had to have a separate primary key instead of a combined primary key like we learned in other classes, otherwise hibernate would freak out:
```sql
create table favorites (
    id int primary key auto_increment, -- Needed for hibernate
    recipe_id int not null,
    user_id int not null,
    foreign key (recipe_id) references recipes(id) on delete cascade,
    foreign key (user_id) references users(id) on delete cascade,
    unique(recipe_id, user_id) -- Formerly primary key(recipe_id, user_id)
);
``` 



